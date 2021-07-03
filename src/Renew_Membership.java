package library_service;

import java.io.BufferedReader;
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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class Renew_Membership extends javax.swing.JFrame {


    public Renew_Membership() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Mem_ID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("RENEW MEMBERSHIP");
        jLabel1.setPreferredSize(new java.awt.Dimension(175, 22));

        jLabel2.setText("ENTER ID:");

        Mem_ID.setPreferredSize(new java.awt.Dimension(155, 33));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("RENEW");
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
                                .addGap(106, 106, 106)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2)
                                .addGap(78, 78, 78)
                                .addComponent(Mem_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Mem_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Members_Login_Success().setVisible(true);
        this.setVisible(false);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        BufferedReader reader = null;
        try {
         
            //int k=1;
            String id = Mem_ID.getText();
            File infile = new File("D:/members.txt");
            File tempfile = new File(infile.getAbsolutePath() + ".tmp");
            reader = new BufferedReader(new FileReader(infile));
            PrintWriter pw = new PrintWriter(new FileWriter(tempfile));
            String[] libs = new String[7];
            String read = "";
            while((read = reader.readLine())!=null){
                libs = read.split(";");
                if(!libs[0].trim().equals(id)){
                    pw.println(read);
                    pw.flush();
                }
                else{
                    //k=0;
                    if(libs[6].equals("-")){
                        Calendar cal = Calendar.getInstance();
                        Date dtf = cal.getTime();
                        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
                        String s = formatter.format(dtf);
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        Date firstDate = sdf.parse(libs[5]);
                        Date secondDate = sdf.parse(s);
                        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
                        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                        if(diff>365){
                            String word = libs[0] + ";" + libs[1] + ";" + libs[2] + ";" + libs[3] + ";" + libs[4] + ";" + s + ";" + libs[6];
                            pw.println(word);
                            pw.flush();
                        }
                        else{
                            JDialog.setDefaultLookAndFeelDecorated(true);
                            JOptionPane.showMessageDialog(Renew_Membership.this, "Your duration isn't over yet. You can renew your membership after your duration is over","No Need to Renew!", JOptionPane.ERROR_MESSAGE);
                            new Members_Login_Success().setVisible(true);
                            this.setVisible(false);
                        }
                    }
                    else{
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        JOptionPane.showMessageDialog(Renew_Membership.this, "Please pay your fine to a librarian, and he/she will renew your membership","Fine!", JOptionPane.ERROR_MESSAGE);
                        new Members_Login_Success().setVisible(true);
                        this.setVisible(false);
                    }
                }
                pw.close();
                reader.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Renew_Membership.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Renew_Membership.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Renew_Membership.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Renew_Membership.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Renew_Membership.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Renew_Membership.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Renew_Membership.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Renew_Membership.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Renew_Membership().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField Mem_ID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
}
