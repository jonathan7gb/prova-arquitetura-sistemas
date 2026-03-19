package br.com.weg.strategies;

public class Credito implements IPagamento{
    @Override
    public double valorTipoPagamento(double valorCompra) {
        return valorCompra * 1.05;
    }
}
