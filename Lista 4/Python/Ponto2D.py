class Ponto2D:
    def __init__(self, x = 0, y = 0):
        self.__x = x
        self.__y = y

    def __str__(self):
        return f"({self.__x}, {self.__y})"
    
    @property
    def x(self):
        return self.__x
    
    @property
    def y(self):
        return self.__y
    
    @x.setter
    def x(self, x):
        self.__x = x

    @y.setter
    def y(self, y):
        self.__y = y
    
    def isEixoX(self):
        if self.__x == 0:
            return True
        return False
        
    def isEixoY(self):
        if self.__y == 0:
            return True
        return False
    
    def isEixos(self):
        if self.__x == 0 or self.__y == 0:
            return True
        return False
    
    def quadrante(self):
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
            
    def distancia(self, Ponto2D):
        from math import sqrt
        distancia = sqrt((Ponto2D.x - self.__x)**2 + (Ponto2D.y - self.__y)**2)
        return distancia


if __name__ == "__main__":
    ponto = Ponto2D()
    print(ponto)
    ponto.y = 3
    print("IsEixoX:", ponto.isEixoX())
    print("IsEixoY:", ponto.isEixoY())
    print("IsEixos:", ponto.isEixos())

    ponto2 = Ponto2D(4, 0)
    print(ponto.distancia(ponto2))