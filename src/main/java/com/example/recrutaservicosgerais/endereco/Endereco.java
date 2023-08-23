package com.example.recrutaservicosgerais.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
    private String complemento;

    public Endereco(DadosEndereco dadosEndereco) {
        this.logradouro = dadosEndereco.logradouro();
        this.numero = dadosEndereco.numero();
        this.bairro = dadosEndereco.bairro();
        this.cidade = dadosEndereco.cidade();
        this.cep = dadosEndereco.cep();
        this.uf = dadosEndereco.uf();
        this.complemento = dadosEndereco.complemento();

    }

    public void atualizarInformacoes(DadosEndereco dadosEndereco) {
        if(dadosEndereco.logradouro() != null) {
            this.logradouro = dadosEndereco.logradouro();
        }
        if(dadosEndereco.numero() != null) {
            this.numero = dadosEndereco.numero();
        }
        if(dadosEndereco.bairro() != null) {
            this.bairro = dadosEndereco.bairro();
        }
        if(dadosEndereco.cidade() != null) {
            this.cidade = dadosEndereco.cidade();
        }
        if(dadosEndereco.cep() != null) {
            this.cep = dadosEndereco.cep();
        }
        if(dadosEndereco.uf() != null) {
            this.uf = dadosEndereco.uf();
        }
        if(dadosEndereco.complemento() != null) {
            this.complemento = dadosEndereco.complemento();
        }
    }
}
