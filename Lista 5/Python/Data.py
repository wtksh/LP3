class Data:
    def __new__(self, *args, **kwargs):
        return super().__new__(self)

    def __init__(self, dia = 0, mes = 0, ano = 0):
        self.__verificar_data(dia, mes, ano)
        self.__dia = dia
        self.__mes = mes
        self.__ano = ano

    # Imprimir data
    def __str__(self):
        return f"{self.__dia:02}/{self.__mes:02}/{self.__ano:04}"
    
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
        self.__verificar_data(dia, self.__mes, self.__ano)
        self.__dia = dia

    @mes.setter
    def mes(self, mes):
        self.__verificar_data(self.__dia, mes, self.__ano)
        self.__mes = mes    
    
    @ano.setter
    def ano(self, ano):
        self.__verificar_data(self.__dia, self.__mes, ano)
        self.__ano = ano
    
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

    # Imprimir data extenso
    def extenso(self):
        meses = ["-----", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"]
        return f"{self.__dia:02} de {meses[self.__mes]} de {self.__ano:04}"
    

    def isPrevious(self, data: "Data"):
        self.__verificar_data(data.dia, data.mes, data.ano)
        if data.ano < self.__ano:
            return True
        elif data.ano > self.__ano:
            return False
        else:
            if data.mes < self.__mes:
                return True
            elif data.mes > self.__mes:
                return False
            else:
                if data.dia < self.__dia:
                    return True
                else:
                    return False

    def howManyDays2(self, data: "Data"):
        i = 0
        dias_por_mes = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        if data.isPrevious(self):
            start_date = self
            end_date = data
            i = 1
        elif self.isPrevious(data):
            start_date = data
            end_date = self
            i = -1
        else:
            return 0
        dias = (end_date.dia + sum(dias_por_mes[0:end_date.mes - 1])) - (start_date.dia + sum(dias_por_mes[0:start_date.mes - 1]))
        # Se as datas são do mesmo ano; Se o ano é bissexto; Se a data inicia antes de 29/02
        if start_date.ano == end_date.ano and (start_date.ano % 4 == 0 and (start_date.ano % 100 != 0 or start_date.ano % 400 == 0)) and (start_date.mes < 2 or (start_date.mes == 2 and start_date.dia <= 29)):
            dias += 1
        for ano in range(start_date.ano, end_date.ano):
            dias += 365
            if ano % 4 == 0 and (ano % 100 != 0 or ano % 400 == 0):
                if ano == start_date.ano:
                    if start_date.mes < 2 or (start_date.mes == 2 and start_date.dia <= 29):
                        dias += 1
                elif ano == end_date.ano:
                    if end_date.mes > 2 or (end_date.mes == 2 and end_date.dia == 29):
                        dias += 1
                else:
                    dias += 1
        return i * dias

    def dayOfWeek(self):
        a = (14 - self.__mes)//12
        y = self.__ano - a
        m = self.__mes + 12*a - 2
        d = (self.__dia + y + y//4 - y//100 + y//400 + 31*m//12) % 7
        semana = ["Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"]
        return semana[d]


if __name__ == "__main__":
    data1 = Data(28, 2, 2020)
    data2 = Data(1, 3, 2021)

    print("Data", data1, data1.dayOfWeek())
    print("Data extenso:", data2.extenso(), data2.dayOfWeek())

    print("data1 < data2 ?", data2.isPrevious(data1))

    print(data1.howManyDays2(data2))
