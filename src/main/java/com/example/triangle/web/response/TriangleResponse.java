package com.example.triangle.web.response;

public class TriangleResponse {

    private boolean isTriangle;
    private String description;

    public TriangleResponse(boolean isTriangle, String description) {
        this.isTriangle = isTriangle;
        this.description = description;
    }

    public boolean isTriangle() {
        return isTriangle;
    }

    public void setTriangle(boolean triangle) {
        isTriangle = triangle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
