package br.com.weg.controller;

import br.com.weg.dto.PratoRequestDTO;
import br.com.weg.dto.PratoResponseDTO;
import br.com.weg.service.PratoService;
import br.com.weg.view.PratoView;
import br.com.weg.view.MenusAndHelpers;

public class PratoController {

    private final PratoView pratoView;
    private final PratoService pratoService;
    private final MenusAndHelpers menusAndHelpers;

    public PratoController(PratoView pratoView, PratoService pratoService, MenusAndHelpers menusAndHelpers) {
        this.pratoView = pratoView;
        this.pratoService = pratoService;
        this.menusAndHelpers = menusAndHelpers;
    }

    public void PratoController(){
        while(true){

            int opcao = pratoView.MenuPrato();

            switch (opcao){
                case 1 -> {
                    PratoRequestDTO pratoRequestDTO = pratoView.cadastrarPrato();
                    pratoService.adicionarPrato(pratoRequestDTO);
                }
                case 2 -> {
                    pratoView.listarPratos(pratoService.listarPratos());
                }
                case 3 -> {
                    int codigo = pratoView.inserirCodigoPrato();
                    pratoService.excluirPrato(codigo);
                }
                case 4 -> {
                    int codigo = pratoView.inserirCodigoPrato();
                    PratoResponseDTO pratoResponseDTO = pratoService.buscarPratoPorCodigo(codigo);
                    PratoRequestDTO pratoRequestDTO = pratoView.editarPrato(pratoResponseDTO);
                    pratoService.editarPrato(codigo, pratoRequestDTO);
                }
                case 0 -> {
                    return;
                }
                default -> {
                    menusAndHelpers.erro("Opção Inválida. Tente Novamente");
                }
            }
        }
    }

    public void EstoqueController(){
        while(true) {

            int opcao = pratoView.MenuEstoque();

            switch (opcao){
                case 1 -> {
                    int codigo = pratoView.inserirCodigoPrato();
                    PratoResponseDTO pratoResponseDTO = pratoService.buscarPratoPorCodigo(codigo);
                    int quantidadeAdd = pratoView.adicionarEstoque();
                    pratoService.adicionarAoEstoque(codigo, quantidadeAdd);
                }
                case 2  -> {
                    pratoView.listarEstoque(pratoService.listarPratos());
                }
                case 0 -> {
                    return;
                }
                default -> {
                    menusAndHelpers.erro("Opção Inválida. Tente Novamente");
                }
            }
        }
    }
}
