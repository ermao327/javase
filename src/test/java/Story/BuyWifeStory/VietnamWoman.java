package Story.BuyWifeStory;

public class VietnamWoman extends Woman{

    public VietnamWoman(int age, int face) {
        super(age, face);
    }

    @Override
    public Child bear() {
        return new Boy(50, 5);
    }
}
