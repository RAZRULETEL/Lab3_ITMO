package finances;

import java.util.Objects;

import event.Event;
import interfaces.Sellable;


public class Stock extends Finances implements Sellable {
    private int price = 5;
    private String name;
    public String increasePriceWithTime(int[] prices){
        String out = "сначала стоили "+price+" фертинг, но потом продавались ";
        for(int i = 0; i < prices.length-1; i++)
            out += " по "+prices[i]+" фертингу штука, потом";
        String event = Event.getEvent();
        if(event != null && event.contains("фонтан"))
            out += " когда "+ event +", цена на акции подскочила до "+prices[prices.length-1]+" фертингов штука";
        return out;
    }
    public Stock(String name, int price){
        this.name = name;
        this.price = price;
    }
    @Override
    public String getHistory(String name) {
        if(name.contains("жители") && this.name.contains("нефт")) {
            return "вспоминали об удивительном случае, когда акции одного нефтяного общества "+increasePriceWithTime(new int[]{2, 3, 5, 10});
        }else {
            if(name.contains("продавший")){
                if(this.name.contains("фонтан"))
                    return "получил в десять раз больше денег, чем истратил вначале.";
                else
                    return "получил в пять раз больше денег, чем истратил вначале.";
            }
        }
        return null;
    }

    @Override
    public String getThoughts(String name) {
        if(name.contains("жители"))
            return "сообразили, что с течением времени цена на акции может повыситься. ";
        return null;
    }
    @Override
    public int getPrice(){return this.price;}
    public void changePriceBy(int amount){
        if(this.price + amount > 0)
            this.price += amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return price == stock.price && Objects.equals(name, stock.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    public String getName() {
        return name;
    }
}
