package Story.BuyWifeStory;

public class CambodiaWoman extends Woman{

    public CambodiaWoman(int age, int face) {
        super(age, face);
    }

    @Override
    public Child bear() {
        return new Girl(60, 10);
    }
}
