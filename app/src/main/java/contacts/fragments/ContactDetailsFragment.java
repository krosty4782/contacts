package contacts.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import contacts.R;
import contacts.model.Contact;
import contacts.presenters.ContactDetailPresenter;

public class ContactDetailsFragment extends BaseFragment {

    private ContactDetailPresenter mContactDetailPresenter;
    @InjectView(R.id.contactFirstName)
    TextView mFirstNameTV;
    @InjectView(R.id.contactSurname)
    TextView mSurnameTV;
    @InjectView(R.id.contactAddress)
    TextView mAddressTV;
    @InjectView(R.id.contactPhoneNumber)
    TextView mPhoneNumberTV;
    @InjectView(R.id.contactEmail)
    TextView mEmailTV;
    @InjectView(R.id.contactCreatedAt)
    TextView mCreatedAtTV;
    @InjectView(R.id.contactUpdatedAt)
    TextView mUpdatedAtTV;
    @InjectView(R.id.contactPicture)
    ImageView mAvatar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_detail_fragment, null);
        ButterKnife.inject(this, view);
        setUpFragment();
        return view;
    }

    private void setUpFragment() {
        Bundle args = getArguments();
        mContactDetailPresenter = new ContactDetailPresenter(this, (Contact)args.getSerializable("contact"));
        mContactDetailPresenter.setUpView();
    }

    public ContactDetailPresenter getmContactDetailPresenter() {
        return mContactDetailPresenter;
    }

    public void setmContactDetailPresenter(ContactDetailPresenter mContactDetailPresenter) {
        this.mContactDetailPresenter = mContactDetailPresenter;
    }

    public TextView getmFirstNameTV() {
        return mFirstNameTV;
    }

    public void setmFirstNameTV(TextView mFirstNameTV) {
        this.mFirstNameTV = mFirstNameTV;
    }

    public TextView getmSurnameTV() {
        return mSurnameTV;
    }

    public void setmSurnameTV(TextView mSurnameTV) {
        this.mSurnameTV = mSurnameTV;
    }

    public TextView getmAddressTV() {
        return mAddressTV;
    }

    public void setmAddressTV(TextView mAddressTV) {
        this.mAddressTV = mAddressTV;
    }

    public TextView getmPhoneNumberTV() {
        return mPhoneNumberTV;
    }

    public void setmPhoneNumberTV(TextView mPhoneNumberTV) {
        this.mPhoneNumberTV = mPhoneNumberTV;
    }

    public TextView getmEmailTV() {
        return mEmailTV;
    }

    public void setmEmailTV(TextView mEmailTV) {
        this.mEmailTV = mEmailTV;
    }

    public TextView getmCreatedAtTV() {
        return mCreatedAtTV;
    }

    public void setmCreatedAtTV(TextView mCreatedAtTV) {
        this.mCreatedAtTV = mCreatedAtTV;
    }

    public TextView getmUpdatedAtTV() {
        return mUpdatedAtTV;
    }

    public void setmUpdatedAtTV(TextView mUpdatedAtTV) {
        this.mUpdatedAtTV = mUpdatedAtTV;
    }

    public ImageView getmAvatar() {
        return mAvatar;
    }
}
