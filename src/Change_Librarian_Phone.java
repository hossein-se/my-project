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

public class Change_Librarian_Phone extends javax.swing.JFrame {

    public Change_Librarian_Phone() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Mem_Cont = new javax.swing.JTextField();
        Mem_ID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setText("CHANGE LIBRARIAN CONTACT NO.");
        jLabel1.setPreferredSize(new java.awt.Dimension(287, 22));
        jLabel1.setRequestFocusEnabled(false);

        jLabel2.setText("ENTER LIBRARIAN ID:");

        jLabel3.setText("ENTER NEW LIBRARIAN CONTACT:");

        Mem_Cont.setPreferredSize(new java.awt.Dimension(155, 33));

        Mem_ID.setPreferredSize(new java.awt.Dimension(155, 33));

        jButton1.setText("CHANGE");
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Mem_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mem_Cont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jButton1)))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Mem_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Mem_Cont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {        
    	new Modify_Librarians().setVisible(true);
        this.setVisible(false);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        
    	String id = Mem_ID.getText();
        String name = Mem_Cont.getText();
        File f = new File("D:/librarians.txt");
        if(!f.exists()){
            JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(Change_Librarian_Phone.this,"There are no librarians! Please add them before modifying","Librarian Error!", JOptionPane.ERROR_MESSAGE);
            Mem_ID.setText("");
            Mem_Cont.setText("");
        }
        else{
            try {
                BufferedReader reader1 = new BufferedReader(new FileReader(f));
                int k=1;
                String line="";
                while((line=reader1.readLine())!=null){
                    String[] words = line.split(";");
                    if(words[0].equals(id)){
                        k=0;
                    }
                }
                reader1.close();
                if(k==1){
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    JOptionPane.showMessageDialog(Change_Librarian_Phone.this,"ID doesn't exists","ID Error!", JOptionPane.ERROR_MESSAGE);
                    Mem_ID.setText("");
                    Mem_Cont.setText("");
                }
                else{
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    int response = JOptionPane.showConfirmDialog(Change_Librarian_Phone.this, "Are you sure you want to change this librarian's contact number?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
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
                                    String lines = words[0] + ";" + words[1] + ";" + words[2] + ";" + name + ";" + words[4] + ";" + words[5] + ";" + words[6]; 
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
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Change_Librarian_Phone.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                    x=1;
                                }
                                if(!tempfile.renameTo(f)){
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Change_Librarian_Phone.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                    y=1;
                                }
                                if(x==0 && y==0) {
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Change_Librarian_Phone.this,"Librarian Contact Number changed successfully!");    
                                    new Head_Login_Success().setVisible(true);
                                    this.setVisible(false);
                                }
                                else{
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Change_Librarian_Phone.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                    new Head_Login_Success().setVisible(true);
                                    this.setVisible(false);
                                }
                            }
                            else{
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Change_Librarian_Phone.this,"Unable to change contact number!","Category Error!", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Change_Librarian_Phone.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Change_Librarian_Phone.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(response==JOptionPane.NO_OPTION){
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        JOptionPane.showMessageDialog(Change_Librarian_Phone.this,"Name Change Operation cancelled!");    
                        new Modify_Members().setVisible(true);
                        this.setVisible(false);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Change_Librarian_Phone.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Change_Librarian_Phone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Change_Librarian_Phone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Change_Librarian_Phone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Change_Librarian_Phone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change_Librarian_Phone().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField Mem_Cont;
    private javax.swing.JTextField Mem_ID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    
}
