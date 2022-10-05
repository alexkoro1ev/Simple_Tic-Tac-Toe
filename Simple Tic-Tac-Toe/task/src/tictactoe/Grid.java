package tictactoe;

public class Grid {
    private final char[][] currentGrid;

    public Grid() {
        currentGrid = new char[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                currentGrid[y][x] = ' ';
            }
        }
    }

    public void drawEmptyGrid() {
        System.out.println("---------");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("---------");
    }

    public void drawGrid(Move move) {
        currentGrid[move.getY()][move.getX()] = move.getLabel();
        System.out.println("---------");
        for (int y = 0; y < 3; y++) {
            System.out.print("| ");
            for (int x = 0; x < 3; x++) {
                System.out.print(currentGrid[y][x] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

    }

    public char[][] getCurrentGrid() {
        return currentGrid;
    }
}
