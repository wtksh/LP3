class Lampada:
    def __new__(cls, *args, **kwargs):
        return super().__new__(cls)

    def __init__(self, luminosidade = 0):
        self.__luminosidade = luminosidade

    @property
    def luminosidade(self):
        return self.__luminosidade
    
    @luminosidade.setter
    def luminosidade(self, luminosidade):
        if luminosidade > 100:
            luminosidade = 100
        elif luminosidade < 0:
            luminosidade = 0
        self.__luminosidade = luminosidade

    def acende(self):
        self.__luminosidade = 100

    def meia_luz(self):
        self.__luminosidade = 50
    
    def apaga(self):
        self.__luminosidade = 0

    def mostra_estado(self):
        if self.__luminosidade:
            print(f"A lâmpada está com {self.__luminosidade}% de sua luminosidade total.")
        else:
            print("A lâmpada está apagada.")

    def esta_ligada(self):
        return self.__luminosidade
    
if __name__ == "__main__":
    lampada = Lampada()
    lampada.mostra_estado()
    print(lampada.esta_ligada())

    lampada.luminosidade = 75
    lampada.mostra_estado()
    print(lampada.esta_ligada())
    
    lampada.acende()
    lampada.mostra_estado()

    lampada.meia_luz()
    lampada.mostra_estado()
    
    lampada.apaga()
    lampada.mostra_estado()


    

