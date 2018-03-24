package com.example.triangle.enums;

public enum TriangleType {

    NO_TRIANGLE(false, "No triangle"),
    EQUILATERAL(true, "Equilateral triangle"),
    ISOSCELES(true, "Isosceles triangle"),
    SCALENE(true, "Scalene triangle");

    private final boolean isTriangle;
    private final String description;

    TriangleType(boolean isTriangle, String description) {
        this.isTriangle = isTriangle;
        this.description = description;
    }

    public boolean isTriangle() {
        return isTriangle;
    }

    public String getDescription() {
        return description;
    }
}
