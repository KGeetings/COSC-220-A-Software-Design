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
    
    public PlayerList() {
        thePlayers = new HashMap<>();
        names = new ArrayList<>();
    }
    
    public void addPlayer(Player p) {
        thePlayers.put(p.getName(),p);
        names.add(p.getName());
    }
    
    public Player getPlayer(String name) {
        return thePlayers.get(name);
    }
    
    public ArrayList<String> getNames() {
        return names;
    }
    
}
