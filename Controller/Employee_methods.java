package Controller;

import Model.Account;
import Model.Customer;
import Model.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class Employee_methods
{
    public HashMap<String,Employee> employees=new HashMap<>();

    public void add_employee(String empid,Employee employee)
    {
        employees.put(empid,employee);
    }

    public HashMap<String,Employee> getAll_Employees()
    {
        return employees;
    }

    public boolean employee_login(String empid,String password)
    {
        if(isEmployee(empid))
        {
            Employee empdetail=employees.get(empid);
            if(empdetail.password.equals(password))
            {
                return true;
            }
            return false;
        }
        return false;
    }
    public boolean isEmployee(String empid)
    {
        return employees.containsKey(empid);
    }

    public Employee getData(String empid)
    {
        return employees.get(empid);
    }
}
