package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Colaborador;
import util.ConnectionUtil;

public class ColaboradorDao {

	private static ColaboradorDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static ColaboradorDao getInstance() {
		if (instance == null) {
			instance = new ColaboradorDao();
		}
		return instance;
	}
	
	public void salvar(Colaborador colaborador) {
		try {
			String sql = "INSERT INTO colaborador (nome, habilitado) VALUES (?, ?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, colaborador.getNome());
			pstmt.setBoolean(2, colaborador.isHabilitado());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Colaborador colaborador) {
		try {
			String sql = "UPDATE colaborador SET nome = ?, habilitado = ? WHERE nome = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, colaborador.getNome());
			pstmt.setBoolean(2, colaborador.isHabilitado());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		try {
			String sql = "DELETE FROM colaborador WHERE nome = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Colaborador> listar() {
		List<Colaborador> listaColaboradores = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM colaborador;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Colaborador c = new Colaborador();
				c.setNome(rs.getString("nome"));
				c.setHabilitado(rs.getBoolean("habilitado"));
				listaColaboradores.add(c);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaColaboradores;
	}
	
}