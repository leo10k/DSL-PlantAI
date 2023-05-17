package br.com.dnl.agrogpt.api.config;

import br.com.dnl.agrogpt.api.models.Empresa;
import br.com.dnl.agrogpt.api.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public void run(String... args) throws Exception {

        Empresa emp1 = new Empresa(1L, "AgroNegocio", "Agro Negocio", 123456789012L, "agronegocio@gmail.com", "Empresa voltada para agro negocio", "Ativo");
        empresaRepository.saveAll(List.of(emp1));

    }
}
