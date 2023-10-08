package br.com.projeto.ecommerce.utils;

import org.springframework.stereotype.Component;

import br.com.projeto.ecommerce.enums.UserRole;

@Component
public class Utils {

	public String formatCpfCnpj(String cpfCnpj, UserRole userRole) {
		var cpfCnpjFormatted = "";
		
		if (UserRole.ADMIN.equals(userRole)) {
			cpfCnpjFormatted = cpfCnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})", "$1.$2.$3/$4-");
		} 
		
		if (UserRole.USER.equals(userRole)) {
			cpfCnpjFormatted = cpfCnpj.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
		}
		return cpfCnpjFormatted;
	}
	
	public String formatTelefone(String telefone) {
		return telefone.replaceAll("(\\d{2})(\\d{5})", "($1) $2-");
	}
}
