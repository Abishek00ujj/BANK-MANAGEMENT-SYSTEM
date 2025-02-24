package Model;

public class Address
{
    String city;
    String street;
    String pincode;
    String country;
    String state;

    public Address(String street, String city, String pincode, String state, String country)
    {
        this.city=city;
        this.state=state;
        this.pincode=pincode;
        this.country=country;
        this.street=street;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
