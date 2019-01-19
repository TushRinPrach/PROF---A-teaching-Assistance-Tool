/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prof;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ankul
 */
class Ideal
{
   
    private int Sem_Academics[]=new int[8];
    private int Sem_Hostel_Mess[]=new int[8];
    Ideal()
    {
       
       Sem_Academics[0]=59000;
       Sem_Academics[1]=59000;
       Sem_Academics[2]=59000;
        Sem_Academics[3]=59000;
        Sem_Academics[4]=59000;
        Sem_Academics[5]=59000;
        
        Sem_Academics[6]=59000;
        Sem_Academics[7]=59000;
        
        Sem_Hostel_Mess[0]=40000;
        Sem_Hostel_Mess[1]=40000;
        Sem_Hostel_Mess[2]=40000;
        Sem_Hostel_Mess[3]=40000;
        Sem_Hostel_Mess[4]=40000;
        Sem_Hostel_Mess[5]=40000;
        Sem_Hostel_Mess[6]=40000;
        Sem_Hostel_Mess[7]=40000;
    }
    
    int get_Academic_fees(int i)
    {
        return(Sem_Academics[i]);
    }
    
    int get_Hostel_fees(int i)
    {
        return(Sem_Hostel_Mess[i]);
    }
    
      public void Information_Broucher()
        {
            //System.out.println("INFORMATION BROUCHER");
             List<String> ls = new ArrayList<String>();
             String str = "";
             str=str+"INFORMATION BROUCHER: ";
             ls.add(str);
             str=str+"\n";
             str="";
            //System.out.println();
            //System.out.println("    \tAcademics\tHostel and Mess");
            str=str+"    \tAcademics\t\tHostel and Mess";
             ls.add(str);
             str=str+"\n";
             str="";
            for(int i=0;i<8;i++)
            {
                //System.out.println("Sem"+(i+1)+"\t"+Sem_Academics[i]+"\t\t"+Sem_Hostel_Mess[i]);
                str=str+"Sem"+(i+1)+"\t"+Sem_Academics[i]+"\t\t"+Sem_Hostel_Mess[i];
                 ls.add(str);
                str=str+"\n";
                str="";
            }
              String listString = "";
           for (String s : ls) {
        listString += s + "\n";
    }
        FileWriter writer = null;
    try {
        writer = new FileWriter("Information_Broucher.txt");
        writer.write(listString);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    } 
            
            
        }
    
    
            
}

 class Account_Details
    {
       
       private int Sem[][]=new int[8][2];
       private int balance[][]=new int[8][2];
       boolean balance_flag;
       
       Account_Details()
       {
           System.out.println("Hii!!!");
           for(int i=0;i<8;i++)
           {
               for(int j=0;j<2;j++)
               {
                   Sem[i][j]=0;
                   balance[i][j]=0;
               }
           }
           balance_flag=false;
           //or either fetch from database
       }
       public int get(int x,int c)
       {
           return(Sem[x][c]);
       }
       public void set(int s0a, int s0h, int s1a,int s1h, int s2a,int s2h, int s3a, int s3h, int s4a, int s4h, int s5a, int s5h, int s6a, int s6h, int s7a, int s7h)
       {
           Sem[0][0]=s0a;
           Sem[0][1]=s0h;
           Sem[1][0]=s1a;
           Sem[1][1]=s1h;
           Sem[2][0]=s2a;
           Sem[2][1]=s2h;
           Sem[3][0]=s3a;
           Sem[3][1]=s3h;
           Sem[4][0]=s4a;
           Sem[4][1]=s4h;
           Sem[5][0]=s5a;
           Sem[5][1]=s5h;
           Sem[6][0]=s6a;
           Sem[6][1]=s6h;
           Sem[7][0]=s7a;
           Sem[7][1]=s7h;
           
           
       }
       public void set_balance(int s, int c,int bal)
       {
           if(bal>0)
           {
               balance_flag=true;
           }
           balance[s][c]=bal;
       }
       public int get_balance(int s, int c)
       {
           return(balance[s][c]);
       }
       //public int get(int i)
    }

     class Student
    {
        Scanner sc=new Scanner(System.in);
        public String EnrollmentID;
        public String Name;
        boolean Hostelite;
        public Account_Details X=new Account_Details();
        Ideal ideal=new Ideal();
        public boolean x;
        public int Current=4;
        FileWriter writer = null;
        
        Student()
        {
            //System.out.println("Enter Name: ");
            //Name=sc.next();
            
            try {
                writer = new FileWriter("Balance_Enquiry_List.txt");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
           
        }
        public void Account_Detail_Search(String ID)
        {
             List<String> ls = new ArrayList<String>();
             String str = "";
            //System.out.println(Name);
            str=str+"Student Name: "+ Name+"\n";
            //System.out.println(EnrollmentID);
            str=str+"Enrollment ID: "+EnrollmentID+"\n";
            ls.add(str);
            str="";
                int h;
                if(Hostelite==false)
                {
                    h=0;
                    //System.out.println("Academic fees: ");
                    str=str+"Academic fees: ";
                    ls.add(str);
                    str="";
                    
                    for(int i=0;i<Current;i++)
                    {
                        //XXX System.out.println("Sem"+(i+1)+":\t"+X.get(i, 0)+"\t");
                        str=str+"Sem"+(i+1)+":\t"+X.get(i, 0)+"\t";
                        str=str+"\n";
                        ls.add(str);
                        str="";
                        //Balance(i,Hostelite);
                    }
                }
                else
                {
                    h=1;
                    //System.out.println("\tAcademic fees\tHostel Fee");
                    str="";
                    str=str+"\tAcademic fees\t\tHostel Fee";
                    ls.add(str);
                    str=str+"\n";
                    str="";
                    for(int i=0;i<Current;i++)
                    {
                       
                            //System.out.println("Sem"+(i+1)+":\t"+X.get(i,0)+"\t\t"+X.get(i, 1)+"\t");
                            str=str+"Sem"+(i+1)+":\t"+X.get(i,0)+"\t\t"+X.get(i, 1)+"\t";
                            ls.add(str);
                            str=str+"\n";
                            str="";
                              // Balance(i,Hostelite);
                        
                    }  
                    
                }
                 String listString = "";
    for (String s : ls) {
        listString += s + "\n";
    }
        FileWriter writer = null;
    try {
        writer = new FileWriter("CompleteAccountDetail.txt");
        writer.write(listString);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
              /*  System.out.println("Want to enquire about Balance? Y/N");
             String resp=sc.nextLine();
             if(resp.equals("Y"));
             {
                 if(h==0)
                 {
                      System.out.println("Balance Enquiry:\t Academics");
                      for(int i=0;i<Current;i++)
                      {
                           System.out.println("Sem"+(i+1)+":\t\t\t\t"+X.get_balance(i,h));
                      }
                    
                 }
                 if(h==1)
                 {
                     System.out.println("Balance Enquiry:\t Academics\tHostel and Mess");
                     for(int i=0;i<Current;i++)
                     {
                         System.out.println("Sem"+(i+1)+":\t\t\t\t"+X.get_balance(i,0)+"\t\t"+X.get_balance(i,1));
                         
                     }
                     
                 }
                
             }*/
               
        }
        public void Semester_Details(String ID,int sem)
        {
             //System.out.println(Name);
            //System.out.println(EnrollmentID);
             List<String> ls = new ArrayList<String>();
             String str = "";
            //System.out.println(Name);
            str=str+"Student Name: "+ Name+"\n";
            //System.out.println(EnrollmentID);
            str=str+"Enrollment ID: "+EnrollmentID+"\n";
            ls.add(str);
            str="";
            int h;
             if(Hostelite==false)
             {
                 h=0;
                 if(sem<=Current)
                 {
                    // System.out.println("Academic fees: ");
                     str=str+"Academic fees: ";
                     
                     ls.add(str);
                     str=str+"\n";
                     str="";
                    // System.out.println("Sem"+sem+":\t"+X.get(sem-1, 0));
                    str=str+"Sem"+sem+":\t"+X.get(sem-1, 0);
                    ls.add(str);
                    str=str+"\n";
                    str="";
                     //Balance(sem-1,Hostelite);
                 }
                 else
                 {
                     //System.out.println("Semester  yet to come!!");
                     str=str+"Semester  yet to come!!";
                 }
                 
             }
             else
             {
                 h=1;
                 if(sem<=Current)
                 {
                      //System.out.println("\tAcademic fees\tHostel Fee");
                      str=str+"\tAcademic fees\t\tHostel Fee";
                       ls.add(str);
                    str=str+"\n";
                    str="";
                     // System.out.println("Sem"+sem+":\t"+X.get(sem-1,0)+"\t\t"+X.get(sem-1, 1));
                     str=str+"Sem"+sem+":\t"+X.get(sem-1,0)+"\t\t"+X.get(sem-1, 1);
                      ls.add(str);
                    str=str+"\n";
                    str="";
                      //Balance(sem,Hostelite);
                 }
                 else
                 {
                     str=str+"Semester  yet to come!!";
                 }
             }
            /* System.out.println("Want to enquire about Balance? Y/N");
             String resp=sc.nextLine();
             if(resp.equals("Y"));
             {
                 if(h==0)
                 {
                      System.out.println("Balance Enquiry:\t Academics");
                     System.out.println("Sem"+sem+":\t\t\t\t"+X.get_balance(sem-1,h));
                 }
                 if(h==1)
                 {
                     System.out.println("Balance Enquiry:\t Academics\tHostel and Mess");
                     System.out.println("Sem"+sem+":\t\t\t\t"+X.get_balance(sem-1,0)+"\t\t"+X.get_balance(sem-1,1));
                 }
                
             }*/
            
                      String listString = "";
    for (String s : ls) {
        listString += s + "\n";
    }
        FileWriter writer = null;
    try {
        writer = new FileWriter("Semester_wise_Detail.txt");
        writer.write(listString);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
            
             
             
        }
        public void make_Balance(int sem, boolean x)
        {
            if(x==true)
            {
                int balance_Academics=ideal.get_Academic_fees(sem)-X.get(sem,0);
                int balance_Hostel=ideal.get_Hostel_fees(sem)-X.get(sem, 1);
               /* if(balance_Academics!=0)
                {
                    //System.out.println("Balance in Sem"+(sem+1));
                    // System.out.println("\t\tAcademics: "+balance_Academics);
                }
                if(balance_Hostel!=0)
                {
                    //System.out.println("Balance in Sem"+(sem+1));
                     //System.out.println("\t\t Hostel and mess: "+balance_Hostel);
                }*/
               X.set_balance(sem,0,balance_Academics);
               X.set_balance(sem,1,balance_Hostel);
                
                
                
            }
            else
            {
                int balance_Academics=ideal.get_Academic_fees(sem)-X.get(sem,0);
                 X.set_balance(sem,0,balance_Academics);
                 X.set_balance(sem,1,0);
        }
        
        
    }
        public void Balance_Enquiry()
        {
            List<String> ls = new ArrayList<String>();
             String str = "";
              str=str+"Student Name: "+ Name+"\n";
            //System.out.println(EnrollmentID);
            str=str+"Enrollment ID: "+EnrollmentID+"\n";
            ls.add(str);
            str="";
             
             
            if(Hostelite==false)
                 {
                      //System.out.println("Balance Enquiry:\t Academics");
                     str=str+"Balance Enquiry:\t Academics";
                        ls.add(str);
                    str=str+"\n";
                    str="";
                      for(int i=0;i<Current;i++)
                      {
                           //System.out.println("Sem"+(i+1)+":\t\t\t\t"+X.get_balance(i,0));
                          str=str+"Sem"+(i+1)+":\t\t"+X.get_balance(i,0);
                             ls.add(str);
                            str=str+"\n";
                            str="";
                      }
                    
                 }
                 if(Hostelite==true)
                 {
                    // System.out.println("Balance Enquiry:\t Academics\tHostel and Mess");
                     str=str+"Balance Enquiry:\t Academics\tHostel and Mess";
                      ls.add(str);
                            str=str+"\n";
                            str="";
                     for(int i=0;i<Current;i++)
                     {
                         //System.out.println("Sem"+(i+1)+":\t\t\t\t"+X.get_balance(i,0)+"\t\t"+X.get_balance(i,1));
                         str=str+"Sem"+(i+1)+":\t\t"+X.get_balance(i,0)+"\t"+X.get_balance(i,1);
                            ls.add(str);
                            str=str+"\n";
                            str="";
                         
                     }
                 }
                 
    String listString = "";
    for (String s : ls) {
        listString += s + "\n";
    }
        FileWriter writer = null;
    try {
        writer = new FileWriter("Balance_Enquiry.txt");
        writer.write(listString);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
                 
                 
                 
                 
        }
      
        
        
            /*    public void Balance_Enquiry_list()
        {
            List<String> ls = new ArrayList<String>();
             String str = "";
              str=str+"Student Name: "+ Name+"\n";
            //System.out.println(EnrollmentID);
            str=str+"Enrollment ID: "+EnrollmentID+"\n";
            ls.add(str);
            str="";
             
             
            if(Hostelite==false)
                 {
                      //System.out.println("Balance Enquiry:\t Academics");
                     str=str+"Balance Enquiry:\t Academics";
                        ls.add(str);
                    str=str+"\n";
                    str="";
                      for(int i=0;i<Current;i++)
                      {
                           //System.out.println("Sem"+(i+1)+":\t\t\t\t"+X.get_balance(i,0));
                          str=str+"Sem"+(i+1)+":\t\t"+X.get_balance(i,0);
                             ls.add(str);
                            str=str+"\n";
                            str="";
                      }
                    
                 }
                 if(Hostelite==true)
                 {
                    // System.out.println("Balance Enquiry:\t Academics\tHostel and Mess");
                     str=str+"Balance Enquiry:\t Academics\tHostel and Mess";
                      ls.add(str);
                            str=str+"\n";
                            str="";
                     for(int i=0;i<Current;i++)
                     {
                         //System.out.println("Sem"+(i+1)+":\t\t\t\t"+X.get_balance(i,0)+"\t\t"+X.get_balance(i,1));
                         str=str+"Sem"+(i+1)+":\t\t"+X.get_balance(i,0)+"\t"+X.get_balance(i,1);
                            ls.add(str);
                            str=str+"\n";
                            str="";
                         
                     }
                 }
                 
    String listString = "";
    for (String s : ls) {
        listString += s + "\n";
    }
        try{
        writer.write(listString);
        writer.close();
    } catch (IOException e) {
      //  e.printStackTrace();
    }
                 
                 
                 
                 
        }*/

      
   }
public class accounts {
    
    
     public static void main() {
      
        Ideal idl=new Ideal();
        Scanner sc=new Scanner(System.in);
        Student[] s1=new Student[3];
        //String ID;
        int flag=1,s;
        for(int i=0;i<3;i++)
        {
            s1[i]=new Student();
        }
       try
     {
    
            //CONECCTION TO DATABASE!!!!
            String myDriver ="com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost:3306/trial?zeroDateTimeBehavior=convertToNull";

            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(myUrl, "root", "wh@tthehell!");
      
      
            
            
            
            
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM new_trial";

            // create the java statement
            Statement st = conn.createStatement();
   
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      int j=0;
            while (rs.next())
            {
              //int id = rs.getInt("id");
              //String Studentx;
              //int IDx= rs.getInt("StudentID");
              
             // int Sem2x= rs.getInt("Sem2");
              /*Date dateCreated = rs.getDate("date_created");
              boolean isAdmin = rs.getBoolean("is_admin");
              int numPoints = rs.getInt("num_points");*/

              // print the results
              //System.out.format("%s, %d, %d", Studentx, Sem1x, Sem2x);
              s1[j].Name=rs.getString("Student");
              s1[j].EnrollmentID=rs.getString("StudentID");
              if(rs.getInt("Type")==0)
              {
                  s1[j].Hostelite=false;
              }
              else
              {
                  s1[j].Hostelite=true;
              }
              s1[j].X.set(rs.getInt("Sem1(A)"), rs.getInt("Sem1(H)"),rs.getInt("Sem2(A)"),rs.getInt("Sem2(H)"),rs.getInt("Sem3(A)"),rs.getInt("Sem3(H)"),rs.getInt("Sem4(A)"),rs.getInt("Sem4(H)"),rs.getInt("Sem5(A)"),rs.getInt("Sem5(H)"),rs.getInt("Sem6(A)"),rs.getInt("Sem6(H)"),rs.getInt("Sem7(A)"),rs.getInt("Sem7(H)"),rs.getInt("Sem8(A)"),rs.getInt("Sem8(H)"));
              //System.out.format( "%d", Sem1x);
              //System.out.println();
              j++;
            }
            st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
       for (int i=0;i<3;i++)
       {
           System.out.println(" "+ s1[i].Name);
           for(int j=0;j<8;j++)
           {
               s1[i].make_Balance(j, s1[i].Hostelite);
               
           }
           
       }
     }
}
       /*for(int i=0;i<3;i++)
       {
           System.out.println(" "+ s1[i].Name);
           for(int j=0;j<8;j++)
           {
               for(int k=0;k<2;k++)
               {
                   if(k==0)
                   {
                       System.out.print("A: ");
                       System.out.println("Sem"+(j+1)+":  "+ s1[i].X.get(j,k));
                   }
                   else
                   {
                        System.out.print("H: ");
                       System.out.println("Sem"+(j+1)+":  "+ s1[i].X.get(j,k));

                   }
                   
               }
                
           }
       }*/
       
      
       
      
      
       
       /*String check="Y";
      while(check.equals("Y"))
      {
       
       System.out.println("Press:");
       System.out.println("1.Account Deatails of a Student.");
       System.out.println("2.Account Detail of a particular Semester.");
       System.out.println("3.Balance Enquiry.");
       System.out.println("4.Balance Enquiry List and Details.");
       System.out.println("5.Information Broucher.");
      
       int x=sc.nextInt();
       switch(x)
       {
           case 1:*/
                
             /*Commented on 15/04 00:35   System.out.println();
                System.out.println("1. For getting Account Deatails of a Student.");
                        
                System.out.println("Enter ID of Student: ");
                String ID=sc.nextLine();
                 flag=1;
                for(int i=0;i<s1.length&&flag==1;i++)//change name to ID
                {
                    if(s1[i].EnrollmentID.equals(ID))
                    {
                        flag=0;
                        s1[i].Account_Detail_Search(ID);
                    }
                }
            if(flag==1)
                {
                    System.out.println("ID didn't match!!");
                }
                flag=1;
               // break;
                
          // case 2:
          
                System.out.println();
                System.out.println("2. For getting Account Detail of a particular Semester.");
               System.out.println("Enter ID of Student: ");
                 String ID1=sc.nextLine();
                 flag=1;
                System.out.println("Enter Semester no: ");
                
                s=sc.nextInt();
                for(int i=0;i<s1.length&&flag==1;i++)//change name to ID
                {
                    if(s1[i].EnrollmentID.equals(ID1))
                    {
                        flag=0;
                        s1[i].Semester_Details(ID1,s);
                    }
                }
                if(flag==1)
                {
                    System.out.println("ID didn't match!!");
                }
                flag=1;
              //  break;
            
          // case 3:
                
                System.out.println();
                 System.out.println("3.Balance Enquiry.");
                System.out.println("Enter ID of Student: ");
                String ID2=sc.next();
                int flag2=1;
                //System.out.println("Enter Semester no: ");
                 //s=sc.nextInt();
                for(int i=0;i<s1.length&&flag2==1;i++)//change name to ID
                {
                    if(s1[i].EnrollmentID.equals(ID2))
                    {
                        flag2=0;
                        System.out.println(s1[i].Name);
                        s1[i].Balance_Enquiry();
                    }
                }
                if(flag2==1)
                {
                    System.out.println("ID didn't match!!"); 
                }
                flag2=1;
              //  break;
            
           //case 4:
                     System.out.println();
                      System.out.println("4.Balance Enquiry List and Details.");
                    for(int i=0;i<3;i++)
                    {
                        if(s1[i].X.balance_flag==true)
                        {
                            System.out.println(s1[i].Name);
                            s1[i].Balance_Enquiry();
                        }
                    }
                    
                //    break;
                    
          // case 5:
                     System.out.println();
                    System.out.println("5.Information Broucher.");
                    idl.Information_Broucher();
                //    break;
                    
          

     //  }
       //System.out.println("Do you want to continue? Y/N");
       //check=sc.nextLine();
       
   // }
    
    }
    
}*/
