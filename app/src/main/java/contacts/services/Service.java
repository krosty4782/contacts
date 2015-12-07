package contacts.services;



import java.util.List;

import contacts.MainApplication;
import contacts.R;
import contacts.model.Contact;
import retrofit.http.GET;
import rx.Observable;

public interface Service {
    String SERVICE_ENDPOINT =  MainApplication.getAppContext().getString(R.string.api_url);

    @GET("/contacts")
    Observable<List<Contact>> getContacts();
}
