package controller;

import java.util.List;

import dao.ColaboradorDao;
import model.Colaborador;

public class ColaboradorController {
	
	public void salvar(Colaborador Colaborador) throws Exception {
		
		if (Colaborador.getNome() == null || Colaborador.getNome().length() < 2) {
			throw new Exception("Nome inválido");
		}
		
		ColaboradorDao.getInstance().salvar(Colaborador);
	}
	
	public void atualizar(Colaborador Colaborador) throws Exception {
		
		if (Colaborador.getNome() == null || Colaborador.getNome().length() < 2) {
			throw new Exception("Nome inválido");
		}
		
		ColaboradorDao.getInstance().atualizar(Colaborador);
	}
	
	public void excluir(int idColaborador) throws Exception {
		
		if (idColaborador == 0) {
			throw new Exception("Nenhum colaborador selecionado");
		}
		
		ColaboradorDao.getInstance().del(idColaborador);
	}
	
	public List<Colaborador> listar(){
		return ColaboradorDao.getInstance().listar();
	}
}
