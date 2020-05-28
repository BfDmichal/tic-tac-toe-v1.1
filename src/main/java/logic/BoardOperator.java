package logic;

public class BoardOperator {
    public static Player[][] startBoard() {
        Player[][] tableOfPlayers = new Player[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                tableOfPlayers[x][y] = Player.EMPTY;
            }
        }
        return tableOfPlayers;
    }

    public static Player[][] deepCopy(Player[][] mainTable) {
        Player[][] clonedTable = new Player[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                clonedTable[x][y] = mainTable[x][y];
            }
        }
        return clonedTable;
    }
}
