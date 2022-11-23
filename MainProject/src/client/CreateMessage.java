/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author Kenyon
 */
public class CreateMessage extends javax.swing.JDialog {

    /**
     * Creates new form CreateMessage
     */
    public CreateMessage(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sendMessageButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        hashtagTextArea = new javax.swing.JTextField();
        hashtagLabel = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Say something brilliant:");

        sendMessageButton.setText("Send");
        sendMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageButtonActionPerformed(evt);
            }
        });

        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        jScrollPane1.setViewportView(messageTextArea);

        hashtagLabel.setText("Hashtag:");

        messageLabel.setText("Message:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(hashtagTextArea, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sendMessageButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(hashtagLabel)
                            .addComponent(messageLabel))
                        .addGap(0, 192, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(messageLabel)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hashtagLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hashtagTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendMessageButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessageButtonActionPerformed
        // Send message to server
        String username = Client.username;
        String message = messageTextArea.getText();
        String hashtag = hashtagTextArea.getText();

        // check if message has new line characters, if so, replace with space
        if (message.contains("\n")) {
            message = message.replace("\n", " ");
        }

        try (Socket connector = new Socket(Client.serverIP, 2001)) {
            InputStream inStream = connector.getInputStream();
            OutputStream outStream = connector.getOutputStream();

            try (Scanner in = new Scanner(inStream)) {
                PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream), true);

                // Send "SENDPUBLICMESSAGE" to server
                out.println("SENDPUBLICMESSAGE");

                // Send username, hashtag, then message to server
                out.println(username);
                out.println(hashtag);
                out.println(message);

                // Receive response from server
                String response = in.nextLine();

                // If response is "SUCCESS", then message was sent successfully
                if (response.equals("SUCCESS")) {
                    // Add this message to the client's message list, as well as the hashtag
                    Client.messages.add(message);
                    Client.hashtags.add(hashtag);
                    // Close dialog
                    this.dispose();
                }
                // If response is "FAILURE", then message was not sent successfully
                else if (response.equals("FAILURE")) {
                    // Get next line from server and display it as a popup error
                    String error = in.nextLine();
                    javax.swing.JOptionPane.showMessageDialog(this, error);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_sendMessageButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    /* public static void main(String args[]) {
        //Set the Nimbus look and feel
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        //If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        //or details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //Create and display the dialog
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateMessage dialog = new CreateMessage(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    } */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hashtagLabel;
    private javax.swing.JTextField hashtagTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JButton sendMessageButton;
    // End of variables declaration//GEN-END:variables
}
