package com.ablaikhan.phonebook.dao;

import com.ablaikhan.phonebook.models.Contact ;
import org.springframework.stereotype.Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactDAO {
    private static int CONTACTS_COUNT;

    public static final String URL = "jdbc:mysql://localhost:3306/phonebookdb";
    public static final String USERNAME = "Dev";
    public static final String PASSWORD = "1111";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Contact> index() {
        List<Contact> contacts = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM contacts";
            ResultSet resultSet = statement.executeQuery(SQL);

            while ( resultSet.next() ){
                Contact contact = new Contact();

                contact.setId(resultSet.getInt("id"));
                contact.setFirstname(resultSet.getString("firstname"));
                contact.setLastname(resultSet.getString("lastname"));
                contact.setP_number(resultSet.getString("phonenumber"));
                contact.setAdress(resultSet.getString("adress"));

                contacts.add(contact);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contacts;
    }

    public List<Contact> filter(String text) {
        List<Contact> contacts = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String filter = "SELECT * FROM contacts WHERE `id` LIKE \'%" + text + "%\' OR `firstname` LIKE \'%" + text + "%\' OR `lastname` LIKE \'%" + text + "%\' OR `phonenumber` LIKE \'%" + text + "%\' OR `adress` LIKE \'%" + text + "%\';";
            ResultSet resultSet = statement.executeQuery(filter);

            while ( resultSet.next() ){
                Contact contact = new Contact();

                contact.setId(resultSet.getInt("id"));
                contact.setFirstname(resultSet.getString("firstname"));
                contact.setLastname(resultSet.getString("lastname"));
                contact.setP_number(resultSet.getString("phonenumber"));
                contact.setAdress(resultSet.getString("adress"));

                contacts.add(contact);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contacts;
    }



}
