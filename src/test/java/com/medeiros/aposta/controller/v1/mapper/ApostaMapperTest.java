package com.medeiros.aposta.controller.v1.mapper;

import com.medeiros.aposta.controller.v1.dto.ApostaResquestDTO;
import com.medeiros.aposta.entities.Aposta;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.UUID;

class ApostaMapperTest {

    @Test
    void quandoTemUmaEntidadeRetornoDTO() {
        var data = ZonedDateTime.now();
        var aposta = Aposta.builder()
                .comprovante(UUID.randomUUID().toString())
                .emailApostador("mateus@test.com")
                .numeroAposta(21)
                .dataAtualizacao(data)
                .dataAtualizacao(data)
                .build();
        var resultado = ApostaMapper.toDTO(aposta);
        Assertions.assertThat(resultado.getEmail()).isEqualTo("mateus@test.com");
        Assertions.assertThat(resultado.getNumero()).isEqualTo(21L);
    }

    @Test
    void quantoTenhoUmDtoRetornoEntidade() {
        var apostaDTO = new ApostaResquestDTO();
        apostaDTO.setEmail("teste@test.com");
        var aposta = ApostaMapper.toEntity(apostaDTO);

        Assertions.assertThat(aposta.getEmailApostador()).isEqualTo("teste@test.com");
        //Assertions.assertThat(aposta.getNumeroAposta()).isEqualTo(555L);
    }

}