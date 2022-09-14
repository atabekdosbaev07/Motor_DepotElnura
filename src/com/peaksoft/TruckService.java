package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import static com.peaksoft.Main.*;

public class TruckService {
        static String truckName;
        static String driverName;

        static Driver driver = new Driver();
        static String aa;
    public static void change(Truck[] truck , Driver[] driver){
        for (int i = 0; i < truck.length; i++) {
            int truckNum = scan.nextInt();
            if (truckNum == 0) {
                break;
            }
            Truck choose = new Truck();
            for (Truck truck1 : truck) {
                if (truck1.getId() == truckNum) {
                    choose = truck1;
                }
            }
            System.out.println(choose);
            System.out.println("\n1  Выбрать водителя \n" +
                    "2  Отправить на маршрут " +
                    "\n3  Отправить на ремонт " +
                    "\n0  Завершить");
            int actionNum = scan.nextInt();
            if (actionNum == 0) {
                break;
            }
            switch (actionNum) {
                case 1 -> changeDriver(choose, driver);
                case 2 -> startDrive(choose, driver);
                case 3 -> startRepair(choose);
            }
        }
    }
    public static void startRepair(Truck truck){
        if(truck.getState().equals(State.REPAIR)){
            System.out.println("Грузовик уже в ремонте");
        } else {
            if(truck.getState().equals(State.BASE)){
                System.out.println("грузовик " + truck.getName() + " отправлен на ремонт");
                truck.setState(State.REPAIR);
                System.out.println(truck);
                System.out.println("Выберите грузовик 1 2 3 или завершить 0");
            }
        }
    }
    public static void startDrive(Truck truck,Driver[] drivers){

        if (truck.getState().equals(State.ROUTE)) {
            System.out.println("Грузовик уже в пути");
        } else if (truck.getState().equals(State.ROUTE)) {
            System.out.println("грузовик " + truck.getName() + " отправлен на ремонт");
            truck.setState(State.REPAIR);
            System.out.println(truck);
        }else if (truck.getState().equals(State.REPAIR)) {
            System.out.println("грузовик " + truck.getName() + " отправлен на базу");
            truck.setState(State.BASE);
            System.out.println(truck);
        }  else {
            if(truck.getState().equals(State.BASE)){
                if(truck.getDriver().equals("")){
                    System.out.println("<<С начала выберите водителя>>");
                    System.out.println("Выберите грузовик 1 2 3 или завершить 0");
                }
            }
            for (Driver driver: drivers) {
                if(truck.getState().equals(State.ROUTE) && truck.getDriver().equals(driver.getName())){
                    System.out.println("Грузовик в пути, невозможно сменить водителя");
                }
                if (truck.getState().equals(State.BASE) && truck.getDriver().equals(driver.getName())) {
                    System.out.println("грузовик " + truck.getName() + " успешно вышел в путь");
                    truck.setState(State.ROUTE);
                    System.out.println(truck);
                    System.out.println("Выберите грузовик 1 2 3 или завершить 0");
                }

            }
        }
    }

    public static void changeDriver(Truck truck, Driver[] drivers){
        Scanner scan = new Scanner(System.in);
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
        System.out.println("Выберите водителя по номеру");
        int aa = scan.nextInt();

        if (truck.getState().equals(State.ROUTE)) {
            System.out.println("Грузовик в пути Нельзя сменить водителя");
        } else if (truck.getState().equals(State.REPAIR)) {
            System.out.println("Грузовик на ремонте Нельзя сменить водителя");
        } else {
            for (Driver driver : drivers) {
                if (truck.getState().equals(State.BASE) && truck.getDriver().equals(driver.getName())) {
                    System.out.println("грузовик " + truck.getName() + " успешно вышел в путь");
                    truck.setDriver(driver.getName());
                    System.out.println(truck);
                    System.out.println("Выберите грузовик 1 2 3 или завершить 0");
                }
                if (driver.getId() == aa ) {
                    truck.setDriver(driver.getName());
                    System.out.println("Теперь грузовиком " + truck.getName() +
                            "\nведет водитель " + driver.getName());
                    System.out.println(truck);
                    System.out.println("Выберите грузовик 1 2 3 или завершить 0");
                    break;
                }

            }
        }
        if (truck.getDriver().equals(" ")) {
            System.out.println("Нет свободных");
        }
    }




}


