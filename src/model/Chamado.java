package model;

public class Chamado {
	private int id;
	private Double distanciaPercorrida;
	private Double calculoCO2PorLdeGasolina;
	private Veiculo modelo ;
	private Colaborador nome;
	private EnderecoAtendimento cep;
	
	
	public Chamado(double distanciaPercorrida, Veiculo modelo, Colaborador nome, EnderecoAtendimento cep) {
		this.modelo = modelo;
		this.nome = nome;
		this.cep = cep;
		this.distanciaPercorrida = distanciaPercorrida;
		if (distanciaPercorrida > 0) {
			totalCO2PorL();
		}
	}
	
	public Chamado() {
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getDistanciaPercorrida() {
		return distanciaPercorrida;
	}
	
	public void setDistanciaPercorrida(double distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}

	public Double getCalculoCO2PorLdeGasolina() {
		return calculoCO2PorLdeGasolina;
	}

	public void setCalculoCO2PorLdeGasolina(Double calculoCO2PorLdeGasolina) {
		this.calculoCO2PorLdeGasolina = calculoCO2PorLdeGasolina;
	}

	public Veiculo getVeiculo() {
		return modelo;
	}
	
	public void setVeiculo(Veiculo modelo) {
		this.modelo = modelo;
	}
	
	public Colaborador getColaborador() {
		return nome;
	}
	
	public void setColaborador(Colaborador nome) {
		this.nome = nome;
	}
	
	public EnderecoAtendimento getEnderecoAtendimento() {
		return cep;
	}
	
	public void setEnderecoAtendimento(EnderecoAtendimento cep) {
		this.cep = cep;
	}
	
	public double totalCO2PorL() {
		this.calculoCO2PorLdeGasolina = Veiculo.getConsumoKmPorL() * 0.82 * 0.75 * 3.7;
		return calculoCO2PorLdeGasolina * distanciaPercorrida;
	}
}
