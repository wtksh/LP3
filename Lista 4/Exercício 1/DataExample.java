public class DataExample{
    public static void main(String[] args){
        Data data = new Data();
        data.inicializarData(1, 5, 2000);
        data.imprimirData();
        data.imprimirDataExtenso();

        data.setDia(29);
        data.setMes(2);
        data.setAno(2000);

        System.out.printf("%d, %d, %d", data.getDia(), data.getMes(), data.getAno());
    }
}
