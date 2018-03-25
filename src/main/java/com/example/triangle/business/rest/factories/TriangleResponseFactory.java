package com.example.triangle.business.rest.factories;

import com.example.triangle.enums.TriangleType;
import com.example.triangle.response.rest.TriangleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TriangleResponseFactory {

    private MessageSource messageSource;
    private Locale locale;

    @Autowired
    public TriangleResponseFactory(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public TriangleResponse createResponse(TriangleType triangleType) {
        return new TriangleResponse(triangleType.isTriangle(), messageSource.getMessage(triangleType.getDescription(), null, locale));
    }
}
