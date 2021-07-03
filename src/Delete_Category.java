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

public class Delete_Category extends javax.swing.JFrame {

    
    public Delete_Category() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Del_Cat = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setText("DELETE CATEGORY");

        jLabel2.setText("ENTER THE CATEGORY NAME:");
        jLabel2.setPreferredSize(new java.awt.Dimension(149, 33));

        Del_Cat.setPreferredSize(new java.awt.Dimension(145, 33));
        Del_Cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Del_CatActionPerformed(evt);
            }
        });

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
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
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jButton1)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(Del_Cat, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Del_Cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {        
    	new Modify_BCategory().setVisible(true);
        this.setVisible(false);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        
    	JDialog.setDefaultLookAndFeelDecorated(true);
        String cat = Del_Cat.getText();
        File f = new File("D:/Categories/" + cat + ".txt");
        int k=1;
        if(!f.exists()){
            JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(Delete_Category.this, "\""+cat+"\" category doesn't exists or was already deleted","Category Error!", JOptionPane.ERROR_MESSAGE);
            Del_Cat.setText("");
        }
        else if(f.length()!=0){
            JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(Delete_Category.this, "\""+cat+"\" category contains some books.  Be sure to move all the books before deleting!","Category Error!", JOptionPane.ERROR_MESSAGE);
            new Modify_BCategory().setVisible(true);
            this.setVisible(false);
        }
        else{
            JDialog.setDefaultLookAndFeelDecorated(true);
            int response = JOptionPane.showConfirmDialog(Delete_Category.this, "Are you sure you want to delete this category?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {    
                File infile = new File("D:/categories.txt");
                File tempfile = new File(infile.getAbsolutePath() + ".tmp");
                try {
                    BufferedReader reader1 = new BufferedReader(new FileReader(infile));
                    PrintWriter pw = new PrintWriter(new FileWriter(tempfile));
                    String read = "";
                    while((read = reader1.readLine())!=null){
                        if(!read.trim().equals(cat)){
                            pw.println(read);
                            pw.flush();
                        }
                        else
                            k=0;
                    }
                    pw.close();
                    reader1.close();
                    int x=0,y=0;
                    if(k==0){
                        if(!infile.delete()){
                            JDialog.setDefaultLookAndFeelDecorated(true);
                            JOptionPane.showMessageDialog(Delete_Category.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                            x=1;
                        }
                        if(!tempfile.renameTo(infile)){
                            JDialog.setDefaultLookAndFeelDecorated(true);
                            JOptionPane.showMessageDialog(Delete_Category.this, "Sorry, an Unexpected error occurerd","Error 2!", JOptionPane.ERROR_MESSAGE);
                            y=1;
                        }
                        if(x==0 && y==0){
                            f.delete();
                            JDialog.setDefaultLookAndFeelDecorated(true);
                            JOptionPane.showMessageDialog(Delete_Category.this, "\""+cat+"\" category deleted successfully!");
                            new AVMD_Book_Category().setVisible(true);
                            this.setVisible(false);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Delete_Category.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Delete_Category.class.getName()).log(Level.SEVERE, null, ex);
                }       
            }
            else if(response==JOptionPane.NO_OPTION){
                JDialog.setDefaultLookAndFeelDecorated(true);
                JOptionPane.showMessageDialog(Delete_Category.this,"Delete Operation cancelled!");    
                new Modify_BCategory().setVisible(true);
                this.setVisible(false);
            }
        }
    }
    private void Del_CatActionPerformed(java.awt.event.ActionEvent evt) {          
    	
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
            java.util.logging.Logger.getLogger(Delete_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Delete_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Delete_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Delete_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Delete_Category().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField Del_Cat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    
}
