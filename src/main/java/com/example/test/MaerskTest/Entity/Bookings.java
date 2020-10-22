package com.example.test.MaerskTest.Entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Bookings {

    @PrimaryKey
    private String id;

    private int container_Size;
    private String container_Type;
    private String origin;
    private String destination;
    private int quantity;
    private String timestamp;

    public Bookings() {
    }

    public Bookings(String id, int container_Size, String container_Type, String origin, String destination, int quantity, String timestamp) {
        this.id = id;
        this.container_Size = container_Size;
        this.container_Type = container_Type;
        this.origin = origin;
        this.destination = destination;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getContainer_Size() {
        return container_Size;
    }

    public void setContainer_Size(int container_Size) {
        this.container_Size = container_Size;
    }

    public String getContainer_Type() {
        return container_Type;
    }

    public void setContainer_Type(String container_Type) {
        this.container_Type = container_Type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
