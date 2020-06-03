package br.com.naila.gerenciador;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import br.com.naila.gerenciador.database.ConnectionFactory;
import br.com.naila.gerenciador.database.dao.EmpresaDao;
import br.com.naila.gerenciador.modelo.Empresa;

public class InsercaoEListagemEmpresaTeste {

    public static void main(String[] args) throws SQLException, ParseException, PropertyVetoException {

	Empresa empresa = new Empresa("Corsair");
	LocalDate data = LocalDate.of(1991, Month.MAY, 24);
	empresa.setData(data);

	try (Connection conexao = new ConnectionFactory().getConnection()) {

	    EmpresaDao empresaDAO = new EmpresaDao(conexao);

//	    empresaDAO.adiciona(empresa);

	    List<Empresa> empresas = empresaDAO.lista();
	    empresas.forEach(System.out::println);
	}

    }

}
