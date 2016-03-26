/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.parser.Scanner;

/**
 *
 * @author Albertyson
 */
public class formPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form fomrPrincipal
     */
    public formPrincipal() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFileName = new javax.swing.JTextField();
        btnParse = new javax.swing.JButton();
        btnShowTree = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        btnClean = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFile = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        mnuReadFile = new javax.swing.JMenuItem();
        mnuLexer = new javax.swing.JMenuItem();
        mnuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtFileName.setEnabled(false);

        btnParse.setText("Parsear");
        btnParse.setEnabled(false);
        btnParse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnParseMouseClicked(evt);
            }
        });

        btnShowTree.setText("Mostrar Árbol");
        btnShowTree.setEnabled(false);
        btnShowTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowTreeMouseClicked(evt);
            }
        });

        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane2.setViewportView(txtOutput);

        btnClean.setText("Limpiar");
        btnClean.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCleanMouseClicked(evt);
            }
        });

        txtFile.setColumns(20);
        txtFile.setRows(5);
        txtFile.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFile.setEnabled(false);
        jScrollPane1.setViewportView(txtFile);

        jMenu2.setText("Opciones");

        mnuReadFile.setText("Leer Archivo .adb");
        mnuReadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuReadFileActionPerformed(evt);
            }
        });
        jMenu2.add(mnuReadFile);

        mnuLexer.setText("Generar lexer");
        mnuLexer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLexerActionPerformed(evt);
            }
        });
        jMenu2.add(mnuLexer);

        mnuExit.setText("Salir");
        jMenu2.add(mnuExit);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFileName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnParse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnShowTree)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClean)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnParse)
                    .addComponent(btnShowTree)
                    .addComponent(btnClean))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuReadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuReadFileActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("./src/mainPackage/"));
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                currentFile = fc.getSelectedFile();
                txtFileName.setText(currentFile.getPath());
                btnParse.setEnabled(true);
                FileReader fr = new FileReader(currentFile);
                BufferedReader br = new BufferedReader(fr);
                txtFile.setText("");
                String linea= "";
                int lineNumber = 1;
                txtFile.setTabSize(4);
                while ((linea = br.readLine())!=null) {
                    txtFile.append(lineNumber + "\t");
                    txtFile.append(linea);
                    txtFile.append("\n");
                    lineNumber++;
                }
            } else {
                txtFileName.setText("");
                btnParse.setEnabled(true);
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_mnuReadFileActionPerformed

    private void mnuLexerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLexerActionPerformed
        // TODO add your handling code here:
        try {
            //pasa la salida estándar al textarea
            PrintStream printStream = new PrintStream(new CustomOutputStream(txtOutput));
            System.setOut(printStream);
            System.setErr(printStream);
            
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("./"));
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File lexerFile = fc.getSelectedFile();
                generarLexer(lexerFile.getPath());
                JOptionPane.showMessageDialog(null, "Se ha generado el lexer", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            txtOutput.setText(e.getMessage());
        }

    }//GEN-LAST:event_mnuLexerActionPerformed

    private void btnParseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParseMouseClicked
        // TODO add your handling code here:
        try {
            PrintStream printStream = new PrintStream(new CustomOutputStream(txtOutput));
            System.setOut(printStream);
            System.setErr(printStream);
            parser p = new parser(new Lexer2(new FileReader(currentFile.getPath())));
            Object result = p.parse().value;
            btnShowTree.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnParseMouseClicked

    private void btnCleanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCleanMouseClicked
        // TODO add your handling code here:
        txtOutput.setText("");
    }//GEN-LAST:event_btnCleanMouseClicked

    private void btnShowTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowTreeMouseClicked
        // TODO add your handling code here:
        try{
            File htmlFile = new File("src/mainPackage/ast.xml");
            Desktop.getDesktop().browse(htmlFile.toURI());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
    }//GEN-LAST:event_btnShowTreeMouseClicked

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
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPrincipal().setVisible(true);
            }
        });
    }

    public void generarLexer(String path) {
        File f = new File(path);
        jflex.Main.generate(f);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnParse;
    private javax.swing.JButton btnShowTree;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuItem mnuLexer;
    private javax.swing.JMenuItem mnuReadFile;
    private javax.swing.JTextArea txtFile;
    private javax.swing.JTextField txtFileName;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables
    File currentFile;
}
