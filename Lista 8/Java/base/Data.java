package base;

public class Data{
    private int dia;
    private int mes;
    private int ano;
    private static final String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    private static final int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] diasDaSemana = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};

    public Data(int dia, int mes, int ano) {
        validateData(dia, mes, ano);
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Data() {
        this(1, 1, 1970);
    }

    public Data(Data data) {
        this(data.dia, data.mes, data.ano);
    }

    // Validações
    private boolean validateData(int dia, int mes, int ano) {
        if (ano < 0)
            throw new IllegalArgumentException("Invalid year");

        if (mes < 1 || mes > 12)
            throw new IllegalArgumentException("Invalid month");

        if (dia < 1 || dia > diasPorMes[mes - 1]){
            if (mes == 2 && dia == 29 && ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0))
                return true;
            else
                throw new IllegalArgumentException("Invalid day");
        }
        return true;
    }    
    
    // Getters
    public int getDia() {
        return dia;
    }
    
    public int getMes() {
        return mes;
    }
    
    public int getAno() {
        return ano;
    }
    
    // Setters
    public void setDia(int dia) {
        validateData(dia, mes, ano);
        this.dia = dia;
    }
    
    public void setMes(int mes) {
        validateData(dia, mes, ano);
        this.mes = mes;
    }
    
    public void setAno(int ano) {
        validateData(dia, mes, ano);
        this.ano = ano;
    }

    public void setData(Data data) {
        validateData(data.dia, data.mes, data.ano);
        dia = data.dia;
        mes = data.mes;
        ano = data.ano;
    }

    public void setData(int dia, int mes, int ano) {
        setData(new Data(dia, mes, ano));
    }

    public void setData(int daquiAXDias) {
        dia += daquiAXDias;
        while (dia > diasPorMes[mes - 1]) {
            dia -= diasPorMes[mes - 1];
            mes++;

            if (mes > 12) {
                mes = 1;
                ano++;
            }
        }
    }
    
    // Methods
    /*
    public void setData(int primeiroDiaDoMesX) {
        validateData(1, primeiroDiaDoMesX, ano);
        mes = primeiroDiaDoMesX;
        dia = 1;
    }

    public void setData(int primeiraSegundaFeiraDoMesX) {
        validateData(1, primeiraSegundaFeiraDoMesX, ano);
        mes = primeiraSegundaFeiraDoMesX;
        dia = 1;
        while (this.dayOfWeek() != "Segunda-feira") {
            dia++;
        }
    }
    */
    
    public void imprimirData() {
        System.out.printf("%02d/%02d/%04d\n", dia, mes, ano);
    }
    
    public void imprimirDataExtenso() {
        System.out.printf("%02d de %s de %04d\n", dia, meses[mes - 1], ano);
    }

    public boolean isPrevious(Data data) {
        if (data.ano < this.ano)
            return true;
        else if (data.ano > this.ano)
            return false;
        else {
            if (data.mes < this.mes)
                return true;
            else if (data.mes > this.mes)
                return false;
            else {
                if (data.dia < this.dia)
                    return true;
                else
                    return false;
            }
        }
    }

    public int howManyDays(Data data) {
        int sinal = 0;
        Data dataInicio, dataFim;
        if (data.isPrevious(this)){
            dataInicio = this;
            dataFim = data;
            sinal = 1;
        }
        else if (this.isPrevious(data)){
            dataInicio = data;
            dataFim = this;
            sinal = -1;
        }
        else
            return 0;

        int somaDPMInicio = 0;
        for (int i = 0; i < dataInicio.mes - 1; i++)
            somaDPMInicio += diasPorMes[i];
            
        int somaDPMFim = 0;
        for (int i = 0; i < dataFim.mes - 1; i++)
            somaDPMFim += diasPorMes[i];

        int dias = (dataFim.dia + somaDPMFim) - (dataInicio.dia + somaDPMInicio);

        // Se as datas são do mesmo ano; Se o ano é bissexto; Se a data inicia antes de 29/02
        if (dataInicio.ano == dataFim.ano && (dataInicio.ano % 4 == 0 && (dataInicio.ano % 100 != 0 || dataInicio.ano % 400 == 0)) && (dataInicio.mes < 2 || (dataInicio.mes == 2 && dataInicio.dia <= 29)))
            dias += 1;

        for (int ano = dataInicio.ano; ano <= dataFim.ano; ano++) {
            dias += 365;
            if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
                if (ano == dataInicio.ano) {
                    if (dataInicio.mes < 2 || (dataInicio.mes == 2 && dataInicio.dia <= 29))
                        dias += 1;
                }
                else if (ano == dataFim.ano) {
                    if (dataFim.mes > 2 || (dataFim.mes == 2 && dataFim.dia == 29))
                        dias += 1;
                }
                else
                    dias += 1;
            }
        }
        dias -= 365;

        return sinal * dias;
    }

    public int howManyDays(int dia, int mes, int ano) {
        return howManyDays(new Data(dia, mes, ano));
    }

    public String dayOfWeek() {
        int a = (14 - mes) / 12;
        int y = ano - a;
        int m = mes + 12*a - 2;
        int d = (dia + y + y/4 - y/100 + y/400 + 31*m/12) % 7;
        return diasDaSemana[d];
    }

    public static int howManyDaysUntilEndYear(Data data) {
        return data.howManyDays(31, 12, data.ano);
    }

    public static int howManyDaysUntilNextMonth(Data data) {
        return data.howManyDays(1, data.mes + 1, data.ano);
    }

    public static boolean isBissexto(Data data) {
        return (data.ano % 4 == 0 && (data.ano % 100 != 0 || data.ano % 400 == 0));
    }

    public static String dayOfWeek(Data data) {
        return data.dayOfWeek();
    }

    public static String dayToPrintShort(Data data) {
        return String.format("%02d/%02d/%04d", data.dia, data.mes, data.ano);
    }

    public static String dayToPrintLong(Data data) {
        return String.format("%02d de %s de %04d", data.dia, meses[data.mes - 1], data.ano);
    }
    
    public static void main(String[] args){
        Data data1 = new Data(29, 5, 2023);

        System.out.println(howManyDaysUntilEndYear(data1));
        System.out.println(howManyDaysUntilNextMonth(data1));
        System.out.println(isBissexto(data1));
        System.out.println(dayOfWeek(data1));
        System.out.println(dayToPrintShort(data1));
        System.out.println(dayToPrintLong(data1)); 
    }
}