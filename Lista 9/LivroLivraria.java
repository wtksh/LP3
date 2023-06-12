
public class LivroLivraria extends Livro {
    private float preco;
    private int estoque;

    public LivroLivraria(String titulo, String autor, int numeroPaginas, int anoPublicacao, float preco, int estoque) {
        super(titulo, autor, numeroPaginas, anoPublicacao);
        this.preco = preco;
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        String titulo = "Titulo: " + this.titulo;
        String autor = "Autor: " + this.autor;
        String numeroPaginas = "Numero de paginas: " + this.numeroPaginas;
        String anoPublicacao = "Ano de Publicacao: " + this.anoPublicacao;
        String preco = "Preco: " + this.preco;
        String estoque = "Estoque: " + this.estoque;
        return titulo + "\n" + autor + "\n" + numeroPaginas + "\n" + anoPublicacao + "\n" + preco + "\n" + estoque + "\n";
    }

    public boolean isAvailable() {
        return estoque > 0;
    }

    public void sell() {
        estoque--;
    }
}
