package com.company.Reports;

import com.company.Firm.Dept;
import com.company.Firm.Firm;
import com.company.Firm.Worker;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class Report implements Serializable {


    // структура организации
    public void showOrgStructure(Firm f) {
        System.out.println("СТРУКТУРА ОРГАНИЗАЦИИ: ");
        for (Map.Entry<String, Dept> i : f.getDepts().entrySet()) {
            System.out.println(i.getValue().nameDeptToString());
            System.out.println("Число сотрудников: " + i.getValue().getEmpWithPosts().size() + "\n");
        }
    }

    // средняя з/плата по отделу
    private double getAverageSalaryByDept(Dept d) {
        double sum = 0;
        for (Map.Entry<String, Worker> i : d.getEmpWithPosts().entrySet()) {
            sum += i.getValue().getSalary();
        }
        return sum / d.getEmpWithPosts().size();
    }


    public void showAverageSalaryByDept(Firm f) {

        System.out.println("СРЕДНЯЯ ЗАРАБОТНАЯ ПЛАТА ПО ОТДЕЛАМ: ");
        for (Map.Entry<String, Dept> i : f.getDepts().entrySet()) {
            System.out.println(i.getKey() + ": " + getAverageSalaryByDept(i.getValue()));
        }
        System.out.println();
    }

    //средняя з/плата по организации
    private double getAverageSalaryByFirm(Firm f) {
        double sum = 0;
        for (int i : f.getSalaries()) {
            sum += i;
        }
        return sum / f.getSalaries().size();
    }

    public void showAverageSalaryByFirm(Firm f) {
        System.out.println("СРЕДНЯЯ ЗАРАБОТНАЯ ПЛАТА ПО ОРГАНИЗАЦИИ: " + getAverageSalaryByFirm(f)  + "\n");
    }

    // получить ТОП-10 сотрудников по заработной плате
    private Map<String, Integer> getTop10Salaries(Firm f) {

        Map sortedEmpWithSal = f.getEmpWithSal().entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        return sortedEmpWithSal;
    }

    // вывести ТОП-10 сотрудников по заработной плате
    public void showTop10Salaries(Firm f) {
        System.out.println("ТОП-10 САМЫХ ДОРОГИХ СОТРУДНИКОВ ПО ЗАРАБОТНОЙ ПЛАТЕ:");
        int count = 0;
        for (Map.Entry<String, Integer> i : getTop10Salaries(f).entrySet()) {
            count++;
            System.out.println(i.getKey() + ": " + i.getValue());
            if (count >= 10) break;
        }
        System.out.println();
    }

    // преобразователь даты
    private int getStage(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse(date);

        long res = new  Date().getTime() - date1.getTime();
        int stage = (int)(res / 1000 / 60 / 60 / 24 / 365.25);
        return stage;
    }


    // получить ТОП-10 сотрудников по кол-ву лет работы в организации
    private Map<String, Integer> getTop10Stages(Firm f) throws ParseException {

        Map <String, Integer> castEmpWithDates = new HashMap<>();
        for (Map.Entry<String, String> i : f.getEmpWithDates().entrySet()) {
            int stage = getStage(i.getValue());
            castEmpWithDates.put(i.getKey(),stage);
        }

        Map sortedEmpWithStages = castEmpWithDates.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        return sortedEmpWithStages;
    }

    // вывести ТОП-10 сотрудников по кол-ву лет работы в организации
    public void showTop10Stages(Firm f) throws ParseException {
        System.out.println("ТОП-10 САМЫХ ПРЕДАННЫХ СОТРУДНИКОВ ПО КОЛ-ВУ ЛЕТ РАБОТЫ В ОРГАНИЗАЦИИ:");
        int count = 0;
        for (Map.Entry<String, Integer> i : getTop10Stages(f).entrySet()) {
            count++;
            System.out.println(i.getKey() + ": " + i.getValue());
            if (count >= 10) break;
        }
        System.out.println();
    }


}