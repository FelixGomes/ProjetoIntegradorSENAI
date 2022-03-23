package model;

public class Veiculo {
	
	private int id;
	private String modelo;
	private boolean disponivel;
	private Double quilometragemAtual;
	private static Double consumoKmPorL;
	
	public Veiculo(String modelo, boolean disponivel, Double consumoKmPorL) {
		this.modelo = modelo;
		this.disponivel = disponivel;
		Veiculo.consumoKmPorL = consumoKmPorL;
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

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Double getQuilometragemAtual() {
		return quilometragemAtual;
	}

	public void setQuilometragemAtual(Double quilometragemAtual) {
		this.quilometragemAtual = quilometragemAtual;
	}

	public static Double getConsumoKmPorL() {
		return consumoKmPorL;
	}

	public void setConsumoKmPorL(Double consumoKmPorL) {
		Veiculo.consumoKmPorL = consumoKmPorL;
	}
	

}
