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
        currentPlayer = 0;
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
        Player p = thePlayers.get(names.get(currentPlayer));
        currentPlayer++;
        if (currentPlayer == maxPlayers)
            currentPlayer = 0;
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
    
}
