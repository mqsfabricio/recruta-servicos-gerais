package com.example.recrutaservicosgerais.candidato;

import com.example.recrutaservicosgerais.endereco.DadosEndereco;
import com.example.recrutaservicosgerais.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "candidatos")
@Entity(name = "Candidato")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    @Enumerated(EnumType.STRING)
    private Profissao profissao;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Candidato(DadosCadastroCandidato dadosCadastroCandidato) {
        this.ativo = true;
        this.nome = dadosCadastroCandidato.nome();
        this.cpf = dadosCadastroCandidato.cpf();
        this.telefone = dadosCadastroCandidato.telefone();
        this.email = dadosCadastroCandidato.email();
        this.profissao = dadosCadastroCandidato.profissao();
        this.endereco = new Endereco(dadosCadastroCandidato.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoCandidato dadosAtualizacaoCandidato) {
        if(dadosAtualizacaoCandidato.nome() != null) {
            this.nome = dadosAtualizacaoCandidato.nome();
        }
        if(dadosAtualizacaoCandidato.telefone() != null) {
            this.telefone = dadosAtualizacaoCandidato.telefone();
        }
        if(dadosAtualizacaoCandidato.email() != null) {
            this.email = dadosAtualizacaoCandidato.email();
        }
        if(dadosAtualizacaoCandidato.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosAtualizacaoCandidato.endereco());
        }

    }

    public void excluirCandidato() {
        this.ativo = false;
    }
}
