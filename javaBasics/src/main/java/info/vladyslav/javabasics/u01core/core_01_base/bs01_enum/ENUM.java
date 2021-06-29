package info.vladyslav.javabasics.u01core.core_01_base.bs01_enum;

import java.util.Arrays;

public enum ENUM {
    FIRST("First"), SECONDS, THIRD;

    /**Для вывода удовлетворительного для конечного пользователя, нужно создать переменную и 2 конструктора*/
    String name;


    ENUM(String first) {
        this.name = first;
    }

    ENUM() {
    }
}

class TestEnum {
    public static void main(String[] args) {
        /** получение номер перечисления по порядку начина с нуля «0»*/
        System.out.println(ENUM.SECONDS.ordinal()); // 1
        System.out.println(ENUM.valueOf("SECONDS").ordinal()); // 1

        /**Положить и достать енам через поле класса*/
        Order order = new Order();
        order.setRoomOrderStatus(ENUM.THIRD);
        System.out.println(order.getRoomOrderStatus().ordinal() + 1); // 3

        /**передачала элемента перечисления по его порядковому номеру*/
        System.out.println(ENUM.values()[2 - 2]); // FIRST

        /**Вывод всех енамов*/
        System.out.println(Arrays.toString(ENUM.values())); // [FIRST, SECONDS, THIRD]

        /**Вывод енама по имени, регистр имеет значение*/
        System.out.println(ENUM.valueOf("SECONDS")); // SECONDS


        /**Вывод нормального имени енама для конечного пользователя*/
        System.out.println(ENUM.FIRST.name); // First
        System.out.println(ENUM.SECONDS.name); // null
    }
}

class Order {
    private ENUM roomOrderStatus;

    public ENUM getRoomOrderStatus() {
        return roomOrderStatus;
    }

    public void setRoomOrderStatus(ENUM roomOrderStatus) {
        this.roomOrderStatus = roomOrderStatus;
    }
}