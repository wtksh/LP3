
public class Livro {
    protected String titulo;
    protected String autor;
    protected int numeroPaginas;
    protected int anoPublicacao;

    public Livro(String titulo, String autor, int numeroPaginas, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.anoPublicacao = anoPublicacao;
    }

    public String toString() {
        String titulo = "Titulo: " + this.titulo;
        String autor = "Autor: " + this.autor;
        String numeroPaginas = "Numero de paginas: " + this.numeroPaginas;
        String anoPublicacao = "Ano de Publicacao: " + this.anoPublicacao;
        return titulo + "\n" + autor + "\n" + numeroPaginas + "\n" + anoPublicacao + "\n";
    }

    public boolean isOlder(int ano) {
        return anoPublicacao < ano;
    }

    public boolean isOlder(Livro livro) {
        return anoPublicacao < livro.anoPublicacao;
    }

    public static void main(String[] args) {
        Livro livro1 = new Livro("Title1", "Author1", 100, 2021);
        Livro livro2 = new Livro("Title2", "Author2", 300, 2023);

        System.out.println(livro1);
        System.out.println(livro1.isOlder(livro2));

    }
}
