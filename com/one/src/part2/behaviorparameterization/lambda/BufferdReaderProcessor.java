package one.src.part2.behaviorparameterization.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * ${DESCRIPTION}
 * One on 2018-11-29.
 */
@FunctionalInterface
public interface BufferdReaderProcessor {
    String process(BufferedReader reader) throws IOException;
}
