import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

/*TODO:
        Build a command line Tic Tac Toe game.
        What the board should look like:

Template for the gameBoard

          _ | _ | _
          _ | _ | _
            |   |

The positions of the gameBoard

         1 [0][0], 2 [0][2], 3 [0][4]
         4 [1][0], 5 [1][2], 6 [1][4]
         7 [2][0], 8 [2][2], 9 [2][4]

*/

    static int playerScore = 0;
    static int computerScore = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] gameBoard = {
                {'_', '|', '_', '|', '_'},
                {'_', '|', '_', '|', '_'},
                {' ', '|', ' ', '|', ' '}
        };
        displayBoard(gameBoard);
        boolean gameOver = false;
        boolean playAgain = true;

        while(playAgain) {
            while(!gameOver){
                System.out.println("Tic Tac Toe");
                playerMove(gameBoard);
                gameOver = isGameOver(gameBoard);
                if(gameOver) {
                    break;
                }

                computerMove(gameBoard);
                gameOver = isGameOver(gameBoard);
                if (gameOver){
                    break;
                }
            }
        }
        System.out.println("Player Score: " + playerScore);
        System.out.println("Computer Score: " + computerScore);
        System.out.println("Would you like to play again? [y/n] ");
        sc.nextLine();
        String userInput = sc.nextLine();

        switch(userInput){
            case "Y":
            case "y":
                playAgain = true;
                System.out.println("Rematch!");
                resetBoard(gameBoard);
                gameOver = false;
                displayBoard(gameBoard);
                break;

            case "N":
            case "n":
                playAgain = false;
                System.out.println("Thank you for playing Tic Tac Toe!");
                break;
            default:
                break;
        }



//        Testing
//        displayBoard(gameBoard);
//        playerMove(gameBoard);
//        computerMove(gameBoard);
//        playerMove(gameBoard);
//        computerMove(gameBoard);
    }

    public static void resetBoard(char[][] gameBoard) {
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';
    }

    // Prints out the game board.
    public static void displayBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

// Once a valid move is made, the board is updated.
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

// Determining the player's move by using Scanner to get their input.
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

// Determining the computer's move by randomly generating a number.
    public static void computerMove (char [][] gameBoard) {
        Random randNumber = new Random();
        int compMove = randNumber.nextInt(9)+1;
        boolean result = isValid(compMove, gameBoard);

        while(!result) {
            compMove = randNumber.nextInt(9)+1;
            result = isValid(compMove, gameBoard);
        }

        System.out.println("Computer moved at position " + compMove);
        updateBoard(compMove, 2, gameBoard);

    }

// Method to check if the move the user or computer made is valid.
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
