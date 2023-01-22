package finances;

import java.util.Arrays;
import java.util.Objects;

public class Money extends Finances {
    private int amount;
    private int[] banknotes;

    public Money(int amount){
        this.amount=amount;
        this.banknotes = new int[(amount-amount%5)/5];
        for(int i = 0; i < this.banknotes.length; i++)
            banknotes[i] = 5;
    }
    public Money(int[] banknotes){
        this.banknotes=banknotes;
        this.amount = Arrays.stream(banknotes).sum();
    }
    public int[] getBanknotes(){return banknotes;}
    public void setBanknotes(int[] banknotes){if(banknotes != null && banknotes.length > 0 && Arrays.stream(banknotes).allMatch(e -> e==5||e==20||e==100)){
        this.banknotes=banknotes;
        this.amount = Arrays.stream(banknotes).sum();
        }
    }
    public void decreaseBy(int lost){
        this.amount -= lost%5;
        lost = this.amount;
        int[] newBanknotes = new int[this.banknotes.length];
        int i = 0;
        while (lost > 0) {
            if (lost >= 5 && this.banknotes[i] == 5) {
                newBanknotes[i] = 5;
                lost -= 5;
            }
            i++;
        }
        this.banknotes = newBanknotes;
    }
    public void increaseBy(int gained) {
        this.amount += gained%5;
        gained = this.amount;
        int[] newBanknotes = new int[this.banknotes.length + (gained-gained%5)/5];
        int i = 0;
        while (gained > 0) {
            if (gained >= 5) {
                newBanknotes[i] = 5;
                gained -= 5;
            }
            i++;
        }
        this.banknotes = newBanknotes;
    }
    public int getBalance(){return this.amount;}

    @Override
    public String getHistory(String name) {
        return " не нашлось историй про деньги";
    }

    @Override
    public String getThoughts(String name) {
        return " думали как заработать денег";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && Arrays.equals(banknotes, money.banknotes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(amount);
        result = 31 * result + Arrays.hashCode(banknotes);
        return result;
    }

}
