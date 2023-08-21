package br.upf.sistemaeventos.repository

import br.upf.sistemaeventos.model.Evento
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EventoRepository: JpaRepository<Evento, Long> {

    fun findByNome(nomeEvento: String, paginacao: Pageable): Page<Evento>
}