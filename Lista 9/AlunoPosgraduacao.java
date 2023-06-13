import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AlunoPosgraduacao extends Aluno {
    private String nomeOrientador;
    private String tituloProjetoDePesquisa;
    private char nivel;

    public AlunoPosgraduacao(String nome, int matricula, LocalDate dataAdmissao, int semestre, String tipoCurso, String nomeOrientador, String tituloProjetoDePesquisa, char nivel) throws IllegalArgumentException {
        super(nome, matricula, dataAdmissao, semestre, tipoCurso);

        if (validaAlunoPosgraduacao(nomeOrientador, tituloProjetoDePesquisa, nivel)) {
            this.nomeOrientador = nomeOrientador;
            this.tituloProjetoDePesquisa = tituloProjetoDePesquisa;
            this.nivel = nivel;
        }
        else
            throw new IllegalArgumentException();
    }

    private boolean validaAlunoPosgraduacao(String nomeOrientador, String tituloProjetoDePesquisa, char nivel) {
        return validaNomeOrientador(nomeOrientador) && validaTituloProjetoDePesquisa(tituloProjetoDePesquisa) && validaNivel(nivel);
    }

    private boolean validaNomeOrientador(String nomeOrientador) {
        return !nomeOrientador.isBlank();
    }

    private boolean validaTituloProjetoDePesquisa(String tituloProjetoDePesquisa) {
        return !tituloProjetoDePesquisa.isBlank();
    }

    private boolean validaNivel(char nivel) {
        return nivel == 'M' || nivel == 'D';
    }

    private float calculaMensalidade() {
        float total;
        switch (tipoCurso) {
            case "Engenharias":
                total = VALOR_BASE * (1.2F);
                break;
            
            case "Computacao":
                total = VALOR_BASE * (1.1F);
                break;

            case "Letras":
                total = VALOR_BASE * (1.05F);
                break;

            default:
                total = VALOR_BASE;
        }

        if ((dataAdmissao.until(LocalDate.now(), ChronoUnit.MONTHS)) > (nivel == 'M' ? 24 : (nivel == 'D' ? 48 : 0)))
            total *= 1.2;

        return total;
    }

    @Override
    public String toString() {
        String nome = "Nome: " + this.nome;
        String matricula = "Matricula: " + this.matricula;
        String dataAdmissao = "Data Admissao: " + this.dataAdmissao;
        String semestre = "Semestre: " + this.semestre;
        String tipoCurso = "Tipo Curso: " + this.tipoCurso;
        String mensalidade = "Mensalidade: " + this.mensalidade;
        String nomeOrientador = "Nome do Orientador: " + this.nomeOrientador;
        String tituloProjetoDePesquisa = "Titulo do Projeto de Pesquisa: " + this.tituloProjetoDePesquisa;
        String nivel = "Nivel: " + this.nivel;
        return nome + "\n" + matricula + "\n" + dataAdmissao + "\n" + semestre + "\n" + tipoCurso + "\n" + mensalidade + "\n" + nomeOrientador + "\n" + tituloProjetoDePesquisa + "\n" + nivel;
    }

    public static void main(String[] args) {
        LocalDate dataAdmissao = LocalDate.of(2022, 3, 12);

        AlunoPosgraduacao aluno = new AlunoPosgraduacao("Takeshi", 202210344, dataAdmissao, 3, "Computacao", "Danny", "LP3", 'M');
        System.out.println(aluno);
    }
}
