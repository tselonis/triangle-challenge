package unit.com.example.triangle.business.rest.factories

import com.example.triangle.business.rest.factories.TriangleResponseFactory
import com.example.triangle.enums.TriangleType
import com.example.triangle.response.rest.TriangleResponse
import org.springframework.context.MessageSource
import spock.lang.Specification
import spock.lang.Unroll


class TriangleResponseFactorySpec extends Specification {

    @Unroll
    def "Should correctly create responses for #triangleType"() {
        given: "A type of triangle"
        MessageSource messageSourceMock = Mock(MessageSource.class)
        messageSourceMock.getMessage(triangleType.getDescription(), null, _) >> description
        TriangleResponseFactory triangleResponseFactory = new TriangleResponseFactory(messageSourceMock)

        when: "Create new response is requested"
        TriangleResponse response = triangleResponseFactory.createResponse(triangleType)

        then: "The correct response is generated"
        response.isTriangle() == triangleType.isTriangle()
        response.getDescription().equals(description)

        where:
        triangleType             | description
        TriangleType.NO_TRIANGLE | "No triangle"
        TriangleType.EQUILATERAL | "Equilateral triangle"
        TriangleType.ISOSCELES   | "Isosceles triangle"
        TriangleType.SCALENE     | "Scalene triangle"
    }
}