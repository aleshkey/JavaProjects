public class Customer {
    private String name, lastName, patronymic, adress;
    private int numberOfCard, numberOfBankAccount, id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNumberOfCard() {
        return numberOfCard;
    }

    public void setNumberOfCard(int numberOfCard) {
        this.numberOfCard = numberOfCard;
    }

    public int getNumberOfBankAccount() {
        return numberOfBankAccount;
    }

    public void setNumberOfBankAccount(int numberOfBankAccount) {
        this.numberOfBankAccount = numberOfBankAccount;
    }

    public Customer(int id, String name, String lastName, String patronymic, String adress, int numberOfCard, int numberOfBankAccount) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.adress = adress;
        this.numberOfCard = numberOfCard;
        this.numberOfBankAccount = numberOfBankAccount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id = "+id+'\''+
                "lastname='" + lastName + '\'' +
                ", Name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", adress='" + adress + '\'' +
                ", numberOfCard=" + numberOfCard +
                ", numberOfBankAccount=" + numberOfBankAccount +
                '}';
    }
}
