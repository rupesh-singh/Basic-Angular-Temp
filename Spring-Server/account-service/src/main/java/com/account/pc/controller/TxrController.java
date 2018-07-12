package com.account.pc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.account.pc.model.Account;
import com.account.pc.model.Txn;
import com.account.pc.repository.TxnRepository;
import com.account.pc.service.TxrService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/txr")
public class TxrController {

	@Autowired
	private TxnRepository txnRepository;

	@Autowired
	private TxrService txrService;

	@GetMapping(produces = { "application/json" })
	public List<Txn> get() {
		List<Txn> txn = txnRepository.findAll();
		return txn;
	}

	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	protected TxrResponse doPost(@RequestBody TxrRequest txrReq) {

		txrService.txr(txrReq.getAmount(), txrReq.getFromAccNum(), txrReq.getToAccNum());
		
		TxrResponse txrResponse=new TxrResponse();
		txrResponse.setMessage("Done");
		return txrResponse;
	}

}
