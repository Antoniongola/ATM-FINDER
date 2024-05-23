package com.ngolajr.cashfinderapifinal.dto;

public record AtmCreationDto(String local, boolean sistema, boolean papel, boolean dinheiro, double latitude, double longitude) {
}