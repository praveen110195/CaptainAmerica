package com.captain.CaptainAmerica.rest;

import com.captain.CaptainAmerica.dto.CustomerDTO;
import com.captain.CaptainAmerica.dto.SuccessResponse;
import com.captain.CaptainAmerica.exception.ErrorMessage;
import com.captain.CaptainAmerica.service.CustomerService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CustomerRest {

    private final CustomerService customerService;

    @GetMapping("/get-customer")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server error", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 400, message = "Customer Fetch Invalid Request", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 201, message = "Customer Fetch Successfully", response = CustomerDTO.class, responseContainer = "CustomerDTO")
    })
    ResponseEntity<CustomerDTO> getCustomer(@RequestParam (name="userId") String userId) throws URISyntaxException {

        log.info("Customer rest call : {} ", userId);
        CustomerDTO customer = customerService.findCustomer(userId);
        return new ResponseEntity<CustomerDTO>(customer, HttpStatus.OK);
    }

    @PostMapping("/register-customer")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server error", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 400, message = "Customer Register Invalid Request", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 201, message = "Customer Registration Successfully", response = CustomerDTO.class, responseContainer = "CustomerDTO")
    })
    ResponseEntity<CustomerDTO> registerCustomer(@RequestBody CustomerDTO customer) {
        log.info("rest call for post {}", customer);
        CustomerDTO customerDTO = customerService.registerCustomer(customer);
        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-customer")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server error", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 400, message = "Delete Customer Invalid Request", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 201, message = "Delete Customer Record Successfully", response = SuccessResponse.class, responseContainer = "SuccessResponse")
    })
    ResponseEntity<SuccessResponse> deleteCustomer(@RequestParam (name="userId") String userId) {
        log.info("Delete the customer record {}", userId);
        customerService.deleteCustomer(userId);
        return new ResponseEntity<>(new SuccessResponse("Delete Successfully"), HttpStatus.OK);
    }

    @PutMapping("/update-customer")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server error", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 400, message = "Customer Register Invalid Request", response = ErrorMessage.class, responseContainer = "ErrorResponse"),
            @ApiResponse(code = 201, message = "Customer Registration Successfully", response = CustomerDTO.class, responseContainer = "CustomerDTO")
    })
    ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {

        log.info("Update Customer rest call {} ", customerDTO);
        CustomerDTO customer = customerService.registerCustomer(customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
