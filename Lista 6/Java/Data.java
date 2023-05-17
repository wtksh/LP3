public class Data{
    private int dia;
    private int mes;
    private int ano;

    Data(int dia, int mes, int ano) {
        verificarData(dia, mes, ano);
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    Data() {
        this(1, 1, 1970);
    }

    Data(Data data) {
        this(data.dia, data.mes, data.ano);
    }

    private boolean verificarData(int dia, int mes, int ano) {
        if (ano < 0)
            throw new IllegalArgumentException("Invalid year");

        if (mes < 1 || mes > 12)
            throw new IllegalArgumentException("Invalid month");

        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
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
        verificarData(dia, mes, ano);
        this.dia = dia;
    }
    
    public void setMes(int mes) {
        verificarData(dia, mes, ano);
        this.mes = mes;
    }
    
    public void setAno(int ano) {
        verificarData(dia, mes, ano);
        this.ano = ano;
    }

    public void setData(Data data) {
        verificarData(data.dia, data.mes, data.ano);
        dia = data.dia;
        mes = data.mes;
        ano = data.ano;
    }

    public void setData(int dia, int mes, int ano) {
        setData(new Data(dia, mes, ano));
    }

    public void setData(int daquiAXDias) {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
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
    /*
    public void setData(int primeiroDiaDoMesX) {
        verificarData(1, primeiroDiaDoMesX, ano);
        mes = primeiroDiaDoMesX;
        dia = 1;
    }

    public void setData(int primeiraSegundaFeiraDoMesX) {
        verificarData(1, primeiraSegundaFeiraDoMesX, ano);
        mes = primeiraSegundaFeiraDoMesX;
        dia = 1;
        while (this.dayOfWeek() != "Segunda-feira") {
            dia++;
        }
    }
    */
    
    // Imprime data
    public void imprimirData() {
        System.out.printf("%02d/%02d/%04d\n", dia, mes, ano);
    }
    
    // Imprime data extenso
    public void imprimirDataExtenso() {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        System.out.printf("%02d de %s de %04d\n", dia, meses[mes], ano);
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
        verificarData(data.dia, data.mes, data.ano);
        int sinal = 0;
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
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
        String[] semana = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
        return semana[d];
    }
    
    public static void main(String[] args){
        Data data1 = new Data(17, 5, 2023);
        Data data2 = new Data();

        data1.imprimirData();
        data2.imprimirData();

        System.out.println(data1.howManyDays(18, 5, 2024));

        data2.setData(data1);
        data2.imprimirData();

        data2.setData(17, 6, 2024);
        data2.imprimirData();

        data1.setData(15);
        data1.imprimirData();
    }
}