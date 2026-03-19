package br.com.weg.model;

public class Funcionario {

    private String nome;
    private String CPF;
    private String cargo;
    private Double salario;
    private int idade;

    public Funcionario(String nome, String CPF, String cargo, Double salario, int idade) {
        this.nome = nome;
        this.CPF = CPF;
        this.cargo = cargo;
        this.salario = salario;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String Cargo) {
        cargo = Cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double Salario) {
        salario = Salario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
