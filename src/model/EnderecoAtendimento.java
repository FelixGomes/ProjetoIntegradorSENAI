package model;

public class EnderecoAtendimento {
	
	private int id;
	private String UF;
	private String municipio;
	private String bairro;
	private String rua;
	private String numero;
	private String cep;
	
	public EnderecoAtendimento(String nome, String cpf, String UF, String municipio, String bairro, String rua, String numero, String cep) {
		this.setUF(UF);
		this.setMunicipio(municipio);
		this.setBairro(bairro);
		this.setRua(rua);
		this.setNumero(numero);
		this.setCep(cep);
	}
	
	public EnderecoAtendimento() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uf) {
		UF = uf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}


