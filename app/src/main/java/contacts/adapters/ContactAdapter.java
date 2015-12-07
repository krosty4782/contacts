package contacts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import contacts.R;
import contacts.model.Contact;


public class ContactAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Contact> mContacts;

    public ContactAdapter(Context context, List<Contact> contacts) {
        mInflater = LayoutInflater.from(context);
        mContacts = contacts;
    }

    @Override
    public int getCount() {
        return mContacts.size();
    }

    @Override
    public Object getItem(int position) {
        return mContacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.contact_item, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (Holder) convertView.getTag();
        }

        Contact contact = ((Contact)this.getItem(position));
        holder.mName.setText(contact.getFirst_name());
        holder.mSurname.setText(contact.getSurname());
        holder.mPicture.setImageDrawable(null);
        ImageLoader.getInstance().displayImage(contact.getAvatarUrl(), holder.mPicture);
        return convertView;
    }

    static class Holder {

        @InjectView(R.id.contactName)
        TextView mName;

        @InjectView(R.id.contactSurname)
        TextView mSurname;

        @InjectView(R.id.contactPicture)
        ImageView mPicture;

        public Holder(View view) {

            ButterKnife.inject(this, view);
        }
    }
}
