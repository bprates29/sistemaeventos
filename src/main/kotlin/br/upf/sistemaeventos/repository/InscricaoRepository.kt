package br.upf.sistemaeventos.repository

import br.upf.sistemaeventos.model.Inscricao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InscricaoRepository: JpaRepository<Inscricao, Long> {
}