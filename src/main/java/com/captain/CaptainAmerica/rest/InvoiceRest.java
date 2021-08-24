package com.captain.CaptainAmerica.rest;

import com.captain.CaptainAmerica.dto.CustomerDTO;
import com.captain.CaptainAmerica.dto.InvoiceDTO;
import com.captain.CaptainAmerica.dto.SuccessResponse;
import com.captain.CaptainAmerica.exception.ErrorMessage;
import com.captain.CaptainAmerica.service.InvoiceService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InvoiceRest {

    private final InvoiceService invoiceService;

    @GetMapping("/get-invoice")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server error", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 400, message = "Invoice Fetch Invalid Request", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 201, message = "Invoice Fetch Successfully", response = InvoiceDTO.class, responseContainer = "InvoiceDTO")
    })
    ResponseEntity<InvoiceDTO> getCustomer(@RequestParam(name="orderId") String orderId) throws URISyntaxException {

        log.info("Invoice rest call : {} ", orderId);
        InvoiceDTO invoice = invoiceService.findInvoice(orderId);
        return new ResponseEntity<InvoiceDTO>(invoice, HttpStatus.OK);
    }

    @PostMapping("/register-invoice")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server error", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 400, message = "Invoice Register Invalid Request", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 201, message = "Invoice Registration Successfully", response = InvoiceDTO.class, responseContainer = "InvoiceDTO")
    })
    ResponseEntity<InvoiceDTO> registerCustomer(@RequestBody InvoiceDTO invoice) {
        log.info("rest call for post {}", invoice);
        InvoiceDTO invoiceDTO = invoiceService.registerInvoice(invoice);
        return new ResponseEntity<>(invoiceDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-invoice")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server error", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 400, message = "Delete Invoice Invalid Request", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 201, message = "Delete Invoice Record Successfully", response = SuccessResponse.class, responseContainer = "SuccessResponse")
    })
    ResponseEntity<SuccessResponse> deleteCustomer(@RequestParam (name="orderId") String orderId) {
        log.info("Delete the invoice record {}", orderId);
        invoiceService.deleteInvoice(orderId);
        return new ResponseEntity<>(new SuccessResponse("Delete Successfully"), HttpStatus.OK);
    }

    @PutMapping("/update-invoice")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server error", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 400, message = "Customer Register Invalid Request", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 201, message = "Customer Registration Successfully", response = InvoiceDTO.class, responseContainer = "InvoiceDTO")
    })
    ResponseEntity<InvoiceDTO> updateCustomer(@RequestBody InvoiceDTO invoiceDTO) {

        log.info("Update Customer rest call {} ", invoiceDTO);
        InvoiceDTO invoice = invoiceService.registerInvoice(invoiceDTO);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

}
