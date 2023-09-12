package br.com.dsl.agrogpt.api.config;

import br.com.dsl.agrogpt.api.models.Avaliacao;
import br.com.dsl.agrogpt.api.models.Parceiro;
import br.com.dsl.agrogpt.api.models.Problema;
import br.com.dsl.agrogpt.api.models.Telefone;
import br.com.dsl.agrogpt.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;


@Configuration
@Profile("dev")
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    TelefoneRepository telefoneRepository;

    @Autowired
    ParceiroRepository parceiroRepository;

    @Autowired
    ProblemaRepository problemaRepository;

    @Autowired
    AvaliacaoRepository avaliacaoRepository;


    @Override
    public void run(String... args) throws Exception {

        Telefone tel1 = new Telefone(null, 55, 11, 911111111L, null);
        Telefone tel2 = new Telefone(null, 55, 13, 922222222L, null);
        Telefone tel3 = new Telefone(null, 55, 19, 933333333L, null);
        Telefone tel4 = new Telefone(null, 55, 23, 944444444L, null);
        Telefone tel5 = new Telefone(null, 55, 35, 955555555L, null);
        //telefoneRepository.saveAll(List.of(tel1, tel2, tel3, tel4, tel5));


        Parceiro par1 = new Parceiro(null, "Parceiro 1", "descricao", "parceiro1@gmail.com", "parceiro1.com.br", null);
        Parceiro par2 = new Parceiro(null, "Parceiro 2", "descricao", "parceiro2@gmail.com", "parceiro2.com.br", null);
        parceiroRepository.saveAll(List.of(par1, par2));

        Avaliacao ava1 = new Avaliacao(null, LocalDate.of(2021, 1, 17), "img1.png", "Concluido", "Solucionado", "95%", null);
        Avaliacao ava2 = new Avaliacao(null, LocalDate.of(2020, 3, 24), "img2.png", "Concluido", "Solucionado", "95%", null);
        Avaliacao ava3 = new Avaliacao(null, LocalDate.of(2022, 5, 9), "img3.png", "Pendente", "Não solucionado", "95%", null);
        Avaliacao ava4 = new Avaliacao(null, LocalDate.of(2023, 7, 1), "img4.png", "Concluido", "Solucionado", "95%", null);
        Avaliacao ava5 = new Avaliacao(null, LocalDate.of(2021, 9, 10), "img5.png", "Pendente", "Não solucionado", "95%", null);
        avaliacaoRepository.saveAll(List.of(ava1, ava2, ava3, ava4, ava5));

        Problema prob1 = new Problema(null, "Problema no solo", "O solo esta com falta de agua.", null,ava1);
        Problema prob2 = new Problema(null, "Problema na planta", "A planta esta com falta de sais.", null, ava1);
        Problema prob3 = new Problema(null, "Problema na violeta", "A violeta esta com falta de minerios.", null, ava1);
        Problema prob4 = new Problema(null, "Problema no planta", "A planta vai sarar.", null, ava1);
        Problema prob5 = new Problema(null, "Problema no solo argiloso", "O solo vai beber agua.", null, ava1);
        problemaRepository.saveAll(List.of(prob1, prob2, prob3, prob4, prob5));


//        clienteRepository.saveAll(List.of(
//            Cliente.builder().name("Claudio").genero("Masculino").email("claudio@gmail.com").cpf(11111111111L).cnpj(null).dataNascimento(LocalDate.of(1978, 4, 20)).dataCadastro(LocalDate.of(2020, 7, 13)).status('A').password("claudio123").problema(Collections.singletonList(prob1)).telefone(tel1).build(),
//            Cliente.builder().name("Joao").genero("Masculino").email("joao@gmail.com").cpf(null).cnpj(22222222222222L).dataNascimento(LocalDate.of(1965, 2, 14)).dataCadastro(LocalDate.of(2021, 2, 24)).status('F').password("joao123").problema(Collections.singletonList(prob2)).telefone(tel2).build()
//            //Cliente.builder().name("Amelia").email("amelia@gmail.com").cnpj(33333333333333L).dataNascimento(LocalDate.of(1984, 7, 3)).dataCadastro(LocalDate.of(2022, 10, 22)).build(),
//            //Cliente.builder().name("Jose").email("jose@gmail.com").cnpj(44444444444444L).dataNascimento(LocalDate.of(1985, 11, 15)).dataCadastro(LocalDate.of(2023, 5, 19)).build(),
//            //Cliente.builder().name("Pedro").email("pedro@gmail.com").cnpj(55555555555555L).dataNascimento(LocalDate.of(1987, 7, 11)).dataCadastro(LocalDate.of(2020, 6, 29)).build()
//        ));

    }
}
