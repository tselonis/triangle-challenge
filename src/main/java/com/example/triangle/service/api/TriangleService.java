package com.example.triangle.service.api;

import com.example.triangle.domain.enums.TriangleType;

public interface TriangleService {

    TriangleType determineType(int a, int b, int c);
}
