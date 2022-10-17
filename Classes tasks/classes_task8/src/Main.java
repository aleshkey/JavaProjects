import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        for(int i=0;i<3;i++){
            System.out.println("name, lastname, patronymic, adress, id, numberOfCard, NumberOfBankAccount");
            String name = sc.nextLine(), lastname = sc.nextLine(), patronymic = sc.nextLine(), adress = sc.nextLine();
            int id = sc.nextInt(), numberOfCard = sc.nextInt(), numberOfBankAccount=sc.nextInt();
            Customer customerBuff = new Customer(id, name, lastname, patronymic, adress, numberOfCard, numberOfBankAccount);
            String emptyString = sc.nextLine();
            customers.add(customerBuff);
        }
        Realization real =  new Realization();
        real.setCustomers(customers);
        real.sortingByLastName();
    }
}
