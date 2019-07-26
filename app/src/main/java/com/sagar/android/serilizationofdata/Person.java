package com.sagar.android.serilizationofdata;

public class Person {
    private String name;
    private String contactAddress;
    private int age;

    public Person() {
    }

    public Person(String name, String contactAddress, int age) {
        this.name = name;
        this.contactAddress = contactAddress;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
