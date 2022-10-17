import java.util.ArrayList;

public class Realization {
    ArrayList<Customer> customers = new ArrayList<Customer>();

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    private static int firstAlphabet(String str1, String str2, int i){
        if(str1.charAt(i)==str2.charAt(i)){
            if(i+1<str1.length() && i+1<str2.length()){
                i++;
                return firstAlphabet(str1, str2, i);
            }
            else{
                return 0;
            }
        }
        else{
            if(str1.charAt(i)<str2.charAt(i)){
                return 1;
            }
        }
        return 2;
    }

    public void sortingByLastName(){
        for(int i =0; i< customers.size(); i++){
            Customer customerBuff = customers.get(i);
            String min = customerBuff.getLastName();
            int nummin=i;
            for(int j=i; j< customers.size(); j++){
                customerBuff = customers.get(j);
                if(firstAlphabet(customerBuff.getLastName(), min, 0)==1) {
                    min = customerBuff.getLastName();
                    nummin = j;
                }
            }
            customerBuff = customers.get(nummin);
            customers.set(nummin, customers.get(i));
            customers.set(i, customerBuff);
        }
        for (int i =0; i<customers.size(); i++){
            System.out.println(customers.get(i));
        }
    }

    public void printSomeCards(int start, int finish){
        for(int i =0; i<customers.size();i++){
            Customer customerBuff = customers.get(i);
            if(customerBuff.getId()>=start && customerBuff.getId()<=finish){
                System.out.println(customerBuff);
            }
        }
    }
}
