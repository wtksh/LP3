import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Contato {
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;

    Contato(String nome, String email, String telefone, LocalDate dataNascimento){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    Contato(String nome, String telefone, LocalDate dataNascimento){
        this(nome, "Nao informado", telefone, dataNascimento);
    }

    // Imprimir contato
    public void imprimirContato(){
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data de Nascimento: " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataNascimento));
    }

    // Calcular idade
    public int calcularIdade(){
        LocalDate dataHoje = LocalDate.now();
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
    
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    // Setters
    public void setEmail(String email){
        this.email = email;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public static void main(String[] args){
        LocalDate data = LocalDate.of(2023, 5, 8);
        Contato contato = new Contato("Fulano", "73999999999", data);
        contato.imprimirContato();
        System.out.printf("%s, %s, %s, %s", contato.getNome(), contato.getEmail(), contato.getTelefone(), contato.getDataNascimento());
        System.out.println(contato.calcularIdade());
    }
    
}
