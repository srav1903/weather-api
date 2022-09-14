
-- create a database and table named weather
    -- public Weather(int id, String date, double latitude, double longitude, String city, String state, double temperature) {
    --     this.id = id;
    --     this.date = date;
    --     this.latitude = latitude;
    --     this.longitude = longitude;
    --     this.city = city;
    --     this.state = state;
    --     this.temperature = temperature;
    -- }

-- create a database and table named weather
CREATE DATABASE weather;
CREATE TABLE weather (
    id INT,
    date VARCHAR(255),
    latitude DOUBLE,
    longitude DOUBLE,
    city VARCHAR(255),
    state VARCHAR(255),
    temperature DOUBLE
);
-- add some sample data to the table
INSERT INTO weather VALUES (1, '2019-01-01', 40.7128, 74.0060, 'New York', 'NY', 32.0);
INSERT INTO weather VALUES (2, '2019-01-02', 40.7128, 74.0060, 'New York', 'NY', 35.0);
INSERT INTO weather VALUES (3, '2019-01-03', 40.7128, 74.0060, 'New York', 'NY', 28.0);
INSERT INTO weather VALUES (4, '2019-01-04', 40.7128, 74.0060, 'New York', 'NY', 25.0);
INSERT INTO weather VALUES (5, '2019-01-05', 40.7128, 74.0060, 'New York', 'NY', 30.0);
INSERT INTO weather VALUES (6, '2019-01-06', 40.7128, 74.0060, 'New York', 'NY', 35.0);
INSERT INTO weather VALUES (7, '2019-01-07', 40.7128, 74.0060, 'New York', 'NY', 40.0);
INSERT INTO weather VALUES (8, '2019-01-08', 40.7128, 74.0060, 'New York', 'NY', 45.0);
INSERT INTO weather VALUES (9, '2019-01-09', 40.7128, 74.0060, 'New York', 'NY', 50.0);
INSERT INTO weather VALUES (10, '2019-01-10', 40.7128, 74.0060, 'New York', 'NY', 55.0);