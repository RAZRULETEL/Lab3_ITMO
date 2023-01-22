package storages;

import java.util.Arrays;

import finances.Money;

public class Closet {
    private Money[] storage = new Money[0];
    private Feature[] features;
    public Closet(Feature[] feat){
        this.features = feat;
    }
    public void addMoney(Money money){
        if(storage == null || storage.length == 0) {
            storage = new Money[]{money};
            return;
        }
        int length = this.storage.length;
        Money[] newArray = new Money[length + 1];
        System.arraycopy(this.storage, 0, newArray, 0, length);
        newArray[length] = money;
        this.storage = newArray;
    }
    @Override
    public String toString() {
        String out = "";
        String cont = "";
        for(Feature feat : features)
            out += feat.toString()+" ";
        for(Money put : storage)
            out += put.toString()+" ";
        return out + " шкаф "+cont;
    }
    Feature[] getFeatures() {return this.features;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Closet closet = (Closet) o;
        return Arrays.equals(storage, closet.storage) && Arrays.equals(features, closet.features);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(storage);
        result = 31 * result + Arrays.hashCode(features);
        return result;
    }

}
