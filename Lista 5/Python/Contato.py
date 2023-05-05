from datetime import datetime as dt
from Data import Data

class Contato:
    def __new__(cls, *args, **kwargs):
        return super().__new__(cls)
    
    def __init__(self, nome, email, telefone, data_nascimento):
        self.__validarNome(nome)
        self.__validarEmail(email)
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
    
    def __validarNome(self, nome: str):
        if not (nome == "" and nome.isspace()):
            return True
        raise ValueError("Invalid name")
    
    def __validarEmail(self, email: str):
        if email.endswith(".com") or email.endswith(".br"):
            return True
        raise ValueError("Invalid email")

    # Calcular idade
    def calcular_idade(self):
        diferenca = dt.today() - dt.strptime(str(self.__data_nascimento), "%d/%m/%Y")
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
    @email.setter
    def email(self, email):
        self.__email = email

    @telefone.setter
    def telefone(self, telefone):
        self.__telefone = telefone

if __name__ == "__main__":
    dataNascimento = Data(9, 5, 2000)
    contato = Contato("Fulano", "fulano@email.com", "73999999999", dataNascimento)
    print(contato)
    print("Idade", contato.calcular_idade())