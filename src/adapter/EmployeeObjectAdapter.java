package adapter;

//adapter class - two-way adapter
public class EmployeeObjectAdapter implements Customer {

    Employee emp;
    EmployeeObjectAdapter (Employee emp) {
        this.emp = emp;
    }
    @Override
    public String getName() {
        return emp.getFullName();
    }

    @Override
    public String getDesignation() {
        return emp.getJobTitle();
    }

    @Override
    public String getAddress(){
        return emp.getOfficeLocation();
    }
}
