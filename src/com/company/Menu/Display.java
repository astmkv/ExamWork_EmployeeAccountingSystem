package com.company.Menu;

import com.company.Firm.Dept;
import com.company.Firm.Firm;
import com.company.Firm.Worker;

import java.util.Map;

public class Display {

    // вывод отдела
    public void showDept(Dept dep) {
        System.out.println(dep.getNameDept());
        for (Map.Entry<String, Worker> i : dep.getEmpWithPosts().entrySet()) {
            String key = i.getKey();
            Worker value = i.getValue();
            System.out.println(key + ": " + value.getFullName());
        }
        System.out.println();
    }

    // вывод результатов поиска сотрудника в отделе по должности
    public void showResultSearchByPost(Dept dep, String post) {
        if (dep.searchByPostInDept(post) != null) {
            System.out.println("Поиск прошел успешно: " + dep.searchByPostInDept(post).getFullName());
        }
    }

    // вывод результатов поиска сотрудника в отделе по ФИО
    public void showResultSearchByFullName(Dept dep, String name) {

        if (dep.searchByNameInDept(name) != null) {
            System.out.println("Поиск прошел успешно: " + name + " работает в отделе " + "\"" + dep.getNameDept() + "\"");

        }
    }

    // вывод результатов поиска отдела по названию
    public void showResultSearchByNameDept(Firm f, String nameDept) {
        if (f.searchDeptByName(nameDept) != null) {
            System.out.println("Поиск прошел успешно: " + f.searchDeptByName(nameDept).nameDeptToString());
            showDept(f.searchDeptByName(nameDept));

        }
    }

    // вывод результатов поиска отдела по ФИО начальника
    public void showResultSearchByNameChief(Firm f, String nameChief) {
        if (f.searchDeptByChief(nameChief) != null) {
            System.out.println("Поиск прошел успешно: " + f.searchDeptByChief(nameChief).nameDeptToString());
        }
    }

}