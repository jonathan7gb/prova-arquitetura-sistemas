package br.com.weg.strategies;

public class Delivery implements IEntrega{


    @Override
    public double valorcomentrega(double valorCompra) {
        return valorCompra + 15.0;
    }
}
