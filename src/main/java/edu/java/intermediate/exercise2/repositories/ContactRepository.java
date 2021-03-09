package edu.java.intermediate.exercise2.repositories;

import edu.java.intermediate.exercise2.models.Contact;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContactRepository {

    private static ContactRepository repository;
    private List<Contact> contact;

    public static ContactRepository getInstance(){
        if(repository == null){
            repository = new ContactRepository();
            repository.getContact().add(new Contact(1,"nombre1","apellidos",
                    "correo@correo.com","987654321", new Date(), null));
        }
        return repository;
    }

    private ContactRepository() {
        this.contact = new ArrayList<Contact>();
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List contact) {
        this.contact = contact;
    }
}
