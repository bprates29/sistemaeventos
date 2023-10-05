package br.upf.sistemaeventos.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.springframework.boot.autoconfigure.domain.EntityScan
import java.time.LocalDateTime

@Entity
data class Inscricao(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    val usuario: Usuario,
    @ManyToOne
    val evento: Evento,
    val data: LocalDateTime = LocalDateTime.now()
)
