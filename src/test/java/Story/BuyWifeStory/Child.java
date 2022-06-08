package Story.BuyWifeStory;

public class Child {

    private int height;

    private int weight;

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Child(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
}
