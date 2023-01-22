package finances;

import java.util.Objects;

import event.Event;
import interfaces.Sellable;


public class Stock extends Finances implements Sellable {
    private int price = 5;
    private String name;
    public String increasePriceWithTime(int[] prices){
        String out = "������� ������ "+price+" �������, �� ����� ����������� ";
        for(int i = 0; i < prices.length-1; i++)
            out += " �� "+prices[i]+" �������� �����, �����";
        String event = Event.getEvent();
        if(event != null && event.contains("������"))
            out += " ����� "+ event +", ���� �� ����� ���������� �� "+prices[prices.length-1]+" ��������� �����";
        return out;
    }
    public Stock(String name, int price){
        this.name = name;
        this.price = price;
    }
    @Override
    public String getHistory(String name) {
        if(name.contains("������") && this.name.contains("����")) {
            return "���������� �� ������������ ������, ����� ����� ������ ��������� �������� "+increasePriceWithTime(new int[]{2, 3, 5, 10});
        }else {
            if(name.contains("���������")){
                if(this.name.contains("������"))
                    return "������� � ������ ��� ������ �����, ��� �������� �������.";
                else
                    return "������� � ���� ��� ������ �����, ��� �������� �������.";
            }
        }
        return null;
    }

    @Override
    public String getThoughts(String name) {
        if(name.contains("������"))
            return "����������, ��� � �������� ������� ���� �� ����� ����� ����������. ";
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