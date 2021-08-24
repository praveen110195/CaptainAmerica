package com.captain.CaptainAmerica.service.impl;

import com.captain.CaptainAmerica.dto.CustomerDTO;
import com.captain.CaptainAmerica.dto.InvoiceDTO;
import com.captain.CaptainAmerica.exception.ProgramException;
import com.captain.CaptainAmerica.model.Customer;
import com.captain.CaptainAmerica.model.Invoice;
import com.captain.CaptainAmerica.repository.InvoiceRepository;
import com.captain.CaptainAmerica.repository.SequenceDao;
import com.captain.CaptainAmerica.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final ModelMapper mapper;

    private static final String HOSTING_SEQ_KEY = "invoiceSeq";

    private final SequenceDao sequenceDao;

    @Override
    public InvoiceDTO findInvoice(String orderId) {

        Invoice invoice = invoiceRepository.findByOrderId(orderId);
        if(invoice == null) {
            throw new ProgramException("Invoice not found " +orderId);
        }
        InvoiceDTO invoiceDTO = mapper.map(invoice, InvoiceDTO.class);
        return invoiceDTO;
    }

    @Override
    public InvoiceDTO registerInvoice(InvoiceDTO invoiceDTO) {
        if(invoiceDTO.getId() == null) {
            invoiceDTO.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY, "Invoice"));
        }
        Invoice invoice = mapper.map(invoiceDTO, Invoice.class);
        Invoice invoiceObject = invoiceRepository.save(invoice);
        return mapper.map(invoiceObject, InvoiceDTO.class);
    }

    @Override
    public void deleteInvoice(String orderId) {
        Invoice invoice = invoiceRepository.findByOrderId(orderId);
        if(invoice == null) {
            throw new ProgramException("Invoice not found " +orderId);
        }
        invoiceRepository.deleteByOrderId(orderId);
    }
}
