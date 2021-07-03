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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Issue_Book extends javax.swing.JFrame {

    public Issue_Book() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        B_ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Mem_ID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setText("RETURN BOOK");
        jLabel1.setPreferredSize(new java.awt.Dimension(99, 22));

        jLabel2.setText("ENTER BOOK ID:");
        jLabel2.setPreferredSize(new java.awt.Dimension(104, 33));

        B_ID.setPreferredSize(new java.awt.Dimension(155, 33));

        jLabel3.setText("ENTER MEMBER ID:");
        jLabel3.setPreferredSize(new java.awt.Dimension(124, 33));

        Mem_ID.setPreferredSize(new java.awt.Dimension(155, 33));
        Mem_ID.setRequestFocusEnabled(false);

        jButton1.setText("RETURN");
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
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Mem_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(B_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 30, Short.MAX_VALUE))
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
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mem_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {        
    	new Librarian_Login_Succes().setVisible(true);
        this.setVisible(false);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        
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
                    
                while((books = readers.readLine())!=null){
                        String[] words = books.split(";");
                        if(words[0].equalsIgnoreCase(id) && words[3].equalsIgnoreCase("Borrowed")){
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
                int response = JOptionPane.showConfirmDialog(Issue_Book.this,new JTextArea("Book Category:\t\t" + args[0] + "\nBook ID:\t\t" + args[1] + "\nBook Name:\t\t" + args[2] + "\nBook Author:\t\t" + args[3] + "\nAvailability:\t\t" + args[4] + "\nBorrowed Member:\t" + args[5] + "\nBorrowed Date:\t\t" + args[6]),"Return Book?",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    Calendar cal = Calendar.getInstance();
                    Date dtf = cal.getTime();
                    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String s = formatter.format(dtf);
                    try {
                        File f = new File("D:/Categories/" + args[0] + ".txt");
                        File tempfile = new File(f.getAbsolutePath() + ".tmp");
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
                                String lines = words[0] + ";" + words[1] + ";" + words[2] + ";" + "Available;-;-";
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                                try {
                                    Date firstDate = sdf.parse(words[5]);
                                    Date secondDate = sdf.parse(s);
                                    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
                                    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                                    BufferedWriter writer1 = new BufferedWriter(new FileWriter("D:/overdue.txt",true));
                                    if(diff>14){
                                        writer1.write(args[5]);
                                        writer1.newLine();
                                    }
                                    writer1.close();
                                    int a=0;
                                    Scanner read1 = new Scanner(new FileReader("D:/overdue.txt"));
                                    while(read1.hasNext()){
                                        books=read1.nextLine();
                                        if(books.equals(mem_id)){
                                            a++;
                                        }
                                    }
                                    if(a%3==0){
                                        File files = new File("D:/members.txt");
                                        File tempfiles = new File(files.getAbsolutePath() + ".tmp");
                                        BufferedReader r = new BufferedReader(new FileReader(files));
                                        PrintWriter p = new PrintWriter(new FileWriter(tempfiles));
                                        String reads = "";
                                        int c=1;
                                        while((reads = r.readLine())!=null){
                                            String[] words1 = reads.split(";");
                                            if(!words1[0].equals(mem_id)){
                                                p.println(reads);
                                                p.flush();
                                            }
                                            else{
                                                String lines1 = words1[0] + ";" + words1[1] + ";" + words[2] + ";" + words1[3] + ";" + words1[4] + ";" + words1[5] + ";Fine";
                                                p.println(lines1);
                                                p.flush();
                                                c=0;
                                            }
                                        }   
                                        p.close();
                                        r.close();
                                        if(c==0){
                                            if(!f.delete()){
                                                JDialog.setDefaultLookAndFeelDecorated(true);
                                                JOptionPane.showMessageDialog(Issue_Book.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                            }
                                            if(!tempfile.renameTo(f)){
                                                JDialog.setDefaultLookAndFeelDecorated(true);
                                                JOptionPane.showMessageDialog(Issue_Book.this, "Sorry, an Unexpected error occurerd","Error 2!", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                        else{
                                            JDialog.setDefaultLookAndFeelDecorated(true);
                                            JOptionPane.showMessageDialog(Issue_Book.this,"Unable to return!","Member Error!", JOptionPane.ERROR_MESSAGE);
                                        }
                                        
                                    }
                                } catch (ParseException ex) {
                                    Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
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
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Issue_Book.this, "Sorry, an Unexpected error occurerd","Error 3!", JOptionPane.ERROR_MESSAGE);
                                x=1;
                            }
                            if(!tempfile.renameTo(f)){
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Issue_Book.this, "Sorry, an Unexpected error occurerd","Error 4!", JOptionPane.ERROR_MESSAGE);
                                y=1;
                            }
                        }
                        else{
                            JDialog.setDefaultLookAndFeelDecorated(true);
                            JOptionPane.showMessageDialog(Issue_Book.this,"Unable to return!","Category Error!", JOptionPane.ERROR_MESSAGE);
                        }
                        File f1 = new File("D:/Members/" + args[5] + ".txt");
                        File tempfile1 = new File(f1.getAbsolutePath() + ".tmp");
                        BufferedReader readers = new BufferedReader(new FileReader(f1));
                        PrintWriter pws = new PrintWriter(new FileWriter(tempfile1));
                        String reads = "";
                        int w=1;
                        while((reads = readers.readLine())!=null){
                            String[] words = reads.split(";");
                            if(!words[0].equals(id)){
                                pws.println(reads);
                                pws.flush();
                            }
                            else{
                                String lines = words[0] + ";" + words[1] + ";" + s;
                                pws.println(lines);
                                pws.flush();
                                w=0;
                            }
                        }   
                        pws.close();
                        readers.close();
                        int u=0,v=0;
                        if(w==0){
                            if(!f1.delete()){
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Issue_Book.this, "Sorry, an Unexpected error occurerd","Error 5!", JOptionPane.ERROR_MESSAGE);
                                u=1;
                            }
                            if(!tempfile1.renameTo(f1)){
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Issue_Book.this, "Sorry, an Unexpected error occurerd","Error 6!", JOptionPane.ERROR_MESSAGE);
                                v=1;
                            }
                        }
                        else{
                            JDialog.setDefaultLookAndFeelDecorated(true);
                            JOptionPane.showMessageDialog(Issue_Book.this,"Unable to return!","Category Error!", JOptionPane.ERROR_MESSAGE);
                        }
                        File f2 = new File("D:/Books/" + args[1] + ".txt");
                        File tempfile2 = new File(f2.getAbsolutePath() + ".tmp");
                        BufferedReader readers1 = new BufferedReader(new FileReader(f2));
                        PrintWriter pws1 = new PrintWriter(new FileWriter(tempfile2));
                        String reads2 = "";
                        int t=1;
                        while((reads2 = readers1.readLine())!=null){
                            String[] words = reads2.split(";");
                            if(!words[0].equals(mem_id)){
                                pws1.println(reads);
                                pws1.flush();
                            }
                            else{
                                String lines = words[0] + ";" + words[1] + ";" + s;
                                pws1.println(lines);
                                pws1.flush();
                                t=0;
                            }
                        }   
                        pws1.close();
                        readers1.close();
                        int r=0,q=0;
                        if(t==0){
                            if(!f2.delete()){
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Issue_Book.this, "Sorry, an Unexpected error occurerd","Error 7!", JOptionPane.ERROR_MESSAGE);
                                r=1;
                            }
                            if(!tempfile2.renameTo(f2)){
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Issue_Book.this, "Sorry, an Unexpected error occurerd","Error 8!", JOptionPane.ERROR_MESSAGE);
                                q=1;
                            }
                            if(q==0 && r==0 && u==0 && v==0 && x==0 && y==0) {
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Issue_Book.this,"Book returned successfully!");    
                                new Librarian_Login_Succes().setVisible(true);
                                this.setVisible(false);
                            }
                            else{
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Issue_Book.this, "Sorry, an Unexpected error occurerd","Error 9!", JOptionPane.ERROR_MESSAGE);
                                new Librarian_Login_Succes().setVisible(true);
                                this.setVisible(false);
                            }
                        }
                        else{
                            JDialog.setDefaultLookAndFeelDecorated(true);
                            JOptionPane.showMessageDialog(Issue_Book.this,"Unable to return!","Category Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }            
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Issue_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Issue_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Issue_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Issue_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Issue_Book().setVisible(true);
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
