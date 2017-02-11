package jesusgsdev.shoppingcart.entities;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jesgarsal on 11/02/17.
 */
public class ProductTest {

    @Test
    public void when_CreateProduct_DataIsThereAndNoRules(){
        String name = "Pizza";
        Double price = 14.40;

        Product p = new Product(name, price);

        Assert.assertEquals(p.getName(), name);
        Assert.assertEquals(p.getPrice(), price);
        Assert.assertNull(p.getRule());
    }


    @Test
    public void when_CreateProductByString_DataIsThereAndNoRules(){
        String name = "Pizza";
        Double price = 14.40;
        String product = name+ "," + price;

        Product p = new Product(product);

        Assert.assertEquals(p.getName(), name);
        Assert.assertEquals(p.getPrice(), price);
        Assert.assertNull(p.getRule());
    }

    @Test
    public void when_CreateProductByBuilder_DataIsThereAndNoRules(){
        String name = "Pizza";
        Double price = 14.40;

        Product p = Product.newProduct().name(name).price(price).build();

        Assert.assertEquals(p.getName(), name);
        Assert.assertEquals(p.getPrice(), price);
        Assert.assertNull(p.getRule());
    }

    @Test
    public void when_ProductIsOutPut_ProductStringComesOut(){
        String name = "Pizza";
        Double price = 14.40;
        Product p = Product.newProduct().name(name).price(price).build();

        String output = p.toString();
        String expectedOutput = "{" + name + ": $" + price + "}\n";

        Assert.assertEquals(output, expectedOutput);
    }

    @Test
    public void when_CreateTwoProducts_Then_BothAreDifferent(){
        String name = "Pizza";
        Double price = 14.40;

        Product p = Product.newProduct().name(name).price(price).build();
        Product p2 = Product.newProduct().name(name).price(price).build();

        Assert.assertNotEquals(p.hashCode(), p2.hashCode());
        Assert.assertFalse(p.equals(p2));
    }

    @Test
    public void when_CloneProducts_Then_BothAreDifferent(){
        String name = "Pizza";
        Double price = 14.40;

        Product p = Product.newProduct().name(name).price(price).build();
        Product p2 = new Product(p);

        Assert.assertNotEquals(p.hashCode(), p2.hashCode());
        Assert.assertFalse(p.equals(p2));
    }

}
