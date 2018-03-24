package com.example.triangle.business.rest.services.runtime;

import com.example.triangle.business.rest.services.api.TriangleService;
import com.example.triangle.enums.TriangleType;
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
        TriangleType answer;
        if (a == b && b == c) {
            answer = TriangleType.EQUILATERAL;
        } else if (a == b || b == c || a == c) {
            answer = TriangleType.ISOSCELES;
        } else {
            answer = TriangleType.SCALENE;
        }
        return answer;
    }
}
