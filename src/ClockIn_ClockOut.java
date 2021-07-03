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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClockIn_ClockOut extends javax.swing.JFrame {

    public ClockIn_ClockOut() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Lib_ID = new javax.swing.JTextField();
        Lib_PIN = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setText("CLOCK IN/CLOCK OUT");
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 22));

        jLabel2.setText("ENTER ID:");
        jLabel2.setPreferredSize(new java.awt.Dimension(80, 33));

        Lib_ID.setPreferredSize(new java.awt.Dimension(155, 33));

        Lib_PIN.setPreferredSize(new java.awt.Dimension(155, 33));

        jLabel3.setText("ENTER UNIQUE PIN NUMBER:");
        jLabel3.setPreferredSize(new java.awt.Dimension(174, 33));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CLOCK IN/CLOCK OUT");
        jButton2.setPreferredSize(new java.awt.Dimension(160, 25));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CLOCK IN", "CLOCK OUT" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Lib_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Lib_PIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lib_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lib_PIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	new Librarian_Login_Succes().setVisible(true);
        this.setVisible(false);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {        
    	String id = Lib_ID.getText();
        String pin = String.valueOf(Lib_PIN.getText());
        File f = new  File("D:/Librarians/" + id + ".txt");
        if(f.exists()){
            try{
                BufferedReader reader1 = new BufferedReader(new FileReader("D:/librarians.txt"));
                String line = "";
                int i=0,j=0;
                while((line=reader1.readLine())!=null){
                    String[] words = line.split(";");
                    if(words[0].trim().equals(id)){
                        i=1;
                        if(words[5].equals(pin))
                            j=1;
                    }
                }
                reader1.close();
                if(i==0){
                    JOptionPane.showMessageDialog(ClockIn_ClockOut.this,"ID doesn't exists","ID Error!", JOptionPane.ERROR_MESSAGE);
                    Lib_ID.setText("");
                    Lib_PIN.setText("");
                }
                else{
                    if(j==0){
                        JOptionPane.showMessageDialog(ClockIn_ClockOut.this,"PIN you entered is incorrect","PIN Error!", JOptionPane.ERROR_MESSAGE);
                        Lib_PIN.setText("");
                    }
                    else{
                        String choice = (String)jComboBox1.getSelectedItem();
                        File tempfile = new File(f.getAbsolutePath() + ".tmp");
                        if(choice.equals("Clock Out")){
                            try {
                                BufferedReader reader = new BufferedReader(new FileReader(f));
                                PrintWriter pw = new PrintWriter(new FileWriter(tempfile));
                                String read = "";
                                int z=1;
                                String[] words = new String[3];
                                while((read = reader.readLine())!=null){
                                    words=read.split(";");
                                    if(!words[1].equals("-") && !words[2].equals("-")){
                                        pw.println(read);
                                        pw.flush();
                                    }
                                    else{
                                        z=0;
                                    }
                                }   
                                Calendar cal = Calendar.getInstance();
                                Date dtf = cal.getTime();
                                Format formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                String s = formatter.format(dtf);
                                SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                                Date d1 = formats.parse(s);
                                Date d2 = formats.parse(words[0]);
                                long diff = d1.getTime() - d2.getTime();
                                double hours = ((double)diff)/(60*60*1000);
                                pw.println(words[0] + ";" + s + ";" + Double.toString(hours));
                                pw.flush();
                                pw.close();
                                reader.close();
                                int x=0,y=0;
                                if(z==0){
                                    if(!f.delete()){
                                        JOptionPane.showMessageDialog(ClockIn_ClockOut.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                        x=1;
                                    }
                                    if(!tempfile.renameTo(f)){
                                        JOptionPane.showMessageDialog(ClockIn_ClockOut.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                        y=1;
                                    }
                                    if(x==0 && y==0) {
                                        JOptionPane.showMessageDialog(ClockIn_ClockOut.this,"Clocked Out!");    
                                        new Librarian_Login_Succes().setVisible(true);
                                        this.setVisible(false);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(ClockIn_ClockOut.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                        new Librarian_Login_Succes().setVisible(true);
                                        this.setVisible(false);
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(ClockIn_ClockOut.this,"Unable to clock!","Clock Error!", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(ClockIn_ClockOut.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(ClockIn_ClockOut.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ParseException ex) {
                                Logger.getLogger(ClockIn_ClockOut.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{
                            try {
                                BufferedReader reader = new BufferedReader(new FileReader(f));
                                String read = "";
                                int z=1;
                                String[] words = new String[3];
                                while((read = reader.readLine())!=null){
                                    words=read.split(";");
                                    if(words[1].equals("-") && words[2].equals("-")){
                                        z=0;
                                    }
                                }  
                                reader.close(); 
                                if(z==0){
                                    JOptionPane.showMessageDialog(ClockIn_ClockOut.this,"You haven't clocked out yet. Please clock out before you clock in!","Clock Error!", JOptionPane.ERROR_MESSAGE);
                                    Lib_ID.setText("");
                                    Lib_PIN.setText("");
                                }
                                else{
                                    PrintWriter pw = new PrintWriter(new FileWriter(f,true));
                                    Calendar cal = Calendar.getInstance();
                                    Date dtf = cal.getTime();
                                    Format formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                    String s = formatter.format(dtf);
                                    pw.println(s + ";-;-");
                                    pw.flush();
                                    pw.close();
                                    JOptionPane.showMessageDialog(ClockIn_ClockOut.this,"Clocked In!");    
                                    new Librarian_Login_Succes().setVisible(true);
                                    this.setVisible(false);
                                }
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(ClockIn_ClockOut.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(ClockIn_ClockOut.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }  
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ClockIn_ClockOut.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClockIn_ClockOut.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {        
    	
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
            java.util.logging.Logger.getLogger(ClockIn_ClockOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClockIn_ClockOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClockIn_ClockOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClockIn_ClockOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClockIn_ClockOut().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField Lib_ID;
    private javax.swing.JPasswordField Lib_PIN;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    
}
