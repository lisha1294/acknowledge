class A {public A(){System.out.println("a");}
    public String toString(){return("A");}}
class B extends A {public B(){System.out.println("b");}
    public String toString(){return("B");}}
class C extends B {public C(){System.out.println("c");}
    public String toString(){return("C");}}
class D {public static void main(String [] args)
{A a_b = new B();System.out.print(a_b.toString());
 C c_c = new C();System.out.print(c_c.toString());
 //C c_a = new A();System.out.print(c_a.toString()); required new C()
 //C c_b = new B();System.out.print(c_b.toString()); "          "
}}