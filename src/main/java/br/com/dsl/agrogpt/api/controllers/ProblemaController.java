package br.com.dsl.agrogpt.api.controllers;

import br.com.dsl.agrogpt.api.exception.RestNotFoundException;
import br.com.dsl.agrogpt.api.models.Avaliacao;
import br.com.dsl.agrogpt.api.models.Problema;
import br.com.dsl.agrogpt.api.repository.ProblemaRepository;
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
@RequestMapping("/api/problemas")
public class ProblemaController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProblemaRepository problemaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

//    @GetMapping
//    public PagedModel<EntityModel<Object>> listAll(@RequestParam(required = false) String nome, @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
//        Page<Problema> problemas = (nome == null)?
//                problemaRepository.findAll(pageable):
//                problemaRepository.findByNomeContaining(nome, pageable);
//
//        return assembler.toModel(problemas.map(Problema::toEntityModel));
//    }

    @GetMapping
    public List<Problema> listAll() {
        logger.info("consultando problemas");
        return problemaRepository.findAll();
    }

    @GetMapping("{id}")
    public EntityModel<Problema> getById(@PathVariable Long id) {
        logger.info("Buscando problema com id: " + id );
        return getProblema(id).toEntityModel();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Problema problema) {
        logger.info("Cadastrando a problema!: " + problema);
        problemaRepository.save(problema);
        return ResponseEntity
                .created(problema.toEntityModel()
                .getRequiredLink("self")
                .toUri())
                .body(problema.toEntityModel());
    }

    @PutMapping("{id}")
    public EntityModel<Problema> update(@PathVariable Long id, @RequestBody @Valid Problema problema){
        logger.info("Alterando problema com id: " + id);
        getProblema(id);
        problema.setId(id);
        problemaRepository.save(problema);
        return problema.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Problema> delete(@PathVariable Long id) {
        logger.info("Apagando problema com id: " + id);
        problemaRepository.delete(getProblema(id));
        return ResponseEntity.noContent().build();
    }

    private Problema getProblema(Long id) {
        return problemaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Problema não encontrado!"));
    }

}
