package com.example.trabalho1unidade.model;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Pair<Product, Integer>> products; // <Product, Quantity>

    public Cart() {
        this.products = new ArrayList<Pair<Product, Integer>>();
    }

    public Cart(ArrayList<Pair<Product, Integer>> products) {
        this.products = new ArrayList<Pair<Product, Integer>>();
        this.products.addAll(products);
    }

    public int getQuantity(Product product) {
        for(Pair<Product, Integer> _product: this.products){
            if(_product.first == product){ return _product.second; }
        }
        return 0;
    }

    public ArrayList<Pair<Product, Integer>> getProducts() {
        return this.products;
    }

    public float getTotalPrice() {
        float total_price = 0;
        for(Pair<Product, Integer> product: this.products){
            total_price += product.first.getPrice() * product.second;
        }
        return total_price;
    }

    public int getTotalQuantity(){
        int total_quantity = 0;
        for(Pair<Product, Integer> product: this.products){
            total_quantity += product.second;
        }
        return total_quantity;
    }

    public void addProduct(Product product, int quantity) {
        for(int i = 0; i < this.products.size(); i++){
            if(this.products.get(i).first == product){this.products.remove(i); break;}
        }

        this.products.add(new Pair<Product, Integer>(product, quantity));
    }

    public void removeProduct(Product product){
        for(int i = 0; i < this.products.size(); i++){
            if(this.products.get(i).first == product){
                this.products.remove(i);
                return;
            }
        }
    }

    public void updateQuantity(Product product, int new_quantity){
        this.addProduct(product, new_quantity);
    }

    public void loadCartFromIntentBundle(Bundle data){
        int cart_size = data.getInt("cart_size");
        for(int i = 0; i < cart_size; i++){
            this.addProduct((Product) data.getSerializable("product_"+i), data.getInt("quantity_"+i));
        }
    }

    public Intent saveCartToIntentBundle(Intent it){
        int cart_size = this.getProducts().size();
        it.putExtra("cart_size", cart_size);
        for(int i = 0; i < cart_size; i++){
            it.putExtra("product_"+i, this.getProducts().get(i).first);
            it.putExtra("quantity_"+i, this.getProducts().get(i).second);
        }
        return it;
    }
}
