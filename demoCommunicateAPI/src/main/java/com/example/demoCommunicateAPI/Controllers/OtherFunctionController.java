package com.example.demoCommunicateAPI.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class OtherFunctionController {
	private static final Logger logger = LoggerFactory.getLogger(OtherFunctionController.class);

	@GetMapping(value = "/otherService/currency/list", produces = "application/json;charset=utf-8")
	@ApiOperation(value = "取得外幣幣別列表資訊")
	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
	public String getCurrencyList() {
		logger.info("getCurrencyList");
		String uri = "https://api.scsb.com.tw/openAPI/otherService/currency/list";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}

	@GetMapping(value = "/otherService/exchangeRates/{currency}", produces = "application/json;charset=utf-8")
	@ApiOperation(value = "取得銀行匯率資訊")
	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
	public String getExchangeRates(@PathVariable("currency") String currency) {
		String uri = "https://api.scsb.com.tw/openAPI/otherService/exchangeRates?currency=" + currency;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
}
