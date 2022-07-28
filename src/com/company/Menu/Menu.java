package com.company.Menu;

import com.company.Firm.Dept;
import com.company.Firm.Firm;
import com.company.Reports.Report;
import com.company.Serializator;
import com.company.Firm.Worker;

import java.io.InvalidObjectException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static final String Login = "client";
    private static final String Password = "00000";
    static String input;
    static int select;
    Report r = new Report();
    Firm f;
    Serializator s = new Serializator();
    Display d = new Display();

    public void showMenu() throws ParseException, InvalidObjectException {
        Scanner in = new Scanner(System.in);
        String login, pass;
//        String input;
        System.out.println();
//        int select;


        for (int i = 1; i <= 3; i++) {                                   ///?????
            System.out.println("Вход в систему");
            System.out.print("Логин: ");
            login = in.nextLine();
            System.out.print("Пароль: ");
            pass = in.nextLine();
            if (!login.equals(Login) || !pass.equals(Password)) {
                System.out.println("Ошибка авторизации. Осталось " + (3 - i) + " попытки.");
            } else {
                System.out.println("ГЛАВНОЕ МЕНЮ:");
                System.out.println("1 - Создать новую организацию\n" +
                        "2 - Загрузить организацию из файла\n" +
                        "3 - Выход");

                select = in.nextInt();
                switch (select) {
                    case 1 -> select1();
                    case 2 -> menu2();
                    case 3 -> System.exit(0);
                }
            }
            if (login.equals(Login) || pass.equals(Password)) { break;}
        }
        in.close();
    }

    public void select1() throws ParseException, InvalidObjectException {
        Scanner in = new Scanner(System.in);

        System.out.print("Название организации: ");
        input = in.nextLine();
        in.nextLine();

        System.out.print("Кол-во подразделений: ");
        select = in.nextInt();
        in.nextLine();

        System.out.println("Введите названия подразделений: ");
        ArrayList<String> deptsList = fillList(in, select);
        f = new Firm(input, deptsList);
        in.nextLine();
        Dept d;
        for (int i = 0; i < deptsList.size(); i++) {
            d = createDept(in, deptsList.get(i));
            f.addDept(deptsList.get(i), d);
        }
        menu2();
    }

    public void menu2() throws ParseException, InvalidObjectException {
        f = s.deserialization();
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Выберите раздел: ");
            System.out.println("1 - Редактор\n" +
                    "2 - Отчеты\n" +
                    "3 - Выгрузить информацию в файл\n" +
                    "4 - Выход");

            select = in.nextInt();
            switch (select) {
                case 1 -> editorMenu();
                case 2 -> reportMenu();
                case 3 -> s.serialization(f);
                case 4 -> System.exit(0);
            }
        } while (select != 4);
        in.close();
    }

    // заполнение списка
    public ArrayList<String> fillList(Scanner in, int count) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            System.out.print(i + " - ");
            String nameDept = in.nextLine();
            list.add(nameDept);
        }
        return list;
    }

    // создание отдела
    public Dept createDept(Scanner in, String nameDept) {

        System.out.println("Формирование отдела " + "\"" + nameDept + "\"");
        System.out.print("Кол-во сотрудников: ");
        select = in.nextInt();
        in.nextLine();
        System.out.println();

        System.out.println("Введите должности в отделе: ");
        ArrayList<String> workList = fillList(in, select);
        System.out.println();
        Dept d = new Dept(nameDept, workList);
        for (int j = 0; j < workList.size(); j++) {
            Worker w;
            if (j == 0) {
                w = createWorker(in, workList.get(j), d);
                d.addChief(workList.get(j), w);
                System.out.println();
            } else w = createWorker(in, workList.get(j), d);
            d.addWorker(workList.get(j), w);
            System.out.println();
        }
        return d;
    }

    // создание сотрудника
    public Worker createWorker(Scanner in, String postName, Dept d) {
        Worker w = new Worker();
        System.out.println(postName + ": ");

        System.out.print("ФИО: ");
        w.setFullName(in.nextLine());
        in.nextLine();

        System.out.print("Дата рождения (в формате ДД-ММ-ГГГГ): ");
        w.setDateOfBirth(in.nextLine());
        in.nextLine();

        if ((w.getFullName().charAt(w.getFullName().length() - 1)) == 'ч') {
            w.setGender("М");
        } else w.setGender("Ж");

        w.setPost(postName);

        w.setDept(d.getNameDept());

        w.setChief(d.getBoss());

        System.out.print("Дата приема на работу (в формате ДД-ММ-ГГГГ): ");
        w.setStartDate(in.nextLine());
        in.nextLine();

        System.out.print("Размер заработной платы: ");
        w.setSalary(in.nextInt());
        in.nextLine();

        return w;
    }


    // здесь методы работы с отделами и сотрудниками
    public void editorMenu() throws ParseException, InvalidObjectException {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("МЕНЮ РЕДАКТИРОВАНИЯ:");                                 // Получить информацию о сотруднике
            System.out.println("1 - Поиск сотрудника по ФИО\n" +
                    "2 - Поиск сотрудника по должности\n" +
                    "3 - Поиск отдела по названию\n" +
                    "4 - Поиск отдела по ФИО начальника\n" +
                    "5 - Вернуться в предыдущее меню\n" +
                    "6 - Выход");

            select = in.nextInt();
            switch (select) {
            case 1 -> searchWorkerByName(f);
            case 2 -> searchWorkerByPost(f);
            case 3 -> searchDeptByName(f);
            case 4 -> searchDeptByChief(f);
            case 5 -> menu2();
            case 6 -> System.exit(0);
            }
        } while (select != 6);
        in.close();
    }

    private void searchDeptByChief(Firm f) {
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите начальника отдела: ");
        String nameChief = in.nextLine();
        in.nextLine();
        d.showResultSearchByNameChief(f,nameChief);
    }

    private void searchDeptByName(Firm f) {
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите название отдела: ");
        String nameDept = in.nextLine();
        in.nextLine();
        d.showResultSearchByNameDept(f,nameDept);
    }

    private void searchWorkerByPost(Firm f) {
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите должность сотрудника: ");
        String post = in.nextLine();
        in.nextLine();
        for (Map.Entry<String, Dept> i : f.getDepts().entrySet()){
            d.showResultSearchByPost(i.getValue(), post);
        }
    }
    public void searchWorkerByName(Firm f) {
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите ФИО сотрудника: ");
        String name = in.nextLine();
        in.nextLine();
        for (Map.Entry<String, Dept> i : f.getDepts().entrySet()){
            d.showResultSearchByFullName(i.getValue(),name);
        }
    }

    public void reportMenu() throws ParseException, InvalidObjectException {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("МЕНЮ ОТЧЕТОВ ОБ ОРГАНИЗАЦИИ: ");
            System.out.println("1 - Показать структуру организации\n" +
                    "2 - Средняя заработная плата в организации\n" +
                    "3 - Средняя заработная плата по отделам\n" +
                    "4 - ТОП-10 сотрудников по размеру заработной платы\n" +
                    "5 - ТОП-10 сотрудников по длительности работы в организации\n" +
                    "6 - Вернуться в предыдущее меню\n" +
                    "7 - Выход");

            select = in.nextInt();
            switch (select) {
                case 1 -> r.showOrgStructure(f);
                case 2 -> r.showAverageSalaryByFirm(f);
                case 3 -> r.showAverageSalaryByDept(f);
                case 4 -> r.showTop10Salaries(f);
                case 5 -> r.showTop10Stages(f);
                case 6 -> menu2();
                case 7 -> System.exit(0);
            }
        } while (select != 7);
        in.close();
    }




    }
