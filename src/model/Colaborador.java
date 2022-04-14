package model;

public class Colaborador {

	private int id;
	public String nome;
	private String cpf;
	private boolean isHabilitado;

	public Colaborador(int id, String nome, String cpf, boolean isHabilitado) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.isHabilitado = isHabilitado;
	}
	
	public Colaborador(int id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Colaborador() {
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public boolean isHabilitado() {
		return isHabilitado;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setHabilitado(boolean isHabilitado) {
		this.isHabilitado = isHabilitado;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}

