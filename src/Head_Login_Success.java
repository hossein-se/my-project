package library_service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Head_Login_Success extends javax.swing.JFrame {

    
    public Head_Login_Success() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("HEAD LIBRARIAN SECTION");
        jLabel1.setPreferredSize(new java.awt.Dimension(177, 22));

        jButton1.setText("ADD LIBRARIAN");
        jButton1.setPreferredSize(new java.awt.Dimension(123, 33));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("VIEW LIBRARIAN");
        jButton2.setPreferredSize(new java.awt.Dimension(123, 33));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE LIBRARIAN");
        jButton3.setPreferredSize(new java.awt.Dimension(125, 33));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("LOGOUT");
        jButton4.setPreferredSize(new java.awt.Dimension(123, 33));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("VIEW REPORT");
        jButton5.setPreferredSize(new java.awt.Dimension(125, 33));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("MODIFY LIBRARIAN");
        jButton6.setPreferredSize(new java.awt.Dimension(143, 33));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        
    	new Add_Librarian().setVisible(true);
        this.setVisible(false);
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {        
    	JDialog.setDefaultLookAndFeelDecorated(true);
        int reply = JOptionPane.showConfirmDialog(Head_Login_Success.this, "Are you sure you want to logout?", "Confirm Logout?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
          new main_page().setVisible(true);
          this.setVisible(false);
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {        
    	new View_Librarian().setVisible(true);
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {        
    	new Delete_Librarian().setVisible(true);
        this.setVisible(false);
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {        
    	try{
            int cat_count = 0,books_count=0,books_avail=0,books_borrow=0,books_lost=0,mem_count=0,fine=0;
            String cat="";
            File f = new File("D:/categories.txt");
            if(f.exists()){
                Scanner s = new Scanner(new FileReader(f));
                while(s.hasNext()){
                    cat_count++;
                    cat=s.nextLine();
                    Scanner r = new Scanner(new FileReader("D:/Categories/" + cat + ".txt"));
                    while(r.hasNext()){
                        String[] words = r.nextLine().split(";");
                        books_count++;
                        if(words[3].equals("Available"))
                            books_avail++;
                        else if(words[3].equals("Borrowed"))
                            books_borrow++;
                        else
                            books_lost++;
                    }
                    r.close();
                }
                s.close();
            }
            File f1 = new File("D:/members.txt");
            if(f1.exists()){
                Scanner t = new Scanner(new FileReader(f1));
                while(t.hasNext()){
                    mem_count++;
                    String[] word = t.nextLine().split(";");
                    if(word[6].equals("Fine"))
                        fine++;
                }
                t.close();
            }
            JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(Head_Login_Success.this, new JTextArea("\nNumber of Categories:\t\t" + cat_count + "\nNumber of Books:\t\t" + books_count + "\nAvailable Books:\t\t" + books_avail + "\nBorrowed Books:\t\t" + books_lost + "\nLost Books:\t\t\t" + books_lost + "\nNumber of Members:\t\t" + mem_count + "\nNumber of Members with Fine:\t\t" + fine), "Library Report",JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Head_Login_Success.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {        
    	new Modify_Librarians().setVisible(true);
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
            java.util.logging.Logger.getLogger(Head_Login_Success.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Head_Login_Success.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Head_Login_Success.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Head_Login_Success.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Head_Login_Success().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    
}
