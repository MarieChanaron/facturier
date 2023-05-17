package fr.mariech.facturier.service;

import fr.mariech.facturier.controller.dto.InvoiceDto;
import fr.mariech.facturier.controller.dto.PaymentDto;
import fr.mariech.facturier.entity.Invoice;
import fr.mariech.facturier.entity.InvoiceLineItem;
import fr.mariech.facturier.entity.Payment;
import fr.mariech.facturier.repository.InvoiceLineItemRepository;
import fr.mariech.facturier.repository.InvoiceRepository;
import fr.mariech.facturier.util.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    final InvoiceRepository invoiceRepository;
    final InvoiceLineItemRepository invoiceLineItemRepository;


    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceLineItemRepository invoiceLineItemRepository) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceLineItemRepository = invoiceLineItemRepository;
    }

    public List<InvoiceDto> fetchAllInvoices() {

        List<Invoice> invoices = invoiceRepository.findAll();
        List<InvoiceDto> invoiceDtoList = new ArrayList<>();

        for (Invoice invoice : invoices) {
            InvoiceDto invoiceDto = new InvoiceDto();
            invoiceDto.setInvoiceId(invoice.getInvoiceId());
            invoiceDto.setIssuingDate(invoice.getIssuingDate());
            invoiceDto.setDeadline(invoice.getDeadline());

            Payment payment = invoice.getPayment();
            if (payment != null) {
                PaymentDto paymentDto = new PaymentDto();
                paymentDto.setPaymentId(payment.getPaymentId());
                paymentDto.setPaymentMethod(payment.getPaymentMethod());
                paymentDto.setPaymentDate(payment.getPaymentDate());
                invoiceDto.setPaymentDto(paymentDto);
            }

            List<InvoiceLineItem> invoiceLines = invoiceLineItemRepository.findInvoiceLineItemsByInvoice_InvoiceId(invoice.getInvoiceId());
            double total = 0;

            for (InvoiceLineItem lineItem : invoiceLines) {
                byte quantity = lineItem.getQuantity();
                double productPrice = lineItem.getProduct().getPriceBeforeVat().doubleValue();
                double price = quantity * productPrice;
                total += price;
            }

            invoiceDto.setTotal(total);

            invoiceDto.setStatus(Status.getStatus(invoiceDto));
            invoiceDtoList.add(invoiceDto);
        }

        return invoiceDtoList;
    }
}
