package br.upf.sistemaeventos.dtos

import br.upf.sistemaeventos.model.Inscricao
import br.upf.sistemaeventos.model.StatusEvento
import java.time.LocalDate

data class EventoResponseDTO (
    val id: Long?,
    val nome: String,
    val data: LocalDate,
    val descricao: String,
    val status: StatusEvento,
    val inscritos: List<Inscricao>
)