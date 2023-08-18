/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.employee.Employee;

/**
 *
 * @author MosesGadebe
 */
@Stateless
public class EmployeeServiceBean implements EmployeeService
{
    @PersistenceContext(unitName="abcConnect")
    EntityManager entityManager;
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addEmployee(Employee emp)
    {
        entityManager.persist(emp);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteEmployee(long empID) 
    {
        entityManager.remove(findEmployee(empID));
    }

    @Override
    public Employee findEmployee(long empID)
    {
       return entityManager.find(Employee.class, empID);
    }

    @Override
    public List<Employee> getAllEmployees()
    {
        String sql = "Select employee from Employee employee";
        List<Employee> list = entityManager.createQuery(sql).getResultList();
        return list;
    }

    @Override
    public void updateEmployee(Employee emp)
    {
        Employee objEmp = findEmployee(emp.getEmpno());
        
        if (objEmp != null)
        {
            entityManager.merge(emp);
        }
    }
    @Override
    public Employee getEmployee(String ename, String esurname)
    {
        String sql = "Select employee from Employee employee where name Like :name and  surname Like :surname";
        //String sql = "Select employee from Employee employee where name := name and  surname :=surname";
        
        Query query = entityManager.createQuery(sql);
        query.setParameter("name", ename);
        query.setParameter("surname", esurname);
        Employee emp = (Employee) query.getSingleResult();
        return emp;
    }
    
}
