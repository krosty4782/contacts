package contacts.db;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;

import java.sql.SQLException;
import java.util.List;

import contacts.model.Contact;


public class ContactDaoImpl extends BaseDaoImpl<Contact, Integer> implements ContactDao {

    public ContactDaoImpl(Class<Contact> dataClass) throws SQLException {
        super(dataClass);
    }

    public ContactDaoImpl(ConnectionSource connectionSource, Class<Contact> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public ContactDaoImpl(ConnectionSource connectionSource, DatabaseTableConfig<Contact> tableConfig) throws SQLException {
        super(connectionSource, tableConfig);
    }

    @Override
    public void createContacts(List<Contact> contacts) {
        try {
            for (Contact contact : contacts) {
                create(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}