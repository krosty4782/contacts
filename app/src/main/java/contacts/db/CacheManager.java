package contacts.db;

import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import contacts.model.Contact;

public class CacheManager {

    public static List<Contact> getContacts() {
        DaoManager manager = DaoManager.getDaoManager();
        ContactDao contactsDao = manager.getContactsDao();
        List<Contact> contacts;
        try {
            contacts = contactsDao.queryForAll();
            return contacts;
        } catch (SQLException e) {
            Log.e("SQL EXCEPTION", e.toString());
        }
        return new ArrayList<>();
    }

    public static void saveContacts(List<Contact> contacts) {
        DaoManager manager = DaoManager.getDaoManager();
        ContactDao contactsDao = manager.getContactsDao();
        contactsDao.createContacts(contacts);
    }
}
