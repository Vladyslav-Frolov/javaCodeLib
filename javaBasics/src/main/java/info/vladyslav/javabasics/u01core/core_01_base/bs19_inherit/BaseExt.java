package info.vladyslav.javabasics.u01core.core_01_base.bs19_inherit;

public class BaseExt extends BaseImpl{
    @Override
    public void basic(){
        System.out.println("BaseExt out");
    }

    public static void main(String[] args) {
        BaseExt baseExt = new BaseExt();
        baseExt.basic();
    }
}
