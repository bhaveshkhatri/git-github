#include <stdio.h>

#include <netinet/in.h>

#include <string.h>

#include <unistd.h>

#include <sys/types.h>

#include <sys/socket.h>
#include <stdlib.h>

#include <netdb.h>



#include <netinet/in.h>



int sockfd, port;

 struct sockaddr_in serv_addr;

 struct hostent *server;



int  flag ,status,a;

int num,choice,i,j;
char buffer[1000];
char msg[1000];

/* Fortune cookies function */

 int cookie(){

   printf("Please enter the number to get Cookies:\n");

    bzero(buffer,1000);

    fgets(buffer,999,stdin);

    scanf("%s",&buffer);

    flag = write(sockfd,buffer,strlen(buffer));

    if (flag < 0)

         printf("\n Error occured while write operation\n");

    bzero(buffer,1000);

    flag = read(sockfd,buffer,sizeof(buffer)*1000);

    if (flag < 0)

         printf("\n Error occured while read operation\n");

    printf("\n%s\n",buffer);

    return 0;



 }

 

int main(int argc, char *argv[])

{

   if (argc <2) {

      fprintf(stderr,"usage %s hostname port\n", argv[0]);

      exit(0);

   }

   printf ( "Enter your CHOICE\n");
   printf ("\n 1. For Fortune cookies....\n");

   printf(" 2 To Encrypttion or  Decryption of  a message\n");

   scanf("%d",&choice);

   if ( choice ==1)

      port = 7148;

   else if ( choice == 2)

      port = 7147;

   else

       printf("Server terminated\n");

   sockfd = socket(AF_INET, SOCK_STREAM, 0);



   if (sockfd < 0)

   {

      printf("ERROR: while opening socket");

      exit(1);

   }

   server = gethostbyname(argv[1]);

   if (server == NULL) {

      fprintf(stderr,"ERROR: There is NO HOST\n");

      exit(0);

   }

   bzero((char *) &serv_addr, sizeof(serv_addr));

   serv_addr.sin_family = AF_INET;

   bcopy((char *)server->h_addr, (char *)&serv_addr.sin_addr.s_addr, server->h_l                                                                                        ength);

   serv_addr.sin_port = htons(port);

   if (connect(sockfd, (struct sockaddr*)&serv_addr, sizeof(serv_addr)) < 0)

   {

      printf("\nERROR: Conection problem\n");

      exit(1);

   }

   if ( choice ==1)

                cookie();

        else if ( choice == 2)

                ed();

        else

                printf("Server terminated\n");

    }

/*  Encryption and Decryption function  */

int ed(){

   printf("\nEnter :: 1 for Encryption ::\n");

   printf("Enter :: 2 for Decryption :: \n");

   printf("Enter 3 For Sign Out\n");

   scanf("%d",&num);

   a=htonl(num);

   flag = write(sockfd,&a,sizeof(a));

   if (flag < 0)

   {

      printf("\nError occured while  write operationn\n");

      exit(1);

   }

   if(num == 3)

   {

    printf("\n Server Terminated\n");

   }

   else

   {

   printf("\n  :: Type your message here :: \n");

   bzero(msg,1000);

   scanf("%s",&msg);

   status = write(sockfd, msg, strlen(msg));

   if (status < 0)

   {

      printf("\n Error occured while write operation\n");

      exit(1);

   }

   bzero(msg,1000);

   flag = read(sockfd, msg, 999);



   if (flag < 0)

   {

      printf("\n Error occured while read operationn \n");

      exit(1);

   }

    if(num==1)

       printf("Here is the encrypted message  :: %s\n",msg);

    else

    printf("Here is the decrypted message :: %s\n",msg);

       return 0;

  }

 }
