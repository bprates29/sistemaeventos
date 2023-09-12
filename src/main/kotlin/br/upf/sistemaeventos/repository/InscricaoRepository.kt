package br.upf.sistemaeventos.repository

import br.upf.sistemaeventos.model.Inscricao
import org.springframework.data.jpa.repository.JpaRepository

interface InscricaoRepository: JpaRepository<Inscricao, Long> {
}