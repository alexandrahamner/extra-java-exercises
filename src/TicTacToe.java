import java.util.Scanner;

public class TicTacToe {

/*TODO:
        Build a command line Tic Tac Toe game.
        What the board should look like:

          _ | _ | _
          _ | _ | _
            |   |

         [0][0],[0][2],[0][4]
         [1][0],[1][2],[1][4]
         [2][0],[2][2],[2][4]

*/

    public static void main(String[] args) {
        char[][] gameBoard = {
                {'_', '|', '_', '|', '_'},
                {'_', '|', '_', '|', '_'},
                {' ', '|', ' ', '|', ' '}
        };

//        Testing
        displayBoard(gameBoard);
//        Testing
//        updateBoard(9, 1, gameBoard);
        playerMove(gameBoard);
        playerMove(gameBoard);
        playerMove(gameBoard);
        playerMove(gameBoard);
    }

    public static void displayBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void updateBoard( int position, int player, char [][] gameBoard) {
        char character;

        if(player == 1){
            character = 'X';
        }
        else {
            character = 'O';
        }

        switch (position) {
            case 1:
                gameBoard[0][0] = character;
                displayBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = character;
                displayBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = character;
                displayBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = character;
                displayBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][2] = character;
                displayBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = character;
                displayBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = character;
                displayBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = character;
                displayBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = character;
                displayBoard(gameBoard);
                break;
            default:
                break;

        }
    }

    public static void playerMove(char [][] gameBoard) {
        System.out.println("Make a move! Choose a number between 1 - 9.");
        Scanner sc = new Scanner(System.in);
        int move = sc.nextInt();
        boolean result = isValid(move, gameBoard);

        while (!result) {
            System.out.println("Sorry, that spot is taken. Try again.");
            move = sc.nextInt();
            result = isValid(move, gameBoard);
        }

        updateBoard(move,1, gameBoard);
    }

    public static boolean isValid(int move, char[][] gameBoard) {
        switch (move){
            case 1:
                return gameBoard[0][0] == '_';
            case 2:
                return gameBoard[0][2] == '_';
            case 3:
                return gameBoard[0][4] == '_';
            case 4:
                return gameBoard[1][0] == '_';
            case 5:
                return gameBoard[1][2] == '_';
            case 6:
                return gameBoard[1][4] == '_';
            case 7:
                return gameBoard[2][0] == ' ';
            case 8:
                return gameBoard[2][2] == ' ';
            case 9:
                return gameBoard[2][4] == ' ';
            default:
                return false;
        }
    }
}
