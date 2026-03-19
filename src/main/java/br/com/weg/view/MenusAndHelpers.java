package br.com.weg.view;


public class MenusAndHelpers {

    public int menuPrincipal(){
        System.out.println("\n - TECHFOOD ERP - MENU PRINCIPAL -");
        System.out.println("1 - Gerenciar Funcionários (Ver/Contratar/Demitir/Editar)");
        System.out.println("2 - Pagamentos e Aumento Salarial");
        System.out.println("3 - Gerenciar Cardápio (Ver/Cadastrar/Excluir/Editar)");
        System.out.println("4 - Gerenciar Estoque (Entrada/Visualizar)");
        System.out.println("5 - REALIZAR VENDA (Presencial ou Delivery)");
        System.out.println("0 - Sair");
        return LerDados.lerInteger("Escolha: ");
    }

    public void erro(String mensagem){
        System.out.println("\n[ERRO] -> "+mensagem+"\n");
    }

    public void sucesso(String mensagem){
        System.out.println("\n[SUCESSO] -> "+mensagem+"\n");
    }
}
