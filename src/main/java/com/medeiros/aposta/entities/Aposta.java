package com.medeiros.aposta.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aposta")
public class Aposta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comprovante")
    private String comprovante;

    @Column(name = "numero")
    private Integer numeroAposta;

    @Column(name = "email")
    private String emailApostador;

    @Column(name = "data_criacao")
    private ZonedDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private ZonedDateTime dataAtualizacao;

}
