package tictactoe;

public class Move {
    private final char label;
    private final int y;
    private final int x;

    public Move(char label, int y, int x) {
        this.label = label;
        this.y = y;
        this.x = x;
    }

    public char getLabel() {
        return label;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
