package info.vladyslav.javabasics.u01core.core_01_base.bs04_abstractClasses;

public class InstantOfAbstractClassProhibitet extends AbstractClass {
    @Override
    void test() {

    }
    // Выдаст ошибку т. к. создавать объекты абстрактного класса запрещено,
    // если в абстрактном классе убрать отметку abstract, то экземпляр создать можно.
    // Ключевым словом abstract можно закрывать все экземпляры класса.
//    AbstractClass abstract1 = new AbstractClass();

}
