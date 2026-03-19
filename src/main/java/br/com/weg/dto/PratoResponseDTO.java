package br.com.weg.dto;

public record PratoResponseDTO (
        int codigo,
        String nome,
        String Categoria,
        double preco,
        int estoque
) {
}
