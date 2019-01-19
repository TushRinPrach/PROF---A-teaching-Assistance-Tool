/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prof;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;

import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.JScrollPane;
/**
 *
 * @author Ankul
 */
class PrintJobWatcher {
  boolean done = false;

  PrintJobWatcher(DocPrintJob job) {
    job.addPrintJobListener(new PrintJobAdapter() {
      public void printJobCanceled(PrintJobEvent pje) {
        allDone();
      }
      public void printJobCompleted(PrintJobEvent pje) {
        allDone();
      }
      public void printJobFailed(PrintJobEvent pje) {
        allDone();
      }
      public void printJobNoMoreEvents(PrintJobEvent pje) {
        allDone();
      }
      void allDone() {
        synchronized (PrintJobWatcher.this) {
          done = true;
          System.out.println("Printing done ...");
          PrintJobWatcher.this.notify();
        }
      }
    });
  }
  public synchronized void waitForDone() {
    try {
      while (!done) {
        wait();
      }
    } catch (InterruptedException e) {
    }
  }
}
public class accFrame extends javax.swing.JFrame {

    /**
     * Creates new form accFrame
     */
    accounts acc;
    Student s1[];
    Ideal idl;
    String filename;
    public accFrame()
    {
        initComponents();
        this.setLocationRelativeTo(null);
        jLabel4.setVisible(false);
        jLabel2.setVisible(false);
        jTextField2.setVisible(false);
        jTextField1.setVisible(false);
        jButton7.setVisible(false);//Below ONe
        jButton8.setVisible(false);//Upper one
        jButton11.setVisible(false);
        jTextField3.setVisible(false);
        jButton10.setVisible(false);
        acc=new accounts();
        //acc.main();
        idl=new Ideal();
        Scanner sc=new Scanner(System.in);
        s1=new Student[3];
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jButton6.setText("jButton6");

        jLabel3.setText("jLabel3");

        jScrollPane1.setViewportView(jTextPane1);

        jButton9.setText("Submit!");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(650, 450));

        jPanel1.setLayout(null);

        jButton1.setText("Complete Account Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(30, 40, 180, 50);

        jButton2.setText("Semester-wise Account Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(30, 120, 180, 50);

        jButton3.setText("Balance Enquiry");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(30, 210, 180, 50);

        jButton4.setText("Generate List");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(30, 290, 180, 50);

        jButton5.setText("Information Broucher");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(30, 370, 180, 50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ACCOUNTS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(260, 10, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Semester No:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(270, 90, 110, 30);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(400, 90, 130, 30);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(400, 50, 120, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enrollment ID:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(270, 50, 110, 30);

        jButton7.setText("Submit!");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(540, 90, 100, 30);

        jButton8.setText("Submit!");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(540, 50, 100, 30);

        jTextField3.setEditable(false);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(270, 140, 360, 260);

        jButton11.setText("Submit this!");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(540, 50, 100, 30);

        jButton10.setText("Print");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(310, 410, 70, 30);

        jButton12.setText("Menu");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12);
        jButton12.setBounds(520, 410, 70, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon("H:\\SEM 4\\ITW\\PROF\\235493381-wallpaper-backgrounds-blue.jpg")); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 700, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        List<String> ls = new ArrayList<String>();
             String str = "";
        jLabel4.setVisible(false);
        jLabel2.setVisible(false);
        jTextField2.setVisible(false);
        jTextField1.setVisible(false);
        jButton7.setVisible(false);//Below ONe
        jButton8.setVisible(false);//Upper one
        jTextField3.setVisible(false);
         jButton11.setVisible(false);
         jButton10.setVisible(true);
         for(int i=0;i<3;i++)
                    {
                        if(s1[i].X.balance_flag==true)
                        {
                            //System.out.println(s1[i].Name);
                           // s1[i].Balance_Enquiry_list();
                            str=str+s1[i].Name;
                            //str=str+"Sem"+(i+1)+":\t\t"+X.get_balance(i,0);
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
        writer = new FileWriter("Balance_Enquiry_list.txt");
        writer.write(listString);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
        jTextField3.setVisible(true);
      try
    { 
    //String filetext="",filecontent="";

    //File file=new File("C:\\Users\\Ankul\\Documents\\NetBeansProjects\\TrialFile\\final.txt");
     filename="C:\\Users\\Ankul\\Documents\\NetBeansProjects\\prof\\Balance_Enquiry_List.txt";
    FileReader fr=new FileReader(filename);
    BufferedReader br=new BufferedReader(fr);
    /*StringBuilder sb=new StringBuilder();
    while(fr !=null)
    {
           filetext=br.readLine();
           sb.append(filetext);
           sb.append("\n");
    }
    filecontent=sb.toString();
    //JOptionPane.showMessageDialog(null,"File is"+filecontent);*/
     jTextField3.read(br, null);
     br.close();
     jTextField3.requestFocus();
//     flag=1;
    //JScrollPane scrollPane =new JScrollPane(jTextField3);
    }
    catch(Exception ex){
    System.out.print("hi i am error");
    System.out.println(ex);
    }
         
        
                                         

     
         
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int flag=1;
        jLabel4.setVisible(true);
        jLabel2.setVisible(false);
        jTextField2.setVisible(true);
        jTextField1.setVisible(false);
        jButton8.setVisible(true);
        jButton7.setVisible(false);//Below ONe
         jButton11.setVisible(false);
         jButton10.setVisible(true);
       
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jLabel4.setVisible(true);
        jLabel2.setVisible(true);
        jTextField2.setVisible(true);
        jTextField1.setVisible(true);
        jButton7.setVisible(true);//Below ONe
        jButton8.setVisible(false);//Upper one
        jTextField3.setVisible(false);
         jButton11.setVisible(false);
         jButton10.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jLabel4.setVisible(true);
        jLabel2.setVisible(false);
        jTextField2.setVisible(true);
        jTextField1.setVisible(false);
        jButton8.setVisible(false);
        jButton7.setVisible(false);//Below ONe
        jButton11.setVisible(true);
        jTextField3.setVisible(false);
         //jButton9.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jLabel4.setVisible(false);
        jLabel2.setVisible(false);
        jTextField2.setVisible(false);
        jTextField1.setVisible(false);
        jButton7.setVisible(false);//Below ONe
        jButton8.setVisible(false);//Upper one
        jTextField3.setVisible(false);
         jButton11.setVisible(false);
          idl.Information_Broucher();
           jTextField3.setVisible(true);
             try
    { 
    //String filetext="",filecontent="";

    //File file=new File("C:\\Users\\Ankul\\Documents\\NetBeansProjects\\TrialFile\\final.txt");
    filename="C:\\Users\\Ankul\\Documents\\NetBeansProjects\\prof\\Information_Broucher.txt";
    FileReader fr=new FileReader(filename);
    BufferedReader br=new BufferedReader(fr);
    /*StringBuilder sb=new StringBuilder();
    while(fr !=null)
    {
           filetext=br.readLine();
           sb.append(filetext);
           sb.append("\n");
    }
    filecontent=sb.toString();
    //JOptionPane.showMessageDialog(null,"File is"+filecontent);*/
     jTextField3.read(br, null);
     br.close();
     jTextField3.requestFocus();
     //flag=1;
    // JScrollPane scrollPane =new JScrollPane( textArea );
    }
    catch(Exception ex){
    System.out.print("hi i am error");
    System.out.println(ex);
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int flag=1;
         String ID=jTextField2.getText();
         for(int i=0;i<s1.length&&flag==1;i++)//change name to ID
                {
                    if(s1[i].EnrollmentID.equals(ID))
                    {
                        flag=0;
                        s1[i].Account_Detail_Search(ID);
                    }
         }
         /*if(flag==1)
                {
                    //System.out.println("ID didn't match!!");
                    jLabel2.setText("Sorry!  ID didn't match!!!");
                }
         else{*/
          jTextField3.setVisible(true);
          jButton10.setVisible(true);
             try
    { 
    //String filetext="",filecontent="";

    //File file=new File("C:\\Users\\Ankul\\Documents\\NetBeansProjects\\TrialFile\\final.txt");
     filename="C:\\Users\\Ankul\\Documents\\NetBeansProjects\\prof\\CompleteAccountDetail.txt";
    FileReader fr=new FileReader(filename);
    BufferedReader br=new BufferedReader(fr);
    /*StringBuilder sb=new StringBuilder();
    while(fr !=null)
    {
           filetext=br.readLine();
           sb.append(filetext);
           sb.append("\n");
    }
    filecontent=sb.toString();
    //JOptionPane.showMessageDialog(null,"File is"+filecontent);*/
     jTextField3.read(br, null);
     br.close();
     jTextField3.requestFocus();
     flag=1;
    // JScrollPane scrollPane =new JScrollPane( textArea );
    }
    catch(Exception ex){
    System.out.print("hi i am error");
    System.out.println(ex);
    }
         
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int flag=1;
        String temp=jTextField1.getText();
        int s=Integer.parseInt(temp);
        for(int i=0;i<s1.length&&flag==1;i++)//change name to ID
                {
                    if(s1[i].EnrollmentID.equals(jTextField2.getText()))
                    {
                        flag=0;
                        s1[i].Semester_Details(jTextField2.getText(),s);
                    }
                }
        
        
                /*if(flag==1)
                {
                    System.out.println("ID didn't match!!");
                }
                flag=1;*/
                jTextField3.setVisible(true);
                jButton10.setVisible(true);
             try
    { 
    //String filetext="",filecontent="";

    //File file=new File("C:\\Users\\Ankul\\Documents\\NetBeansProjects\\TrialFile\\final.txt");
     filename="C:\\Users\\Ankul\\Documents\\NetBeansProjects\\prof\\Semester_wise_Detail.txt";
    FileReader fr=new FileReader(filename);
    BufferedReader br=new BufferedReader(fr);
    /*StringBuilder sb=new StringBuilder();
    while(fr !=null)
    {
           filetext=br.readLine();
           sb.append(filetext);
           sb.append("\n");
    }
    filecontent=sb.toString();
    //JOptionPane.showMessageDialog(null,"File is"+filecontent);*/
     jTextField3.read(br, null);
     br.close();
     jTextField3.requestFocus();
     flag=1;
    // JScrollPane scrollPane =new JScrollPane( textArea );
    }
    catch(Exception ex){
    System.out.print("hi i am error");
    System.out.println(ex);
    }
         
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        /*int flag2=1;
        for(int i=0;i<s1.length&&flag2==1;i++)//change name to ID
                {
                    if(s1[i].EnrollmentID.equals(jTextField2.getText()))
                    {
                        flag2=0;
                        
                      // jTextField3.setText("Name: "+s1[i].Name+"\n");
                        //jTextField3.setText("Enrollment ID: "+s1[i].EnrollmentID+"\n\n");
                        s1[i].Balance_Enquiry();
                    }
                }
        jTextField3.setVisible(true);
                try
    { 
    //String filetext="",filecontent="";

    //File file=new File("C:\\Users\\Ankul\\Documents\\NetBeansProjects\\TrialFile\\final.txt");
    String filename="C:\\Users\\Ankul\\Documents\\NetBeansProjects\\prof\\Balance_Enquiry.txt";
    FileReader fr=new FileReader(filename);
    BufferedReader br=new BufferedReader(fr);
    /*StringBuilder sb=new StringBuilder();
    while(fr !=null)
    {
           filetext=br.readLine();
           sb.append(filetext);
           sb.append("\n");
    }
    filecontent=sb.toString();
    //JOptionPane.showMessageDialog(null,"File is"+filecontent);*/
     /*jTextField3.read(br, null);
     br.close();
     jTextField3.requestFocus();
     flag2=1;
    // JScrollPane scrollPane =new JScrollPane( textArea );
    }
    catch(Exception ex){
    System.out.print("hi i am error");
    System.out.println(ex);
    }*/
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
         int flag2=1;
        for(int i=0;i<s1.length&&flag2==1;i++)//change name to ID
                {
                    if(s1[i].EnrollmentID.equals(jTextField2.getText()))
                    {
                        flag2=0;
                        
                      // jTextField3.setText("Name: "+s1[i].Name+"\n");
                        //jTextField3.setText("Enrollment ID: "+s1[i].EnrollmentID+"\n\n");
                        s1[i].Balance_Enquiry();
                    }
                }
        jTextField3.setVisible(true);
        jButton10.setVisible(true);
                try
    { 
    //String filetext="",filecontent="";

    //File file=new File("C:\\Users\\Ankul\\Documents\\NetBeansProjects\\TrialFile\\final.txt");
     filename="C:\\Users\\Ankul\\Documents\\NetBeansProjects\\prof\\Balance_Enquiry.txt";
    FileReader fr=new FileReader(filename);
    BufferedReader br=new BufferedReader(fr);
    /*StringBuilder sb=new StringBuilder();
    while(fr !=null)
    {
           filetext=br.readLine();
           sb.append(filetext);
           sb.append("\n");
    }
    filecontent=sb.toString();
    //JOptionPane.showMessageDialog(null,"File is"+filecontent);*/
     jTextField3.read(br, null);
     br.close();
     jTextField3.requestFocus();
     flag2=1;
    // JScrollPane scrollPane =new JScrollPane( textArea );
    }
    catch(Exception ex){
    System.out.print("hi i am error");
    System.out.println(ex);
    }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        /*try{
        BufferedWriter out1 = new BufferedWriter(new FileWriter(filename));
      out1.write("string to be copied\n");
      out1.close();
      InputStream inp = new FileInputStream(new File(filename));
      String destnfile="C:\\Users\\Ankul\\Documents\\NetBeansProjects\\prof\\Letter head IIITN.docx";
      OutputStream out = new FileOutputStream(new File(destnfile));
      byte[] buf = new byte[1024];
      int len;
      
      while ((len = inp.read(buf)) > 0) {
         out.write(buf, 0, len);
      }
      inp.close();
      out.close();
      BufferedReader in1 = new BufferedReader(new FileReader(destnfile));
      String str;
      
      while ((str = in1.readLine()) != null) {
         System.out.println(str);
      }
      inp.close();*/
         FileInputStream ins = null;
      FileOutputStream outs = null;
      File infile =new File(filename);
         File outfile =new File("C:\\Users\\Ankul\\Documents\\NetBeansProjects\\prof\\Letter head IIITN.docx");
      try {
         
         ins = new FileInputStream(infile);
         outs = new FileOutputStream(outfile);
         byte[] buffer = new byte[1024];
         int length;
         
         while ((length = ins.read(buffer)) > 0) {
            outs.write(buffer, 0, length);
         } 
         ins.close();
         outs.close();
         System.out.println("File copied successfully!!");
      } catch(IOException ioe) {
         ioe.printStackTrace();
      } 
      try{
        
        String defaultPrinter =
      PrintServiceLookup.lookupDefaultPrintService().getName();
    System.out.println("Default printer: " + defaultPrinter);

    PrintService service = PrintServiceLookup.lookupDefaultPrintService();

    FileInputStream in = new FileInputStream(new File("C:\\Users\\Ankul\\Documents\\NetBeansProjects\\prof\\Letter head IIITN.docx"));

    PrintRequestAttributeSet  pras = new HashPrintRequestAttributeSet();
    pras.add(new Copies(1));


    DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
    Doc doc = new SimpleDoc(in, flavor, null);

    DocPrintJob job = service.createPrintJob();
    PrintJobWatcher pjw = new PrintJobWatcher(job);
    job.print(doc, pras);
    pjw.waitForDone();
    in.close();

    // send FF to eject the page
    InputStream ff = new ByteArrayInputStream("\f".getBytes());
    Doc docff = new SimpleDoc(ff, flavor, null);
    DocPrintJob jobff = service.createPrintJob();
    pjw = new PrintJobWatcher(jobff);
    jobff.print(docff, null);
    pjw.waitForDone();
        }
    
        catch (Exception e)
        {
            System.out.println(e);
        }
      try{
          String myDriver ="com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost:3306/trial?zeroDateTimeBehavior=convertToNull";

            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(myUrl, "root", "wh@tthehell!");
      
      
            
            
            Statement st = conn.createStatement();
             LocalTime time=java.time.LocalTime.now();
             //String t=LocalTime.parse
      String q = " insert into access (Name,Date,Time)" + " values (?,?,?)";
            System.out.println("Inserted records into the table...");
           PreparedStatement preparedStmt = conn.prepareStatement(q);
            preparedStmt.setString (1,jTextField2.getText());
            preparedStmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
             preparedStmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            // execute the query, and get a java resultset
            preparedStmt.execute();
          }
                   catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
     }
      
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        new menu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(accFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
