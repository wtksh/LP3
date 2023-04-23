class Data:
    def __init__(self, dia = 0, mes = 0, ano = 0):
        if self.__verificar_data(dia, mes, ano):
            self.__dia = dia
            self.__mes = mes
            self.__ano = ano

    # Imprimir data
    def __str__(self):
        return f"{self.__dia:02}/{self.__mes:02}/{self.__ano:04}"
    
    # Imprimir data extenso
    def extenso(self):
        meses = ["-----", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"]
        return f"{self.__dia:02} de {meses[self.__mes]} de {self.__ano:04}"
    
    # Verificar data
    def __verificar_data(self, dia, mes, ano):
        if mes < 1 or mes > 12:
            raise ValueError("Invalid date.")

        dias_por_mes = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        if dia < 1 or dia > dias_por_mes[mes - 1]:
            if mes == 2 and dia == 29 and ano % 4 == 0 and (ano % 100 != 0 or ano % 400 == 0):
                return True
            else:
                raise ValueError("Invalid date.")
            
        return True
    
    # Getters
    @property
    def dia(self):
        return self.__dia

    @property
    def mes(self):
        return self.__mes
    
    @property
    def ano(self):
        return self.__ano

    # Setters
    @dia.setter
    def dia(self, dia):
        if self.__verificar_data(dia, self.__mes, self.__ano):
            self.__dia = dia

    @mes.setter
    def mes(self, mes):
        if self.__verificar_data(self.__dia, mes, self.__ano):
            self.__mes = mes

    @ano.setter
    def ano(self, ano):
        if self.__verificar_data(self.__dia, self.__mes, ano):
            self.__ano = ano


if __name__ == "__main__":
    data = Data(26, 4, 2023)

    print('Teste 1: ', data)
    print('Teste 2: ', data.extenso())

    data.ano = 2000
    data.mes = 2
    data.dia = 29
    print('Teste 3: ', data.dia, data.mes, data.ano)
    print('Teste 4: ', data.extenso())
