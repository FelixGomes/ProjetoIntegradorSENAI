package model;
import java.util.ArrayList;
import java.util.List;

import controller.ColaboradorController;
import controller.VeiculoController;
import controller.ChamadoController;
import model.Colaborador;
import model.Chamado;
import model.Veiculo;

public class Principal {

	public static void main(String[] args) {
		
//		testeColaborador();
//		testeVeiculo();
		testeChamado();
		
	}
	
	public static void testeColaborador() {
		Colaborador c1 = new Colaborador();
		c1.setId(1);
		c1.setNome("JOAO PAULO");
		c1.setHabilitado(true);
		
		Colaborador c2 = new Colaborador();
		c2.setId(2);
		c2.setNome("PEDRO PAULO");
		c2.setHabilitado(false);
		
		ColaboradorController controller = new ColaboradorController();
		try {
			controller.salvar(c1);
			controller.salvar(c2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Colaborador c : controller.listar()) {
			System.out.println(c.toString());
		}
	}
	
	public static void testeVeiculo() throws Exception {
		Veiculo p1 = new Veiculo();
		p1.setId(1);
		p1.setModelo("celta");
		p1.setConsumoKmPorL(15.9);
		p1.setDisponivel(true);
		p1.setQuilometragemAtual(4986.4);
		
		Veiculo p2 = new Veiculo();
		p2.setId(2);
		p2.setModelo("gol");
		p2.setConsumoKmPorL(18.2);
		p2.setDisponivel(false);
		p2.setQuilometragemAtual(10589.47);
		
		VeiculoController controller = new VeiculoController();
		
		try {
			controller.salvar(p1);
			controller.salvar(p2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		for (Veiculo p : controller.list()) {
			System.out.println(p.toString());
		}
	}
	
	public static void testeChamado() {
		
		Veiculo p1 = new Veiculo();
		p1.setId(1);
		p1.setModelo("celta");
		p1.setConsumoKmPorL(15.9);
		p1.setDisponivel(true);
		p1.setQuilometragemAtual(4986.4);
		
		Veiculo p2 = new Veiculo();
		p2.setId(2);
		p2.setModelo("gol");
		p2.setConsumoKmPorL(18.2);
		p2.setDisponivel(false);
		p2.setQuilometragemAtual(10589.47);
		
		Colaborador c1 = new Colaborador();
		c1.setId(1);
		c1.setNome("JOAO PAULO");
		c1.setHabilitado(true);
		
		Colaborador c2 = new Colaborador();
		c2.setId(2);
		c2.setNome("PEDRO PAULO");
		c2.setHabilitado(false);
		
		Chamado c = new Chamado();
		c.setVeiculo(p1);
		c.setColaborador(c2);
		c.calculaEmissaoDeCarbono();
		c.getEndereco();
		c.getTotalKgCarbonoEmitidoPorLitro();
				
		Chamado i2 = new Chamado();
		i2.setVeiculo(p2);
		i2.setColaborador(c1);
		i2.calculaEmissaoDeCarbono();
		i2.getEndereco();
		i2.getTotalKgCarbonoEmitidoPorLitro();
		
		List<Chamado> items = new ArrayList<>();
		items.add(c);
		items.add(i2);
		
		for (Chamado item : items) {
			System.out.println(item.getDistanciaPercorrida() + " - " + item.getVeiculo() + " - TOTAL: " + item.getTotalKgCarbonoEmitidoPorLitro());
		}
		
		
		ChamadoController controller = new ChamadoController();
		try {
			controller.criarChamado(i2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}