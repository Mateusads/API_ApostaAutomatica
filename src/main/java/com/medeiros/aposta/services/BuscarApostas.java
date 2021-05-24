package com.medeiros.aposta.services;

import com.medeiros.aposta.entities.Aposta;
import com.medeiros.aposta.repositories.ApostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BuscarApostas {

    private final ApostaRepository apostaRepository;

    public List<Aposta> buscarTodasApostas(){
        return apostaRepository.findAll();
    }

    public Aposta buscarPorComprovante(String comprovante){
        return apostaRepository.findByComprovante(comprovante.toString());
    }
}
