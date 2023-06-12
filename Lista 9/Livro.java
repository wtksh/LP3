
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
}
