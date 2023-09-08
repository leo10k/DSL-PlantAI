package br.com.dsl.agrogpt.api.controllers;

import br.com.dsl.agrogpt.api.exception.RestNotFoundException;
import br.com.dsl.agrogpt.api.models.Parceiro;
import br.com.dsl.agrogpt.api.repository.ParceiroRepository;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequestMapping("/api/parceiros")
public class ParceiroController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ParceiroRepository parceiroRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;


    @GetMapping
    public PagedModel<EntityModel<Object>> listAll(@RequestParam(required = false) String nome, @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
        Page<Parceiro> parceiros = (nome == null)?
                parceiroRepository.findAll(pageable):
                parceiroRepository.findByNameContaining(nome, pageable);

        return assembler.toModel(parceiros.map(Parceiro::toEntityModel));
    }

    @GetMapping("{id}")
    public EntityModel<Parceiro> getById(@PathVariable Long id) {
        logger.info("Buscando parceiro com id: " + id );
        return getParceiro(id).toEntityModel();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Parceiro parceiro) {
        logger.info("Cadastrando o parceiro!: " + parceiro);
        parceiroRepository.save(parceiro);
        return ResponseEntity
                .created(parceiro.toEntityModel()
                        .getRequiredLink("self")
                        .toUri())
                .body(parceiro.toEntityModel());
    }

    @PutMapping("{id}")
    public EntityModel<Parceiro> update(@PathVariable Long id, @RequestBody @Valid Parceiro parceiro){
        logger.info("Alterando cliente com id: " + id);
        getParceiro(id);
        parceiro.setId(id);
        parceiroRepository.save(parceiro);
        return parceiro.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Parceiro> delete(@PathVariable Long id) {
        logger.info("Apagando parceiro com id: " + id);
        parceiroRepository.delete(getParceiro(id));
        return ResponseEntity.noContent().build();
    }

    private Parceiro getParceiro(Long id) {
        return parceiroRepository.findById(id).orElseThrow(() -> new RestNotFoundException("parceiro não encontrado!"));
    }

}
