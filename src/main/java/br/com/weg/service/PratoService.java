package br.com.weg.service;

import br.com.weg.dto.PratoRequestDTO;
import br.com.weg.dto.PratoResponseDTO;
import br.com.weg.mapper.PratoMapper;
import br.com.weg.model.Prato;
import br.com.weg.repository.PratoRepository;

import java.util.List;

public class PratoService {

    private final PratoRepository pratoRepository;
    private final PratoMapper pratoMapper;

    public PratoService(PratoRepository pratoRepository, PratoMapper pratoMapper) {
        this.pratoRepository = pratoRepository;
        this.pratoMapper = pratoMapper;
    }

    public void adicionarPrato(PratoRequestDTO p){
        pratoRepository.AddPrato(pratoMapper.toEntity(p));
    }

    public List<PratoResponseDTO> listarPratos(){
        List<Prato> pratos = pratoRepository.listarPratos();

        if(pratos.isEmpty()){
            throw new RuntimeException("Nenhum funcionário encontrado!");
        }

        return pratoMapper.listEntityToListDto(pratos);
    }

    public void excluirPrato(int codigo){
        boolean excluido = pratoRepository.excluirPrato(codigo);

        if(!excluido){
            throw new RuntimeException("Nenhum prato encontrado!");
        }
    }

    public PratoResponseDTO buscarPratoPorCodigo(int codigo){
        Prato prato = pratoRepository.buscarPratoPorCodigo(codigo);

        if(prato == null){
            throw new RuntimeException("Nenhum prato encontrado!");
        }
        return pratoMapper.toDto(prato);
    }

    public void editarPrato(int codigo, PratoRequestDTO pratoEditado){
        Prato pratoEdit = pratoMapper.toEntity(pratoEditado);
        pratoRepository.editarPrato(codigo, pratoEdit);
    }

    public void adicionarAoEstoque(int codigo, int quantidade){


        boolean adicionado = pratoRepository.adicionarEstoque(codigo, quantidade);

        if(!adicionado){
            throw new RuntimeException("Erro ao adicionar quantidade ao estoque");
        }
    }

    public void verificarEstoque(int codigo, int quantidade){
        Prato prato = pratoRepository.buscarPratoPorCodigo(codigo);

        if(prato.getEstoque() < quantidade){
            throw new RuntimeException("Quantidade Insuficiente. Tente novamente.");
        }
    }
}
