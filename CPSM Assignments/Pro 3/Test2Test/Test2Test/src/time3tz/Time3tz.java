/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time3tz;

import time3.Time3;
public class Time3tz extends Time3{
    
    
    Time3tz()
{
super(0,0,0);
}
public Time3tz(int hour)
{
    
   super(hour,0,0);
}
public Time3tz(int hour,int minute)
{
super(hour,minute,0);
}
public Time3tz(int hour,int minute,int second)
{
super(hour,minute,second);
}
public Time3tz(Time3 time)
{
super(time.getHour(),time.getMinute(),time.getSecond());
}
    
 public String toUniversalString()
{
 
    
return String.format("%02d: %02d: %02d",getHour(),getMinute(),getSecond());
}
public String toString()
{
   
    return String.format("%02d: %02d: %02d %s cst\n  %02d: %02d: %02d %s est\n %02d: %02d: %02d %s mst\n %02d: %02d: %02d %s pst\n",((getHour()==0 ||getHour()==12)?12:getHour()%12),getMinute(),getSecond(),(getHour()<12? "AM": "PM"),
            (((getHour()+1)==0 ||(getHour()+1)==12)?12:(getHour()+1)%12),getMinute(),getSecond(),((getHour()+1)<12? "AM": "PM"),
            (((getHour()-1)==0 ||(getHour()-1)==12)?12:(getHour()-1)%12),getMinute(),getSecond(),((getHour()-1)<12? "AM": "PM"),
            (((getHour()-2)==0 ||(getHour()-2)==12)?12:(getHour()-2)%12),getMinute(),getSecond(),((getHour()-2)<12? "AM": "PM"));
}
}
