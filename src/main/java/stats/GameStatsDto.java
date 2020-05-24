package stats;

import logic.Player;

public class GameStatsDto {
    private Player player;
    private Player winner;
    private Player[][] gameTable;

    public GameStatsDto(Player Player, Player winner, Player[][] gameTable) {
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
}
