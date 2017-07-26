#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <time.h>

#define randrange(N) rand() / (RAND_MAX/(N) + 1)
#define MAX 50
static int c[50];




char *lst[80]={"Today it's up to you to create the peacefulness you long for.\n"                                                                                        ,"A friend asks only for your time not your money.\n","If you refuse to accept a                                                                                        nything but the best, you very often get it.\n","A smile is your passport into t                                                                                        he hearts of others.\n","A good way to keep healthy is to eat more Chinese food.                                                                                        \n","Your high-minded principles spell success.\n","Hard work pays off in the fu                                                                                        ture, laziness pays off now.\n","Change can hurt, but it leads a path to somethi                                                                                        ng better.\n","Enjoy the good luck a companion brings you.\n","People are natura                                                                                        lly attracted to you.\n","Hidden in a valley beside an open stream- This will be                                                                                         the type of place where you will find your dream.\n","A chance meeting opens ne                                                                                        w doors to success and friendship.\n","You learn from your mistakes... You will                                                                                         learn a lot today.\n","If you have something good in your life, don't let it go!                                                                                        \n","What ever you're goal is in life, embrace it visualize it, and for it will                                                                                         be yours.\n","Your shoes will make you happy today.\n","You cannot love life unt                                                                                        il you live the life you love.\n","Be on the lookout for coming events; They cas                                                                                        t their shadows beforehand.\n","Land is always on the mind of a flying bird.\n",                                                                                        "The man or woman you desire feels the same about you.\n","Meeting adversity wel                                                                                        l is the source of your strength.\n","A dream you have will come true.\n","Our d                                                                                        eeds determine us, as much as we determine our deeds.\n","Never give up. You're                                                                                         not a failure if you don't give up.\n","You will become great if you believe in                                                                                         yourself.\n","There is no greater pleasure than seeing your loved ones prosper.\                                                                                        n","You will marry your lover.\n","A very attractive person has a message for yo                                                                                        u.\n","You already know the answer to the questions lingering inside your head.\                                                                                        n","It is now, and in this world, that we must live.\n","You must try, or hate y                                                                                        ourself for not trying.\n","You can make your own happiness.\n","The greatest ri                                                                                        sk is not taking one.\n","The love of your life is stepping into your planet thi                                                                                        s summer.\n","Love can last a lifetime, if you want it to.\n","Adversity is the                                                                                         parent of virtue.\n","Serious trouble will bypass you.\n","A short stranger will                                                                                         soon enter your life with blessings to share.\n","Now is the time to try someth                                                                                        ing new.\n","Wealth awaits you very soon.\n","If you feel you are right, stand f                                                                                        irmly by your convictions.\n","If winter comes, can spring be far behind?\n","Ke                                                                                        ep your eye out for someone special.\n","You are very talented in many ways.\n",                                                                                        "A stranger, is a friend you have not spoken to yet.\n","A new voyage will fill                                                                                         your life with untold memories.\n","You will travel to many exotic places in you                                                                                        r lifetime.\n","Your ability for accomplishment will follow with success.\n","No                                                                                        thing astonishes men so much as common sense and plain dealing.\n","Its amazing                                                                                         how much good you can do if you dont care who gets the credit.\n"};









int vector[MAX];
int l;
int nn;

int i,j;
void error(const char *msg)
{
  perror(msg);
  exit(1);
}
int main(int argc, char *argv[])
{
  int sockfd, newsockfd, portno;
  socklen_t clilen;
  char buffer[256];
  struct sockaddr_in serv_addr, cli_addr;
  int n;
  if (argc < 2) {
    fprintf(stderr,"Error there is no port number\n");
    exit(1);
  }
  sockfd = socket(AF_INET, SOCK_STREAM, 0);
  if (sockfd < 0)
  error("ERROR opening socket");
  bzero((char *) &serv_addr, sizeof(serv_addr));
  portno = atoi(argv[1]);
  serv_addr.sin_family = AF_INET;
  serv_addr.sin_addr.s_addr = INADDR_ANY;
  serv_addr.sin_port = htons(portno);
  if (bind(sockfd, (struct sockaddr *) &serv_addr,
           sizeof(serv_addr)) < 0)
    error("ERROR on binding");
  listen(sockfd,5);
  clilen = sizeof(cli_addr);
  for(j=0;j<4;j++){
    newsockfd = accept(sockfd,(struct sockaddr *) &cli_addr,&clilen);
    if (newsockfd < 0)
      error("ERROR on accept");
    bzero(buffer,256);
    n = read(newsockfd,buffer,255);
    if (n < 0) error("ERROR reading from socket");
    printf("\n\nThe number of Cookies requested by the client : %s\n\n\n",buffer                                                                                        );
    l =  atoi(buffer);
    srand(time(NULL));
    for (i=0; i<MAX; i++)
      vector[i] = i;
    for (i = 0; i < MAX-1; i++) {
      int c = randrange(MAX-i);
      int t = vector[i];
      vector[i] = vector[i+c];
      vector[i+c] = t;
    }
    for (i=0; i<l; i++)
      c[i] = vector[i] + 5;
    for (i=0; i<l; i++){
      nn=c[i]-1;
      printf("cookie No. :: %d %s", i+1, lst[nn]);
      n = write(newsockfd,lst[nn],strlen(lst[nn]));
    }
    if (n < 0) error("\nError while writing to socket\n");
    close(newsockfd);
  }
  close(sockfd);
  return 0;
}
