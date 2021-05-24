package com.medeiros.aposta.controller.v1;

import com.medeiros.aposta.controller.v1.dto.ApostaResquestDTO;
import com.medeiros.aposta.controller.v1.mapper.ApostaMapper;
import com.medeiros.aposta.services.BuscarApostas;
import com.medeiros.aposta.services.GeradorApostaService;
import com.medeiros.aposta.services.RemovedorAposta;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class ApostaController {

    private final GeradorApostaService geradorApostaService;
    private final BuscarApostas buscarApostas;
    private final RemovedorAposta removedorAposta;

    @PostMapping("/apostas")
    public ApostaResponseDTO criarAposta(@RequestBody ApostaResquestDTO apostaDTO) {
        var entity = ApostaMapper.toEntity(apostaDTO);
        var resultado = geradorApostaService.gerar(entity);
        return ApostaMapper.toDTO(resultado);
    }

    @GetMapping("/apostas")
    public List<ApostaResponseDTO> retornarApostas() {
        var apostas = buscarApostas.buscarTodasApostas();
        return ApostaMapper.toDTOs(apostas);
    }

    @DeleteMapping("/apostas/{comprovante}")
    public void deletar(@RequestParam String comprovante) {
        removedorAposta.removerAposta(comprovante);
    }

    @GetMapping("/apostas/{comprovante}")
    public ApostaResponseDTO buscaPorComprovante(@RequestParam String comprovante) {
        var aposta = buscarApostas.buscarPorComprovante(comprovante);
        return ApostaMapper.toDTO(aposta);
    }

}
