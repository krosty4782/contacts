package contacts.db;

import android.util.Log;


import java.sql.SQLException;

import contacts.model.Contact;


public class DaoManager {

    private static final String TAG = "DaoManager";

    private DatabaseHelper databaseHelper;

    private static DaoManager instance;

    private ContactDao mContactDao;


    public DaoManager() {
        databaseHelper = DatabaseHelper.getHelper();
    }

    public static DaoManager getDaoManager() {
        if (instance == null) {
            instance = new DaoManager();
        }
        return instance;
    }

    public ContactDao getContactsDao() {
        if(mContactDao == null) {
            try {
                mContactDao = com.j256.ormlite.dao.DaoManager.createDao(databaseHelper.getConnectionSource(), Contact.class);
            } catch (SQLException e) {
                Log.d(TAG, "getContactDao sql exception " + e);
            }
        }
        return mContactDao;
    }
}
