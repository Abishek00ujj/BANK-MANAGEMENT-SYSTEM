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

    public boolean isExisting_customer(String customerId)
    {
        return customers.containsKey(customerId);
    }

    public Customer add_customer(String name, String phone_number, String email, Address address, ArrayList<Account> accounts)
    {
        Random random = new Random();
        String customerId = Integer.toString(10000000 + random.nextInt(90000000));
        Customer customer=new Customer(customerId,name,phone_number,email,address,accounts);
        return customer;
    }


    public Account add_Account(String acc_type,String customer_id)
    {
        Random random = new Random();
        String account_number = Long.toString(1000000000+ random.nextInt(2000000000));
        Account account=new Account(account_number,acc_type,customer_id);
        return account;
    }


    public Customer get_Customer(String customer_id)
    {
        return customers.get(customer_id);
    }
}
