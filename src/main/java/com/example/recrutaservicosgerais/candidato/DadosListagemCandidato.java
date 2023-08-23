package com.example.recrutaservicosgerais.candidato;

public record DadosListagemCandidato(Long id, String nome, String telefone, String email, Profissao profissao) {
    public DadosListagemCandidato(Candidato candidato) {
        this(candidato.getId(), candidato.getNome(), candidato.getTelefone(), candidato.getEmail(), candidato.getProfissao());
    }
}
