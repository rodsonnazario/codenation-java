package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		if(salarioBase < 1039)
			return 0;
		salarioBase = calcularInss(salarioBase);
		salarioBase = calcularIrrf(salarioBase);
		return Math.round(salarioBase);
	}
	
	private double calcularInss(double salarioBase) {
		return salarioBase -= salarioBase <= 1500 ? salarioBase * 0.08 :
				salarioBase <= 4000 ? salarioBase * 0.09 :
						salarioBase * 0.11;
	}

	private  double calcularIrrf(double salarioBase) {
		return salarioBase -= salarioBase <= 3000 ? 0 :
				salarioBase <= 6000 ? salarioBase * 0.075 :
						salarioBase * 0.15;
	}
}