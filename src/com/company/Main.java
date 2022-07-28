package com.company;

import com.company.Firm.Dept;
import com.company.Firm.Firm;
import com.company.Firm.Worker;
import com.company.Menu.Display;
import com.company.Menu.Menu;
import com.company.Reports.Report;

import java.io.InvalidObjectException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException, InvalidObjectException {

        Menu menu = new Menu();
        menu.showMenu();

//        Display display = new Display();
//        Serializator s = new Serializator();
//        Scanner in = new Scanner(System.in);

//        List<String> deptsInFirm = new ArrayList<>();
//
//        List<String> ecoWorkers = new ArrayList<>();
//        ecoWorkers.add("Начальник ЭО");
//        ecoWorkers.add("Экономист 1");
//        ecoWorkers.add("Экономист 2");
//        ecoWorkers.add("Ассистент экономиста");
//
//        Dept dep1 = new Dept("Экономический отдел", ecoWorkers);
//
//        Worker w1 = new Worker("Орлов Дмитрий Сергеевич", "03-06-1977", "М", ecoWorkers.get(0), dep1.getNameDept(), " - ", "09-01-1993", 51200);
//        Worker w2 = new Worker("Иванов Иван Иванович", "11-02-1990", "М", ecoWorkers.get(1), dep1.getNameDept(), w1.getFullName(), "01-04-2015", 35600);
//        Worker w3 = new Worker("Симаев Петр Геннадьевич", "23-11-1984", "М", ecoWorkers.get(2), dep1.getNameDept(), w1.getFullName(), "01-04-2006", 35600);
//        Worker w4 = new Worker("Петрова Елена Павловна", "19-08-1997", "Ж", ecoWorkers.get(3), dep1.getNameDept(), w1.getFullName(), "01-04-2020", 22900);
//
//        dep1.addChief(ecoWorkers.get(0), w1);;
//        dep1.addWorker(ecoWorkers.get(1), w2);
//        dep1.addWorker(ecoWorkers.get(2), w3);
//        dep1.addWorker(ecoWorkers.get(3), w4);
//
//        display.showDept(dep1);
//        deptsInFirm.add(dep1.getNameDept());
////        dep1.removeWorker(dep1.getNameDept(), ecoWorkers.get(2));
//
//
//        List<String> engWorkers = new ArrayList<>();
//        engWorkers.add("Главный инженер");
//        engWorkers.add("Мастер участка");
//        engWorkers.add("Инженер сборки");
//        engWorkers.add("Инженер наладки");
//        engWorkers.add("Инженер ремонта");
//        engWorkers.add("Техник");
//
//        Dept dep2 = new Dept("Инженерный отдел", engWorkers);
//        Worker w5 = new Worker("Успенская Алия Львовна", "22-08-1964", "Ж", engWorkers.get(0), dep2.getNameDept(), "-", "01-04-1990", 58903);
//        Worker w6 = new Worker("Козлов Ростислав Александрович", "21-06-1985", "М", engWorkers.get(1), dep2.getNameDept(), w5.getFullName(), "29-02-1997", 43590);
//        Worker w7 = new Worker("Потапов Степан Львович", "26-06-1981", "М", engWorkers.get(2), dep2.getNameDept(), w5.getFullName(), "16-12-1993", 39810);
//        Worker w8 = new Worker("Носова Анастасия Дмитриевна", "16-01-1976", "Ж", engWorkers.get(3), dep2.getNameDept(), w5.getFullName(), "07-01-1998", 39920);
//        Worker w9 = new Worker("Михайлов Егор Александрович", "19-01-1990", "М", engWorkers.get(4), dep2.getNameDept(), w5.getFullName(), "02-11-2011", 32000);
//        Worker w10 = new Worker("Фирсова Вероника Ивановна", "27-05-1999", "Ж", engWorkers.get(5), dep2.getNameDept(), w5.getFullName(), "15-08-2021", 18500);
//
//        dep2.addChief(engWorkers.get(0),w5);
//        dep2.addWorker(engWorkers.get(1),w6);
//        dep2.addWorker(engWorkers.get(2),w7);
//        dep2.addWorker(engWorkers.get(3),w8);
//        dep2.addWorker(engWorkers.get(4),w9);
//        dep2.addWorker(engWorkers.get(5),w10);
//        display.showDept(dep2);
//
//        deptsInFirm.add(dep2.getNameDept());
//
//
//
////        display.showResultSearchByNameDept(f,in);
////        display.showResultSearchByNameChief(f,in);
//
//        List<String> adminstration = new ArrayList<>();
//        adminstration.add("Директор");
//        adminstration.add("Заместитель директора");
//        adminstration.add("Советник директора");
//
//        Dept dep3 = new Dept("Руководство", adminstration);
//        Worker w11 = new Worker("Максимов Владислав Эмильевич","11-02-1974", "М", adminstration.get(0),dep3.getNameDept(),"-", "22-01-1997", 125600);
//        Worker w12 = new Worker("Федоров Кирилл Артёмович","16-11-1980", "М", adminstration.get(1),dep3.getNameDept(), w11.getFullName(), "18-03-2006", 98000);
//        Worker w13 = new Worker("Блинов Артём Ярославович","10-12-1982", "М", adminstration.get(2),dep3.getNameDept(), w11.getFullName(), "02-06-2010", 93500);
//
//        deptsInFirm.add(dep3.getNameDept());
//        dep3.addChief(adminstration.get(0),w11);
//        dep3.addWorker(adminstration.get(1),w12);
//        dep3.addWorker(adminstration.get(2),w13);
//
//        display.showDept(dep3);
//
//        Firm f = new Firm("ООО \"Рога и копыта\"", deptsInFirm);
//
//        f.addDept(dep3.getNameDept(),dep3);
//        f.addDept(dep1.getNameDept(),dep1);
//        f.addDept(dep2.getNameDept(),dep2);
//
//
//        Report r = new Report();
//        r.showOrgStructure(f);
//
//        r.showAverageSalaryByFirm(f);
//
//        r.showAverageSalaryByDept(f);
//
//        r.showTop10Salaries(f);
//
//        r.showTop10Stages(f);
//
//        s.serialization(f);


//        Report r = new Report();
//        Firm f = s.deserialization();
//        System.out.println(s.deserialization());
//
//        System.out.println(s.deserialization().getDepts());
//
//        r.showTop10Stages(f);
//        r.showOrgStructure(f);
//        r.showAverageSalaryByDept(f);
//        r.showAverageSalaryByFirm(f);
//
//
//        f.searchDeptByName("Руководство").addWorker("Советник 2",menu.createWorker(in,"Советник 2",f.searchDeptByName("Руководство")));
//
//        Dept d = f.searchDeptByName("Руководство");
//
//        f.addDept("Руководство", d);
//
//        r.showTop10Stages(f);
//        r.showOrgStructure(f);
//        r.showAverageSalaryByDept(f);
//        r.showAverageSalaryByFirm(f);

        // переписать статические мапы, сделать добавление в них данных на этапе добавления отделов в фирму
        // после десериализации, чтобы обратиться к отделу, необходимо использовать метод поиска отдела по названию
        // перепроверить десериализацию

    }
}