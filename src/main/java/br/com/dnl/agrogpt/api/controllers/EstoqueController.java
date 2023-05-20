package br.com.dnl.agrogpt.api.controllers;

import br.com.dnl.agrogpt.api.exception.RestNotFoundException;
import br.com.dnl.agrogpt.api.models.Estoque;
import br.com.dnl.agrogpt.api.repository.EstoqueRepository;
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
@RequestMapping("/api/estoques")
public class EstoqueController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> listAll(@RequestParam(required = false) Integer qtdProduzida, @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
        Page<Estoque> estoques = (qtdProduzida == null)?
                estoqueRepository.findAll(pageable):
                estoqueRepository.findByQtdProduzidaContaining(qtdProduzida, pageable);

        return assembler.toModel(estoques.map(Estoque::toEntityModel));
    }

    @GetMapping("{id}")
    public EntityModel<Estoque> getById(@PathVariable Long id) {
        logger.info("Buscando estoque com id: " + id );
        return getEstoque(id).toEntityModel();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Estoque estoque) {
        logger.info("Cadastrando a estoque!: " + estoque);
        estoqueRepository.save(estoque);
        return ResponseEntity
                .created(estoque.toEntityModel()
                        .getRequiredLink("self")
                        .toUri())
                .body(estoque.toEntityModel());
    }

    @PutMapping("{id}")
    public EntityModel<Estoque> update(@PathVariable Long id, @RequestBody @Valid Estoque estoque){
        logger.info("Alterando estoque com id: " + id);
        getEstoque(id);
        estoque.setId(id);
        estoqueRepository.save(estoque);
        return estoque.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Estoque> delete(@PathVariable Long id) {
        logger.info("Apagando estoque com id: " + id);
        estoqueRepository.delete(getEstoque(id));
        return ResponseEntity.noContent().build();
    }

    private Estoque getEstoque(Long id) {
        return estoqueRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Estoque não encontrado!"));
    }

}
