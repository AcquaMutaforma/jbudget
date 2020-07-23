package it.unicam.cs.pa.jbudget102627.ledge;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Rappresenta un singolo movimento di denaro.
 */
public class Movement implements MovementInterface {

    private final int id;
    private double value;
    private String motivation;
    private MovementType type;
    private List<Integer> tagList;
    private LocalDate date;
    private int accountid;

    public Movement(int i, double val, String motiv, MovementType mt,
                    List<Integer> tag, LocalDate ld, AccountInterface a ){
        this.id = i;
        setValue(val);
        setMotivation(motiv);
        setType(mt);
        setTags(tag);
        setDate(ld);
        setAccount(a);
    }

    @Override
    public int getId() {return this.id;}

    @Override
    public String getMotivation() {return this.motivation;}

    @Override
    public double getValue() {return this.value;}

    @Override
    public MovementType getType() {return this.type;}

    @Override
    public List<Integer> getTags() {return this.tagList;}

    @Override
    public LocalDate getDate() {return this.date;}

    @Override
    public int getAccountId() {return this.accountid;}

    @Override
    public void setMotivation(String m) {this.motivation = m;  }

    @Override
    public void setValue(double d) {this.value = d;}

    @Override
    public void setType(MovementType mt) {this.type = mt;}

    @Override
    public void setTags(List<Integer> l) {this.tagList = l;}

    @Override
    public void setDate(LocalDate d) {this.date = d;}

    @Override
    public void setAccount(AccountInterface a) {this.accountid= a.getId();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movement)) return false;
        Movement movement = (Movement) o;
        return getId() == movement.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public void addTag(TagInterface c) {
        if(!getTags().contains(c.getId()))
            getTags().add(c.getId());
    }

    @Override
    public boolean rmTag(TagInterface c) {
        if(getTags().contains(c.getId())){
            getTags().remove(c.getId());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void addTag(int c) {
        if(!this.tagList.contains(c))
            this.tagList.add(c);
    }

    @Override
    public boolean rmTag(int c) {
        if(this.tagList.contains(c)) {
            this.tagList.remove(c);
            return true;
        }
        return false;
    }

}
