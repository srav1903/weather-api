package com.cognizant.weatherapi;

public class Weather {
    private int id;
    // create a private variable for date, latitude, longitude, city, state, temerature
    private String date;
    private double latitude;
    private double longitude;
    private String city;
    private String state;
    private double temperature;

    

    // create a constructor for the class
    public Weather(int id, String date, double latitude, double longitude, String city, String state, double temperature) {
        this.id = id;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
        this.temperature = temperature;
    }

    // create getters and setters for the variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    // create a toString method to display the values
    @Override
    public String toString() {
        return "Weather [city=" + city + ", date=" + date + ", id=" + id + ", latitude=" + latitude + ", longitude="
                + longitude + ", state=" + state + ", temperature=" + temperature + "]";
    }



    // Date dNow = new Date( );
    //   SimpleDateFormat ft = 
    //   new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

    //   System.out.println("Current Date: " + ft.format(dNow));


}
