package com.captain.CaptainAmerica.service;

import com.captain.CaptainAmerica.dto.InvoiceDTO;

public interface InvoiceService {
    InvoiceDTO findInvoice(String orderId);

    InvoiceDTO registerInvoice(InvoiceDTO invoice);

    void deleteInvoice(String orderId);
}
