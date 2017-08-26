package br.fundatec.lpii.produtorest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


@Path("/produtos")

public class ProdutosREST {
	@GET 
	@Produces("application/json;charset=ISO-8859-1")
	public Response exibir() {
		Connection con = new ConnectionFactory().fabricate();
		JSONObject resultado = new JSONObject();
		try {
			String sql = "SELECT * FROM produto ORDER BY \"idProduto\"";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			JSONArray produtos = new JSONArray();
			while (rs.next()) {
				JSONObject produto = new JSONObject();
				produto.put("idProduto", rs.getInt("idProduto"));
				produto.put("nome", rs.getString("nome"));
				produto.put("preco", rs.getDouble("preco"));
				produto.put("unidade", rs.getString("unidade"));
				produtos.put(produto);
			}
			resultado.put("text", "Pesquisa executada com sucesso!");
			resultado.put("produtos", produtos);
		} catch (SQLException e) {
			e.printStackTrace();
			resultado.put("text", "Erro ao executar a pesquisa no banco de dados.");
			return Response.status(500).entity(resultado.toString(2)).build();
		}
		return Response.status(200).entity(resultado.toString(2)).build();
	}
	
	
	@Path("/idproduto/{id}")
	@GET
	@Produces("application/json;charset=ISO-8859-1")
	public Response ConsultaProdutosId(@PathParam("id") int idProduto) {
		Connection con = new ConnectionFactory().fabricate();
		JSONObject resultado = new JSONObject();
		try {
			String sql = "SELECT * FROM produto WHERE \"idProduto\" = " + idProduto + " ORDER BY \"idProduto\"";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			JSONArray produtos = new JSONArray();
			while (rs.next()) {
				JSONObject produto = new JSONObject();
				produto.put("idProduto", rs.getInt("idProduto"));
				produto.put("nome", rs.getString("nome"));
				produto.put("preco", rs.getDouble("preco"));
				produto.put("unidade", rs.getString("unidade"));
				produtos.put(produto);
			}
			resultado.put("text", "Pesquisa executada com sucesso!");
			resultado.put("produtos", produtos);
		} catch (SQLException e) {
			e.printStackTrace();
			resultado.put("text", "Erro ao executar a pesquisa no banco de dados.");
			return Response.status(500).entity(resultado.toString(2)).build();
		}
		return Response.status(200).entity(resultado.toString(2)).build();
	}
	
	
	@Path("/nome/{nome}")
	@GET 
	@Produces("application/json;charset=ISO-8859-1")
	public Response ConsultaProdutosNome(@PathParam("nome") String nome) {
		Connection con = new ConnectionFactory().fabricate();
		JSONObject resultado = new JSONObject();
		try {
			String sql = "SELECT * FROM produto WHERE \"nome\" like '%" + nome + "%' ORDER BY \"nome\"";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			JSONArray produtos = new JSONArray();
			while (rs.next()) {
				JSONObject produto = new JSONObject();
				produto.put("idProduto", rs.getInt("idProduto"));
				produto.put("nome", rs.getString("nome"));
				produto.put("preco", rs.getDouble("preco"));
				produto.put("unidade", rs.getString("unidade"));
				produtos.put(produto);
			}
			resultado.put("text", "Pesquisa executada com sucesso!");
			resultado.put("produtos", produtos);
		} catch (SQLException e) {
			e.printStackTrace();
			resultado.put("text", "Erro ao executar a pesquisa no banco de dados.");
			return Response.status(500).entity(resultado.toString(2)).build();
		}
		return Response.status(200).entity(resultado.toString(2)).build();
	}
	
	
	@Path("/preco/{preco}")
	@GET
	@Produces("application/json;charset=ISO-8859-1")
	public Response ConsultaProdutosPreco(@PathParam("preco") double preco) {
		Connection con = new ConnectionFactory().fabricate();
		JSONObject resultado = new JSONObject();
		try {
			String sql = "SELECT * FROM produto WHERE \"preco\" = " + preco + " ORDER BY \"idProduto\"";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			JSONArray produtos = new JSONArray();
			while (rs.next()) {
				JSONObject produto = new JSONObject();
				produto.put("idProduto", rs.getInt("idProduto"));
				produto.put("nome", rs.getString("nome"));
				produto.put("preco", rs.getDouble("preco"));
				produto.put("unidade", rs.getString("unidade"));
				produtos.put(produto);
			}
			resultado.put("text", "Pesquisa executada com sucesso!");
			resultado.put("produtos", produtos);
		} catch (SQLException e) {
			e.printStackTrace();
			resultado.put("text", "Erro ao executar a pesquisa no banco de dados.");
			return Response.status(500).entity(resultado.toString(2)).build();
		}
		return Response.status(200).entity(resultado.toString(2)).build();
	}
	
	
	@Path("/unidade/{unidade}")
	@GET
	@Produces("application/json;charset=ISO-8859-1")
	public Response ConsultaProdutosUnidade(@PathParam("unidade") String unidade) {
		Connection con = new ConnectionFactory().fabricate();
		JSONObject resultado = new JSONObject();
		try {
			String sql = "SELECT * FROM produto WHERE \"unidade\" LIKE '%" + unidade + "%' ORDER BY \"idProduto\"";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			JSONArray produtos = new JSONArray();
			while (rs.next()) {
				JSONObject produto = new JSONObject();
				produto.put("idProduto", rs.getInt("idProduto"));
				produto.put("nome", rs.getString("nome"));
				produto.put("preco", rs.getDouble("preco"));
				produto.put("unidade", rs.getString("unidade"));
				produtos.put(produto);
			}
			resultado.put("text", "Pesquisa executada com sucesso!");
			resultado.put("produtos", produtos);
		} catch (SQLException e) {
			e.printStackTrace();
			resultado.put("text", "Erro ao executar a pesquisa no banco de dados.");
			return Response.status(500).entity(resultado.toString(2)).build();
		}
		return Response.status(200).entity(resultado.toString(2)).build();
	}
	
	
	@PUT
	@Consumes("application/json;charset=ISO-8859-1") 
	@Produces("application/json;charset=ISO-8859-1") 
	public Response CadastraProduto(String j) throws JSONException {
		try {
			JSONObject produto = new JSONObject(j);
			String nome = produto.getString("nome");
			double preco = produto.getDouble("preco");
			String unidade = produto.getString("unidade");
			
			Connection con = new ConnectionFactory().fabricate();
			String sql = "INSERT INTO produto (nome, preco, unidade) values (?,?,?)";
			JSONObject resultado = new JSONObject();
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.setDouble(2, preco);
				stmt.setString(3, unidade);
				stmt.execute();
				stmt.close();
				resultado.put("text", "Produto cadastrado com sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
				resultado.put("text", "Erro ao cadastrar no banco de dados.");
			}
			return Response.status(201).entity(resultado.toString(2)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	
	@POST
	@Consumes("application/json;charset=ISO-8859-1")
	@Produces("application/json;charset=ISO-8859-1") 
	public Response AlteraProduto(String j) throws JSONException {
		try {
			JSONObject produto = new JSONObject(j);
			int idProduto = produto.getInt("idProduto");
			String nome = produto.getString("nome");
			double preco = produto.getDouble("preco");
			String unidade = produto.getString("unidade");
			
			Connection con = new ConnectionFactory().fabricate();
			String sql = "UPDATE produto SET nome = ? , preco = ? , unidade = ? WHERE \"idProduto\" = ?";
			JSONObject resultado = new JSONObject();
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.setDouble(2, preco);
				stmt.setString(3, unidade);
				stmt.setInt(4, idProduto);
				stmt.execute();
				stmt.close();
				resultado.put("text", "Produto alterado com sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
				resultado.put("text", "Erro ao alterar no banco de dados.");
			}
			return Response.status(200).entity(resultado.toString(2)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	
	@DELETE
	@Consumes("application/json;charset=ISO-8859-1") 
	@Produces("application/json;charset=ISO-8859-1") 
	public Response ExcluiPessoa(String j) throws JSONException {
		try {
			JSONObject produto = new JSONObject(j);
			int idProduto = produto.getInt("idProduto");
			Connection con = new ConnectionFactory().fabricate();
			String sql = "DELETE FROM produto WHERE \"idProduto\" = ?;";
			JSONObject resultado = new JSONObject();
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, idProduto);
				stmt.execute();
				stmt.close();
				resultado.put("text", "Produto excluido com sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
				resultado.put("text", "Erro ao excluir no banco de dados.");
			}
			return Response.status(202).entity(resultado.toString(2)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
}
