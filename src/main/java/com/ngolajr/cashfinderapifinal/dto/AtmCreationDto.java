package com.ngolajr.cashfinderapifinal.dto;

public record AtmCreationDto(String nome, String local, boolean sistema, boolean papel, boolean dinheiro, double latitude, double longitude) {
}