package controller;

import logic.*;
import stats.GameStatsDto;
import view.View;

public class Controller {
    private Logic logic;
    private View view;
    private Player activePlayer;
    private Player[][] board;
    private Player isWinner;

    public Controller(View view) {
        this.logic = new Logic();
        this.view = view;
        this.activePlayer = Player.x;
    }

    public void start() {
        board = BoardOperator.startBoard();

    }

    public Player[][] click(Point point) {
        GameStatsDto gameStatsDto = logic.play(board, point, activePlayer);
        board = gameStatsDto.getGameTable();
        activePlayer = gameStatsDto.getPlayer();
        isWinner = gameStatsDto.getWinner();
        stop();
        return board;
    }

    public void stop() {
        if (isWinner != Player.EMPTY) {
            view.stopTable();
            board = BoardOperator.startBoard();
            view.message("Winner is "+isWinner,"Oponent start next game");
        }
        if (logic.isFull(board)) {
            view.stopTable();
            board = BoardOperator.startBoard();
            view.message("Nobody has won",activePlayer+" start next game");
        }
    }
}
