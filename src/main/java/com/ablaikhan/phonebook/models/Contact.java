package com.ablaikhan.phonebook.models;

public class Contact {
    private int id;
    private String f_name;
    private String l_name;
    private String p_number;
    private String adress;

    public Contact(String f_name, String l_name, String p_number, String adress) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.p_number = p_number;
        this.adress = adress;
    }

    public Contact() {}

    public int getId() {
        return id;
    }

    public void setId(int id)  {
        this.id = id;
    }

    public String getFirstname(){
        return f_name;
        }

    public String getLastname(){
        return l_name;
        }

    public String getP_number(){
        return p_number;
        }

    public String getAdress(){
        return adress;
        }

    public void setFirstname(String f_name){
        this.f_name = f_name;
        }

    public void setLastname(String l_name){
        this.l_name = l_name;
        }

    public void setP_number(String p_number){
        this.p_number = p_number;
        }

    public void setAdress(String adress){
        this.adress = adress;
        }
}
