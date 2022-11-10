/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stephen Fyfe
 */
public class CommInfo {
    private String serverIP;
    private int serverPort;
    
    public CommInfo(String ip, int port) {
        serverIP = ip;
        serverPort = port;
    }
    
    public String getIP() {
        return serverIP;
    }
    
    public int getPort() {
        return serverPort;
    }
}
