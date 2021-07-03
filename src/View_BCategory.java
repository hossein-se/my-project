package library_service;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class View_BCategory extends javax.swing.JFrame {

    public View_BCategory() {
        super("View Book Category");
        setSize(650, 415);
        
        try{
            int j=0,k=0,z=0;
            Scanner reader1 = new Scanner(new File("D:/categories.txt"));
            String books;
            String cat[] = new String[20];
            while(reader1.hasNext()){
                cat[j++] = reader1.nextLine();
            }
            reader1.close();
            String[][] args = new String[100][5];
            for(int i=0;i<j;i++){
                BufferedReader readers = new BufferedReader(new FileReader("D:/Categories/" + cat[i] + ".txt"));
                    int x=0,y=0,m=0,n=0;
                    while((books = readers.readLine())!=null){
                        String[] words = books.split(";");
                        x++;
                        if(words[3].equalsIgnoreCase("available"))
                            y++;
                        else if(words[3].equalsIgnoreCase("Borrowed"))
                            m++;
                        else if(words[3].equalsIgnoreCase("lost"))
                            n++;
                    }
                    args[k][0] = cat[i];
                    args[k][1] = String.valueOf(x);
                    args[k][2] = String.valueOf(y);
                    args[k][3] = String.valueOf(m);
                    args[k][4] = String.valueOf(n);
                    k++;
                    readers.close();
            }
                
            String[][] args1 = new String[k][5];
            for(int i=0;i<k;i++)
                for(j=0;j<5;j++)
                    args1[i][j]=args[i][j];
            JTable jt = new JTable(args1, new String[] { "CATEGORY", "TOTAL BOOKS", "BOOKS AVAILABLE", "BOOKS BORROWED", "BOOKS LOST" });
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
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_BCategory().setVisible(true);
            }
        });
    }
}
