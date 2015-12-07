package contacts.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import contacts.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import contacts.presenters.ContactsListPresenter;

public class ContactListFragment extends BaseFragment {
    private ContactsListPresenter mMainViewModel;
    @InjectView(R.id.contactList)
    ListView contactListV;
    @InjectView(R.id.contactError)
    TextView contactErrorTV;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_list_fragment, container, false);
        ButterKnife.inject(this, view);
        mMainViewModel = new ContactsListPresenter(this);
        mMainViewModel.getContacts();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public ListView getContactList() {
        return contactListV;
    }

    public TextView getContactErrorTV() {
        return contactErrorTV;
    }
}
