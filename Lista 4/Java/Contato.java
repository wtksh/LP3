import java.time.LocalDate;

public class Contato {
    private String nome;
    private String email;
    private String telefone;
    private Data dataNascimento;

    // Construtor
    public void inicializarContato(String nome, String email, String telefone, Data dataNascimento){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    // Imprimir contato
    public void imprimirContato(){
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data de Nascimento: " + dataNascimento.getDia() + "/" + dataNascimento.getMes() + "/" + dataNascimento.getAno());
    }

    // Calcular idade
    public int calcularIdade(){
        LocalDate dataHoje = LocalDate.now();
        LocalDate dataNascimento = LocalDate.of(this.dataNascimento.getAno(), this.dataNascimento.getMes(), this.dataNascimento.getDia());
        int idade = dataHoje.getYear() - dataNascimento.getYear();

        if (dataHoje.getMonthValue() < dataNascimento.getMonthValue()
                || (dataHoje.getMonthValue() == dataNascimento.getMonthValue() && dataHoje.getDayOfMonth() < dataNascimento.getDayOfMonth()))
            idade--;

        return idade;
    }

    // Getters
    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public String getTelefone(){
        return telefone;
    }
    
    public Data getDataNascimento(){
        return dataNascimento;
    }

    // Setters
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public void setDataNascimento(Data dataNascimento){
        this.dataNascimento = dataNascimento;
    }


    public static void main(String[] args){
        Contato contato = new Contato();
        Data dataNascimento = new Data(1, 5, 2000);
        contato.inicializarContato("Fulano", "fulano@email.com", "73999999999", dataNascimento);
        contato.imprimirContato();

        contato.setNome("Ciclano");
        contato.setEmail("ciclano@email.com");
        contato.setTelefone("73888888888");
        contato.setDataNascimento(new Data(29, 2, 2000));
        
        System.out.printf("%s\n%s\n%s\n", contato.getNome(), contato.getEmail(), contato.getTelefone());
        contato.getDataNascimento().imprimirData();

        System.out.println(calcularIdade());
    }
    
}
