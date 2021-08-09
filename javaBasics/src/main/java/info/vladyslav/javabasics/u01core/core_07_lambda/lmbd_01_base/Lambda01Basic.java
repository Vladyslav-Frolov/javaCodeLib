package info.vladyslav.javabasics.u01core.core_07_lambda.lmbd_01_base;

public class Lambda01Basic {
    public static void main(String[] args) {
        /** классическая лямбда*/
        MyNumber myNumber = () -> 123.45;       // тип возращаемого значения заложен в абстрактном методе функционального интрефейса

        /** лямбда с вынесенным телом выражения*/
        MyNumber myNumber2 = () -> {            // остаётся только () ->
            System.out.print("промежуточное вычисление --> ");
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
        System.out.println(myNumber.getValue()); // 123.45
        System.out.println(myNumber2.getValue()); // промежуточное вычисление --> 123.45
        System.out.println(myNumber3.getValue());  // 123.45
    }
}

@FunctionalInterface // только один абстрактный метод
interface MyNumber {

    double getValue();  // тип возвращаемого значения задан изначально // только один абстрактный метод

    static double getStaticValue() { // разрешается статический метод
        return 50.;
    }

    default double getDefaultValue(){ // разрешается метод по умолчанию
        return 100.;
    }
}