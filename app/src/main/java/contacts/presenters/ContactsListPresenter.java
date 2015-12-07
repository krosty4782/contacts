package contacts.presenters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;


import java.util.List;

import contacts.R;
import contacts.adapters.ContactAdapter;
import contacts.fragments.ContactDetailsFragment;
import contacts.fragments.ContactListFragment;
import contacts.model.Contact;
import contacts.services.RequestManager;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ContactsListPresenter {

    private List<Contact> mContacts;
    private Context mContext;
    private ContactListFragment mView;

    public ContactsListPresenter(ContactListFragment mView) {
        this.mView = mView;
        mContext = mView.getActivity();
    }

    public void setmArtists(List<Contact> contacts) {
        this.mContacts = contacts;
    }

    public void getContacts() {

        RequestManager.getContacts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(contacts -> {
                    if (contacts.size() > 0) {
                        mView.getContactErrorTV().setVisibility(View.GONE);
                        this.setmArtists(contacts);
                        this.setContactsAdapter();
                        this.setClickListeners();
                    }
                }, throwable -> {
                    Log.e("ERROR", throwable.toString());
                    mView.getContactErrorTV().setText(R.string.network_error);
                    mView.getContactErrorTV().setVisibility(View.VISIBLE);
                });
    }

    private void setContactsAdapter() {
        mView.getContactList().setAdapter(new ContactAdapter(mContext, mContacts));
    }

    private void setClickListeners() {
        ListView listView = mView.getContactList();
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("contact", (Contact) listView.getAdapter().getItem(position));
            ContactDetailsFragment contactDetailsFragment = new ContactDetailsFragment();
            contactDetailsFragment.setArguments(bundle);
            mView.addFragment(contactDetailsFragment, true);
        });
    }
}

