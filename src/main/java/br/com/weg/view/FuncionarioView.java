package br.com.weg.view;

import br.com.weg.dto.FuncionarioRequestDTO;
import br.com.weg.dto.FuncionarioResponseDTO;
import br.com.weg.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class FuncionarioView {

    public int MenuFuncionario(){
        System.out.println("\n - GERENCIAR FUNCIONÁRIOS -");
        System.out.println("1 - Listar");
        System.out.println("2 - Contratar ");
        System.out.println("3 - Demitir ");
        System.out.println("4 - Editar ");
        System.out.println("0 - Sair");
        return LerDados.lerInteger("Escolha: ");
    }

    public void listarFuncionarios(List<FuncionarioResponseDTO> lista){
        System.out.println("\n - LISTAR FUNCIONÁRIOS -");
        for(FuncionarioResponseDTO f : lista){
            System.out.println("Nome: " + f.nome());
            System.out.println("CPF: " + f.cpf());
            System.out.println("Cargo: " + f.cargo());
            System.out.println("Salário: " + f.salario());
            System.out.println("Idade: " + f.idade());
            System.out.println("-------------------------------------");
        }
    }

    public FuncionarioRequestDTO contratarFuncionario(){
        System.out.println("\n - Contratar Funcionário -");
        String nome = LerDados.lerString("Nome: ");
        String CPF = LerDados.lerString("CPF: ");
        String cargo = LerDados.lerString("Cargo: ");
        double salario = LerDados.lerDouble("Salário: ");
        int idade = LerDados.lerInteger("Idade: ");
        System.out.println("-------------------------------------");
        return new FuncionarioRequestDTO(nome, CPF, cargo, salario, idade);
    }

    public String inserirCPFFuncionario(){
        return LerDados.lerString("CPF do Funcionário: ");
    }

    public FuncionarioRequestDTO editarFuncionario( FuncionarioResponseDTO funcionarioResponseDTO ){
        System.out.println("\n - Editar Funcionário -");
        String nome = LerDados.lerString("Nome ("+funcionarioResponseDTO.nome()+"): ");
        String CPF = LerDados.lerString("CPF ("+funcionarioResponseDTO.cpf()+"): ");
        String cargo = LerDados.lerString("Cargo ("+funcionarioResponseDTO.cargo()+"): ");
        double salario = LerDados.lerDouble("Salário ("+funcionarioResponseDTO.salario()+"): ");
        int idade = LerDados.lerInteger("Idade ("+funcionarioResponseDTO.idade()+"): ");
        System.out.println("-------------------------------------");

        return new FuncionarioRequestDTO(nome, CPF, cargo, salario, idade);
    }

    public double porcentagemAumento(){
        return LerDados.lerDouble("Insira a porcentagem de aumento do funcionário (%): ");
    }
}
