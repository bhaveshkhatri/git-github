#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#define CONFIG_FILE "userList.txt"
#define MAX_LINE 500
#define MAX_CONTENT 10000
#define EMAIL_CONTENT 4000
#define ATTACH_CONTENT 5000
#define SMALL_STRING 50
#define MAX_STRING 250
//#define CONFIG_FILE "/Users/phamanh_trung/Documents/UHCL/Test Function/Test Function/userList.txt"

int CheckIfUserExist(char* userName)
{
    FILE* fp;
    char _userName[SMALL_STRING];
    char readLine[MAX_LINE];
    fp=fopen(CONFIG_FILE,"r+");
    if(fp)
    {
        while(fgets(readLine,MAX_LINE,fp) != NULL)
        {
            //printf("%s",readLine);
            printf("Reach here\n");
            
            sscanf(readLine,"%[^;]",_userName);
            if(strcmp(userName,_userName) == 0)
            {
                fclose(fp);
                return 1;
            }
        }
        fclose(fp);
        return 0;
    }
    return 0;
}

char* IsClientAuthenticated(char* userName,char* password)
{
    FILE* fp;
    fp=fopen(CONFIG_FILE,"r+");
    char _userName[SMALL_STRING];
    char _password[SMALL_STRING];
    char _firstName[SMALL_STRING];
    char _lastName[SMALL_STRING];
    char readLine[MAX_LINE];
    
    char *returnMessage = malloc (sizeof (char) * MAX_LINE);
    
    while(fgets(readLine,MAX_LINE,fp) != NULL)
    {
        //printf("%s",readLine);
        printf("Reach here\n");
        
        sscanf(readLine,"%[^;];%[^;];%[^;];%[^;]",_userName,_password,_firstName,_lastName);
        printf("Line - user: %s , pass: %s , first: %s, last: %s\n",_userName,_password,_firstName,_lastName);
        if((strcmp(_userName,userName) == 0) && strcmp(password,_password) == 0)
        {
            fclose(fp);
            //snprintf(returnMessage, MAX_LINE, "%d:%s:%s", 1,_firstName,_lastName);
            sprintf (returnMessage, "%d:%s:%s", 1,_firstName,_lastName);
            return returnMessage;
        }
    }
    fclose(fp);
    return "NONE";
}

int ClientRegistration(char* userName,char* pwd,char* firstName,char* lastName)
{
    printf("Server GOT: %s;%s;%s;%s\n",userName,pwd,firstName,lastName);
    if(!CheckIfUserExist(userName))
    {
        
        char fileName[50];
        //snprintf(fileName,100,"%s.txt",userName);
        sprintf (fileName, "%s.txt",userName);
        printf("File Name = %s\n",fileName);
        FILE *file = fopen(CONFIG_FILE,"ab+");
        if(file)
        {
            printf("Before save: %s;%s;%s;%s;%s\n",userName,pwd,firstName,lastName,fileName);
            fprintf(file,"%s;%s;%s;%s;%s\n",userName,pwd,firstName,lastName,fileName);
            fclose(file);
            FILE *clientFile=fopen(fileName,"ab+");
            if(clientFile)
            {
                fclose(clientFile);
                return 1;
            }
            else
            {
                fclose(clientFile);
                return 0;
            }
        }
        else
        {
            fclose(file);
            return 0;
        }
        
    }
    else
    {
        return 0;
    }
}


void doProcessEmailMessage(char *messageContent)
{
    char subject[SMALL_STRING];
    char from[SMALL_STRING];
    char senderEMail[SMALL_STRING];
    //char firstName[SMALL_STRING];
    //char lastName[SMALL_STRING];
    char toName[SMALL_STRING];
    char sendTime[SMALL_STRING];
    char attachment[ATTACH_CONTENT];
    char emailContent[EMAIL_CONTENT];
    int count;
    printf("%s",messageContent);
    count = sscanf(messageContent,
                   "%s EmailSubject: %[^#]#EmailContent: %[^#]#Attachment: %[^#]#ToName: %[^#]#SendTime: %[^#]#FromName: %[^'\0']"
                   ,senderEMail,subject,emailContent,attachment,toName,sendTime,from);
    printf("Count: %d\n",count);
    printf("%s\n",subject);
    printf("%s\n",emailContent);
    printf("%s\n",attachment);
    printf("%s\n",toName);
    printf("%s\n",sendTime);
    printf("%s\n",from);
    
    FILE *file = fopen(strcat(toName,".txt"),"a+");
    if(file)
    {
        fprintf(file,"~Un-Read\nFrom: %s\nSender Email: %s\nDate: %s\nSubject: %s\nContent: %s\nAttachment: %s\n#END\n",from, senderEMail, sendTime,subject,emailContent,attachment);
        fclose(file);
    }
    else
    {
        printf("Cannot find file %s",toName);
    }
}
