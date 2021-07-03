package library_service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

public class Move1Book_Category extends javax.swing.JFrame {

    public Move1Book_Category() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Org_Cat = new javax.swing.JTextField();
        Book_ID = new javax.swing.JTextField();
        Dest_Cat = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setText("MOVE ONE BOOK");
        jLabel1.setPreferredSize(new java.awt.Dimension(127, 22));

        jLabel2.setText("ENTER ORIGINATING CATEGORY:");
        jLabel2.setPreferredSize(new java.awt.Dimension(138, 33));

        jLabel3.setText("ENTER THE BOOK ID:");
        jLabel3.setPreferredSize(new java.awt.Dimension(82, 33));

        jLabel4.setText("ENTER DESTINATION CATEGORY:");
        jLabel4.setPreferredSize(new java.awt.Dimension(157, 33));

        Org_Cat.setPreferredSize(new java.awt.Dimension(6, 33));

        Book_ID.setPreferredSize(new java.awt.Dimension(145, 33));

        Dest_Cat.setPreferredSize(new java.awt.Dimension(145, 33));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("MOVE");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 345, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Org_Cat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Book_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Dest_Cat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Org_Cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Book_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dest_Cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {        
    	String ocat = Org_Cat.getText();
        String id = Book_ID.getText();
        String dcat = Dest_Cat.getText();
        File f1 = new File("D:/Categories/" + ocat + ".txt");
        File f2 = new File("D:/Categories/" + dcat + ".txt");
        if(!f1.exists() || !f2.exists()){
            JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(Move1Book_Category.this,"Category you specified doesn't exists","Category Error!", JOptionPane.ERROR_MESSAGE);
            Org_Cat.setText("");
            Dest_Cat.setText("");
            Book_ID.setText("");
        }
        else{
            try{
                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(Move1Book_Category.this, "Are you sure you want to move this book?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    int k=1;
                    BufferedReader reader = new BufferedReader(new FileReader(f1));
                    File tempfile = new File(f1.getAbsolutePath() + ".tmp");
                    PrintWriter pw = new PrintWriter(new FileWriter(tempfile));
                    String[] book = new String[5];
                    String read = "";
                    String line = "";
                    while((read = reader.readLine())!=null){
                        book = read.split(",");
                        if(!book[0].trim().equals(id)){
                            pw.println(read);
                            pw.flush();
                        }
                        else {
                            k=0;
                            line = read;
                        }    
                    }
                    pw.close();
                    reader.close();
                    if(k==0){
                        if(!f1.delete()){
                            JDialog.setDefaultLookAndFeelDecorated(true);
                            JOptionPane.showMessageDialog(Move1Book_Category.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                            new Modify_Books().setVisible(true);
                            this.setVisible(false);
                        }
                        if(!tempfile.renameTo(f1)){
                            JDialog.setDefaultLookAndFeelDecorated(true);
                            JOptionPane.showMessageDialog(Move1Book_Category.this, "Sorry, an Unexpected error occurerd","Error 2!", JOptionPane.ERROR_MESSAGE);
                            new Modify_Books().setVisible(true);
                            this.setVisible(false);
                        }
                        BufferedWriter writer = new BufferedWriter(new FileWriter(f2,true));
                        writer.write(line);
                        writer.newLine();
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        JOptionPane.showMessageDialog(Move1Book_Category.this,"Book moved successfully!");    
                        new AVM_Books().setVisible(true);
                        this.setVisible(false);
                        writer.close();
                    }
                    else {
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        JOptionPane.showMessageDialog(Move1Book_Category.this,"ID doesn't exist","ID Error!", JOptionPane.ERROR_MESSAGE);
                        Org_Cat.setText("");
                        Dest_Cat.setText("");
                        Book_ID.setText("");
                    }
                }else if(response==JOptionPane.NO_OPTION){
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        JOptionPane.showMessageDialog(Move1Book_Category.this,"Move Operation cancelled!");    
                        new Modify_Books().setVisible(true);
                        this.setVisible(false);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Move1Book_Category.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Move1Book_Category.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Move1Book_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Move1Book_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Move1Book_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Move1Book_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Move1Book_Category().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField Book_ID;
    private javax.swing.JTextField Dest_Cat;
    private javax.swing.JTextField Org_Cat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    
}
