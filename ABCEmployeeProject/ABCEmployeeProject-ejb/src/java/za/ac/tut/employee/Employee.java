/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.employee;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author MosesGadebe
 */
@Entity
@Table(name="tblEmployee")
public class Employee implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long empno;
    private String name;
    @Column(name="empSurname")
    private String surname;
    private int age;
    private String dept;
    private double salary;

    public Employee() {
    }

    public Employee(String name, String surname, int age, String dept, double salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dept = dept;
        this.salary = salary;
    }

    public Long getEmpno() {
        return empno;
    }

    public void setEmpno(Long empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}
