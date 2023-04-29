package com.project.ccm.controller;




import java.util.List;


import org.springframework.stereotype.Controller;




import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ccm.service.ApplicantService;
import com.project.ccm.service.CardHolderService;
import com.project.ccm.service.LoginService;
import com.project.ccm.service.TransactionService;
import com.project.ccm.entity.Applicant;
import com.project.ccm.entity.Card_Holder;
import com.project.ccm.entity.Transactions;

@Controller
public class ApplicantController {
	
	private ApplicantService applicantService;
	private CardHolderService cardHolderService;
	private TransactionService transactService;
	private LoginService loginService;

	public ApplicantController(ApplicantService applicantService, CardHolderService cardHolderService, TransactionService transactService, LoginService loginService) {
		super();
		this.applicantService = applicantService;
		this.cardHolderService = cardHolderService;
		this.transactService = transactService;
		this.loginService = loginService;
	}
	//Login Form
	@GetMapping("/")
	public String createLoginForm(Model model) {
		String name = new String();
		String phone = new String();
		model.addAttribute("name", name);
		model.addAttribute("phone", phone);
		return "Login";
	}
	@GetMapping("/Login")
	public String Login() {
		return "redirect:/";
	}
	@GetMapping("/Card_Holder")
	public String displayUser(Model model, @RequestParam("phone") String phone) {
		model.addAttribute("Card_Holder",cardHolderService.getCardDetails(phone));
		return "User_Page";
	}
	//Login validation
	@PostMapping("/Login")
	public String enterApp(@ModelAttribute("name") String name, @ModelAttribute("phone") String phone, RedirectAttributes redirectAttributes){
		if(loginService.ValidateAdmin(phone)) {
			return "redirect:/applicant";
		}
		else if(loginService.Validate(phone)){
			redirectAttributes.addAttribute("phone", phone);
			return "redirect:/Card_Holder";
		} else {
			return "redirect:/Login";
		}
	}
	
	//Applicant Display
	@GetMapping("/applicant")
	public String listApplicants(Model model) {
		model.addAttribute("applicant", applicantService.getAllApplicants());
		return "applicant";
	}
	//Applicant creation
	@GetMapping("/applicant/apply")
	public String createApplicantForm(Model model) {
		Applicant applicant = new Applicant();
		model.addAttribute("applicant", applicant);
		return "create_applicant";
	}
	
	//Applicant Updation
	@GetMapping("/applicant/update")
	public String createUpdationForm(Model model) {
		String phone = new String();
		String address = new String();
		String cardType = new String();
		model.addAttribute("phone", phone);
		model.addAttribute("address", address);
		model.addAttribute("cardType", cardType);
		return "update_applicant";
	}
	
	//Transaction Creation
	@GetMapping("/applicant/transact")
	public String createTransactionForm(Model model) {
		Transactions transaction = new Transactions();
		model.addAttribute("transactions", transaction);
		return "create_transaction";
	}
	
	//Transaction History Display
	@GetMapping("/applicant/history")
	public String listTransactions(@ModelAttribute("phone") String phone, Model model, RedirectAttributes redirectAttributes) {
	    List<Transactions> transactions = transactService.getAllTransactions(phone);
	    model.addAttribute("Transactions", transactions);
	    //redirectAttributes.addAttribute("phone",transactions.get(0).getPhone());
	    return "Transaction_History";
	}

	
	//Applicant Save
	@PostMapping("/applicant")
	public String saveApplicant(@ModelAttribute("applicant") Applicant applicant) {
		applicantService.saveApplicant(applicant);
		cardHolderService.saveCardHolder(applicant);
		loginService.saveCredentials(applicant.getPhone());
		return "Login";
	}
	
	//Applicant Update
	@PostMapping("/update")
	public String updateClient(@ModelAttribute("phone") String phone, @ModelAttribute("address") String address, @ModelAttribute("cardType") String cardType,RedirectAttributes redirectAttributes) {
		applicantService.updateApplicant(phone, address, cardType);
		List<Applicant> applicant = applicantService.getApplicantByPhone(phone);
		cardHolderService.updateCardHolder(applicant.get(0));
		//redirectAttributes.addAttribute("phone", phone);
		return "redirect:/";
	}
	
	//Transaction Save
	@PostMapping("/transaction")
	public String createTransation(@ModelAttribute("transactions") Transactions transaction,RedirectAttributes redirectAttributes) {
		transactService.saveTransaction(transaction);
		cardHolderService.Transaction(transaction.getPhone(), transaction.getTransactionAmt());
		//redirectAttributes.addAttribute("phone", transaction.getPhone());
		return "redirect:/";
	}
	
	
}