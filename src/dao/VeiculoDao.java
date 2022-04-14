package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Veiculo;
import util.ConnectionUtil;

public class VeiculoDao {

	private static VeiculoDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static VeiculoDao getInstance() {
		if (instance == null) {
			instance = new VeiculoDao();
		}
		return instance;
	}
	
	public void salvar(Veiculo veiculo) {
		try {
			String sql = "INSERT INTO veiculo (modelo, consumoKmPorL, quilometragemAtual) VALUES (?, ?, ?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, veiculo.getModelo());
			pstmt.setDouble(2, veiculo.getConsumoKmPorL());
			pstmt.setDouble(3, veiculo.getQuilometragemAtual());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Veiculo veiculo) {
		try {
			String sql = "UPDATE veiculo SET modelo = ?, consumoKmPorL = ?, quilometragemAtual = ?, WHERE id_Veiculo = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, veiculo.getModelo());
			pstmt.setDouble(2, veiculo.getConsumoKmPorL());
			pstmt.setDouble(3, veiculo.getQuilometragemAtual());
			pstmt.setInt(5, veiculo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		try {
			String sql = "DELETE FROM veiculo WHERE id_Veiculo = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Veiculo> listar() {
		List<Veiculo> listaVeiculos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM veiculo;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Veiculo v = new Veiculo();
				v.setId(rs.getInt("id_Veiculo"));
				v.setModelo(rs.getString("modelo"));
				v.setConsumoKmPorL(rs.getDouble("consumoKmPorL"));
				v.setQuilometragemAtual(rs.getDouble("quilometragemAtual"));
				listaVeiculos.add(v);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVeiculos;
	}
	
	public Veiculo listById(int id) {
		Veiculo v = new Veiculo();
		try {
			String sql = "SELECT * FROM veiculo WHERE id_Veiculo = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				v.setId(rs.getInt("id_Veiculo"));
				v.setModelo(rs.getString("modelo"));
				v.setConsumoKmPorL(rs.getDouble("consumoKmPorL"));
				v.setQuilometragemAtual(rs.getDouble("quilometragemAtual"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
}
