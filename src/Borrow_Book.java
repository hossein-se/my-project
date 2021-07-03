package library_service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Borrow_Book extends javax.swing.JFrame {


    public Borrow_Book() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        B_ID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Mem_ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("BORROW BOOK");
        jLabel1.setPreferredSize(new java.awt.Dimension(111, 22));

        jLabel2.setText("ENTER BOOK ID:");
        jLabel2.setPreferredSize(new java.awt.Dimension(104, 33));

        B_ID.setPreferredSize(new java.awt.Dimension(155, 33));

        jButton1.setText("BORROW");
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

        Mem_ID.setPreferredSize(new java.awt.Dimension(155, 33));

        jLabel3.setText("ENTER ID:");
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 33));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Mem_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Mem_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Members_Login_Success().setVisible(true);
        this.setVisible(false);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String id = B_ID.getText();
        String mem_id = Mem_ID.getText();
        try{
            int j=0,k=1;
            Scanner reader1 = new Scanner(new File("D:/categories.txt"));
            String books;
            String cat[] = new String[20];
            while(reader1.hasNext()){
                cat[j++] = reader1.nextLine();
            }
            reader1.close();
            String[] args = new String[7];
            for(int i=0;i<j;i++){
                BufferedReader readers = new BufferedReader(new FileReader("D:/Categories/" + cat[i] + ".txt"));
                    //int x=0,y=0;
                    while((books = readers.readLine())!=null){
                        String[] words = books.split(";");
                        if(words[0].equalsIgnoreCase(id) && words[3].equalsIgnoreCase("Available")){
                            args[0] = cat[i];
                            args[1] = words[0];
                            args[2] = words[1];
                            args[3] = words[2];
                            args[4] = words[3];
                            args[5] = words[4];
                            args[6] = words[5];
                            k=0;
                        }
                    }
                    readers.close();
            }
            if(k==0){
                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(Borrow_Book.this,new JTextArea("Book Category:\t" + args[0] + "\nBook ID:\t" + args[1] + "\nBook Name:\t" + args[2] + "\nBook Author:\t" + args[3] + "\nAvailability:\t" + args[4] + "\n\n"),"Borrow Book?",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    int b=0;
                    Scanner fil = new Scanner(new FileReader("D:/Members/" + mem_id + ".txt"));
                    while(fil.hasNext()){
                        String[] lin = fil.nextLine().split(";");
                        if(lin[2].equals("-"))
                            b=1;
                    }
                    if(b==0){
                        fil.close();
                        BufferedWriter writer = new BufferedWriter(new FileWriter("D:/Books/" + args[1] + ".txt",true));
                        Calendar cal = Calendar.getInstance();
                        Date dtf = cal.getTime();
                        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
                        String s = formatter.format(dtf);
                        writer.write(mem_id + ";" + s + ";-");
                        writer.newLine();
                        writer.close();
                        BufferedWriter writer1 = new BufferedWriter(new FileWriter("D:/Members/" + mem_id + ".txt",true));
                        writer1.write(id + ";" + s + ";-");
                        writer1.newLine();
                        File f = new File("D:/Categories/" + args[0] + ".txt");
                        writer1.close();
                        File tempfile = new File(f.getAbsolutePath() + ".tmp");
                        try {
                            Scanner r = new Scanner(new FileReader("D:/members.txt"));
                            String l ="";
                            int p=0;
                            while(r.hasNext()){
                                l = r.nextLine();
                                String[] w = l.split(";");
                                if(w[0].equals(mem_id) && w[6].equals("Fine")){
                                    p=1;
                                }
                            }
                            r.close();
                            if(p==0){
                                BufferedReader reader = new BufferedReader(new FileReader(f));
                                PrintWriter pw = new PrintWriter(new FileWriter(tempfile));
                                String read = "";
                                int Z=1;
                                while((read = reader.readLine())!=null){
                                    String[] words = read.split(";");
                                    if(!words[0].equals(id)){
                                        pw.println(read);
                                        pw.flush();
                                    }
                                    else{
                                        String lines = words[0] + ";" + words[1] + ";" + words[2] + ";" + "Borrowed" + ";" + mem_id + ";" + s; 
                                        pw.println(lines);
                                        pw.flush();
                                        Z=0;
                                    }
                                }   
                                pw.close();
                                reader.close();
                                int x=0,y=0;
                                if(Z==0){
                                    if(!f.delete()){
                                        JDialog.setDefaultLookAndFeelDecorated(true);
                                        JOptionPane.showMessageDialog(Borrow_Book.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                        x=1;
                                    }
                                    if(!tempfile.renameTo(f)){
                                        JDialog.setDefaultLookAndFeelDecorated(true);
                                        JOptionPane.showMessageDialog(Borrow_Book.this, "Sorry, an Unexpected error occurerd","Error 2!", JOptionPane.ERROR_MESSAGE);
                                        y=1;
                                    }
                                    if(x==0 && y==0) {
                                        JDialog.setDefaultLookAndFeelDecorated(true);
                                        JOptionPane.showMessageDialog(Borrow_Book.this,"Book borrowed successfully!");    
                                        new Members_Login_Success().setVisible(true);
                                        this.setVisible(false);
                                    }
                                    else{
                                        JDialog.setDefaultLookAndFeelDecorated(true);
                                        JOptionPane.showMessageDialog(Borrow_Book.this, "Sorry, an Unexpected error occurerd","Error 3!", JOptionPane.ERROR_MESSAGE);
                                        new Members_Login_Success().setVisible(true);
                                        this.setVisible(false);
                                    }
                                }
                                else{
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Borrow_Book.this,"Unable to borrow!","Error!", JOptionPane.ERROR_MESSAGE);
                                    new Members_Login_Success().setVisible(true);
                                    this.setVisible(false);
                                }
                            }
                            else{
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Borrow_Book.this,"Please pay your fine before borrowing a book","Fine Error!", JOptionPane.ERROR_MESSAGE);
                                new Members_Login_Success().setVisible(true);
                                this.setVisible(false);
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Change_Book_Author.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Change_Book_Author.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else{
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        JOptionPane.showMessageDialog(Borrow_Book.this,"Please return your previous book before borrowing a new one! You are allowed to borrow only one book at a time!","Borrow Error!", JOptionPane.ERROR_MESSAGE);
                        new Members_Login_Success().setVisible(true);
                        this.setVisible(false);
                    }
                }
                else if(response==JOptionPane.NO_OPTION){
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        JOptionPane.showMessageDialog(Borrow_Book.this,"Borrow Operation cancelled!");    
                        new Members_Login_Success().setVisible(true);
                        this.setVisible(false);
                    }
            }
            else{
                JDialog.setDefaultLookAndFeelDecorated(true);
                JOptionPane.showMessageDialog(Borrow_Book.this,"Book ID is incorrect, or not available", "ID Error!",JOptionPane.ERROR_MESSAGE);
                new Members_Login_Success().setVisible(true);
                this.setVisible(false);
            }
        } catch (IOException ex) {
            Logger.getLogger(Change_Book_Name.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Borrow_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Borrow_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Borrow_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Borrow_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Borrow_Book().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField B_ID;
    private javax.swing.JTextField Mem_ID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
}
