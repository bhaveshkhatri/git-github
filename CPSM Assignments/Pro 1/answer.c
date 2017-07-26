#include<stdio.h>
#include<pthread.h>
#include<time.h>

int i,j,who,column,result=0,threshold=0;
char put;

void board();
char table[6][7];


void *insert();

void *monitor();

 struct
 {
   pthread_mutex_t mutexA;
   pthread_mutex_t mutexB;

   pthread_cond_t condA;
   pthread_cond_t condB;

   int run;

 }s={PTHREAD_MUTEX_INITIALIZER,PTHREAD_MUTEX_INITIALIZER,PTHREAD_COND_INITIALIZER,PTHREAD_COND_INITIALIZER,0};




main()


      {

        for(i=0;i<6;i++)
          {
            for(j=0;j<7;j++)
              {
                table[i][j]='*';
              }
          }


        pthread_t umpire,player1, player2;

        pthread_create(&umpire,NULL,monitor,NULL);
        pthread_create(&player1,NULL,insert,NULL);
        pthread_create(&player2,NULL,insert,NULL);


        pthread_join(umpire,NULL);
        pthread_join(player1,NULL);
        pthread_join(player2,NULL);


      }


        void *monitor()
        {


          pthread_mutex_lock(&s.mutexA);

                    printf("\n\n\nHi.......!  I am yur Umpire!!!!!!    Let's start the game and here is your table   \n\n\n");

                    sleep(2);
                    board();


              for(;;)
                {

                  for(i=0;i<3;i++)
                    {
                      for(j=0;j<7;j++)
                        {
                          if(table[i][j]!='*'&&table[i][j]==table[i+1][j] && table[i][j]==table[i+2][j] && table[i][j]==table[i+3][j])
                            {
                              printf("\n\n\n*********  PLAYER %c HAS WON THE GAME  **********\n\n\n",table[i][j]);
                              board();
                              result=1;
                              pthread_mutex_unlock(&s.mutexA);
                              pthread_exit(NULL);
                            }
                        }
                    }

              for(i=0;i<3;i++)
                {
                  for(j=0;j<4;j++)
                    {
                      if(table[i][j]!='*'&&table[i][j]==table[i+1][j+1] && table[i][j]==table[i+2][j+2] && table[i][j]==table[i+3][j+3])
                        {
                          printf("\n\n\n*********  PLAYER %C HAS WON THE GAME  **********\n\n\n",table[i][j]);
                          board();
                          result=1;
                          pthread_mutex_unlock(&s.mutexA);
                          pthread_exit(NULL);
                        }
                    }
                }

              for(i=5;i>2;i--)
                {
                  for(j=0;j<4;j++)
                    {
                      if(table[i][j]!='*'&&table[i][j]==table[i-1][j+1] && table[i][j]==table[i-2][j+2] && table[i][j]==table[i-3][j+3])
                        {
                          printf("\n\n\n*********  PLAYER %C HAS WON THE GAME  **********\n\n\n",table[i][j]);
                          board();
                          result=1;
                          pthread_mutex_unlock(&s.mutexA);
                          pthread_exit(NULL);

                        }
                    }
                }


              if(threshold==42)
                {
                     printf("No one won the game and game terminated");
                     pthread_mutex_unlock(&s.mutexA);
                     pthread_exit(NULL);
                }





          if(s.run==0)

              pthread_cond_signal(&s.condA);
              s.run++;
              pthread_mutex_unlock(&s.mutexA);




              pthread_mutex_lock(&s.mutexB);

              pthread_cond_wait(&s.condB,&s.mutexB);
              pthread_mutex_unlock(&s.mutexB);


            }
        }







        void *insert()

        {
          for(;;)
            {
          pthread_mutex_lock(&s.mutexA);

          if(result==1)
            {
              pthread_mutex_unlock(&s.mutexA);
              pthread_exit(NULL);
            }

          while(s.run==0)
            {
              pthread_cond_wait(&s.condA,&s.mutexA);
            }

          s.run--;

          who=pthread_self()%2;
          if(who!=0)
            {
               put='B';
            }
          else
            {
               put='W';
            }

          time_t t;
          srand(time(&t));
          column=rand()%7;
          sleep(1);


          for(i=5;i>=0;i--)
            {
          if(table[i][column]=='*')
            {
              printf("\n\nThe player %c is playing\n\n",put);
              sleep(1);
              table[i][column]=put;
              threshold++;
              board();
              break;
            }
            }



          pthread_mutex_unlock(&s.mutexA);

          pthread_mutex_lock(&s.mutexB);
          pthread_cond_signal(&s.condB);
          pthread_mutex_unlock(&s.mutexB);
          sleep(1);
            }
        }





        void board()
        {

          printf("--------------------------------------------------");
          for(i=0;i<6;i++)
            {

              printf("\n");
              for(j=0;j<7;j++)
                {

                  printf("|%3c   ",table[i][j]);
                }
              printf("|");
              printf("\n");
              printf("--------------------------------------------------");
            }
          printf("\n\n\n\n");

        }
