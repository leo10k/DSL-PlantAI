package br.com.dnl.agrogpt.api.config;

import br.com.dnl.agrogpt.api.models.*;
import br.com.dnl.agrogpt.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    EmpreendedorRepository empreendedorRepository;

    @Autowired
    GeneroRepository generoRepository;

    @Autowired
    TelefoneRepository telefoneRepository;

    @Autowired
    ProblemaRepository problemaRepository;

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    PropriedadeRepository propriedadeRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    ProducaoCultivoRepository producaoCultivoRepository;

    @Override
    public void run(String... args) throws Exception {



        Pagamento pag1 = new Pagamento(null, LocalDate.of(2023, 4, 10), 123.99);
        Pagamento pag2 = new Pagamento(null, LocalDate.of(2022, 12, 30), 234.99);
        Pagamento pag3 = new Pagamento(null, LocalDate.of(2023, 1, 2), 97.99);
        Pagamento pag4 = new Pagamento(null, LocalDate.of(2020, 7, 22), 72.99);
        Pagamento pag5 = new Pagamento(null, LocalDate.of(2021, 8, 17), 54.99);
        pagamentoRepository.saveAll(List.of(pag1, pag2, pag3, pag4, pag5));

        Empresa emp1 = new Empresa(null, "Monsanto", "Bayer Crop Science", 11111111111111L, "Monsanto@gmail.com", "Monsanto é uma empresa voltada para agro negocio", "Ativo", null, pag1);
        Empresa emp2 = new Empresa(null, "Cargill", "Cargill Agrícola", 22222222222222L, "Cargill@gmail.com", "Cargill é uma empresa voltada para agro negocio", "Ativo", null, pag2);
        Empresa emp3 = new Empresa(null, "Syngenta", "Syngenta Crop Protection", 33333333333333L, "Syngenta@gmail.com", "Syngenta é uma empresa voltada para agro negocio", "Ativo", null, pag3);
        Empresa emp4 = new Empresa(null, "John Deere", "John Deere Brasil", 44444444444444L, "JohnDeere@gmail.com", "John Deere é uma empresa voltada para agro negocio", "Ativo", null, pag4);
        Empresa emp5 = new Empresa(null, "JBS", "JBS Foods", 55555555555555L, "JBS@gmail.com", "JBS é uma empresa voltada para agro negocio", "Ativo", null, pag5);
        //empresaRepository.saveAll(List.of(emp1, emp2, emp3, emp4, emp5));

        Genero gen1 = new Genero(null, "Masculino", "Ele/Dele", null);
        Genero gen2 = new Genero(null, "Feminino", "Ela/Dela", null);
        //generoRepository.saveAll(List.of(gen1, gen2));

        Telefone tel1 = new Telefone(null, 55, 11, 911111111L, null);
        Telefone tel2 = new Telefone(null, 55, 13, 922222222L, null);
        Telefone tel3 = new Telefone(null, 55, 19, 933333333L, null);
        Telefone tel4 = new Telefone(null, 55, 23, 944444444L, null);
        Telefone tel5 = new Telefone(null, 55, 35, 955555555L, null);
        //elefoneRepository.saveAll(List.of(tel1, tel2, tel3, tel4, tel5));

        Avaliacao ava1 = new Avaliacao(null, LocalDate.of(2021, 1, 17), "img1.png", "Concluido", "Solucionado");
        Avaliacao ava2 = new Avaliacao(null, LocalDate.of(2020, 3, 24), "img2.png", "Concluido", "Solucionado");
        Avaliacao ava3 = new Avaliacao(null, LocalDate.of(2022, 5, 9), "img3.png", "Pendente", "Não solucionado");
        Avaliacao ava4 = new Avaliacao(null, LocalDate.of(2023, 7, 1), "img4.png", "Concluido", "Solucionado");
        Avaliacao ava5 = new Avaliacao(null, LocalDate.of(2021, 9, 10), "img5.png", "Pendente", "Não solucionado");
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

        Estoque est1 = new Estoque(null, 591, 50, 52, null);
        Estoque est2 = new Estoque(null, 1000, 800, 150, null);
        Estoque est3 = new Estoque(null, 1500, 1300, 200, null);
        Estoque est4 = new Estoque(null, 600, 300, 50, null);
        Estoque est5 = new Estoque(null, 800, 700, 20, null);
        //estoqueRepository.saveAll(List.of(est1, est2, est3, est4, est5));

        ProducaoCultivo prod1 = new ProducaoCultivo(null, "Café", "Café Arábica", 2000, null);
        ProducaoCultivo prod2 = new ProducaoCultivo(null, "Arroz", "Arroz Ingles", 1000, null);
        ProducaoCultivo prod3 = new ProducaoCultivo(null, "Feijao", "Feijao Brasileiro", 5200, null);
        ProducaoCultivo prod4 = new ProducaoCultivo(null, "Batata", "Batata Africana", 1858, null);
        ProducaoCultivo prod5 = new ProducaoCultivo(null, "Algodao", "Algodao Alemao", 1850, null);
        //producaoCultivoRepository.saveAll(List.of(prod1, prod2, prod3, prod4, prod5));

        Propriedade prop1 = new Propriedade(null, "Fazenda Solo", 10.50, 25.0,"Solo fino", "Tropical", null, end1, Collections.singletonList(prod1), est1);
        Propriedade prop2 = new Propriedade(null, "Fazenda Violeta", 20.00, 37.0, "Solo fértil", "Temperado", null, end2, Collections.singletonList(prod2), est2);
        Propriedade prop3 = new Propriedade(null, "Fazenda Luisa", 30.50, 50.0,"Solo triste", "Temperado", null, end3, Collections.singletonList(prod3), est3);
        Propriedade prop4 = new Propriedade(null, "Fazenda Livia", 40.50, 46.0,"Solo argiloso", "Tropical", null, end4, Collections.singletonList(prod4), est4);
        Propriedade prop5 = new Propriedade(null, "Fazenda Leo", 50.50, 60.0,"Solo sem fertilidade", "Tropical", null, end5, Collections.singletonList(prod5), est5);
        //propriedadeRepository.saveAll(List.of(prop1, prop2, prop3, prop4, prop5));

        //Empreendedor empree1 = new Empreendedor(1L, "Claudio", "claudio@gmail.com", 11111111111111L, LocalDate.of(1978, 4, 20), LocalDate.of(2020, 7, 13), emp1, prob1, gen1, tel1, prop1);
        //Empreendedor empree2 = new Empreendedor(2L, "Joao", "joao@gmail.com", 22222222222222L, LocalDate.of(1965, 2, 14), LocalDate.of(2021, 2, 24), emp2, prob2, gen2, tel1, prop2);
        //Empreendedor empree3 = new Empreendedor(3L, "Amelia", "amelia@gmail.com", 33333333333333L, LocalDate.of(1984, 7, 3), LocalDate.of(2022, 10, 22), emp3, prob3, gen2, tel3, prop3);
        //Empreendedor empree4 = new Empreendedor(4L, "Jose", "jose@gmail.com", 44444444444444L, LocalDate.of(1985, 11, 15), LocalDate.of(2023, 5, 19), emp4, prob4, gen1, tel4, prop4);
        //Empreendedor empree5 = new Empreendedor(5L, "Pedro", "pedro@gmail.com", 55555555555555L, LocalDate.of(1987, 7, 11), LocalDate.of(2020, 6, 29), emp5, prob5, gen1, tel5, prop5);
        //empreendedorRepository.saveAll(List.of(empree1, empree2, empree3, empree4, empree5));

        empreendedorRepository.saveAll(List.of(
            Empreendedor.builder().name("Claudio").email("claudio@gmail.com").cnpj(11111111111111L).dataNascimento(LocalDate.of(1978, 4, 20)).dataCadastro(LocalDate.of(2020, 7, 13)).empresa(emp1).problema(Collections.singletonList(prob1)).genero(gen1).telefone(tel1).propriedade(Collections.singletonList(prop1)).build(),
            Empreendedor.builder().name("Joao").email("joao@gmail.com").cnpj(22222222222222L).dataNascimento(LocalDate.of(1965, 2, 14)).dataCadastro(LocalDate.of(2021, 2, 24)).empresa(emp2).problema(Collections.singletonList(prob2)).genero(gen1).telefone(tel2).propriedade(Collections.singletonList(prop2)).build(),
            Empreendedor.builder().name("Amelia").email("amelia@gmail.com").cnpj(33333333333333L).dataNascimento(LocalDate.of(1984, 7, 3)).dataCadastro(LocalDate.of(2022, 10, 22)).empresa(emp3).problema(Collections.singletonList(prob3)).genero(gen2).telefone(tel3).propriedade(Collections.singletonList(prop3)).build(),
            Empreendedor.builder().name("Jose").email("jose@gmail.com").cnpj(44444444444444L).dataNascimento(LocalDate.of(1985, 11, 15)).dataCadastro(LocalDate.of(2023, 5, 19)).empresa(emp4).problema(Collections.singletonList(prob4)).genero(gen1).telefone(tel4).propriedade(Collections.singletonList(prop4)).build(),
            Empreendedor.builder().name("Pedro").email("pedro@gmail.com").cnpj(55555555555555L).dataNascimento(LocalDate.of(1987, 7, 11)).dataCadastro(LocalDate.of(2020, 6, 29)).empresa(emp5).problema(Collections.singletonList(prob5)).genero(gen1).telefone(tel5).propriedade(Collections.singletonList(prop5)).build()
        ));

    }
}
