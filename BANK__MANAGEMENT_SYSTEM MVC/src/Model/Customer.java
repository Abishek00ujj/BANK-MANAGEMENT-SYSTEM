package Model;

import java.util.ArrayList;

public class Customer
{
    public long cust_id;
    public String cust_name;
    public String cust_password;
    public Address address;
    public String contact;
    public String ifce;
    public String password;
    public ArrayList<Account> accounts=new ArrayList<>();

    public Customer(long cust_id,String cust_name,Address address,String contact,String ifce,ArrayList<Account> accounts)
    {
        this.address=address;
        this.contact=contact;
        this.cust_name=cust_name;
        this.ifce=ifce;
        this.cust_id=cust_id;
        this.accounts=accounts;
    }
}
