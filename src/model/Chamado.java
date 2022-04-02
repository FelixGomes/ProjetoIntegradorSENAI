package model;

public class Chamado {
	
	private int id;
	private String endereco;
	private Double distanciaPercorrida;;
	private Double totalKgCarbonoEmitidoPorLitro;
	private Colaborador colaborador;
	private Veiculo veiculo;
	
	public Chamado(String endereco, Double distanciaPercorrida, Colaborador colaborador, Veiculo veiculo) {
		this.endereco = endereco;
		this.distanciaPercorrida = distanciaPercorrida;
		this.colaborador = colaborador;
		this.veiculo = veiculo;
		calculaEmissaoDeCarbono();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public double getDistanciaPercorrida() {
		return distanciaPercorrida;
	}
	
	public void setDistanciaPercorrida(double distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}
	
	public double getTotalKgCarbonoEmitidoPorLitro() {
		return totalKgCarbonoEmitidoPorLitro;
	}
	
	public void setTotalKgCarbonoEmitidoPorLitro(double totalKgCarbonoEmitidoPorLitro) {
		this.totalKgCarbonoEmitidoPorLitro = totalKgCarbonoEmitidoPorLitro;
	}
	
	public Colaborador getColaborador() {
		return colaborador;
	}
	
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public void calculaEmissaoDeCarbono() {
		
		double percentualGasolinaPorLitro = 0.82;
		double densidadeGasolina = 0.75;
		double transformaGasolinaEmCo2 = 3.7; 
		
		double consumo = distanciaPercorrida / veiculo.getConsumoKmPorL();
		this.totalKgCarbonoEmitidoPorLitro = consumo * percentualGasolinaPorLitro * densidadeGasolina * transformaGasolinaEmCo2;
	}
}
