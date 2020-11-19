package info.vladyslav.cl.javaBasics.u04patterns.gof_1_creational.crea_2_factory_method.facM2;

// 2-й этап создания → вынесение метода для девелопера в интерфейс
interface Developer {
    void writeCode();
}

// 3-й этап создания → добавление интрефейса и класса, которые порождают объекты
interface DeveloperFactory {
    Developer createDeveloper();
}

class FactoryMethodRun {
    public static void main(String[] args) {
        // создание через 2 интерфейса при помощи метода-переключателя, где нужно заменить только принимаемый аргумент
        DeveloperFactory developerFactorySwitch = createDeveloperBySpecialty("java");
        Developer developerSwitch = developerFactorySwitch.createDeveloper();
        developerSwitch.writeCode();

        // создание через 2 интерфейса (основной-Developer и порождающий-DeveloperFactory)
        DeveloperFactory developerFactory = new JavaDeveloperFactory(); // порождающий интерфейс + вызов порождающего класса
        Developer developer = developerFactory.createDeveloper(); // основной интерфейс + объект порождающего интрефейса
        developer.writeCode();

        // создание через основной интрефейс Developer
        Developer cppDeveloper = new CppDeveloper();
        cppDeveloper.writeCode();

        // создание напрямую
        JavaDeveloper java2Developer = new JavaDeveloper();
        java2Developer.writeCode();
    }

    static DeveloperFactory createDeveloperBySpecialty(String specialty) {
        if (specialty.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (specialty.equalsIgnoreCase("C++")) {
            return new CppDeveloperFactory();
        }else{
            throw new RuntimeException(specialty + " is unknown specialty");
        }
    }
}

//3-й этап создания → добавление интрефейса и класса, которые порождают объекты
class JavaDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() { // возвращает экземпляр интрефейса
        return new JavaDeveloper(); // класс созданного объекта имплементирует интерфейс Developer
    }
}

class CppDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}

// 1-й этап создания
class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes java code...");
    }
}

class CppDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("C++ developer write C++ code...");
    }
}
