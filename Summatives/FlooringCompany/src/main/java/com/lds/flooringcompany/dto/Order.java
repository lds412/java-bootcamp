/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author lydia
 */
public class Order {

    private int orderNum;
    private LocalDate orderDate;
    private String customerName;
    private String state;
    private BigDecimal taxRate;
    private String productType;
    private BigDecimal area;
    private BigDecimal costPerSqFt;
    private BigDecimal laborCostPerSqFt;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    //private BigDecimal total;
    
    private final String DELIMITER = ",  ";

    //Order number is unique
    public Order(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getOrderNum() {
        return orderNum;
    }

    //KEEP???
//    public void setOrderNum(int orderNum) {
//        this.orderNum = orderNum;
//    }
    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate() {
        this.orderDate = LocalDate.now();
    }

    public void setOrderDate(LocalDate date) {
        this.orderDate = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) throws DelimiterInclusionException {
        if (customerName.contains(DELIMITER)) {
            throw new DelimiterInclusionException("Customer name may not include "
                    + "the string \""+ DELIMITER +"\"");
        }
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(BigDecimal costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public BigDecimal getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(BigDecimal laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public BigDecimal getMaterialCost() {
        materialCost = costPerSqFt.multiply(area).setScale(2, RoundingMode.HALF_UP);
        return materialCost;
    }

    public BigDecimal getLaborCost() {
        laborCost = laborCostPerSqFt.multiply(area).setScale(2, RoundingMode.HALF_UP);
        return laborCost;
    }

    public BigDecimal getTax() {
        BigDecimal preTaxTotal = materialCost.add(laborCost);
        BigDecimal hundred = new BigDecimal("100");
        tax = preTaxTotal.multiply(taxRate).divide(hundred).setScale(2, RoundingMode.HALF_UP);
        return tax;
    }

    public BigDecimal getTotal() {
        BigDecimal preTaxTotal = materialCost.add(laborCost).setScale(2, RoundingMode.HALF_UP);
        return tax.add(preTaxTotal);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.orderNum;
        hash = 59 * hash + Objects.hashCode(this.orderDate);
        hash = 59 * hash + Objects.hashCode(this.customerName);
        hash = 59 * hash + Objects.hashCode(this.state);
        hash = 59 * hash + Objects.hashCode(this.taxRate);
        hash = 59 * hash + Objects.hashCode(this.productType);
        hash = 59 * hash + Objects.hashCode(this.area);
        hash = 59 * hash + Objects.hashCode(this.costPerSqFt);
        hash = 59 * hash + Objects.hashCode(this.laborCostPerSqFt);
        hash = 59 * hash + Objects.hashCode(this.materialCost);
        hash = 59 * hash + Objects.hashCode(this.laborCost);
        hash = 59 * hash + Objects.hashCode(this.tax);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderNum != other.orderNum) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.costPerSqFt, other.costPerSqFt)) {
            return false;
        }
        if (!Objects.equals(this.laborCostPerSqFt, other.laborCostPerSqFt)) {
            return false;
        }
        if (!Objects.equals(this.materialCost, other.materialCost)) {
            return false;
        }
        if (!Objects.equals(this.laborCost, other.laborCost)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        return true;
    }
    
}
