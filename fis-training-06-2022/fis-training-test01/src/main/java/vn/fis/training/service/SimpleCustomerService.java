package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.exception.CustomerNotFoundException;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.exception.InvalidCustomerException;
import vn.fis.training.store.InMemoryCustomerStore;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService{

    private InMemoryCustomerStore customerStore;
    Customer customer;

    public List<Customer> findAll() {
        List<Customer> list = customerStore.findAll();
        return list;
    }

    private boolean isNullOrEmpty(String id) {
        if (id.trim() == null) {
            return true;
        }
        return false;
    }
    @Override
    public Customer findById(String id) {

        if (isNullOrEmpty(id)){

            throw new IllegalArgumentException("Khong the tim thay Id");
        }
        return customerStore.findAll().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst().orElseThrow(() -> {
                    throw new CustomerNotFoundException("Khong tim thay" + id);
                });
    }

    @Override
    public void deleteCustomerById(String id) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        if (isNullOrEmpty(id))
            throw new IllegalArgumentException("Khong the tim thay Id");
        customerStore.deleteById(id);
    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {
        customerStore.findAll();
        if (customerStore.findAll().isEmpty()) {
            throw new CustomerNotFoundException("Khong co su lieu");
        }
        return customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    private void checkDuplicate(Customer customer) {
        try {

        } catch (CustomerNotFoundException customerNotFoundException) {
            if (customerStore.findAll().stream().anyMatch(i -> i.hashCode() == 1)) {
                throw new DuplicateCustomerException(customer,
                        String.format("da ton tai customer %s", customer.toString()));
            }
        }
    }

    private void validate(Customer customer) {
        if(!isNullOrEmpty(customer.getName())) {
            throw new IllegalArgumentException("Khong de trong name");
        }

        if(!isNullOrEmpty(customer.getMobile())) {
            throw new IllegalArgumentException("Khong de trong Mobile");
        }
        if(isNullOrEmpty(customer.getBirthDay().toString())){
            throw new IllegalArgumentException("Khong de trong BirthDay ");
        }
        if(isNullOrEmpty(customer.getStatus().toString())){
            throw new IllegalArgumentException("Khong de trong Status ");
        }

    }
    @Override
    public Customer createCustomer(Customer customer) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        validate(customer);
        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        validate(customer);
        findById(customer.getId());
        return customerStore.insertOrUpdate(customer);
    }


    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return null;
    }

    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, String limit) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return null;
    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return null;
    }

}
