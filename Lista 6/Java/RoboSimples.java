public class RoboSimples {
    private String nomeDoRobo;
    private int posicaoXAtual, posicaoYAtual;
    private String direcaoAtual;
    private static RoboSimples[] listaDeRobos = new RoboSimples[0];

    RoboSimples(String nome, int px, int py, String d){
        validaRobo(nome, px, py, d);
        nomeDoRobo = nome;
        posicaoXAtual = px;
        posicaoYAtual = py;
        direcaoAtual = d;
        listaDeRobos = addInList();
    }

    RoboSimples(String nome){
        this(nome, 0, 0, "N");
    }

    RoboSimples(){
        this("Wally");
    }

    // Adiciona robo na listaDeRobos
    private RoboSimples[] addInList() {
        int cont = 0;

        for (int i = 0; i < listaDeRobos.length; i++) {
            cont++;
        }

        RoboSimples[] lista = new RoboSimples[cont + 1];
        for (int i = 0; i < cont; i++) {
            lista[i] = listaDeRobos[i];
        }

        lista[cont] = this;

        return lista;
    }

    // Verifica se a posicao ja é ocupada
    private boolean verificarPosicao(int posX, int posY) {
        for (RoboSimples robo : listaDeRobos) {
            if ((robo.posicaoXAtual == posX) && (robo.posicaoYAtual == posY)) {
                System.out.printf("Nao foi possivel mover o robo %s: Posicao (%d, %d) ja ocupada por robo %s!!!\n", this.nomeDoRobo, posX, posY, robo.nomeDoRobo);
                return false;
            }
        }
        return true;
    }

    private boolean validaRobo(String nome, int posX, int posY, String novaDirecao){
        if(validaNome(nome) && verificarPosicao(posX, posY) && validaDirecao(novaDirecao))
            return true;
        return false;
    }
    
    private boolean validaNome(String nome){
        if(nome.isEmpty() || nome.isBlank())
            throw new IllegalArgumentException("Invalid name");
        return true;
    }

    private boolean validaDirecao(String direcao){
        switch(direcao) {
            case "N":
            case "NL":
            case "L":
            case "SL":
            case "S":
            case "SO":
            case "O":
            case "NO":
                return true;

            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }

    public void move(){
        this.move(1);
    }

    public void move(int passos){
        switch(direcaoAtual) {
            case "N":
            if (verificarPosicao(posicaoXAtual, posicaoYAtual + passos))
                posicaoYAtual += passos;
            break;

            case "L":
            if (verificarPosicao(posicaoXAtual + passos, posicaoYAtual))
                posicaoXAtual += passos;
            break;

            case "S":
            if (verificarPosicao(posicaoXAtual, posicaoYAtual - passos))
                posicaoYAtual -= passos;
            break;
            
            case "O":
            if (verificarPosicao(posicaoXAtual - passos, posicaoYAtual))
                posicaoXAtual -= passos;
            break;
            
            case "NL":
            if (verificarPosicao(posicaoXAtual + passos, posicaoYAtual + passos)) {
                posicaoYAtual += passos;
                posicaoXAtual += passos;
            }
            break;
            
            case "NO":
            if (verificarPosicao(posicaoXAtual - passos, posicaoYAtual + passos)) {
                posicaoYAtual += passos;
                posicaoXAtual -= passos;
            }
            break;
            
            case "SL":
            if (verificarPosicao(posicaoXAtual + passos, posicaoYAtual - passos)) {
                posicaoYAtual -= passos;
                posicaoXAtual += passos;
            }
            break;
            
            case "SO":
            if (verificarPosicao(posicaoXAtual - passos, posicaoYAtual - passos)) {
                posicaoYAtual -= passos;
                posicaoXAtual -= passos;
            }
            break;
        
        }        
    }

    public void mudaDirecao(String novaDirecao){
        direcaoAtual = novaDirecao;
    }

    public String toString(){
        String str = "\nNome do robo: "+nomeDoRobo+"\n";
        str = str + "Posicao do robo: ("+posicaoXAtual+", "+posicaoYAtual+")\n";
        str = str + "Direcao do robo: "+direcaoAtual;

        return str;
    }

    public static void main (String[] args) {
        RoboSimples robo1 = new RoboSimples("A", 0, 0, "NL");
        RoboSimples robo2 = new RoboSimples("B", 1, 1, "NL");
        RoboSimples robo3 = new RoboSimples("C", 1, 0, "N");
        
        System.out.println(robo1.toString());
        System.out.println(robo2.toString());
        System.out.println(robo3.toString() + "\n");
        
        robo1.move();
        
        System.out.println(robo1.toString());
    }
}