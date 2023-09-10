package br.com.dsl.agrogpt.api.service;

import br.com.dsl.agrogpt.api.models.Cliente;
import br.com.dsl.agrogpt.api.models.Credencial;
import br.com.dsl.agrogpt.api.models.Token;
import br.com.dsl.agrogpt.api.repository.ClienteRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    @Autowired
    ClienteRepository clienteRepository;

    @Value("${jwt.secret}")
    String secret;

    public Token generateToken(Credencial credencial, Long userId) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var token = JWT.create()
                .withSubject(credencial.email())
                .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                .withIssuer("PlantAI")
                .sign(alg);

        return new Token(token, "JWT", "Bearer", userId);
    }

    public Cliente valideAndGetUserBy(String token) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var email =  JWT.require(alg)
                .withIssuer("PlantAI")
                .build()
                .verify(token)
                .getSubject();

        return clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente nao encotrado!"));
    }

}
