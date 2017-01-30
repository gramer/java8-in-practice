package lambda

import spock.lang.Specification


class ConsumerExampleTest extends Specification {

    def "ForEach"() {
        given:
        def list = [1, 2, 3, 4, 5]

        when:
        def result = []
        ConsumerExample.forEach(list, { i -> result.add(i * 2) })

        then:
        result.size() == 5
        result.first() == 2
    }

}