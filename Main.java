import Model.*;
import Controller.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Account_methods accountMethods=new Account_methods();
        int EmpLoginFlag=0;
        Employee employeeData=null;


        Employee branchManager=null;
        int branchManagerFlag=0;
        Employee_methods employeeMethods=new Employee_methods();
        Employee BranchManager=new Employee("1","1","ABISHEK","ADMIN");
        Branch branch=new Branch(BranchManager.ifce,"CBE",BranchManager.empid);


        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO BANK OF BARODA");

        while(true)
        {
            if(EmpLoginFlag==1)
            {
                System.out.println("------------------------EMPLOYEEE DASHBOARD-------------------------");
                System.out.println();
                System.out.println("Employee Logged in as "+employeeData.name);
                System.out.println();
                System.out.println("1.CREATE ACCOUNT");
                System.out.println("2.MANAGE ACCOUNT");
                int opt=Integer.parseInt(sc.nextLine());
                if(opt==1)
                {
                    System.out.println("------------------------------CREATE ACCOUNT---------------------------------");
                    System.out.println();
                    System.out.println("1.Existing customer ");
                    System.out.println("2.New customer ");

                    int option=Integer.parseInt(sc.nextLine());

                    if(option==1)
                    {
                        System.out.println("------------------------CREATE ACCOUNT-(EXISTING CUSTOMER)---------------");
                        System.out.println();
                        System.out.println("Please enter the customer id: ");
                        String customer_id=sc.nextLine();
                        if(!accountMethods.isExisting_customer(customer_id))
                        {
                            System.out.println("Sorry, No customer found with the provided id: "+ customer_id);
                        }
                        else
                        {
                            Customer customer=accountMethods.get_Customer(customer_id);
                            System.out.println();
                            System.out.println("Customer id: "+customer.customerId);
                            System.out.println("Customer Name: "+customer.cust_name);
                            System.out.println("Customer Phone Number: "+customer.phone_number);
                            System.out.println("Customer Email:"+customer.email);

                            String account_types[]={"SAVINGS ACCOUNT","CURRENT ACCOUNT","LOAN ACCOUNT"};
                            for(int i=0;i<account_types.length;i++)
                            {
                                System.out.println(i+1+":"+account_types[i]);
                            }
                            System.out.println("Choose an option: ");

                            int op=Integer.parseInt(sc.nextLine());
                                Account account=accountMethods.add_Account(account_types[op-1],customer.customerId);
                                ArrayList<Account> dummy=accountMethods.get_Customer(customer.customerId).accounts;
                                ArrayList<Account> newList=new ArrayList<>();
                                newList.addAll(dummy);
                                newList.add(account);
                                Customer customer1=new Customer(customer.customerId,customer.cust_name,customer.phone_number,customer.email,customer.address,newList);
                                accountMethods.add_account_existing_customer(customer.customerId,customer1);
                                System.out.println();
                                System.out.println("Loading....");
                                System.out.println("Account has been created!");
                                System.out.println();
                                System.out.println("|-------------------------------------------------------|");
                                System.out.println("|           CUSTOMER ACCOUNT DETAILS!                   |");
                                System.out.println("|                                                       |");
                                System.out.println("|      ACCOUNT NUMBER : "+account.acc_number+"          |");
                                System.out.println("|         CUSTOMER ID : "+account.customerId+"          |");
                                System.out.println("|                NAME : "+customer1.cust_name+"         |");
                                System.out.println("|        PHONE NUMBER : "+customer1.phone_number+"      |");
                                System.out.println("|                                                       |");
                                System.out.println("|-------------------------------------------------------|");
                                System.out.println("");
                                System.out.println("kindly, Make a note of this Account details!");
                        }
                    }
                    else if(option==2)
                    {
                        System.out.println("------------------------CREATE ACCOUNT-(NEW CUSTOMER)---------------");
                        System.out.println();
                        System.out.println("ENTER THE CUSTOMER NAME: ");
                        String cust_name=sc.nextLine();
                        System.out.println("ENTER THE CUSTOMER PHONE NUMBER : ");
                        String cust_phoneNumber=sc.nextLine();
                        System.out.println("ENTER THE EMAIL ADDRESS");
                        String cust_email=sc.nextLine();
                        System.out.println("ENTER THE ADDRESS DETAILS");
                        System.out.println("Street : ");
                        String street=sc.nextLine();
                        System.out.println("City : ");
                        String city=sc.nextLine();
                        System.out.println("pincode: ");
                        String pincode=sc.nextLine();
                        System.out.println("State: ");
                        String state=sc.nextLine();
                        System.out.println("country: ");
                        String country=sc.nextLine();
                        Address address=new Address(street,city,pincode,state,country);
                        Customer customer=accountMethods.add_customer(cust_name,cust_phoneNumber,cust_email,address,new ArrayList<Account>());
                        String customer_Id=customer.customerId;
                        String account_types[]={"SAVINGS ACCOUNT","CURRENT ACCOUNT","LOAN ACCOUNT"};
                        for(int i=0;i<account_types.length;i++)
                        {
                            System.out.println(i+1+":"+account_types[i]);
                        }
                        System.out.println("Choose an option: ");
                        int opti=Integer.parseInt(sc.nextLine());
                           Account account=accountMethods.add_Account(account_types[opti-1],customer_Id);
                          // ArrayList<Account> dummy=accountMethods.get_Customer(customer_Id).accounts;
                           ArrayList<Account> newList=new ArrayList<>();
                           newList.add(account);
                           Customer customer1=new Customer(customer_Id,cust_name,cust_phoneNumber,cust_email,address,newList);
                           accountMethods.add_account_existing_customer(customer_Id,customer1);
                            System.out.println();
                            System.out.println("Loading....");
                            System.out.println("Account has been created!");
                            System.out.println();
                            System.out.println("|-------------------------------------------------|");
                            System.out.println("|           CUSTOMER ACCOUNT DETAILS!             |");
                            System.out.println("|                                                 |");
                            System.out.println("|      ACCOUNT NUMBER : "+account.acc_number+"    | ");
                            System.out.println("|         CUSTOMER ID : "+account.customerId+"    |");
                            System.out.println("|                NAME : "+cust_name+"             |");
                            System.out.println("|        PHONE NUMBER : "+cust_phoneNumber+"      |");
                            System.out.println("|                                                 |");
                            System.out.println("|-------------------------------------------------|");
                            System.out.println("");
                            System.out.println("kindly, Make a note of this Account details!");
                    }

                }
                else if (opt==2)
                {

                }
            }
            else {
                System.out.println("1.BANK MANAGER LOGIN");
                System.out.println("2.EMPLOYEE LOGIN");

                int option = Integer.parseInt(sc.nextLine());

                if (option == 1) {
                    System.out.println("-------------------------------BANK MANAGER LOGIN---------------------------------");
                    System.out.println("enter your empid: ");
                    String empid = sc.nextLine();
                    System.out.println("enter your password: ");
                    String password = sc.nextLine();

                    if (BranchManager.empid.equals(empid) && BranchManager.password.equals(password)) {
                        System.out.println(BranchManager.name + "Login attempt is Loading...");
                        System.out.println(BranchManager.name + "  is login succuessfully!");
                        branchManagerFlag = 1;


                        System.out.println();
                        System.out.println();

                        System.out.println("-------------------BRANCH MANAGER-------------------------");
                        System.out.println("---------------------------------------" + BranchManager.name);


                        while (true) {
                            System.out.println("1.create employees");
                            System.out.println("2.Manage employees");
                            System.out.println("3.LOGOUT");

                            System.out.println("Enter the option:");
                            int opt = Integer.parseInt(sc.nextLine());
                            if (opt == 1) {
                                System.out.println("-------------------------CREATE EMPLOYEES---------------------");
                                System.out.println();
                                System.out.println();
                                System.out.println("ENTER THE EMPLOYEE NAME : ");
                                String employee_name = sc.nextLine();

                                Random random = new Random();
                                String employee_id = Integer.toString(100000 + random.nextInt(900000));
                                System.out.println("ENTER THE PASSWORD TO BE SET TO EMPLOYEE " + employee_name);
                                String employee_password = sc.nextLine();
                                Employee employee = new Employee(employee_id, branch.ifce, employee_name, employee_password);
                                employeeMethods.add_employee(employee_id, employee);

                                System.out.println("Employee account is creating....");

                                System.out.println();
                                System.out.println("Employee account is created succuesfully");
                                System.out.println();
                            } else if (opt == 2) {
                                System.out.println("  EMPLOYEE_NAME  " + "EMPLOYEE_ID  " + "EMPLOYEE_PASSWORD");
                                HashMap<String, Employee> employee_details = employeeMethods.getAll_Employees();
                                for (Map.Entry<String, Employee> em : employee_details.entrySet()) {
                                    System.out.println("   " + em.getValue().name + "     " + em.getValue().empid + "    " + em.getValue().password);
                                }
                            } else if (opt == 3) {
                                System.out.println("PRESS/ TYPE CONFIRM TO LOGOUT");
                                String confirm = sc.nextLine();
                                if (confirm.toLowerCase().equals("confirm")) {
                                    System.out.println(BranchManager.name + " Branch Manager is Logging out....");
                                    System.out.println("Loading...");
                                    System.out.println("Logout succuessfully!");
                                    branchManagerFlag = 0;
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Sorry!, wrong credentials provided!");
                    }
                } else if (option == 2) {
                    System.out.println("-------------------------EMPLOYEE LOGIN----------------------------");
                    System.out.println();
                    System.out.println("ENTER YOUR EMPLOYEE ID: ");
                    String employee_id = sc.nextLine();

                    System.out.println("ENTER YOUR PASSWORD : ");
                    String employee_password = sc.nextLine();

                    if (employeeMethods.employee_login(employee_id, employee_password)) {
                        EmpLoginFlag = 1;
                        employeeData = employeeMethods.getData(employee_id);
                    } else {
                        System.out.println("Sorry!. employee credentials is wrong!");
                    }
                }
            }

        }
    }
}
