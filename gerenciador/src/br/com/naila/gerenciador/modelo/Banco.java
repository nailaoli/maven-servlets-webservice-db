package br.com.naila.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Banco {

    private static Map<Integer, Empresa> listaDeEmpresas = new ConcurrentHashMap<>();
    private static List<Usuario> listaDeUsuarios = new ArrayList<>();
    private static Integer id;

    static {
	id = 1;
	listaDeEmpresas.put(id, new Empresa("Alura"));
	listaDeEmpresas.get(id).setId(id);
	id++;
	listaDeEmpresas.put(id, new Empresa("Caelum"));
	listaDeEmpresas.get(id).setId(id);
	id++;

	listaDeUsuarios.add(new Usuario("tompero", "12345"));
	listaDeUsuarios.add(new Usuario("montega", "12345"));
    }

    public static void adiciona(Empresa empresa) {
	Banco.listaDeEmpresas.put(id, empresa);
	listaDeEmpresas.get(id).setId(id);
	id++;
    }

    public static void removeEmpresa(Integer id) {
	Banco.listaDeEmpresas.remove(id);
    }

    public static void alteraEmpresa(Integer id, String nome, Date data) {
	listaDeEmpresas.get(id).setNome(nome);
	listaDeEmpresas.get(id).setData(data);
    }

    public static Empresa buscaEmpresaPeloId(Integer id) {
	return listaDeEmpresas.get(id);
    }
    
    public static Collection<Empresa> getEmpresas() {
	return Collections.unmodifiableCollection(Banco.listaDeEmpresas.values());
    }

    public static Usuario autenticaUsuario(String login, String senha) {
	Usuario tentandoLogar = new Usuario(login, senha);
	for (Usuario usuario : listaDeUsuarios) {
	    if (usuario.equals(tentandoLogar)){
		return usuario;
	    }
	}
	return null;
    }
}
