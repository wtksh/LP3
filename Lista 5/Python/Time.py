class Time:
    def __new__(cls, *args, **kwargs):
        return super().__new__(cls)

    def __init__(self, hora = 0, min = 0, seg = 0):
        self.__validateTime(hora, min, seg)
        self.__hora = hora
        self.__min = min
        self.__seg = seg

    def __str__(self):
        return f"{self.__hora}:{self.__min}:{self.__seg}"

    # Getters
    @property
    def hora(self):
        return self.__hora
    
    @property
    def min(self):
        return self.__min
    
    @property
    def seg(self):
        return self.__seg
    
    # Setters
    @hora.setter
    def hora(self, hora):
        self.__hora = hora

    @min.setter
    def min(self, min):
        self.__min = min
    
    @seg.setter
    def seg(self, seg):
        self.__seg = seg

    def __validateTime(self, hora, min, seg):
        return self.__validateHour(hora) and self.__validateMin(min) and self.__validateSec(seg)

    def __validateHour(self, hora):
        if hora >= 0 and hora < 25:
            return True
        raise ValueError("Invalid hour")
    
    def __validateMin(self, min):
        if min >= 0 and min < 61:
            return True
        raise ValueError("Invalid min")
    
    def __validateSec(self, seg):
        if seg >=0 and seg < 61:
            return True
        raise ValueError("Invalid sec")
    
    def __timeToSec(self):
        return self.__hora*3600 + self.__min*60 + self.__seg
    
    def isAm(self):
        return self.__hora < 12
    
    def cron(self, time: "Time"):
        seg = time.__timeToSec() - self.__timeToSec()
        if seg < 0:
            seg += 24*3600
        return seg
    
    def addSeconds(self, seg):
        self.__hora += seg//3600
        self.__min += (seg%3600)//60
        self.__seg += (seg%3600)%60
 
if __name__ == "__main__":
    tempo1 = Time(11, 0, 0)
    tempo2 = Time(12, 0, 15)

    print(tempo2.isAm())
    print(tempo1.cron(tempo2))
    tempo1.addSeconds(3600)
    print(tempo1)
