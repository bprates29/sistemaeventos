package br.upf.sistemaeventos.dtos

data class UsuarioDTO(
    val nome: String,
    val cidade: String,
    val telefone: String,
    val senha: String,
    val email: String
)
