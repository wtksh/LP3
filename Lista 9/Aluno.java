import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Aluno {
    protected String nome;
    protected int matricula;
    protected LocalDate dataAdmissao;
    protected int semestre;
    protected String tipoCurso;
    protected float mensalidade;
    protected static final float VALOR_BASE = 700;

    public Aluno(String nome, int matricula, LocalDate dataAdmissao, int semestre, String tipoCurso) throws IllegalArgumentException {
        if (validaAluno(nome, semestre, tipoCurso)) {
            this.nome = nome;
            this.matricula = matricula;
            this.dataAdmissao = dataAdmissao;
            this.semestre = semestre;
            this.tipoCurso = tipoCurso;
            this.mensalidade = calcularMensalidade();
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    private boolean validaAluno(String nome, int semestre, String tipoCurso) {
        return validaNome(nome) && validaSemestre(semestre) && validaTipoCurso(tipoCurso);
    }

    private boolean validaNome(String nome) {
        return !nome.isBlank();
    }

    private boolean validaSemestre(int semestre) {
        return semestre > 0;
    }

    private boolean validaTipoCurso(String tipoCurso) {
        return tipoCurso == "Engenharias" || tipoCurso == "Computacao" || tipoCurso == "Letras" || tipoCurso == "Biologicas";
    }

    private float calcularMensalidade() {
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

        if (semestre != (int) (dataAdmissao.until(LocalDate.now(), ChronoUnit.MONTHS) / 7 + 1))
            total *= 1.2;

        return total;
    }

    public String toString() {
        String nome = "Nome: " + this.nome;
        String matricula = "Matricula: " + this.matricula;
        String dataAdmissao = "Data Admissao: " + this.dataAdmissao;
        String semestre = "Semestre: " + this.semestre;
        String tipoCurso = "Tipo Curso: " + this.tipoCurso;
        String mensalidade = "Mensalidade: " + this.mensalidade;
        return nome + "\n" + matricula + "\n" + dataAdmissao + "\n" + semestre + "\n" + tipoCurso + "\n" + mensalidade;
    }

    public static void main(String[] args) {
        LocalDate dataAdmissao = LocalDate.of(2022, 3, 12);

        Aluno aluno = new Aluno("Takeshi", 202210344, dataAdmissao, 3, "Computacao");
        System.out.println(aluno);
    }


}
