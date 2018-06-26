package sg.edu.np.twq2.e82sqlite;

public class Product {
    private int id;
    private String productName;
    private int quantity;
    public Product() {}

    public Product(int id, String pn, int qty)
    {
        this.id = id;
        productName = pn;
        quantity = qty;
    }

    public Product(String pn, int qty)
    {
        productName = pn;
        quantity = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
