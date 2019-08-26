package joffre.NanifarfallaRest.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import joffre.NanifarfallaRest.model.ContactModel;
import joffre.NanifarfallaRest.model.Distrito;
import joffre.NanifarfallaRest.model.EstadoUsuario;
import joffre.NanifarfallaRest.model.RequestUsuario;
import joffre.NanifarfallaRest.model.TipoUsuario;
import joffre.NanifarfallaRest.model.Usuario;
import joffre.NanifarfallaRest.model.entity.Privilege;
import joffre.NanifarfallaRest.repository.TipoUsuarioRepository;
import joffre.NanifarfallaRest.repository.UsuarioRepository;
import joffre.NanifarfallaRest.service.UsuarioService;

@Component
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

	Boolean enabled, accountNonExpired, credentialsNonExpired, accountNonLocked;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	TipoUsuarioRepository tipousuarioRepository;

	@Override
	public Usuario getUsuario(int usuarioId) {
		return usuarioRepository.findById(usuarioId).get();

	}

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario save(RequestUsuario requestUsuario) {
		Usuario usuario = new Usuario();
		usuario.setApellido_usuario(requestUsuario.getApellido_usuario());
		usuario.setNombre_usuario(requestUsuario.getNombre_usuario());
		usuario.setApellido_usuario(requestUsuario.getApellido_usuario());
		usuario.setDireccion_usuario(requestUsuario.getDireccion_usuario());
		usuario.setPassword_usuario(requestUsuario.getPassword_usuario());
		Distrito distrito = new Distrito();
		TipoUsuario tipoUsuario = new TipoUsuario();
		EstadoUsuario estadoUsuario = new EstadoUsuario();
		distrito.setCodigo_distrito(Integer.valueOf(requestUsuario.getDistrito()));
		usuario.setDistrito(distrito);
		return null;
	}

	@Override
	public ObjectNode updateUsuarioEstado(int estado, int idUsuario) {
		// int result = usuarioRepository.updateEstado(estado, idUsuario);
//		boolean resultado = result == 1 ? true : false;
		ObjectNode objectNode = new ObjectMapper().createObjectNode();
//		objectNode.put("resultado", resultado);
		return objectNode;
	}

	@Override
	public ObjectNode login(String username, String password) {
		ObjectNode objectNode = new ObjectMapper().createObjectNode();
		if (usuarioRepository.login(username, password)) {
			Usuario usuario = usuarioRepository.getUsuarioLogin(username, password);
			objectNode.put("login", true);
			objectNode.set("usuario", new ObjectMapper().valueToTree(usuario));
		} else {
			objectNode.put("login", false);
		}
		return objectNode;
	}

	@Override
	public Usuario addContact(ContactModel contactModel) {
		// TODO Auto-generated method stub
		return null;
	}

	private User buildUser(Usuario usuario, List<GrantedAuthority> authorities) {

		if (usuario.getEstadousuario().getCodigo_estadousuario() == 1
				&& usuario.getTipousuario().getCodigo_tipousuario() == 1) {
			enabled = true;
			accountNonExpired = true;
			credentialsNonExpired = true;
			accountNonLocked = true;
		} else {
			enabled = false;
			accountNonExpired = false;
			credentialsNonExpired = false;
			accountNonLocked = false;
		}

		return new User(usuario.getNombre_logeo_usuario(), usuario.getPassword_usuario(),

				enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

//	private Collection<? extends GrantedAuthority> buildAuthorities(Collection<TipoUsuario> tipousuarios) {
//		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
//		for (TipoUsuario tipousuario : tipousuarios) {
//			auths.add(new SimpleGrantedAuthority(tipousuario.getmPrivileges()));
//		}
//		return new ArrayList<GrantedAuthority>(auths);
//	}

	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.getUsuarioLogin(username, "");
   
//		List<GrantedAuthority> authorities = buildAuthorities(usuario.getTipousuario());
		
		 List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) getAuthorities((Collection<TipoUsuario>) usuario.getTipousuario());

		return buildUser(usuario, grantedAuthorities);
	}
	
	   private Collection<? extends GrantedAuthority> getAuthorities(Collection<TipoUsuario> tipousuario) {
	        return getGrantedAuthorities(getPrivileges(tipousuario));
	    }

	private List<String> getPrivileges(Collection<TipoUsuario> tipousuarios) {

		List<String> privileges = new ArrayList<>();
		List<Privilege> collection = new ArrayList<>();
		for (TipoUsuario tipousuario : tipousuarios) {
			collection.addAll((Collection<? extends Privilege>) tipousuario.getmPrivileges());

		}
		for (Privilege item : collection) {
			privileges.add(item.getNamePrivilege());
		}
		return privileges;
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(privilege));
		}
		return authorities;
	}

}
