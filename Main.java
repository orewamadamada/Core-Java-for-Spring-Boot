import java.util.ArrayList;
import java.util.List;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class EWalletPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using E-Wallet");
    }
}

class Order {
    private final List<String> items = new ArrayList<>();
    private final PaymentStrategy paymentStrategy;

    public Order(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void checkout(double amount) {
        System.out.println("Checking out items: " + items);
        paymentStrategy.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPayment();
        Order order1 = new Order(creditCard);
        order1.addItem("Laptop");
        order1.checkout(1500.0);

        PaymentStrategy eWallet = new EWalletPayment();
        Order order2 = new Order(eWallet);
        order2.addItem("Mouse");
        order2.checkout(20.0);
    }
}
