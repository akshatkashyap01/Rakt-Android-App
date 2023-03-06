package com.example.rakt.DonorInformation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DonorInformation implements Serializable {


    String name,phone,city,gender,blood_type,image;


    ArrayList<DonorInformation> donorInformation=new ArrayList<>();


    public void setDonorInformation(ArrayList<DonorInformation> donorInformation) {
        this.donorInformation = donorInformation;
    }

    public ArrayList<DonorInformation> getDonorInformation() {
        return donorInformation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
