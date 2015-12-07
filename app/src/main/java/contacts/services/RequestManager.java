package contacts.services;


import java.util.ArrayList;
import java.util.List;


import contacts.db.CacheManager;
import contacts.model.Contact;
import rx.Observable;


public class RequestManager {

    private static Service service = ServiceFactory.createRetrofitService(Service.class, Service.SERVICE_ENDPOINT);

    public static Observable<List<Contact>> getContacts() {
        List<Contact> contacts = CacheManager.getContacts();

        if (contacts.size() > 0) {
            return Observable.from(wrapResponse(contacts));
        }

        return service.getContacts()
                .flatMap((contactsRequest -> {
                    if (contactsRequest.size() > 0) {
                        CacheManager.saveContacts(contacts);
                    }
                    return Observable.from(wrapResponse(contactsRequest));
                }));
    }

    public static List<List<Contact>> wrapResponse(List<Contact> response){
        List<List<Contact>> contactList = new ArrayList<>();
        contactList.add(response);
        return contactList;
    }

}
