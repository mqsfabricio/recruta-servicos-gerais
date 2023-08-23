package com.example.recrutaservicosgerais.candidato;

import com.example.recrutaservicosgerais.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCandidato(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String email,
        DadosEndereco endereco) {
}
