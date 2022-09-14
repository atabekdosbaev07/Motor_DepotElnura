package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson gson = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH_TRUCKS = Paths.get("./Truck.json");
    public static final Path WRITE_PATH_DRIVERS = Paths.get("./Drive.json");
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Truck[] trucks = {
                Truck.met(1, "Renault Magnum", "", State.BASE),
                Truck.met(2, "Volvo", "", State.BASE),
                Truck.met(3, "DAF XT", "", State.BASE)
        };

        Driver[] drivers = {
                Driver.met2(1, "Petr", " "),
                Driver.met2(2, "Askar", " "),
                Driver.met2(3, "Uson", " ")
        };


        Tables.tableTruck(WRITE_PATH_TRUCKS);
        System.out.println("\n");
        Tables.tableDriver(WRITE_PATH_DRIVERS);

        System.out.println("\n\nЗавершить программу 0");
        System.out.println("выберите грузовик 1, 2, 3");
        Files.writeFile(gson.toJson(trucks), WRITE_PATH_TRUCKS);
        Files.writeFile(gson.toJson(drivers), WRITE_PATH_DRIVERS);


        Truck[] truck = gson.fromJson(Files.fileRead(WRITE_PATH_TRUCKS), Truck[].class);
        Driver[] driver = gson.fromJson(Files.fileRead(WRITE_PATH_DRIVERS), Driver[].class);
        TruckService.change(truck,driver);


    }
}











