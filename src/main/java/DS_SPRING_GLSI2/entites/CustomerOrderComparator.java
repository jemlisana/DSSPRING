package DS_SPRING_GLSI2.entites;

import java.util.Comparator;



public class CustomerOrderComparator implements Comparator<Customer> {
    // override the compare() method
    public int compare(Customer s1, Customer s2)
    {
        if (s1.getOrders().size() == s2.getOrders().size())
            return 0;
        else if (s1.getOrders().size() < s2.getOrders().size())
            return 1;
        else
            return -1;
    }
}
