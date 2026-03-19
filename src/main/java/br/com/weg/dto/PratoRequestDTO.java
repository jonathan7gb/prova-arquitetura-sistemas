package br.com.weg.dto;

public record PratoRequestDTO(
        int codigo,
        String nome,
        String Categoria,
        double preco,
        int estoque
) {
}
