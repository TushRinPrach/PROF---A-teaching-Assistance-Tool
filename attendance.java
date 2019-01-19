/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prof;
import java.util.Scanner;

/**
 *
 * @author Ankul
 */
public class attendance {
     
        static int lect=5;
    public static class student{
        int id;
        String name;
       subject[] sub=new subject[5];
        student(int id,String nam)
        {
            this.id=id;
            this.name=nam;
             for(int i=0;i<5;i++)
            {
                //System.out.println("subject:"+i);
                sub[i]=new subject();
            }
        }
        void present(String sbname,int j)
        {int i=0,t=1;
         while(t==1)
         { System.out.println("hello"+i);
           System.out.println("name:"+sub[i].subname);
             if(sub[i].subname.equals(sbname)) 
           { System.out.println("hello"+i);
            sub[i].count[j]=1;System.out.println("done present");t=0;
            /*for(int k=0;k<5;k++)
            { //System.out.println("subject:"+i);
             //System.out.println(k+"-"+sub[i].count[k]);
            }*/
           }System.out.println("bhago");
          i++;
         }  
        }
        
        public  int attend(String sbname,int total ){
            int i=0,t=1;
            int percentage=0;
         while(t==1)
         {  if(sub[i].subname.equals(sbname)) 
           {
            int cd=0,k; t=0;
            for(k=0;k<lect;k++)
            {
                cd=cd+sub[i].count[k];
            }
             percentage = cd/total;
            return(percentage);
           }
          i++;
         } 
         return(percentage);
        }
        /*void absent(int i,int j){
            sub[i].count[j]=0;System.out.println("done present");

        }*/
    }
     
    public static class subject{
        int[] count=new int[lect];
        double percentage;
        int sb=0;
        String subname;
        subject(){
            int i;percentage=0;
            for(i=0;i<lect;i++){count[i]=0;
            //System.out.println(i+"-"+count[i]);
            } 
            //if(sb==0){subname="DAA";}
            if(sb==0){subname="DAA";}
            else if(sb==1){subname="ITW";}
            else if(sb==2){subname="OS";}
            else if(sb==3){subname="DPPL";}
            else if(sb==4){subname="SW";}
            sb++;
        }
    }
    public  String print(){
        String t="hello";
        return(t);
    }
    
    
    
    public static void main(){
        
    
        Scanner sc=new Scanner(System.in);
        student[] cs=new student[3];
       
       
        cs[0]=new student(1,"parth");
        cs[1]=new student(2,"mayur");
        cs[2]=new student(3,"divyesh");
        char con='y';
        while(con=='y' )
        {
           System.out.println("give subcode:");
           String s=sc.next();
           System.out.println("lecture no:");
           int lecno=sc.nextInt();
           for(int i=0;i<cs.length;i++)
          {
            System.out.println(cs[i].name+"is present?");
            int p = sc.nextInt();
            if(p==1)
            {
                cs[i].present(s,lecno);
            }
          }
           System.out.println("do you want to continue");
           con=sc.next().charAt(0);
        }
        System.out.println("for how many lectures do you want percentage");
        int var = sc.nextInt();
        System.out.println("give subcode:");
          String s=sc.next();
        int j;
        int i=0,t=1;
         while(t==1)
         {  if(cs[i].sub[i].subname.equals(s)) 
           {
            t=0;
           }
          i++;
         }  
        for( j=0;j<cs.length;j++)
        {
            
            cs[j].sub[i].percentage=cs[j].attend(s,var);
        }
       
    
        
    }
}
