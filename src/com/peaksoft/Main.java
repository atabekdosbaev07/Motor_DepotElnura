package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson gson = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./Truck.gson");

    public static void main(String[] args) {
	// write your code here

        Truck[] trucks = {
                Truck.met(1,"Renault Magnum","",State.BASE),
                Truck.met(2,"Volvo","",State.BASE),
                Truck.met(3,"DAF XT","",State.BASE)
        };

        System.out.println("# |Bus |Driver |State\n\n" +
                "__+_______+_______+______\n\n" +
                "1| Renault|      |On Base\n" +
                "2| Volvo|        |On Base\n" +
                "3| Dav xt|       |On Base\n");

        String allTrucks = gson.toJson(trucks);
       // System.out.println(all);
        writeFile(allTrucks);

        System.out.println(fileRead());

    }

    private static void writeFile(String object){
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try{
            Files.writeString(write,object,
                    StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        }catch (Exception e){
            e.getMessage();
        }
    }
    private static String fileRead(){
        String json = "";
        try{
            FileReader reader = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = reader.read()) != -1){
                json += (char)a;
            }
        }catch (Exception e){
            e.getMessage();
        }
        return json;
    }
}











