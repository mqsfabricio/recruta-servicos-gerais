package com.example.recrutaservicosgerais.controller;

import com.example.recrutaservicosgerais.candidato.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroCandidato dadosCadastroCandidato) {
        candidatoRepository.save(new Candidato(dadosCadastroCandidato));
    }

//    @GetMapping
//    public List<DadosListagemCandidato> listar() {
//        return candidatoRepository.findAll().stream().map(DadosListagemCandidato::new).toList();
//    }

    @GetMapping
    public Page<DadosListagemCandidato> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"})  Pageable paginacao) {
        return candidatoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemCandidato::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoCandidato dadosAtualizacaoCandidato) {
        var candidato = candidatoRepository.getReferenceById(dadosAtualizacaoCandidato.id());
        candidato.atualizarInformacoes(dadosAtualizacaoCandidato);
    }
//    @DeleteMapping("{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id) {
//        candidatoRepository.deleteById(id);
//    }

    @DeleteMapping("{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var candidato = candidatoRepository.getReferenceById(id);
        candidato.excluirCandidato();
    }

}
