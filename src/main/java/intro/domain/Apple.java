package intro.domain;

/**
 * Created by jsalvador on 16/05/18.
 */
public class Apple {
    private final String color;
    private final int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }
}
