package fr.mariech.facturier.repository;

import fr.mariech.facturier.entity.InvoiceLineItem;
import fr.mariech.facturier.entity.InvoiceLineItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InvoiceLineItemRepository extends JpaRepository<InvoiceLineItem, InvoiceLineItemId> {

    List<InvoiceLineItem> findInvoiceLineItemsByInvoice_InvoiceId(Long invoiceId);
}
