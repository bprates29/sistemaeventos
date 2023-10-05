package br.upf.sistemaeventos.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.springframework.boot.autoconfigure.domain.EntityScan

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val cidade: String,
    val telefone: String,

    @OneToMany
    val incricoes: List<Inscricao> = listOf()
)
