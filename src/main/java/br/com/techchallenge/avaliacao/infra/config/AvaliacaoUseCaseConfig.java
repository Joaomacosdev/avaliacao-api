package br.com.techchallenge.avaliacao.infra.config;

import br.com.techchallenge.avaliacao.application.avaliacao.usecase.CreateAvaliacaoUseCase;
import br.com.techchallenge.avaliacao.application.avaliacao.usecase.DeleteByIdAvaliacaoUseCase;
import br.com.techchallenge.avaliacao.application.avaliacao.usecase.ListAvaliacaoUseCase;
import br.com.techchallenge.avaliacao.domain.avaliacao.gateways.AvaliacaoGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvaliacaoUseCaseConfig {


    @Bean
    public CreateAvaliacaoUseCase createAvaliacaoUseCase(AvaliacaoGateway gateway) {
        return new CreateAvaliacaoUseCase(gateway);
    }

    @Bean
    public ListAvaliacaoUseCase listAvaliacao(AvaliacaoGateway gateway) {
        return new ListAvaliacaoUseCase(gateway);
    }

    @Bean
    public DeleteByIdAvaliacaoUseCase  deleteByIdAvaliacaoUseCase(AvaliacaoGateway gateway) {
        return new DeleteByIdAvaliacaoUseCase(gateway);
    }

}
