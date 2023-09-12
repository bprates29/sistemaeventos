package br.upf.sistemaeventos.model

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Evento(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val data: LocalDate,
    val dataInicioInsc: LocalDateTime,
    val dataFimInsc: LocalDateTime,
    val descricao: String,
    @Enumerated(value = EnumType.STRING)
    val status: StatusEvento,
    @OneToMany(mappedBy = "evento")
    val inscritos: List<Inscricao> = listOf()
)
