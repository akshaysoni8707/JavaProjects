import java.util.Arrays;

class Bill extends inventory {
    private Bill[] bill_item = new Bill[2];
    private int productId;
    private String productName;
    private int productQuantity;
    private int productPrice;

    private int counter1;

    private Bill(inventory ob, int quantity) {
        this.productId = ob.product_id;
        this.productName = ob.product_name;
        this.productQuantity = quantity;
        this.productPrice = productQuantity * ob.product_price;
    }

    private Bill() {
    }

    public static void main(String[] args) {
        Bill a = new Bill();
        a.billGenerator();
    }

    private void addBill(int giveId, int quantity, int counter, inventory ob) {
        if (counter1 >= 2) {
            this.bill_item = Arrays.copyOf(bill_item, counter1 + 1);
        }
        for (int i = 0; i < counter; i++) {
            if (ob.inventoryItem[i].product_id == giveId && ob.inventoryItem[i].product_quantity - quantity >= 0) {
                bill_item[counter1++] = new Bill(ob.inventoryItem[i], quantity);
                ob.inventoryItem[i].product_quantity -= quantity;
                System.out.println(bill_item[counter1 - 1].productId + " " + bill_item[counter1 - 1].productName + " " + bill_item[counter1 - 1].productQuantity + " " + bill_item[counter1 - 1].productPrice);
                break;
            } else if (ob.inventoryItem[i].product_id == giveId && ob.inventoryItem[i].product_quantity - quantity <= 0) {
                System.out.println("We are out of stock for " + ob.inventoryItem[i].product_name);
                break;
            } else if (i == counter) {
                System.out.println(" Wrong Id of Product");
                break;
            }
        }
    }

    private void billGenerator() {
        long start = System.currentTimeMillis();
        inventory myInventory = new inventory();
        int total = 0;
        myInventory.addItems(1, "orange", 4, 24);
        myInventory.addItems(2, "apple", 2, 25);
        myInventory.addItems(5, "apple", 2, 25);
        myInventory.addItems(3, "mango", 9, 26);
        myInventory.addItems(4, "grapes", 5, 27);
        System.out.println(myInventory.toString());
        addBill(1, 3, myInventory.counter, myInventory);
        addBill(2, 2, myInventory.counter, myInventory);
        addBill(2, 2, myInventory.counter, myInventory);
        addBill(4, 3, myInventory.counter, myInventory);
        System.out.println(billDisplay(total));
        System.out.println("\n Inventory after bill generated....\n");
        System.out.println(myInventory.toString());
        myInventory.updateItems(2, 5);
        myInventory.updateItems("ORange", 3);
        myInventory.updateItems(4, 0, 34);
        myInventory.updateItems("mAngo", 1, 60);
        System.out.println("\nLets check if inventory is updated...\n");
        System.out.println(myInventory.toString());
        long end = System.currentTimeMillis();
        System.out.println(" time taken for program to run :" + (end - start));
    }

    private String billDisplay(int total) {
        System.out.println("--------------------------- B I L L ---------------------------");
        System.out.println("Product_id    Product_name    Product_quantity    Product_price\n" +
                "---------------------------------------------------------------");
        String message = "";
        for (int i = 0; i < counter1; i++) {
            message = message.concat("    " + bill_item[i].productId +
                    "           " + bill_item[i].productName + '\'' +
                    "          \t  " + bill_item[i].productQuantity +
                    "           \t " + bill_item[i].productPrice +
                    "\n");
            total = total + bill_item[i].productPrice;
        }
        message = message.concat("---------------------------------------------------------------");
        message = message.concat("\n\t\t\t\t\t\t\t\t\t\tYour Total : " + total + "\n");
        message = message.concat("---------------------------------------------------------------\n");
        return message;
    }
}

class inventory {
    inventory[] inventoryItem = new inventory[2];
    int product_id;
    String product_name;
    int product_quantity;
    int product_price;
    int counter;

    private inventory(int product_id, String product_name, int product_quantity, int product_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_quantity = product_quantity;
        this.product_price = product_price;
    }

    inventory() {
    }

    void addItems(int product_id, String product_name, int product_quantity, int product_price) {
        int i;
        for (i = 0; i < counter; i++) {
            if (inventoryItem[i].product_id == product_id) {
                System.err.println("This id :" + product_id + " already exist");
                break;
            } else if (inventoryItem[i].product_name.equalsIgnoreCase(product_name)) {
                System.err.println("This name :" + product_name + " already exist");
                break;
            }
        }
        if (i == counter) {
            if (counter >= 2) {
                this.inventoryItem = Arrays.copyOf(inventoryItem, counter + 1);
            }
            inventoryItem[counter++] = new inventory(product_id, product_name, product_quantity, product_price);
        }
    }

    void updateItems(int id, int quantity) {
        int i;
        for (i = 0; i < counter; i++) {
            if (inventoryItem[i].product_id == id) {
                inventoryItem[i].product_quantity += quantity;
                break;
            }
        }
        if (i == counter) {
            System.err.println("There is no item with id : " + id);
        }
    }

    void updateItems(String name, int quantity) {
        int i;
        for (i = 0; i < counter; i++) {
            if (inventoryItem[i].product_name.equalsIgnoreCase(name)) {
                inventoryItem[i].product_quantity += quantity;
                break;
            }
        }
        if (i == counter) {
            System.err.println("There is no item with id : " + name);
        }
    }

    void updateItems(int id, int quantity, int price) {
        int i;
        for (i = 0; i < counter; i++) {
            if (inventoryItem[i].product_id == id) {
                inventoryItem[i].product_quantity += quantity;
                inventoryItem[i].product_price = price;
                break;
            }
        }
        if (i == counter) {
            System.err.println("There is no item with id : " + id);
        }
    }

    void updateItems(String name, int quantity, int price) {
        int i;
        for (i = 0; i < counter; i++) {
            if (inventoryItem[i].product_name.equalsIgnoreCase(name)) {
                inventoryItem[i].product_quantity += quantity;
                inventoryItem[i].product_price = price;
                break;
            }
        }
        if (i == counter) {
            System.err.println("There is no item with id : " + name);
        }
    }

    @Override
    public String toString() {
        System.out.println("---------------- INVENTORY OF MY GROCERY STORE ----------------");
        System.out.println("Product_id    Product_name    Product_quantity    Product_price\n" +
                "---------------------------------------------------------------");
        String message = "";
        for (int i = 0; i < counter; i++) {
            message = message.concat("    " + inventoryItem[i].product_id +
                    "           " + inventoryItem[i].product_name + '\'' +
                    "          \t  " + inventoryItem[i].product_quantity +
                    "           \t " + inventoryItem[i].product_price +
                    "\n");
        }
        message = message.concat("---------------------------------------------------------------\n");
        return message;
    }
}