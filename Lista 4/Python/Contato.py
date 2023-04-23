class Contato:
    def __self__(self):
        self.__nome = ""
        self.__email = ""
        self.__telefone = ""
        self.__data_nascimento = ""
    
    # Inicializar contato
    def inicializar_contato(self, nome, email, telefone, dataNascimento):
        self.__nome = nome
        self.__email = email
        self.__telefone = telefone
        self.__data_nascimento = dataNascimento

    # Imprimir contato
    def imprimir_contato(self):
        print(f"Nome: {self.__nome}\n"
              f"Email: {self.__email}\n"
              f"Telefone: {self.__telefone}\n"
              f"Data de Nascimento: {self.__data_nascimento}")

    # Calcular idade
    def calcular_idade(self):
        from datetime import datetime as dt
        diferenca = dt.today() - dt.strptime(self.__data_nascimento, "%d/%m/%Y")
        idade = int(diferenca.days/365.25)
        return idade

    # Getters
    @property
    def nome(self):
        return self.__nome
    
    @property
    def email(self):
        return self.__email
    
    @property
    def telefone(self):
        return self.__telefone
    
    @property
    def data_nascimento(self):
        return self.__data_nascimento

    # Setters
    @nome.setter
    def nome(self, nome):
        self.__nome = nome

    @email.setter
    def email(self, email):
        self.__email = email

    @telefone.setter
    def telefone(self, telefone):
        self.__telefone = telefone

    @data_nascimento.setter
    def data_nascimento(self, data_nascimento):
        self.__data_nascimento = data_nascimento


if __name__ == "__main__":
    contato = Contato()
    contato.inicializar_contato("Fulano", "fulano@email.com", "73999999999", "26/04/2000")
    contato.imprimir_contato()
    print(contato.calcular_idade())

    contato.nome = "Ciclano"
    contato.email = "ciclano@email.com"
    contato.telefone = "73888888888"
    contato.data_nascimento = "27/04/2005"
    contato.imprimir_contato()
    print(contato.calcular_idade())