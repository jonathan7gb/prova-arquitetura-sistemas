package br.com.weg.controller;

import br.com.weg.dto.FuncionarioRequestDTO;
import br.com.weg.dto.FuncionarioResponseDTO;
import br.com.weg.service.FuncionarioService;
import br.com.weg.view.FuncionarioView;
import br.com.weg.view.LerDados;
import br.com.weg.view.MenusAndHelpers;

public class FuncionarioController {

    private final FuncionarioView funcionarioView;
    private final FuncionarioService funcionarioService;
    private final MenusAndHelpers menusAndHelpers;

    public FuncionarioController(FuncionarioView funcionarioView, FuncionarioService funcionarioService, MenusAndHelpers menusAndHelpers) {
        this.funcionarioView = funcionarioView;
        this.funcionarioService = funcionarioService;
        this.menusAndHelpers = menusAndHelpers;
    }

    public void FuncionarioController(){
        while(true){

            int opcao = funcionarioView.MenuFuncionario();

            switch (opcao){
                case 1 -> {
                    funcionarioView.listarFuncionarios(funcionarioService.listarFuncionarios());
                }
                case 2 -> {
                    FuncionarioRequestDTO funcionarioRequestDTO = funcionarioView.contratarFuncionario();
                    funcionarioService.contratarFuncionario(funcionarioRequestDTO);
                }
                case 3 -> {
                    String cpf = funcionarioView.inserirCPFFuncionario();
                    funcionarioService.demitirFuncionario(cpf);
                }
                case 4 -> {
                    String cpf = funcionarioView.inserirCPFFuncionario();
                    FuncionarioResponseDTO funcionarioResponseDTO = funcionarioService.buscarFuncionarioPorCPF(cpf);
                    FuncionarioRequestDTO funcionarioRequestDTO = funcionarioView.editarFuncionario(funcionarioResponseDTO);
                    funcionarioService.editarFuncionario(cpf, funcionarioRequestDTO);
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

    public void AumentoController(){
        String cpf = funcionarioView.inserirCPFFuncionario();
        FuncionarioResponseDTO funcionarioResponseDTO = funcionarioService.buscarFuncionarioPorCPF(cpf);
        double porcentagemAumento = funcionarioView.porcentagemAumento();
        double salario = funcionarioService.aumentarSalarioFuncionario(funcionarioResponseDTO, porcentagemAumento);
        menusAndHelpers.sucesso("Novo salário do funcionário: R$" + salario);
    }
}
