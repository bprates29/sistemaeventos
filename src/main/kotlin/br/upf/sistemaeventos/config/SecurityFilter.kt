package br.upf.sistemaeventos.config

import br.upf.sistemaeventos.model.Usuario
import br.upf.sistemaeventos.repository.UsuarioRepository
import br.upf.sistemaeventos.service.TokenService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class SecurityFilter(
    val tokenService: TokenService,
    val usuarioRepository: UsuarioRepository
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = recoverToken(request)
        if (token != null) {
            val email = tokenService.validadeToken(token)
            val user = usuarioRepository.findByEmail(email)
            val authentication =
                UsernamePasswordAuthenticationToken(user, null, user!!.authorities)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }

    private fun recoverToken(request: HttpServletRequest): String? {
        val authHeader = request.getHeader("Authorization")
        return authHeader?.replace("Bearer ", "")
    }
}