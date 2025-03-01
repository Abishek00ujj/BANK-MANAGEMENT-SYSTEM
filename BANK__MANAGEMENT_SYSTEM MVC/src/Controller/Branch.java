package Controller;

import Model.Account;
import Model.Address;
import Model.Customer;
import Model.Employee;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Branch
{
    static long accountNumber=1;
    static long customerID=1;
     public LinkedHashMap<String, Employee> employees=new LinkedHashMap<>();

     public LinkedHashMap<String, Customer> customers=new LinkedHashMap<>();

    public boolean create_employee(String ifce, String emp_id, String emp_name, String emp_password, String emp_resignation, Address address,String contact)
    {
        employees.put(emp_id,new Employee(ifce, emp_id, emp_name, emp_password, emp_resignation, address, contact));
        return true;
    }

    public LinkedHashMap<String,Employee> view_employees()
    {
        return employees;
    }


    public Employee employee_login(String emp_id,String emp_password)
    {
        if(employees.containsKey(emp_id))
        {
            Employee emp = employees.get(emp_id);
            if(emp.emp_id.equals(emp_id) && emp.emp_password.equals(emp_password))
            {
                return employees.get(emp_id);
            }
        }
        return null;
    }

    public LinkedHashMap<String,Customer> get_all_customers()
    {
        return customers;
    }

    public ArrayList<Account> get_all_account()
    {
        ArrayList<Account> all_accounts=new ArrayList<>();

        for(Map.Entry<String,Customer> e:customers.entrySet())
        {
            for(Account acc:e.getValue().accounts)
            {
                all_accounts.add(acc);
            }
        }
        return all_accounts;
    }

    public ArrayList<Account> get_all_account_of_customer(String cust_id)
    {
        ArrayList<Account> all_accounts=new ArrayList<>();

        for(Map.Entry<String,Customer> e:customers.entrySet())
        {
            if(cust_id.equals(e.getKey())) {
                for (Account acc : e.getValue().accounts) {
                    all_accounts.add(acc);
                }
                return all_accounts;
            }
        }
        return new ArrayList<>();
    }

    public boolean is_existing_customer(String cust_id)
    {
        return customers.containsKey(cust_id);
    }

    public Customer get_customer(String cust_id)
    {
        return customers.get(cust_id);
    }

}
