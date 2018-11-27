package deliciascaseiras.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import deliciascaseiras.modelo.Pessoa;
import deliciascaseiras.service.PessoaService;

public class AppUserDetailsService implements UserDetailsService {

		@Override
		public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
			PessoaService usuarios = new PessoaService();
			Pessoa usuario = usuarios.buscarPorLogin(login);
			
			PessoaSistema user = null;
			
			if (usuario != null) {
				user = new PessoaSistema(usuario, getGrupos(usuario));
			}
			
			return user;
		}

		private Collection<? extends GrantedAuthority> getGrupos(Pessoa usuario) {
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			
			for (String grupo : usuario.getPermissao()) {
				authorities.add(new SimpleGrantedAuthority(grupo.toUpperCase()));
			}
			
			return authorities;
	}	
	
}
