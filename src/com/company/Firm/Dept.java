package com.company.Firm;

import java.io.Serializable;
import java.util.*;

// класс отдел
public class Dept implements Serializable {


    public String getNameDept() {
        return nameDept;
    }

    public void setNameDept(String nameDept) {
        this.nameDept = nameDept;
    }

    private String nameDept;

    public Map<String, Worker> empWithPosts = new LinkedHashMap<>();

    public Map<String, Worker> getEmpWithPosts() {
        return empWithPosts;
    }


    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    private String boss;

    // создание отдела с "пустыми" сотрудниками
    public Dept(String nameDept, List<String> namePost) {
        this.nameDept = nameDept;
        for (String item : namePost) {
            empWithPosts.put(item, null);
        }
    }

    public boolean addChief(String namePost, Worker w) {
        // проверка существования должности
        if(empWithPosts.containsKey(namePost)){
            empWithPosts.put(namePost, w);
            setBoss(w.getFullName());
            return true;
        } return false;
    }

    // добавление сотрудника в отдел
    public boolean addWorker(String namePost, Worker w) {
        // проверка существования должности
        if(empWithPosts.containsKey(namePost)){
            empWithPosts.put(namePost, w);
            return true;
        } else empWithPosts.put(namePost, w);
        System.out.println("В отдел " + namePost + " добавлена новая должность!");
            return false;
    }

    // НУЖНО ДОБАВИТЬ ДОБАВЛЕНИЕ ПОЛЕЙ ЗП И СТАЖ ПРИ ДОБАВЛЕНИИ СОТРУДНИКА В ОТДЕЛ В ТОМ ЧИСЛЕ

    // увольнение сотрудника
    public boolean removeWorker(String nameDept,String namePost){
        if (empWithPosts.containsKey(nameDept)){                            // проверка существования отдела
            if (empWithPosts.containsKey(namePost)){                        // проверка существования должности
                empWithPosts.remove(namePost);                              // увольняем сотрудника с должности
                empWithPosts.put(namePost, null);                           // добавляем "пустого" сотрудника - открытая вакансия
                return true;
            }
        } return false;
    }

    // поиск сотрудника по ФИО в отделе
    public Worker searchByNameInDept(String nameWorker) {
        for (Map.Entry<String, Worker> i : empWithPosts.entrySet()) {
            if (nameWorker.equals(i.getValue().getFullName())) {
                return i.getValue();
            }
        } return null;
    }

    // поиск сотрудника по должности в отделе
    public Worker searchByPostInDept(String namePost) {
        for (Map.Entry<String, Worker> i : empWithPosts.entrySet()) {
            if (namePost.equals(i.getKey())) {
                return i.getValue();
            }
        } return null;
    }

    @Override
    public String toString() {
        return nameDept +
                "\nНачальник: " + boss +
                "\nСотрудники: " + empWithPosts.toString();
    }


    public String nameDeptToString() {
        return nameDept +
                "\nНачальник: " + boss;
    }
}


// методы:
// добавление "конкретного" сотрудника                  +
// увольнение сотрудника                                +
// поиск по ФИО, должности                              + (НАДО ПЕРЕПРОВЕРИТЬ И ДОДЕЛАТЬ!!!!!!)
// поиск по названию отдела, ФИО начальника


// реализация toString() для отдела, будет обращаться к методу nameToString() класса Worker


// отдельный класс для интерфейса меню
// абстрактный класс - Сериализатор
// класс доступ с наследованием: по желанию

// десериализация из файла, для последующей работы с объектами
