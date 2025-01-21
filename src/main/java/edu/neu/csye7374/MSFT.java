package edu.neu.csye7374;

public class MSFT extends Stock{
    public MSFT(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void setPrice(double price) {
        if(price> this.getPrice()) {
            int value = (int) ((price-this.getPrice())*80/this.getPrice());
            setMetric(this.getMetric() +value);
        }else {
            int value = (int) ((price-this.getPrice())*4/this.getPrice());
            setMetric(this.getMetric() +value);
        }
        this.price = price;
    }
}