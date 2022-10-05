package tictactoe;

import java.util.Scanner;

public class Controller {
    private final Grid grid;
    private boolean isFinished = false;
    private int turnCounter = 0;

    public Controller(Grid grid) {
        this.grid = grid;
    }

    public void makeAMove() {
        Move move = readMove();
        updateGrid(move);
        getState();
    }

    private Move readMove() {
        int y;
        int x;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                y = scanner.nextInt();
                x = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (!checkMoveValidity(y, x)) {
                continue;
            }

            turnCounter++;

            return new Move(getLabel(), y - 1, x - 1);
        }
    }

    private char getLabel() {
        return turnCounter % 2 == 0 ? 'O' : 'X';
    }

    private boolean checkMoveValidity(int y, int x) {
        if (y < 0 || y > 3 || x < 0 || x > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        char currentCellLabel = grid.getCurrentGrid()[y - 1][x - 1];

        if (currentCellLabel != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        return true;
    }

    private void updateGrid(Move move) {
        grid.drawGrid(move);
    }

    private void getState() {
        if (checkWin()) {
            System.out.println(getLabel() + " wins");
            isFinished = true;
            return;
        }
        if (checkDraw()) {
            System.out.println("Draw");
            isFinished = true;
        }
    }

    private boolean checkWin() {
        char[][] currentGrid = grid.getCurrentGrid();
        char currentLabel = getLabel();

        for (int i = 0; i < 3; i++) {
            if ((currentGrid[i][0] == currentLabel &&
                    currentGrid[i][1] == currentLabel &&
                    currentGrid[i][2] == currentLabel) ||
                    (currentGrid[0][i] == currentLabel &&
                            currentGrid[1][i] == currentLabel &&
                            currentGrid[2][i] == currentLabel)) {
                return true;
            }

            if (((currentGrid[0][0] == currentLabel &&
                    currentGrid[1][1] == currentLabel &&
                    currentGrid[2][2] == currentLabel) ||
                    (currentGrid[0][2] == currentLabel &&
                            currentGrid[1][1] == currentLabel &&
                            currentGrid[2][0] == currentLabel))) {
                return true;
            }
        }

        return false;
    }

    private boolean checkDraw() {
        char[][] currentGrid = grid.getCurrentGrid();

        for (char[] line : currentGrid) {
            for (char c : line) {
                if (c == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
