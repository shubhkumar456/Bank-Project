package com.example.Bank.Project.service;

import com.example.Bank.Project.bank_model.Bank;
import com.example.Bank.Project.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository repository;

    public void addclient(Bank bank){
        repository.save(bank);
    }

    public List<Bank> getclient(){
        return repository.findAll();
    }

    public Bank getbyid(int id){
        Optional<Bank> client=repository.findById(id);
        if (client.isPresent()){
            return client.get();
        }
        return null;
    }

    public void deleteclient(int id){
        repository.deleteById(id);
    }
}
