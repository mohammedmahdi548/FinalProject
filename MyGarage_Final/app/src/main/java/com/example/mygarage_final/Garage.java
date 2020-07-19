package com.example.mygarage_final;

public class Garage {
    private String GarageName;
    private String phone;
    private String place;



    public Garage() {
}

    public Garage(String garageName, String phone, String place) {
        GarageName = garageName;
        this.phone = phone;
        this.place = place;
    }

    public String getGarageName() {
        return GarageName;
    }

    public void setGarageName(String garageName) {
        GarageName = garageName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


}
