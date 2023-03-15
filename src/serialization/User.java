package serialization;

import java.io.Serializable;

public class User implements Serializable {
    private long id;
    private String name;
    private String tcNo;

    public User(long id, String name, String tcNo) {
        this.id = id;
        this.name = name;
        this.tcNo = tcNo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tcNo='" + tcNo + '\'' +
                '}';
    }
}
