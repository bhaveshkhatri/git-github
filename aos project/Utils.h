//
//  Utils.h
//  Test Function
//

#ifndef Utils_h
#define Utils_h

//#include <stdio.h>

void WriteEmail(char EmailContent[]);
char* GetEmailInput();
int CheckIfUserExist(char* userName);
char* IsClientAuthenticated();
int ClientRegistration();
void doProcessEmailMessage(char *messageContent);
#endif /* Utils_h */

