/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lydia
 */
public class VendingMachineAuditDaoFileImpl implements VendingMachineAuditDao {

    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void writeAuditEntry(String entry)
            throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch(IOException e){
            throw new VendingMachinePersistenceException("Could not persist "
                    + "audit information.", e);
        }

        LocalDateTime timestamp = LocalDateTime.now();
        String formated = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        out.println(formated + " : " + entry);
        out.flush();
    }
}
