package lambda

import spock.lang.Specification

class MethodReferenceExampleTest extends Specification {

    def "ParseInt"() {
        when:
        def result = MethodReferenceExample.parseInt("1")
        then:
        result == 1
    }

    def "CreateByMethodReference"() {
        when:
        def result = MethodReferenceExample.createByMethodReference(1, 2, 3)
        then:
        result == [new Apple(1), new Apple(2), new Apple(3)]
    }
}
