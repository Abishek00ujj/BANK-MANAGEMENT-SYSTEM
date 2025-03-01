package Model;

public class Employee
{
    public String ifce;
    public String emp_id;
    public String emp_name;
    public String emp_password;
    public String emp_resignation;
    public Address address;
    public String contact;


    public Employee(String ifce, String emp_id, String emp_name, String emp_password, String emp_resignation, Address address, String contact)
    {
        this.emp_resignation=emp_resignation;
        this.emp_password=emp_password;
        this.emp_name=emp_name;
        this.emp_id=emp_id;
        this.address=address;
        this.contact=contact;
        this.ifce=ifce;
    }
}
