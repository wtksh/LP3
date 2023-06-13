import java.time.LocalDate;

public class LivroBiblioteca extends Livro{
    private boolean emprestado;
    private LocalDate dataDevolucao;

    public LivroBiblioteca(String titulo, String autor, int numeroPaginas, int anoPublicacao, boolean emprestado, LocalDate dataDevolucao) {
        super(titulo, autor, numeroPaginas, anoPublicacao);
        this.emprestado = emprestado;
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        String titulo = "Titulo: " + this.titulo;
        String autor = "Autor: " + this.autor;
        String numeroPaginas = "Numero de paginas: " + this.numeroPaginas;
        String anoPublicacao = "Ano de Publicacao: " + this.anoPublicacao;
        String emprestado = "Emprestado: " + this.emprestado;
        String dataDevolucao = "Data Devolucao: " + this.dataDevolucao;
        return titulo + "\n" + autor + "\n" + numeroPaginas + "\n" + anoPublicacao + "\n" + emprestado + "\n" + dataDevolucao + "\n";
    }

    public boolean isAvailable() {
        return !emprestado;
    }

    public void borrow() {
        emprestado = true;
    }

    public static void main(String[] args) {
        LocalDate data = LocalDate.of(2023, 6, 12);
        LivroBiblioteca livroBiblioteca = new LivroBiblioteca("Title", "Author", 500, 2023, false, data);

        System.out.println(livroBiblioteca);
        System.out.println("IsOlder: " + livroBiblioteca.isOlder(2024));
        System.out.println("IsAvailable: " + livroBiblioteca.isAvailable());
        livroBiblioteca.borrow();
        System.out.println("Emprestimo realizado");
        System.out.println("IsAvailable: " + livroBiblioteca.isAvailable());
    }
}
