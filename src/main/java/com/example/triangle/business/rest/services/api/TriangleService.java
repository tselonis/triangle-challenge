package com.example.triangle.business.rest.services.api;

import com.example.triangle.enums.TriangleType;

public interface TriangleService {

    TriangleType determineType(int a, int b, int c);
}
