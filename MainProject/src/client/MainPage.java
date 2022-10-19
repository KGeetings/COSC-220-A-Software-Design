/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Kenyon
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    public MainPage() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mySentMessagesTextArea = new javax.swing.JTextArea();
        mySentMessagesLabel = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        peopleFollowingLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        peopleFollowingTextArea = new javax.swing.JTextArea();
        followThemLabel = new javax.swing.JLabel();
        usernameFollowThemLabel = new javax.swing.JLabel();
        followThemTextField = new javax.swing.JTextField();
        followThemButton = new javax.swing.JButton();
        unfollowThemLabel = new javax.swing.JLabel();
        usernameUnfollowThemLabel = new javax.swing.JLabel();
        unfollowThemTextField = new javax.swing.JTextField();
        unfollowThemButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        homeFeedTextArea = new javax.swing.JTextArea();
        refreshFeedButton = new javax.swing.JButton();
        feedTextLabel = new javax.swing.JLabel();
        joinConversationLabel = new javax.swing.JLabel();
        createMesssageButton = new javax.swing.JButton();
        peopleOnlineLabel = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        peopleOnlineTextArea = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        searchHashtagLabel = new javax.swing.JLabel();
        searchHashtagTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        hashtagFeedTextArea = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        receivePrivateMessageTextArea = new javax.swing.JTextArea();
        receivePrivateMessageLabel = new javax.swing.JLabel();
        sendPrivateMessageLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        sendPrivateMessageTextArea = new javax.swing.JTextArea();
        sendPrivateMessageButton = new javax.swing.JButton();
        whoToMessageLabel = new javax.swing.JLabel();
        usernameToMessageTextField = new javax.swing.JTextField();
        goWhoToMessageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mySentMessagesTextArea.setColumns(20);
        mySentMessagesTextArea.setRows(5);
        jScrollPane2.setViewportView(mySentMessagesTextArea);

        mySentMessagesLabel.setText("My Sent Messages:");

        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        peopleFollowingLabel.setText("People I'm Following:");

        peopleFollowingTextArea.setColumns(20);
        peopleFollowingTextArea.setRows(5);
        jScrollPane5.setViewportView(peopleFollowingTextArea);

        followThemLabel.setText("Like another user's posts? Follow them!");

        usernameFollowThemLabel.setText("Username:");

        followThemButton.setText("Follow");
        followThemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followThemButtonActionPerformed(evt);
            }
        });

        unfollowThemLabel.setText("Tired of someone? Unfollow them!");

        usernameUnfollowThemLabel.setText("Username:");

        unfollowThemButton.setText("Unfollow");
        unfollowThemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unfollowThemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mySentMessagesLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(peopleFollowingLabel)
                                .addGap(82, 82, 82)
                                .addComponent(followThemLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(usernameFollowThemLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(followThemTextField))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(unfollowThemLabel)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(usernameUnfollowThemLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(unfollowThemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(followThemButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(unfollowThemButton, javax.swing.GroupLayout.Alignment.TRAILING)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logOutButton)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mySentMessagesLabel)
                    .addComponent(peopleFollowingLabel)
                    .addComponent(followThemLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameFollowThemLabel)
                            .addComponent(followThemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(followThemButton)
                        .addGap(17, 17, 17)
                        .addComponent(unfollowThemLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameUnfollowThemLabel)
                            .addComponent(unfollowThemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unfollowThemButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(logOutButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("My Profile", jPanel2);

        homeFeedTextArea.setColumns(20);
        homeFeedTextArea.setRows(5);
        jScrollPane1.setViewportView(homeFeedTextArea);

        refreshFeedButton.setText("Refresh Feed (go to most recent)");

        feedTextLabel.setText("See what others are saying:");

        joinConversationLabel.setText("Join in the conversation:");

        createMesssageButton.setText("Create message");
        createMesssageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createMesssageButtonActionPerformed(evt);
            }
        });

        peopleOnlineLabel.setText("People you know currently online:");

        peopleOnlineTextArea.setColumns(20);
        peopleOnlineTextArea.setRows(5);
        jScrollPane7.setViewportView(peopleOnlineTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(joinConversationLabel)
                        .addGap(18, 18, 18)
                        .addComponent(createMesssageButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(feedTextLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshFeedButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(peopleOnlineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane7))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshFeedButton)
                    .addComponent(feedTextLabel)
                    .addComponent(peopleOnlineLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joinConversationLabel)
                    .addComponent(createMesssageButton))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Home", jPanel1);

        searchHashtagLabel.setText("Search for a hashtag:");

        searchButton.setText("Search");

        hashtagFeedTextArea.setColumns(20);
        hashtagFeedTextArea.setRows(5);
        jScrollPane6.setViewportView(hashtagFeedTextArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(searchHashtagLabel)
                        .addGap(18, 18, 18)
                        .addComponent(searchHashtagTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton)
                        .addGap(0, 484, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchHashtagLabel)
                    .addComponent(searchHashtagTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Search", jPanel3);

        receivePrivateMessageTextArea.setColumns(20);
        receivePrivateMessageTextArea.setRows(5);
        jScrollPane3.setViewportView(receivePrivateMessageTextArea);

        receivePrivateMessageLabel.setText("Receive a private message:");

        sendPrivateMessageLabel.setText("Send a private message:");

        sendPrivateMessageTextArea.setColumns(20);
        sendPrivateMessageTextArea.setRows(5);
        jScrollPane4.setViewportView(sendPrivateMessageTextArea);

        sendPrivateMessageButton.setText("Send");

        whoToMessageLabel.setText("Who do you want to message?");

        goWhoToMessageButton.setText("Go");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendPrivateMessageLabel)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(sendPrivateMessageButton)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(receivePrivateMessageLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(whoToMessageLabel)
                                .addGap(0, 64, Short.MAX_VALUE))
                            .addComponent(usernameToMessageTextField)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(goWhoToMessageButton)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receivePrivateMessageLabel)
                    .addComponent(whoToMessageLabel))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(usernameToMessageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(goWhoToMessageButton)))
                .addGap(18, 18, 18)
                .addComponent(sendPrivateMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendPrivateMessageButton)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DM", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createMesssageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMesssageButtonActionPerformed
        /// Open the CreateMessage window, modal
        CreateMessage createMessage = new CreateMessage(this, true);
        createMessage.setVisible(true);
    }//GEN-LAST:event_createMesssageButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        try (Socket connector = new Socket("localhost", 2001)) {
            InputStream inStream = connector.getInputStream();
            OutputStream outStream = connector.getOutputStream();

            try (Scanner in = new Scanner(inStream)) {
                PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream), true);

                // Send "REGISTER" to server
                out.println("LOGOUT");

                // Check if username is saved in Client.java
                if (Client.username != null) {
                    // Send username to server
                    out.println(Client.username);
                } else {
                    // Popup error message
                    javax.swing.JOptionPane.showMessageDialog(this, "How did you get here?");
                }
                
                // Receive response from server
                String response = in.nextLine();
                            
                // If response is "success", then close the window and return to login page
                if (response.equals("SUCCESS")) {
                    this.dispose();
                } if (response.equals("FAILURE")) {
                    // Get next line from server and display it as a popup error
                    String error = in.nextLine();
                    javax.swing.JOptionPane.showMessageDialog(this, error);
                }
                //Set Client.username to null
                Client.username = null;
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // Check if we have already logged out, if not, log out
        if (Client.username != null) {
            try (Socket connector = new Socket("localhost", 2001)) {
                InputStream inStream = connector.getInputStream();
                OutputStream outStream = connector.getOutputStream();

                try (Scanner in = new Scanner(inStream)) {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream), true);

                    // Send "REGISTER" to server
                    out.println("LOGOUT");

                    // Check if username is saved in Client.java
                    if (Client.username != null) {
                        // Send username to server
                        out.println(Client.username);
                    } else {
                        // Popup error message
                        javax.swing.JOptionPane.showMessageDialog(this, "How did you get here?");
                    }
                    
                    // Receive response from server
                    String response = in.nextLine();
                                
                    // If response is "success", then close the window and return to login page
                    if (response.equals("SUCCESS")) {
                        this.dispose();
                    } if (response.equals("FAILURE")) {
                        // Get next line from server and display it as a popup error
                        String error = in.nextLine();
                        javax.swing.JOptionPane.showMessageDialog(this, error);
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Check if we have already logged out, if not, log out
        if (Client.username != null) {
            try (Socket connector = new Socket("localhost", 2001)) {
                InputStream inStream = connector.getInputStream();
                OutputStream outStream = connector.getOutputStream();

                try (Scanner in = new Scanner(inStream)) {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream), true);

                    // Send "REGISTER" to server
                    out.println("LOGOUT");

                    // Check if username is saved in Client.java
                    if (Client.username != null) {
                        // Send username to server
                        out.println(Client.username);
                    } else {
                        // Popup error message
                        javax.swing.JOptionPane.showMessageDialog(this, "How did you get here?");
                    }
                    
                    // Receive response from server
                    String response = in.nextLine();
                                
                    // If response is "success", then close the window and return to login page
                    if (response.equals("SUCCESS")) {
                        this.dispose();
                    } if (response.equals("FAILURE")) {
                        // Get next line from server and display it as a popup error
                        String error = in.nextLine();
                        javax.swing.JOptionPane.showMessageDialog(this, error);
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void followThemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followThemButtonActionPerformed
        // Get the username of the user we want to follow from the text field and store it in a variable
        String username = followThemTextField.getText();
        
        // Check if we have selected a user
        if (username != null) {
            try (Socket connector = new Socket("localhost", 2001)) {
                InputStream inStream = connector.getInputStream();
                OutputStream outStream = connector.getOutputStream();

                try (Scanner in = new Scanner(inStream)) {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream), true);

                    // Send "FOLLOW" to server
                    out.println("FOLLOW");

                    // Send username to server
                    out.println(Client.username);
                    
                    // Send username of user we want to follow
                    out.println(username);
                    
                    // Receive response from server
                    String response = in.nextLine();
                                
                    // If response is "success", then popup message saying we have followed the user
                    if (response.equals("SUCCESS")) {
                        javax.swing.JOptionPane.showMessageDialog(this, "You are now following " + username);
                    } if (response.equals("FAILURE")) {
                        // Get next line from server and display it as a popup error
                        String error = in.nextLine();
                        javax.swing.JOptionPane.showMessageDialog(this, error);
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else {
            // Popup error message
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a user to follow");
        }
    }//GEN-LAST:event_followThemButtonActionPerformed

    private void unfollowThemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unfollowThemButtonActionPerformed
        // Get the username of the user we want to unfollow from the text field and store it in a variable
        String username = unfollowThemTextField.getText();
        
        // Check if we have selected a user
        if (username != null) {
            try (Socket connector = new Socket("localhost", 2001)) {
                InputStream inStream = connector.getInputStream();
                OutputStream outStream = connector.getOutputStream();

                try (Scanner in = new Scanner(inStream)) {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream), true);

                    // Send "UNFOLLOW" to server
                    out.println("UNFOLLOW");

                    // Send username to server
                    out.println(Client.username);
                    
                    // Send username of user we want to unfollow
                    out.println(username);
                    
                    // Receive response from server
                    String response = in.nextLine();
                                
                    // If response is "success", popup message that we have unfollowed the user
                    if (response.equals("SUCCESS")) {
                        javax.swing.JOptionPane.showMessageDialog(this, "You have unfollowed " + username);
                    } if (response.equals("FAILURE")) {
                        // Get next line from server and display it as a popup error
                        String error = in.nextLine();
                        javax.swing.JOptionPane.showMessageDialog(this, error);
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else {
            // Popup error message
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a user to unfollow");
        }
    }//GEN-LAST:event_unfollowThemButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createMesssageButton;
    private javax.swing.JLabel feedTextLabel;
    private javax.swing.JButton followThemButton;
    private javax.swing.JLabel followThemLabel;
    private javax.swing.JTextField followThemTextField;
    private javax.swing.JButton goWhoToMessageButton;
    private javax.swing.JTextArea hashtagFeedTextArea;
    private javax.swing.JTextArea homeFeedTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel joinConversationLabel;
    private javax.swing.JButton logOutButton;
    private javax.swing.JLabel mySentMessagesLabel;
    private javax.swing.JTextArea mySentMessagesTextArea;
    private javax.swing.JLabel peopleFollowingLabel;
    private javax.swing.JTextArea peopleFollowingTextArea;
    private javax.swing.JLabel peopleOnlineLabel;
    private javax.swing.JTextArea peopleOnlineTextArea;
    private javax.swing.JLabel receivePrivateMessageLabel;
    private javax.swing.JTextArea receivePrivateMessageTextArea;
    private javax.swing.JButton refreshFeedButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchHashtagLabel;
    private javax.swing.JTextField searchHashtagTextField;
    private javax.swing.JButton sendPrivateMessageButton;
    private javax.swing.JLabel sendPrivateMessageLabel;
    private javax.swing.JTextArea sendPrivateMessageTextArea;
    private javax.swing.JButton unfollowThemButton;
    private javax.swing.JLabel unfollowThemLabel;
    private javax.swing.JTextField unfollowThemTextField;
    private javax.swing.JLabel usernameFollowThemLabel;
    private javax.swing.JTextField usernameToMessageTextField;
    private javax.swing.JLabel usernameUnfollowThemLabel;
    private javax.swing.JLabel whoToMessageLabel;
    // End of variables declaration//GEN-END:variables
}
