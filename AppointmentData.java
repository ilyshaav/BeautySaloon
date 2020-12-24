package com.example.beaty_saloon;

public class AppointmentData {
    String login;
    int id;
    int sumcost;
    String[] servises;
    String getLogin(){
        return this.login;
    }
    int getId(){
        return this.id;
    }
    String[] getServises(){
        return this.servises;
    }

    public int getSumcost() {
        return sumcost;
    }

    String Serealization(){
        String str= "";
        str+=this.login;
        str+=this.id;
        str+=this.sumcost;
        for (int i=0; i<this.servises.length; i++){
            str+= this.servises[i];;
        }
        return str;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setServises(String[] servises) {
        this.servises = servises;
    }

    public void setSumcost(int sumcost) {
        this.sumcost = sumcost;
    }
    AppointmentData(String login, int id, int sumcost, String[] servises){
        this.servises= servises;
        this.id=id;
        this.login = login;
        this.sumcost=sumcost;

    }
}
