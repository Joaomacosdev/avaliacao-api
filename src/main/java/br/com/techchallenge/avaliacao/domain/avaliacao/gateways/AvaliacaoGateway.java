package br.com.techchallenge.avaliacao.domain.avaliacao.gateways;

import br.com.techchallenge.avaliacao.domain.avaliacao.entiy.Avaliacao;

import java.util.List;
import java.util.UUID;

public interface AvaliacaoGateway {
    Avaliacao save(Avaliacao avaliacao);
    List<Avaliacao> findAll();
    void deleteById(UUID id);
}
