package it.unicam.cs.pa.jbudget.model;

import java.util.Objects;

public class Tag implements TagInterface {

    private int id;
    private String name;
    aa //TODO tutto
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setId(int o) {

    }

    @Override
    public void setName(String s) {

    }

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
