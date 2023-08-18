/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.session;

import java.util.List;
import javax.ejb.Remote;
import za.ac.tut.employee.Employee;

/**
 *
 * @author MosesGadebe
 */
@Remote
public interface EmployeeService 
{
    public void addEmployee(Employee emp);
    public void deleteEmployee(long empID);
    public void updateEmployee(Employee emp);
    public Employee findEmployee(long empID);
    public List<Employee> getAllEmployees();
     public Employee getEmployee(String name, String surname);
}
