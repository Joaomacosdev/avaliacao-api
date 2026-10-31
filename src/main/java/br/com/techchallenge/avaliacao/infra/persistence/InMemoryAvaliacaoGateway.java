package br.com.techchallenge.avaliacao.infra.persistence;

import br.com.techchallenge.avaliacao.domain.avaliacao.entiy.Avaliacao;
import br.com.techchallenge.avaliacao.domain.avaliacao.gateways.AvaliacaoGateway;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class InMemoryAvaliacaoGateway implements AvaliacaoGateway {

    private final List<Avaliacao> avaliacoes = new ArrayList<>();


    @Override
    public Avaliacao save(Avaliacao avaliacao) {

        avaliacoes.add(avaliacao);
        return avaliacao;
    }

    @Override
    public List<Avaliacao> findAll() {
        return List.copyOf(avaliacoes);
    }

    @Override
    public boolean existsById(UUID id) {
        return false;
    }

    @Override
    public void deleteById(UUID id) {
        avaliacoes.removeIf(avaliacao -> avaliacao.getId().equals(id));

    }
}
