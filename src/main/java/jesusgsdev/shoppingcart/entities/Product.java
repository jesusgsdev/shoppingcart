package jesusgsdev.shoppingcart.entities;

import jesusgsdev.shoppingcart.ShoppingRule;

import java.util.UUID;

/**
 * Created by jesgarsal on 23/01/17.
 */
public class Product {

    private UUID id;
    private String name;
    private Double price;
    private ShoppingRule rule;

    public Product(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.id = UUID.randomUUID();
    }

    public Product(String string) {
        String[] product = string.split(",");

        this.name = product[0].trim();
        this.price = Double.valueOf(product[1].trim());
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
        this.id = UUID.randomUUID();
    }

    private Product(Builder builder) {
        this.id = UUID.randomUUID();
        this.name = builder.name;
        this.price = builder.price;
    }

    public static Builder newProduct() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ShoppingRule getRule() {
        return rule;
    }

    public void setRule(ShoppingRule rule) {
        this.rule = rule;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id != null ? id.equals(product.id) : product.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "{" + name + ": $" + price + "}\n";
    }

    public static final class Builder {
        private String name;
        private Double price;

        private Builder() {
        }

        public Product build() {
            return new Product(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

    }
}
