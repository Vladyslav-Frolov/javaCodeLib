package info.vladyslav.codelibrary.z_test;

import static info.vladyslav.codelibrary.z_test.RoomStatus.UNAVAILABLE;

public class Z_8 {
    public static void main(String[] args) {
        UNAVAILABLE.getName();
    }
}

enum RoomStatus {
    UNAVAILABLE, EXPIRED, BOOKED, OCCUPIED, COMPLETED;

    public String getName() {
        return name().toLowerCase();
    }

    @Override
    public String toString() {
        return getName();
    }
}