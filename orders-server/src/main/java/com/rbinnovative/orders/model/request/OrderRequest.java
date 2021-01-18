package com.rbinnovative.orders.model.request;

public class OrderRequest {
    private Integer id;
    private String name;

    public OrderRequest(){
//
    }
    public Integer getId() {
        return id;
    }

    public OrderRequest setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderRequest setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
