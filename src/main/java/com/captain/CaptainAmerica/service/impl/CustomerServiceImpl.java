package com.captain.CaptainAmerica.service.impl;

import com.captain.CaptainAmerica.dto.CustomerDTO;
import com.captain.CaptainAmerica.exception.ProgramException;
import com.captain.CaptainAmerica.exception.SequenceException;
import com.captain.CaptainAmerica.model.Customer;
import com.captain.CaptainAmerica.repository.CustomerRepository;
import com.captain.CaptainAmerica.repository.SequenceDao;
import com.captain.CaptainAmerica.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final ModelMapper mapper;

    private static final String HOSTING_SEQ_KEY = "hosting";
    private final SequenceDao sequenceDao;

    @Override
    public CustomerDTO findCustomer(String userId) {
       Customer customer = customerRepository.findByUserId(userId);
       CustomerDTO customerDTO = mapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    @Override
    public CustomerDTO registerCustomer(CustomerDTO customerDTO) throws SequenceException {
        if(customerDTO.getId() == null) {
            customerDTO.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY, "Customer"));
        }
        Customer customer = mapper.map(customerDTO, Customer.class);
        Customer customerObject = customerRepository.save(customer);
        return mapper.map(customerObject, CustomerDTO.class);
    }

    @Override
    public void deleteCustomer(String userId) {
        Customer customer = customerRepository.findByUserId(userId);
        if(customer == null) {
            throw new ProgramException("Customer not found " +userId);
        }
        customerRepository.deleteByUserId(userId);
    }
}
