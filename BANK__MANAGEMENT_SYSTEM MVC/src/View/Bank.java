package View;

import Model.Address;
import Model.Branch;
import Model.Employee;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank
{
    public void bank_view(Controller.Bank bank)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("------------------------------BANK ADMIN----------------------------------------");

        while(true) {
            System.out.println("1.create branch");
            System.out.println("2.Manage branch");
            System.out.println("3.Assign Branch Manager");
            System.out.println("4.View total funds");
            System.out.println("5.Assign funds to Branch");
            System.out.println("6.Credential details of Employees");
            System.out.println("7.Exit");
            int option = Integer.parseInt(sc.nextLine());
            if(option==1)
            {
                System.out.println("-------------------------------CREATE BRANCH----------------------------------");
                System.out.println("Enter the IFCE:");
                String ifce=sc.nextLine();
                System.out.println("Enter the Branch Name:");
                String branch_name=sc.nextLine();
                System.out.println("Enter the address:");

                System.out.println("City:");
                String city=sc.nextLine();

                System.out.println("Door no.");
                String doorno=sc.nextLine();

                System.out.println("District:");
                String district=sc.nextLine();

                System.out.println("State:");
                String state=sc.nextLine();
                System.out.println("Enter the contact:");
                String contact=sc.nextLine();

                System.out.println("Branch Manager Details..");
                System.out.println();

                System.out.println("Enter the Employee id: ");
                String emp_id=sc.nextLine();

                System.out.println("Enter the Employee name: ");
                String emp_name=sc.nextLine();

                System.out.println("Enter the Employee password: ");
                String emp_password=sc.nextLine();

                String emp_resignation="MANAGER";

                System.out.println("Enter the Manager address");

                System.out.println("City:");
                String emp_city=sc.nextLine();

                System.out.println("Door no.");
                String emp_doorno=sc.nextLine();

                System.out.println("District:");
                String emp_district=sc.nextLine();

                System.out.println("State:");
                String emp_state=sc.nextLine();
                System.out.println("Enter the contact:");
                String emp_contact=sc.nextLine();

                Address emp_address=new Address(emp_city,emp_doorno,emp_district,emp_state);

                Employee branch_manager=new Model.Employee(ifce,emp_id,emp_name,emp_password,emp_resignation,emp_address,emp_contact);

                Branch branch=new Branch(ifce,branch_name,new Address(city,doorno,district,state),contact,branch_manager,100000);
                bank.create_branch(ifce, branch_name, new Address(city, doorno, district, state), contact, branch_manager);
                System.out.println("New Branch is created succuesfully!");
            }
            else if(option==2)
            {
                System.out.println("-------------------------------MANAGE BRANCH-------------------------------------");
                System.out.println();
                LinkedHashMap<String,Model.Branch> branches=bank.view_all_branches();
                System.out.println("      IFCE             BRANCH NAME              MANAGER NAME");
                for(Map.Entry<String,Branch> e:branches.entrySet())
                {
                    System.out.println(e.getKey()+"   "+e.getValue().branch_name+"    "+e.getValue().branch_manager.emp_name);
                }
            }
            else if(option==3)
            {
                System.out.println("---------------------------ASSIGN BRANCH MANAGER-------------------------------");
                System.out.println("Enter the IFCE code:");
                String ifce=sc.nextLine();
                System.out.println("Branch Manager Details..");
                System.out.println();

                System.out.println("Enter the Employee id: ");
                String emp_id=sc.nextLine();

                System.out.println("Enter the Employee name: ");
                String emp_name=sc.nextLine();

                System.out.println("Enter the Employee password: ");
                String emp_password=sc.nextLine();

                String emp_resignation="MANAGER";

                System.out.println("Enter the Manager address");

                System.out.println("City:");
                String emp_city=sc.nextLine();

                System.out.println("Door no.");
                String emp_doorno=sc.nextLine();

                System.out.println("District:");
                String emp_district=sc.nextLine();

                System.out.println("State:");
                String emp_state=sc.nextLine();
                System.out.println("Enter the contact:");
                String emp_contact=sc.nextLine();

                Address emp_address=new Address(emp_city,emp_doorno,emp_district,emp_state);

                Employee branch_manager=new Model.Employee(ifce,emp_id,emp_name,emp_password,emp_resignation,emp_address,emp_contact);

                if(bank.is_branch_available(ifce))
                {
                    Branch branch_data = bank.get_branch(ifce);
                    System.out.println("Are you sure want to make " + emp_name + " as a Branch manager of " + ifce + " " + branch_data.branch_name);
                    System.out.println("Type confirm. and press enter.");

                    String confirm=sc.nextLine();
                    if(confirm.toLowerCase().equals("confirm"))
                    {
                        bank.create_branch(ifce,branch_data.branch_name,branch_data.address,branch_data.contact,branch_manager);
                        System.out.println("New branch manager is assigned succuessfully!");
                    }
                    else
                    {
                        System.out.println("Try again later...");
                    }
                }
            }
            else if(option==4)
            {
                System.out.println("------------------------BANK CURRENT AVAILABLE/ ROLLING OUT FUND---------------------");
                System.out.println("Time: "+new Date().getTime());
                System.out.println();
                System.out.println("Total Avilable fund is--->"+bank.view_funds());
            }
            else if(option==5)
            {
                System.out.println("----------------------ASSIGN FUND TO BRANCH-----------------------");
                System.out.println();
                System.out.println("Enter the IFCE:");
                String ifce=sc.nextLine();
                if(bank.is_branch_available(ifce))
                {
                    Branch branch_data = bank.get_branch(ifce);
                    String fund = sc.nextLine();
                    System.out.println("Are you sure want to make transfer fund to the " + branch_data.branch_name + " " + branch_data.ifce);
                    System.out.println("Type confirm. and press enter.");

                    String confirm = sc.nextLine();
                    if (confirm.toLowerCase().equals("confirm"))
                    {
                        bank.update_branch_manager(ifce, new Branch(ifce, branch_data.branch_name, branch_data.address, branch_data.contact, branch_data.branch_manager, Long.parseLong(fund)));
                        System.out.println("fund is transfered succuessfully!");
                    }
                }
                else
                {
                    System.out.println("Try again later...");
                }
            }
            else if(option==6)
            {
                System.out.println("-------------------------------BRANCH MANAGER CREDENTIALS---------------------------------");
                System.out.println();
                System.out.println("IFCE    BRANCH-NAME      MANAGER-NAME    MANAGER_ID  MANAGER_PASSWORD");
                LinkedHashMap<String,Model.Branch> branches=bank.view_all_branches();
                for(Map.Entry<String,Branch> e:branches.entrySet())
                {
                    System.out.println(e.getKey()+"    "+e.getValue().branch_name+"    "+e.getValue().branch_manager.emp_name+"   "+e.getValue().branch_manager.emp_id+"    "+e.getValue().branch_manager.emp_password);
                }
            }
            else {
                return;
            }
        }

    }
}
