import base.Data;
import base.Time;

public class DataHora1 {
    private Data data;
    private Time hora;

    public DataHora1(int dia, int mes, int ano, int hora, int min, int seg) {
        data = new Data(dia, mes, ano);
        this.hora = new Time(hora, min, seg);
    }

    public String toString() {
        return Data.dayToPrintLong(data) + ", " + hora.getTime();
    }

    public boolean isEqual(DataHora1 outroObjeto) {
        return ((data.howManyDays(outroObjeto.data) == 0) && (outroObjeto.hora.timeToSec() - hora.timeToSec() == 0));
    }

    public boolean isGreater(DataHora1 outroObjeto) {
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

    public boolean isLower(DataHora1 outroObjeto) {
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
        DataHora1 dataHora1 = new DataHora1(29, 5, 2023, 7, 30, 0);
        DataHora1 dataHora2 = new DataHora1(29, 5, 2023, 7, 30, 0);
        DataHora1 dataHora3 = new DataHora1(31, 5, 2023, 7, 35, 0);

        System.out.println(dataHora1.toString());
        System.out.println(dataHora1.isEqual(dataHora2));
        System.out.println(dataHora1.isGreater(dataHora3));
        System.out.println(dataHora3.isLower(dataHora1));
    }
}
