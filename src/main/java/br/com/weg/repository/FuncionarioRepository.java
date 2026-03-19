package br.com.weg.repository;

import br.com.weg.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {

    List<Funcionario> listaFuncionarios = new ArrayList<>();

    public void AddFuncionario(Funcionario f){
        listaFuncionarios.add(f);
    }

    public List<Funcionario> listarFuncionarios(){
        return listaFuncionarios;
    }

    public Funcionario buscarFuncionarioPorCPF(String CPF){
        for(Funcionario f : listaFuncionarios){
            if(f.getCPF().equals(CPF)){
                return f;
            }
        }
        return null;
    }

    public boolean demitirFuncionario(String CPF){
        for(Funcionario f : listaFuncionarios){
            if(f.getCPF().equals(CPF)){
                listaFuncionarios.remove(f);
                return true;
            }
        }
        return false;
    }

    public void editarFuncionario(String CPF, Funcionario funcEditado){
        for(Funcionario f : listaFuncionarios){
            if(f.getCPF().equals(CPF)){
                f.setNome(funcEditado.getNome());
                f.setCPF(funcEditado.getCPF());
                f.setCargo(funcEditado.getCargo());
                f.setSalario(funcEditado.getSalario());
                f.setIdade(funcEditado.getIdade());
            }
        }
    }

    public Funcionario aumentarSalario(String cpf, Double NovoSalario){
        for(Funcionario f : listaFuncionarios){
            if(f.getCPF().equals(cpf)){
                f.setSalario(NovoSalario);
                return f;
            }
        }
        return null;
    }

}
