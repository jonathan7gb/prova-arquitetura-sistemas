package br.com.weg;

import br.com.weg.controller.FuncionarioController;
import br.com.weg.controller.MainController;
import br.com.weg.controller.PratoController;
import br.com.weg.mapper.FuncionarioMapper;
import br.com.weg.mapper.PratoMapper;
import br.com.weg.repository.FuncionarioRepository;
import br.com.weg.repository.PratoRepository;
import br.com.weg.service.FuncionarioService;
import br.com.weg.service.PratoService;
import br.com.weg.view.FuncionarioView;
import br.com.weg.view.MenusAndHelpers;
import br.com.weg.view.PratoView;

public class Main {
    public static void main(String[] args) {

        MenusAndHelpers menusAndHelpers = new MenusAndHelpers();
        FuncionarioService funcionarioService = new FuncionarioService(new FuncionarioRepository(), new FuncionarioMapper());
        PratoService pratoService = new PratoService(new PratoRepository(), new PratoMapper());
        FuncionarioController funcionarioController = new FuncionarioController(new FuncionarioView(),funcionarioService, menusAndHelpers);
        PratoController pratoController = new PratoController(new PratoView(),pratoService, menusAndHelpers);

        MainController mainController = new MainController(menusAndHelpers, funcionarioController, pratoController);

        mainController.startSystem();

    }
}