public class Time {
    private int hora;
    private int min;
    private int seg;

    public Time(int hora, int min, int seg) {
        this.hora = hora;
        this.min = min;
        this.seg = seg;
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
        String res = this.hora + ":" + this.min + ":" + this.seg;
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

    public void addSeconds(int secs) {
        this.hora += secs/3600;
        this.min += (secs%3600)/60;
        this.seg += (secs%3600)%60;

        if (this.seg > 59) {
            this.seg -= 60;
            this.min += 1;
        }
        if (this.min > 59) {
            this.min -= 60;
            this.hora += 1;
        }
        if (this.hora > 23) {
            this.hora -= 24;
        }
    }

    public static void main(String args[]) {
        Time time1 = new Time(22, 59, 59);
        Time time2 = new Time(12, 0, 15);

        System.out.println(time1.isAm());
        System.out.println(time1.cron(time2));
        time1.addSeconds(3601);
        time1.prnTime();
    }
}