import java.util.Scanner;

public class BatalhaNaval{
    static final int PLAYERS_NUM = 2;
    static final int SHIPS_NUM = 5;
    static final int BOARD_SIZE = 5;

    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Welcome to Battleship!!!");

            // Inicialização dos tabuleiros
            char[][][] templateBoards = new char[PLAYERS_NUM][BOARD_SIZE+1][BOARD_SIZE+1], playingBoards = new char[PLAYERS_NUM][BOARD_SIZE+1][BOARD_SIZE+1];
            for (int i = 0; i < PLAYERS_NUM; i++){
                templateBoards[i] = generateBoard(BOARD_SIZE);
                playingBoards[i] = generateBoard(BOARD_SIZE);
            }

            // Escolha de coordenadas nos tabuleiros
            for (int player = 0; player < PLAYERS_NUM; player++){
                System.out.println("\nPLAYER " + (player+1) + ", ENTER YOUR SHIP'S COORDINATES");
                
                for (int ship = 0; ship < SHIPS_NUM; ship++){
                    boolean verifyShip = false;
                    while (!verifyShip){
                        System.out.print("Enter ship " + (ship+1) + " location: ");
                        verifyShip = generateShip(templateBoards[player], scanner.nextInt(), scanner.nextInt());
                    }
                }
                printBoard(templateBoards[player]);
            }
            
            // Jogo
            int[] hitCount = new int[PLAYERS_NUM];
            int winner = -1, target = 0;
            while(winner == -1){
                for (int player = 0; player < PLAYERS_NUM; player++){
                    
                    if (player == 0)
                        target = 1;
                    else if (player == 1)
                        target = 0;
                    
                    boolean verifyCoord = false;
                    while (!verifyCoord){
                        System.out.print("\nPlayer " + (player+1) + ", enter hit row/column: ");
                        verifyCoord = hitCoord(player, target, hitCount, templateBoards, playingBoards, scanner.nextInt(), scanner.nextInt());
                    }
                    
                    printBoard(playingBoards[target]);
                    System.out.println("Remaining ships: " + (SHIPS_NUM - hitCount[player]));
                    
                    if (SHIPS_NUM - hitCount[player] == 0){
                        winner = player;
                        break;
                    }
                }
            }

            // Resultados
            System.out.println("\nPLAYER " + (winner+1) + " WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
            System.out.println("Final boards:\nPLAYER 1:");
            printBoard(playingBoards[0]);
            System.out.println("\nPLAYER 2:");
            printBoard(playingBoards[1]);
        }       
    }


    /* Gera uma matriz-tabuleiro de tamanho (size)x(size) com índices. Caso (size) seja menor que 0 ou maior que 9, retornará um erro. */
    public static char[][] generateBoard(int size){
        if (size < 1 || size > 9){
            System.out.println("Error: Size must be between 1 and 9. Returning empty array.");
            return null;
        }
        char[][] board = new char[size + 1][size + 1];
        board[0][0] = '*';

        for (int i = 1; i <= size; i++){
            board[0][i] = (char)(i + '0');
            board[i][0] = (char)(i + '0');
            for (int j = 1; j <= size; j++) 
                board[i][j] = '-';
        }
        return board;
    }


    /* Imprime a matriz-tabuleiro */
    public static void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++)
                System.out.print(board[i][j] + " ");    
            System.out.println();
        }
    }


    /* Gera um navio no tabuleiro (board) na linha (row) coluna (column) */
    public static boolean generateShip(char[][] board, int row, int column){
        if (row < 1 || row >= board.length || column < 1 || column >= board[0].length)
            System.out.println("Invalid coordinates. Choose different coordinates.");

        else if(board[row][column] == '@')
            System.out.println("You already have a ship there. Choose different coordinates.");
        
        else{
            board[row][column] = '@';
            return true;
        }
        return false;
    }


    /* Atualiza a matriz-tabuleiro com o ataque em (row)x(column) e o contador de acertos (hitCount) caso acertar. Retorna true se o ataque for lançado; Retorna false se o ataque for inválido.*/
    public static boolean hitCoord(int player, int target, int[] hitCount, char[][][] templateBoards, char[][][] playingBoards, int row, int column){
        if (row < 1 || row >= templateBoards[0].length || column < 1 || column >= templateBoards[0][0].length)
            System.out.println("Invalid coordinates. Choose different coordinates.");

        else{
            switch(templateBoards[target][row][column]){
                case 'X':
                case 'O':
                    System.out.println("You already fired on this spot. Choose different coordinates.");
                    break;

                case '-':
                    templateBoards[target][row][column] = 'O';
                    playingBoards[target][row][column] = 'O';
                    System.out.println("PLAYER " + (++player) + " MISSED!");
                    return true;

                case '@':
                    templateBoards[target][row][column] = 'X';
                    playingBoards[target][row][column] = 'X';
                    hitCount[player]++;
                    System.out.println("PLAYER " + (++player) + " HIT PLAYER " + (++target) + "'s SHIP!!!");
                    return true;
            }
        }
        return false;
    }
}