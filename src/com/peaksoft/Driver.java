package com.peaksoft;

public class Driver {
    private int id;
    private String name;
    private String truckName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public static Driver met2(int id, String name,String truckName){
        Driver driver = new Driver();
        driver.id = id;
        driver.name = name;
        driver.truckName = truckName;
        return driver;
    }

    @Override
    public String toString() {
        return  id + "  | " + name + " | " + truckName;
    }
}
