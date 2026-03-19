package br.com.weg.controller;

import br.com.weg.dto.PratoResponseDTO;
import br.com.weg.service.PratoService;
import br.com.weg.strategies.*;
import br.com.weg.view.MenusAndHelpers;
import br.com.weg.view.PratoView;
import br.com.weg.view.VendaView;

public class VendaController {

    private final PratoView pratoView;
    private final VendaView vendaView;
    private final PratoService pratoService;
    private final MenusAndHelpers menusAndHelpers;
    private IEntrega iEntrega;
    private IPagamento iPagamento;

    public VendaController(PratoView pratoView, VendaView vendaView, PratoService pratoService, MenusAndHelpers menusAndHelpers) {
        this.pratoView = pratoView;
        this.vendaView = vendaView;
        this.pratoService = pratoService;
        this.menusAndHelpers = menusAndHelpers;
    }


    public void VendaController() {
        int codigoPrato = pratoView.inserirCodigoPrato();
        PratoResponseDTO pratoResponseDTO = pratoService.buscarPratoPorCodigo(codigoPrato);
        int quantidadeVenda = pratoView.quantidadeVenda();
        pratoService.verificarEstoque(codigoPrato, quantidadeVenda);

        alterarFormaPagamento(vendaView.formaPagamento();)
    }

    public int alterarFormaPagamento(int escolha){
        int totalParcelas = 1;
        switch (escolha){
            case 1 -> {
                this.iPagamento = new Credito();
                totalParcelas = vendaView.totalParcelas();
            }
            case 2 -> this.iPagamento = new Debito();
            case 3 -> this.iPagamento = new Pix();
            case 4 -> this.iPagamento = new Especie();
        }
        return totalParcelas;
    }

    public void alterarMetodoEntrega(int escolha){
        switch (escolha){
            case 1 -> {
                this.iEntrega = new Presencial();
            }
            case 2 -> this.iEntrega = new Delivery();
        }
    }
}
