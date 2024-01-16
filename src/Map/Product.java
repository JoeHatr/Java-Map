package Map;

import java.util.Date;

public class Product {
    private int productId;
    private String productName;
    private Date productYear;
    private double productPrice;

    public Product() {
    }

    public Product(int productId, String productName, Date productYear, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productYear = productYear;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getProductYear() {
        return productYear;
    }

    public void setProductYear(Date productYear) {
        this.productYear = productYear;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        sb.append("productId: ")
                .append(this.productId)
                .append("\n")
                .append("productName: ")
                .append(this.productName)
                .append("\n")
                .append("productYear: ")
                .append(this.productYear)
                .append("\n")
                .append("productPrice: ")
                .append(this.productPrice)
                .append("\n");
        System.out.println(sb);
    }
}
