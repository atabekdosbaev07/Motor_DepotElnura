package com.peaksoft;

public class Truck {

    private int id;
    private String name;
    private String driver;
    private State state;

    public Truck(){}

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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static Truck met(int id, String name, String driver, State state) {
        Truck truck = new Truck();
        truck.id = id;
        truck.name = name;
        truck.driver = driver;
        truck.state = state;
        return truck;
    }

    @Override
    public String toString(){
        return " " + id +
                " | " + name +
                " | " + driver +
                " | " + state;
    }
}

enum State{
    BASE,
    REMOTE,
    REPAIR;
}
