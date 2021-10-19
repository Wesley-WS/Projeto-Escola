package br.com.ebix.escola.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ebix.escola.model.AlunoMateria;

public class AlunoMateriaDaoImpl  extends ConnectionFactory implements AlunoMateriaDao{

	public List<AlunoMateria> selecionaMateriasAluno(long codigo) {
		List<AlunoMateria> relacoes = new ArrayList<AlunoMateria>();
		try {
			String sql = "SELECT * FROM escola.Aluno_materia_professor WHERE cod_aluno=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, codigo);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				AlunoMateria relacaoObtida = new AlunoMateria();
				relacaoObtida.setCod_aluno(rs.getLong("cod_aluno"));
				relacaoObtida.setCod_materia(rs.getLong("cod_materia"));
				relacoes.add(relacaoObtida);
			}
			
			rs.close();
			ps.close();
			return relacoes;
		} catch (SQLException e) {
			e.printStackTrace();
			return relacoes;
		}
		
		
	}

}
