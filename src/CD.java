import java.util.Scanner;

public class CD extends Product{
    String artist;
    int noOfSongs;
    String label;

    CD(int number,String name,int qty,double price,String artist, int noOfSongs, String label){
        super(number, name, qty, price);
        this.artist = artist;
        this.noOfSongs = noOfSongs;
        this.label = label;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getNoOfSongs() {
        return noOfSongs;
    }

    public void setNoOfSongs(int noOfSongs) {
        this.noOfSongs = noOfSongs;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static CD addCDToInventory(CD productArray, Scanner in){
        int tempNum;
        String tempName;
        int tempQty;
        double tempPrice;
        String tempArtist;
        int tempNoOfSongs;
        String templabel;


        System.out.println("enter the item number");
        tempNum = in.nextInt();
        System.out.println("enter the item name");
        in.nextLine();
        tempName = in.nextLine();
        System.out.println("enter the item qty");
        tempQty = in.nextInt();
        System.out.println("enter the item price");
        tempPrice = in.nextDouble();
        System.out.println("Enter the name of the artist");
        in.nextLine();
        tempArtist = in.nextLine();
        System.out.println("Enter the number of songs in the CD");
        tempNoOfSongs = in.nextInt();
        System.out.println("Enter the label present on the CD");
        in.nextLine();
        templabel = in.nextLine();
        productArray = new CD(tempNum,tempName,tempQty,tempPrice,tempArtist,tempNoOfSongs,templabel);
        return productArray;

    }
    public String toString(){
        String st = this.isStatus()?"Active":"Discontinued";
        return "Item Number : " + getItemNumber() +
                "\nItem Name : " + getItemName() +
                "\nQuantity In Stock : " + getNoOfUnitsInStock() +
                "\nItem Price : " + getItemPrice()+
                "\nStock Value : "+getNoOfUnitsInStock()*getItemPrice()+
                "\nStatus : "+st+
                "\nArtist : "+getArtist()+
                "\nNo of Songs : "+getNoOfSongs()+
                "\nLabel : "+getLabel();
    }
}
