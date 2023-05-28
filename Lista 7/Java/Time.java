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

    // Validações
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
        return String.format("%02d:%02d:%02d", this.hora, this.min, this.seg);
    }

    // Setter
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
    
    // Methods
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

    public static Time diffTime(Time time1, Time time2) {
        Time time = new Time();
        int segundos = time2.timeToSec() - time1.timeToSec();
        if (segundos < 0)
            segundos += 24 * 3600;

        time.hora = segundos / 3600;
        time.min = (segundos % 3600) / 60;
        time.seg = (segundos % 3600) % 60;
        
        return time;
    }

    public static Time diffTime(Time t){
        return diffTime(new Time(java.time.LocalTime.now().getHour(), java.time.LocalTime.now().getMinute(), java.time.LocalTime.now().getSecond()), t);
    }

    public static boolean isAm(Time t) {
        return (t.hora < 12);
    }

    public static boolean isPm(Time t) {
        return (t.hora > 12);
    }

    public static void main(String args[]) {
        Time time1 = new Time(23, 30);
        Time time2 = new Time(1);

        Time time3 = Time.diffTime(time1, time2);
        time3.prnTime();

        Time time4 = Time.diffTime(time1);
        time4.prnTime();

        System.out.println(Time.isAm(time2));
        System.out.println(Time.isPm(time1));
    }
}