package stats;

import logic.BoardOperator;
import logic.Player;

public class GameStats {
    private Player player;
    private Player winner;
    private Player[][] gameTable;

    public GameStats() {
        player = Player.x;
        winner = Player.EMPTY;
        gameTable = BoardOperator.startBoard();
    }

    public GameStats(Player Player, Player winner, Player[][] gameTable) {
        this.player = Player;
        this.winner = winner;
        this.gameTable = gameTable;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getWinner() {
        return winner;
    }

    public Player[][] getGameTable() {
        return gameTable;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameTable(Player[][] gameTable) {
        this.gameTable = gameTable;
    }
}
