package com.medeiros.aposta.services;

import com.medeiros.aposta.entities.Aposta;
import com.medeiros.aposta.repositories.ApostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GeradorApostaService {

    private static final int MIN = 1;
    private static final int MAX = 60;
    private final ApostaRepository apostaRepository;

    public Aposta gerar(Aposta aposta) {
        var data = ZonedDateTime.now();
        var apostaAutomatica = aposta.toBuilder()
                .comprovante(UUID.randomUUID().toString())
                .numeroAposta(geraNumeroAposta(aposta.getEmailApostador()))
                .dataCriacao(data)
                .dataAtualizacao(data)
                .build();
        return apostaRepository.save(apostaAutomatica);
    }

    private Integer geraNumeroAposta(String emailApostador) {
        var apostas = apostaRepository.findByEmailApostador(emailApostador);
        var apostasRealizadas = apostas.stream()
                .map(Aposta::getNumeroAposta)
                .collect(Collectors.toSet());
        var numeroAleatorio = gerarNumeroAleatorio();
        while (apostasRealizadas.contains(numeroAleatorio)) {
            numeroAleatorio = gerarNumeroAleatorio();
        }
        return numeroAleatorio;
    }

    private Integer gerarNumeroAleatorio() {
        Random random = new Random();
        return random.ints(MIN, MAX)
                .findFirst()
                .getAsInt();
    }
}
