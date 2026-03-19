package br.com.weg.strategies;

public class Especie implements IPagamento{
    @Override
    public double valorTipoPagamento(double valorCompra) {
        return valorCompra * 0.92;
    }
}
