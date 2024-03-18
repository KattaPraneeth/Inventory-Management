import java.util.Scanner;

public class DVD extends Product{
    int length;
    int ageRating;
    String studioName;

    DVD(int number,String name,int qty,double price, int length, int ageRating, String studioName){
        super(number, name, qty, price);
        this.length = length;
        this.ageRating = ageRating;
        this.studioName = studioName;
    }



    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public static DVD addDVDToInventory(DVD  productArray, Scanner in){
        int tempNum;
        String tempName;
        int tempQty;
        double tempPrice;
        int tempLength;
        int tempAgeRating;
        String tempStudioName;


        System.out.println("enter the item number");
        tempNum = in.nextInt();
        System.out.println("enter the item name");
        in.nextLine();
        tempName = in.nextLine();
        System.out.println("enter the item qty");
        tempQty = in.nextInt();
        System.out.println("enter the item price");
        tempPrice = in.nextDouble();
        System.out.println("Enter the length of the movie");
        tempLength = in.nextInt();
        System.out.println("Enter the age rating of the movie");
        tempAgeRating = in.nextInt();
        System.out.println("Enter the studio name of the film");
        in.nextLine();
        tempStudioName = in.nextLine();
        productArray = new DVD(tempNum,
                    tempName,
                    tempQty,
                    tempPrice,
                    tempLength,
                    tempAgeRating,
                    tempStudioName);
            return productArray;

    }
    public String toString(){
        String st = isStatus()?"Active":"Discontinued";
        return "Item Number : " + getItemNumber() +
                "\nItem Name : " + getItemName() +
                "\nQuantity In Stock : " + getNoOfUnitsInStock() +
                "\nItem Price : " + getItemPrice()+
                "\nStock Value : "+getNoOfUnitsInStock()*getItemPrice()+
                "\nStatus : "+st+
                "\nLength of the movie : "+getLength()+
                "\nAge Rating : "+getAgeRating()+
                "\nStudio Name : "+getStudioName();
    }
}
