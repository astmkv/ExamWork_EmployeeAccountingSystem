package com.company.Firm;

import java.io.Serializable;
import java.util.*;

public class Firm implements Serializable {

    transient Scanner in = new Scanner(System.in);

    private String nameFirm;                                      // название организации


    public Map<String, Dept> depts = new LinkedHashMap<>();       // коллекция отделов

    public Map<String, Dept> getDepts() {
        return depts;
    }

    public ArrayList<Integer> getSalaries() {
        return salaries;
    }

    public Map<String, Integer> getEmpWithSal() {
        return empWithSal;
    }

    public Map<String, String> getEmpWithDates() {
        return empWithDates;
    }

    private Map<String, Integer> empWithSal = new LinkedHashMap<>();

    private ArrayList<Integer> salaries = new ArrayList<>();

    private Map<String, String> empWithDates = new LinkedHashMap<>();

    // создание организации с "пустыми" отделами (только названия отделов)

    public Firm(String nameFirm, List<String> nameDept) {
        this.nameFirm = nameFirm;
        for (String item : nameDept) {
            depts.put(item, null);
        }
    }

    // добавление отдела в организацию
    public boolean addDept(String nameDept, Dept d) {
        // проверка существования отдела
        if (depts.containsKey(nameDept)) {
            depts.put(nameDept, d);
            for (Map.Entry<String, Worker> i : d.getEmpWithPosts().entrySet()) {
                empWithSal.put(i.getValue().getPost() + " " + i.getValue().getFullName(), i.getValue().getSalary());
                empWithDates.put(i.getValue().getPost() + " " + i.getValue().getFullName(), i.getValue().getStartDate());
                salaries.add(i.getValue().getSalary());
            }
            return true;
        }
        return false;
    }

    // удаление отдела (вспомогательная функция)
    public boolean removeDept(String nameFirm, String nameDept) {
        if (depts.containsKey(nameFirm)) {                                   // проверка существования организации
            if (depts.containsKey(nameDept)) {                               // проверка существования отдела
                depts.remove(nameDept);                                     // удаление отдела из организации
                return true;
            }
        }
        return false;
    }

    // поиск отдела по названию
    public Dept searchDeptByName(String nameDept) {
        for (Map.Entry<String, Dept> i : depts.entrySet()) {
            if (nameDept.equals(i.getKey())) {
                return i.getValue();
            }
        }
        return null;
    }

    // поиск отдела по ФИО начальника
    public Dept searchDeptByChief(String nameChief) {
        for (Map.Entry<String, Dept> i : depts.entrySet()) {
            if (nameChief.equals(i.getValue().getBoss())) {
                return i.getValue();
            }
        }
        return null;
    }


}
