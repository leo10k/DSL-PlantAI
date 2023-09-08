package br.com.dsl.agrogpt.api.config;

import br.com.dsl.agrogpt.api.models.*;
import br.com.dsl.agrogpt.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
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
        //elefoneRepository.saveAll(List.of(tel1, tel2, tel3, tel4, tel5));


        Parceiro par1 = new Parceiro(null, "Parceiro 1", "descricao", "email parceiro", "parceiro1.com.br", null);
        Parceiro par2 = new Parceiro(null, "Parceiro 2", "descricao", "email parceiro", "parceiro2.com.br", null);
        parceiroRepository.saveAll(List.of(par1, par2));

        Avaliacao ava1 = new Avaliacao(null, LocalDate.of(2021, 1, 17), "img1.png", "Concluido", "Solucionado", null);
        Avaliacao ava2 = new Avaliacao(null, LocalDate.of(2020, 3, 24), "img2.png", "Concluido", "Solucionado", null);
        Avaliacao ava3 = new Avaliacao(null, LocalDate.of(2022, 5, 9), "img3.png", "Pendente", "Não solucionado", null);
        Avaliacao ava4 = new Avaliacao(null, LocalDate.of(2023, 7, 1), "img4.png", "Concluido", "Solucionado", null);
        Avaliacao ava5 = new Avaliacao(null, LocalDate.of(2021, 9, 10), "img5.png", "Pendente", "Não solucionado", null);
        avaliacaoRepository.saveAll(List.of(ava1, ava2, ava3, ava4, ava5));

        Problema prob1 = new Problema(null, "Problema no solo", "O solo esta com falta de agua.", null,ava1);
        Problema prob2 = new Problema(null, "Problema na planta", "A planta esta com falta de sais.", null, ava1);
        Problema prob3 = new Problema(null, "Problema na violeta", "A violeta esta com falta de minerios.", null, ava1);
        Problema prob4 = new Problema(null, "Problema no planta", "A planta vai sarar.", null, ava1);
        Problema prob5 = new Problema(null, "Problema no solo argiloso", "O solo vai beber agua.", null, ava1);
        problemaRepository.saveAll(List.of(prob1, prob2, prob3, prob4, prob5));

        Endereco end1 = new Endereco(null, 123,"Rua das Flores", "Centro", "SP", "Brasil", 15161516, "casa da esquina");
        Endereco end2 = new Endereco(null, 86,"Rua Purificada", "Centro", "BA", "Brasil", 16146565, "ali 123");
        Endereco end3 = new Endereco(null, 76,"AV. das pombas", "Osasco", "SP", "Brasil", 96959454, "Ao lado do 258");
        Endereco end4 = new Endereco(null, 222,"Rua das Orquideas", "Conceicao", "MG", "Brasil", 15615165, "farmacia da esquina");
        Endereco end5 = new Endereco(null, 90,"Rua das Violetas", "Vila Sonia", "TO", "Brasil", 12345678, "");
        //enderecoRepository.saveAll(List.of(end1, end2, end3, end4, end5));


        //Empreendedor empree1 = new Empreendedor(1L, "Claudio", "claudio@gmail.com", 11111111111111L, LocalDate.of(1978, 4, 20), LocalDate.of(2020, 7, 13), emp1, prob1, gen1, tel1, prop1);
        //Empreendedor empree2 = new Empreendedor(2L, "Joao", "joao@gmail.com", 22222222222222L, LocalDate.of(1965, 2, 14), LocalDate.of(2021, 2, 24), emp2, prob2, gen2, tel1, prop2);
        //Empreendedor empree3 = new Empreendedor(3L, "Amelia", "amelia@gmail.com", 33333333333333L, LocalDate.of(1984, 7, 3), LocalDate.of(2022, 10, 22), emp3, prob3, gen2, tel3, prop3);
        //Empreendedor empree4 = new Empreendedor(4L, "Jose", "jose@gmail.com", 44444444444444L, LocalDate.of(1985, 11, 15), LocalDate.of(2023, 5, 19), emp4, prob4, gen1, tel4, prop4);
        //Empreendedor empree5 = new Empreendedor(5L, "Pedro", "pedro@gmail.com", 55555555555555L, LocalDate.of(1987, 7, 11), LocalDate.of(2020, 6, 29), emp5, prob5, gen1, tel5, prop5);
        //empreendedorRepository.saveAll(List.of(empree1, empree2, empree3, empree4, empree5));

        clienteRepository.saveAll(List.of(
            Cliente.builder().name("Claudio").email("claudio@gmail.com").cnpj(11111111111111L).dataNascimento(LocalDate.of(1978, 4, 20)).dataCadastro(LocalDate.of(2020, 7, 13)).build(),
            Cliente.builder().name("Joao").email("joao@gmail.com").cnpj(22222222222222L).dataNascimento(LocalDate.of(1965, 2, 14)).dataCadastro(LocalDate.of(2021, 2, 24)).build(),
            Cliente.builder().name("Amelia").email("amelia@gmail.com").cnpj(33333333333333L).dataNascimento(LocalDate.of(1984, 7, 3)).dataCadastro(LocalDate.of(2022, 10, 22)).build(),
            Cliente.builder().name("Jose").email("jose@gmail.com").cnpj(44444444444444L).dataNascimento(LocalDate.of(1985, 11, 15)).dataCadastro(LocalDate.of(2023, 5, 19)).build(),
            Cliente.builder().name("Pedro").email("pedro@gmail.com").cnpj(55555555555555L).dataNascimento(LocalDate.of(1987, 7, 11)).dataCadastro(LocalDate.of(2020, 6, 29)).build()
        ));

    }
}
