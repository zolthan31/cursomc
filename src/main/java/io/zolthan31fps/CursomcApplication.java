package io.zolthan31fps;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.zolthan31fps.domain.Categoria;
import io.zolthan31fps.domain.Cidade;
import io.zolthan31fps.domain.Cliente;
import io.zolthan31fps.domain.Endereco;
import io.zolthan31fps.domain.Estado;
import io.zolthan31fps.domain.Produto;
import io.zolthan31fps.domain.enums.TipoCliente;
import io.zolthan31fps.repositories.CategoriaRepository;
import io.zolthan31fps.repositories.CidadeRepository;
import io.zolthan31fps.repositories.ClienteRepository;
import io.zolthan31fps.repositories.EnderecoRepository;
import io.zolthan31fps.repositories.EstadoRepository;
import io.zolthan31fps.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired 
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Vestuario");
		Categoria cat2 = new Categoria(null, "Acessorios");
		
		Produto p1 = new Produto(null, "Camisa Polo", 80.00);
		Produto p2 = new Produto(null, "Relogio G-Shok", 170.00);
		Produto p3 = new Produto(null, "Camiseta", 60.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));				
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Pará");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "Belém", est2);
		Cidade c3 = new Cidade(null, "Castanhal", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "63796784097", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("984874876", "988074549"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Travessa Bom Jardim", "303", "Sala 808", "Cidade Velha", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}

}
