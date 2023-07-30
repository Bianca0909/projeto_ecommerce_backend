package br.com.projeto.ecommerce.repository;

import br.com.projeto.ecommerce.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
	
	UserDetails findByLogin(String login);
}
