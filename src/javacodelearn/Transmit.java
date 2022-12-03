package javacodelearn;

/**
 * @author foanxi
 */
public class Transmit {
    public static void main(String[] args) {
        System.out.println("基本类型------------------");
        int a = 0;
        System.out.println("改变之前" + a);
        changeBasic(a);
        System.out.println("改变之后" + a);

        System.out.println("引用类型String-------------");
        String b = "yes";
        System.out.println("改变之前" + b);
        changeString(b);
        System.out.println("改变之后" + b);

        System.out.println("引用类型-------------------");
        Student student = new Student("A",10);
        System.out.println("改变之前" + student);
        changeQuote(student);
        System.out.println("改变之后" + student);
    }

    public static void changeBasic(int a){
        a = 1;
    }

    public static void changeString(String b){
        b = "no";
    }

    public static void changeQuote(Student param){
        param.setName("B");
        param.setAge(12);
    }
}
