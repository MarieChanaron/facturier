package fr.mariech.facturier.service;

import fr.mariech.facturier.controller.dto.ClientDto;
import fr.mariech.facturier.controller.dto.InvoiceDto;
import fr.mariech.facturier.controller.dto.PaymentDto;
import fr.mariech.facturier.entity.Client;
import fr.mariech.facturier.entity.Invoice;
import fr.mariech.facturier.entity.Payment;
import fr.mariech.facturier.repository.ClientRepository;
import fr.mariech.facturier.util.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    final
    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<ClientDto> getClientById(long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        ClientDto clientDto = new ClientDto();

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            clientDto.setClientId(client.getClientId());
            clientDto.setCompanyName(client.getCompanyName());
            clientDto.setPhone(client.getPhone());
            clientDto.setAddress(client.getAddress());

            List<Invoice> invoices = client.getInvoices();
            List<InvoiceDto> invoiceDtoList = new ArrayList<>();
            invoices.stream().forEach(invoice -> {
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

                invoiceDto.setStatus(Status.getStatus(invoiceDto));
                invoiceDtoList.add(invoiceDto);
            });
            clientDto.setInvoices(invoiceDtoList);
        }

        return Optional.of(clientDto);
    }
}
