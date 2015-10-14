package builder;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author richardclay
 */
public class Customer
{
    static public ArrayList<Customer> allCustomers = new ArrayList<>();
    public Integer id  = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;
    
    public Customer(){}
    
    public static Customer washingtonCustomer()
    {
        Customer wCust = new Customer();
        wCust.setAddress("Washington");
        return wCust;
    }
    
    public static List<String> getEnabledCustomerNames()
    {
        ArrayList<String> outList = new ArrayList();
        
        Customer.allCustomers.stream()
                .filter(Customer::isEnabled)
                .forEach((customer) -> outList.add(customer.name));
        
//        for(Customer customer : Customer.allCustomers)
//        {
//            if(customer.enabled)
//                outList.add(customer.name);
//        }
        return outList;
    }
    
    public boolean isEnabled()
    {
        return enabled;
    }
    
    public static List<String> getEnabledCustomerStates()
    {
        ArrayList<String> outList = new ArrayList<String>();
        for(Customer customer : Customer.allCustomers)
        {
            if(customer.enabled)
                outList.add(customer.state);
        }
        return outList;
    }
    public static List<String> getEnabledCustomerPrimaryContacts()
    {
        ArrayList<String> outList = new ArrayList<String>();
        for(Customer customer : Customer.allCustomers)
        {
            if(customer.enabled)
                outList.add(customer.primaryContact);
        }
        return outList;
    }
    public static List<String> getEnabledCustomerDomain()
    {
        ArrayList<String> outList = new ArrayList<String>();
        for(Customer customer : Customer.allCustomers)
        {
            if(customer.enabled)
                outList.add(customer.domain);
        }
        return outList;
    }
    public static <B> List<B> getEnabledCustomerField(Function1<Customer, B> func)
    {
        ArrayList<B> outList = new ArrayList<B>();
        for(Customer customer : Customer.allCustomers)
        {
            if(customer.enabled)
                outList.add(func.call(customer));
        }
        return outList;
    }

    private void setAddress(String address)
    {
        this.address = address;
    }
    
    private interface Function1<A1, B>
    {
        public B call(A1 in1);
    }
    
    static private class CustomerAddress implements Function1<Customer, String>
    {
        public String call(Customer customer){return customer.address;}
    }
    
    public static List<String> getEnabledCustomerAddress()
    {
        return getEnabledCustomerField(new CustomerAddress());
    }
}
