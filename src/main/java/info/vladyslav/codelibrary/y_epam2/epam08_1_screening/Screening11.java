package info.vladyslav.codelibrary.y_epam2.epam08_1_screening;

public class Screening11 {

}
/**
 * "X extends Y" is correct if and only if X is an interface and Y is a class; --
 * "X extends Y" is correct if and only if X is a class and Y is an interface; --
 * "X extends Y" is correct for all compilations of X and Y being classes and/or interface; --
 * "X extends Y" is correct if X and Y are either both classes or both all interfaces; <-- correct
 * */

class Y{

}
class X extends Y{

        }