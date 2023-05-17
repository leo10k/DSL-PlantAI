package br.com.dnl.agrogpt.api.controllers;

import br.com.dnl.agrogpt.api.repository.EmpreendedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empreendedores")
public class EmpreendedorController {

    Logger loger = LoggerFactory.getLogger(getClass());

    @Autowired
    EmpreendedorRepository empreendedorRepository;
}
