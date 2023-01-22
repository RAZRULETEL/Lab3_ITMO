import storages.Closet;
import storages.Feature;
import enums.TimeOfDay;
import finances.Money;
import finances.Stock;
import people.Human;
import people.PeopleGroup;
import place.Place;
import storages.FireResistance;

public class Main {
    public static void main(String[] args){
        PeopleGroup all = new PeopleGroup("городские жители");
        Place kontora = new Place("Контора", 0, 0);
        Place bank = new Place("Банк", 0, 1);
        Closet fireProofCloset = new Closet(new Feature[]{new FireResistance("огнеупорный", 1)});
        PeopleGroup interested = new PeopleGroup("Желающие купить акции");
        for (int i = 0; i < 3; i++)
            interested.walkTo(kontora);
        Human neznayka = new Human("Незнайка", new Money(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}), kontora);
        Human kozklik = new Human("Козлик", new Money(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}), kontora);
        Stock big_plants_stocks = new Stock("акции Общества гигантских растений", 5);
        PeopleGroup nezn_and_kozl = new PeopleGroup(new Human[]{neznayka, kozklik});
        PeopleGroup buyers = new PeopleGroup("покупатели");
        nezn_and_kozl.sellFromTo(big_plants_stocks, TimeOfDay.MORNING, TimeOfDay.EVENING, buyers);
        Human miga = new Human("Мига", new Money(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}), kontora);
        miga.drive(bank);
        miga.exchangeMoney();
        miga.putMoneyInCloset(fireProofCloset);
        Stock oil_comm = new Stock("акции нефтяного сообщества", 1);
        for (int i = 0; i < 10; i++)
            buyers.walkToInTime(kontora, TimeOfDay.NIGTH);
        all.think(big_plants_stocks);
        all.remember(oil_comm);
        PeopleGroup sellers = new PeopleGroup("Каждый продавший");
        sellers.remember(oil_comm);
    }
}
