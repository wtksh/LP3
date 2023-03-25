import java.util.Scanner;

public class BatalhaNaval{
    static final int PLAYERS_NUM = 2;
    static final int SHIPS_NUM = 5;
    static final int BOARD_SIZE = 5;

    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Welcome to Battleship!!!");

            char[][] board = generateBoard(5);
            int[][] coordinates = new int[SHIPS_NUM][2];

            for (int player = 0; player < PLAYERS_NUM; player++){
                System.out.println("\nPLAYER " + (player+1) + ", ENTER YOUR SHIP'S COORDINATES");
                for (int ship = 0; ship < SHIPS_NUM; ship++){
                    while(true){
                        System.out.println("Enter ship " + (ship+1) + " location:");
                        coordinates[ship][0] = scanner.nextInt();
                        coordinates[ship][1] = scanner.nextInt();

                        if (coordinates[ship][0] > 0 && coordinates[ship][0] <= BOARD_SIZE && coordinates[ship][1] > 0 && coordinates[ship][1] <= BOARD_SIZE)
                            if (differentCoords(coordinates, ship))
                                break;
                            else
                                System.out.println("You already have a ship there. Choose different coordinates.");
                        else
                            System.out.println("Invalid coordinates. Choose different coordinates.");
                    }
                }
            }       
        }
    }
    
    /* Gera uma matriz-tabuleiro de tamanho (size)x(size). Caso (size) seja menor que 0 ou maior que 9, retornará um erro. */
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

    /* Verifica se a coordenada atual é igual a alguma coordenada inserida anteriormente. */
    public static boolean differentCoords(int[][] coordinates, int ship){
        if (ship == 0) 
            return true;
        for (int i = 0; i < ship; i++)
            if (coordinates[i][0] == coordinates[ship][0] && coordinates[i][1] == coordinates[ship][1])
                return false;
        return true;
    }

    



}

