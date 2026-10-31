package br.com.techchallenge.avaliacao.presentation.avaliacao.conroller;

import br.com.techchallenge.avaliacao.application.avaliacao.usecase.CreateAvaliacaoUseCase;
import br.com.techchallenge.avaliacao.application.avaliacao.usecase.DeleteByIdAvaliacaoUseCase;
import br.com.techchallenge.avaliacao.application.avaliacao.usecase.ListAvaliacaoUseCase;
import br.com.techchallenge.avaliacao.presentation.avaliacao.mapper.AvaliacaoPresentationMapper;
import br.com.techchallenge.avaliacao.presentation.avaliacao.request.AvaliacaoRequest;
import br.com.techchallenge.avaliacao.presentation.avaliacao.response.AvaliacaoResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/avaliacao/v1")
public class AvaliacaoController {

    private final CreateAvaliacaoUseCase createAvaliacaoUseCase;
    private final DeleteByIdAvaliacaoUseCase deleteByIdAvaliacaoUseCase;
    private final ListAvaliacaoUseCase listAvaliacaoUseCase;

    public AvaliacaoController(CreateAvaliacaoUseCase createAvaliacaoUseCase, DeleteByIdAvaliacaoUseCase deleteByIdAvaliacaoUseCase, ListAvaliacaoUseCase listAvaliacaoUseCase) {
        this.createAvaliacaoUseCase = createAvaliacaoUseCase;
        this.deleteByIdAvaliacaoUseCase = deleteByIdAvaliacaoUseCase;
        this.listAvaliacaoUseCase = listAvaliacaoUseCase;
    }


    @PostMapping
    public ResponseEntity<AvaliacaoResponse>  createAvaliacao(@Valid @RequestBody AvaliacaoRequest avaliacaoRequest) {
        var input = AvaliacaoPresentationMapper.toInput(avaliacaoRequest);
        var output =  createAvaliacaoUseCase.execute(input);
        var response = AvaliacaoPresentationMapper.toResponse(output);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoResponse>> listAvaliacao() {
        var response = listAvaliacaoUseCase.execute().stream()
                .map(AvaliacaoPresentationMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AvaliacaoResponse> deleteAvaliacao(@PathVariable UUID id) {
        deleteByIdAvaliacaoUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}
