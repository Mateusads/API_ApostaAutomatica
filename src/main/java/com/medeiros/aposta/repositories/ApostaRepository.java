package com.medeiros.aposta.repositories;

import com.medeiros.aposta.entities.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Long> {

    List<Aposta> findByEmailApostador(String emailApostador);

    Aposta findByComprovante(String comprovante);
}
