package br.com.weg.strategies;

public class Debito implements IPagamento{
    @Override
    public double valorTipoPagamento(double valorCompra) {
        return valorCompra;
    }
}
