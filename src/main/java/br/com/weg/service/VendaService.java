package br.com.weg.service;

import br.com.weg.dto.PratoRequestDTO;
import br.com.weg.dto.PratoResponseDTO;
import br.com.weg.mapper.PratoMapper;
import br.com.weg.model.Prato;
import br.com.weg.repository.PratoRepository;
import br.com.weg.strategies.IEntrega;
import br.com.weg.strategies.IPagamento;

public class VendaService {

    private final PratoRepository pratoRepository;
    private final PratoMapper pratoMapper;

    public VendaService(PratoRepository pratoRepository, PratoMapper pratoMapper) {
        this.pratoRepository = pratoRepository;
        this.pratoMapper = pratoMapper;
    }

    public void vender(PratoRequestDTO pratoDto, int quantidade, IEntrega iEntrega, IPagamento iPagamento, int parcelas){
        Prato prato = pratoMapper.toEntity(pratoDto);
        double valor = prato.getPreco() * quantidade;

        valor = iEntrega.valorcomentrega(valor);
        valor = iPagamento.valorTipoPagamento(valor);

        System.out.println("\n - DETALHES DA VENDA -");
        System.out.println("PRATO: ["+ prato.getCodigo() +"] " + prato.getNome());
        System.out.println("QUANTIDADE: " + quantidade);
        System.out.println("FORMA DE PAGAMENTO: " + iPagamento.getClass().getName());
        System.out.println("MÉTODO DA ENTREGA: " + iEntrega.getClass().getName());
        System.out.println("VALOR FINAL: "+ parcelas+"x R$" + (valor/parcelas));
    }
}
