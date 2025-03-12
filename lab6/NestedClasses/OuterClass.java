package lab6.NestedClasses;

public class OuterClass {
    private String outerField = "Outer Field";

    // 1. Внутренний (Inner) класс
    class InnerClass {
        void display() {
            System.out.println("Inner Class accessing: " + outerField);
        }
    }

    // 2. Статический вложенный (Static Nested) класс
    static class StaticNestedClass {
        void display() {
            System.out.println("Static Nested Class.");
        }
    }

    // 3. Член-классы (Member Classes)
    class MemberClass1 {
        void show() {
            System.out.println("Member Class 1");
        }
    }

    class MemberClass2 {
        void show() {
            System.out.println("Member Class 2");
        }
    }

    class MemberClass3 {
        void show() {
            System.out.println("Member Class 3");
        }
    }

    // Метод, содержащий локальные и анонимные классы
    void demonstrateLocalAndAnonymousClasses() {
        // 4. Локальный (Local) класс
        class LocalClass1 {
            void show() {
                System.out.println("Local Class 1");
            }
        }
        LocalClass1 local1 = new LocalClass1();
        local1.show();

        class LocalClass2 {
            void show() {
                System.out.println("Local Class 2");
            }
        }
        LocalClass2 local2 = new LocalClass2();
        local2.show();

        // 5. Анонимный (Anonymous) класс
        Runnable anonymousClass1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Class 1");
            }
        };
        anonymousClass1.run();

        Runnable anonymousClass2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Class 2");
            }
        };
        anonymousClass2.run();

        Runnable anonymousClass3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Class 3");
            }
        };
        anonymousClass3.run();
    }

    public void runAll() {
        // Создание объектов и вызов методов для демонстрации
        InnerClass inner = new InnerClass();
        inner.display();

        StaticNestedClass staticNested = new StaticNestedClass();
        staticNested.display();

        MemberClass1 m1 = new MemberClass1();
        MemberClass2 m2 = new MemberClass2();
        MemberClass3 m3 = new MemberClass3();
        m1.show();
        m2.show();
        m3.show();

        demonstrateLocalAndAnonymousClasses();
    }
}
