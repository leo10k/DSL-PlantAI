package br.com.dnl.agrogpt.api.config;

import br.com.dnl.agrogpt.api.models.*;
import br.com.dnl.agrogpt.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
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

        Empresa emp1 = new Empresa(1L, "Monsanto", "Bayer Crop Science", 11111111111111L, "Monsanto@gmail.com", "Monsanto é uma empresa voltada para agro negocio", "Ativo");
        Empresa emp2 = new Empresa(2L, "Cargill", "Cargill Agrícola", 22222222222222L, "Cargill@gmail.com", "Cargill é uma empresa voltada para agro negocio", "Ativo");
        Empresa emp3 = new Empresa(3L, "Syngenta", "Syngenta Crop Protection", 33333333333333L, "Syngenta@gmail.com", "Syngenta é uma empresa voltada para agro negocio", "Ativo");
        Empresa emp4 = new Empresa(4L, "John Deere", "John Deere Brasil", 44444444444444L, "JohnDeere@gmail.com", "John Deere é uma empresa voltada para agro negocio", "Ativo");
        Empresa emp5 = new Empresa(5L, "JBS", "JBS Foods", 55555555555555L, "JBS@gmail.com", "JBS é uma empresa voltada para agro negocio", "Ativo");
        empresaRepository.saveAll(List.of(emp1, emp2, emp3, emp4, emp5));

        Pagamento pag1 = new Pagamento(1L, LocalDate.of(2023, 4, 10), 123.99);
        Pagamento pag2 = new Pagamento(2L, LocalDate.of(2022, 12, 30), 234.99);
        Pagamento pag3 = new Pagamento(3L, LocalDate.of(2023, 1, 2), 97.99);
        Pagamento pag4 = new Pagamento(4L, LocalDate.of(2020, 7, 22), 72.99);
        Pagamento pag5 = new Pagamento(5L, LocalDate.of(2021, 8, 17), 54.99);
        pagamentoRepository.saveAll(List.of(pag1, pag2, pag3, pag4, pag5));

        Empreendedor empree1 = new Empreendedor(1L, "Claudio", "claudio@gmail.com", 11111111111111L, LocalDate.of(1978, 4, 20), LocalDate.of(2020, 7, 13));
        Empreendedor empree2 = new Empreendedor(2L, "Joao", "joao@gmail.com", 22222222222222L, LocalDate.of(1965, 2, 14), LocalDate.of(2021, 2, 24));
        Empreendedor empree3 = new Empreendedor(3L, "Amelia", "amelia@gmail.com", 33333333333333L, LocalDate.of(1984, 7, 3), LocalDate.of(2022, 10, 22));
        Empreendedor empree4 = new Empreendedor(4L, "Jose", "jose@gmail.com", 44444444444444L, LocalDate.of(1985, 11, 15), LocalDate.of(2023, 5, 19));
        Empreendedor empree5 = new Empreendedor(5L, "Pedro", "pedro@gmail.com", 55555555555555L, LocalDate.of(1987, 7, 11), LocalDate.of(2020, 6, 29));
        empreendedorRepository.saveAll(List.of(empree1, empree2, empree3, empree4, empree5));

        Genero gen1 = new Genero(1L, "Masculino", "Ele/Dele");
        Genero gen2 = new Genero(2L, "Feminino", "Ela/Dela");
        generoRepository.saveAll(List.of(gen1, gen2));

        Telefone tel1 = new Telefone(1L, 55, 11, 911111111L);
        Telefone tel2 = new Telefone(2L, 55, 13, 922222222L);
        Telefone tel3 = new Telefone(3L, 55, 19, 933333333L);
        Telefone tel4 = new Telefone(4L, 55, 23, 944444444L);
        Telefone tel5 = new Telefone(5L, 55, 35, 955555555L);
        telefoneRepository.saveAll(List.of(tel1, tel2, tel3, tel4, tel5));

        Problema prob1 = new Problema(1L, "Problema no solo", "O solo esta com falta de agua.");
        Problema prob2 = new Problema(2L, "Problema na planta", "A planta esta com falta de sais.");
        Problema prob3 = new Problema(3L, "Problema na violeta", "A violeta esta com falta de minerios.");
        Problema prob4 = new Problema(4L, "Problema no planta", "A planta vai sarar.");
        Problema prob5 = new Problema(5L, "Problema no solo argiloso", "O solo vai beber agua.");
        problemaRepository.saveAll(List.of(prob1, prob2, prob3, prob4, prob5));

        Avaliacao ava1 = new Avaliacao(1L, LocalDate.of(2021, 1, 17), "img1.png", "Concluido", "Solucionado");
        Avaliacao ava2 = new Avaliacao(2L, LocalDate.of(2020, 3, 24), "img2.png", "Concluido", "Solucionado");
        Avaliacao ava3 = new Avaliacao(3L, LocalDate.of(2022, 5, 9), "img3.png", "Pendente", "Não solucionado");
        Avaliacao ava4 = new Avaliacao(4L, LocalDate.of(2023, 7, 1), "img4.png", "Concluido", "Solucionado");
        Avaliacao ava5 = new Avaliacao(5L, LocalDate.of(2021, 9, 10), "img5.png", "Pendente", "Não solucionado");
        avaliacaoRepository.saveAll(List.of(ava1, ava2, ava3, ava4, ava5));

        Propriedade prop1 = new Propriedade(1L, "Fazenda Solo", 10.50, 25.0,"Solo fino", "Tropical");
        Propriedade prop2 = new Propriedade(2L, "Fazenda Violeta", 20.00, 37.0,"Solo fértil", "Temperado");
        Propriedade prop3 = new Propriedade(3L, "Fazenda Luisa", 30.50, 50.0,"Solo triste", "Temperado");
        Propriedade prop4 = new Propriedade(4L, "Fazenda Livia", 40.50, 46.0,"Solo argiloso", "Tropical");
        Propriedade prop5 = new Propriedade(5L, "Fazenda Leo", 50.50, 60.0,"Solo sem fertilidade", "Tropical");
        propriedadeRepository.saveAll(List.of(prop1, prop2, prop3, prop4, prop5));

        Endereco end1 = new Endereco(1L, 123,"Rua das Flores", "Centro", "SP", "Brasil", 15161516, "casa da esquina");
        Endereco end2 = new Endereco(2L, 86,"Rua Purificada", "Centro", "BA", "Brasil", 16146565, "ali 123");
        Endereco end3 = new Endereco(3L, 76,"AV. das pombas", "Osasco", "SP", "Brasil", 96959454, "Ao lado do 258");
        Endereco end4 = new Endereco(4L, 222,"Rua das Orquideas", "Conceicao", "MG", "Brasil", 15615165, "farmacia da esquina");
        Endereco end5 = new Endereco(5L, 90,"Rua das Violetas", "Vila Sonia", "TO", "Brasil", 12345678, "");
        enderecoRepository.saveAll(List.of(end1, end2, end3, end4, end5));

        Estoque est1 = new Estoque(1L, 591, 50, 52);
        Estoque est2 = new Estoque(2L, 1000, 800, 150);
        Estoque est3 = new Estoque(3L, 1500, 1300, 200);
        Estoque est4 = new Estoque(4L, 600, 300, 50);
        Estoque est5 = new Estoque(5L, 800, 700, 20);
        estoqueRepository.saveAll(List.of(est1, est2, est3, est4, est5));

        ProducaoCultivo prod1 = new ProducaoCultivo(1L, "Café", "Café Arábica", 2000);
        ProducaoCultivo prod2 = new ProducaoCultivo(2L, "Arroz", "Arroz Ingles", 1000);
        ProducaoCultivo prod3 = new ProducaoCultivo(3L, "Feijao", "Feijao Brasileiro", 5200);
        ProducaoCultivo prod4 = new ProducaoCultivo(4L, "Batata", "Batata Africana", 1858);
        ProducaoCultivo prod5 = new ProducaoCultivo(5L, "Algodao", "Algodao Alemao", 1850);
        producaoCultivoRepository.saveAll(List.of(prod1, prod2, prod3, prod4, prod5));

    }
}
