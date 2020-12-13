package info.vladyslav.cl.javaBasics.u01core.core_07_lambda.lmbd_01_base;

public class Lambda01Basic {
    public static void main(String[] args) {
        /** классическая лямбда*/
        MyNumber myNumber = () -> 123.45;       // тип возращаемого значения заложен в абстрактном методе функционального интрефейса

        /** лямбда с вынесенным телом выражения*/
        MyNumber myNumber2 = () -> {            // остаётся только () ->
            return 123.45;                      // остаётся только 123.45
        };

        /** тот же код, но без лямбды — анонимный класс*/
        MyNumber myNumber3 = new MyNumber() {   // тут ничего не остаётся
            @Override
            public double getValue() {          // остаётся только (), далее идёт ->
                return 123.45;                  // остается только 123.45
            }
        };
//---------------------------------------------------------------------
        System.out.println(myNumber.getValue());
        System.out.println(myNumber2.getValue());
        System.out.println(myNumber3.getValue());
    }
}

@FunctionalInterface
interface MyNumber {
    double getValue();  // тип возвращаемого значения задан изначально
}