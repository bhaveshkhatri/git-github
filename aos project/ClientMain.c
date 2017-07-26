#include <sys/socket.h>
#include <sys/types.h>
#include <arpa/inet.h>
#include <unistd.h>
#include "Utils.h"
#include "pthread.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>


/*  Global constants  */
#define SERVER_TCP_PORT 5004
#define SERVER_HOST_ADDR "127.0.0.1"
#define MAX_LINE 500
#define MAX_CONTENT 10000
#define EMAIL_CONTENT 4000
#define ATTACH_CONTENT 5000
#define SMALL_STRING 50
#define MAX_STRING 250


char client_message[MAX_LINE];
char message[256] ;
int  sockfd;
int isLogin;
int serviceInput;
char currentUserName[SMALL_STRING];
char currentUserFName[SMALL_STRING];
char currentUserLName[SMALL_STRING];
int isQuit=0;
int isReadingEmailRequest = 0;
int isFinishFetchingEmail = 1;

int foundEmail= 0;

struct email_struct
{
    int val;
    char* myEmailContent;
    struct email_struct *next;
};

struct email_struct *head = NULL;
struct email_struct *curr = NULL;

struct email_struct *localhead = NULL;
struct email_struct *localcurr = NULL;

pthread_cond_t readEmailCondition = PTHREAD_COND_INITIALIZER;
pthread_mutex_t readEmailMutex= PTHREAD_MUTEX_INITIALIZER;
pthread_t fetchEmailThread;



struct email_struct* createEmailList(int val, char* _myEmailContent, int isLocal)
{
    //printf("\n creating list with headnode as [%d]\n", val);
    struct email_struct *ptr = (struct email_struct*)malloc(sizeof(struct email_struct));
    ptr->myEmailContent = malloc(strlen(_myEmailContent) + 1);
    if (ptr == NULL)
    {
        printf("\n Email struct creation failed \n");
        return NULL;
    }
    ptr->val = val;
    strcpy(ptr->myEmailContent, _myEmailContent);
    ptr->next = NULL;
    /* This is the head of linklist*/
    if (!isLocal)
    {
        head = curr = ptr;
    }
    else
    {
        localhead = localcurr = ptr;
    }
    return ptr;
}

struct email_struct* addEmailtoList(int val, char* _myEmailContent, int isLocal)
{
    if (!isLocal)
    {
        if (head == NULL)
        {
            return (createEmailList(val, _myEmailContent, isLocal));
        }
    }
    else
    {
        if (localhead == NULL)
        {
            return (createEmailList(val, _myEmailContent, isLocal));
        }
    }
    
    struct email_struct *ptr = (struct email_struct*)malloc(sizeof(struct email_struct));
    if (ptr == NULL)
    {
        printf("\n Email struct creation failed \n");
        return NULL;
    }
    ptr->myEmailContent = malloc(strlen(_myEmailContent) + 1);
    ptr->val = val;
    strcpy(ptr->myEmailContent,_myEmailContent);
    ptr->next = NULL;
    if (!isLocal)
    {
        curr->next = ptr;
        curr = ptr;
    }
    else
    {
        localcurr->next = ptr;
        localcurr = ptr;
    }
    return ptr;
}

struct email_struct* searchEmail(int val, struct email_struct **prev,int isLocal)
{
    struct email_struct *ptr;
    if (!isLocal)
    {
        ptr = head;
    }
    else
    {
        ptr = localhead;
    }
    struct email_struct *tmp = NULL;
    int found = 0;
    
    while (ptr != NULL)
    {
        if (ptr->val == val)
        {
            found = 1;
            break;
        }
        else
        {
            tmp = ptr;
            ptr = ptr->next;
        }
    }
    
    if (found == 1)
    {
        if (prev)
            *prev = tmp;
        return ptr;
    }
    else
    {
        return NULL;
    }
}

int deleteEmailfromList(int val, int isLocal)
{
    struct email_struct *prev = NULL;
    struct email_struct *del = NULL;
    
    printf("\n Deleting value [%d] from list\n", val);
    if (!isLocal)
    {
        del = searchEmail(val, &prev,0);
    }
    else
    {
        del = searchEmail(val, &prev, 1);
    }
    
    if (del == NULL)
    {
        return -1;
    }
    else
    {
        if (prev != NULL)
            prev->next = del->next;
        if (!isLocal)
        {
            if (del == curr)
            {
                curr = prev;
            }
            else if (del == head)
            {
                head = del->next;
            }
        }
        else
        {
            if (del == localcurr)
            {
                localcurr = prev;
            }
            else if (del == localhead)
            {
                localhead = del->next;
            }
        }
    }
    
    free(del);
    del = NULL;
    
    return 0;
}

void print_filter_list(int option, char query[])
{
    foundEmail = 0;
    struct email_struct *ptr = localhead;;
    char status[SMALL_STRING];
    char subject[SMALL_STRING];
    char from[SMALL_STRING];
    char senderEMail[SMALL_STRING];
    char sendTime[SMALL_STRING];
    
    printf("\n -------Start------- \n");
    while (ptr != NULL)
    {
        sscanf(ptr->myEmailContent,
               "%s\nFrom: %[^\n]\nSender Email: %s\nDate: %[^\n]\nSubject: %[^\n]"
               ,status,from,senderEMail,sendTime,subject);
        if(option == 1)
        {
            if(strcmp(status,query) == 0)
            {
                foundEmail +=1;
                printf("[%d]:%s From: %s - Email: %s - Subject: %s - Time: %s\n",
                       ptr->val,status,from,senderEMail,subject,sendTime);
            }
        }
        else if(option == 2)
        {
            if(strcmp(from,query) == 0)
            {
                foundEmail +=1;
                printf("[%d]:%s From: %s - Email: %s - Subject: %s - Time: %s\n",
                       ptr->val,status,from,senderEMail,subject,sendTime);
            }
        }
        else if(option == 3)
        {
            if(strstr(subject, query) != NULL)
            {
                foundEmail +=1;
                printf("[%d]:%s From: %s - Email: %s - Subject: %s - Time: %s\n",
                       ptr->val,status,from,senderEMail,subject,sendTime);
            }
        }
        
        ptr = ptr->next;
    }
    printf("\n -------End------- \n");
    
    return;
    /*if(strstr(readLine, "~") != NULL)
     {
     strcpy(status,readLine);
     }*/
}


void print_list(int isLocal)
{
    foundEmail = 0;
    struct email_struct *ptr;
    char status[SMALL_STRING];
    char subject[SMALL_STRING];
    char from[SMALL_STRING];
    char senderEMail[SMALL_STRING];
    char sendTime[SMALL_STRING];
    
    if (!isLocal)
    {
        ptr = head;
    }
    else
    {
        ptr = localhead;
    }
    printf("\n -------Start------- \n");
    while (ptr != NULL)
    {
        sscanf(ptr->myEmailContent,
               "%s\nFrom: %[^\n]\nSender Email: %s\nDate: %[^\n]\nSubject: %[^\n]"
               ,status,from,senderEMail,sendTime,subject);
        foundEmail +=1;
        printf("[%d]:%s From: %s - Email: %s - Subject: %s - Time: %s\n",
               ptr->val,status,from,senderEMail,subject,sendTime);
        
        
        ptr = ptr->next;
    }
    printf("\n -------End------- \n");
    
    return;
}

void emptyEmailList(int isLocal)
{
    struct email_struct *tmp = NULL;
    if (!isLocal)
    {
        while (head != NULL)
        {
            tmp = head->next;
            free(head);
            head = tmp;
        }
    }
    else
    {
        while (localhead != NULL)
        {
            tmp = localhead->next;
            free(localhead);
            localhead = tmp;
        }
    }
}


void duplicateEmailList()
{
    emptyEmailList(1);
    struct email_struct *tmp = head;
    while (tmp != NULL)
    {
        struct email_struct *ptr = (struct email_struct*)malloc(sizeof(struct email_struct));
        if (ptr == NULL)
        {
            printf("\n Email struct creation failed \n");
        }
        
        ptr->myEmailContent = malloc(strlen(tmp->myEmailContent));
        ptr->val = tmp->val;
        strcpy(ptr->myEmailContent, tmp->myEmailContent);
        ptr->next = NULL;
        
        if (localhead == NULL)
        {
            localhead = localcurr = ptr;
        }
        else
        {
            localcurr->next = ptr;
            localcurr = ptr;
        }
        tmp = tmp->next;
    }
}

void ChangeLocalEmailStatus(int emailNumber)
{
    struct email_struct *prev = NULL;
    struct email_struct *found = NULL;
    
    found = searchEmail(emailNumber, &prev, 1);
    if (found == NULL)
    {
        printf("Cannot find the email to update\n");
    }
    else
    {
        char line[MAX_LINE];
        char content[MAX_CONTENT];
        char updatedEmail[MAX_CONTENT] = {'\0'};
        sscanf(found->myEmailContent, "%[^'\n']%[^'\0']", line, content);
        strcat(updatedEmail, "~Read");
        strcat(updatedEmail, content);
        strcpy(found->myEmailContent, updatedEmail);
    }
}

void doComposingMail()
{
    char subject[SMALL_STRING];
    char datetime[SMALL_STRING];
    char recipient[SMALL_STRING];
    char tempLine[MAX_LINE];
    char messageContent[MAX_CONTENT]= {'\0'};
    char emailContent[EMAIL_CONTENT] = {'\0'} ;
    char attachment[ATTACH_CONTENT] = {'\0'};
    char attachmail[2] = {'\0'};
    char filepath[MAX_LINE];
    strcat(messageContent,"3:");
    strcat(messageContent,currentUserName);
    printf("Please enter Subject: ");
    scanf("%[^\n]s",subject);
    strcat(messageContent," EmailSubject: ");
    strcat(messageContent,subject);
    strcat(messageContent,"#EmailContent: ");
    getchar();
    printf("Please enter email content below (END to end input):\n");
    fgets (tempLine, MAX_LINE, stdin);
    while(strlen(tempLine)>0)
    {
        if(strcmp(tempLine,"END\n") !=0)
        {
            strcat(emailContent,tempLine);
            fgets (tempLine, MAX_LINE, stdin);
        }
        else
        {
            break;
        }
        
    }
    strcat(messageContent,emailContent);
    printf("Attach File (Y/N): ");
    fgets (attachmail, 2, stdin);
    getchar();
    strcat(messageContent,"#Attachment: ");
    if(strcmp(attachmail,"Y") == 0 || strcmp(attachmail,"y") == 0)
    {
        printf("Please enter file path: ");
        scanf("%[^\n]s",filepath);
        getchar();
        FILE* file;
        if ((file = fopen(filepath, "r")))
        {
            while(fgets(tempLine, MAX_LINE, file) != NULL)
            {
                strcat(attachment,tempLine);
            }
            fclose(file);
            strcat(messageContent,attachment);
        }
        else
        {
            printf("Cannot find %s\n",filepath);
        }
    }
    else
    {
        strcat(messageContent,"NO");
    }
    
    printf("Please enter Recipient: ");
    scanf("%s",recipient);
    strcat(messageContent,"#ToName: ");
    strcat(messageContent,recipient);
    getchar();
    printf("Please enter Date Time (MM/DD/YYYY HH:MM:SS): ");
    scanf("%[^\n]s",datetime);
    getchar();
    strcat(messageContent,"#SendTime: ");
    strcat(messageContent,datetime);
    strcat(messageContent,"#FromName: ");
    strcat(messageContent,currentUserFName);
    strcat(messageContent,", ");
    strcat(messageContent,currentUserLName);
    //strcat(messageContent,"\n");
    printf("%s",messageContent);
    if (send(sockfd,messageContent ,MAX_CONTENT, 0) < 0)
    {
        printf("CLIENT: can't send login request to server\n");
        close(sockfd);
        exit(EXIT_FAILURE);
    }
}


void *doFetchEMail()
{
    while(1)
    {
        while(isReadingEmailRequest)
        {
            pthread_cond_wait(&readEmailCondition, &readEmailMutex);
        }
        isFinishFetchingEmail = 0;
        
        char returnEmail[MAX_CONTENT];
        int isEmailEnd= 0;
        sprintf (client_message, "%d:%s",4, currentUserName);
        if (send(sockfd, client_message,MAX_CONTENT, 0) < 0)
        {
            printf("CLIENT: can't send login request to server\n");
            close(sockfd);
            exit(EXIT_FAILURE);
        }
        int i = 1;
        emptyEmailList(0);
        
        while(!isEmailEnd)
        {
            if (recv(sockfd, returnEmail, MAX_CONTENT, 0) < 0)
            {
                printf("CLIENT: can't receive reply from server\n");
                close(sockfd);
                exit(EXIT_FAILURE);
            }
            if(strcmp(returnEmail,"#EOF") != 0)
            {
                addEmailtoList(i,returnEmail,0);
                i+=1;
            }
            else
            {
                isEmailEnd = 1;
            }
        }
        isFinishFetchingEmail = 1;
        
        pthread_cond_signal(&readEmailCondition);
        sleep(2);
    }
    return NULL;
}

void DisplayEmail()
{
    if(foundEmail > 0)
    {
        struct email_struct *ptr = NULL;
        int mailNumber;
        printf("Please type the number of email that you want to read (-1 to exit): ");
        scanf("%d",&mailNumber);
        getchar();
        if(mailNumber != -1)
        {
            int deleteEmailOption = 0;
            ptr= searchEmail(mailNumber,NULL,1);
            if(ptr!=NULL)
            {
                printf("%s",ptr->myEmailContent);
                
                ChangeLocalEmailStatus(mailNumber);
                while(deleteEmailOption != -1)
                {
                    printf("Type 1 to delete this email (-1 to exit):");
                    scanf("%d",&deleteEmailOption);
                    getchar();
                    if(deleteEmailOption == 1)
                    {
                        int d = deleteEmailfromList(mailNumber,1);
                        if(d<0)
                        {
                            printf("Sorry! We cannot delete the email [%d]\n",mailNumber);
                        }
                        break;
                    }
                }
            }
        }
    }
}

void DoReadEmail()
{
    
    while(!isFinishFetchingEmail)
    {
        printf("Is finished fetching %d\n",isFinishFetchingEmail);
        pthread_cond_wait(&readEmailCondition, &readEmailMutex);
    }
    printf("\nBefore reading email\n");
    isReadingEmailRequest = 1;
    duplicateEmailList();
    print_list(1);
    isReadingEmailRequest = 0;
    printf("\nAfter reading email");
    pthread_cond_signal(&readEmailCondition);
    
    int isInReadingEmailProcess = 1;
    int readingoption;
    while(isInReadingEmailProcess)
    {
        printf("Type 1 to filter email, 2 to read email (-1 to exit): ");
        scanf("%d",&readingoption);
        getchar();
        if(readingoption == -1)
        {
            isInReadingEmailProcess = 0;
        }
        else if(readingoption == 1)
        {
            int filteroption;
            char filerString[SMALL_STRING] = {'\0'};
            printf("Type 1 to filter by reading status, 2 by sender name, 3 by subject (-1 to exit): ");
            scanf("%d",&filteroption);
            getchar();
            if(filteroption == 1)
            {
                printf("Please type ~Un-Read for unread email, ~Read for already read email (NULL to exit): ");
                scanf("%[^\n]s",filerString);
                getchar();
                if(strcmp(filerString,"NULL") != 0)
                {
                    print_filter_list(1,filerString);
                    DisplayEmail();
                }
            }
            else if(filteroption == 2)
            {
                printf("Please type sender name (NULL to exit): ");
                scanf("%[^\n]s",filerString);
                getchar();
                if(strcmp(filerString,"NULL") != 0)
                {
                    print_filter_list(2,filerString);
                    DisplayEmail();
                }
            }
            else if(filteroption == 3)
            {
                printf("Please type interested subject (NULL to exit): ");
                scanf("%[^\n]s",filerString);
                getchar();
                if(strcmp(filerString,"NULL") != 0)
                {
                    print_filter_list(3,filerString);
                    DisplayEmail();
                }
            }
            
        }
        else if(readingoption == 2)
        {
            print_list(1);
            DisplayEmail();
        }
    }
}


void MainScreen()
{
    int currentOption;
    if(pthread_create(&fetchEmailThread, NULL, &doFetchEMail, NULL)!=0)
    {
        printf("Cannot create Player \"x\" thread\n");
        exit(1);
    }
    do
    {
        if(isLogin == 1)
        {
            printf("Type 1 for compose email, 2 for checking email (-1 to quit): ");
            scanf("%d",&currentOption);
            getchar();
            if(currentOption == 1)
            {
                doComposingMail();
            }
            else if(currentOption == 2)
            {
                DoReadEmail();
            }
            else if(currentOption == -1)
            {
                isQuit = 1;
            }
        }
        else
        {
            printf("\nPlease logIn!\n");
            isQuit = 1;
        }
    }while(!isQuit);
}

void doClientRegistration()
{
    char returnMessage[MAX_LINE];
    char pwd[SMALL_STRING];
    printf("Please enter your First Name: ");
    scanf("%[^\n]s",currentUserFName);
    getchar();
    printf("Please enter your Last Name: ");
    scanf("%[^\n]s",currentUserLName);
    getchar();
    printf("Please enter your User Name: ");
    scanf("%[^\n]s",currentUserName);
    getchar();
    printf("Please enter your Password: ");
    scanf("%[^\n]s",pwd);
    getchar();
    
    sprintf (client_message, "%d:%s:%s:%s:%s",2, currentUserName, pwd,currentUserFName,currentUserLName);
    //printf("%s\n",client_message);
    if (send(sockfd, client_message,MAX_CONTENT, 0) < 0)
    {
        printf("CLIENT: can't send login request to server\n");
        close(sockfd);
        exit(EXIT_FAILURE);
    }
    if (recv(sockfd, returnMessage, MAX_LINE, 0) < 0)
    {
        printf("CLIENT: can't receive reply from server\n");
        close(sockfd);
        exit(EXIT_FAILURE);
    }
    if(strcmp(returnMessage, "SUCCESS") == 0)
    {
        printf("Congratuation! You are registered successfully\n");
    }
    else
    {
        printf("We are sorry! Please register with different user name\n");
    }
}

void doClientLogin()
{
    char userName[SMALL_STRING];
    char password[SMALL_STRING];
    char returnMessage[MAX_LINE];
    while(!isLogin)
    {
        printf("Please enter user name (type QUIT to exit): ");
        scanf("%[^\n]s",userName);
        
        if(strcmp(userName,"QUIT")==0)
        {
            break;
        }
        fgetc(stdin);
        printf("Please enter password: ");
        scanf("%[^\n]s",password);
        fgetc(stdin);
        //snprintf(client_message, 100, "%d:%s:%s", 1,userName,password);
        sprintf (client_message, "%d:%s:%s",1, userName, password);
        if (send(sockfd, client_message,MAX_CONTENT, 0) < 0)
        {
            printf("CLIENT: can't send login request to server\n");
            close(sockfd);
            exit(EXIT_FAILURE);
        }
        if (recv(sockfd, returnMessage, MAX_LINE, 0) < 0)
        {
            printf("CLIENT: can't receive reply from server\n");
            close(sockfd);
            exit(EXIT_FAILURE);
        }
        if(strcmp(returnMessage, "NONE") != 0)
        {
            printf("Client get return %s",returnMessage);
            strcpy(currentUserName,userName);
            sscanf(returnMessage,"%d:%[^:]:%[^:]",&isLogin,currentUserFName,currentUserLName);
            if(isLogin)
            {
                printf("\nWelcome %s! You are login succefullfy\n",currentUserName);
            }
        }
        else
        {
            printf("\nLogin Failed! Please try again\n");
        }
    }
}

int main(int argc, char *argv[]) {
    
    //int       sockfd;                /*  connection socket         */
    //int port;                  /*  port number               */
    struct    sockaddr_in serv_addr;  /*  socket address structure  */
    
    
    /*  Set all bytes in socket address structure to
     zero, and fill in the relevant data members   */
    
    memset(&serv_addr, 0, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(SERVER_TCP_PORT);
    
    
    /*  Set the remote IP address  */
    
    if (inet_aton(SERVER_HOST_ADDR, &serv_addr.sin_addr) <= 0 ) {
        printf("ECHOCLNT: Invalid remote IP address.\n");
        exit(EXIT_FAILURE);
    }
    
    
    /*  Open TCP socket  */
    
    if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0 ) {
        fprintf(stderr, "CLIENT: Error creating listening socket.\n");
        exit(EXIT_FAILURE);
    }
    
    /*  connect() to the remote echo server  */
    
    if (connect(sockfd, (struct sockaddr *) &serv_addr, sizeof(serv_addr) ) < 0 ) {
        printf("client: can't connect to server\n");
        close(sockfd);
        exit(EXIT_FAILURE);
    }
    
    do
    {
        printf("-------- Welcome Email Client ---------\nPlease type 1 for Login 2 for Register(-1 to exit): ");
        
        scanf("%d",&serviceInput);
        //fflush(stdin);
        //fgetc(stdin);
        getchar();
        if(serviceInput == 1 || serviceInput == 2)
        {
            if(serviceInput == 1)
            {
                doClientLogin();
                if(isLogin)
                {
                    MainScreen();
                    
                    sprintf (client_message, "%d:%d",-1, -1);
                    if (send(sockfd, client_message,MAX_CONTENT, 0) < 0)
                    {
                        printf("CLIENT: can't send request to server\n");
                        close(sockfd);
                        exit(EXIT_FAILURE);
                    }
                    isQuit = 1;
                    
                }
                
            }
            else if(serviceInput == 2)
            {
                doClientRegistration();
            }
            
        }
        else if(serviceInput==-1)
        {
            
            sprintf (client_message, "%d:%d",-1, -1);
            if (send(sockfd, client_message,MAX_CONTENT, 0) < 0)
            {
                printf("CLIENT: can't send request to server\n");
                close(sockfd);
                exit(EXIT_FAILURE);
            }
            isQuit = 1;
        }
        else
        {
            printf("%d Wrong input receive\r\n",serviceInput);
        }
        
    }while(!isQuit);
    printf("See you another time!\n");
    close(sockfd);
    return 0;
    
}

