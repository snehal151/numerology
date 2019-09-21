
package com.example1.info;

public class PersonalNumber {

    int id;
    String name;
    int dateOfBirth;
    int month;
    int year;

    public PersonalNumber(int id, String name, int dateOfBirth,int month, int year) {
        this.id=id;
        this.name=name;
        this.dateOfBirth = dateOfBirth;
        this.month =month;
        this.year =year;

    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + dateOfBirth +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
