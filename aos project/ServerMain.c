#include <sys/socket.h>
#include <sys/types.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <string.h>
#include "Utils.h"
/*  Global constants  */

#include<sys/ipc.h>
#include<sys/sem.h>
#define KEY ((key_t)45678L)


#define SERVER_TCP_PORT 5004
#define SERVER_HOST_ADDR "127.0.0.1"
#define MAX_LINE 500
#define MAX_CONTENT 10000
#define EMAIL_CONTENT 4000
#define ATTACH_CONTENT 5000
#define SMALL_STRING 50
#define MAX_STRING 250



char client_message[MAX_CONTENT];
FILE *filePointer;
time_t t;

//union semun arg;

/*union semun{
 int val;
 struct semid_ds *buff;
 ushort *array;
 }arg;*/

/*int semid;
struct sembuf setlock,rellock;
key_t semaphoreKey;
*/

void serverDoLogin(char* message,int sk)
{
    char userName[SMALL_STRING];
    char pwd[SMALL_STRING];
    //char c[2];
    //char returnMessage[MAX_LINE];
    printf("Socket from Func: %d\n",sk);
    sscanf(message,"%[^':']:%s",userName,pwd);
    char *returnMessage = IsClientAuthenticated(userName,pwd);
    //strcpy(returnMessage,IsClientAuthenticated(userName,pwd));
    //printf("Return from server %s\n",returnMessage);
    if (send(sk, returnMessage,MAX_LINE, 0) < 0)
    {
        printf("SERVER: can't send reply authentication to client\n");
        close(sk);
        exit(EXIT_FAILURE);
    }
}

void serverDoRegistration(char* message,int sk)
{
    char userName[SMALL_STRING];
    char pwd[SMALL_STRING];
    char firstName[SMALL_STRING];
    char lastName[SMALL_STRING];
    sscanf(message,"%[^':']:%[^':']:%[^':']:%s",userName,pwd,firstName,lastName);
    int isSuccess = ClientRegistration(userName,pwd,firstName,lastName);
    char returnMessage[MAX_STRING]={'\0'};
    if(isSuccess)
    {
        strcpy(returnMessage,"SUCCESS");
    }
    else
    {
        strcpy(returnMessage,"FAILED");
    }
    if (send(sk, returnMessage,MAX_LINE, 0) < 0)
    {
        printf("SERVER: can't send reply authentication to client\n");
        close(sk);
        exit(EXIT_FAILURE);
    }
}

void doFetchEmail(char* userName,int sk)
{
    //printf("Before fetch email for %s on Server\n",userName);
    char readLine[MAX_LINE];
    char fileName[SMALL_STRING];
    sprintf (fileName, "%s.txt",userName);
    FILE* fp;
    //printf("Before open file %s\n",fileName);
    fp=fopen(fileName,"r+");
    char UserDisplayEmail[MAX_CONTENT];
    char status[SMALL_STRING];
    char subject[SMALL_STRING];
    char from[SMALL_STRING];
    char senderEMail[SMALL_STRING];
    //char toName[SMALL_STRING];
    char sendTime[SMALL_STRING];
    char attachment[ATTACH_CONTENT];
    char emailContent[EMAIL_CONTENT];
    
    
    int isInAttachement= 0;
    if(fp)
    {
        while(fgets(readLine,MAX_LINE,fp) != NULL)
        {
            if(!isInAttachement)
            {
                if(strstr(readLine, "~") != NULL)
                {
                    strcpy(status,readLine);
                }
                else if(strstr(readLine, "From: ") != NULL)
                {
                    strcpy(from,readLine);
                }
                else if(strstr(readLine, "Sender Email: ") != NULL)
                {
                    strcpy(senderEMail,readLine);
                }
                else if(strstr(readLine, "Date: ") != NULL)
                {
                    strcpy(sendTime,readLine);
                }
                else if(strstr(readLine, "Subject: ") != NULL)
                {
                    strcpy(subject,readLine);
                }
                else if(strstr(readLine, "Content: ") != NULL)
                {
                    strcpy(emailContent,readLine);
                    while(fgets(readLine,MAX_LINE,fp) != NULL)
                    {
                        if(strstr(readLine, "Attachment: ") == NULL)
                        {
                            strcat(emailContent,readLine);
                        }
                        else
                        {
                            strcpy(attachment,readLine);
                            isInAttachement = 1;
                            break;
                        }
                    }
                }
            }
            else
            {
                if(strstr(readLine, "#END") == NULL)
                {
                    strcat(attachment,readLine);
                }
                else
                {
                    isInAttachement = 0;
                    
                    sprintf (UserDisplayEmail, "%s%s%s%s%s%s%s",status, from,senderEMail,sendTime,subject,emailContent,attachment);
                    if (send(sk, UserDisplayEmail,MAX_CONTENT, 0) < 0)
                    {
                        printf("SERVER: can't send reply authentication to client\n");
                        close(sk);
                        exit(EXIT_FAILURE);
                    }
                    //printf("%s",UserDisplayEmail);
                }
            }
        }
        fclose(fp);
        if (send(sk, "#EOF",MAX_CONTENT, 0) < 0)
        {
            printf("SERVER: can't send reply authentication to client\n");
            close(sk);
            exit(EXIT_FAILURE);
        }
        //printf("EOF\n");
    }
}


int main(int argc, char *argv[]) {
    int       sockfd;                /*  listening socket          */
    int       newsockfd;                /*  connection socket         */
    
    struct    sockaddr_in servaddr;  /*  socket address structure  */
    //char      buffer[MAX_LINE];      /*  character buffer          */
    //char     *endptr;                /*  for strtol()              */
    int childpid;//,subchildpid;
    
    /*  Create the listening socket  */
    
    if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0 ) {
        fprintf(stderr, "ECHOSERV: Error creating listening socket.\n");
        exit(EXIT_FAILURE);
    }
    
    
    /*  Set all bytes in socket address structure to
     zero, and fill in the relevant data members   */
    
    memset(&servaddr, 0, sizeof(servaddr));
    servaddr.sin_family = AF_INET;
    servaddr.sin_addr.s_addr = htonl(INADDR_ANY);
    servaddr.sin_port = htons(SERVER_TCP_PORT);
    
    
    /*  Bind our socket addresss to the
     listening socket, and call listen()  */
    
    if (bind(sockfd, (struct sockaddr *) &servaddr, sizeof(servaddr)) < 0 ) {
        fprintf(stderr, "SERVER: Error calling bind()\n");
        exit(EXIT_FAILURE);
    }
    
    if (listen(sockfd, 5) < 0 ) {
        fprintf(stderr, "SERVER: Error calling listen()\n");
        exit(EXIT_FAILURE);
    }
    
    
    /*
     Semaphore Declaration
     
     */
    /*
    setlock.sem_num=0;
    setlock.sem_op=-1;
    setlock.sem_flg=SEM_UNDO;
    
    rellock.sem_num=0;
    rellock.sem_op=1;
    rellock.sem_flg=SEM_UNDO;
    
    semaphoreKey = ftok(".",4);
    int oflag = IPC_CREAT|0666;
    if((semid = semget(semaphoreKey,1,oflag)) == -1)
    {
        perror("segment: semget failed");
        exit(1);
    }
    
        
    printf("\nsemid %d - key %d\n",semid,semaphoreKey);
    arg.val=1;
    semctl(semid,1,SETVAL,arg);*/
    
    /*  Wait for connection loop  */
    
    for ( ;; ) {
        
        /*  Accept new connection  */
        
        if ( (newsockfd = accept(sockfd, NULL, NULL) ) < 0 ) {
            fprintf(stderr, "SERVER: Error calling accept()\n");
            close(sockfd);
            exit(EXIT_FAILURE);
        }
        //childpid=fork();
        if((childpid=fork()) < 0)
        {
            fprintf(stderr, "SERVER: Fork Error\n");
            //close(newsockfd);
            //close(sockfd);
            exit(EXIT_FAILURE);
        }
        else if(childpid == 0)
        {
            close(sockfd);
            printf("Closed parent socket in child\n");
            char child_Message[MAX_CONTENT];
            char child_Main_Message[MAX_CONTENT];
            
            int option;//, gameOption;
            for(;;)
            {
                recv(newsockfd, child_Message,MAX_CONTENT, 0);
                int n = sscanf(child_Message,"%d:%[^'\0']",&option,child_Main_Message);
                printf("Server Recieve %s\n",child_Main_Message);
                if(option== -1)
                {
                    if ( close(newsockfd) < 0 )
                    {
                        fprintf(stderr, "SERVER: Error calling close()\n");
                        exit(EXIT_FAILURE);
                    }
                    printf("SERVER: Closed Child socket\n");
                    exit(0);
                }
                if(option == 1)
                {
                    serverDoLogin(child_Main_Message, newsockfd);
                    
                }
                else if(option == 2)
                {
                    serverDoRegistration(child_Main_Message, newsockfd);
                }
                else if(option == 3)
                {
                    doProcessEmailMessage(child_Main_Message);
                    /*semop(semid,&setlock,1);
                    doProcessEmailMessage(child_Main_Message);
                    semop(semid,&rellock,1);*/
                }
                else if(option == 4)
                {
                    printf("\nBefore locking file for fetching email\n");
                    doFetchEmail(child_Main_Message,newsockfd);
                    /*semop(semid,&setlock,1);
                    doFetchEmail(child_Main_Message,newsockfd);
                    semop(semid,&rellock,1);*/
                    printf("\nAfter locking file for fetching email\n");
                }
            }
        }
        else
        {
            close(newsockfd);
            printf("SERVER: Closed new socket\n");
        }
    }
    
    return 0;
}
