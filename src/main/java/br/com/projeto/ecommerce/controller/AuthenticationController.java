package br.com.projeto.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.dto.AuthenticationDTO;
import br.com.projeto.ecommerce.dto.LoginResponseDTO;
import br.com.projeto.ecommerce.dto.RegisterDTO;
import br.com.projeto.ecommerce.infra.security.TokenService;
import br.com.projeto.ecommerce.model.UserModel;
import br.com.projeto.ecommerce.repository.UserRepository;
import br.com.projeto.ecommerce.utils.Utils;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private Utils utils;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((UserModel) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		if (this.userRepository.findByEmail(data.email()) != null) 
			return ResponseEntity.badRequest().build();
		
		String cpfCnpj = utils.formatCpfCnpj(data.cpfCnpj(), data.role());
		String telefone = utils.formatTelefone(data.telefone());
		
		String encryptPassword = new BCryptPasswordEncoder().encode(data.password());
		UserModel newUser = new UserModel(data.login(), cpfCnpj, data.email(), telefone, encryptPassword, data.role());
		
		this.userRepository.save(newUser);
		
		return ResponseEntity.ok().build();
	}
	
}
