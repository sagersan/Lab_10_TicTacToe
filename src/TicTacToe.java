import java.util.Scanner;

public class TicTacToe
{

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean playAgain;

        do
        {
            clearBoard();

            String currentPlayer = "X";
            int moveCount = 0;
            boolean gameOver = false;

            while(!gameOver)
            {
                display();

                int row;
                int col;

                do
                {
                    row = SafeInput.getRangedInt(in,
                            currentPlayer + " enter row",
                            1, 3) - 1;

                    col = SafeInput.getRangedInt(in,
                            currentPlayer + " enter column",
                            1, 3) - 1;

                } while(!isValidMove(row, col));

                board[row][col] = currentPlayer;
                moveCount++;

                if(moveCount >= 5 && isWin(currentPlayer))
                {
                    display();
                    System.out.println(currentPlayer + " wins!");
                    gameOver = true;
                }
                else if(moveCount >= 9 && isTie())
                {
                    display();
                    System.out.println("It's a tie!");
                    gameOver = true;
                }
                else
                {
                    if(currentPlayer.equals("X"))
                        currentPlayer = "O";
                    else
                        currentPlayer = "X";
                }
            }

            playAgain = SafeInput.getYNConfirm(in,
                    "Play again");

        } while(playAgain);
    }

    private static void clearBoard()
    {
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                board[row][col] = " ";
            }
        }
    }

    private static void display()
    {
        System.out.println();

        for(int row = 0; row < ROWS; row++)
        {
            System.out.println(" " + board[row][0] +
                    " | " + board[row][1] +
                    " | " + board[row][2]);

            if(row < ROWS - 1)
            {
                System.out.println("---+---+---");
            }
        }

        System.out.println();
    }

    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player)
    {
        return isRowWin(player)
                || isColWin(player)
                || isDiagnalWin(player);
    }

    private static boolean isRowWin(String player)
    {
        for(int row = 0; row < ROWS; row++)
        {
            if(board[row][0].equals(player) &&
                    board[row][1].equals(player) &&
                    board[row][2].equals(player))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COLS; col++)
        {
            if(board[0][col].equals(player) &&
                    board[1][col].equals(player) &&
                    board[2][col].equals(player))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isDiagnalWin(String player)
    {
        if(board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player))
        {
            return true;
        }

        return board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player);
    }

    private static boolean isTie()
    {
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                if(board[row][col].equals(" "))
                {
                    return false;
                }
            }
        }

        return true;
    }
}
