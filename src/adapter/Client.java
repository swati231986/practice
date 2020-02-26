package adapter;

import java.io.InputStreamReader;

public class Client {
    public static void main(String [] args) {
        BusinessCardDesigner cardDesigner  =  new BusinessCardDesigner();

        Employee employee = new Employee();
        employee.setFullName("Swati Chaturvedi");
        employee.setJobTitle("CEO");
        employee.setOfficeLocation("Mountain View");

        Customer customer = new EmployeeObjectAdapter(employee);
        String card  = cardDesigner.designCard(customer);
        System.out.println(card);

    }
}
