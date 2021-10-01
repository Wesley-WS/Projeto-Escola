package br.com.ebix.escola.utils;

public class ValidaStringUtil {
	public boolean eNuloVazioOuHaApenasEspaco(String string) {
		return (string == null || string.isBlank() || string.isEmpty() || string.trim().isEmpty());
	}
}
