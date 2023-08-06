package parser;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface Parser extends UnaryOperator<String> {
}
