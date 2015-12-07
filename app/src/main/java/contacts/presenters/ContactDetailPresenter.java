package contacts.presenters;


import com.nostra13.universalimageloader.core.ImageLoader;

import contacts.fragments.ContactDetailsFragment;
import contacts.model.Contact;


public class ContactDetailPresenter{

    private Contact mContact;
    private ContactDetailsFragment mView;

    public ContactDetailPresenter(ContactDetailsFragment mView, Contact contact) {
        this.mContact = contact;
        this.mView = mView;
    }

    public void setUpView() {
        mView.getmFirstNameTV().setText(mContact.getFirst_name());
        mView.getmSurnameTV().setText(mContact.getSurname());
        mView.getmAddressTV().setText(mContact.getAddress());
        mView.getmCreatedAtTV().setText(mContact.getCreatedAt());
        mView.getmUpdatedAtTV().setText(mContact.getUpdatedAt());
        mView.getmEmailTV().setText(mContact.getEmail());
        mView.getmPhoneNumberTV().setText(mContact.getPhoneNumber());
        ImageLoader.getInstance().displayImage(mContact.getAvatarUrl(), mView.getmAvatar());
    }
}

