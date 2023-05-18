package br.com.dnl.agrogpt.api.controllers;

import br.com.dnl.agrogpt.api.exception.RestNotFoundException;
import br.com.dnl.agrogpt.api.models.Pagamento;
import br.com.dnl.agrogpt.api.repository.PagamentoRepository;
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

import java.util.Date;


@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> listAll(@RequestParam(required = false) Date data, @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
        Page<Pagamento> pagamentos = (data == null)?
                pagamentoRepository.findAll(pageable):
                pagamentoRepository.findByDataContaining(data, pageable);

        return assembler.toModel(pagamentos.map(Pagamento::toEntityModel));
    }

    @GetMapping("{id}")
    public EntityModel<Pagamento> getById(@PathVariable Long id) {
        logger.info("Buscando pagamento com id: " + id );
        return getPagamento(id).toEntityModel();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Pagamento pagamento) {
        logger.info("Cadastrando a pagamento!: " + pagamento);
        pagamentoRepository.save(pagamento);
        return ResponseEntity
                .created(pagamento.toEntityModel()
                .getRequiredLink("self")
                .toUri())
                .body(pagamento.toEntityModel());
    }

    @PutMapping("{id}")
    public EntityModel<Pagamento> update(@PathVariable Long id, @RequestBody @Valid Pagamento pagamento){
        logger.info("Alterando pagamento com id: " + id);
        getPagamento(id);
        pagamento.setId(id);
        pagamentoRepository.save(pagamento);
        return pagamento.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Pagamento> delete(@PathVariable Long id) {
        logger.info("Apagando pagamento com id: " + id);
        pagamentoRepository.delete(getPagamento(id));
        return ResponseEntity.noContent().build();
    }

    private Pagamento getPagamento(Long id) {
        return pagamentoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Pagamento não encontrado!"));
    }
}
