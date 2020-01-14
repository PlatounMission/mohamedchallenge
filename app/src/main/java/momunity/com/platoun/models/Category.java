package momunity.com.platoun.models;

import java.util.ArrayList;

/**
 * Created by Mohamed Achref on 2020-01-10.
 */
public class Category {
    String id;
    String name;
    String image;
    ArrayList<Product> products;

    public Category(String id, String name,String image,ArrayList<Product> products) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.products = products;
    }

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }


    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
