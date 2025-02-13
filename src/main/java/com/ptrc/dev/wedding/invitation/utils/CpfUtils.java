package com.ptrc.dev.wedding.invitation.utils;

public class CpfUtils {
	public static boolean isValidCPF(String cpf) {
		if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
			return false;
		}

		int[] weights = {10, 9, 8, 7, 6, 5, 4, 3, 2};
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += (cpf.charAt(i) - '0') * weights[i];
		}
		int firstDigit = 11 - (sum % 11);
		if (firstDigit >= 10) {
			firstDigit = 0;
		}

		sum = 0;
		int[] weights2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
		for (int i = 0; i < 10; i++) {
			sum += (cpf.charAt(i) - '0') * weights2[i];
		}
		int secondDigit = 11 - (sum % 11);
		if (secondDigit >= 10) {
			secondDigit = 0;
		}

		return cpf.charAt(9) - '0' == firstDigit && cpf.charAt(10) - '0' == secondDigit;
	}
}