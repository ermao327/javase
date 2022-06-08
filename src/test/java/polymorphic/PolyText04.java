package polymorphic;

public class PolyText04 {
    public static void main(String[]args)
    {
        // TODO: 用抽象类给一个有工资收入和稿费收入的小伙伴算税:
        Income1[] incomes = new Income1[] {new SalaryIncome(7500), new RoyaltyIncome(12000) };
        double total = 0;
        // TODO:
        for (Income1 in:incomes)
        {
            total += in.getTax();
        }
        System.out.println(total);
    }
}
/**
 * 计税的抽象类
 */
abstract  class Income1
{
    protected double income;

    public Income1(double income)
    {
        this.income = income;
    }
    public abstract double getTax();
}
/**
 * 工资计税
 */
class SalaryIncome extends Income1
{
    public SalaryIncome(double income)
    {
        super(income);
    }

    @Override
    public double getTax()
    {
        if (this.income <= 5000) {
            return 0;
        }
        return (this.income - 5000) * 0.2;
    }
}
/**
 * 稿费计税
 */
class RoyaltyIncome extends Income1
{
    public RoyaltyIncome(double income)
    {
        super(income);
    }

    @Override
    public double getTax()
    {
        return this.income * 0.1;
    }
}