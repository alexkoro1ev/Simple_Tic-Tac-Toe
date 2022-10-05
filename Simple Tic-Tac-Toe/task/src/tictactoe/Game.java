package tictactoe;

public class Game {
    private final Grid grid = new Grid();
    private final Controller controller = new Controller(grid);

    public void run() {
        grid.drawEmptyGrid();
        while (!controller.isFinished()) {
            controller.makeAMove();
        }
    }
}
