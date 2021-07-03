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

 class Delete_Book extends javax.swing.JFrame {

    public Delete_Book() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        B_Cat = new javax.swing.JTextField();
        B_ID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setText("DELETE BOOK");
        jLabel1.setPreferredSize(new java.awt.Dimension(117, 22));

        jLabel2.setText("ENTER BOOK CATEGORY:");
        jLabel2.setPreferredSize(new java.awt.Dimension(143, 33));

        jLabel3.setText("ENTER BOOK ID:");
        jLabel3.setPreferredSize(new java.awt.Dimension(104, 33));

        B_Cat.setPreferredSize(new java.awt.Dimension(155, 33));

        B_ID.setPreferredSize(new java.awt.Dimension(155, 33));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("DELETE");
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
                                .addGap(135, 135, 135)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(B_Cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(B_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 10, Short.MAX_VALUE))
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
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        
    	new Modify_Books().setVisible(true);
        this.setVisible(false);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {        
    	String cat = B_Cat.getText();
        String id = B_ID.getText();
        File f = new File("D:/Categories/" + cat + ".txt");
        if(!f.exists()){
            JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(Delete_Book.this,"Category you specified doesn't exists","Category Error!", JOptionPane.ERROR_MESSAGE);
            B_Cat.setText("");
        }
        else{
            try {
                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(Delete_Book.this, "Are you sure you want to delete this book?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    BufferedReader reader1 = new BufferedReader(new FileReader(f));
                    int i=0,k=1;
                    String line="";
                    while((line=reader1.readLine())!=null){
                        String[] words = line.split(";");
                        if(words[0].equals(id)){
                            k=0;
                            if(words[3].equalsIgnoreCase("available")){
                                i=1;
                            }
                        }
                    }
                    reader1.close();
                    if(k==1){
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        JOptionPane.showMessageDialog(Delete_Book.this,"ID doesn't exists, or you entered the wrong category name","ID Error!", JOptionPane.ERROR_MESSAGE);
                        B_Cat.setText("");
                        B_ID.setText("");
                    }
                    else{
                        if(i==0){
                            JDialog.setDefaultLookAndFeelDecorated(true);
                            JOptionPane.showMessageDialog(Delete_Book.this,"Book is currently not available. Please delete after the book is available","Book Error!", JOptionPane.ERROR_MESSAGE);
                            B_Cat.setText("");
                            B_ID.setText("");
                        }
                        else{
                            File tempfile = new File(f.getAbsolutePath() + ".tmp");
                            try {
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
                                        z=0;
                                    }
                                }   
                                pw.close();
                                reader.close();
                                int x=0,y=0;
                                if(z==0){
                                    if(!f.delete()){
                                        JOptionPane.showMessageDialog(Delete_Book.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                        x=1;
                                    }
                                    if(!tempfile.renameTo(f)){
                                        JOptionPane.showMessageDialog(Delete_Book.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                        y=1;
                                    }
                                    if(x==0 && y==0) {
                                        File f1 = new File("D:/Books/" + id + ".txt");
                                        f1.delete();
                                        JDialog.setDefaultLookAndFeelDecorated(true);
                                        JOptionPane.showMessageDialog(Delete_Book.this,"Book deleted successfully!");    
                                        new AVM_Books().setVisible(true);
                                        this.setVisible(false);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(Delete_Book.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                        new AVM_Books().setVisible(true);
                                        this.setVisible(false);
                                    }
                                }
                                else{
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Delete_Book.this,"Unable to rename!","Category Error!", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Delete_Book.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Delete_Book.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                else if(response==JOptionPane.NO_OPTION){
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    JOptionPane.showMessageDialog(Delete_Book.this,"Delete Operation cancelled!");    
                    new Modify_Books().setVisible(true);
                    this.setVisible(false);
                }
            } catch (IOException ex) {
                Logger.getLogger(Delete_Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
            java.util.logging.Logger.getLogger(Delete_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Delete_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Delete_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Delete_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Delete_Book().setVisible(true);
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
