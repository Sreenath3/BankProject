package com.cg.bankproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bankproject.model.Customer;
import com.cg.bankproject.model.Transaction;
import com.cg.bankproject.service.CustomerServiceImpl;
import com.cg.bankproject.service.ITransactionService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	int temp;
	@Autowired
	private CustomerServiceImpl service;
	@Autowired
	private ITransactionService service1;

//saving the the customer in the database 

	@PostMapping("/saveee")
	public ModelAndView save(@RequestParam String name, @RequestParam String password) {
		Customer customerlist = new Customer();
		customerlist.setName(name);
		customerlist.setPassword(password);
		customerlist.setBalance(0);

		service.save(customerlist);
		List<Customer> customerlist1 = service.findAll();
		ModelAndView modelAndView = new ModelAndView("customerlist");
		modelAndView.addObject("CUSTOMERLIST", customerlist1);
		return modelAndView;
	}
	@PostMapping("/saveee1")
	public ModelAndView save() {
	
		List<Customer> customerlist1 = service.findAll();
		ModelAndView modelAndView = new ModelAndView("customerlist");
		modelAndView.addObject("CUSTOMERLIST", customerlist1);
		return modelAndView;
	}
// for changing the password as account is created by manager so we need to change the password for future reference and safety

	@PostMapping("/pass")
	public ModelAndView changepassword(@RequestParam String previouspassword, @RequestParam String password) {
		Customer customer = service.findById(temp);

		String pp = customer.getPassword();

		if (previouspassword.equals(pp)) {
			customer.setPassword(password);
			service.save(customer);

			ModelAndView modelAndView = new ModelAndView("showstatus");

			modelAndView.addObject("AA", customer);
			return modelAndView;

		} else {

			ModelAndView modelAndView = new ModelAndView("wrongpassword");
			return modelAndView;
		}

	}

// for checking the balance
	@GetMapping("/balance")
	public ModelAndView getbalancefromid() {
		Customer customer = service.findById(temp);
		int balance = customer.getBalance();
		ModelAndView modelAndView = new ModelAndView("showbalance");

		modelAndView.addObject("AA", balance);
		return modelAndView;
	}

//for printing the transaction done by a particular user
	@GetMapping("/transaction")
	public ModelAndView gettransaction() {

		List<Transaction> list = service1.findByCustomerId(temp);
		ModelAndView modelAndView = new ModelAndView("receipt");

		modelAndView.addObject("PRINT", list);
		return modelAndView;
	}

//manager login
	@PostMapping("/manager")
	public ModelAndView ManagerLogin(@RequestParam String name, @RequestParam String password) {
		ModelAndView modelAndView;
		String a = name;
		String b = password;

		if (a.equals("Sreenath3") && b.equals("Sree@123")) {
			modelAndView = new ModelAndView("addcustomer");
			return modelAndView;
		} else {
			modelAndView = new ModelAndView("managernotpresent");
		}
		return modelAndView;
	}

// login of customer
	@PostMapping("checkuser")
	public ModelAndView requestLogin(@RequestParam int user, @RequestParam String password) {
		ModelAndView modelAndView;
		temp = user;
		Customer cust = service.findByIdAndPassword(user, password);
		if (cust == null) {
			modelAndView = new ModelAndView("noidfound");
			return modelAndView;
		} else {
			modelAndView = new ModelAndView("home");
			return modelAndView;
		}
	}
//hello
// deposit money
	@PostMapping("/add")
	public ModelAndView addbalance(@RequestParam Integer money) {
		Customer customer = service.findById(temp);
		int sendersmoney = customer.getBalance();
		Transaction tran = new Transaction();
		tran.setAmount(money);
		tran.setType("deposit");
		customer.addTransaction(tran);
		int money1 = sendersmoney + money;

		customer.setBalance(money1);
		service.save(customer);

		ModelAndView modelAndView = new ModelAndView("updatedbalance");

		modelAndView.addObject("AA", customer);
		return modelAndView;
	}

// withdraw money
	@PostMapping("/withdraw")
	public ModelAndView withdrawbalance(@RequestParam Integer money) {

		Customer customer = service.findById(temp);
		int customermoney = customer.getBalance();
		if (customermoney - money < 0 ) {
			ModelAndView modelAndView = new ModelAndView("accountinsfficient");
			
			return modelAndView;
		} else {
			Transaction tran1 = new Transaction();
			tran1.setAmount(money);
			tran1.setType("withdrawl");
			customer.addTransaction(tran1);
			int money1 = customermoney - money;

			customer.setBalance(money1);
			service.save(customer);

			ModelAndView modelAndView = new ModelAndView("updatedbalance");

			modelAndView.addObject("AA", customer);
			return modelAndView;
		}
	}
	@PostMapping("/home")
	public ModelAndView display()
	{
		ModelAndView modelAndView = new ModelAndView("index");	
		return modelAndView;
	}
   

//fund transferS
	@PostMapping("/transfer")
	public ModelAndView FundTransfer(@RequestParam Integer id, @RequestParam Integer money) {

		int sendingmoney = money;
		Customer receiver = service.findById(id);
		int Receiverbalance = receiver.getBalance();
		Customer sender = service.findById(temp);
		int Senderbalance = sender.getBalance();
		if (Senderbalance - sendingmoney < 0) {
			ModelAndView modelAndView = new ModelAndView("accountinsfficient");
			return modelAndView;
		} else {
			Transaction tran3 = new Transaction();
			tran3.setAmount(sendingmoney);
			tran3.setType("transfer");
			receiver.addTransaction(tran3);

			Transaction tran4 = new Transaction();
			tran4.setAmount(sendingmoney);
			tran4.setType("received ");
			sender.addTransaction(tran4);

			int money1 = Receiverbalance + sendingmoney;
			int money2 = Senderbalance - sendingmoney;
			receiver.setBalance(money1);
			sender.setBalance(money2);
			service.save(sender);
			service.save(receiver);

			ModelAndView modelAndView = new ModelAndView("transferdetail");

			modelAndView.addObject("AA", receiver);
			modelAndView.addObject("BB", sender);
			return modelAndView;
		}
	}
}
