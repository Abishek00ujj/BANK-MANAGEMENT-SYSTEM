package Model;

public class Employee
{
    public String empid;
    public String ifce;
    public String name;
    public String password;
    public Employee(String empid,String ifce,String name,String password)
    {
        this.empid=empid;
        this.ifce=ifce;
        this.name=name;
        this.password=password;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
