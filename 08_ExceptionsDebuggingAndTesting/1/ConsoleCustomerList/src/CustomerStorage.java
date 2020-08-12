import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws WrongEmailException {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong command! Available command examples: \n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (!components[2].matches("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*.\\w{2,4}$")) {
            throw new WrongEmailException("Wrong format of the email address! " +
                    "Available format of the email address example: \nvasily.petrov@gmail.com");
        }
        if (!components[3].matches("^\\+(\\d){11}$")) {
            throw new WrongPhoneNumberException("Wrong format of the phone number! " +
                    "Available format of the phone number example: \n+79215637722");
        }
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (name.split("\\s+").length != 2) {
            throw new IllegalArgumentException("Wrong name! Available name example: \nВасилий Петров");
        }
        if (!storage.containsKey(name.trim())) {
            throw new IllegalArgumentException("A client with this name is not in the database!");
        }
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}