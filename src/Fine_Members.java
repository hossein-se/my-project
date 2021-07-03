package library_service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class Fine_Members extends javax.swing.JFrame {


    public Fine_Members() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Mem_ID = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("FINE FOR MEMBERS");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("ENTER THE MEMBER ID:");
        jLabel2.setPreferredSize(new java.awt.Dimension(124, 33));

        Mem_ID.setPreferredSize(new java.awt.Dimension(155, 33));

        jButton2.setText("REMOVE FINE");
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(Mem_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel1)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mem_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 :
        String mem_id = Mem_ID.getText();
        File f = new File("D:/Members/" + mem_id + ".txt");
        if(f.exists()){
            try {
                Scanner read = new Scanner(new FileReader("D:/members.txt"));
                String line = "";
                int i=0;
                while(read.hasNext()){
                    line = read.nextLine();
                    String[] words = line.split(";");
                    if(words[0].equals(mem_id))
                        if(words[6].equals("Fine"))
                            i=1;
                }
                read.close();
                if(i==1){
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    int response = JOptionPane.showConfirmDialog(Fine_Members.this, "Are you sure you want to remove the fine of this member? Please check if the member ID is correct.", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        File f1 = new File("D:/members.txt");
                        File tempfile = new File(f1.getAbsolutePath() + ".tmp");
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(f1));
                            PrintWriter pw = new PrintWriter(new FileWriter(tempfile));
                            String reads = "";
                            int z=1;
                            while((reads = reader.readLine())!=null){
                                String[] words = reads.split(";");
                                if(!words[0].equals(mem_id)){
                                    pw.println(read);
                                    pw.flush();
                                }
                                else{
                                    String lines = words[0] + ";" + words[1] + ";" + words[2] + ";" + words[3] + ";" + words[4] + ";" + words[5] + "-"; 
                                    pw.println(lines);
                                    pw.flush();
                                    z=0;
                                }
                            }   
                            pw.close();
                            reader.close();
                            int x=0,y=0;
                            if(z==0){
                                if(!f1.delete()){
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Fine_Members.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                    x=1;
                                }
                                if(!tempfile.renameTo(f)){
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Fine_Members.this, "Sorry, an Unexpected error occurerd","Error 2!", JOptionPane.ERROR_MESSAGE);
                                    y=1;
                                }
                                if(x==0 && y==0) {
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Fine_Members.this,"Fine removed successfully!");    
                                    new AVD_Members().setVisible(true);
                                    this.setVisible(false);
                                }
                                else{
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Fine_Members.this, "Sorry, an Unexpected error occurerd","Error 3!", JOptionPane.ERROR_MESSAGE);
                                    new AVD_Members().setVisible(true);
                                    this.setVisible(false);
                                }
                            }
                            else{
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Fine_Members.this,"Unable to remove fine!","Category Error!", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Fine_Members.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Fine_Members.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(response==JOptionPane.NO_OPTION){
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        JOptionPane.showMessageDialog(Fine_Members.this,"Operation cancelled!");    
                        new AVD_Members().setVisible(true);
                        this.setVisible(false);
                    }
                }
                else{
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    JOptionPane.showMessageDialog(Fine_Members.this, "There is no fine for this member","Fine Error!", JOptionPane.ERROR_MESSAGE);
                    new AVD_Members().setVisible(true);
                    this.setVisible(false);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Fine_Members.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AVD_Members().setVisible(true);
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
            java.util.logging.Logger.getLogger(Fine_Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fine_Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fine_Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fine_Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fine_Members().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField Mem_ID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
}
