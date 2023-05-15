public class RoboSimples {
    private  String nomeDoRobo;
    private int posicaoXAtual, posicaoYAtual;
    private String direcaoAtual;

    RoboSimples(String nome, int px, int py, String d){
        validaRobo(nome, d);
        nomeDoRobo = nome;
        posicaoXAtual = px;
        posicaoYAtual = py;
        direcaoAtual = d;
    }

    RoboSimples(String nome){
        this(nome, 0, 0, "N");
    }

    RoboSimples(){
        this("Wally");
    }

    private boolean validaRobo(String nome, String novaDirecao){
        if(validaNome(nome) && validaDirecao(novaDirecao))
            return true;
        return false;
    }
    
    private boolean validaNome(String nome){
        if(!nome.isEmpty())
            return true;
        throw new IllegalArgumentException("Invalid name");
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
        switch(direcaoAtual){
            case "N":
            posicaoYAtual += passos;
            break;

            case "L":
            posicaoXAtual += passos;
            break;

            case "S":
            posicaoYAtual -= passos;
            break;

            case "O":
            posicaoXAtual -= passos;
            break;

            case "NL":
            posicaoYAtual += passos;
            posicaoXAtual += passos;
            break;

            case "NO":
            posicaoYAtual += passos;
            posicaoXAtual -= passos;
            break;

            case "SL":
            posicaoYAtual -= passos;
            posicaoXAtual += passos;
            break;

            case "SO":
            posicaoYAtual -= passos;
            posicaoXAtual -= passos;
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

}