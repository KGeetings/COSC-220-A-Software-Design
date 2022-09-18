/*
 * This class defines a list of players for the guessing game
 */
package guessinggame;

import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author FYFES
 */
public class PlayerList {
    HashMap<String,Player> thePlayers;
    ArrayList<String> names;
    int maxPlayers;
    int numPlayers;
    int currentPlayer;
    
    public PlayerList() {
        thePlayers = new HashMap<>();
        names = new ArrayList<>();
        numPlayers = 0;
        maxPlayers = 0;
        currentPlayer = -1;
    }
    
    public void addPlayer(Player p) {
        thePlayers.put(p.getName(),p);
        names.add(p.getName());
        numPlayers++;
    }
    
    public Player getPlayerByName(String name) {
        return thePlayers.get(name);
    }
    
    public Player getNextPlayer() {
        currentPlayer++;
        if (currentPlayer == maxPlayers)
            currentPlayer = 0;
        Player p = thePlayers.get(names.get(currentPlayer));
        
        return p;
    }
    
    public ArrayList<String> getNames() {
        return names;
    }
    
    public int getNumPlayers() {
        return numPlayers;
    }
    
    public int getMaxPlayers() {
        return maxPlayers;
    }
    
    public void setMax(int max) {
        maxPlayers = max;
    }
    
    public boolean isFirstPlayer() {
        if (currentPlayer == 0)
            return true;
        else
            return false;
    }
    
    public boolean isLastPlayer() {
        if (currentPlayer == (maxPlayers - 1))
            return true;
        else
            return false;
    }
    
}
