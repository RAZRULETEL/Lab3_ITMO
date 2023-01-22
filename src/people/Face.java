package people;


public class Face{
    private String[] visualFeatures;
    private String[] faceParts;

    public String getEyes(){
        String res = null;
        for(String part : faceParts)
            if(part.contains("глаза"))
                res = part.substring(4);
        return res;
    }
    public String getNose(){
        String res = null;
        for(String part : faceParts)
            if(part.contains("нос"))
                res = part.substring(4);
        return res;
    }
    public String[] getVisualFeatures(){
        return this.visualFeatures;
    }
    public void addPart(String part){
        this.faceParts = addElementToStaticArray(part, this.faceParts);
    }
    public void addVisualFeature(String feature){
        this.visualFeatures = addElementToStaticArray(feature, this.visualFeatures);
    }
    private String[] addElementToStaticArray(String str, String[] arr){
        if(arr == null || arr.length == 0) {
            arr = new String[]{str};
            return arr;
        }
        int length = arr.length;
        String[] newArray = new String[length + 1];
        System.arraycopy(arr, 0, newArray, 0, length);
        newArray[length] = str;
        return newArray;
    }
}