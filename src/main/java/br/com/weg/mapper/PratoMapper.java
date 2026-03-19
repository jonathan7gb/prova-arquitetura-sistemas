package br.com.weg.mapper;

import br.com.weg.dto.PratoRequestDTO;
import br.com.weg.dto.PratoResponseDTO;
import br.com.weg.model.Prato;

import java.util.ArrayList;
import java.util.List;

public class PratoMapper {

    public Prato toEntity(PratoRequestDTO pratoRequestDTO){
        return new Prato(
                pratoRequestDTO.codigo(),
                pratoRequestDTO.nome(),
                pratoRequestDTO.Categoria(),
                pratoRequestDTO.preco(),
                pratoRequestDTO.estoque()
        );
    }

    public PratoResponseDTO toDto(Prato prato){
        return new PratoResponseDTO(
                prato.getCodigo(),
                prato.getNome(),
                prato.getCategoria(),
                prato.getPreco(),
                prato.getEstoque()
        );
    }

    public List<PratoResponseDTO> listEntityToListDto(List<Prato> pratoList){
        List<PratoResponseDTO> pratoResponseDTOS = new ArrayList<>();
        for(Prato f : pratoList){
            pratoResponseDTOS.add(toDto(f));
        }
        return pratoResponseDTOS;
    }

    public List<Prato> listDtoToListEntity(List<PratoRequestDTO> pratoResponseDTOS){
        List<Prato> pratoList = new ArrayList<>();
        for(PratoRequestDTO f : pratoResponseDTOS){
            pratoList.add(toEntity(f));
        }
        return pratoList;
    }
}
