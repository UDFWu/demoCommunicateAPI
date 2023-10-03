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
public class DepositProductInfoController {

	private static final Logger logger = LoggerFactory.getLogger(DepositProductInfoController.class);

	@GetMapping(value = "/deposit/domesticDemand/list", produces = "application/json;charset=utf-8")
	@ApiOperation(value = "取得存款分類產品列表-台幣活期")
	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
	public String getDomesticDemandList() {
		logger.info("getDomesticDemandList");
		String uri = "https://api.scsb.com.tw/openAPI/deposit/domesticDemand/list";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}

	@GetMapping(value = "/deposit/domesticDemand/list/{id}", produces = "application/json;charset=utf-8")
	@ApiOperation(value = "取得存款分類產品列表-台幣活期-BY-產品ID")
	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
	public String getDomesticDemandListById(@PathVariable("id") String id) {
		String uri = "https://api.scsb.com.tw/openAPI/deposit/domestic/demand?depositValues=" + id;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
	@GetMapping(value = "/deposit/domesticTime/list", produces = "application/json;charset=utf-8")
	@ApiOperation(value = "取得存款分類產品列表-台幣定期")
	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
	public String getDomesticTimeList() {
		String uri = "https://api.scsb.com.tw/openAPI/deposit/domesticTime/list";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
	@GetMapping(value = "/deposit/foreignDemand/list", produces = "application/json;charset=utf-8")
	@ApiOperation(value = "取得存款分類產品列表-外幣活期")
	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
	public String getForeignDemandList() {
		String uri = "https://api.scsb.com.tw/openAPI/deposit/foreignDemand/list";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
	@GetMapping(value = "/deposit/foreignDemand/list/{id}", produces = "application/json;charset=utf-8")
	@ApiOperation(value = "取得存款分類產品列表-外幣活期-BY-產品ID")
	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
	public String getForeignDemandListById(@PathVariable("id") String id) {
		String uri = "https://api.scsb.com.tw/openAPI/deposit/foreign/demand?depositValues=" + id;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
	@GetMapping(value = "/deposit/foreignTime/list", produces = "application/json;charset=utf-8")
	@ApiOperation(value = "取得存款分類產品列表-外幣定期")
	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
	public String getForeignTimeList() {
		String uri = "https://api.scsb.com.tw/openAPI/deposit/foreignTime/list";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
//	@GetMapping(value = "/deposit/domestic/demand", produces = "application/json;charset=utf-8")
//	@ApiOperation(value = "台幣活期存款類產品資訊")
//	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
//	public String getDepositDomesticDemand() {
//		String uri = "https://api.scsb.com.tw/openAPI/deposit/domestic/demand";
//		RestTemplate restTemplate = new RestTemplate();
//		String result = restTemplate.getForObject(uri, String.class);
//		return result;
//	}
//	
//	@GetMapping(value = "/deposit/domestic/time", produces = "application/json;charset=utf-8")
//	@ApiOperation(value = "台幣定期存款類產品資訊")
//	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
//	public String getDepositDomesticTime() {
//		String uri = "https://api.scsb.com.tw/openAPI/deposit/domestic/time";
//		RestTemplate restTemplate = new RestTemplate();
//		String result = restTemplate.getForObject(uri, String.class);
//		return result;
//	}
//	
//	@GetMapping(value = "/deposit/foreign/demand", produces = "application/json;charset=utf-8")
//	@ApiOperation(value = "外幣活期存款類產品資訊")
//	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
//	public String getDepositForeignDemand() {
//		String uri = "https://api.scsb.com.tw/openAPI/deposit/foreign/demand";
//		RestTemplate restTemplate = new RestTemplate();
//		String result = restTemplate.getForObject(uri, String.class);
//		return result;
//	}
//	
//	@GetMapping(value = "/deposit/foreign/time", produces = "application/json;charset=utf-8")
//	@ApiOperation(value = "外幣定期存款類產品資訊")
//	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
//	public String getDepositForeignTime() {
//		String uri = "https://api.scsb.com.tw/openAPI/deposit/foreign/time";
//		RestTemplate restTemplate = new RestTemplate();
//		String result = restTemplate.getForObject(uri, String.class);
//		return result;
//	}
	
	
}
