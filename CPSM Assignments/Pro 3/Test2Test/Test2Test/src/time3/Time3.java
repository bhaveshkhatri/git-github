/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time3;

import time2.Time2;

public class Time3 {

   private int hour;
private int minute;
private int second;
public Time3()
{
this(0,0,0);
}
public Time3(int hour)
{
    
   this(hour,0,0);
}
public Time3(int hour,int minute)
{
this(hour,minute,0);
}
public Time3(int hour,int minute,int second)
{
if (hour < 0 || hour >=24)
throw new IllegalArgumentException("hour must be 0-23");
if (minute < 0 || minute >=60)
throw new IllegalArgumentException("minute  must be 0-59");
if(second < 0 || second >=60)
throw new IllegalArgumentException("minute  must be 0-59");
this.hour=hour;
this.minute=minute;
this.second=second;
}
public Time3(Time3 time)
{
this(time.getHour(),time.getMinute(),time.getSecond());
}
public void setTime(int hour,int minute,int second)
{
if (hour < 0 || hour >=24)
throw new IllegalArgumentException("hour must be 0-23");
if (minute < 0 || minute >=60)
throw new IllegalArgumentException("minute  must be 0-59");
if(second < 0 || second >=60)
throw new IllegalArgumentException("second  must be 0-59");
this.hour=hour;
this.minute=minute;
this.second=second;
}
public void setHour(int Hour)
{
if (hour < 0 || hour >=24)
throw new IllegalArgumentException("hour must be 0-23");
this.hour=hour;
}
public void setMinute(int minute)
{
if(minute<0 && minute>=60)
throw new IllegalArgumentException("minute must be 0-59");
this.minute=minute;
}
public void setSecond(int second)
{
if(second<0 && second>=60)
throw new IllegalArgumentException("second must be 0-59");
this.second=second;
}
public int getHour()
{
return hour;
}
public int getMinute()
{
return minute;
}
public int getSecond()
{
return second;
}
public String toUniversalString()
{
return String.format("%02d: %02d: %02d",getHour(),getMinute(),getSecond());
}
public String toString()
{
   return String.format("%08d",((getHour()*60*60)+(getMinute()*60)+getSecond()));
}
 
public void addtime(int h, int m, int s) {
    if (h < 0 || h >=24)
throw new IllegalArgumentException("hour must be 0-23");
if (m < 0 || m >=60)
throw new IllegalArgumentException("minute  must be 0-59");
if(s < 0 || s >=60)
throw new IllegalArgumentException("seconds  must be 0-59");
this.hour=h;
this.minute=m;
this.second=s;
    
}
public void addtime(Time2 time){
    this.hour=time.getHour();
    this.minute=time.getMinute();
    this.second=time.getSecond();
    
}
    
}

class Time3tz extends Time3 {
    
    
   
    
}
