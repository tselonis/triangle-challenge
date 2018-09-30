package com.example.triangle.service.runtime;

import com.example.triangle.service.api.TriangleService;
import com.example.triangle.domain.enums.TriangleType;
import org.springframework.stereotype.Component;

@Component
public class TriangleServiceImpl implements TriangleService {

    @Override
    public TriangleType determineType(int a, int b, int c) {
        return constituteTriangle(a,b,c) ? getType(a,b,c) : TriangleType.NO_TRIANGLE;
    }

    private boolean constituteTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    private TriangleType getType(int a, int b, int c) {
        TriangleType type;
        if (a == b && b == c) {
            type = TriangleType.EQUILATERAL;
        } else if (a == b || b == c || a == c) {
            type = TriangleType.ISOSCELES;
        } else {
            type = TriangleType.SCALENE;
        }
        return type;
    }
}
