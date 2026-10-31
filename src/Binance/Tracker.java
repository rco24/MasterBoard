package Binance;

public class Tracker {
    private String symbol;
    private String price;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrice() {
        System.out.println("Testing....");
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
