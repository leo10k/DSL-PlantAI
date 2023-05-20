package br.com.dnl.agrogpt.api.controllers;

import br.com.dnl.agrogpt.api.exception.RestNotFoundException;
import br.com.dnl.agrogpt.api.models.Propriedade;
import br.com.dnl.agrogpt.api.repository.PropriedadeRepository;
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

@RestController
@RequestMapping("/api/propriedades")
public class PropriedadeController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    PropriedadeRepository propriedadeRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> listAll(@RequestParam(required = false) String nome, @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
        Page<Propriedade> propriedades = (nome == null)?
                propriedadeRepository.findAll(pageable):
                propriedadeRepository.findByNomeContaining(nome, pageable);

        return assembler.toModel(propriedades.map(Propriedade::toEntityModel));
    }

    @GetMapping("{id}")
    public EntityModel<Propriedade> getById(@PathVariable Long id) {
        logger.info("Buscando propriedade com id: " + id );
        return getPropriedade(id).toEntityModel();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Propriedade propriedades) {
        logger.info("Cadastrando a propriedade!: " + propriedades);
        propriedadeRepository.save(propriedades);
        return ResponseEntity
                .created(propriedades.toEntityModel()
                .getRequiredLink("self")
                .toUri())
                .body(propriedades.toEntityModel());
    }

    @PutMapping("{id}")
    public EntityModel<Propriedade> update(@PathVariable Long id, @RequestBody @Valid Propriedade propriedade){
        logger.info("Alterando propriedade com id: " + id);
        getPropriedade(id);
        propriedade.setId(id);
        propriedadeRepository.save(propriedade);
        return propriedade.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Propriedade> delete(@PathVariable Long id) {
        logger.info("Apagando propriedade com id: " + id);
        propriedadeRepository.delete(getPropriedade(id));
        return ResponseEntity.noContent().build();
    }

    private Propriedade getPropriedade(Long id) {
        return propriedadeRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Propriedade não encontrada!"));
    }
}
