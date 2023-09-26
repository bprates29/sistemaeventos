package br.upf.sistemaeventos.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val senha: String,
    val email: String,
    @Enumerated(value = EnumType.STRING)
    val role: UserRole = UserRole.USER,
    val cidade: String,
    val telefone: String,

    @OneToMany(mappedBy = "usuario")
    val inscricoes: List<Inscricao> = listOf()
): UserDetails {
    override fun getAuthorities(): MutableList<SimpleGrantedAuthority> {
        if (role == UserRole.ADMIN) {
            return mutableListOf(
                SimpleGrantedAuthority("ROLE_ADMIN"),
                SimpleGrantedAuthority("ROLE_USER")
            )
        }
        return mutableListOf(SimpleGrantedAuthority("ROLE_USER"))
    }

    override fun getPassword() = senha

    override fun getUsername() = email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

}
