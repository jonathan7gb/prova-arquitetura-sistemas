package br.com.weg.dto;

import java.math.BigDecimal;

public record FuncionarioResponseDTO(
        String nome,
        String cpf,
        String cargo,
        Double salario,
        int idade
) {
}
