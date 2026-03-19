package br.com.weg.dto;

import java.math.BigDecimal;

public record FuncionarioRequestDTO(
        String nome,
        String cpf,
        String cargo,
        Double salario,
        int idade
) {
}
