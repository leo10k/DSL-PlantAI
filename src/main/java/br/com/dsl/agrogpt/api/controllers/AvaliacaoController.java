package br.com.dsl.agrogpt.api.controllers;

import br.com.dsl.agrogpt.api.exception.RestNotFoundException;
import br.com.dsl.agrogpt.api.models.Avaliacao;
import br.com.dsl.agrogpt.api.repository.AvaliacaoRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

//    @GetMapping
//    public PagedModel<EntityModel<Object>> listAll(@RequestParam(required = false) String status, @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
//        Page<Avaliacao> avaliacoes = (status == null)?
//                avaliacaoRepository.findAll(pageable):
//                avaliacaoRepository.findByStatusContaining(status, pageable);
//
//        return assembler.toModel(avaliacoes.map(Avaliacao::toEntityModel));
//    }

    @GetMapping
    public List<Avaliacao> listAll() {
        logger.info("consultando avaliação");
        return avaliacaoRepository.findAll();
    }

    @GetMapping("{id}")
    public EntityModel<Avaliacao> getById(@PathVariable Long id) {
        logger.info("Buscando avaliacao com id: " + id );
        return getAvaliacao(id).toEntityModel();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Avaliacao avaliacao) {
        logger.info("Cadastrando a avaliacao!: " + avaliacao);
        avaliacaoRepository.save(avaliacao);
        return ResponseEntity
                .created(avaliacao.toEntityModel()
                .getRequiredLink("self")
                .toUri())
                .body(avaliacao.toEntityModel());
    }

    @PutMapping("{id}")
    public EntityModel<Avaliacao> update(@PathVariable Long id, @RequestBody @Valid Avaliacao avaliacao){
        logger.info("Alterando avaliacao com id: " + id);
        getAvaliacao(id);
        avaliacao.setId(id);
        avaliacaoRepository.save(avaliacao);
        return avaliacao.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Avaliacao> delete(@PathVariable Long id) {
        logger.info("Apagando avaliacao com id: " + id);
        avaliacaoRepository.delete(getAvaliacao(id));
        return ResponseEntity.noContent().build();
    }

    private Avaliacao getAvaliacao(Long id) {
        return avaliacaoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Avaliacao não encontrado!"));
    }
}
