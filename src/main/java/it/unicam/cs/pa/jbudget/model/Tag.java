package it.unicam.cs.pa.jbudget.model;

import java.util.Objects;

public class Tag implements TagInterface {

    private int id;
    private String name;

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setId(int o) { this.id = o;    }

    @Override
    public void setName(String s) {this.name = s;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag tag = (Tag) o;
        return getId() == tag.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
