package AdvJavaPractice.generics.classes;

/*
==Generic Types==
-Java 5 ile geldi
-Farklı data tipleri ile aynı yapıyı kullanabilme
-Tip güvenliği sağlar, castinge gerek olmaz
-CTE verir.
-Generics primitive data tipi ile çalışmaz.

Task: 1) Java dersi için, öğrencileri isim, vize notu ve final notunu  ile birlikte
                                                        listeleyen bir program yazınız.
      2) Kütüphane için, öğrencileri isim, okul no ve mail adresi ile birlikte
                                                        listeleyen bir program yazınız.
*/
public class StudentLists {

    public static void main(String[] args) {

        System.out.println("***************  vize ve final notlari  ***************");
        listGrade();
        System.out.println("*******************************************************");
        listMemberOfLibrary();

    }

    private static void listGrade() {
        Student<String, Double, Double> student1 = new Student<>("Gulsum", 100.0, 100.0);
        Student<String, Double, Double> student2 = new Student<>("halil", 90.0, 90.0);
        Student<String, Double, Double> student3 = new Student<>("Erkan", 95.0, 95.0);

        System.out.printf("||  %-10s  ||  %7s  ||  %7s  || %n", student1.getS(), student1.getU(), student1.getV());
        System.out.printf("||  %-10s  ||  %7s  ||  %7s  || %n", student2.getS(), student2.getU(), student2.getV());
        System.out.printf("||  %-10s  ||  %7s  ||  %7s  || %n", student3.getS(), student3.getU(), student3.getV());
    }

    private static void listMemberOfLibrary() {
        Student<String, Integer, String> student1 = new Student<>("Gulsum", 1001, "gulsum@gmail.com");
        Student<String, Integer, String> student2 = new Student<>("halil", 1002, "halil@gmail.com");
        Student<String, Integer, String> student3 = new Student<>("Erkan", 1003, "erkan@gmail.com");

        System.out.printf("||  %-10s  ||  %8s ||  %-16s  || %n", student1.getS(), student1.getU(), student1.getV());
        System.out.printf("||  %-10s  ||  %8s ||  %-16s  || %n", student2.getS(), student2.getU(), student2.getV());
        System.out.printf("||  %-10s  ||  %8s ||  %-16s  || %n", student3.getS(), student3.getU(), student3.getV());
    }
}
