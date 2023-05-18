package br.com.dnl.agrogpt.api.controllers;

import br.com.dnl.agrogpt.api.exception.RestNotFoundException;
import br.com.dnl.agrogpt.api.models.Empresa;
import br.com.dnl.agrogpt.api.repository.EmpresaRepository;
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
@RequestMapping("/api/empresas")
public class EmpresaController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> listAll(@RequestParam(required = false) String nome, @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
        Page<Empresa> empresas = (nome == null)?
                empresaRepository.findAll(pageable):
                empresaRepository.findByNameContaining(nome, pageable);

        return assembler.toModel(empresas.map(Empresa::toEntityModel));
    }

    @GetMapping("{id}")
    public EntityModel<Empresa> getById(@PathVariable Long id) {
        logger.info("Buscando empresa com id: " + id );
        return getEmpresa(id).toEntityModel();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Empresa empresa) {
        logger.info("Cadastrando a empresa!: " + empresa);
        empresaRepository.save(empresa);
        return ResponseEntity
                .created(empresa.toEntityModel()
                .getRequiredLink("self")
                .toUri())
                .body(empresa.toEntityModel());
    }

    @PutMapping("{id}")
    public EntityModel<Empresa> update(@PathVariable Long id, @RequestBody @Valid Empresa empresa){
        logger.info("Alterando empresa com id: " + id);
        getEmpresa(id);
        empresa.setId(id);
        empresaRepository.save(empresa);
        return empresa.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Empresa> delete(@PathVariable Long id) {
        logger.info("Apagando empresa com id: " + id);
        empresaRepository.delete(getEmpresa(id));
        return ResponseEntity.noContent().build();
    }

    private Empresa getEmpresa(Long id) {
        return empresaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Empresa não encontrada!"));
    }

}
