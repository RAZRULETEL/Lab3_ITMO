package people;

import java.util.Objects;

import finances.Money;
import place.Place;
import storages.Closet;

public class Human {
    private String name;
    private Money ownMoney;
    private Place location;
    public Human(String name, Money money, Place location){
        this.name = name;
        this.ownMoney = money;
        this.location = location;
    }
    public String getName() {
        return name;
    }
    public void walkTo(Place place){
        this.location = place;
        location.addMember(this);
    }

    public void drive(Place drive){
        System.out.println(this.name+" ездил в "+drive.getName());
        location = drive;

    }
    public void putMoneyInCloset(Closet closet){
        String out = this.name+" положил деньги в ";
        out += closet.toString()+" ";
        out += "деньги";
        System.out.println(out);
        closet.addMoney( this.ownMoney);
        this.ownMoney = null;
    }
    public void exchangeMoney(){
        System.out.println(this.name+" объменивал мелкие деньги на крупные");
        int[] bankn = ownMoney.getBanknotes();
        int[] res = new int[0];
        if(bankn != null) {
            int sum = 0;
            for (int j : bankn)
                sum += j;
            int res_length = (sum-sum%100)/100+(sum%100-sum%20)/20+(sum%20)/5;
            res = new int[res_length];
            for(int i = 0; i < res_length; i++){
                res[i] = (sum-sum%100)/100>i?100:(sum-sum%100)/100+(sum%100-sum%20)/20>i?20:5;
            }
        }
        ownMoney.setBanknotes(res);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) && Objects.equals(location, human.location) && Objects.equals(ownMoney, human.ownMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, ownMoney);
    }
}
