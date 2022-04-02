package controller;

import java.util.List;

import dao.ChamadoDao;
import dao.VeiculoDao;
import model.Chamado;

public class ChamadoController{
	
	public void novoChamado(Chamado chamado) throws Exception {
		
		if (chamado.getEndereco() == null || chamado.getEndereco().length() < 5) {
			throw new Exception("Alerta: Endereço inválido.");
		}
		
		if (!chamado.getColaborador().isHabilitado()) {
			throw new Exception("Alerta: Colaborador não habilitado.");
		}
		
		if(!chamado.getVeiculo().isDisponivel()) {
			throw new Exception("Alerta: Veiculo indisponível.");
		}	
		
		ChamadoDao.getInstance().novoChamado(chamado);
		VeiculoDao.getInstance().desabilitarveiculos(chamado.getVeiculo());
		ChamadoDao.getInstance().novoChamado(chamado);
	}
	
	public void atualizar(Chamado chamado) throws Exception {

		ChamadoDao.getInstance().atualizar(chamado);
		VeiculoDao.getInstance().habilitarveiculos(chamado.getVeiculo());
	}
	
	public void del(int id) throws Exception {
		
		if (id == 0) {
			throw new Exception("O Id do chamado é inválido");
		}
		
		ChamadoDao.getInstance().del(id);
	}
	
	public List<Chamado> listar() throws Exception{
		List<Chamado> chamados = ChamadoDao.getInstance().listar();
		
		if(chamados.isEmpty()) {
			throw new Exception("Não há chamados registrados.");
		}		
		return chamados;
	}
	
	public Chamado listById(int id) {
		return ChamadoDao.getInstance().listById(id);
	}
}