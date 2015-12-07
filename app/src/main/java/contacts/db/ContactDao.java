package contacts.db;

import com.j256.ormlite.dao.Dao;

import java.util.List;

import contacts.model.Contact;


public interface ContactDao extends Dao<Contact, Integer> {

    void createContacts(List<Contact> contact);
}
