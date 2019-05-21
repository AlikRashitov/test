package testgroup.parts.model;

import javax.persistence.*;

@Entity
@Table(name = "computers")
public class Computer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "countt")
    private int countt;

    @Column(name = "needed")
    private boolean needed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountt() {
        return countt;
    }

    public void setCountt(int countt) {
        this.countt = countt;
    }

    public boolean isNeeded() {
        return needed;
    }

    public void setNeeded(boolean needed) {
        this.needed = needed;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + countt + " " + needed;
    }
}
