package adapter;

public class BusinessCardDesigner {

    public String designCard(Customer cust) {
        String card = "";
        card = cust.getName() + " " + cust.getAddress() + " " + cust.getDesignation();
        return card;
    }
}
