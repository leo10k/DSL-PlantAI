package br.com.dnl.agrogpt.api.controllers;

import br.com.dnl.agrogpt.api.exception.RestNotFoundException;
import br.com.dnl.agrogpt.api.models.ProducaoCultivo;
import br.com.dnl.agrogpt.api.repository.ProducaoCultivoRepository;
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
@RequestMapping("/api/producoesCultivos")
public class ProducaoCultivoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProducaoCultivoRepository producaoCultivoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> listAll(@RequestParam(required = false) String nome, @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
        Page<ProducaoCultivo> producaoCultivos = (nome == null)?
                producaoCultivoRepository.findAll(pageable):
                producaoCultivoRepository.findByNomeContaining(nome, pageable);

        return assembler.toModel(producaoCultivos.map(ProducaoCultivo::toEntityModel));
    }

    @GetMapping("{id}")
    public EntityModel<ProducaoCultivo> getById(@PathVariable Long id) {
        logger.info("Buscando producao de cultivo com id: " + id );
        return getProducaoCultivo(id).toEntityModel();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid ProducaoCultivo producaoCultivo) {
        logger.info("Cadastrando a producao de cultivo!: " + producaoCultivo);
        producaoCultivoRepository.save(producaoCultivo);
        return ResponseEntity
                .created(producaoCultivo.toEntityModel()
                        .getRequiredLink("self")
                        .toUri())
                .body(producaoCultivo.toEntityModel());
    }

    @PutMapping("{id}")
    public EntityModel<ProducaoCultivo> update(@PathVariable Long id, @RequestBody @Valid ProducaoCultivo producaoCultivo){
        logger.info("Alterando producao de cultivo com id: " + id);
        getProducaoCultivo(id);
        producaoCultivo.setId(id);
        producaoCultivoRepository.save(producaoCultivo);
        return producaoCultivo.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ProducaoCultivo> delete(@PathVariable Long id) {
        logger.info("Apagando producao de cultivo com id: " + id);
        producaoCultivoRepository.delete(getProducaoCultivo(id));
        return ResponseEntity.noContent().build();
    }

    private ProducaoCultivo getProducaoCultivo(Long id) {
        return producaoCultivoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Producao de cultivo não encontrado!"));
    }
}
