package com.java.practice.learning;

import java.util.Scanner;

public class Main {
    private static MobilePhone iphone = new MobilePhone("673-338-9832");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a 1 to begin the app");
        int s = scanner.nextInt();
        scanner.nextLine();
        if (s == 1) {
            boolean programOn = true;
            while (programOn) {
                System.out.println("Welcome");
                System.out.println("Please Choose an option from below");
                System.out.println("Press 0: Quit");
                System.out.println("Press 1: Add New Contact");
                System.out.println("Press 2: Update Contact");
                System.out.println("Press 3: Remove Contact");
                System.out.println("Press 4: Find Contact");
                System.out.println("Press 5: Show All Contacts");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 0:
                        programOn = false;
                    case 1:
                        System.out.println("Contact Name: ");
                        String name = scanner.next();
                        scanner.nextLine();
                        System.out.println("Contact Phone Number:");
                        String pN = scanner.next();
                        scanner.nextLine();
                        Contacts contact = createContact(name, pN);
                        iphone.addNewContact(contact);
                        break;
                    case 2:
                        //Request contact Name
                        System.out.println("Contact Name: ");
                        name = scanner.next();
                        scanner.nextLine();
                        contact = iphone.queryContact(name);

                        //Update Information
                        if (contact != null) {
                            System.out.println("Update Contact Name: ");
                            String newName = scanner.next();
                            scanner.nextLine();
                            System.out.println("Update Contact Phone Number:");
                            String newPN = scanner.next();
                            scanner.nextLine();
                            Contacts modifiedContact = createContact(newName, newPN);
                            iphone.updateContact(contact, modifiedContact);
                        } else {
                            System.out.println("Sorru");
                        }
                        break;
                    case 3:
                        System.out.println("Contact Name: ");
                        name = scanner.next();
                        scanner.nextLine();
                        contact = iphone.queryContact(name);
                        if (contact != null) {
                            iphone.removeContact(contact);
                        } else {
                            System.out.println("Contact not found");
                        }
                        break;
                    case 4:
                        System.out.println("Contact Name: ");
                        name = scanner.next();
                        scanner.nextLine();
                        contact = iphone.queryContact(name);
                        if (contact != null) {
                            System.out.println(contact.getName());
                            System.out.println(contact.getPhoneNumber());
                        } else {
                            System.out.println("Contact not found");
                        }
                        break;
                    case 5:
                        iphone.printContacts();

                }
            }
        }else{
            System.out.println("Good Bye");
        scanner.close();
        System.out.println("Adios");
        }
    }



    public static Contacts createContact(String name, String phoneNumber){
        Contacts contact = new Contacts(name, phoneNumber);
        return contact;
    }
}
