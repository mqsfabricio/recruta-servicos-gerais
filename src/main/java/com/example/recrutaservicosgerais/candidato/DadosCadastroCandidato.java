package com.example.recrutaservicosgerais.candidato;

import com.example.recrutaservicosgerais.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCandidato(
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,
        @NotNull
        Profissao profissao,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
