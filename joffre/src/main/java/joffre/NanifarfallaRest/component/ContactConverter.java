package joffre.NanifarfallaRest.component;

import org.springframework.stereotype.Component;

import joffre.NanifarfallaRest.model.ContactModel;
import joffre.NanifarfallaRest.model.Usuario;

@Component
public class ContactConverter {

	public Usuario convertContactModel2Usuario(ContactModel contactModel) {

		Usuario usuario = new Usuario();
		usuario.setNombre_usuario(contactModel.getNombre_usuario());
		usuario.setApellido_usuario(contactModel.getApellido_usuario());
		usuario.setNombre_logeo_usuario(contactModel.getNombre_logeo_usuario());
		usuario.setPassword_usuario(contactModel.getPassword_usuario());
		usuario.setDireccion_usuario(contactModel.getDireccion_usuario());
		usuario.setFecha_nacimiento(contactModel.getFecha_nacimiento());	
		usuario.setRuta_foto_usuario(contactModel.getRuta_foto_usuario());
		usuario.setDireccion_usuario(contactModel.getDireccion_usuario());
		usuario.setClaveApi(contactModel.getClaveApi());

		return usuario;

	}

	public ContactModel convertUsuario2ContactModel(Usuario usuario) {
		ContactModel contactmodel = new ContactModel();
		contactmodel.setNombre_usuario(usuario.getNombre_usuario());
		contactmodel.setApellido_usuario(usuario.getApellido_usuario());
		contactmodel.setNombre_logeo_usuario(usuario.getNombre_logeo_usuario());
		contactmodel.setPassword_usuario(usuario.getPassword_usuario());
		contactmodel.setDireccion_usuario(usuario.getDireccion_usuario());
		contactmodel.setFecha_nacimiento(usuario.getFecha_nacimiento());	
		contactmodel.setRuta_foto_usuario(usuario.getRuta_foto_usuario());
		contactmodel.setDireccion_usuario(usuario.getDireccion_usuario());
		contactmodel.setClaveApi(usuario.getClaveApi());
		return contactmodel;

	}
}
