class Data:
    def __init__(self):
        self.dia = 0
        self.mes = 0
        self.ano = 0
            
    def inicializar_data(self, dia, mes, ano):
        self.dia = dia
        self.mes = mes
        self.ano = ano

    def verificar_data(self):
        dias_por_mes = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        
        if self.mes < 1 or self.mes > 12:
            return False

        if self.dia < 1 or self.dia > dias_por_mes[self.mes - 1]:
            if self.mes == 2 and self.dia == 29 and self.ano % 4 == 0 and (self.ano % 100 != 0 or self.ano % 400 == 0):
                return True
            else:
                return False
        return True
 
    def set_dia(self, dia):
        self.dia = dia

    def set_mes(self, mes):
        self.mes = mes

    def set_ano(self, ano):
        self.ano = ano

    def get_dia(self):
        return self.dia
    
    def get_mes(self):
        return self.mes
    
    def get_ano(self):
        return self.ano
    
    def imprimir_data(self):
        print(f"{self.dia:02}/{self.mes:02}/{self.ano:04}")

    def imprimir_data_extenso(self):
        meses = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro", "----"]
        print(f"{self.dia:02} de {meses[self.mes - 1]} de {self.ano:04}")

    
if __name__ == "__main__":
    data = Data()
    data.inicializar_data(1, 2, 2000)
    print(data.get("mes"))
    data.imprimir_data()
    data.imprimir_data_extenso()
    