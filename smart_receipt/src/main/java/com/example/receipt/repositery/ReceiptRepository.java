package com.example.receipt.repositery;

import org.springframework.data.repository.CrudRepository;

import com.example.receipt.model.Receipt;

public interface ReceiptRepository extends CrudRepository<Receipt,Long> {

}
