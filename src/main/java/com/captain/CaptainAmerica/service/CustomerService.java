package com.captain.CaptainAmerica.service;

import com.captain.CaptainAmerica.dto.CustomerDTO;

public interface CustomerService {

    CustomerDTO findCustomer(String userId);

    CustomerDTO registerCustomer(CustomerDTO customer);

    void deleteCustomer(String userId);
}
