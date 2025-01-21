package edu.neu.csye7374;

public class Stock implements Tradable {

    private String name;

    private String description;
    protected double price;

    private int metric;


    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.metric = 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(this.price > price) {
            setMetric(this.metric - 10);
        }else {
            setMetric(this.metric + 10);
        }
        this.price = price;
    }

    @Override
    public void setBid(String bid) {
        setPrice(Double.parseDouble(bid));
    }

    @Override
    public int getMetric() {
        return this.metric;
    }

    public void setMetric(int metric) {
        this.metric = metric;
    }

    @Override
    public String toString() {
        return "Stock{ \n" +
                "\t name='" + name + '\'' +
                ",\t price=" + price +
                ",\t description='" + description + '\'' +
                ",\t metric=" + metric +
                "\n }";
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}