package controller;

import java.util.List;

import dao.VeiculoDao;
import model.Veiculo;

public class VeiculoController {
	
	public void salvar(Veiculo veiculo) throws Exception {
		
		if (!validarModelo(veiculo.getModelo())) {
			throw new Exception("Alerta: Modelo inválido.");
		}
		
		if (!validarQuilometragemAtual(veiculo.getQuilometragemAtual())) {
			throw new Exception("Alerta: A quilometragem atual está inválida.");
		}
		
		if (!validarConsumoKmPorL(veiculo.getConsumoKmPorL())) {
			throw new Exception("Alerta: Consumo inválido");
		}		
		VeiculoDao.getInstance().salvar(veiculo);
		
	}
	
	public void atualizar(Veiculo veiculo) throws Exception {
		
		if (!validarModelo(veiculo.getModelo())) {
			throw new Exception ("Alerta: Modelo inválido.");
		}
		
		if (!validarQuilometragemAtual(veiculo.getQuilometragemAtual())) {
			throw new Exception ("Alerta: A quilometragem atual está inválida.");
		}
		
		if (!validarConsumoKmPorL(veiculo.getConsumoKmPorL())) {
			throw new Exception ("Alerta: Consumo inválido");
		}
		
		VeiculoDao.getInstance().atualizar(veiculo);
		
	}
	
	public void del(int id) throws Exception {
		
		if (id == 0) {
			throw new Exception ("Alerta: Id inválido.");
		}
		
		VeiculoDao.getInstance().del(id);
		
	}
	
	public List<Veiculo> list() throws Exception{
		
		List<Veiculo> veiculos = VeiculoDao.getInstance().listar();
		
		if (veiculos.isEmpty()) {
			throw new Exception ("Alerta: Não existem veículos cadastrados.");
		} 
		else {
			
			return veiculos;
		}
		
	}
	
	public Veiculo listById(int id) {
		return VeiculoDao.getInstance().listById(id);
	}
	
	private boolean validarModelo(String modelo) {
		if (modelo == null || modelo.length() < 2) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean validarQuilometragemAtual(Double quilometragemAtual) {
		if (quilometragemAtual == null || quilometragemAtual < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean validarConsumoKmPorL(Double consumoKmPorL) {
		if (consumoKmPorL < 1.00 || consumoKmPorL > 50) {
			return false;
		}else {
			return true;
		}
	}
}