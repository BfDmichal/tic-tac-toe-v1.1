package logic;

import stats.GameStats;

public class Logic {


    public GameStats play(Player[][] gameTable, Point point, Player player) {
        boolean isMovePossible = moveIsPossible(gameTable, point);
        if (isMovePossible) {
            Player[][] changedTable = setMove(gameTable, point, player);
            Player winnerPlayer = checkWin(changedTable, player);
            Player changedPlayer = changePlayer(player);
            return new GameStats(changedPlayer, winnerPlayer, changedTable);
        } else {
            return new GameStats(player, Player.EMPTY, gameTable);
        }
    }

    public boolean moveIsPossible(Player[][] board, Point point) {
        Player point1 = board[point.getX()][point.getY()];
        return point1.equals(Player.EMPTY);
    }

    public Player[][] setMove(Player[][] board, Point point, Player player) {
        Player[][] copyBoard = BoardOperator.deepCopy(board);
        copyBoard[point.getX()][point.getY()] = player;
        return copyBoard;
    }

    public Player checkWin(Player[][] board, Player player) {
        Player winnerPlayer = checkHorizon(board, player);
        if (winnerPlayer == Player.EMPTY) {
            winnerPlayer = checkVertical(board, player);
        }
        if (winnerPlayer == Player.EMPTY) {
            winnerPlayer = checkDiagonal(board, player);
        }
        return winnerPlayer;
    }


    public Player changePlayer(Player player) {
        if (player.equals(Player.x)) {
            return Player.o;
        } else {
            return Player.x;
        }
    }

    public Player checkHorizon(Player[][] board, Player player) {
        for (int y = 0; y < 3; y++) {
            if (board[0][y].equals(player) && board[1][y].equals(player) && board[2][y].equals(player)) {
                return player;
            }
        }
        return Player.EMPTY;
    }

    public Player checkVertical(Player[][] board, Player player) {
        for (int x = 0; x < 3; x++) {
            if (board[x][0].equals(player) && board[x][1].equals(player) && board[x][2].equals(player))
                return player;
        }
        return Player.EMPTY;
    }

    public Player checkDiagonal(Player[][] board, Player player) {
        if ((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)
                || board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player))) {
            return player;
        } else
            return Player.EMPTY;
    }

    public boolean isFull(Player[][] board) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[x][y] == Player.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
