package controllers;

import GUI.EcoCreateInvoiceCard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.Customer;
import objects.Project;

public final class EcoCreateInvoiceCardController implements ActionListener {

    private final EcoCreateInvoiceCard view;

    public EcoCreateInvoiceCardController(EcoCreateInvoiceCard view) {
        this.view = view;

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Hello from EcoCreateInvoiceCardController");
        String source = event.getActionCommand();
        if (source.equalsIgnoreCase("Save")) {
            System.out.println("Save was pressed");
        }
    }

}
