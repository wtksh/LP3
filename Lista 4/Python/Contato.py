from datetime import datetime as dt

class Contato:
    def __init__(self, nome = "", email = "", telefone = "", data_nascimento = ""):
        self.__nome = nome
        self.__email = email
        self.__telefone = telefone
        self.__data_nascimento = data_nascimento

    # Imprimir contato
    def __str__(self):
        return f"Nome: {self.__nome}\n" \
               f"Email: {self.__email}\n" \
               f"Telefone: {self.__telefone}\n" \
               f"Data de Nascimento: {self.__data_nascimento}"

    # Calcular idade
    def calcular_idade(self):
        diferenca = dt.today() - dt.strptime(self.__data_nascimento, "%d/%m/%Y")
        idade = int(diferenca.days / 365.25)
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
        try:
            dt.strptime(data_nascimento, "%d/%m/%Y")
        except ValueError:
            raise ValueError("Data de nascimento deve estar no formato dd/mm/aaaa.")
        self.__data_nascimento = data_nascimento


if __name__ == "__main__":
    contato = Contato("Fulano", "fulano@email.com", "73999999999", "26/04/2000")
    print(contato)
    print("Idade", contato.calcular_idade())

    contato.nome = "Ciclano"
    contato.email = "ciclano@email.com"
    contato.telefone = "73888888888"
    contato.data_nascimento = "26/04/2000"
    print(contato)
    print("Idade:", contato.calcular_idade())