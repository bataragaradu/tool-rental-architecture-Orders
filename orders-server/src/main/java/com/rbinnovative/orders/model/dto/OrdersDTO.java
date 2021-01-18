package com.rbinnovative.orders.model.dto;

import java.time.LocalDate;

public class OrdersDTO {

    private Integer id;
    private String status;
    private String userId;
    private String toolId;
    private LocalDate startDate;
    private LocalDate endDate;

    public OrdersDTO(){
    }

    public Integer getId() {
        return id;
    }

    public OrdersDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public OrdersDTO setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public OrdersDTO setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getToolId() {
        return toolId;
    }

    public OrdersDTO setToolId(String toolId) {
        this.toolId = toolId;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public OrdersDTO setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public OrdersDTO setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", userId='" + userId + '\'' +
                ", toolId='" + toolId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
