package com.example.triangle.business.rest.facade.api;

import com.example.triangle.response.rest.TriangleResponse;

public interface TriangleFacade {

    TriangleResponse evaluateTriangle(int a, int b, int c);
}
