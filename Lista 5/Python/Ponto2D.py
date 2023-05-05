from math import sqrt

class Ponto2D:
    def __new__(cls, x, y):
        obj = super().__new__(cls)
        obj.__x = x
        obj.__y = y
        return obj

    def __init__(self, x, y):
        pass

    def __str__(self):
        return f"({self.__x}, {self.__y})"
    
    @property
    def x(self):
        return self.__x
    
    @property
    def y(self):
        return self.__y
    
    def isEixoX(self):
        return self.__x == 0
    
    def isEixoY(self):
        return self.__y == 0

    def isEixos(self):
        return self.__x == 0 or self.__y == 0

    def quadrant(self):
        if self.isEixos():
            return 0
        
        if self.__x > 0:
            if self.__y > 0:
                return 1
            else:
                return 4
        else:
            if self.__y > 0:
                return 2
            else:
                return 3
            
    def distance(self, Ponto2D):
        distancia = sqrt((Ponto2D.x - self.__x)**2 + (Ponto2D.y - self.__y)**2)
        return distancia


if __name__ == "__main__":
    ponto = Ponto2D(1, 0)
    print(ponto)
    print("IsEixoX:", ponto.isEixoX())
    print("IsEixoY:", ponto.isEixoY())
    print("IsEixos:", ponto.isEixos())

    ponto2 = Ponto2D(4, 1)
    print("Quadrante:", ponto2.quadrant())
    print(ponto.distance(ponto2))