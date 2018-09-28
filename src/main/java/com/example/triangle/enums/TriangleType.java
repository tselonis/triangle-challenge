package com.example.triangle.enums;

public enum TriangleType {

    NO_TRIANGLE(false, "triangle.no"),
    EQUILATERAL(true, "triangle.equilateral"),
    ISOSCELES(true, "triangle.isosceles"),
    SCALENE(true, "triangle.scalene");

    private final boolean isTriangle;
    private final String messageKey;

    TriangleType(boolean isTriangle, String messageKey) {
        this.isTriangle = isTriangle;
        this.messageKey = messageKey;
    }

    public boolean isTriangle() {
        return isTriangle;
    }

    public String getMessageKey() {
        return messageKey;
    }
}
