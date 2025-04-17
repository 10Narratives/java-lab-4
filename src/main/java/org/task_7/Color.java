package org.task_7;

public enum Color {
    BLACK(0, 0, 0),
    RED(1, 0, 0),
    GREEN(0, 1, 0),
    BLUE(0, 0, 1),
    CYAN(0, 1, 1),
    MAGENTA(1, 0, 1),
    YELLOW(1, 1, 0),
    WHITE(1, 1, 1);

    private final int red;
    private final int green;
    private final int blue;

    Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
