package contacts.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

import contacts.MainApplication;
import contacts.R;
import contacts.db.ContactDaoImpl;

@DatabaseTable(tableName = "Contact", daoClass = ContactDaoImpl.class)
public class Contact implements Serializable{

    @DatabaseField(columnName = "id")
    private int id;
    @DatabaseField(columnName = "firstName")
    private String first_name;
    @DatabaseField(columnName = "surname")
    private String surname;
    @DatabaseField(columnName = "address")
    private String address;
    @DatabaseField(columnName = "phoneNumber")
    private String phoneNumber;
    @DatabaseField(columnName = "email")
    private String email;
    @DatabaseField(columnName = "createdAt")
    private String createdAt;
    @DatabaseField(columnName = "updatedAt")
    private String updatedAt;
    @DatabaseField(columnName = "avatarUrl")
    private String avatarUrl;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAvatarUrl() {
        if (avatarUrl == null) {
            avatarUrl = MainApplication.getAppContext().getString(R.string.avatar_url) + email;
        }
        return avatarUrl;
    }
}
