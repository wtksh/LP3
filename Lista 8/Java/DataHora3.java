import base.Data;
import base.Time;

public class DataHora3 {
    private Data data;
    private Time hora;

    public DataHora3(Data data, Time hora) {
        this.data = data;
        this.hora = hora;
    }

    // public String toString() {
    //     return Data.dayToPrintLong(data) + ", " + hora.getTime();
    // }

    public boolean isEqual(DataHora3 outroObjeto) {
        return ((data.howManyDays(outroObjeto.data) == 0) && (outroObjeto.hora.timeToSec() - hora.timeToSec() == 0));
    }

    public boolean isGreater(DataHora3 outroObjeto) {
        int dataDiff = data.howManyDays(outroObjeto.data);
        int timeDiff = outroObjeto.hora.timeToSec() - hora.timeToSec();

        if (dataDiff > 0) {
            return true;
        }
        else if (dataDiff < 0) {
            System.out.println(dataDiff);
            return false;
        }
        else {
            if (timeDiff > 0)
                return true;
            else
                return false;
        }
    }

    public boolean isLower(DataHora3 outroObjeto) {
        int dataDiff = data.howManyDays(outroObjeto.data);
        int timeDiff = outroObjeto.hora.timeToSec() - hora.timeToSec();

        if (dataDiff < 0) {
            return true;
        }
        else if (dataDiff > 0) {
            return false;
        }
        else {
            if (timeDiff < 0)
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {
        Data data1 = new Data(29, 5, 2023);
        Time hora1 = new Time(7, 30, 0);
        DataHora3 dataHora1 = new DataHora3(data1, hora1);

        Data data2 = new Data(31, 5, 2023);
        Time hora2 = new Time(7, 30, 0);
        DataHora3 dataHora3 = new DataHora3(data2, hora2);

        System.out.println(Data.dayToPrintLong(data1) + " - " + hora1.getTime());

    }
}
