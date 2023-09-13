package com.example.receipt.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.receipt.model.Product;
import com.example.receipt.model.Receipt;
import com.example.receipt.service.MailService;
import com.example.receipt.service.ReceiptService;



@Controller
public class ReceiptController {
	@Autowired
	MailService ms;
	@Autowired
	ReceiptService rs;
@GetMapping("/first")
public String showForm(Model m)
{  Receipt r=new Receipt();
    m.addAttribute("firstobj",r);
	return "FirstPage";
}

@RequestMapping(value="/first",method=RequestMethod.POST)
@ResponseBody
public String processForm(Receipt r,Product p) throws Exception
{   

   r.setProductdetails(p);
   rs.savedetails(r);
   System.out.println("send mail");
	Map<String,Object>map=new HashMap<String,Object>();
    map.put("id",r.getCid());
    map.put("name",r.getCname());
    map.put("email",r.getEmail());
    map.put("address",r.getAddress());
    map.put("totamt", r.getTotalAmount());
    map.put("productname",p.getPname());
    map.put("perItemPrice", p.getPer());
    map.put("Quantity", p.getQuantity());
    map.put("price", p.getPrice());
	 ms.sendmail(r,map);
	return "Mail Sent SuccessFully";
}
@GetMapping("/view")
public String viewDetails(Model m) {
	List<Receipt> receiptList=new ArrayList<Receipt>();
	receiptList=rs.getDetails();
	m.addAttribute("result",receiptList);
	System.out.println("Details View");
	return "viewdetails";
}
@GetMapping("/viewproductdetails")
public String viewProductDetails(Model m,@RequestParam(name="id")List<Long> receiptid) {
	
	System.out.println("Id Linked"+receiptid);
	List<Receipt> receiptList=new ArrayList<Receipt>();
	receiptList=rs.getproductDetails(receiptid);
	m.addAttribute("result",receiptList);
	return "viewproducts";
	
}
}
