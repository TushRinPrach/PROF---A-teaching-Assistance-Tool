/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prof;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tgsingh
 */
public class Att extends javax.swing.JFrame {

    /**
     * Creates new form Att
     */
    
   /* private static final String USERNAME="tushita";
    private static final String PASSWORD="tushita";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull" ;*/
    public static  Connection conn;
    public static String myDriver ="com.mysql.jdbc.Driver";

     public static String myUrl = "jdbc:mysql://localhost:3306/trial?zeroDateTimeBehavior=convertToNull";
    public static  ResultSet rs;
    public static  Statement stmt = null;
    
    public Att() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        submit.setVisible(false);
        jTable1.setVisible(false);
        jScrollPane1.setVisible(false);
        done.setVisible(false);
        submit2.setVisible(false);
        submit3.setVisible(false);
        percent.setVisible(false);
        jLabel5.setVisible(false);
        jTextField3.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        percent = new javax.swing.JLabel();
        submit3 = new javax.swing.JButton();
        submit2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        done = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(650, 450));
        jPanel1.setLayout(null);

        percent.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        percent.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(percent);
        percent.setBounds(370, 260, 120, 40);

        submit3.setText("Submit");
        submit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit3ActionPerformed(evt);
            }
        });
        jPanel1.add(submit3);
        submit3.setBounds(380, 220, 70, 30);

        submit2.setText("SUBMIT");
        submit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit2ActionPerformed(evt);
            }
        });
        jPanel1.add(submit2);
        submit2.setBounds(370, 220, 130, 30);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(390, 90, 160, 20);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID-NO:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(320, 90, 51, 20);

        jButton1.setText("Mark Attendance");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 100, 180, 50);

        jButton2.setText("Check Attendance");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(40, 180, 180, 50);

        jButton3.setText("Get Percentage");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(40, 260, 180, 40);

        jButton4.setText("Go To Main Menu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(200, 360, 190, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ATTENDANCE SHEET");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(230, 20, 260, 40);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("subCode:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(300, 130, 70, 19);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("lecture no:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(290, 170, 80, 19);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(390, 130, 160, 20);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(390, 170, 160, 20);

        submit.setText("submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel1.add(submit);
        submit.setBounds(350, 220, 140, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"bt16cse001", "parth", null},
                {"bt16cse002", "mayur", null},
                {"bt16cse003", "divyesh", null},
                {"bt16cse004", "athrav", null},
                {null, null, null}
            },
            new String [] {
                "id", "name", "present/absent"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(280, 80, 300, 240);

        done.setText("done");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });
        jPanel1.add(done);
        done.setBounds(400, 320, 57, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon("H:\\SEM 4\\ITW\\PROF\\235493381-wallpaper-backgrounds-blue.jpg")); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 650, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        jTable1.setVisible(false);
        jScrollPane1.setVisible(false);
        done.setVisible(false);
        submit2.setVisible(false);
        submit3.setVisible(false);
        percent.setVisible(false);
        jLabel5.setVisible(false);
        jTextField3.setVisible(false);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        submit.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
       jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        submit.setVisible(false);
       String subject=jTextField1.getText();
        String take=jTextField2.getText();
        int lect= Integer.parseInt(take);
        jTable1.setVisible(true);
       jScrollPane1.setVisible(true);
       done.setVisible(true);
    }//GEN-LAST:event_submitActionPerformed

    public void theQuery(String id,int count){
         try
      {
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection(myUrl, "root", "wh@tthehell!");
         //conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
        System.out.println("CONNECTED");
       // stmt = conn.createStatement();
        //stmt.executeUpdate(query);
       String query = "UPDATE tushita.attendance SET counting = ? WHERE attendance.id = ?";
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setInt   (1,count);
      preparedStmt.setString(2, id);
      preparedStmt.executeUpdate();
        // Statement stmt = (Statement) conn.createStatement();
      }
      catch (Exception ex)
      {// handle any errors
          System.out.println("in Query");
           System.err.println(ex);
      }
    }
    public void Update(String id){
        
        try{
            System.out.print("update");
            stmt = conn.createStatement();
            String sql;

      // Now you can extract all the records
      // to see the updated records
          sql = "SELECT  * FROM tushita.attendance WHERE id='"+id+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
            int count=rs.getInt("counting");
            count=count+1;
            //theQuery("UPDATE `attendance` SET `counting`= [counting+1] WHERE `id`= '"+id+"' ");
            theQuery(id,count);}
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
    public void absent(String id){
        
        try{
            System.out.print("update");
            stmt = conn.createStatement();
            String sql;

      // Now you can extract all the records
      // to see the updated records
          sql = "SELECT  * FROM tushita.attendance WHERE id='"+id+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
            int count=rs.getInt("counting");
            //theQuery("UPDATE `attendance` SET `counting`= [counting+1] WHERE `id`= '"+id+"' ");
            theQuery(id,count);}
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
    /*private boolean id_check(String key) {
     boolean ret=false;
        try{           
        
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;

      // Now you can extract all the records
      // to see the updated records
      sql = "SELECT id, name, counting FROM tushita.attendance";
      rs = stmt.executeQuery(sql);

      while(rs.next()){
         //Retrieve by column name
         String id  = rs.getString("id");
         String nam = rs.getString("name");
         int count = rs.getInt("counting");
         
          if(id.equals(key))
          {   count=count+1;
              sql = "UPDATE tushita.attendance " + "SET counting = '"+count+"' WHERE id=key ";
              stmt.executeUpdate(sql);
             ret=true;
          }
         
      }
      stmt.close();
     }
     catch(SQLException e){
       System.err.print(e);
       ret=false;
    }
        return(ret);
  } */
    
    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
         jTable1.setVisible(false);
       jScrollPane1.setVisible(false);
       done.setVisible(false);
       System.out.println(jTable1.getRowCount());
       for(int i=0;i<jTable1.getRowCount()-1;i++){
               String id = (String)jTable1.getModel().getValueAt(i,0);
               System.out.println(id);
               //if(!jTable1.getModel().getValueAt(i,2).equals(0))
               int isPresent = (int) jTable1.getValueAt(i, 2);
               System.out.println("i: "+i);
               if(isPresent==0){isPresent=0;}
               System.out.println(isPresent);
               if(isPresent==1)
               {System.out.print("here2");
                   Update(id);
               }
               else{
                   System.out.print("here");
                   absent(id); 
               }
       } 
    }//GEN-LAST:event_doneActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        submit.setVisible(false);
        jTable1.setVisible(false);
        jScrollPane1.setVisible(false);
        done.setVisible(false);
        submit3.setVisible(false);
        percent.setVisible(false);
        jLabel2.setVisible(true);
        jLabel3.setVisible(false);
        jTextField1.setVisible(true);
        jTextField2.setVisible(false);
        submit2.setVisible(true);
        jLabel5.setVisible(true);
        jTextField3.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        jLabel3.setVisible(false);
        jTextField2.setVisible(false);
        submit.setVisible(false);
        jTable1.setVisible(false);
        jScrollPane1.setVisible(false);
        done.setVisible(false);
        submit2.setVisible(false);
        
        jLabel2.setVisible(true);
         percent.setVisible(true);
        jTextField1.setVisible(true);
        submit3.setVisible(true);
        jLabel5.setVisible(true);
        jTextField3.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void submit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit2ActionPerformed
       String id=jTextField3.getText();
       String subjectCode=jTextField1.getText();
       //String lectno=jTextField2.getText();
        try{
            System.out.print("check ke liye\n");
            stmt = conn.createStatement();
            String sql;

      // Now you can extract all the records
      // to see the updated records
          sql = "SELECT  * FROM tushita.attendance WHERE id='"+id+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
            int count=rs.getInt("counting");
            //theQuery("UPDATE `attendance` SET `counting`= [counting+1] WHERE `id`= '"+id+"' ");
            jLabel5.setText(Integer.toString(count));}
        }
        catch(Exception e){
            System.out.print(e);
        }
       
    }//GEN-LAST:event_submit2ActionPerformed

    private void submit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit3ActionPerformed
       String id=jTextField3.getText();
       String subjectCode=jTextField1.getText();
       //String lectno=jTextField2.getText();
        try{
            System.out.print("check ke liye\n");
            stmt = conn.createStatement();
            String sql;

      // Now you can extract all the records
      // to see the updated records
          sql = "SELECT  * FROM tushita.attendance WHERE id='"+id+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
            int count=rs.getInt("counting");
            //theQuery("UPDATE `attendance` SET `counting`= [counting+1] WHERE `id`= '"+id+"' ");
            jLabel5.setText(Integer.toString(count));}
        }
        catch(Exception e){
            System.out.print(e);
        }
    }//GEN-LAST:event_submit3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new menu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Att.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Att.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Att.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Att.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         try
      { 
          Class.forName("com.mysql.jdbc.Driver");

          conn = DriverManager.getConnection(myUrl, "root", "wh@tthehell!");
         //conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
        System.out.println("CONNECTED");
        }
      catch (Exception ex)
      {// handle any errors
           System.err.println(ex);
      }
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Att().setVisible(true);
            }
        });
    
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton done;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel percent;
    private javax.swing.JButton submit;
    private javax.swing.JButton submit2;
    private javax.swing.JButton submit3;
    // End of variables declaration//GEN-END:variables
}
