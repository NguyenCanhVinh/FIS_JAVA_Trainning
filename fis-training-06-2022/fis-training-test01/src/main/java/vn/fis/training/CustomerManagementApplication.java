package vn.fis.training;


import org.jetbrains.annotations.NotNull;
import vn.fis.training.domain.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomerManagementApplication {
    public static void main(String[] args) {
        test_when_findById();


        HashMap<String, Customer> map = new HashMap<String, Customer>();
        map.put("1", new Customer("A","Binh","0389798468"));
        map.put("2", new Customer("B","Lan", "0288888377"));
        map.put("3", new Customer("C","Hieu","0187977286"));
        map.put("4", new Customer("D", "Nam","0382983459"));
        show(map);
    }
    // TODO: Implement method to test all CustomerService

    public static void test_when_findById() {

    }

    public static void show(@NotNull Map<String, Customer> map) {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
