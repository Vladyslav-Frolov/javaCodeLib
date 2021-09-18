package info.vladyslav.javabasics.z_test.old;


public class Z_8 {
    public static void main(String[] args) {
        System.out.println(RoomStatus.UNAVAILABLE.getName());
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
}