/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readarabicfile;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author xabuka
 */
public class ReadFile extends javax.swing.JFrame {

    /**
     * Creates new form ReadFile
     */
    protected File currentInputFilePanelFile;
    
    public ReadFile() {
        initComponents();
    }

    private static final HashSet<Character> repeated = new HashSet<Character>();
    //private static final HashSet<Character> Alef = new HashSet<Character>();
    private static final HashSet<Character> arab = new HashSet<Character>();



    static{
    repeated.add('ب');
    repeated.add('ت');
    repeated.add('ل');
    repeated.add('ه');
    repeated.add('ر');
    repeated.add('م');
    repeated.add('ن');
    repeated.add('ص');
    repeated.add('ط');
    repeated.add('د');
    repeated.add('ف');
    repeated.add('ي');
    repeated.add('ه');
    repeated.add('خ');
    }
    
    static{
    arab.add('ب');    arab.add('ت');
    arab.add('ث');    arab.add('ج');
    arab.add('ح');    arab.add('خ');
    arab.add('د');    arab.add('ذ');
    arab.add('ر');    arab.add('ز');
    arab.add('س');    arab.add('ش');
    arab.add('ص');    arab.add('ض');
    arab.add('ط');    arab.add('ظ');
    arab.add('ع');    arab.add('غ');
    arab.add('ف');    arab.add('ق');
    arab.add('ك');    arab.add('ل');
    arab.add('م');    arab.add('ن');
    arab.add('ه');    arab.add('و');
    arab.add('ي');    arab.add('آ');
    arab.add('أ');    arab.add('إ');
    arab.add('ا');    arab.add('ئ');
    arab.add('ى');    arab.add('ؤ');
  
    }
    
   /* static{
        Alef.add('أ');
        Alef.add('إ');
        Alef.add('آ');
        Alef.add('ا');
        
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jFileChooser2 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        deleteRepeat = new javax.swing.JButton();
        processNormalize = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileprint = new javax.swing.JTextArea();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jFileChooser2.setName("displayOpenFileDialog"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Read");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        deleteRepeat.setText("Process Repeated");
        deleteRepeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRepeatActionPerformed(evt);
            }
        });

        processNormalize.setText("Process Normalize");
        processNormalize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processNormalizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteRepeat))
                    .addComponent(processNormalize))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(deleteRepeat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(processNormalize)
                .addGap(35, 35, 35))
        );

        fileprint.setColumns(20);
        fileprint.setRows(5);
        fileprint.setName("fileprint"); // NOI18N
        jScrollPane1.setViewportView(fileprint);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        currentInputFilePanelFile = null;
        File tempFile = displayOpenFileDialog (currentInputFilePanelFile );
        if ( tempFile != null )
            {
                FileInputStream fileInputStream = null;
            try {
                StringBuffer stringBuffer = new StringBuffer ( );
                fileInputStream = new FileInputStream ( tempFile);
                InputStreamReader inputStreamReader = new InputStreamReader ( fileInputStream);//,"cp1256" );//cp1256
                Reader reader = new BufferedReader ( inputStreamReader );

             int character;
                    while ( ( character = reader.read ( ) ) > -1 )
                    {
                        stringBuffer.append ( ( char ) character );
                    }
                    reader.close ( );
                // put the file contents into the input file text area
                    fileprint.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                    fileprint.setText ( stringBuffer.toString ( ) );
                    fileprint.setCaretPosition ( 0 );
                
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                   
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteRepeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRepeatActionPerformed
        // TODO add your handling code here:
        try {
            BufferedWriter bw = null;
	    FileWriter fw = null;
            //String content = "";
            File arabic_file = displayOpenFileDialog (currentInputFilePanelFile );
            
            final String FILENAME = arabic_file.getName().split("\\.")[0]+".txt";   
            
            fw = new FileWriter(FILENAME,true);
            bw = new BufferedWriter(fw);            

            //Scanner s = new Scanner(arabic_file);
            //System.out.print(arabic_file.getName().split("\\.")[0]);
            ArrayList<String> list = new ArrayList<String>();
            
            // handle new line in file 
            
            Scanner sc = new Scanner(arabic_file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                
                if (line.isEmpty())
                    continue;
                // do whatever processing at the end of each line
                String[] tokens = line.split("\\s");
                for (String token : tokens) {
                    if (token.isEmpty())
                        continue;
                    list.add(token);
                    // do whatever processing for each token
                }
                list.add("\n");
            }
            
       
           
            for (int word =0; word < list.size(); word ++)
                {
                    if (list.get(word) == "\n") { bw.write("\n"); continue;}
                    String nodes = list.get(word);
                    
                    if (nodes.charAt(0) == '،') 
                    {bw.write("\n");
                    continue;
                    }
                  
                    if(! isArab(nodes.charAt(0))) 
                        continue;
                        
                    //fileprint.setText(fileprint.getText() +nodes+"\n");
                    //System.out.println(nodes);
                    if (nodes.length()>1)
                    {if (nodes.charAt(0) == nodes.charAt(1) && (nodes.charAt(0))== 'و')
                    {
                        bw.write("و"+" ");
                        nodes = nodes.substring(1);
                    }}
                    nodes = delete_repeated_character(nodes);
                   // fileprint.setText(fileprint.getText() +nodes+"\n");
                    bw.write(nodes+" ");

                   
                }
            
            fileprint.setText(fileprint.getText()+"\n"+"Finish");
            sc.close();
            if (bw != null)
		bw.close();

            if (fw != null)
		fw.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_deleteRepeatActionPerformed

    private void processNormalizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processNormalizeActionPerformed
        // TODO add your handling code here:
              try {
                  
            char first ;
            char last;
            File arabic_file = displayOpenFileDialog (currentInputFilePanelFile );
      
            BufferedWriter bw = null;
	    FileWriter fw = null;
            final String FILENAME = arabic_file.getName().split("\\.")[0]+".txt";   
            
            // write new file
            fw = new FileWriter(FILENAME,true);
            bw = new BufferedWriter(fw); 
            ArrayList<String> list = new ArrayList<String>();
            
            //handle new line in file 
            
            Scanner sc = new Scanner(arabic_file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                
                if (line.isEmpty())
                    continue;
                
                // do whatever processing at the end of each line
                String[] tokens = line.split("\\s");
                for (String token : tokens) {
                    if (token.isEmpty())
                        continue;
                    list.add(token);
                    // do whatever processing for each token
                }
                list.add("\n");
            }
            
          
            for (int word =0; word < list.size(); word ++)
                {
                    if (list.get(word) == "\n") { bw.write("\n"); continue;}
                    String nodes = list.get(word);
                    first = nodes.charAt(0);
                    last = nodes.charAt(nodes.length()-1);
                    String normalized = nodes ;
                    
                    if (first == 'أ'  || first == 'إ' || first == 'آ')
                       {
                           //bw.write("ا"+nodes.substring(1)+" ");
                           normalized = "ا"+normalized.substring(1);
                           //fileprint.setText(fileprint.getText()+"\n"+"ا"+nodes.substring(1)+"\n");
                           //continue;
                       }
                    if (last == 'ة')
                    {
                        normalized = normalized.substring(0,normalized.length()-1)+"ه";
                    }
                    
                    if (normalized.indexOf('گ') >= 0)
                    {
                        normalized = normalized.substring(0,normalized.indexOf('گ')) +"ك"+ normalized.substring(normalized.indexOf('گ')+1);
                    }
                    
                 
                bw.write(normalized+" ");
                }
                   
               
            
            fileprint.setText(fileprint.getText()+"\n"+"Finish");
            sc.close();
            if (bw != null)
		bw.close();
            if (fw != null)
		fw.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_processNormalizeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReadFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteRepeat;
    private javax.swing.JTextArea fileprint;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processNormalize;
    // End of variables declaration//GEN-END:variables

    protected File displayOpenFileDialog( File openInDirectory) {
        // display the open file dialog

        JFileChooser openfilechoser = new JFileChooser("/Users/");
                //+ "Dropbox/phdsupervision_kathrein/arabic_MT/Katy Corpus");
        openfilechoser.setDialogTitle(" Open ");
        openfilechoser.setPreferredSize(new Dimension(openfilechoser.getPreferredSize().width + 15, openfilechoser.getPreferredSize().height));
        if (openInDirectory != null) {
            openfilechoser.setCurrentDirectory(openInDirectory);
        } else {
            openfilechoser.setCurrentDirectory(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "DataSet"));
        }
        int returnValue = openfilechoser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return openfilechoser.getSelectedFile();
        } else {
            return null;
        }
    }
  
    public static boolean isRepeated(Character c){
    return repeated.contains(c);
}
      public static boolean isArab(Character c){
    return arab.contains(c);
}
 
  private String delete_repeated_character(String s)
  {
     char prev = s.charAt(0);
     int last = 0;
     int start =0;
     String replacement;
     
     
     
     for (int i = 1; i < s.length(); i++) 
     {
         if (prev == s.charAt(i))
         {
            start = i-1;
             last = i;
             for (int j = i+1; j< s.length() ;j++) // to determine how many repeated form
             {
                 if (prev == s.charAt(j))
                 {  last = j;
                     continue;}
                 else
                     break;
            }
             
             
             if (isRepeated(prev)) //( Arrays.asList("ل","م","ن","ت","ب","ص","ر","ط","د","ف","ي","ه","ع","خ").contains(prev) )
             //only keep two occurance // else keep one character
                 replacement = Character.toString(prev)+Character.toString(prev);
             
             else // keep one character
                replacement = Character.toString(prev);
                
           // construct the new string after removeing duplicated   
          s = s.substring(0, start)+replacement+s.substring(last+1);
          
         }
         else // if not similar then move prev to the next letter
         {
             prev = s.charAt(i);
         }
     }
     return s; 
  }
}
