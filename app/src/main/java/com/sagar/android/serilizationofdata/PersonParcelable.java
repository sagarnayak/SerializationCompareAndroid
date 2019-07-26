package com.sagar.android.serilizationofdata;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonParcelable implements Parcelable {
    private String name;
    private String contactAddress;
    private int age;

    public PersonParcelable() {
    }

    public PersonParcelable(String name, String contactAddress, int age) {
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

    public static Creator<PersonParcelable> getCREATOR() {
        return CREATOR;
    }

    protected PersonParcelable(Parcel in) {
        name=in.readString();
        contactAddress=in.readString();
        age=in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(contactAddress);
        dest.writeInt(age);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PersonParcelable> CREATOR = new Creator<PersonParcelable>() {
        @Override
        public PersonParcelable createFromParcel(Parcel in) {
            return new PersonParcelable(in);
        }

        @Override
        public PersonParcelable[] newArray(int size) {
            return new PersonParcelable[size];
        }
    };
}
