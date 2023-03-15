package generics.classes;

public class NonGenericClass {

    //field(özellik):farklı data tiplerini referans alsın

    //private T type;
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
