public class Product {
    //instance field declarations
    private int itemNumber;
    private String itemName;
    private int noOfUnitsInStock;
    private double itemPrice;
    private boolean status;



    Product(){
        this.itemName = "";
        this.itemNumber = 0;
        this.itemPrice = 0;
        this.noOfUnitsInStock = 0;
        status = true;
    }
    Product(int number,String name,int qty,double price){
        this.itemName = name;
        status = true;
        this.itemNumber = number;
        this.itemPrice = price;
        this.noOfUnitsInStock = qty;
    }

    // Getter(Accessor) and Setter(Mutator) methods
    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getNoOfUnitsInStock() {
        return noOfUnitsInStock;
    }

    public void setNoOfUnitsInStock(int noOfUnitsInStock) {
        this.noOfUnitsInStock = noOfUnitsInStock;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String toString(){
        String st = isStatus()?"Active":"Discontinued";
        return "Item Number : " + getItemNumber() +
                "\nItem Name : " + getItemName() +
                "\nQuantity In Stock : " + getNoOfUnitsInStock() +
                "\nItem Price : " + getItemPrice()+
                "\nStock Value : "+getNoOfUnitsInStock()*getItemPrice()+
                "\nStatus : "+st;
    }
}
