/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author jacksonrkj
 */
public class BoardView {
    
    Board board;
    
    public Object displayBoard(Object object) {
        this.board = (Board) object;
        this.printHeadRow();
        this.printDividerRow();
        for (int i = 0; i < this.board.getRowCount(); i++) {
            Player[] rowOfLocations = this.board.getBoardLocations()[i];
            this.printRow(i+1, rowOfLocations);
            this.printDividerRow();
        }
        System.out.println();
         
        return null;
    }

    private void printHeadRow() {

        // print first cell

        System.out.print("\n\t      1   ");
        int columnsInRow = this.board.getColumnCount();
        // print remaining cells in row
        for (int i = 1; i < columnsInRow - 1; i++) {
            int col = i + 1;
            System.out.print("  " + col + "   ");
        }
        System.out.print(" " + columnsInRow + "   ");
    }

    private void printDividerRow() {

        // print first cell

        System.out.print("\n\t  |------");
        int columnsInRow = this.board.getColumnCount();
        // print remaining cells in row
        for (int i = 1; i < columnsInRow - 1; i++) {
            System.out.print("------");
        }
        System.out.print("-----|");
    }

    private void printRow(int rowNumber, Player[] rowLocations) {
        
        // print first cell
        String letter = " ";
        if (rowLocations[0] != null) {
            letter = rowLocations[0].marker;
        }
        System.out.print("\n\t" + rowNumber + " |  " + letter + "  |");

        // print remaining cells in row
        for (int i = 1; i < rowLocations.length; i++) {
            if (rowLocations[i] == null) {
                letter = " ";
            } else {
                letter = rowLocations[i].marker;
            }
            System.out.print("  " + letter + "  |");
        }
    }

}
