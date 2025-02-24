package Model;

public class Account
{
    String acc_number;
    String acc_type;
    String customerId;


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
