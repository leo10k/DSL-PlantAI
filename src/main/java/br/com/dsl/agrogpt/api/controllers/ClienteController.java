package br.com.dsl.agrogpt.api.controllers;

import br.com.dsl.agrogpt.api.exception.RestNotFoundException;
import br.com.dsl.agrogpt.api.models.Cliente;
import br.com.dsl.agrogpt.api.models.Credencial;
import br.com.dsl.agrogpt.api.repository.ClienteRepository;
import br.com.dsl.agrogpt.api.service.TokenService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequestMapping("/api/clientes")
public class ClienteController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    @Autowired
    AuthenticationManager manager;

    @GetMapping
    public PagedModel<EntityModel<Object>> listAll(@RequestParam(required = false) String nome, @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
        Page<Cliente> clientes = (nome == null)?
                clienteRepository.findAll(pageable):
                clienteRepository.findByNameContaining(nome, pageable);

        return assembler.toModel(clientes.map(Cliente::toEntityModel));
    }

    @PostMapping("/register")
    public ResponseEntity<Cliente> registrer(@RequestBody @Valid Cliente cliente){
        cliente.setPassword(encoder.encode(cliente.getPassword()));
        clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);

    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial){
        manager.authenticate(credencial.toAuthentication());
        var token = tokenService.generateToken(credencial);
        return ResponseEntity.ok(token);
    }

    @GetMapping("{id}")
    public EntityModel<Cliente> getById(@PathVariable Long id) {
        logger.info("Buscando cliente com id: " + id );
        return getCliente(id).toEntityModel();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Cliente cliente) {
        logger.info("Cadastrando o cliente!: " + cliente);
        clienteRepository.save(cliente);
        return ResponseEntity
                .created(cliente.toEntityModel()
                .getRequiredLink("self")
                .toUri())
                .body(cliente.toEntityModel());
    }

    @PutMapping("{id}")
    public EntityModel<Cliente> update(@PathVariable Long id, @RequestBody @Valid Cliente cliente){
        logger.info("Alterando cliente com id: " + id);
        getCliente(id);
        cliente.setId(id);
        clienteRepository.save(cliente);
        return cliente.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id) {
        logger.info("Apagando cliente com id: " + id);
        clienteRepository.delete(getCliente(id));
        return ResponseEntity.noContent().build();
    }

    private Cliente getCliente(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RestNotFoundException("cliente não encontrado!"));
    }

}
