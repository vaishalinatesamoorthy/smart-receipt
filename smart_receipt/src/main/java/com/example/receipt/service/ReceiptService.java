package com.example.receipt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.receipt.model.Receipt;
import com.example.receipt.repositery.ReceiptRepository;


@Service
@Transactional
public class ReceiptService {
	@Autowired
private ReceiptRepository rr;
public void savedetails(Receipt r) {
	rr.save(r);
	
	
}
public List<Receipt> getDetails() {
	return (List<Receipt>)rr.findAll();
}

public List<Receipt> getproductDetails(List<Long> receiptid) {
	return (List<Receipt>) rr.findAllById(receiptid);
}
}
