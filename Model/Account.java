package Model;

public class Account
{
   public String acc_number;
    public String acc_type;
    public String customerId;


    public Account(String acc_number,String acc_type,String customerId)
    {
        this.acc_number=acc_number;
        this.acc_type=acc_type;
        this.customerId=customerId;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
