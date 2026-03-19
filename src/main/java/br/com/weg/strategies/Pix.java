package br.com.weg.strategies;

public class Pix implements IPagamento{
    @Override
    public double valorTipoPagamento(double valorCompra) {
        return valorCompra * 0.90;
    }
}
