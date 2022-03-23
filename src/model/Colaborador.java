package model;

public class Colaborador {
	private int id;
	private String nome;
	private boolean habilitado;
	
	public Colaborador(String nome, boolean habilitado) {
		this.nome = nome;
		this.habilitado = habilitado;
	}
	
	public Colaborador() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

}
