package org.point;

import java.util.Objects;

public class LabeledPoint extends Point {
    private final String label;

    public LabeledPoint(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "label='" + label + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        if (!super.equals(obj)) {
            return false;
        }

        LabeledPoint other = (LabeledPoint) obj;

        return label.equals(other.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLabel());
    }
}
