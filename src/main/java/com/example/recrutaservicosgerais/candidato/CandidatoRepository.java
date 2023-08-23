package com.example.recrutaservicosgerais.candidato;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    Page<Candidato> findAllByAtivoTrue(Pageable paginacao);

}
