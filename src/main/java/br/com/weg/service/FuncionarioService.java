package br.com.weg.service;

import br.com.weg.dto.FuncionarioRequestDTO;
import br.com.weg.dto.FuncionarioResponseDTO;
import br.com.weg.mapper.FuncionarioMapper;
import br.com.weg.model.Funcionario;
import br.com.weg.repository.FuncionarioRepository;

import java.util.List;

public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    public void contratarFuncionario(FuncionarioRequestDTO f){
        funcionarioRepository.AddFuncionario(funcionarioMapper.toEntity(f));
    }

    public List<FuncionarioResponseDTO> listarFuncionarios(){
       List<Funcionario> funcionarios = funcionarioRepository.listarFuncionarios();

       if(funcionarios.isEmpty()){
           throw new RuntimeException("Nenhum funcionário encontrado!");
       }

       return funcionarioMapper.listEntityToListDto(funcionarios);
    }

    public void demitirFuncionario(String CPF){
        boolean demitido = funcionarioRepository.demitirFuncionario(CPF);

        if(!demitido){
            throw new RuntimeException("Nenhum funcionário encontrado!");
        }
    }

    public FuncionarioResponseDTO buscarFuncionarioPorCPF(String cpf){
        return funcionarioMapper.toDto(funcionarioRepository.buscarFuncionarioPorCPF(cpf));
    }

    public void editarFuncionario(String CPF, FuncionarioRequestDTO funcionarioEditado){
        Funcionario funcionarioEdit = funcionarioMapper.toEntity(funcionarioEditado);
        funcionarioRepository.editarFuncionario(CPF, funcionarioEdit);
    }

    public double aumentarSalarioFuncionario(FuncionarioResponseDTO funcionarioResponseDTO, double porcentagem){
        double novoSalario = funcionarioResponseDTO.salario() * ((porcentagem / 100) + 1);
        Funcionario func = funcionarioRepository.aumentarSalario(funcionarioResponseDTO.cpf(), novoSalario);
        return novoSalario;
    }
}
