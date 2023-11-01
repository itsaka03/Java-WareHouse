package com.example.skladovinalichnosti;

import javafx.collections.ObservableList;

public class AdminView {
    String id;
    String name;
    String kolichestvoo;
    String cena;
    String data;
    String email;
    public static void setItems(ObservableList<AdminView> list) {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKolichestvoo() {
        return kolichestvoo;
    }

    public String getCena() {
        return cena;
    }

    public String getData() {
        return data;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public AdminView(String ID,String NAME,String KOLICHESTVO, String CENA, String DATA,String EMAIL) {
        id=ID;
        name=NAME;
        kolichestvoo=KOLICHESTVO;
        cena=CENA;
        data=DATA;
        email=EMAIL;
    }


}
