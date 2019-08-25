package joffre.NanifarfallaRest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import joffre.NanifarfallaRest.component.ContactConverter;
import joffre.NanifarfallaRest.model.ContactModel;
import joffre.NanifarfallaRest.model.Usuario;
import joffre.NanifarfallaRest.repository.ContactRepository;
import joffre.NanifarfallaRest.service.ContactService;

@Service()
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ContactConverter contactconverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Usuario usuario = contactRepository.save(contactconverter.convertContactModel2Usuario(contactModel));
		return contactconverter.convertUsuario2ContactModel(usuario);
	}

	@Override
	public List<ContactModel> listAllContacts() {

		List<Usuario> usuarios = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for (Usuario usuario : usuarios) {
			contactsModel.add(contactconverter.convertUsuario2ContactModel(usuario));

		}
		return contactsModel;
	}




	@Override
	public Usuario getUsuario(int usuarioId) {
	
		 	return contactRepository.findById(usuarioId).get();
	}


	
	
	@Override
	public void removeContact(int id) {
		Usuario usuario = getUsuario(id);
		if(null != usuario) {
			contactRepository.delete(usuario);
		}
		
	}

	@Override
	public ContactModel getUsuarioModel(int usuarioId) {
		return contactconverter.convertUsuario2ContactModel(getUsuario(usuarioId));
	}

}
