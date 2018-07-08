package intro;

import intro.domain.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jsalvador on 09/06/18.
 */
public class BehaviourParameterization {

    private List<Apple> basicFilter(List<Apple> apples) {

        List<Apple> filteredApples = new ArrayList<>();

        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                filteredApples.add(apple);
            }
        }

        return filteredApples;
    }

    public static void main(String[] args) {


    }
}
