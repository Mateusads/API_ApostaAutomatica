package com.medeiros.aposta.services;

import com.medeiros.aposta.repositories.ApostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RemovedorAposta {

    private final ApostaRepository apostaRepository;

    public void removerAposta(String comprovante){
        var aposta = apostaRepository.findByComprovante(comprovante);
        apostaRepository.delete(aposta);
    }

}
