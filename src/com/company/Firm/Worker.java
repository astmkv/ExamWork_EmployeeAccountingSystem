package com.company.Firm;

import java.io.Serializable;
import java.util.Scanner;

public class Worker implements Serializable {

    transient Scanner in = new Scanner(System.in);

    private String fullName;            //  ФИО
    private String dateOfBirth;         //  дата рождения
    private String gender;              //  пол
    private String post;                //  должность
    private String dept;                //  отдел
    private String chief;               //  начальник
    private String startDate;           //  дата приема на работу
    private int salary;                 //  заработная плата

    public Worker() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Worker(String fullName, String dateOfBirth, String gender, String post, String dept, String chief, String startDate, int salary) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.post = post;
        this.dept = dept;
        this.chief = chief;
        this.startDate = startDate;
        this.salary = salary;
//        Firm.salaries.add(salary);
//        Firm.empWithSal.put(post + ": " + fullName, salary);
//        Firm.empWithDates.put(post + ": " + fullName, startDate);
    }



    @Override
    public String toString() {
        return
                "ФИО: \t" + fullName + "\n" +
                        "Дата рождения: \t" + dateOfBirth + "\n" +
                        "Пол: \t" + gender + "\n" +
                        "Занимаемая должность: \t" + post + "\n" +
                        "Отдел: \t" + dept + "\n" +
                        "Начальник отдела: \t" + chief + "\n" +
                        "Дата приема на работу: \t" + startDate + "\n" +
                        "Размер заработной платы: \t" + salary + ".\n\n";

    }

//    public String nameToString() {
//        return fullName;
//    }

//    public String salaryToString() {
//        return post + " " + fullName + "Заработная плата: " + salary;
//    }

// реализация toString()
    // nameToString() - выводит ФИО и должность
}
