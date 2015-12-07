package contacts;

import android.os.Bundle;


import contacts.fragments.ContactListFragment;


public class MainActivity extends BaseFragmentActivity {

    @Override
    protected int getFragmentContainerId() {
        return R.id.mainFragmentContainer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        addFragment(new ContactListFragment(), false);
    }
}
