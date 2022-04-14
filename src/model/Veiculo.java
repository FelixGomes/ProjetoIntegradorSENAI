package model;

public class Veiculo {
	
	private  int id;
	private String modelo;
	private boolean disponivel;
	private Double consumoKmPorL;
	private Double quilometragemAtual;
	
	public Veiculo (String modelo, Double quilometragemAtual, Double consumoKmPorL) {
		this.modelo = modelo;
		this.quilometragemAtual = quilometragemAtual;
		this.consumoKmPorL = consumoKmPorL;
	}
	
	public Veiculo() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Double getQuilometragemAtual() {
		return quilometragemAtual;
	}
	
	public void setQuilometragemAtual(Double quilometragemAtual) {
		this.quilometragemAtual = quilometragemAtual;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public void setConsumoKmPorL(double consumoKmPorL) {
		this.consumoKmPorL= consumoKmPorL;
	}

	public double getConsumoKmPorL() {	
		return consumoKmPorL;
	}
}
