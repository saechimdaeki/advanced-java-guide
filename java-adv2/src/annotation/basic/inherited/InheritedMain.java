package annotation.basic.inherited;

import java.lang.annotation.Annotation;

public class InheritedMain {

    public static void main(String[] args) {
        print(Parent.class);
        print(Child.class); // InheritedAnnotation만 받음
        print(TestInterface.class);
        print(TestInterfaceImpl.class); // 애노테이션 상속 받을 수 없음
    }

    private static void print(Class<?> clazz) {
        System.out.println("class: " + clazz);
        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println(" - " + annotation.annotationType().getSimpleName());
        }
        System.out.println();
    }
}
