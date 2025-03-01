package Model;

import java.util.ArrayList;

public class Account
{
    public long cust_id;
    public long acc_number;
    public String acc_type;
    public long acc_balance;

    public ArrayList<Transaction> transactions=new ArrayList<>();

    public Account(long cust_id,long acc_number,String acc_type,long acc_balance,ArrayList<Transaction>transaction)
    {
        this.acc_number=acc_number;
        this.acc_type=acc_type;
        this.acc_balance=acc_balance;
        this.cust_id=cust_id;
        this.transactions=transaction;
    }

}
