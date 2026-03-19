package br.com.weg.strategies;

public class Presencial implements IEntrega{

    @Override
    public double valorcomentrega(double valorCompra) {
        return valorCompra;
    }
}
