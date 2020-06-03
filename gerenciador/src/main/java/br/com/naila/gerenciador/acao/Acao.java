package br.com.naila.gerenciador.acao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Acao {
    /**
     * @return Deve retornar uma String no formato "forward:endereco" ou "redirect:endereco" 
     * @throws IOException
     * @throws ServletException
     * @throws PropertyVetoException 
     * @throws SQLException 
     */
    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException, PropertyVetoException;
    
}
