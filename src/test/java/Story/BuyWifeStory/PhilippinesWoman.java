package Story.BuyWifeStory;
public class PhilippinesWoman extends Woman{

    public PhilippinesWoman(int age, int face) {
        super(age, face);
    }

    @Override
    public Child bear() {
        return new Girl(40, 4);
    }
}
