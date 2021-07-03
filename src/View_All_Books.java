package library_service;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class View_All_Books extends javax.swing.JFrame {


    public View_All_Books() {
        super("View Books");
        setSize(1000, 415);
        try{
            int j=0,k=0,z=0;
            Scanner reader1 = new Scanner(new File("D:/categories.txt"));
            String books;
            String cat[] = new String[20];
            while(reader1.hasNext()){
                cat[j++] = reader1.nextLine();
            }
            reader1.close();
            String[][] args = new String[100][7];
            for(int i=0;i<j;i++){
                BufferedReader readers = new BufferedReader(new FileReader("D:/Categories/" + cat[i] + ".txt"));
                    while((books = readers.readLine())!=null){
                        String[] words = books.split(";");
                        args[k][0] = cat[i];
                        args[k][1] = words[0];
                        args[k][2] = words[1];
                        args[k][3] = words[2];
                        args[k][4] = words[3];
                        args[k][5] = words[4];
                        args[k][6] = words[5];
                        k++;
                    }
                    readers.close();
            }
            String[][] args1 = new String[k][7];
            for(int i=0;i<k;i++)
                for(j=0;j<7;j++)
                    args1[i][j]=args[i][j];
            JTable jt = new JTable(args1, new String[] { "CATEGORY", "BOOK ID", "NAME", "AUTHOR", "AVAILABILTY", "BORROWED MEMBER", "BORROWED DATE" });
            JScrollPane jsp = new JScrollPane(jt);
            getContentPane().add(jsp, BorderLayout.CENTER);
        }catch(IOException e){
            e.printStackTrace();
        }
            }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
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
            java.util.logging.Logger.getLogger(View_All_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_All_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_All_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_All_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_All_Books().setVisible(true);
            }
        });
    }


}
