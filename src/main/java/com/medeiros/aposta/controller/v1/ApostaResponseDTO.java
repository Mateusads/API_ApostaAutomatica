package com.medeiros.aposta.controller.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApostaResponseDTO {

    private String comprovante;

    private String email;

    private Integer numero;

    private ZonedDateTime dataCriacao;

    private ZonedDateTime dataAtualizacao;

}
