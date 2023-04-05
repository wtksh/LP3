def generateBoard(boardSize):
    board = [['-' for _ in range(boardSize+1)] for _ in range(boardSize+1)]
    board[0][0] = '*'
    for index in range(1, boardSize+1):
        board[index][0] = board[0][index] = str(index)
    return board


def printBoard(board):
    for row in board:
        for element in row:
            print(element, end=' ')
        print()


def main():
    PLAYERS_NUM = 2
    BOARD_SIZE = 5
    SHIPS_NUM = 5

    print('Welcome to the Battleship!!!')

    # Inicialização dos tabuleiros
    templateBoards = [generateBoard(BOARD_SIZE), generateBoard(BOARD_SIZE)]
    playingBoards = [generateBoard(BOARD_SIZE), generateBoard(BOARD_SIZE)]

    # Escolha de coordenadas nos tabuleiros
    for player in range(PLAYERS_NUM):
        print(f'\nPLAYER {player+1}, ENTER YOUR SHIP\'S COORDINATES')

        for ship in range(SHIPS_NUM):
            while(True):
                try:
                    row, column = map(int, input(f'Enter ship {ship+1} location: ').split())
                except:
                    print('Invalid coordinates. Choose different coordinates.')
                    continue

                if row < 1 or row >= len(templateBoards[player][0]) or column < 1 or column >=len(templateBoards[player]):
                    print('Invalid coordinates. Choose different coordinates.')

                elif templateBoards[player][row][column] == '@':
                    print('You already have a ship there. Choose different coordinates.')
                
                else:
                    templateBoards[player][row][column] = '@'
                    break

        printBoard(templateBoards[player])


    # Jogo
    while(playingBoards[0] != templateBoards[1] and playingBoards[1] != templateBoards[0]):
        for player in range(PLAYERS_NUM):

            if player == 0:
                target = 1
            elif player == 1:
                target = 0

            while(True):
                try:
                    row, column = map(int, input(f'\nPlayer {player+1}, enter hit row/column: ').split())
                except:
                    print('Invalid coordinates. Choose different coordinates.')
                    continue

                if row < 1 or row >= len(playingBoards[player][0]) or column < 1 or column >=len(playingBoards[player]):
                    print('Invalid coordinates. Choose different coordinates.')

                elif playingBoards[player][row][column] in ['X', 'O']:
                    print('You already fired on this spot. Choose different coordinates.')
                
                else:
                    if templateBoards[target][row][column] == '-':
                        templateBoards[target][row][column] = 'O'
                        playingBoards[player][row][column] = 'O'
                        print(f'Player {player+1} MISSED!')

                    else:
                        templateBoards[target][row][column] = 'X'
                        playingBoards[player][row][column] = 'X'
                        print(f'Player {player+1} hit Player {target+1}’s Ship!!!')

                    printBoard(playingBoards[player])
                    break

            if (playingBoards[player] == templateBoards[target]):
                break


    print(f'Player {player+1} WINS! You sunk all of your opponent’s ships!\n')
    print('Final boards:\nPLAYER 1:')
    printBoard(templateBoards[0])
    print('\nPLAYER 2:')
    printBoard(templateBoards[1])


if __name__ == '__main__':
    main()