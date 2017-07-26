#include <stdio.h>

#include <stdlib.h>

#include <netdb.h>

#include <netinet/in.h>

#include <string.h>




void encription(char message[],int ekey);

void decription(char message[],int dkey);



void child(int socket,int option);



int main( int argc, char *argv[] )

{

   int sockfd, newsockfd, port, client;

   char message[1000];

   struct sockaddr_in serv_addr, cli_addr;

   int  n, process,flag,lable;

   sockfd = socket(AF_INET, SOCK_STREAM, 0);

   if (sockfd < 0)

      {

      perror("\n:::::: socket error ::::::\n");

      exit(1);

      }

   bzero((char *) &serv_addr, sizeof(serv_addr));

   port = atoi(argv[1]);

   serv_addr.sin_family = AF_INET;

   serv_addr.sin_addr.s_addr = INADDR_ANY;

   serv_addr.sin_port = htons(port);

   if (bind(sockfd, (struct sockaddr *) &serv_addr, sizeof(serv_addr)) < 0)

      {


        perror("\n:::::: Error while binding ::::::\n");

      exit(1);

      }

   listen(sockfd,5);

   client = sizeof(cli_addr);

   while (1)

   {

      newsockfd = accept(sockfd, (struct sockaddr *) &cli_addr, &client);

      n = read(newsockfd,&flag,sizeof(flag));

    if (n < 0)

    {

        perror("\n:::::: Reading error ::::::\n");

        exit(1);

    }

       lable=ntohl(flag);

        if(lable == 3)

        {

        close(sockfd);

        close(newsockfd);

        exit(0);

        }

        else

        {

       if (newsockfd < 0)

         {

         perror("\n:::::::Error in accept ::::::\n");

         exit(1);

         }

      process = fork();

      if (process < 0)

         {

         perror("\n ::::::error while fork ::::::\n");

         exit(1);

         }



      if (process == 0)

         {

         child(newsockfd,lable);

         }

      else

         {

         close(newsockfd);

         }

   }

}

}

void encription(char message[],int ekey)

{

    unsigned int i;

    for(i=0;i<strlen(message);++i)

    {

        message[i] = message[i] - ekey;

    }

}

void decription(char message[],int dkey)

{

    unsigned int i;

    for(i=0;i<strlen(message);++i)

    {

        message[i] = message[i] + dkey;

    }

}

void child(int socket,int option)

{

   int n;

   char message[1000];



   bzero(message,1000);



   n = read(socket,message,255);



   if (n < 0)

   {

      perror("::::::: Read error :::::::");

      exit(1);

   }

if(option == 1)

{

   encription(message,-7);

}

 if(option == 2)

{

   decription(message,-7);

}

   n = write(socket,message,strlen(message));

   if (n < 0)

      {

      perror("\n:::::: Writing error :::::::");

      exit(1);

      }

}
