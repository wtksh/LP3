import math
from Ponto2D import Ponto2D

class Circulo:
    def __new__(cls, *args, **kwargs):
        return super().__new__(cls)

    def __init__(self, x = 0, y = 0, r = 1):
        if self.__validaCirculo(r):
            self.__x = x
            self.__y = y
            self.__r = r

    # Imprimir circulo
    def __str__(self):
        return f"({self.__x}, {self.__y}, {self.__r})"

    def __validaCirculo(self, r):
        if r > 0:
            return True
        raise ValueError("'r' deve ser maior que 0.")
    
    # Getters
    @property
    def x(self):
        return self.__x
    
    @property
    def y(self):
        return self.__y

    @property
    def r(self):
        return self.__r
    
    # Setters
    @x.setter
    def x(self, x):
        self.__x = x

    @y.setter
    def y(self, y):
        self.__y = y

    @r.setter
    def r(self, r):
        self.__r = r

    def isInnerPoint(self, ponto: Ponto2D):
        centro = Ponto2D(self.__x, self.__y)
        return ponto.distance(centro) <= self.__r

    def area(self):
        area = math.pi * self.__r**2
        return area

    def perimeter(self):
        perimeter = 2 * math.pi * self.__r
        return perimeter
    
    def isBiggerThan(self, circulo: "Circulo"):
        return self.area() > circulo.area()

if __name__ == "__main__":
    ponto = Ponto2D(-1, 2)
    circulo1 = Circulo(1, 3, 2)
    circulo2 = Circulo(r = 5)

    print(ponto)
    print(circulo2)
    print(f"Point {ponto} is inner of {circulo2}?", circulo2.isInnerPoint(ponto))
    print("Area: ", circulo1.area())
    print("Perimeter: ", circulo2.perimeter())
    print("Circulo1 is bigger than Circulo2?", circulo1.isBiggerThan(circulo2))



