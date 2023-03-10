package people;

import java.util.Random;

import enums.TimeOfDay;
import finances.Money;
import finances.Stock;
import interfaces.Remembable;
import interfaces.Sellable;
import interfaces.Thinkable;
import place.Place;

public class PeopleGroup {
    private String name;
    private Human[] members;
    private Place location;
    private Money ownMoney;
    public PeopleGroup(String name){
        this.name = name;
        this.ownMoney = new Money(100);
        this.members = new Human[0];
    }
    public PeopleGroup(Human[] memb){
        members = memb;
        this.ownMoney = new Money(100);
    }
    public PeopleGroup(String name, Money ownMoney){
        this.name = name;
        this.ownMoney = ownMoney;
        this.members = new Human[0];
    }
    public PeopleGroup(Human[] memb, Money ownMoney){
        members = memb;
        this.ownMoney = ownMoney;
    }

    public void walkTo(Place dest){
            if(members == null || members.length < 1)
                dest.addMember(new Human(this.name, new Money(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}), dest));
            else
                for(int i = 0; i < this.members.length; i++)
                    this.members[i].walkTo(dest);
            location = dest;
    }
    public void walkToInTime(Place dest, TimeOfDay time){
        if(time == TimeOfDay.NIGTH) {
            System.out.println(this.name + " ???????? ? " + dest.getName() + " ??????? ????.");
            dest.attractAttentionOf(new PeopleGroup("????????"));
        }
        if(members.length < 1)
            dest.addMember(new Human(this.name, new Money(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}), dest));
        else
            for(int i = 0; i < this.members.length; i++)
                dest.addMember(this.members[i]);
        location = dest;
    }
    public void remember(Remembable smth){
        System.out.println(this.name+" "+smth.getHistory(this.name));
    }

    public void think(Thinkable smth){
        System.out.println(this.name+" "+smth.getThoughts(this.name));
    }
    public void sellFromTo(Sellable sell, TimeOfDay start, TimeOfDay end, PeopleGroup buyers){
        int price = sell.getPrice();
        int price_of_selled= new Random().nextInt(10)*price;
        if(buyers.ownMoney.getBalance() < price)
            price_of_selled = 0;
        while(buyers.ownMoney.getBalance() < price_of_selled)
            price_of_selled= new Random().nextInt(10)*price;
        ownMoney.increaseBy(price_of_selled);
        buyers.ownMoney.decreaseBy(price_of_selled);
        String out = "";
        if(members.length > 0){
            for(Human member:members){
                out += member.getName();
                if(!member.getName().equals(members[members.length - 1].getName()))
                    out += " ? ";
            }
        }else{
            out += name;
        }
        out += " ?????????";
        if(sell instanceof Stock)
            out += " ?????";
        out += " ? "+start.toString()+" ?? "+end.toString();
        System.out.println(out);
    }
    public String getName(){
        return this.name;
    }

}
