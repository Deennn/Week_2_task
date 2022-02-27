package com.store.internalOperations;

import com.store.exceptions.InsufficientFundException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.models.*;
import com.store.models.Category;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import static com.store.enums.Role.CASHIER;
import static com.store.enums.Role.MANAGER;

public class InternalOperationsImpl implements InternalOperations{

private double customerPrice = 0;


    @Override
    public void addProductToStore(Staff admin, Store store) throws StaffNotAuthorizedException, IOException {
        if (!admin.getRole().equals(MANAGER)) {
                throw new StaffNotAuthorizedException("You're not authorized to perform this operation");
        }
        stockProduct(store);
    }


    private void stockProduct(Store store) throws IOException {
            java.lang.String path = "src/main/resources/deennStore/Deen_Store .xlsx";
            FileInputStream inputStream = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet xssfSheet = workbook.getSheetAt(0);
            Product[] productList = new Product[xssfSheet.getPhysicalNumberOfRows()-1];

            for (int i = 1; i <= xssfSheet.getLastRowNum(); i++) {
                XSSFRow xssfRow = xssfSheet.getRow(i);
                Category category = new Category(
                   xssfRow.getCell(2).getStringCellValue());
                   productList[i-1] = new Product (
                        xssfRow.getCell(0).getStringCellValue(),
                        xssfRow.getCell(1).getStringCellValue(),
                           category,
                        xssfRow.getCell(3).getNumericCellValue(),

                        (int) xssfRow.getCell(4).getNumericCellValue()
                );
            }
        store.setProductList(productList);
        }




    @Override
    public void sellProducts(Staff staff, Store store, Customer customer) throws InsufficientFundException, StaffNotAuthorizedException {
        Map<Product,Integer> map = customer.getCartMap();
        double totalAmount = 0.00;
        double customerBalance = customer.getAccount().getAccountBalance();
        double totalAmountPerProduct = 0.00;
        if (!staff.getRole().equals(CASHIER)) {
            throw new StaffNotAuthorizedException(" You're not Authorized to perform this operation");
        } else {
            for (Map.Entry<Product,Integer> entry : map.entrySet()) {
                double productPrice = entry.getKey().getProductPrice();
                int  productQuantity = entry.getValue();
                totalAmountPerProduct = productPrice * productQuantity;
                totalAmount += totalAmountPerProduct;
                customerPrice = totalAmount;
            }
        }
        if (totalAmount > customerBalance) {
            throw  new InsufficientFundException("Insufficient Funds");
        } else {

                customerBalance -= totalAmount;
                customer.getAccount().setAccountBalance(customerBalance);
                double originalAccountBalance = store.getStoreAccount().getAccountBalance();
                store.getStoreAccount().setAccountBalance(totalAmount+originalAccountBalance);
                removeBoughtProducts(customer.getCartMap(),store.getProductList());
                System.out.println(printReceipt(store,customer,totalAmount));;
        }
        map.clear();

    }

    private void removeBoughtProducts(Map<Product,Integer> customerProductMap,Product[] products) {
        for (Map.Entry<Product, Integer> productsPairsBoughtByCustomer : customerProductMap.entrySet()) {
            java.lang.String nameOfItem =  productsPairsBoughtByCustomer.getKey().getProductName();
            int itemUnit = productsPairsBoughtByCustomer.getValue();

            for (Product productInStore : products) {
                if (productInStore.getProductName().equals(nameOfItem)) {
                   productInStore.setProductQuantity(productInStore.getProductQuantity()-itemUnit);
                }
            }
        }
    }

    @Override
    public java.lang.String printReceipt(Store store, Customer customer, double totalAmount) {
        java.lang.String receipt = "***** Thanks for patronizing " + store.getName() + " *****\n" +
                "Transaction Details\n" +
                "*******************************************\n";

        for( Map.Entry<Product, Integer> each: customer.getCartMap().entrySet()){
            receipt += "Product Name: "+ each.getKey().getProductName()+"\n" +
                    "Price       : "+ each.getKey().getProductPrice()+"\n" +
                    "Units       : "+ each.getValue()+"\n" +
                    "Cost        : "+ (each.getKey().getProductPrice() * (double) each.getValue())+"\n" +
                    "*******************************************\n";
        }
        receipt += "Total Price: "+totalAmount+"\n" +
                "Amount paid: " + totalAmount + "\n" +
                "Buyer: " + customer.getFirstName() + " " + customer.getLastName();


        return receipt;


    }
}
