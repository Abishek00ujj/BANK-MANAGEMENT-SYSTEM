package Model;

public class Transaction
{
    public String Money_from;

    public String Money_to;

    public String time;

    public String date;

    public String amount;


    public Transaction(String Money_from,String Money_to,String time,String date,String amount)
    {
        this.amount=amount;
        this.Money_from=Money_from;
        this.Money_to=Money_to;
        this.date=date;
        this.time=time;
    }
}
