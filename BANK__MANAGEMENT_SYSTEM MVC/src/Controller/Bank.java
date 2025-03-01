package Controller;
import Model.Branch;
import Model.*;
import Model.Employee;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bank
{
    public static long fund=0;

    LinkedHashMap<String,Branch> branches=new LinkedHashMap<>();

    public void create_branch(String ifce, String branch_name, Address address, String contact, Employee branch_manager)
    {
        branches.put(ifce, new Model.Branch(ifce, branch_name, address, contact, branch_manager, 0));
    }
    public void update_branch_manager(String ifce,Branch branch)
    {
        branches.put(ifce,branch);
    }

    public LinkedHashMap<String,Branch> view_all_branches()
    {
        return branches;
    }
    public long view_funds()
    {
        return fund;
    }


    public boolean assign_new_manager(String ifce,Model.Employee employee)
    {
        Branch branchData=null;
        for(Map.Entry<String,Branch> e:branches.entrySet())
        {
            if(ifce.equals(e.getValue().ifce))
            {
                branchData=e.getValue();
                break;
            }
        }
        branches.put(ifce,new Branch(branchData.ifce,branchData.branch_name,branchData.address,branchData.contact,employee,branchData.totalfund));
        return true;
    }

    public void assign_funds_to_branch(String ifce,long fund)
    {
        Branch branchData=null;
        for(Map.Entry<String,Branch> e:branches.entrySet())
        {
            if(ifce.equals(e.getValue().ifce))
            {
                branchData=e.getValue();
                break;
            }
        }
        branches.put(ifce,new Branch(ifce,branchData.branch_name,branchData.address,branchData.contact,branchData.branch_manager,fund));
    }

    public Branch branch_manager_login(String ifce,String empi_id,String emp_password)
    {
        if(!branches.containsKey(ifce))
        {
            return null;
        }
        Branch branch=branches.get(ifce);
        if(branch.branch_manager.emp_id.equals(empi_id) && branch.branch_manager.emp_password.equals(emp_password))
        {
            return branch;
        }
        return null;
    }

    public Model.Branch get_branch(String ifce)
    {
        return branches.get(ifce);
    }

    public boolean is_branch_available(String ifce)
    {
        return branches.containsKey(ifce);
    }
}
