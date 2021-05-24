package com.medeiros.aposta.services;

import com.medeiros.aposta.entities.Aposta;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;

@AllArgsConstructor
class BuscarApostasTest {

    @Autowired
    BuscarApostas buscarAposta;

    @Test
    void buscarAposta() {

        var data = ZonedDateTime.now();
        var aposta = Aposta.builder()
                .comprovante("123456")
                .emailApostador("mateus@test.com")
                .numeroAposta(21)
                .dataAtualizacao(data)
                .dataAtualizacao(data)
                .build();
        var apostaBuscada = buscarAposta.buscarPorComprovante(aposta.getComprovante());
        Assertions.assertThat(apostaBuscada.getEmailApostador()).isEqualTo("mateus@test.com");
        Assertions.assertThat(apostaBuscada.getNumeroAposta()).isEqualTo(21);
        Assertions.assertThat(apostaBuscada.getDataCriacao()).isEqualTo(data);
        Assertions.assertThat(apostaBuscada.getDataAtualizacao()).isEqualTo(data);
    }

}