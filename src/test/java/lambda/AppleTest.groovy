package lambda

import spock.lang.Specification
import lambda.ApplePredicate
import static lambda.Apple.filterApples


/**
 * Created by coupang on 2017. 1. 21..
 */
class AppleTest extends Specification {

    def inventory = [new Apple("green"), new Apple("blue")]

    def "FilterApplesByColor"() {
        when:
        def result = Apple.filterApplesByColor(inventory, "blue")

        then:
        result.first().color == "blue"
    }

    def "FilterGreenApples"() {
        when:
        def result = Apple.filterGreenApples(inventory)

        then:
        result.first().color == "green"
    }

    def "FilterApplesByAnonymousClass"() {
        when:
        def result = filterApples(inventory as List<Apple>, new ApplePredicate() {
            @Override
            boolean test(Apple apple) {
                return "green".equals(apple.getColor())
            }
        })

        then:
        result.first().color == "green"
    }

}