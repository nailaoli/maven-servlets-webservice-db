package br.com.naila.maven;

public class App {
	public static void main(String[] args) {
		Produto produto = new Produto("Vinil do Mercyful Fate", 200.0);
		System.out.println(produto.getNome() + ", " + produto.getPreco());	
	}
}
