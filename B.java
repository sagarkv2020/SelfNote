package acn;

class A {
    static int a = 1;

    static {
        System.out.println("A");
    }
}

public class B {
    static {
        System.out.println("B");
    }

    public static void main(String[] args) {
        System.out.println(A.a);
    }
}