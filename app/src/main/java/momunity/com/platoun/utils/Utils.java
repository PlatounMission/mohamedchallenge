package momunity.com.platoun.utils;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

import momunity.com.platoun.models.Category;
import momunity.com.platoun.models.Product;

/**
 * Created by Mohamed Achref on 2020-01-10.
 */
public class Utils {

    public void showFragment(Fragment fragment, int layout, FragmentManager fragmentManager) {
        fragmentManager.beginTransaction()
                .replace(layout, fragment)
                .commit();
    }



    public static ArrayList<Category> createCategoryProductData() {

        //Stroller
        Product product = new Product("-8%", "product_stroller_1", "note", "Evening Dress", "Dorothy Perkins", "315$", "290$", false);
        Product product1 = new Product("-8%", "product_stroller_2", "note", "Sport Dress", "Sitlly", "315$", "290$", false);
        Product product2 = new Product("-8%", "product_stroller_3", "note", "Sport Dress", "Dorothy Perkins", "315$", "290$", false);

        //Food
        Product product3 = new Product("-20%", "product_food_1", "note", "Ratatouille légume", "OVS", "15$", "12$", false);
        Product product4 = new Product("-20%", "product_food_2", "note", "Ratatouille purée", "Mango Boy", "15$", "12$", false);
        Product product5 = new Product("-20%", "product_food_3", "note", "Petit pot carotte", "Cool", "15$", "12$", false);

        //Toys
        Product product6 = new Product("-20%", "product_toys_1", "note", "Table Baby", "OVS", "15$", "12$", false);
        Product product7 = new Product("-20%", "product_toys_2", "note", "Baby Soother", "Mango Boy", "15$", "12$", false);
        Product product8 = new Product("-20%", "product_toys_3", "note", "Hip fruits", "Cool", "15$", "12$", false);

        ArrayList<Product> products = new ArrayList<>();

        products.add(product);
        products.add(product1);
        products.add(product2);

        Category category = new Category("0", "Stroller","category_stroller", products);

        products = new ArrayList<>();

        products.add(product3);
        products.add(product4);
        products.add(product5);

        Category category1 = new Category("1", "Food","category_food", products);

        products = new ArrayList<>();

        products.add(product6);
        products.add(product7);
        products.add(product8);

        Category category2 = new Category("2", "Toys","category_toys", products);

        ArrayList<Category> categories = new ArrayList<>();

        categories.add(category);
        categories.add(category1);
        categories.add(category2);

        return categories;
    }


    public static ArrayList<Category> createTypeDealData() {

        Category typeDeal = new Category("0", "Group Deals");
        Category typeDeal1 = new Category("1", "Voucher code");
        Category typeDeal2 = new Category("2", "Best deals");

        ArrayList<Category> typeDeals = new ArrayList<>();
        typeDeals.add(typeDeal);
        typeDeals.add(typeDeal1);
        typeDeals.add(typeDeal2);

        return  typeDeals;

    }

    public static ArrayList<Category> createCategoryData() {

        Category category = new Category("0", "Food");
        Category category1 = new Category("1", "Toys");
        Category category2 = new Category("2", "Stroller");
        Category category3 = new Category("3", "Clothings");
        Category category4 = new Category("4", "For moms");
        Category category5 = new Category("5", "Furniture");
        Category category6 = new Category("6", "Hygiene");

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(category);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);
        categories.add(category6);


        return  categories;
    }



    public static ArrayList<Category> createCategoryFilterData() {

        //Stroller
        Product product = new Product("-8%", "product_stroller_1", "note", "Evening Dress", "Dorothy Perkins", "315$", "290$", false);
        Product product1 = new Product("-8%", "product_stroller_2", "note", "Sport Dress", "Sitlly", "315$", "290$", false);
        Product product2 = new Product("-8%", "product_stroller_3", "note", "Sport Dress", "Dorothy Perkins", "315$", "290$", false);

        //Food
        Product product3 = new Product("-20%", "product_food_1", "note", "Ratatouille légume", "OVS", "15$", "12$", false);
        Product product4 = new Product("-20%", "product_food_2", "note", "Ratatouille purée", "Mango Boy", "15$", "12$", false);
        Product product5 = new Product("-20%", "product_food_3", "note", "Petit pot carotte", "Cool", "15$", "12$", false);

        //Toys
        Product product6 = new Product("-20%", "product_toys_1", "note", "Table Baby", "OVS", "15$", "12$", false);
        Product product7 = new Product("-20%", "product_toys_2", "note", "Baby Soother", "Mango Boy", "15$", "12$", false);
        Product product8 = new Product("-20%", "product_toys_3", "note", "Hip fruits", "Cool", "15$", "12$", false);

        ArrayList<Product> products = new ArrayList<>();

        products.add(product);
        products.add(product1);
        products.add(product2);

        Category category = new Category("0", "Stroller","category_stroller", products);

        products = new ArrayList<>();

        products.add(product3);
        products.add(product4);
        products.add(product5);

        Category category1 = new Category("1", "Food","category_food", products);

        products = new ArrayList<>();

        products.add(product6);
        products.add(product7);
        products.add(product8);

        Category category2 = new Category("2", "Toys","category_toys", products);

        ArrayList<Category> categories = new ArrayList<>();



        Category category3 = new Category("3", "Clothings");
        Category category4 = new Category("4", "For moms");
        Category category5 = new Category("5", "Furniture");
        Category category6 = new Category("6", "Hygiene");

        categories.add(category);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);
        categories.add(category6);


        return  categories;
    }
}
