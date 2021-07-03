package library_service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Lost_Found extends javax.swing.JFrame {

    public Lost_Found() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        B_Cat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        B_ID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setText("BOOK LOST/FOUND");
        jLabel1.setPreferredSize(new java.awt.Dimension(163, 22));

        jLabel2.setText("ENTER BOOK CATEGORY:");
        jLabel2.setPreferredSize(new java.awt.Dimension(143, 33));

        B_Cat.setPreferredSize(new java.awt.Dimension(155, 33));

        jLabel3.setText("ENTER BOOK ID:");

        B_ID.setPreferredSize(new java.awt.Dimension(155, 33));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("LOST/FOUND");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(B_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(B_Cat, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(B_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {        
    	String cat = B_Cat.getText();
        String id = B_ID.getText();
        File f = new File("D:/Categories/" + cat + ".txt");
        if(!f.exists()){
            JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(Lost_Found.this,"Category you specified doesn't exists","Category Error!", JOptionPane.ERROR_MESSAGE);
            B_Cat.setText("");
        }
        else{
            try {
                BufferedReader reader1 = new BufferedReader(new FileReader(f));
                int i=0,j=0,k=1;
                String line="";
                while((line=reader1.readLine())!=null){
                    String[] words = line.split(";");
                    if(words[0].equals(id)){
                        k=0;
                        if(words[3].equalsIgnoreCase("available") || words[3].equalsIgnoreCase("borrowed")){
                            i=1;
                        }
                        else if(words[3].equalsIgnoreCase("Lost"))
                            j=1;
                    }
                }
                reader1.close();
                if(k==1){
                    JOptionPane.showMessageDialog(Lost_Found.this,"ID doesn't exists, or you entered the wrong category name","ID Error!", JOptionPane.ERROR_MESSAGE);
                    B_Cat.setText("");
                    B_ID.setText("");
                }
                else{
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    int response = JOptionPane.showConfirmDialog(Lost_Found.this, "Are you sure you want to change the status of this book?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        File tempfile = new File(f.getAbsolutePath() + ".tmp");
                        try{
                            BufferedReader reader = new BufferedReader(new FileReader(f));
                            PrintWriter pw = new PrintWriter(new FileWriter(tempfile));
                            String read = "";
                            int z=1;
                            while((read = reader.readLine())!=null){
                                String[] words = read.split(";");
                                if(!words[0].equals(id)){
                                    pw.println(read);
                                    pw.flush();
                                }
                                else{
                                    String lines = "";
                                    if(i==1)
                                        lines = words[0] + ";" + words[1] + ";" + words[2] + ";" + "Lost" + ";" + words[4] + ";" + words[5];
                                    else if(j==1){
                                        if(words[4].equals("-") && words[5].equals("-"))
                                            lines = words[0] + ";" + words[1] + ";" + words[2] + ";" + "Available" + ";" + words[4] + ";" + words[5];
                                        else
                                            lines = words[0] + ";" + words[1] + ";" + words[2] + ";" + "Borrowed" + ";" + words[4] + ";" + words[5];
                                    }
                                    pw.println(lines);
                                    pw.flush();
                                    z=0;
                                }
                            }   
                            pw.close();
                            reader.close();
                            int x=0,y=0;
                            if(z==0){
                                if(!f.delete()){
                                    JOptionPane.showMessageDialog(Lost_Found.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                    x=1;
                                }
                                if(!tempfile.renameTo(f)){
                                    JOptionPane.showMessageDialog(Lost_Found.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                    y=1;
                                }
                                if(x==0 && y==0) {
                                    if(i==1){
                                        JDialog.setDefaultLookAndFeelDecorated(true);
                                        JOptionPane.showMessageDialog(Lost_Found.this,"Book staus turned to \"Lost\"");    
                                    }
                                    else if(j==1){
                                        JDialog.setDefaultLookAndFeelDecorated(true);
                                        JOptionPane.showMessageDialog(Lost_Found.this,"Book staus turned to \"Found\"");  
                                    }
                                    new AVM_Books().setVisible(true);
                                    this.setVisible(false);
                                }
                                else{
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Lost_Found.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                    new AVM_Books().setVisible(true);
                                    this.setVisible(false);
                                }   
                            }
                            else{
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Lost_Found.this,"Unable to change the book status!","Category Error!", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Lost_Found.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Lost_Found.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(response==JOptionPane.NO_OPTION){
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        JOptionPane.showMessageDialog(Lost_Found.this,"Lost Operation cancelled!");    
                        new Modify_Books().setVisible(true);
                        this.setVisible(false);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Lost_Found.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        
    	new Modify_Books().setVisible(true);
        this.setVisible(false);
    }
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lost_Found.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lost_Found.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lost_Found.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lost_Found.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lost_Found().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField B_Cat;
    private javax.swing.JTextField B_ID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    
}
