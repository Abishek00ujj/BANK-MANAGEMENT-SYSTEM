package Model;

public class Branch {
    public String ifce;
    public String branch_name;
    public Address address;
    public String contact;

    public Employee branch_manager;

    public long totalfund;

    public Branch(String ifce, String branch_name, Address address, String contact, Employee branch_manager, long totalfund) {
        this.address = address;
        this.branch_name = branch_name;
        this.contact = contact;
        this.ifce = ifce;
        this.branch_manager = branch_manager;
        this.totalfund = totalfund;
    }
}

