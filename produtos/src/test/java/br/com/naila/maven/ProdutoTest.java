package br.com.naila.maven;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProdutoTest {
	
	@Test
	public void verificaPrecoComImposto() {
		Produto vinil = new Produto("Mercyful Fate", 200.0);
		assertEquals(220.0, vinil.getPrecoComImposto(), 0.00001);
	}
	
}
