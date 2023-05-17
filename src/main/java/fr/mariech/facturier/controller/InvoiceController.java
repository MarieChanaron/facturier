package fr.mariech.facturier.controller;

import fr.mariech.facturier.controller.dto.InvoiceDto;
import fr.mariech.facturier.entity.Invoice;
import fr.mariech.facturier.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/factures")
public class InvoiceController {

    final
    InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping()
    public String allInvoices(Model model) {
        List<InvoiceDto> invoices = invoiceService.fetchAllInvoices();
        return "invoices";
    }
}
