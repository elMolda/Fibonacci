package com.example.fibonacci;

public class Country {
    private String capital;
    private String name;
    private String int_name;
    private String code;

    public Country(String capital,String name,String int_name,String code) {
        this.capital = capital;
        this.name = name;
        this.int_name = int_name;
        this.code = code;
    }

    public Country(){

    }

    @Override
    public String toString() {
        return this.name+" "+this.capital+" "+this.int_name+" "+this.code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInt_name() {
        return int_name;
    }

    public void setInt_name(String int_name) {
        this.int_name = int_name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

