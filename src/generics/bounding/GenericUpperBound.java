package generics.bounding;

//parametre olarak aldığımız data tipini sınırlandırabiliriz.
//bu classta sadece Number ın alt sınıfları kullanılsın
public class GenericUpperBound<T extends Number> {
    //T:Integer,Double,Long,Float,Number; classı üstten sınırlandırdık

    private T[] numberArray;//field,özellik

    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    //numberArray içindeki değerlerin ortalamsını bulan metod
    public double getAverage() {
        double sum = 0;
        for (T t : this.numberArray) {
            sum += t.doubleValue();
        }
        double avg = sum / this.numberArray.length;
        return avg;
    }
    //main-metod
    public static void main(String[] args) {
        Integer[] intArr = {2, 3, 5, 99};
        Double[] doubleArr = {2.3, 5.5, 88.9};
        String[] strArr = {"Generic", "tipleri", "üstten", "sınırlandırabiliriz"};

        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>(intArr);
        System.out.println(obj1.getAverage());

        GenericUpperBound<Double> obj2 = new GenericUpperBound<>(doubleArr);
        System.out.println(obj2.getAverage());

        //   GenericUpperBound<String> obj3=new GenericUpperBound<>(strArr);-->CTE data tipini number ile sınırlandırdık.

    }
}