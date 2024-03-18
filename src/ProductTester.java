import java.util.Scanner;
public class ProductTester {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of products you would like to add");
        System.out.println("Enter 0 (zero) if you do not wish to add products");
        int maxSize = getNumProducts(in);
        int menuChoice;

        if (maxSize==0){
            System.out.println("No products required");
        }
        else {
            Product [] productArray = new Product[maxSize];
            addToInventory(productArray, in);
            do {
                menuChoice = getMenuOption(in);
                executeMenuChoice(productArray, menuChoice, in);
            }while (menuChoice!=0);
        }

    }

    public static void executeMenuChoice(Product[] productArray, int menuChoice, Scanner in){
        switch (menuChoice) {
            case 1 -> displayInventory(productArray);
            case 2 -> addStock(productArray, in);
            case 3 -> deductStock(productArray, in);
            case 4 -> discontinueProduct(productArray, in);
        }
    }

    public static int getNumProducts(Scanner in){
        int maxSize=-1;
        do {
            try{
                maxSize = in.nextInt();
                if(maxSize<0){
                    System.out.println("Incorrect value entered\nPlease enter the correct value");
                }
            }
            catch (Exception e){
                System.out.println("Incorrect data type");
                in.nextLine();
                maxSize = -1;
            }
        }while (maxSize<0);
        return maxSize;

    }
    public static void displayInventory(Product[] arr){
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i].toString());
            System.out.println();
        }
    }
    public static void addToInventory(Product[] productArray, Scanner in){
        for (int i = 0; i<productArray.length; i++){
            System.out.println("Enter the details of product "+(i+1));
            int stockChoice = getStockChoice(in);
            switch (stockChoice)
            {
                case 1 -> {
//                    CD product
                    CD tempCD = null;
                    productArray[i] = CD.addCDToInventory(tempCD, in);
                }
                case 2 -> {
                    DVD tempDVD = null;
                    productArray[i] = DVD.addDVDToInventory(tempDVD, in);
                }
            }
        }
    }

    public static int getMenuOption(Scanner in){
        int opt = -1;
        do {
            try{
                System.out.println("Choose an option");
                System.out.println("1 - View Inventory"+"\n2 - Add Stock"+"\n3 - Deduct Stock"+"\n4 - Discontinue Product"
                                    +"\n0 - Exit");
                opt = in.nextInt();
                if(opt>4 || opt<0){
                    System.out.println("Incorrect value entered\nPlease re-enter the correct value");
                }
            }
            catch (Exception e){
                System.out.println("Incorrect data type entered");
                in.nextLine();
                opt = -1;
            }

        }while (opt>4 || opt<0);
        return opt;
    }

    public static int getProductNumber(Product [] productArray, Scanner in){
        for (int i=0; i < productArray.length;i++){
            System.out.println("index "+i+" of the product : "+productArray[i].getItemName());
        }
        int productChoice =-1;
        do {
            try{
                productChoice = in.nextInt();
                if(productChoice<0 || (productChoice>productArray.length-1)){
                    System.out.println("Incorrect value entered\nPlease enter the correct value");
                }
            }
            catch (Exception e){
                System.out.println("Incorrect data type entered");
            }
        }while (productChoice<0 || (productChoice>productArray.length-1));
        return productChoice;
    }

    public static void addStock(Product[] productArray, Scanner in){
        int productChoice = getProductNumber(productArray,in);
        int updateValue = -1;
        if(!productArray[productChoice].isStatus()){
            System.out.println("The product is no longer active\nYou can't add stock to this product");
            return;
        }

        System.out.println("How many products do you want to add?");
        do {
            try{
                updateValue = in.nextInt();
                if(updateValue<0){
                    System.out.println("Incorrect value entered\nPlease enter a positive number");
                }
            }
            catch (Exception E){
                System.out.println("Incorrect datatype entered");
                in.nextLine();
                updateValue = -1;
            }
        }while (updateValue<0);
        productArray[productChoice].setNoOfUnitsInStock(productArray[productChoice].getNoOfUnitsInStock()+updateValue);
    }

    public static void deductStock(Product[] productArray, Scanner in){
        int productChoice = getProductNumber(productArray,in);
        int updateValue = productArray[productChoice].getNoOfUnitsInStock()+1;

        System.out.println("How many products do you want to deduct?");
        do {
            try{
                updateValue = in.nextInt();
                if(updateValue> productArray[productChoice].getNoOfUnitsInStock()){
                    System.out.println("We don't have that much of stock in the inventory.\nPlease enter a value which is lesser than the amount of stock present");
                }
            }
            catch (Exception E){
                System.out.println("Incorrect datatype entered");
                in.nextLine();
                updateValue = productArray[productChoice].getNoOfUnitsInStock()+1;
            }
        }while (updateValue> productArray[productChoice].getNoOfUnitsInStock());
        productArray[productChoice].setNoOfUnitsInStock(productArray[productChoice].getNoOfUnitsInStock()-updateValue);
    }

    static void discontinueProduct(Product [] productArray, Scanner in){
        int productChoice = getProductNumber(productArray,in);
        productArray[productChoice].setStatus(false);
    }

    public static int getStockChoice(Scanner in){
        int stockChoice = -1;
        do {
            try{
                System.out.println("Enter 1 for CD"+"\nEnter 2 for DVD");
                stockChoice = in.nextInt();
                if (stockChoice!=1 && stockChoice!=2){
                    System.out.println("Incorrect value entered\nOnly 1 and 2 are allowed");
                }
            }
            catch (Exception e){
                System.out.println("Incorrect datatype entered");
                in.nextLine();
                stockChoice = -1;
            }

        }while (stockChoice!=1 && stockChoice!=2);
        return stockChoice;
    }
}
