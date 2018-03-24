package com.example.triangle.business.rest.facade.runtime;

import com.example.triangle.business.rest.facade.api.TriangleFacade;
import com.example.triangle.business.rest.factories.TriangleResponseFactory;
import com.example.triangle.business.rest.services.api.TriangleService;
import com.example.triangle.response.rest.TriangleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TriangleFacadeImpl implements TriangleFacade {

    private TriangleService triangleService;

    @Autowired
    public TriangleFacadeImpl(TriangleService triangleService) {
        this.triangleService = triangleService;
    }

    @Override
    public TriangleResponse evaluateTriangle(int a, int b, int c) {
        return TriangleResponseFactory.createResponse(triangleService.determineType(a, b, c));
    }
}
