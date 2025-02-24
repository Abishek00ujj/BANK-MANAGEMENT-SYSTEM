package Model;

import java.util.ArrayList;
import java.util.HashSet;

public class Customer
{
    public String customerId;
    public String cust_name;
    public String phone_number;
    public String email;
    public Address address;


    public ArrayList<Account> accounts=new ArrayList<>();


    public Customer(String customerId,String cust_name,String phone_number,String email,Address address,ArrayList<Account> accounts)
    {
        this.customerId=customerId;
        this.cust_name=cust_name;
        this.phone_number=phone_number;
        this.email=email;
        this.address=address;
        this.accounts=accounts;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
