/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time2test;
import time2.Time2;
import time3.Time3;
import time3tz.Time3tz;

public class Time2Test {

public static void main(String[] args)
{
Time2 t1 =new Time2();
Time2 t2 = new Time2(2);
Time2 t3 = new Time2(21,34);
Time2 t4 = new Time2(12, 25, 42);
Time2 t5 = new Time2(t4);
System.out.println("Constructed with:");
displayTime("t1: all default arguments",t1);
displayTime("t2: hour specified;default minute and second",t2);
displayTime("t3:hour and minute specified;default second",t3);
displayTime("t4:hour,minute and second specified",t4);
displayTime("t5: Time2 object t4 specified",t5);


Time3 s1 =new Time3();
Time3 s2 = new Time3(2);
Time3 s3 = new Time3(21,34);
Time3 s4 = new Time3(12, 25, 42);
Time3 s5 = new Time3(s4);
System.out.println("Constructed with:");
displayTime("s1: all default arguments",s1);
displayTime("s2: hour specified;default minute and second",s2);
displayTime("s3:hour and minute specified;default second",s3);
displayTime("s4:hour,minute and second specified",s4);
displayTime("s5: Time2 object t4 specified",s5);
try
{
Time3 s6= new Time3(27,74,99);
}
catch(IllegalArgumentException e)
{
System.out.printf("%n Exception while initializing t6: %s%n",e.getMessage());
}
Time2 p1 = new Time2(12, 25, 42);
Time3 q1 =new Time3();
q1.addtime(p1);
System.out.println("Constructed with:");
displayTime("q1: all default arguments",q1);

Time3 q2 =new Time3();
q2.addtime(23,59,59);
System.out.println("Constructed with:");
displayTime("q2: all default arguments",q2);

Time3tz tz=new Time3tz(21,34);
displayTime("tz: all default arguments",tz);



}
private static void displayTime(String header,Time2 t)
{
System.out.printf("%s%n   %s%n   %s%n",header,t.toUniversalString(),t.toString());
}
private static void displayTime(String header,Time3 t)
{
System.out.printf("%s%n   %s%n   %s%n",header,t.toUniversalString(),t.toString());
}

private static void displayTime(String header,Time3tz tz)
{
System.out.printf("%s%n   %s%n   %s%n",header,tz.toUniversalString(),tz.toString());
}

}
