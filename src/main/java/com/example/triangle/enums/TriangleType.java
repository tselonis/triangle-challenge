package com.example.triangle.enums;

public enum TriangleType {

    NO_TRIANGLE(false, "triangle.no"),
    EQUILATERAL(true, "triangle.equilateral"),
    ISOSCELES(true, "triangle.isosceles"),
    SCALENE(true, "triangle.scalene");

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
