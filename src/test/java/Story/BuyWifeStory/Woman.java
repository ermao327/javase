package Story.BuyWifeStory;

public abstract  class Woman {

    private int age;

    private int face;

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "age=" + age +
                ", face=" + face +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public Woman(int age, int face) {
        this.age = age;
        this.face = face;
    }

    public abstract Child bear();
}
