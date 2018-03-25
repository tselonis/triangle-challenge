package unit.com.example.triangle.business.rest.facade

import com.example.triangle.business.rest.facade.runtime.TriangleFacadeImpl
import com.example.triangle.business.rest.factories.TriangleResponseFactory
import com.example.triangle.business.rest.services.api.TriangleService
import com.example.triangle.business.rest.services.runtime.TriangleServiceImpl
import com.example.triangle.enums.TriangleType
import com.example.triangle.response.rest.TriangleResponse
import spock.lang.Specification
import spock.lang.Unroll

class TriangleFacadeImplSpec extends Specification {

    @Unroll
    def "Should correctly create response for #triangleType"() {
        given: "Valid input user data"
        TriangleService triangleServiceMock = Mock(TriangleServiceImpl.class)
        TriangleResponseFactory triangleResponseFactoryMock = Mock(TriangleResponseFactory.class)
        TriangleFacadeImpl triangleFacade = new TriangleFacadeImpl(triangleServiceMock, triangleResponseFactoryMock)

        when: "Ask for triangle evaluation"
        TriangleResponse response = triangleFacade.evaluateTriangle(a, b, c)

        then: "The correct response being generated"
        1 * triangleServiceMock.determineType(a, b, c)  >> triangleType
        1 * triangleResponseFactoryMock.createResponse(triangleType) >> expectedResponse
        response.getDescription().equals(expectedResponse.getDescription())
        response.isTriangle() == expectedResponse.isTriangle()

        where:
        a | b | c | triangleType                | expectedResponse
        7 | 1 | 2 | TriangleType.NO_TRIANGLE    | new TriangleResponse(false, "No triangle")
        1 | 1 | 1 | TriangleType.EQUILATERAL    | new TriangleResponse(true, "Equilateral triangle")
        5 | 4 | 5 | TriangleType.ISOSCELES      | new TriangleResponse(true, "Isosceles triangle")
        7 | 4 | 5 | TriangleType.SCALENE        | new TriangleResponse(true, "Scalene triangle")

    }
}
