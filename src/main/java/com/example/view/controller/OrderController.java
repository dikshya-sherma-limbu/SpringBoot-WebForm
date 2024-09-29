package com.example.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.view.model.Order;
import com.example.view.model.Validation;

@Controller
public class OrderController {

	@PostMapping("/phoneWebForm")
	public String phone(@ModelAttribute("phoneWebForm") Order order,  Model model) {
		Validation validation = new Validation();
		boolean checkValidation = validation.checkValidation(order);
		
		try {

				if(checkValidation==true) {
					model.addAttribute("order", order);
					System.out.print(checkValidation);
					System.out.print(order.getStreetAddress());
					System.out.print("priuce: " +order.getPhonePrice());
					System.out.print("submitted");
					return "show-order";	
				}else{
					System.out.print(checkValidation);
					System.out.print(order);
					System.out.println("Error occurred else block ");
					return "error-page";
				}				
		}catch(Exception e) {
			   System.out.println("Error occurred: " + e.getMessage());
			return "error-page";
		}
	}

}
