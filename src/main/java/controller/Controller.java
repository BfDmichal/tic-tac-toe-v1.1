package controller;

import logic.*;
import stats.GameStats;
import view.View;

public class Controller {
    private Logic logic;
    private View view;
    private GameStats gameStats;

    public Controller(View view) {
        this.logic = new Logic();
        this.view = view;
        gameStats = new GameStats();
    }

    public void start() {
        gameStats.setGameTable(BoardOperator.startBoard());

    }

    public Player[][] click(Point point) {
        gameStats = logic.play(gameStats.getGameTable(), point, gameStats.getPlayer());
        stop();
        return gameStats.getGameTable();
    }

    public void stop() {
        if (gameStats.getWinner() != Player.EMPTY) {
            view.stopTable();
            start();
            view.message("Winner is " + gameStats.getWinner(), "Opponent start next game");
        }
        if (logic.isFull(gameStats.getGameTable())) {
            view.stopTable();
            start();
            view.message("Nobody has won", gameStats.getPlayer() + " start next game");
        }
    }
}
