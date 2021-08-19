package info.vladyslav.javabasics.u01core.core_01_base.bs24_eq_hc;

import java.util.Objects;

public class EqualsAndHashCode {
    int i;
    String s;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EqualsAndHashCode)) return false;
        EqualsAndHashCode that = (EqualsAndHashCode) o;
        return i == that.i && s.equals(that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, s);
    }

    {
        Object o;
    }
}
