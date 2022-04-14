package controller;

import java.util.List;

import dao.ChamadoDao;
import dao.VeiculoDao;
import model.Chamado;

public class ChamadoController{
	
	public void criarChamado(Chamado chamado) throws Exception {
		
		if (chamado.getEndereco() == null || chamado.getEndereco().length() < 5) {
			throw new Exception("Alerta: Endere�o inv�lido.");
		}
		
		if (!chamado.getColaborador().isHabilitado()) {
			throw new Exception("Alerta: Colaborador n�o habilitado.");
		}
		
		if(!chamado.getVeiculo().isDisponivel()) {
			throw new Exception("Alerta: Veiculo indispon�vel.");
		}	
		
		ChamadoDao.getInstance().criarChamado(chamado);
		VeiculoDao.getInstance().atualizar(chamado.getVeiculo());
	}
	
	public void atualizar(Chamado chamado) throws Exception {
		
		if (chamado.getEndereco() == null || chamado.getEndereco().length() < 10)
			throw new Exception("Alerta: Endere�o inv�lido."); 
		
		if (chamado.getDistanciaPercorrida() < 1)
			throw new Exception("Alerta: Distancia percorrida inv�lida.");

		ChamadoDao.getInstance().atualizar(chamado);
	}
	
	public void del(int idChamado) throws Exception {
		
		if (idChamado == 0) {
			throw new Exception("O Id do chamado � inv�lido");
		}
		
		ChamadoDao.getInstance().excluir(idChamado);
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