package com.medeiros.aposta.controller.v1.mapper;

import com.medeiros.aposta.controller.v1.ApostaResponseDTO;
import com.medeiros.aposta.controller.v1.dto.ApostaResquestDTO;
import com.medeiros.aposta.entities.Aposta;

import java.util.List;
import java.util.stream.Collectors;

public class ApostaMapper {

    public static Aposta toEntity(ApostaResquestDTO apostaDTO) {
        return Aposta.builder()
                .emailApostador(apostaDTO.getEmail())
                .build();
    }

    public static ApostaResponseDTO toDTO(Aposta resultado) {
        return ApostaResponseDTO.builder()
                .email(resultado.getEmailApostador())
                .comprovante(resultado.getComprovante())
                .numero(resultado.getNumeroAposta())
                .dataCriacao(resultado.getDataCriacao())
                .dataAtualizacao(resultado.getDataAtualizacao())
                .build();
    }

    public static List<ApostaResponseDTO> toDTOs(List<Aposta> apostas) {
        return apostas.stream()
                .map(ApostaMapper::toDTO)
                .collect(Collectors.toList());

    }
}
