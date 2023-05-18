package br.com.dnl.agrogpt.api.controllers;

import br.com.dnl.agrogpt.api.exception.RestNotFoundException;
import br.com.dnl.agrogpt.api.models.Empreendedor;
import br.com.dnl.agrogpt.api.repository.EmpreendedorRepository;
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
@RequestMapping("/api/empreendedores")
public class EmpreendedorController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EmpreendedorRepository empreendedorRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> listAll(@RequestParam(required = false) String nome, @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
        Page<Empreendedor> empreendedores = (nome == null)?
                empreendedorRepository.findAll(pageable):
                empreendedorRepository.findByNameContaining(nome, pageable);

        return assembler.toModel(empreendedores.map(Empreendedor::toEntityModel));
    }

    @GetMapping("{id}")
    public EntityModel<Empreendedor> getById(@PathVariable Long id) {
        logger.info("Buscando empreendedor com id: " + id );
        return getEmpreendedor(id).toEntityModel();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Empreendedor empreendedor) {
        logger.info("Cadastrando a empreendedor!: " + empreendedor);
        empreendedorRepository.save(empreendedor);
        return ResponseEntity
                .created(empreendedor.toEntityModel()
                .getRequiredLink("self")
                .toUri())
                .body(empreendedor.toEntityModel());
    }

    @PutMapping("{id}")
    public EntityModel<Empreendedor> update(@PathVariable Long id, @RequestBody @Valid Empreendedor empreendedor){
        logger.info("Alterando empreendedor com id: " + id);
        getEmpreendedor(id);
        empreendedor.setId(id);
        empreendedorRepository.save(empreendedor);
        return empreendedor.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Empreendedor> delete(@PathVariable Long id) {
        logger.info("Apagando empreendedor com id: " + id);
        empreendedorRepository.delete(getEmpreendedor(id));
        return ResponseEntity.noContent().build();
    }

    private Empreendedor getEmpreendedor(Long id) {
        return empreendedorRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Empreendedor não encontrado!"));
    }

}
