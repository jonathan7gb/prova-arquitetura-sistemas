package br.com.weg.view;

import br.com.weg.dto.PratoRequestDTO;
import br.com.weg.dto.PratoResponseDTO;

import java.util.List;

public class PratoView {

    public int MenuPrato(){
        System.out.println("\n - GERENCIAR CARDÁPIO -");
        System.out.println("1 - Adicionar Prato");
        System.out.println("2 - Listar Pratos ");
        System.out.println("3 - Excluir Prato ");
        System.out.println("4 - Editar Prato ");
        System.out.println("0 - Sair");
        return LerDados.lerInteger("Escolha: ");
    }

    public int MenuEstoque(){
        System.out.println("\n - GERENCIAR ESTOQUE -");
        System.out.println("1 - Adicionar Estoque");
        System.out.println("2 - Listar Estoque ");
        System.out.println("0 - Sair");
        return LerDados.lerInteger("Escolha: ");
    }

    public void listarPratos(List<PratoResponseDTO> lista){
        System.out.println("\n - LISTAR PRATOS -");
        for(PratoResponseDTO p : lista){
            System.out.println("Código: " + p.codigo());
            System.out.println("Nome: " + p.nome());
            System.out.println("Categoria: " + p.Categoria());
            System.out.println("Preço: R$" + p.preco());
            System.out.println("Estoque: " + p.estoque());
            System.out.println("-------------------------------------");
        }
    }

    public PratoRequestDTO cadastrarPrato(){
        System.out.println("\n - CADASTRAR PRATOS  -");
        int codigo = LerDados.lerInteger("Codigo: ");
        String nome = LerDados.lerString("Nome: ");
        String Categoria = LerDados.lerString("Categoria: ");
        double preco = LerDados.lerDouble("Preço: R$");
        int estoque = LerDados.lerInteger("Estoque Inicial: ");
        System.out.println("-------------------------------------");
        return new PratoRequestDTO(codigo, nome, Categoria, preco, estoque);
    }

    public int inserirCodigoPrato(){
        return LerDados.lerInteger("Codigo do prato: ");
    }

    public PratoRequestDTO editarPrato(PratoResponseDTO funcionarioResponseDTO ){
        System.out.println("\n - EDITAR PRATO -");
        int codigo = LerDados.lerInteger("Código ("+funcionarioResponseDTO.codigo()+"): ");
        String nome = LerDados.lerString("Nome ("+funcionarioResponseDTO.nome()+"): ");
        String Categoria = LerDados.lerString("Categoria ("+funcionarioResponseDTO.Categoria()+"): ");
        double preco = LerDados.lerDouble("Preço ("+funcionarioResponseDTO.preco()+"): ");
        int estoque = LerDados.lerInteger("Estoque ("+funcionarioResponseDTO.estoque()+"): ");
        System.out.println("-------------------------------------");

        return new PratoRequestDTO(codigo, nome, Categoria, preco, estoque);
    }

    public int adicionarEstoque(){
        return LerDados.lerInteger("Quantidade a somar no estoque do prato: ");
    }

    public int quantidadeVenda(){
        return LerDados.lerInteger("Quantidade do prato: ");
    }

    public void listarEstoque(List<PratoResponseDTO> lista){
        System.out.println("\n - LISTAR ESTOQUE -");
        for(PratoResponseDTO p : lista){
            System.out.println("Código: " + p.codigo());
            System.out.println("Nome: " + p.nome());
            System.out.println("Estoque Atual: " + p.estoque());
            System.out.println("-------------------------------------");
        }
    }
}
