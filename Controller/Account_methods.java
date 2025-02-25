package Controller;

import Model.Account;
import Model.Address;
import Model.Customer;

import java.util.*;

public class Account_methods
{
    public HashMap<String, Customer> customers=new HashMap<>();

    public void add_account_existing_customer(String customer_id,Customer customer)
    {
        customers.put(customer_id,customer);
    }

    public boolean isExisting_customer(String customerId)
    {
        return customers.containsKey(customerId);
    }

    public Customer add_customer(String name, String phone_number, String email, Address address, ArrayList<Account> accounts)
    {
        Random random = new Random();
        String customerId = Integer.toString(100000 + random.nextInt(900000));
        Customer customer=new Customer(customerId,name,phone_number,email,address,accounts);
        return customer;
    }


    public Account add_Account(String acc_type,String customer_id)
    {
        Random random = new Random();
        String account_number = Integer.toString(1000000+ random.nextInt(200000));
        Account account=new Account(account_number,acc_type,customer_id);
        return account;
    }


    public Customer get_Customer(String customer_id)
    {
        return customers.get(customer_id);
    }


    public Account get_Account_by_Account_Number(String acc_number)
    {
        for(Map.Entry<String,Customer> e:customers.entrySet())
        {
            ArrayList<Account> cus=e.getValue().accounts;
            for(Account acc:cus)
            {
                if(acc.acc_number.equals(acc_number))
                {
                    return acc;
                }
            }
        }
        return null;
    }


    public ArrayList<Account> get_Accounts_by_customer_id(String cust_id)
    {
        for(Map.Entry<String,Customer> e:customers.entrySet())
        {
            ArrayList<Account> accounts=e.getValue().accounts;
            return accounts;
        }
        return null;
    }


}
