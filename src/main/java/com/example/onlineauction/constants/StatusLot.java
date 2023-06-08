package com.example.onlineauction.constants;

public enum StatusLot {
    AWAITING_CONFIRMATION("Ожидает подтверждения"),
    ACTIVE("Активный"),
    COMPLETED("Завершен");

    private final String status;

    StatusLot(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}