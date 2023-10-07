package br.upf.sistemaeventos.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.LocalDate

@Entity
data class Evento(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val data: LocalDate,
    val descricao: String,
    @Enumerated(value = EnumType.STRING)
    val status: StatusEvento,
    @OneToMany(mappedBy = "evento")
    val inscritos: List<Inscricao> = listOf()
)
