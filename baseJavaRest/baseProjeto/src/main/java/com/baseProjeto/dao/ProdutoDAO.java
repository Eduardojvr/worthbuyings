package com.baseProjeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.baseProjeto.entity.Produto;


public class ProdutoDAO {
	
	public ProdutoDAO(){
		
	}
	
	public ArrayList<Produto>  getAllProducts() throws Exception {
		Produto prod = null;
		Connection db = ConnectionManager.getDBConnection();
		PreparedStatement pstmt = null;
		ArrayList <Produto> produtos = new ArrayList<Produto>();
		ResultSet result = null;

		pstmt = db.prepareStatement("select id, codigo, urlImg, descricao, preco from produto");

		try {
			result = pstmt.executeQuery();
			while (result.next()) {
				prod = new Produto();
				prod.setId(result.getInt("id"));
				prod.setCodigo(result.getString("codigo"));
				prod.setUrlImg(result.getString("urlImg"));
				prod.setDescricao(result.getString("descricao"));
				prod.setPreco(result.getString("preco"));
				produtos.add(prod);
			}

		} catch(Exception e) {
			throw new Exception(e);
		} finally {
			if (pstmt != null)
				pstmt.close();
			db.close();
		}
		return produtos;
	}
	
	public boolean insert(Produto produto) throws Exception {

		Connection db = ConnectionManager.getDBConnection();
		PreparedStatement pstmt = null;

		StringBuilder sql = new StringBuilder();


		sql.append("INSERT INTO Produto ");
		sql.append(" ( ");
		sql.append(" id, ");
		sql.append(" codigo, ");
		sql.append(" urlImg, ");
		sql.append(" descricao, ");
		sql.append(" preco ");
		sql.append(" VALUES (?,?,?,?,?);");

		try {
			pstmt = db.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, produto.getId());
			pstmt.setString(2, produto.getCodigo());
			pstmt.setString(3, produto.getUrlImg());
			pstmt.setString(4, produto.getDescricao());
			pstmt.setString(5, produto.getPreco());

			pstmt.executeUpdate();

		} finally {
			if (pstmt != null)
				pstmt.close();
			db.close();
		}

		return true;

	}

	

}


