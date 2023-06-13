package io.zolthan31fps;

import java.text.SimpleDateFormat;
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
import io.zolthan31fps.domain.ItemPedido;
import io.zolthan31fps.domain.Pagamento;
import io.zolthan31fps.domain.PagamentoComBoleto;
import io.zolthan31fps.domain.PagamentoComCartao;
import io.zolthan31fps.domain.Pedido;
import io.zolthan31fps.domain.Produto;
import io.zolthan31fps.domain.enums.EstadoPagamento;
import io.zolthan31fps.repositories.CategoriaRepository;
import io.zolthan31fps.repositories.CidadeRepository;
import io.zolthan31fps.repositories.ClienteRepository;
import io.zolthan31fps.repositories.EnderecoRepository;
import io.zolthan31fps.repositories.EstadoRepository;
import io.zolthan31fps.repositories.ItemPedidoRepository;
import io.zolthan31fps.repositories.PagamentoRepository;
import io.zolthan31fps.repositories.PedidoRepository;
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
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria();
		Categoria cat2 = new Categoria();
		
		Produto p1 = new Produto();
		Produto p2 = new Produto();
		Produto p3 = new Produto();
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));				
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado();
		Estado est2 = new Estado();
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "Belém", est2);
		Cidade c3 = new Cidade(null, "Castanhal", est2);
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente();
		
		cli1.getTelefones().addAll(Arrays.asList("984874876", "988074549"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Travessa Bom Jardim", "303", "Sala 808", "Cidade Velha", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), null, cli1, e1, null);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), null, cli1, e2, null);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
//		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
//		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
//		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
//		
//		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
//		ped2.getItens().addAll(Arrays.asList(ip3));
//		
//		p1.getItens().addAll(Arrays.asList(ip1));
//		p2.getItens().addAll(Arrays.asList(ip3));
//		p3.getItens().addAll(Arrays.asList(ip2));
//		
//		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}

}
