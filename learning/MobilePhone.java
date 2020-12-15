package com.java.practice.learning;

import java.util.ArrayList;

public class MobilePhone {
    String myNumber;
    ArrayList<Contacts> contactList;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contactList = new ArrayList<>();
    }

    public boolean addNewContact(Contacts contact){
        if(contactList.contains(contact)){
            System.out.println("This person is in your contacts.");
            return true;
        }else{
            contactList.add(contact);
            return false;
        }
    }

    public boolean updateContact(Contacts contact, Contacts newContact){
        if(contactList.contains(contact)){
            int itemIdx = contactList.indexOf(contact);
            contactList.set(itemIdx, newContact);
            return true;
        }else{
            System.out.println("This user is not in your contacts.");
            return false;
        }
    }

    public boolean removeContact(Contacts contact){
        if(contactList.contains(contact)){
            contactList.remove(contact);
            return true;
        }else{
            System.out.println("This user is not in your contacts.");
            return false;
        }
    }

    public void printContacts(){
        System.out.println("Contact List: ");
        for(int i = 0; i < contactList.size(); i++){
            String contactName = contactList.get(i).getName();
            String contactPN = contactList.get(i).getPhoneNumber();
            System.out.println(i+1 + ".) " + contactName + " " + contactPN);
        }
    }
    //returns index
    public int findContact(String name){
        for(int i = 0; i < contactList.size(); i++ ){
            if(contactList.get(i).name.equals(name)){
                return i;
            }
        }
        return -1;
    }

    public int findContact(Contacts contact){
        for(Contacts i : contactList){
            if(i == contact){
                return contactList.indexOf(i);
            }
        }
        return -1;
    }

    public Contacts queryContact(String name){
        int index = findContact(name);
        if(index != -1) {
            return contactList.get(index);
        }else{
            return null;
        }
    }
}
