package Map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MainProdcut {
    public static void main(String[] args) throws ParseException {
        //Viết chương trình quản lý giỏ hàng. Một giỏ hàng bao gồm hai thông tin là:
        // sản phầm và số lượng sản phầm la 5 -> lon hon 5 ket thuc chuong trinh
        //
        //Thông tin sản phầm bao gồm: id, tên sản phẩm, năm sản xuất, giá.
        //1.Chương trình cho phép thêm sản phẩm vào giỏ hàng.
        //Một giỏ hàng không được có 2 sản phầm trùng nhau.
        //2. show toan bo thong tin san pham cua gio hang,danh sách sản phẩm được sắp xếp giảm dần theo giá.
        //3. update thong tin gio hang theo ID san pham tu nguoi dung nhap vao
        //4. delete thong tin san pham tron gio hang voi id san pham nguoi dung nhap vao
        //5. tim kiem thong tin san pham voi id san pham nguoi dung nhap vao
        //6. clear toan bo gio hang
        System.out.println("---CART MANAGEMENT--- ");
        Map<Integer, Product> products = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i<=5;i++){
            System.out.println("---ADD TO CART---");

            System.out.print("ProductID: ");
            int productId = scanner.nextInt();

            scanner.nextLine();
            System.out.print("ProductName: ");
            String productName = scanner.nextLine();

            System.out.print("ProductYear: ");
            String productYear = scanner.nextLine();

            System.out.print("ProductPrince: ");
            double productPrince = scanner.nextDouble();

            Product product = new Product();
            product.setProductId(productId);
            product.setProductName(productName);
            product.setProductPrice(productPrince);

            SimpleDateFormat pattern = new SimpleDateFormat("yyyy/MM/dd");
            Date dateParse = pattern.parse(productYear);
            product.setProductYear(dateParse);

            products.put(productId,product);
        }
        System.out.println("---PRODUCT IN CART---");
        List<Product> productsSort = products.values().stream().collect(Collectors.toList());
        productsSort.stream().sorted(Comparator.comparingDouble(Product::getProductPrice).reversed());
        for (Product product: productsSort){
            product.display();
        }
        System.out.println("---UPDATE CART---");
        System.out.print("Enter ProductID update: ");
        int productIdUpdate = scanner.nextInt();

        boolean containsKey = products.containsKey(productIdUpdate);
        if (!containsKey){
            System.out.println("NO PRODUCT IN CART");
        }else{

            scanner.nextLine();
            System.out.print("ProductName: ");
            String productName = scanner.nextLine();

            System.out.print("ProductYear: ");
            String productYear = scanner.nextLine();

            System.out.print("ProductPrince: ");
            double productPrince = scanner.nextDouble();

            SimpleDateFormat pattern = new SimpleDateFormat("yyyy/MM/dd");
            Date dateParse = pattern.parse(productYear);

            Product productUpdate = new Product();
            productUpdate.setProductId(productIdUpdate);
            productUpdate.setProductName(productName);
            productUpdate.setProductPrice(productPrince);
            productUpdate.setProductYear(dateParse);

            products.replace(productIdUpdate,productUpdate);

            System.out.println("--CART AFTER UPDATE--");
            List<Product> productsAfterUpdate = products.values().stream().collect(Collectors.toList());
            productsAfterUpdate.stream().sorted(Comparator.comparingDouble(Product::getProductPrice).reversed());
            for (Product product: productsAfterUpdate){
                product.display();
            }
        }
        System.out.println("---REMOVE PRODUCT---");
        System.out.print("Enter ProductID remove: ");
        int productIdRemove = scanner.nextInt();

        boolean containsKeyRemove = products.containsKey(productIdRemove);
        if (!containsKeyRemove){
            System.out.println("NO PRODUCT IN CART");
        }else{
            products.remove(productIdRemove);
            System.out.println("--CART AFTER REMOVE--");
            List<Product> productsAfterUpdate = products.values().stream().collect(Collectors.toList());
            productsAfterUpdate.stream().sorted(Comparator.comparingDouble(Product::getProductPrice).reversed());
            for (Product product: productsAfterUpdate){
                product.display();
            }
        }
        System.out.println("---SEARCH INFOR PRODUCT---");
        System.out.print("Enter ProductID Search: ");
        int productIdExist = scanner.nextInt();

        boolean containsKeyExist = products.containsKey(productIdExist);
        if (!containsKeyExist){
            System.out.println("NO PRODUCT IN CART");
        }else{
            products.get(productIdExist).display();
        }
        System.out.println("---CLEAR CART---");
        products.clear();
        System.out.println("product in cart: "+products.size());

    }
}
