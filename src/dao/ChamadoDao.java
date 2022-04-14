package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Chamado;
import model.Colaborador;
import model.Veiculo;
import util.ConnectionUtil;

public class ChamadoDao {

	private static ChamadoDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static ChamadoDao getInstance() {
		if (instance == null) {
			instance = new ChamadoDao();
		}
		return instance;
	}
	
	public void salvar(Chamado chamado) {
		try {
			String sql = "INSERT INTO CLIENTE (distanciaPercorrida, endereco, totalKgCarbonoEmitidoPorLitro) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, chamado.getDistanciaPercorrida());
			pstmt.setString(2, chamado.getEndereco());
			pstmt.setDouble(3, chamado.getTotalKgCarbonoEmitidoPorLitro());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void criarChamado(Chamado chamado) {
		try {
			String sql = "INSERT INTO CHAMADO (distanciaPercorrida, endereco, totalKgCarbonoEmitidoPorLitro,"
					+ "colaborador_idColaborador, veiculo_idVeiculo) VALUES(?, ?, ?, ?, ?, ?);";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, chamado.getDistanciaPercorrida());
			pstmt.setString(2, chamado.getEndereco());
			pstmt.setDouble(3, chamado.getTotalKgCarbonoEmitidoPorLitro());
			pstmt.setInt(4, chamado.getVeiculo().getId());
			
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Chamado chamado) {
		try {
			String sql = "UPDATE chamado SET endereco = ?, distancia = ?, totalKgCarbonoEmitidoPorLitro = ?, "
					+ "colaborador_id = ?, veiculo_id = ?, WHERE idChamado = ?;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, chamado.getEndereco());
			pstmt.setDouble(2, chamado.getDistanciaPercorrida());
			pstmt.setDouble(3, chamado.getTotalKgCarbonoEmitidoPorLitro());
			pstmt.setInt(4, chamado.getVeiculo().getId());
			pstmt.setInt(5, chamado.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		try {
			String sql = "DELETE FROM chamado WHERE idChamado = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Chamado> listar() {
		List<Chamado> listaChamados = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM chamado c JOIN colaborador col ON c.colaborador_id = col.id"
					+ " JOIN veiculo v ON c.veiculo_id = v.id;";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Chamado c = new Chamado();
				c.setId(rs.getInt("idChamado"));
				c.setEndereco(rs.getString("endereco"));
				c.setDistanciaPercorrida(rs.getDouble("distanciaPercorrida"));
				c.setTotalKgCarbonoEmitidoPorLitro(rs.getDouble("totalKgCarbonoEmitidoPorLitro"));

				Veiculo v = new Veiculo();
				v.setId(rs.getInt("idVeiculo"));
				v.setModelo(rs.getString("modelo"));
				v.setConsumoKmPorL(rs.getDouble("consumoKmPorL"));
				v.setQuilometragemAtual(rs.getDouble("quilometragemAtual"));
				
				Colaborador col = new Colaborador(0, rs.getString("nome"), sql);
				col.setHabilitado(rs.getBoolean("habilitado"));
				
				c.setVeiculo(v);
				c.setColaborador(col);
				
				listaChamados.add(c);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaChamados;
	}

	public Chamado listById(int id) {
		Chamado c = new Chamado();
		
		try {
			String sql = "SELECT * FROM chamado c JOIN colaborador col ON c.colaborador_id = col.id"
					+ " JOIN veiculo v ON c.veiculo_id = v.id WHERE idChamado = ?;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				c.setId(rs.getInt("idChamado"));
				c.setEndereco(rs.getString("endereco"));
				c.setDistanciaPercorrida(rs.getDouble("distanciaPercorrida"));
				c.setTotalKgCarbonoEmitidoPorLitro(rs.getDouble("totalKgCarbonoEmitidoPorLitro"));
				
				Veiculo v = new Veiculo();
				v.setId(rs.getInt("idVeiculo"));
				v.setModelo(rs.getString("modelo"));
				v.setConsumoKmPorL(rs.getDouble("consumoKmPorL"));
				v.setQuilometragemAtual(rs.getDouble("quilometragemAtual"));
				
				Colaborador col = new Colaborador(id, rs.getString("nome"), sql);
				col.setHabilitado(rs.getBoolean("habilitado"));
				
				c.setVeiculo(v);
				c.setColaborador(col);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
}