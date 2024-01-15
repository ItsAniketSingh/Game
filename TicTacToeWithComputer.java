import java.util.Scanner;
import java.util.Random;

class TTTBoard{
    private char[][]board;

    public TTTBoard()
    {
        board = new char[3][3];
        reset();
    }

    public void reset()
    {
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                board[row][col]= '-';
            }
        }
    }

    public String toString()
    {
        String result = "\n";
        for(int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                result += board[row][col] + " ";
            }
            result += "\n";
        }
        return result;
    }

    public boolean placeXorO(char player, int row, int col)
    {
        if(board[row-1][col-1]=='-')
        {
            board[row-1][col-1] = player;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean full()
    {
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                if(board[row][col] == '-')
                {
                    return false;
                }
            }
        }
        return true;
    }

    public char getWinner()
    {
        String[]win = new String[8];
        int x =0;
        for(int y =0; y < 8; y++)
        {
            win[y] = "";
        }

        for(int row = 0; row <3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                win[x] += board[row][col];
            }
            x++;
        }

        for(int col = 0; col <3; col++)
        {
            for (int row = 0; row < 3; row++)
            {
                win[x] += board[row][col];
            }
            x++;
        }

        win[x] += (board[0][2] + board[1][1] + board[2][0]);
        x++;
        win[x] += (board[0][0] + board[1][1] + board[2][2]);

        char winner = '-';
        for(int i = 0; i < 8; i++)
        {
            if (win[i].equals("XXX"))
            {
                winner = 'X';
            }
            if(win[i].equals("OOO"))
            {
                winner = 'O';
            }
        }
        return winner;
    }
}

public class TicTacToeWithComputer
{
    public static void main(String[]args)
    {
        Scanner reader = new Scanner(System.in);
        TTTBoard board = new TTTBoard();

        System.out.println(board);

        Random gen = new Random();
        char player;
        if(gen.nextInt(2) == 1)
        {
            player = 'O';
        }
        else
        {
            player = 'X';
        }
        System.out.println("Would you like to play against the computer?");
        String computer = reader.nextLine();

        while(board.getWinner() == '-' && !board.full())
        {
            int row = 0;
            int column = 0;
            boolean success = false;
            System.out.println(player + "'s turn.");

            if(computer.equals("No")||player=='X')
            {
                System.out.print("Enter the row and column[1-3, space, 1-3]");

                row = reader.nextInt();
                column = reader.nextInt();
                success = board.placeXorO(player, row, column);
            }
            else
            {
                while(!success)
                {
                    row = gen.nextInt(3) +1;
                    column = gen.nextInt(3) +1;
                    success = board.placeXorO(player, row, column);
                }
            }
            if(!success)
            {
                System.out.println("Error: cell already occupied");
            }
            else
            {
                System.out.println(board);
                if(player == 'X')
                {
                    player = 'O';
                }
                else
                {
                    player = 'X';
                }
            }
        }
        char winner = board.getWinner();
        if(winner != '-')
        {
            System.out.println(winner + "'s wins!");
        }
        else
        {
            System.out.println("It's a draw!");
        }

    }
}
