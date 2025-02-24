package Controller;

import Model.Account;
import Model.Address;
import Model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

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
}
