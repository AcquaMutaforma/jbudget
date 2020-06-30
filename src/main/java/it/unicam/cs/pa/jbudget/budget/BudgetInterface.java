package it.unicam.cs.pa.jbudget.budget;

import it.unicam.cs.pa.jbudget.model.TagInterface;

import java.util.List;
import java.util.Map;

public interface BudgetInterface {

    String getName();
    int getId();
    List<TagInterface> getTags();
    double getValueOf(TagInterface c);
    void set(TagInterface c, double expected);
    Map<TagInterface, Double> getMap();
    List<TagInterface> getFilter();

    /*
    PROBABILMENTE NON TI SERVE A NIENTE, IL BUDGET E' SENZA IL REPORT,
    QUINDI SONO LA STESSA COSA

    idea:
    inserisco come valore aspettato " 0 " per non calcolare quel tag,
    magari perché è solo descrittivo, come l'anno o un altro tag di cui non importa
    il calcolo ( esempio @2020 = 0, e non calcolo il budget speso nei movimenti con @2020
    ma calcolo gli altri tag nel budget come @carburante = x && @2020 = 0 calcolo solo
    i tag presenti nei movimenti con i tag cercati :@carburante && @2020 non calcolando
    il valore di tutti questi con @2020 perche' sarebbe ridondante)
     */
}
