package com.cognizant.weatherapi;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    // create a static list of sample weather data
    private static List<Weather> weatherList = new ArrayList<Weather>();

    // static {
    //     // add sample data to the list
    //     weatherList.add(new Weather(1, "2020-01-01", 40.7128, -74.0060, "New York", "NY", 32.0));
    //     weatherList.add(new Weather(2, "2020-01-02", 40.7128, -74.0060, "New York", "NY", 35.6));
    //     weatherList.add(new Weather(3, "2020-01-03", 40.7128, -74.0060, "New York", "NY", 28.9));
    //     weatherList.add(new Weather(4, "2020-01-04", 40.7128, -74.0060, "New York", "NY", 18.3));
    //     weatherList.add(new Weather(5, "2020-01-05", 40.7128, -74.0060, "New York", "NY", 12.5));
    //     weatherList.add(new Weather(6, "2020-01-06", 40.7128, -74.0060, "New York", "NY", 7.2));
    //     weatherList.add(new Weather(7, "2020-01-07", 40.7128, -74.0060, "New York", "NY", 2.3));
    //     weatherList.add(new Weather(8, "2020-01-08", 40.7128, -74.0060, "New York", "NY", -2.1));
    // }

    // create a method to get the weather data
    public List<Weather> getWeatherData() {

        // connect to database using mysql driver and retrieve data from weather table
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from weather");
            while (rs.next()) {
                weatherList.add(new Weather(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getString(5),
                        rs.getString(6), rs.getDouble(7)));
            }
            con.close();
        } catch (Exception e) {
            // print something
            System.out.println(e);
        }
        // print something
        System.out.println("Weather data retrieved from database");
        return weatherList;
    }    

    // create a method to get the weather data by id
    public Weather getWeatherDataById(int id) {
        // connect to db and retrieve weather data from the weather table based on id
        Weather weather = null;
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from weather where id = " + id);
            while (rs.next()) {
                weather = new Weather(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getString(5),
                        rs.getString(6), rs.getDouble(7));
            }
            con.close();
            return weather;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }

    // create a method to add the weather data
    public void addWeatherData(Weather weather) {

        // connect to db and insert weather data into the weather table
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather", "root", "root");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into weather values (" + weather.getId() + ", '" + weather.getDate() + "', "
                    + weather.getLatitude() + ", " + weather.getLongitude() + ", '" + weather.getCity() + "', '"
                    + weather.getState() + "', " + weather.getTemperature() + ")");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // create a method to delete the weather data
    public boolean deleteWeatherData(int id) {
        // check if id is there
        if (getWeatherDataById(id) == null) {
            return false;
        }

        // connect to db and delete weather data from the weather table based on id
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather", "root", "root");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from weather where id = " + id);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
