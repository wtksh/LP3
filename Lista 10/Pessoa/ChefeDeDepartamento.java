package Pessoa;

import java.time.LocalDate;

public class ChefeDeDepartamento extends Funcionario {
    private String departamento;
    private LocalDate promocaoChefe;

    ChefeDeDepartamento(String nome, long id, LocalDate nascimento, LocalDate admissao, double salario, String departamento, LocalDate promocaoChefe) {
        super(nome, id, nascimento, admissao, salario);
        this.departamento = departamento;
        this.promocaoChefe = promocaoChefe;
    }
    
    @Override
    public String toString() {
        String nome = "Nome: " + this.nome + "\n";
        String id = "ID: " + this.id + "\n";
        String nascimento = "Data de nascimento: " + this.nascimento + "\n";
        String admissao = "Data de admissao: " + this.admissao + "\n";
        String salario = "Salario: " + this.salario + "\n";
        String departamento = "Departamento: " + this.departamento + "\n";
        String promocaoChefe = "Data de promocao: " + this.promocaoChefe + "\n";
        return nome + id + nascimento + admissao + salario + departamento + promocaoChefe;
    }

    public String getDepartamento() {
        return departamento;
    }
}
