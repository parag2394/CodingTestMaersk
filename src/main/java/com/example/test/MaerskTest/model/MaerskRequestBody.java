package com.example.test.MaerskTest.model;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MaerskRequestBody {

    @NotNull
    @Min(value = 80)
    @Max(value = 85)
    private int containerSize;

    @NotNull
    private ContainerType containerType;

    @NotNull
    @Size(min= 5,max = 20)
    private String origin;

    @NotNull
    @Size(min= 5,max = 20)
    private String destination;

    @NotNull
    @Min(1)
    @Max(100)
    private int quantity;

    private String timestamp;

    public MaerskRequestBody() {
    }

    public MaerskRequestBody(@NotNull @Min(value = 80) @Max(value = 85) int containerSize, @NotNull ContainerType containerType, @NotNull @Size(min = 5, max = 20) String origin, @NotNull @Size(min = 5, max = 20) String destination, @NotNull @Min(1) @Max(100) int quantity, String timestamp) {
        this.containerSize = containerSize;
        this.containerType = containerType;
        this.origin = origin;
        this.destination = destination;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public int getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(int containerSize) {
        this.containerSize = containerSize;
    }

    public ContainerType getContainerType() {
        return containerType;
    }

    public void setContainerType(ContainerType containerType) {
        this.containerType = containerType;
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
