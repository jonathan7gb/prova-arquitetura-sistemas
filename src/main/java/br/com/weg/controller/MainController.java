package br.com.weg.controller;

import br.com.weg.view.MenusAndHelpers;

public class MainController {

    private final MenusAndHelpers menusAndHelpers;
    private final FuncionarioController funcionarioController;
    private final PratoController pratoController;

    public MainController(MenusAndHelpers menusAndHelpers, FuncionarioController funcionarioController, PratoController pratoController) {
        this.menusAndHelpers = menusAndHelpers;
        this.funcionarioController = funcionarioController;
        this.pratoController = pratoController;
    }

    public void startSystem(){
        while(true){

            int opcao = menusAndHelpers.menuPrincipal();


            switch (opcao){
                case 1 -> {
                    funcionarioController.FuncionarioController();
                }
                case 2 -> {
                    funcionarioController.AumentoController();
                }
                case 3 -> {
                    pratoController.PratoController();
                }
                case 4 -> {
                    pratoController.EstoqueController();
                }
                case 5 -> {}
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
