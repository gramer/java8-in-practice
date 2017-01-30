package lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PipelineByLambdaTest {

    static class Letter {
        static String addHeader(String text) {
            return "From Raoul, Mario and Alan: " + text;
        }

        static String addFooter(String text) {
            return text + " Kind regards";
        }

        public static String checkSpelling(String text) {
            return text.replaceAll("lamda", "lambda");
        }
    }

    @Test
    @DisplayName("Pipeline")
    void pipeline() {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader
                .andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);

        String result = transformationPipeline.apply("zeno lamda");
        assertEquals("From Raoul, Mario and Alan: zeno lambda Kind regards", result);
    }

}
