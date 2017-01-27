package jesusgsdev.shoppingcart.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by jesgarsal on 23/01/17.
 */
public class Cart {

    private List<Product> products;
    private Double total;

    public Cart() {
        this.products = new LinkedList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotal() {
        return products.stream().mapToDouble(p -> p.getPrice()).sum();
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void addProduct(Product p){
        this.products.add(p);
    }

    public void addNProduct(Product p, Integer amount){
        IntStream.rangeClosed(1,amount).forEach(i -> this.products.add(new Product(p)));
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                ", total=" + getTotal() +
                '}';
    }
}
