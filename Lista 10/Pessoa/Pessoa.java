package Pessoa;

import java.time.LocalDate;

public class Pessoa {
    protected String nome;
    protected long id;
    protected LocalDate nascimento;

    public Pessoa(String nome, long id, LocalDate nascimento) {
        this.nome = nome;
        this.id = id;
        this.nascimento = nascimento;
    }

    public String toString() {
        String nome = "Nome: " + this.nome + "\n";
        String id = "ID: " + this.id + "\n";
        String nascimento = "Data de nascimento: " + this.nascimento + "\n";
        return nome + id + nascimento;
    }
}
