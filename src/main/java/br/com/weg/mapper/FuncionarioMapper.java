package br.com.weg.mapper;

import br.com.weg.dto.FuncionarioRequestDTO;
import br.com.weg.dto.FuncionarioResponseDTO;
import br.com.weg.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioMapper {

    public Funcionario toEntity(FuncionarioRequestDTO funcionarioRequestDTO){
        return new Funcionario(
                funcionarioRequestDTO.nome(),
                funcionarioRequestDTO.cpf(),
                funcionarioRequestDTO.cargo(),
                funcionarioRequestDTO.salario(),
                funcionarioRequestDTO.idade()
        );
    }

    public FuncionarioResponseDTO toDto(Funcionario funcionario){
        return new FuncionarioResponseDTO(
                funcionario.getNome(),
                funcionario.getCPF(),
                funcionario.getCargo(),
                funcionario.getSalario(),
                funcionario.getIdade()
        );
    }

    public List<FuncionarioResponseDTO> listEntityToListDto(List<Funcionario> funcionarioList){
        List<FuncionarioResponseDTO> funcionarioResponseDTOS = new ArrayList<>();
        for(Funcionario f : funcionarioList){
            funcionarioResponseDTOS.add(toDto(f));
        }
        return funcionarioResponseDTOS;
    }

    public List<Funcionario> listDtoToListEntity(List<FuncionarioRequestDTO> funcionarioResponseDTOS){
        List<Funcionario> funcionarioList = new ArrayList<>();
        for(FuncionarioRequestDTO f : funcionarioResponseDTOS){
            funcionarioList.add(toEntity(f));
        }
        return funcionarioList;
    }
}
