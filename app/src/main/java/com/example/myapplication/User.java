package com.example.myapplication;

public class User {

    private String id;
    private String name;
    private String username;
    private String email;
    private String address;
    private String geo;



    public User(String name,String id,String username,String email,String address,String geo){
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.geo = geo;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getGeo(){
        return geo;
    }

    public void setGeo(String geo){
        this.geo = geo;
    }

}

