import java.util.*;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    void updatePrice(double newPrice) {
        this.price = newPrice;
    }
}

class Transaction {
    String type;
    Stock stock;
    int quantity;

    Transaction(String type, Stock stock, int quantity) {
        this.type = type;
        this.stock = stock;
        this.quantity = quantity;
    }
}

class User {
    String name;
    double balance;
    Map<String, Integer> portfolio = new HashMap<>();
    List<Transaction> history = new ArrayList<>();

    User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void buyStock(Stock stock, int qty) {
        double cost = stock.price * qty;
        if (balance >= cost) {
            balance -= cost;
            portfolio.put(stock.symbol, portfolio.getOrDefault(stock.symbol,0) + qty);
            history.add(new Transaction("BUY", stock, qty));
            System.out.println("Bought " + qty + " of " + stock.symbol);
        } else {
            System.out.println("Not enough balance.");
        }
    }

    void sellStock(Stock stock, int qty) {
        int owned = portfolio.getOrDefault(stock.symbol, 0);
        if (owned >= qty) {
            balance += stock.price * qty;
            portfolio.put(stock.symbol, owned - qty);
            history.add(new Transaction("SELL", stock, qty));
            System.out.println("Sold " + qty + " of " + stock.symbol);
        } else {
            System.out.println("Not enough stock to sell.");
        }
    }

    void showPortfolio() {
        System.out.println("\nPortfolio of " + name + ":");
        for (String sym : portfolio.keySet()) {
            System.out.println(sym + ": " + portfolio.get(sym));
        }
        System.out.println("Balance: Rs." + balance+"\n");
    }
}

public class StockPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stock google = new Stock("COAL INDIA", 383.83);
        Stock apple = new Stock("ITC", 416.65);

        User user = new User("Gourab", 10000);

        while (true) {
            System.out.println("Welcome to Stock Exchange");
            System.out.println("1. Market Details \n2. Buy\n3. Sell\n4. Portfolio\n5. Exit");
            int ch = sc.nextInt();

            if (ch == 1) {

                System.out.println("Market Prices:");
                System.out.println("1. COAL INDIA - $" + google.price);
                System.out.println("2. ITC  - $" + apple.price);
            } else if (ch == 2) {
                System.out.println("Enter 1 for COAL INDIA, 2 for ITC:");
                int s = sc.nextInt();
                System.out.print("Enter quantity: ");
                int q = sc.nextInt();
                if (s == 1) user.buyStock(google, q);
                else if (s == 2) user.buyStock(apple, q);
            } else if (ch == 3) {
                System.out.println("Enter 1 for COAL INDIA, 2 for ITC:");
                int s = sc.nextInt();
                System.out.print("Enter quantity: ");
                int q = sc.nextInt();
                if (s == 1) user.sellStock(google, q);
                else if (s == 2) user.sellStock(apple, q);
            } else if (ch == 4) {
                user.showPortfolio();
            } else {
                break;
            }
        }
    }
}
