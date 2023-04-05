def calcularMedia(lista):
    return sum(lista)/len(lista)
    
def calcularDesvioPadrao(lista, media):
    from math import sqrt
    return sqrt(sum((numero - media)**2 for numero in lista)/len(lista))
    
def main():
    NUM_AMOSTRAS = 5
    
    # Entrada de dados por teclado
    # amostras = []
    # i = 0
    # while i < NUM_AMOSTRAS:
    #     try:
    #         amostras.append(float(input(f'Amostra {i+1}: ')))
    #         i += 1
    #     except:
    #         print('Valor inválido. Por favor, insira um número.')
    amostras = [1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]
            
    print('\nAmostras: ', end=' '); print(*amostras, sep=', ')

    # Cálculo da média
    media = calcularMedia(amostras)
    print('Media: ', media)

    # Cálculo do desvio padrão
    desvioPadrao = calcularDesvioPadrao(amostras, media)
    print('Desvio Padrão: ', desvioPadrao)

    # Situação do multímetro
    print('Situação: ', 'Multímetro com problema.' if desvioPadrao > media*0.1 else 'Multímetro OK.')


if __name__ == '__main__':
    main()