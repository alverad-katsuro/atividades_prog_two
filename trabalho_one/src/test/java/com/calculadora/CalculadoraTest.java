package com.calculadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {
	@Test
	public void testCalc_raiz() throws Exception {

	}

	@Test
	public void testSoma() throws Exception {
		Calculadora instance = new Calculadora();
		final double expected = 10;
		assertEquals(expected, instance.soma(5.0, 5.0));
		assertEquals(20.0, instance.soma(10.0, 10.0));
	}

	@Test
	public void testSubtracao() throws Exception {
		Calculadora instance = new Calculadora();
		final double expected = 10;
		assertEquals(expected, instance.subtracao(15.0, 5.0));
		assertEquals(30.0, instance.subtracao(35.0, 5.0));
	}

	@Test
	public void testDivisao() throws Exception {
		Calculadora instance = new Calculadora();
		final double expected = 10;
		assertEquals(expected, instance.divisao(100.0, 10.0));
		assertEquals(5, instance.divisao(5.0, 1.0));
	}

	@Test
	public void testResto() throws Exception {
		Calculadora instance = new Calculadora();
		final double expected = 1;
		assertEquals(expected, instance.resto(5.0, 4.0));
		assertEquals(2, instance.resto(6.0, 4.0));
	}

	@Test
	public void testMultiplicacao() throws Exception {
		Calculadora instance = new Calculadora();
		final double expected = 10;
		assertEquals(expected, instance.multiplicacao(5.0, 2.0));
		assertEquals(30, instance.multiplicacao(15.0, 2.0));
	}

	@Test
	public void testExponenciacao() throws Exception {
		Calculadora instance = new Calculadora();
		final double expected = 8;
		assertEquals(expected, instance.exponenciacao(2.0, 3.0));
		assertEquals(32, instance.exponenciacao(2.0, 5.0));
	}
}
