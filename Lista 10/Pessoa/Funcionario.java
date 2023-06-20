package Pessoa;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
    protected LocalDate admissao;
    protected double salario;

    public Funcionario(String nome, long id, LocalDate nascimento, LocalDate admissao, double salario) {
        super(nome, id, nascimento);
        this.admissao = admissao;
        this.salario = salario;
    }

    @Override
    public String toString() {
        String nome = "Nome: " + this.nome + "\n";
        String id = "ID: " + this.id + "\n";
        String nascimento = "Data de nascimento: " + this.nascimento + "\n";
        String admissao = "Data de admissao: " + this.admissao + "\n";
        String salario = "Salario: " + this.salario + "\n";
        return nome + id + nascimento + admissao + salario;
    }

    public double qualSalario() {
        return salario;
    }
}
