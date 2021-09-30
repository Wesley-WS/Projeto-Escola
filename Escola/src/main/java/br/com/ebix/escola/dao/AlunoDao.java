package br.com.ebix.escola.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class AlunoDao {
	public void adiciona() {
		try{
			String sql = "INSERT INTO contato (nome, endereco, email, dataNascimento) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEndereco());
			ps.setString(3, contato.getEmail());
			Date data = new Date(0);
			data.setTime(contato.getDataNascimento().getTimeInMillis());
			ps.setDate(4,data ,contato.getDataNascimento());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao acessar o banco");
			e.printStackTrace();
		}
	}
	
	public List<Contato> obterAlunos() {
		List<Contato> contatos = new ArrayList<Contato>();
		try {
			String	sql	=	"Select * from teste.contato ";
			PreparedStatement	ps	=  connection.prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()) {
				Contato contato = new Contato();
				contato.setNome(resultado.getString("nome"));
				contato.setEndereco(resultado.getString("endereco"));;
				contato.setEmail(resultado.getString("email"));
				Date date = resultado.getDate("dataNascimento");
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(date);
				contato.setDataNascimento(dataNascimento);
				contatos.add(contato);
			}
			ps.close();
			resultado.close();
			return contatos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return contatos;
		}
		
	}
}
