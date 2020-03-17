/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.dao;

import com.lds.flooringcompany.dto.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author lydia
 */
public class FlooringCompanyDaoFileImpl implements FlooringCompanyDao {

    public static final String PATH
            = "C:/Users/lydia/Documents/repos/java-mpls-0220-lds412/Summatives/FlooringCompany";

    public static final String HEADER = "OrderNumber, CustomerName, State, "
            + "TaxRate, ProductType, Area, CostPerSquareFoot, "
            + "LaborCostPerSquareFoot, MaterialCost, LaborCost, Tax, Total";

    public static final String DELIMITER = ",  ";

    public static final String DATE_FILE = "dates.txt";
    public static final String TAX_FILE = "Taxes.txt";
    public static final String PRODUCT_FILE = "Products.txt";

    public static final String FILE_TYPE = ".txt";

    public static final String PREFIX = "Orders_";

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMddyyyy");

    public ArrayList<String> fileNames = new ArrayList<>();
    //public Set<String> fileNames = new HashSet<>();

    private Map<String, BigDecimal> taxRates = new HashMap<>();
    private Map<String, BigDecimal> productRates = new HashMap<>();
    private Map<String, BigDecimal> laborRates = new HashMap<>();

    private Map<Integer, Order> orders = new HashMap<>();

    @Override
    public void loadData() {
        loadTaxes();
        loadProducts();
        loadFileNames();
        loadAllOrders();
    }

    @Override
    public List<Order> listOrders() {
        return new ArrayList<Order>(orders.values());
    }

    @Override
    public List<Order> listOrdersForDate(LocalDate date) {
        return orders.values()
                .stream()
                .filter(o -> o.getOrderDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public Order addOrder(int orderNum, Order order) {
        orders.put(orderNum, order);
        checkDate(order);
        return order;
    }

    @Override
    public Order getOrder(LocalDate date, int orderNum) {
        return orders.get(orderNum);
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNum) {
        Order removedOrder = orders.remove(orderNum);
        return removedOrder;
    }

    @Override
    public void saveEdits() {
        writeOrders();
    }

    @Override
    public BigDecimal getTaxRate(String state) {
        return taxRates.get(state.toUpperCase());
    }

    @Override
    public BigDecimal getProductRate(String product) {
        return productRates.get(product.toUpperCase());
    }

    @Override
    public BigDecimal getLaborRate(String product) {
        return laborRates.get(product.toUpperCase());
    }

    private void unmarshallTaxRates(String taxesAsText) {
        String[] stateTaxTokens = taxesAsText.split(DELIMITER);
        String state = stateTaxTokens[0];
        BigDecimal taxRate = new BigDecimal(stateTaxTokens[1]);
        taxRates.put(state.toUpperCase(), taxRate);
    }

    private void loadFileNames() {
        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader(DATE_FILE)));
        } catch (FileNotFoundException e) {
//            throw new EyeTunesDaoException(
//                    "-_- Could not load artists into memory.", e);
        }

        while (s.hasNextLine()) {
            fileNames.add(s.nextLine());
        }

        s.close();
    }

    private void loadTaxes() {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(TAX_FILE)));
        } catch (FileNotFoundException e) {
            //throw new ClassRosterPersistenceException("-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        //Skip the first line
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            unmarshallTaxRates(currentLine);
        }

        scanner.close();
    }

    private void unmarshallProducts(String productAsText) {
        String[] productTokens = productAsText.split(DELIMITER);
        String product = productTokens[0];
        BigDecimal productRate = new BigDecimal(productTokens[1]);
        BigDecimal laborRate = new BigDecimal(productTokens[2]);
        productRates.put(product.toUpperCase(), productRate);
        laborRates.put(product.toUpperCase(), laborRate);
    }

    private void loadProducts() {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));
        } catch (FileNotFoundException e) {
            //throw new ClassRosterPersistenceException("-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        //Skip the first line
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            unmarshallProducts(currentLine);
        }

        scanner.close();
    }

    private Order unmarshallOrder(String orderAsText, String fileName) {
        String[] orderTokens = orderAsText.split(DELIMITER);

        int orderNum = Integer.parseInt(orderTokens[0]);
        Order orderFromFile = new Order(orderNum);

        LocalDate date = LocalDate.parse(fileName.substring(7), FORMATTER);
        orderFromFile.setOrderDate(date);

        orderFromFile.setCustomerName(orderTokens[1]);

        orderFromFile.setState(orderTokens[2]);

        BigDecimal taxRate = new BigDecimal(orderTokens[3]);
        orderFromFile.setTaxRate(taxRate);

        orderFromFile.setProductType(orderTokens[4]);

        BigDecimal area = new BigDecimal(orderTokens[5]);
        orderFromFile.setArea(area);

        BigDecimal productCost = new BigDecimal(orderTokens[6]);
        orderFromFile.setCostPerSqFt(productCost);

        BigDecimal laborCost = new BigDecimal(orderTokens[7]);
        orderFromFile.setLaborCostPerSqFt(laborCost);

        return orderFromFile;
    }

    private void loadAllOrders() {
        Scanner s = null;

        //currentFile must be formatted "Orders_MMddyyyy"
        for (String currentFile : fileNames) {
            try {
                s = new Scanner(new BufferedReader(new FileReader(currentFile + FILE_TYPE)));
            } catch (FileNotFoundException e) {
//                throw new EyeTunesDaoException(
//                        "-_- Could not load songs into memory.", e);
            }

            String currentLine;
            Order currentOrder;

            //Skip the first line
            s.nextLine();
            
            //MAY CHANGE hasNextLine()
            while (s.hasNextLine()) {
                currentLine = s.nextLine();
                currentOrder = unmarshallOrder(currentLine, currentFile);
                orders.put(currentOrder.getOrderNum(), currentOrder);
            }
            //May want to move it down one bracket
            s.close();
        }
    }

    public void checkDate(Order order) {
        LocalDate date = order.getOrderDate();
        String fileName = PREFIX + date.format(FORMATTER);
        for (String currentFile : fileNames) {
            if (fileName.equalsIgnoreCase(currentFile)) {
                break;
            }
        }
        System.out.println("We are about to add another file to the list"); //This did not execute
        fileNames.add(fileName); //THIS SEEMS TO BE EXECUTING EVERY TIME???
        createNewFile(fileName); //THIS COULD BE CALLED IN WRITE FILE
    }

    public void createNewFile(String fileName) {
        File file = new File(PATH + fileName + FILE_TYPE);

        //THIS method could be split in two starting here!!!!!!!!!!!
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(DATE_FILE, true));
        } catch (IOException e) {
//            throw new EyeTunesDaoException(
//                    "Could not save artist data.", e);
        }

        System.out.println("A new file was just created");
        out.println(fileName);
        out.flush();
        out.close();
    }

    private String marshallOrder(Order order) {

        String orderAsText = order.getOrderNum() + DELIMITER;
        orderAsText += order.getCustomerName() + DELIMITER;
        orderAsText += order.getState() + DELIMITER;
        orderAsText += order.getTaxRate() + DELIMITER;
        orderAsText += order.getProductType() + DELIMITER;
        orderAsText += order.getArea() + DELIMITER;
        orderAsText += order.getCostPerSqFt() + DELIMITER;
        orderAsText += order.getLaborCostPerSqFt() + DELIMITER;
        orderAsText += order.getMaterialCost() + DELIMITER;
        orderAsText += order.getLaborCost() + DELIMITER;
        orderAsText += order.getTax() + DELIMITER;
        orderAsText += order.getTotal();

        return orderAsText;
    }

    private void writeOrders() {
        PrintWriter out = null;

        //COULD CREATE NEW FILES HERE
        //Also note we are not appending but rewriting files every time??
        for (String currentFile : fileNames) {
            try {
                out = new PrintWriter(new FileWriter(currentFile + FILE_TYPE));
            } catch (IOException e) {
//                throw new EyeTunesDaoException(
//                        "Could not save song data.", e);
            }

            out.println(HEADER);

            String orderAsText;
            LocalDate currentDate = LocalDate.parse(currentFile.substring(7), FORMATTER);
            
            List<Order> orderList = listOrdersForDate(currentDate);

            for (Order currentOrder : orderList) {
                orderAsText = marshallOrder(currentOrder);
                out.println(orderAsText);
                out.flush();
            }
            out.close();
        }
    }
}
