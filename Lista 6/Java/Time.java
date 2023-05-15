public class Time {
    private int hora;
    private int min;
    private int seg;

    Time(int hora, int min, int seg) {
        validateTime(hora, min, seg);
        this.hora = hora;
        this.min = min;
        this.seg = seg;
    }

    Time(int hora, int min) {
        this(hora, min, 0);
    }

    Time(int hora) {
        this(hora, 0);
    }

    Time() {
        this(0);
    }

    Time(Time time) {
        this(time.hora, time.min, time.seg);
    }

    private boolean validateTime(int hora, int min, int seg){
        return validateHour(hora) && validateMinOrSec(min) && validateMinOrSec(seg);
    }

    private boolean validateHour(int hora){
        return (hora>=0) && (hora<25);
    }

    private boolean validateMinOrSec(int param){
        return (param>=0) && (param<61);
    }

    //Getters
    public int getHora() {
        return this.hora;
    }
    
    public int getMin() {
        return this.min;
    }

    public int getSeg() {
        return this.seg;
    }
    
    public String getTime(){
        String res = String.format("%02d:%02d:%02d", this.hora, this.min, this.seg);
        return res;
    }

    public void setTime(int hora, int min, int seg){
        if (validateTime(hora, min, seg)) {
            this.hora = hora;
            this.min = min;
            this.seg = seg;
        }
        else{
            this.hora = 0;
            this.min = 0;
            this.seg = 0;
        }
    }

    
    public void prnTime(){
        System.out.println(getTime());
    }


    public boolean isAm() {
        return (this.hora < 12);
    }

    public int cron(Time horario) {
        int time = this.timeToSec() - horario.timeToSec();
        if (time < 0)
            time += 24 * 3600;
        return time;
    }

    private int timeToSec() {
        return this.hora * 3600 + this.min * 60 + this.seg;
    }

    public void addTime(int h, int m, int s) {
        this.seg += s;
        if (this.seg > 59) {
            m += this.seg/60;
            this.seg %= 60;
        }
        this.min += m;
        if (this.min > 59) {
            h += this.min/60;
            this.min %= 60;
        }
        this.hora += h;
        if (this.hora > 23) {
            this.hora %= 24;
        }
    }

    public void addTime(int h, int m) {
        addTime(h, m, 0);
    }

    public void addTime(int h) {
        addTime(h, 0);
    }

    public void addTime(Time time) {
        addTime(time.hora, time.min, time.seg);
    }

    public static void main(String args[]) {
        Time time1 = new Time(23, 30);
        Time time2 = new Time(1);

        time1.addTime(time2);
        time1.prnTime();
    }
}