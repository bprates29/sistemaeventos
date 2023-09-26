package br.upf.sistemaeventos.service

import br.upf.sistemaeventos.model.Usuario
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import com.auth0.jwt.JWT
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class TokenService {

    @Value("\${api.security.token.secret}")
    private lateinit var secret: String

    fun generateToken(usuario: Usuario): String {
        return try {
            val algorithm = Algorithm.HMAC256(secret)
            JWT.create()
                .withIssuer("auth-api")
                .withSubject(usuario.email)
                .withExpiresAt(genExpirationDate())
                .sign(algorithm)
        } catch (exception: Exception) {
            throw RuntimeException("Erro na geração do token!", exception)
        }
    }

    fun validadeToken(token: String): String {
        return try {
            val algorithm = Algorithm.HMAC256(secret)
            JWT.require(algorithm)
                .withIssuer("auth-api")
                .build()
                .verify(token)
                .subject
        } catch (ex: Exception) {
            ""
        }
    }

    private fun genExpirationDate() =
        LocalDateTime.now()
            .plusHours(2)
            .toInstant(ZoneOffset.of("-03:00"))
}