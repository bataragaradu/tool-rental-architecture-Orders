package com.rbinnovative.orders.model.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "\"orders\"")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "First Name cannot be null")
    private Integer id;
    @Column(name = "[status]")
    private String status;
    @Column(name = "[user_id]")
    private String userId;
    @Column(name = "[tool_id]")
    private String toolId;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "[start_date]")
    private LocalDate startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "[end_date]")
    private LocalDate endDate;

    public Orders() {
    }

    public Integer getId() {
        return id;
    }

    public Orders setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Orders setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Orders setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getToolId() {
        return toolId;
    }

    public Orders setToolId(String toolId) {
        this.toolId = toolId;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Orders setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Orders setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
}
