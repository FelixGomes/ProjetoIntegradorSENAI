package controller;

import java.util.List;

import dao.ChamadoDao;
import dao.VeiculoDao;
import model.Chamado;

public class ChamadoController{
	
	public void novoChamado(Chamado chamado) throws Exception {
		
		if (chamado.getEndereco() == null || chamado.getEndereco().length() < 5) {
			throw new Exception("Alerta: Endere�o inv�lido.");
		}
		
		if (!chamado.getColaborador().isHabilitado()) {
			throw new Exception("Alerta: Colaborador n�o habilitado.");
		}
		
		if(!chamado.getVeiculo().isDisponivel()) {
			throw new Exception("Alerta: Veiculo indispon�vel.");
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
			throw new Exception("O Id do chamado � inv�lido");
		}
		
		ChamadoDao.getInstance().del(id);
	}
	
	public List<Chamado> listar() throws Exception{
		List<Chamado> chamados = ChamadoDao.getInstance().listar();
		
		if(chamados.isEmpty()) {
			throw new Exception("N�o h� chamados registrados.");
		}		
		return chamados;
	}
	
	public Chamado listById(int id) {
		return ChamadoDao.getInstance().listById(id);
	}
}