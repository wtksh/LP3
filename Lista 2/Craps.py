def jogarDados():
    from random import randint
    return randint(1, 6), randint(1, 6)

def main():
    # Estagio 1
    dados = jogarDados()
    ponto = sum(dados)
    print(f'ESTAGIO 1\nDado 1: {dados[0]} | Dado 2: {dados[1]}\nPonto: {ponto}')

    if ponto in (7, 11):
        print('Parabens, voce venceu!')
        
    elif ponto in (2, 3, 12):
        print('Que pena, voce perdeu!')

    # Estagio 2
    else:
        cont = 1
        print('\nESTAGIO 2')
        while(True):
            dados = jogarDados()
            print(f'Dado 1: {dados[0]} | Dado 2: {dados[1]}\nJogada {cont}: {sum(dados)}\n')

            if sum(dados) == ponto:
                print('Parabens, voce venceu!')
                break

            elif sum(dados) == 7:
                print('Que pena, voce perdeu!')
                break


if __name__ == '__main__':
    main()