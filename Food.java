package assignment4;

/**
 * Created by JMG on 11/1/2015.
 */
public class Food implements Comparable<Food>{
    String name = "";
    String price = "$0.00";
    String quantity = "0";
    String size = "Medium";
    String description = "None";
    String specialOrder = "N/A";

    public Food(String name)
    {
        this.name = name;
    }
    public Food(String name, String price)
    {
        this.name = name;
        this.price = price;
    }

    public Food(String name, boolean price, String quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }

    public Food(String name, String price, String quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Food(String name, boolean price, boolean quantity, String size)
    {
        this.name = name;
        this.size = size;
    }

    public Food(String name, String price, boolean quantity, String size)
    {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public Food(String name, boolean price, String quantity, String size)
    {
        this.name = name;
        this.quantity = quantity;
        this.size = size;
    }

    public Food(String name, String price, String quantity, String size)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
    }

    public Food(String name, boolean price, boolean quantity, boolean size, String description)
    {
        this.name = name;
        this.description = description;
    }

    public Food(String name, boolean price, boolean quantity, String size, String description)
    {
        this.name = name;
        this.size = size;
        this.description = description;
    }

    public Food(String name, boolean price, String quantity, boolean size, String description)
    {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
    }

    public Food(String name, boolean price, String quantity, String size, String description)
    {
        this.name = name;
        this.quantity = quantity;
        this.size = size;
        this.description = description;
    }

    public Food(String name, String price, boolean quantity, boolean size, String description)
    {
        this.name = name;
        this.price = price;

        this.description = description;
    }

    public Food(String name, String price, boolean quantity, String size, String description)
    {
        this.name = name;
        this.price = price;
        this.size = size;
        this.description = description;
    }

    public Food(String name, String price, String quantity, boolean size, String description)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Food(String name, String price, String quantity, String size, String description)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.description = description;
        this.specialOrder = "";
    }

    public Food(String name, boolean price, boolean quantity, boolean size, boolean description,  String specialOrder)
    {
        this.name = name;
        this.specialOrder = specialOrder;
    }

    public Food(String name, boolean price, boolean quantity, boolean size, String description,  String specialOrder)
    {
        this.name = name;
        this.description = description;
        this.specialOrder = specialOrder;
    }

    public Food(String name, boolean price, boolean quantity, String size, boolean description,  String specialOrder)
    {
        this.name = name;
        this.size = size;
        this.specialOrder = specialOrder;
    }

    public Food(String name, boolean price, boolean quantity, String size, String description,  String specialOrder)
    {
        this.name = name;
        this.size = size;
        this.description = description;
        this.specialOrder = specialOrder;
    }

    public Food(String name, boolean price, String quantity, boolean size, boolean description,  String specialOrder)
    {
        this.name = name;
        this.quantity = quantity;
        this.specialOrder = specialOrder;
    }

    public Food(String name, boolean price, String quantity, boolean size, String description,  String specialOrder)
    {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.specialOrder = specialOrder;
    }

    public Food(String name, boolean price, String quantity, String size, boolean description,  String specialOrder)
    {
        this.name = name;
        this.quantity = quantity;
        this.size = size;
        this.specialOrder = specialOrder;
    }

    public Food(String name, boolean price, String quantity, String size, String description,  String specialOrder)
    {
        this.name = name;
        this.quantity = quantity;
        this.size = size;
        this.description = description;
        this.specialOrder = specialOrder;
    }

    public Food(String name, String price, boolean quantity, boolean size, boolean description,  String specialOrder)
    {
        this.name = name;
        this.price = price;
        this.specialOrder = specialOrder;
    }

    public Food(String name, String price, boolean quantity, boolean size, String description,  String specialOrder)
    {
        this.name = name;
        this.price = price;
        this.description = description;
        this.specialOrder = specialOrder;
    }

    public Food(String name, String price, boolean quantity, String size, boolean description,  String specialOrder)
    {
        this.name = name;
        this.price = price;
        this.size = size;
        this.specialOrder = specialOrder;
    }

    public Food(String name, String price, boolean quantity, String size, String description,  String specialOrder)
    {
        this.name = name;
        this.price = price;
        this.size = size;
        this.description = description;
        this.specialOrder = specialOrder;
    }

    public Food(String name, String price, String quantity, boolean size, boolean description,  String specialOrder)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.specialOrder = specialOrder;
    }

    public Food(String name, String price, String quantity, boolean size, String description,  String specialOrder)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.specialOrder = specialOrder;
    }

    public Food(String name, String price, String quantity, String size, boolean description,  String specialOrder)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.specialOrder = specialOrder;
    }

    public Food(String name, String price, String quantity, String size, String description,  String specialOrder)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.description = description;
        this.specialOrder = specialOrder;
    }



    @Override
    public int compareTo(Food o) {
        int r = this.name.compareTo(o.name);
        /*if (r==0) {
            r = this.price.compareTo(o.price);
            if (r==0) {
                r = this.quantity.compareTo(o.quantity);
                if (r==0) {
                    r = this.size.compareTo(o.size);
                    if (r==0) {
                        r = this.description.compareTo(o.description);
                        if (r==0) {
                            r = this.specialOrder.compareTo(o.specialOrder);
                        }
                    }
                }
            }
        }*/
        return r;
    }
    public String toString()
    {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSpecialOrder() {
        return specialOrder;
    }
    public void setSpecialOrder(String specialOrder) {
        this.specialOrder = specialOrder;
    }
}
