/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import java.util.Scanner;

/**
 *
 * @author jacksonrkj
 */
public class SelectPlayersView {
    
    private Game game;
    private Player[] playerList;

    public SelectPlayersView(Game game) {
        this.game = game;
        playerList = TicTacToe.getPlayerList();
    }

    
    public boolean getInput() {
        
        this.displayNameList(); // display the list of names
        
        // if one player game
        if (Game.ONE_PLAYER.equals(this.game.getGameType())) {
           System.out.println("\tPlease enter the number of the player.");

            // get the players name
            Player player = this.getPlayer();
            if (player ==  null) {
                return false;
            }
           
            this.game.setPlayerA(player);
            this.game.getPlayerB().setName("Computer");
        }
        
        // else two player game
        else { 
            System.out.println("\tPlease enter the number of the first player.");
            // get first players name
            Player player1 = this.getPlayer();
            if (player1 ==  null) {
                return false;
            }
             

            // get the second players name
            System.out.println("\tPlease enter the number of the second player.");
            Player player2 = this.getPlayer();
            if (player2 ==  null) {
                return false;
            }
            
            this.game.setPlayerA(player1);
            this.game.setPlayerB(player2);
            
        }
        
        return true;
        
    }
    

    public Player getPlayer() {
        
        Player player = null;
        Scanner inFile = new Scanner(System.in);
        
        boolean valid = false;
        while (!valid) {
            String strNumber = inFile.nextLine();
            
            if (strNumber.length() < 1) { // was a value entered ?
                new TicTacToeError().displayError("You must enter a name or enter a \"Q\" to quit. Try again.");
                continue;
            }
            
            strNumber = strNumber.trim(); // trim off all blanks from front and back    
            strNumber = strNumber.substring(0, 1); // get only the first character
            
            if (strNumber.toUpperCase().equals("Q")) { // quit?
                return null;
            }
                    
            if (!strNumber.matches("[0-9]+")) { // is the value entered a number?
                new TicTacToeError().displayError("You must enter a number in the list. Try again.");
                continue;
            }
            
            int numberSelected = Integer.parseInt(strNumber); // convert string to integer
            
            // is the number outside the range of the list of names
            if (numberSelected < 1  ||  numberSelected > this.playerList.length) {
                new TicTacToeError().displayError("You must enter a number from the list. Try again.");
                continue;
            }
            
            player = this.playerList[numberSelected-1]; // get the player from the list
            if (alreadyInList(playerList, player)) { // player already selected?
                new TicTacToeError().displayError(
                        "That player has already been selected. Try again.");
                continue;
            }
            
            valid = true; // valid name selected
      
        } while (!valid);
        
        return player;
    }
    
    
    public void displayNameList() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tSelect the player/s who will be playing the game.");
        System.out.println("\tEnter the number of a player below:");

        for (int i = 0; i < this.playerList.length; i++) {
            int namePosition = i+1;
            System.out.println("\t   " + namePosition + "\t" + playerList[i].getName());
        }
        System.out.println("\t===============================================================\n");
    }
    
    
    private boolean alreadyInList(Player[] listOfPlayers, Player selectedPlayer) {
        for (Player player : listOfPlayers) {
            if (player.getName().equals(selectedPlayer.getName())) {
                return true;
            }           
        }
        return false;
    }
    
    
}
