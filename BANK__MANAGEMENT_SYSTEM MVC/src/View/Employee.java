package View;

import Controller.Branch;
import Model.Account;
import Model.Address;
import Model.Customer;
import Model.Transaction;

import java.util.ArrayList;
import java.util.Scanner;


public class Employee
{

     public void employee_view(Model.Branch branch,Model.Employee employee_data,long accountNumber,long customerId,Branch  branchController)
     {
         Scanner sc=new Scanner(System.in);
         if(employee_data!=null)
         {
             System.out.println("---------------------------EMPLOYEE-------------------------------");
             System.out.println("Logged in as "+employee_data.emp_name);
             System.out.println();
             System.out.println("Branch :"+branch.branch_name);
             System.out.println("Branch :"+branch.ifce);
             System.out.println();
             System.out.println("1.create account :");
             System.out.println("2.view account :");
             System.out.println("4.View customer");
             System.out.println("5.View Account Details");
             System.out.println("6.Manage Account");
             System.out.println("7.Manage Customer");
             System.out.println("8.EXIT");
             int option=Integer.parseInt(sc.nextLine());
             if(option==1)
             {
                 System.out.println("-------------------ACCOUNT CREATION-----------------------");
                 System.out.println();
                 System.out.println("1.EXISTING CUSTOMER");
                 System.out.println("2.NEW CUSTOMER");
                 int opti=Integer.parseInt(sc.nextLine());
                 if(opti==1)
                 {
                     System.out.println("Enter the customer ID:");
                     String cust_id=sc.nextLine();
                     if(branchController.is_existing_customer(cust_id))
                     {
                         Customer customerData=branchController.get_customer(cust_id);
                         System.out.println("WHICH TYPE OF ACCOUNT");
                         System.out.println("1.Current Account");
                         System.out.println("2.Savings Account");
                         System.out.println("3.Loan Account");
                         int op = Integer.parseInt(sc.nextLine());

                         if (op == 1) {
                             System.out.println("--------------------------CURRENT ACCOUNT CREATION  (EXISTING CUSTOMER)------------------------------");
                             System.out.println();
                             Address address = customerData.address;

                             accountNumber = accountNumber + 1;

                             String acc_type = "CURRENT";

                             int acc_balance = 1000;

                             ArrayList<Transaction> transactions = new ArrayList<>();

                             Account account = new Account(customerId, accountNumber, acc_type, acc_balance, transactions);
                             ArrayList<Account> userAccounts = branchController.get_all_account_of_customer(cust_id);
                             Customer customer = new Customer(customerId, customerData.cust_name, address, customerData.contact, customerData.ifce, userAccounts);
                             branchController.customers.put(cust_id,customer);

                             System.out.println("User Account is creating...");
                             System.out.println("Account is created succuessfully..");

                             System.out.println("Account Number :" + accountNumber);
                             System.out.println("Customer ID :" + customerId);
                             System.out.println("Customer Name: " + customerData.cust_name);
                             System.out.println("Account Type: " + acc_type);
                         }
                         else if (op == 2)
                         {
                                     System.out.println("--------------------------SAVINGS ACCOUNT CREATION  (EXISTING CUSTOMER)------------------------------");
                                     System.out.println();
                                     Address address = customerData.address;

                                     accountNumber = accountNumber + 1;

                                     String acc_type = "SAVING";

                                     int acc_balance = 0;

                                     ArrayList<Transaction> transactions = new ArrayList<>();

                                     Account account = new Account(customerId, accountNumber, acc_type, acc_balance, transactions);
                                     ArrayList<Account> userAccounts = branchController.get_all_account_of_customer(cust_id);
                                     Customer customer = new Customer(customerId, customerData.cust_name, address, customerData.contact, customerData.ifce, userAccounts);
                                     branchController.customers.put(cust_id,customer);

                                     System.out.println("User Account is creating...");
                                     System.out.println("Account is created succuessfully..");

                                     System.out.println("Account Number :" + accountNumber);
                                     System.out.println("Customer ID :" + customerId);
                                     System.out.println("Customer Name: " + customerData.cust_name);
                                     System.out.println("Account Type: " + acc_type);

                         } else if (op == 3) {
                                             System.out.println("--------------------------LOAN ACCOUNT CREATION  (EXISTING CUSTOMER)------------------------------");
                                             System.out.println();
                                             Address address = customerData.address;

                                             accountNumber = accountNumber + 1;

                                             String acc_type = "LOAN";

                                             int acc_balance = 0;

                                             ArrayList<Transaction> transactions = new ArrayList<>();

                                             Account account = new Account(customerId, accountNumber, acc_type, acc_balance, transactions);
                                             ArrayList<Account> userAccounts = branchController.get_all_account_of_customer(cust_id);
                                             Customer customer = new Customer(customerId, customerData.cust_name, address, customerData.contact, customerData.ifce, userAccounts);
                                             branchController.customers.put(cust_id,customer);

                                             System.out.println("User Account is creating...");
                                             System.out.println("Account is created succuessfully..");

                                             System.out.println("Account Number :" + accountNumber);
                                             System.out.println("Customer ID :" + customerId);
                                             System.out.println("Customer Name: " + customerData.cust_name);
                                             System.out.println("Account Type: " + acc_type);
                         }
                     }
                     else
                     {
                         System.out.println("No customers found with "+cust_id);
                     }
                 }
                 else
                 {
                     System.out.println("WHICH TYPE OF ACCOUNT");
                     System.out.println("1.Current Account");
                     System.out.println("2.Savings Account");
                     System.out.println("3.Loan Account");
                     int op = Integer.parseInt(sc.nextLine());

                     if (op == 1) {
                         System.out.println("--------------------------CURRENT ACCOUNT CREATION  (NEW CUSTOMER)------------------------------");
                         System.out.println();
                         System.out.println("ENTER THE CUSTOMER NAME:");

                         String cust_name = sc.nextLine();
                         System.out.println("ENTER THE CONTACT NUMBER:");

                         String contact = sc.nextLine();

                         String ifce_ = branch.ifce;

                         System.out.println("Address details: ");
                         System.out.println("ENTER THE CITY NAME:");

                         String city = sc.nextLine();
                         System.out.println("ENTER THE DOOR NO. ");

                         String doorno = sc.nextLine();

                         System.out.println("ENTER THE DISTRICT NAME: ");

                         String district = sc.nextLine();

                         System.out.println("ENTER THE STATE NAME: ");

                         String state = sc.nextLine();

                         Address address = new Address(city, doorno, district, state);

                         accountNumber = accountNumber + 1;

                         customerId = customerId + 1;

                         String acc_type = "CURRENT";

                         int acc_balance = 1000;

                         ArrayList<Transaction> transactions = new ArrayList<>();

                         Account account = new Account(customerId, accountNumber, acc_type, acc_balance, transactions);
                         ArrayList<Account> userAccounts = new ArrayList<>();
                         Customer customer = new Customer(customerId, cust_name, new Address(city, doorno, district, state), contact, ifce_, userAccounts);
                         System.out.println("User Account is creating...");
                         System.out.println("Account is created succuessfully..");

                         System.out.println("Account Number :" + accountNumber);
                         System.out.println("Customer ID :" + customerId);
                         System.out.println("Customer Name: " + cust_name);
                         System.out.println("Account Type: " + acc_type);
                     } else if (op == 2) {
                         System.out.println("--------------------------SAVINGS ACCOUNT CREATION (NEW CUSTOMER)------------------------------");
                         System.out.println();

                         System.out.println("ENTER THE CUSTOMER NAME:");

                         String cust_name = sc.nextLine();
                         System.out.println("ENTER THE CONTACT NUMBER:");

                         String contact = sc.nextLine();

                         String ifce_ = branch.ifce;

                         System.out.println("Address details: ");
                         System.out.println("ENTER THE CITY NAME:");

                         String city = sc.nextLine();
                         System.out.println("ENTER THE DOOR NO. ");

                         String doorno = sc.nextLine();

                         System.out.println("ENTER THE DISTRICT NAME: ");

                         String district = sc.nextLine();

                         System.out.println("ENTER THE STATE NAME: ");

                         String state = sc.nextLine();

                         Address address = new Address(city, doorno, district, state);

                         accountNumber = accountNumber + 1;

                         customerId = customerId + 1;

                         String acc_type = "SAVING";

                         int acc_balance = 0;

                         ArrayList<Transaction> transactions = new ArrayList<>();

                         Account account = new Account(customerId, accountNumber, acc_type, acc_balance, transactions);
                         ArrayList<Account> userAccounts = new ArrayList<>();
                         Customer customer = new Customer(customerId, cust_name, new Address(city, doorno, district, state), contact, ifce_, userAccounts);
                         System.out.println("User Account is creating...");
                         System.out.println("Account is created succuessfully..");

                         System.out.println("Account Number :" + accountNumber);
                         System.out.println("Customer ID :" + customerId);
                         System.out.println("Customer Name: " + cust_name);
                         System.out.println("Account Type: " + acc_type);
                     } else if (op == 3) {
                         System.out.println("--------------------------LOAN ACCOUNT CREATION  (NEW CUSTOMER)------------------------------");
                         System.out.println();

                         System.out.println("ENTER THE CUSTOMER NAME:");

                         String cust_name = sc.nextLine();
                         System.out.println("ENTER THE CONTACT NUMBER:");

                         String contact = sc.nextLine();

                         String ifce_ = branch.ifce;

                         System.out.println("Address details: ");
                         System.out.println("ENTER THE CITY NAME:");

                         String city = sc.nextLine();
                         System.out.println("ENTER THE DOOR NO. ");

                         String doorno = sc.nextLine();

                         System.out.println("ENTER THE DISTRICT NAME: ");

                         String district = sc.nextLine();

                         System.out.println("ENTER THE STATE NAME: ");

                         String state = sc.nextLine();

                         Address address = new Address(city, doorno, district, state);

                         accountNumber = accountNumber + 1;

                         customerId = customerId + 1;

                         String acc_type = "LOAN";

                         int acc_balance = 0;

                         ArrayList<Transaction> transactions = new ArrayList<>();

                         Account account = new Account(customerId, accountNumber, acc_type, acc_balance, transactions);
                         ArrayList<Account> userAccounts = new ArrayList<>();
                         Customer customer = new Customer(customerId, cust_name, new Address(city, doorno, district, state), contact, ifce_, userAccounts);
                         System.out.println("User Account is creating...");
                         System.out.println("Account is created succuessfully..");

                         System.out.println("Account Number :" + accountNumber);
                         System.out.println("Customer ID :" + customerId);
                         System.out.println("Customer Name: " + cust_name);
                         System.out.println("Account Type: " + acc_type);
                     }
                 }
             }
             else if(option==8)
             {
                 return;
             }
         }
         else
         {
             System.out.println("Try again later.. invalid login credentials");
         }
     }
}
