package com.example.triangle.business.rest.factories;

import com.example.triangle.enums.TriangleType;
import com.example.triangle.response.rest.TriangleResponse;

public class TriangleResponseFactory {

    public static TriangleResponse createResponse(TriangleType triangleType) {
        return new TriangleResponse(triangleType.isTriangle(), triangleType.getDescription());
    }
}
