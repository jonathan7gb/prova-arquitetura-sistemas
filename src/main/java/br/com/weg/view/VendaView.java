package br.com.weg.view;

public class VendaView {


    public int formaPagamento(){
        System.out.println("\n - FORMA DE PAGAMENTO -");
        System.out.println("1 - Crédito");
        System.out.println("2 - Débito ");
        System.out.println("3 - Pix ");
        System.out.println("4 - Espécie ");
        return LerDados.lerInteger("Escolha: ");
    }

    public int metodoEntrega(){
        System.out.println("\n - MÉTODO DE ENTREGA -");
        System.out.println("1 - Presencial");
        System.out.println("2 - Delivery ");
        return LerDados.lerInteger("Escolha: ");
    }

    public int totalParcelas(){
        return LerDados.lerInteger("Total de parcelas: ");
    }

}
