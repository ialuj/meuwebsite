package br.com.builders.buildersclientsmngapi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.persistence.Embeddable;

import br.com.builders.buildersclientsmngapi.utils.BusinessException;

@Embeddable
public class Cpf implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3588559375986178706L;
	
	private String cpf;

	public Cpf() {
		super();
	}

	public Cpf(String cpf) {
		super();
		setCpf(cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		validateCpf(cpf);
		this.cpf = cpf;
	}
	
	private void validateCpf(String cpf) {

		List<String> regexPatterns = new ArrayList<String>(10);
		regexPatterns.add("00000000000");
		regexPatterns.add("11111111111");
		regexPatterns.add("22222222222");
		regexPatterns.add("33333333333");
		regexPatterns.add("44444444444");
		regexPatterns.add("55555555555");
		regexPatterns.add("66666666666");
		regexPatterns.add("77777777777");
		regexPatterns.add("88888888888");
		regexPatterns.add("99999999999");

		if (regexPatterns.contains(cpf) || cpf.length() != 11) {
			throw new BusinessException("CPF é inválido - " + cpf);
		}

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {

				/*
				 * converte o i-esimo caractere do CPF em um numero: por exemplo, transforma o
				 * caractere '0' no inteiro 0 (48 eh a posicao de '0' na tabela ASCII)
				 */
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
			} else
				throw new BusinessException("CPF é inválido - " + cpf);
		} catch (InputMismatchException exception) {
			throw new BusinessException("CPF é inválido - " + cpf);
		}
	}


}
