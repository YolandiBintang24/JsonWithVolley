package com.example.myapplication;

public class Kontak {
    private String id;
    private String name;
    private String email;
    private String alamat;
    private String nohp;

    public Kontak(String id,String name,String email,String alamat,String nohp){
        this.id = id;
        this.name = name;
        this.email = email;
        this.alamat = alamat;
        this.nohp = nohp;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


    public String getAlamat(){
        return alamat;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getNohp(){
        return nohp;
    }

    public void setNohp(String nohp){
        this.nohp = nohp;
    }

}
