/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prof;

import java.io.BufferedReader;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author Ankul
 */



class Slots
    {
       
        int flag =1;
        //static int countChk=0;
        String SubjectCode;
        int StartTime;
        int EndTime;
        boolean assigned;
        boolean perm;
        boolean notif;
        Slots(int i)
        {
           // if(countChk > 8)
           // {
            
            if(i==0)
            {
                StartTime=9;
                EndTime=10;
                flag=0;
            }
            else  if(i==1)
            {
                StartTime=10;
                EndTime=11;
                
            }
            else if(i==2)
            {
                StartTime=11;
                EndTime=12;
                 
            }
            else if(i==3)
            {
                StartTime=12;
                EndTime=13;
                
            }
            else if(i==4)
            {
                StartTime=13;
                EndTime=14;
               
            }
            else  if(i==5)
            {
                StartTime=14;
                EndTime=15;
                
            }
            else if(i==6)
            {
                StartTime=15;
                EndTime=16;
                
            }
            else if(i==7)
            {
                StartTime=16;
                EndTime=17;
                
            }
            else if(i==8)
            {
                StartTime=17;
                EndTime=18;
                flag=1;
            }
           // System.out.println("SlotDone!"+SlotCount%8);
           
            
        }
        
 }      
class Day
{
     test t= new  test();
    //Slots s[];
    static int DayCount=0;
    int i;
    Slots[] s = new Slots[9];
    List<String> ls = new ArrayList<String>();
    String str = "";
    String DayName;
    
    Day()
    {
        
        for(i=0;i<9;i++)
        {
           s[i]= new Slots(i);
        }
        //System.out.println("Here!");
         if(DayCount==0)
            {
               DayName="Monday";
            }
         else  if(DayCount==1)
            {
               DayName="Tuesday";
            }
         else  if(DayCount==2)
            {
               DayName="Wednesday";
            }
         else if(DayCount==3)
            {
               DayName="Thrusday";
            }
         else if(DayCount==4)
            {
               DayName="Friday";
            }
         else if(DayCount==5)
            {
               DayName="Saturday";
            }
         //System.out.println("DayDone!"+DayCount);
         DayCount++;
         
    }
    int j=8;
    boolean insert(String Subject_Name, int st)
    {  System.out.println(st);
        boolean ret,x,y=false;
        int flag=1;
        for(int i=0;i<9&&flag==1;i++)
        {
            //System.out.println("abc");
            //System.out.println(s[i].StartTime);
            
            if(s[i].StartTime==st)
            {
                if(s[i].assigned==false)
                {
                   System.out.println(st);
                   String stest="Slot availabe at "+s[i].StartTime;
                   t.setVisible(true);
                   t.print(stest);
                   
                  
                  //System.out.println("Slot availabe at"+s[i].StartTime);
                    
                    
                    /*str=str+"Slot availabe at"+s[i].StartTime;
                    ls.add(str);
                    String listString = "";
                    for (String s : ls) {
                        listString += s + "\n";
                    }
                    FileWriter writer = null;
                    try {
                        writer = new FileWriter("midPrint.txt");
                        writer.write(listString);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/
                    
                    
                    y=allocate(Subject_Name,st,s,i);
                    //ret=true;
                    flag=0;
                }
                if(y==false)
                {
                    //System.out.println("No slot available at ")
                    if(j==18)
                    {
                        j=9;
                        System.out.println("Sorry! Reached End of the day!");
                       
                    }
                    else
                    {
                        j++;
                        x=insert(Subject_Name,j);
                        
                    }
                     
                }
                
            }
                
        }
        if(y==true)
        {
            ret=true;
        }
        else
        {
            //System.out.println("Sorry! Required slot not available!");
            ret=false;
        }
       return(ret); 
    }
        boolean allocate(String Subject_Name, int st, Slots[] x, int i)
         {            
            System.out.println("allocate"+st);
             boolean ret;
             Scanner sc=new Scanner(System.in);
            // System.out.println("Do you want to take slot available from "+st+" to "+(st+1)+"?");
             //str=str+"Do you want to take slot available from "+st+" to "+(st+1)+"?";
             String j ="Do you want to take slot available from "+st+" to "+(st+1)+"?";
             t.print(j);
             /*try{
             Thread.sleep(10000);}
             catch(Exception e){
                 System.out.print("SSSLLLEEEEPPP");
             }*/
             //to give time for user
             /*try{
             TimeUnit.SECONDS.sleep(5);
             }
             catch (Exception ex){
                 System.out.print("ERROR!");
             }*/
             
             String catch1 = t.jTextField1.getText();
             
             //String catch1 = t.ret();
             System.out.println(catch1+"catch:");
             
             String y="yes";
             if(y.equals(catch1))
             {
                 //notify
                 x[i].SubjectCode=Subject_Name;
                 x[i].assigned=true;
                 x[i].notif=true;
                 System.out.println("Slot alloted!!");
                 ret=true;
                 
             }
             else
             {
                 ret=false;
             }
           return(ret);
    }
        
        ///delete func in day
Scanner sc=new Scanner(System.in);

    
    
    }
public class timetable {
    
   
    ttinsert slot;
        public static  Day[] d=new Day[6];
    public static void reset()
    {
        d[0].s[0].SubjectCode= "OS";
        d[0].s[0].assigned=true;
        d[0].s[0].notif=false;
        d[0].s[0].perm=true;
        
        d[0].s[1].SubjectCode= "SW";
        d[0].s[1].assigned=true;
        d[0].s[1].notif=false;
        d[0].s[1].perm=true;
        
        d[0].s[2].SubjectCode= "DAA";
        d[0].s[2].assigned=true;
        d[0].s[2].notif=false;
        d[0].s[2].perm=true;
        
        d[0].s[3].SubjectCode= "BREAK";
        d[0].s[3].assigned=true;
        d[0].s[3].notif=false;
        d[0].s[3].perm=true;
        
        d[0].s[4].SubjectCode= "*";
        d[0].s[4].assigned=false;
        d[0].s[4].notif=false;
        d[0].s[4].perm=false;
        
        d[0].s[5].SubjectCode= "DAA-L";
        d[0].s[5].assigned=true;
        d[0].s[5].notif=false;
        d[0].s[5].perm=true;
        
        d[0].s[6].SubjectCode= "DAA-L";
        d[0].s[6].assigned=true;
        d[0].s[6].notif=false;
        d[0].s[6].perm=true;
        
        d[0].s[7].SubjectCode= "*";
        d[0].s[7].assigned=false;
        d[0].s[7].notif=false;
        d[0].s[7].perm=false;
        
        d[0].s[8].SubjectCode= "*";
        d[0].s[8].assigned=false;
        d[0].s[8].notif=false;
        d[0].s[8].perm=false;
        
        //TUESDAY
        
         d[1].s[0].SubjectCode= "ITW";
        d[1].s[0].assigned=true;
        d[1].s[0].notif=false;
        d[1].s[0].perm=true;
        
        d[1].s[1].SubjectCode= "DAA";
        d[1].s[1].assigned=true;
        d[1].s[1].notif=false;
        d[1].s[1].perm=true;
        
        d[1].s[2].SubjectCode= "*";
        d[1].s[2].assigned=false;
        d[1].s[2].notif=false;
        d[1].s[2].perm=false;
        
        d[1].s[3].SubjectCode= "BREAK";
        d[1].s[3].assigned=true;
        d[1].s[3].notif=false;
        d[1].s[3].perm=true;
        
        d[1].s[4].SubjectCode= "SW";
        d[1].s[4].assigned=true;
        d[1].s[4].notif=false;
        d[1].s[4].perm=true;
        
        d[1].s[5].SubjectCode= "OS-L";
        d[1].s[5].assigned=true;
        d[1].s[5].notif=false;
        d[1].s[5].perm=true;
        
        d[1].s[6].SubjectCode= "OS-L";
        d[1].s[6].assigned=true;
        d[1].s[6].notif=false;
        d[1].s[6].perm=true;
       
        d[1].s[7].SubjectCode= "*";
        d[1].s[7].assigned=false;
        d[1].s[7].notif=false;
        d[1].s[7].perm=false;
        
        d[1].s[8].SubjectCode= "*";
        d[1].s[8].assigned=false;
        d[1].s[8].notif=false;
        d[1].s[8].perm=false;
        
        //WEDNESDAY
         d[2].s[0].SubjectCode= "DAA";
        d[2].s[0].assigned=true;
        d[2].s[0].notif=false;
        d[2].s[0].perm=true;
        
        d[2].s[1].SubjectCode= "DPP";
        d[2].s[1].assigned=true;
        d[2].s[1].notif=false;
        d[2].s[1].perm=true;
        
        d[2].s[2].SubjectCode= "SW";
        d[2].s[2].assigned=true;
        d[2].s[2].notif=false;
        d[2].s[2].perm=true;
        
        d[2].s[3].SubjectCode= "BREAK";
        d[2].s[3].assigned=true;
        d[2].s[3].notif=false;
        d[2].s[3].perm=true;
        
        d[2].s[4].SubjectCode= "*";
        d[2].s[4].assigned=false;
        d[2].s[4].notif=false;
        d[2].s[4].perm=false;
        
        d[2].s[5].SubjectCode= "*";
        d[2].s[5].assigned=false;
        d[2].s[5].notif=false;
        d[2].s[5].perm=false;
        
        d[2].s[6].SubjectCode= "*";
        d[2].s[6].assigned=false;
        d[2].s[6].notif=false;
        d[2].s[6].perm=false;
        
        d[2].s[7].SubjectCode= "*";
        d[2].s[7].assigned=false;
        d[2].s[7].notif=false;
        d[2].s[7].perm=false;
        
        d[2].s[8].SubjectCode= "*";
        d[2].s[8].assigned=false;
        d[2].s[8].notif=false;
        d[2].s[8].perm=false;
        
        //THURSDAY
        
        d[3].s[0].SubjectCode= "OS";
        d[3].s[0].assigned=true;
        d[3].s[0].notif=false;
        d[3].s[0].perm=true;
        
        d[3].s[1].SubjectCode= "SW";
        d[3].s[1].assigned=true;
        d[3].s[1].notif=false;
        d[3].s[1].perm=true;
        
        d[3].s[2].SubjectCode= "DPP";
        d[3].s[2].assigned=true;
        d[3].s[2].notif=false;
        d[3].s[2].perm=true;
        
        d[3].s[3].SubjectCode= "BREAK";
        d[3].s[3].assigned=true;
        d[3].s[3].notif=false;
        d[3].s[3].perm=true;
        
        d[3].s[4].SubjectCode= "HUL";
        d[3].s[4].assigned=true;
        d[3].s[4].notif=false;
        d[3].s[4].perm=true;
       
        d[3].s[5].SubjectCode= "ITW";
        d[3].s[5].assigned=true;
        d[3].s[5].notif=false;
        d[3].s[5].perm=true;
        
        d[3].s[6].SubjectCode= "ITW";
        d[3].s[6].assigned=true;
        d[3].s[6].notif=false;
        d[3].s[6].perm=true;
        
        d[3].s[7].SubjectCode= "DPP-L";
        d[3].s[7].assigned=true;
        d[3].s[7].notif=false;
        d[3].s[7].perm=true;
        
        d[3].s[8].SubjectCode= "DPP-L";
        d[3].s[8].assigned=true;
        d[3].s[8].notif=false;
        d[3].s[8].perm=true;
        
        //FRIDAY
        
        d[4].s[0].SubjectCode= "ITW";
        d[4].s[0].assigned=true;
        d[4].s[0].notif=false;
        d[4].s[0].perm=true;
        
        d[4].s[1].SubjectCode= "DPP";
        d[4].s[1].assigned=true;
        d[4].s[1].notif=false;
        d[4].s[1].perm=true;
        
        d[4].s[2].SubjectCode= "OS";
        d[4].s[2].assigned=true;
        d[4].s[2].notif=false;
        d[4].s[2].perm=true;
        
        d[4].s[3].SubjectCode= "BREAK";
        d[4].s[3].assigned=true;
        d[4].s[3].notif=false;
        d[4].s[3].perm=true;
        
        d[4].s[4].SubjectCode= "DAA";
        d[4].s[4].assigned=true;
        d[4].s[4].notif=false;
        d[4].s[4].perm=false;
        
        d[4].s[5].SubjectCode= "HUL";
        d[4].s[5].assigned=true;
        d[4].s[5].notif=false;
        d[4].s[5].perm=true;
        
        d[4].s[6].SubjectCode= "HUL";
        d[4].s[6].assigned=true;
        d[4].s[6].notif=false;
        d[4].s[6].perm=true;
        
        d[4].s[7].SubjectCode= "*";
        d[4].s[7].assigned=false;
        d[4].s[7].notif=false;
        d[4].s[7].perm=false;
        
        d[4].s[8].SubjectCode= "*";
        d[4].s[8].assigned=false;
        d[4].s[8].notif=false;
        d[4].s[8].perm=false;
    }
    
    public static void main() {
        // TODO code application logic here
        boolean ret=false;
        int flag=1;
        Scanner sc=new Scanner(System.in);
       // Day[] d=new Day[6];
        for(int i=0;i<6; i++)
        {
            d[i]= new Day();
       
        }
        // MONDAY
        /*d[0].s[0].SubjectCode= "OS";
        d[0].s[0].assigned=true;
        d[0].s[0].notif=false;
        d[0].s[0].perm=true;
        
        d[0].s[1].SubjectCode= "SW";
        d[0].s[1].assigned=true;
        d[0].s[1].notif=false;
        d[0].s[1].perm=true;
        
        d[0].s[2].SubjectCode= "DAA";
        d[0].s[2].assigned=true;
        d[0].s[2].notif=false;
        d[0].s[2].perm=true;
        
        d[0].s[3].SubjectCode= "BREAK";
        d[0].s[3].assigned=true;
        d[0].s[3].notif=false;
        d[0].s[3].perm=true;
        
        d[0].s[4].SubjectCode= "*";
        d[0].s[4].assigned=false;
        d[0].s[4].notif=false;
        d[0].s[4].perm=false;
        
        d[0].s[5].SubjectCode= "DAA LAB";
        d[0].s[5].assigned=true;
        d[0].s[5].notif=false;
        d[0].s[5].perm=true;
        
        d[0].s[6].SubjectCode= "DAA LAB";
        d[0].s[6].assigned=true;
        d[0].s[6].notif=false;
        d[0].s[6].perm=true;
        
        d[0].s[7].SubjectCode= "*";
        d[0].s[7].assigned=false;
        d[0].s[7].notif=false;
        d[0].s[7].perm=false;
        
        d[0].s[8].SubjectCode= "*";
        d[0].s[8].assigned=false;
        d[0].s[8].notif=false;
        d[0].s[8].perm=false;
        
        //TUESDAY
        
         d[1].s[0].SubjectCode= "ITW";
        d[1].s[0].assigned=true;
        d[1].s[0].notif=false;
        d[1].s[0].perm=true;
        
        d[1].s[1].SubjectCode= "DAA";
        d[1].s[1].assigned=true;
        d[1].s[1].notif=false;
        d[1].s[1].perm=true;
        
        d[1].s[2].SubjectCode= "*";
        d[1].s[2].assigned=false;
        d[1].s[2].notif=false;
        d[1].s[2].perm=false;
        
        d[1].s[3].SubjectCode= "BREAK";
        d[1].s[3].assigned=true;
        d[1].s[3].notif=false;
        d[1].s[3].perm=true;
        
        d[1].s[4].SubjectCode= "SW";
        d[1].s[4].assigned=true;
        d[1].s[4].notif=false;
        d[1].s[4].perm=true;
        
        d[1].s[5].SubjectCode= "OS LAB";
        d[1].s[5].assigned=true;
        d[1].s[5].notif=false;
        d[1].s[5].perm=true;
        
        d[1].s[6].SubjectCode= "OS LAB";
        d[1].s[6].assigned=true;
        d[1].s[6].notif=false;
        d[1].s[6].perm=true;
       
        d[1].s[7].SubjectCode= "*";
        d[1].s[7].assigned=false;
        d[1].s[7].notif=false;
        d[1].s[7].perm=false;
        
        d[1].s[8].SubjectCode= "*";
        d[1].s[8].assigned=false;
        d[1].s[8].notif=false;
        d[1].s[8].perm=false;
        
        //WEDNESDAY
         d[2].s[0].SubjectCode= "DAA";
        d[2].s[0].assigned=true;
        d[2].s[0].notif=false;
        d[2].s[0].perm=true;
        
        d[2].s[1].SubjectCode= "DPP";
        d[2].s[1].assigned=true;
        d[2].s[1].notif=false;
        d[2].s[1].perm=true;
        
        d[2].s[2].SubjectCode= "SW";
        d[2].s[2].assigned=true;
        d[2].s[2].notif=false;
        d[2].s[2].perm=true;
        
        d[2].s[3].SubjectCode= "BREAK";
        d[2].s[3].assigned=true;
        d[2].s[3].notif=false;
        d[2].s[3].perm=true;
        
        d[2].s[4].SubjectCode= "*";
        d[2].s[4].assigned=false;
        d[2].s[4].notif=false;
        d[2].s[4].perm=false;
        
        d[2].s[5].SubjectCode= "*";
        d[2].s[5].assigned=false;
        d[2].s[5].notif=false;
        d[2].s[5].perm=false;
        
        d[2].s[6].SubjectCode= "*";
        d[2].s[6].assigned=false;
        d[2].s[6].notif=false;
        d[2].s[6].perm=false;
        
        d[2].s[7].SubjectCode= "*";
        d[2].s[7].assigned=false;
        d[2].s[7].notif=false;
        d[2].s[7].perm=false;
        
        d[2].s[8].SubjectCode= "*";
        d[2].s[8].assigned=false;
        d[2].s[8].notif=false;
        d[2].s[8].perm=false;
        
        //THURSDAY
        
        d[3].s[0].SubjectCode= "OS";
        d[3].s[0].assigned=true;
        d[3].s[0].notif=false;
        d[3].s[0].perm=true;
        
        d[3].s[1].SubjectCode= "SW";
        d[3].s[1].assigned=true;
        d[3].s[1].notif=false;
        d[3].s[1].perm=true;
        
        d[3].s[2].SubjectCode= "DPP";
        d[3].s[2].assigned=true;
        d[3].s[2].notif=false;
        d[3].s[2].perm=true;
        
        d[3].s[3].SubjectCode= "BREAK";
        d[3].s[3].assigned=true;
        d[3].s[3].notif=false;
        d[3].s[3].perm=true;
        
        d[3].s[4].SubjectCode= "HUL";
        d[3].s[4].assigned=true;
        d[3].s[4].notif=false;
        d[3].s[4].perm=true;
       
        d[3].s[5].SubjectCode= "ITW";
        d[3].s[5].assigned=true;
        d[3].s[5].notif=false;
        d[3].s[5].perm=true;
        
        d[3].s[6].SubjectCode= "ITW";
        d[3].s[6].assigned=true;
        d[3].s[6].notif=false;
        d[3].s[6].perm=true;
        
        d[3].s[7].SubjectCode= "DPP LAB";
        d[3].s[7].assigned=true;
        d[3].s[7].notif=false;
        d[3].s[7].perm=true;
        
        d[3].s[8].SubjectCode= "DPP LAB";
        d[3].s[8].assigned=true;
        d[3].s[8].notif=false;
        d[3].s[8].perm=true;
        
        //FRIDAY
        
        d[4].s[0].SubjectCode= "ITW";
        d[4].s[0].assigned=true;
        d[4].s[0].notif=false;
        d[4].s[0].perm=true;
        
        d[4].s[1].SubjectCode= "DPP";
        d[4].s[1].assigned=true;
        d[4].s[1].notif=false;
        d[4].s[1].perm=true;
        
        d[4].s[2].SubjectCode= "OS";
        d[4].s[2].assigned=true;
        d[4].s[2].notif=false;
        d[4].s[2].perm=true;
        
        d[4].s[3].SubjectCode= "BREAK";
        d[4].s[3].assigned=true;
        d[4].s[3].notif=false;
        d[4].s[3].perm=true;
        
        d[4].s[4].SubjectCode= "DAA";
        d[4].s[4].assigned=true;
        d[4].s[4].notif=false;
        d[4].s[4].perm=false;
        
        d[4].s[5].SubjectCode= "HUL";
        d[4].s[5].assigned=true;
        d[4].s[5].notif=false;
        d[4].s[5].perm=true;
        
        d[4].s[6].SubjectCode= "HUL";
        d[4].s[6].assigned=true;
        d[4].s[6].notif=false;
        d[4].s[6].perm=true;
        
        d[4].s[7].SubjectCode= "*";
        d[4].s[7].assigned=false;
        d[4].s[7].notif=false;
        d[4].s[7].perm=false;
        
        d[4].s[8].SubjectCode= "*";
        d[4].s[8].assigned=false;
        d[4].s[8].notif=false;
        d[4].s[8].perm=false;*/
        reset();
        
    
   int k,l;
   for(k=0;k<6;k++)
   {
       System.out.print(d[k].DayName+"\t    ");
   }
   
   for(k=0;k<9;k++)
   {
      System.out.println(""); 
     for(l=0;l<6;l++)
       {
         System.out.print(d[l].s[k].SubjectCode+"\t\t");
       }
   }
    //void insert()
    System.out.println();
    System.out.println("INSERTION");
    System.out.println("Enter Day Name: ");
    String day=sc.next();
    System.out.println("Enter name of Subject: ");
    String subj=sc.next();
    System.out.println("Enter Start Time of slot you want: ");
    int st=sc.nextInt();
    for (int i=0;i<6&&flag==1;i++)
    {
        //System.out.println("abc");
        if((d[i].DayName).equals(day))
        {
            //System.out.println("abc");
            ret=d[i].insert(subj, st);
            flag=0;
        }
    }
    print(d);
   //if(d[i].slo)
   System.out.println();
   System.out.println("DELETION");
   /*System.out.println("Do you want to cancel the class?");
   String want=sc.next();
   if(want.equals("yes"))
   {*/  System.out.println("name of subject");
      String subname=sc.next();
      System.out.println("name of day");
      String dayp=sc.next();
      int time=0;
      for (int i=0;i<6&&flag==1;i++)///searching day name and the call delete 
    {
        //System.out.println("abc");
        if((d[i].DayName).equals(dayp))
        {
            //System.out.println("abc");
            deletep(subname,time,i);
           flag=0;
        }
    }
   
    print(d);
   
  }  
   public static void deletep(String subname, int st, int i)
    { 
      int k;
     // int st;
      //System.out.println("Enter Start Time of slot: ");
      //st=sc.nextInt();
      for(k=0;k<9;k++)
      {
         if(d[i].s[k].SubjectCode.equals(subname) && d[i].s[k].StartTime==st){
             d[i].s[k].assigned=false;
             d[i].s[k].SubjectCode="*";
             d[i].s[k].notif=true;
         }
                    
      }
    }
    public static void print(Day[] d) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             List<String> ls = new ArrayList<String>();
            String str="";
             for(int k=0;k<6;k++)
             {
                    //System.out.print(d[k].DayName+"\t    ");
                    str=str+d[k].DayName+"\t";
                    //ls.add(str); 
             }
             ls.add(str);
             str="\n";
                for(int k=0;k<9;k++)
                {
                   System.out.println(""); 
                  for(int l=0;l<6;l++)
                    {
                      //System.out.print(d[l].s[k].SubjectCode+"\t\t");
                        str=str+d[l].s[k].SubjectCode+"\t";
                        //ls.add(str); 
                    }
                    ls.add(str);
                    str="\n";
                }
                String listString = "";
    for (String s : ls) {
        listString += s + "\n";
    }
        FileWriter writer = null;
    try {
        writer = new FileWriter("ttPrint.txt");
        writer.write(listString);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
            }
    
}
