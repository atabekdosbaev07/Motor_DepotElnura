package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson gson = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH_TRUCKS = Paths.get("./Truck.json");
    public static final Path WRITE_PATH_DRIVERS = Paths.get("./Drive.json");


    public static void main(String[] args) {
	// write your code here

        Truck[] trucks = {
                Truck.met(1,"Renault Magnum","",State.BASE),
                Truck.met(2,"Volvo","",State.BASE),
                Truck.met(3,"DAF XT","",State.BASE)
        };

        Driver [] drivers = {
                Driver.met2(1,"Petr"),
                Driver.met2(2 ,"Askar"),
                Driver.met2(3,"Uson")
        };

        tableTruck(WRITE_PATH_TRUCKS);
        System.out.println("\n");
        tableDriver(WRITE_PATH_DRIVERS);

        System.out.println("\n\nЗавершить программу 0");
        System.out.println("выберите грузовик 1, 2, 3");

        writeFile(gson.toJson(trucks), WRITE_PATH_TRUCKS);
        writeFile(gson.toJson(drivers),WRITE_PATH_DRIVERS);
//        System.out.println(fileRead(WRITE_PATH_TRUCKS));
//        System.out.println(fileRead(WRITE_PATH_DRIVERS));



    }
    public static void tableTruck(Path path){
        System.out.println("# |Bus               |Driver     |State\n" +
                "_________________________________________" );
        Truck [] truck = gson.fromJson(fileRead(path), Truck[].class);
        for(Truck truck1:truck){
            System.out.printf("\n%-1s |",truck1.getId());
            System.out.printf("%-18s|",truck1.getName());
            System.out.printf("%-10s |",truck1.getDriver());
            System.out.printf("%-10s |",truck1.getState());

        }
    }

    public static void tableDriver(Path path){
        System.out.println("# Driver             |Bus\n" +
                "_________________________________________" );

        Driver [] drivers = gson.fromJson(fileRead(path), Driver[].class);
        for(Driver driver:drivers){
            System.out.printf("\n%-1s |",driver.getId());
            System.out.printf("%-18s|",driver.getName());
        }
    }


    private static void writeFile(String object,Path path){
        try{
            Files.writeString(Paths.get(String.valueOf(path)),object,
                    StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        }catch (IOException e){
            System.out.println( e.getMessage());
        }
    }
    private static String fileRead(Path path){
        StringBuilder json = new StringBuilder();
        try(FileReader reader = new FileReader(String.valueOf(path));){
            int a;
            while ((a = reader.read()) != -1){
                json.append ((char) a);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return json.toString();
    }
}











