package org.isayan.library.utils;

/**
 * <a href="https://gist.github.com/JBlond/2fea43a3049b38287e5e9cefc87b2124">...</a>
 */
public class AnsiColor {

    private static final String RESET = "[0m";

    public static String boldGreen() {
        return new Builder()
                .bold()
                .build();
    }

    public static String reset() {
        return "\u001B%s".formatted(RESET);
    }

    public static class Builder {
        private Style style = Style.REGULAR;
        private Color color = Color.GREEN;

        public Builder bold() {
            this.style = Style.BOLD;
            return this;
        }

        public String build() {
            return "\u001B[%s;%sm".formatted(style.code, color.code);
        }

        private enum Color {
            GREEN("32");

            final String code;

            Color(String code) {
                this.code = code;
            }
        }

        private enum Style {
            REGULAR("0"),
            BOLD("1");

            final String code;

            Style(String code) {
                this.code = code;
            }

        }
    }
}