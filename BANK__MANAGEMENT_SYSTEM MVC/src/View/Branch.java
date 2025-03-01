package View;
import Model.Address;
import Model.Employee;

import java.util.*;

public class Branch
{
    public void branchManager_view(Model.Branch branch,String ifce,Controller.Branch branchController)
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------------BRANCH MANAGER-----------------------------------------");
        System.out.println("BRANCH NAME: "+branch.branch_name);
        System.out.println("IFCE CODE : "+branch.ifce);



        int option=0;

        while(true)
        {
            System.out.println("0.Total fund available in branch: ");

            System.out.println("1.Create employees.");

            System.out.println("2.View employees.");

            System.out.println("3.Manage employees.");

            System.out.println("4.View employees credentials.");

            System.out.println("5.EXIT");

            option=Integer.parseInt(sc.nextLine());
            if(option==1)
            {
                System.out.println("Enter the Name :");
                String emp_name=sc.nextLine();

                System.out.println("Enter the id :");
                String emp_id=sc.nextLine();

                System.out.println("Enter the password :");

                String emp_password=sc.nextLine();
                System.out.println("Enter the resignation :");

                String emp_resgination=sc.nextLine();
                System.out.println("Enter the contact: ");

                String contact=sc.nextLine();
                System.out.println("Enter the Address");

                System.out.println("City:");
                String city=sc.nextLine();

                System.out.println("Door no.");
                String doorno=sc.nextLine();

                System.out.println("District:");
                String district=sc.nextLine();

                System.out.println("State:");
                String state=sc.nextLine();


                if(!emp_name.isEmpty() && !emp_id.isEmpty() && !emp_password.isEmpty() && !emp_resgination.isEmpty() && !state.isEmpty() && !city.isEmpty() && !doorno.isEmpty())
                {
                    branchController.create_employee(branch.ifce,emp_id,emp_name,emp_password,emp_resgination,new Address(city,doorno,district,state),contact);
                    System.out.println("Loading...");
                    System.out.println("Employee is added succuessfully!");
                }
                else {
                    System.out.println("Please fill all the fields..");
                    System.out.println("try again later..");
                }
            }
            else if(option==2)
            {
                System.out.println("----------------------------VIEW ALL EMPLOYEES----------------------------------------");
                System.out.println();
                LinkedHashMap<String, Employee> employees=branchController.view_employees();
                System.out.println("     ID         NAME        RESIGNATION   ");
                for(Map.Entry<String,Employee> e:employees.entrySet())
                {
                    System.out.println(e.getKey()+"       "+e.getValue().emp_name+"      "+e.getValue().emp_resignation);
                }
            }
            else if(option==4)
            {
                System.out.println("-------------------------VIEW EMPLOYEE CREDENTIALS-----------------------------------");
                System.out.println();
                LinkedHashMap<String, Employee> employees=branchController.view_employees();
                System.out.println("     ID         PASSWORD        NAME       RESIGNATION   ");
                for(Map.Entry<String,Employee> e:employees.entrySet())
                {
                    System.out.println(e.getKey()+"       "+e.getValue().emp_password+"    "+e.getValue().emp_name+"      "+e.getValue().emp_resignation);
                }
            }
            else if(option==0)
            {
                System.out.println("----------------------TOTAL FUND AVAILABLE IN BRANCH--------------------------------");
                System.out.println(branch.branch_name+"             "+branch.ifce);
                System.out.println();
                System.out.println("Total fund availabe is--->"+branch.totalfund);
            }
            else{
                return;
            }
        }
    }

}
