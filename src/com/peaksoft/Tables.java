package com.peaksoft;

import java.nio.file.Path;
import static com.peaksoft.Main.gson;

public class Tables {
    public static void tableTruck(Path path) {
        System.out.println("# |Bus               |Driver     |State\n" +
                "_________________________________________");
        Truck[] truck = gson.fromJson(Files.fileRead(path), Truck[].class);
        for (Truck truck1 : truck) {
            System.out.printf("\n%-1s |", truck1.getId());
            System.out.printf("%-18s|", truck1.getName());
            System.out.printf("%-10s |", truck1.getDriver());
            System.out.printf("%-10s |", truck1.getState());

        }
    }

    public static void tableDriver(Path path) {
        System.out.println("# Driver             |Bus\n" +
                "_________________________________________");

        Driver[] drivers = gson.fromJson(Files.fileRead(path), Driver[].class);
        for (Driver driver : drivers) {
            System.out.printf("\n%-1s |", driver.getId());
            System.out.printf("%-18s|", driver.getName());
        }
    }
}
