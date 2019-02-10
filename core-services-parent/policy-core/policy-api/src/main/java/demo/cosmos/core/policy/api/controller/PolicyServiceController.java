
package demo.cosmos.core.policy.api.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.cognizant.cosmos.core.utils.execution.ServiceContext;

import demo.cosmos.core.policy.dao.entity.Product;
import demo.cosmos.core.policy.model.CreateProposal;
import demo.cosmos.core.policy.model.PolicyCreationRequestWrapper;
import demo.cosmos.core.policy.model.PolicyDetails;
import demo.cosmos.core.policy.model.ProposalBeneficiaryInfo;
import demo.cosmos.core.policy.model.ProposalCommunicationDetails;
import demo.cosmos.core.policy.model.ProposalQuestionInfo;
import demo.cosmos.core.policy.service.PolicyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 */
@RestController
@Api("policy-service")
@CrossOrigin("*")
public class PolicyServiceController {

	private final static Logger LOG = LoggerFactory.getLogger(PolicyServiceController.class);
	@Autowired
	private Environment env;
	@Autowired
	private PolicyService policyService;

	/**
	 * 
	 */
	@GetMapping(value = "/api/policy/products/{productID}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retrieve a product details", tags = "GET /api/policy/products/{productID}", response = demo.cosmos.core.policy.model.ProductResource.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully retrieved product list"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<demo.cosmos.core.policy.model.ProductResource> getProductsUsingGET(
			@PathVariable("productID") String productID,
			@ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
			@ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
			@ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {
		LOG.info(env.getProperty("policy-service.log.message.key.1"));
		demo.cosmos.core.policy.model.ProductResource data = policyService.getProductsUsingGET(productID,
				new ServiceContext(headers, pathParams, queryParams));
		if (data != null) {
			LOG.info(env.getProperty("policy-service.log.message.key.2"));
			return new ResponseEntity<demo.cosmos.core.policy.model.ProductResource>(data, HttpStatus.OK);
		} else {
			LOG.info(env.getProperty("policy-service.log.message.key.3"));
			return new ResponseEntity<demo.cosmos.core.policy.model.ProductResource>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 
	 */
	@GetMapping(value = "/api/policy/products/{productID}/plans", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retrieve a plans details", tags = "GET /api/policy/products/{productID}/plans", response = demo.cosmos.core.policy.model.PlansResource.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully retrieved plans list"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<List<demo.cosmos.core.policy.model.PlansResource>> getPlansUsingGET(
			@PathVariable("productID") String productID,
			@ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
			@ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
			@ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {
		LOG.info(env.getProperty("policy-service.log.message.key.4"));
		List<demo.cosmos.core.policy.model.PlansResource> data = policyService
				.getPlansUsingGET(new ServiceContext(headers, pathParams, queryParams));
		if (data != null) {
			LOG.info(env.getProperty("policy-service.log.message.key.2"));
			return new ResponseEntity<List<demo.cosmos.core.policy.model.PlansResource>>(data, HttpStatus.OK);
		} else {
			LOG.info(env.getProperty("policy-service.log.message.key.3"));
			return new ResponseEntity<List<demo.cosmos.core.policy.model.PlansResource>>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 
	 */
	@GetMapping(value = "/api/policy/products/{productID}/questions", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retrieve a questions details", tags = "GET /api/policy/products/{productID}/questions", response = demo.cosmos.core.policy.model.QuestionResource.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully retrieved questions list"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<List<demo.cosmos.core.policy.model.QuestionResource>> getQuestionsUsingGET(
			@PathVariable("productID") String productID,
			@ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
			@ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
			@ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {
		LOG.info(env.getProperty("policy-service.log.message.key.5"));
		List<demo.cosmos.core.policy.model.QuestionResource> data = policyService
				.getQuestionsUsingGET(new ServiceContext(headers, pathParams, queryParams));
		if (data != null) {
			LOG.info(env.getProperty("policy-service.log.message.key.2"));
			return new ResponseEntity<List<demo.cosmos.core.policy.model.QuestionResource>>(data, HttpStatus.OK);
		} else {
			LOG.info(env.getProperty("policy-service.log.message.key.3"));
			return new ResponseEntity<List<demo.cosmos.core.policy.model.QuestionResource>>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 
	 */
	@PostMapping(value = "/api/policy/quote", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add a quote details", tags = "POST /api/policy/quote")
	@ApiResponses({ @ApiResponse(code = 201, message = "Successfully created quote list") })
	public ResponseEntity<CreateProposal> saveQuoteUsingPOST(
			@Valid @RequestBody PolicyCreationRequestWrapper policyCreationRequestWrapper,
			@ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
			@ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
			@ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {
		LOG.info(env.getProperty("policy-service.log.message.key.6"));
		CreateProposal data = policyService.saveQuoteUsingPOST(policyCreationRequestWrapper,
				new ServiceContext(headers, pathParams, queryParams, policyCreationRequestWrapper));
		LOG.info(env.getProperty("policy-service.log.message.key.7"));
		return new ResponseEntity<CreateProposal>(data, HttpStatus.CREATED);
	}

	/**
	 * 
	 */
	@GetMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retrieve a error details", tags = "GET /error", response = demo.cosmos.core.policy.model.ModelAndView.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully retrieved error list"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<demo.cosmos.core.policy.model.ModelAndView> errorHtmlUsingGET(
			@ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
			@ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
			@ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {
		LOG.info(env.getProperty("policy-service.log.message.key.8"));
		demo.cosmos.core.policy.model.ModelAndView data = policyService
				.errorHtmlUsingGET(new ServiceContext(headers, pathParams, queryParams));
		if (data != null) {
			LOG.info(env.getProperty("policy-service.log.message.key.2"));
			return new ResponseEntity<demo.cosmos.core.policy.model.ModelAndView>(data, HttpStatus.OK);
		} else {
			LOG.info(env.getProperty("policy-service.log.message.key.3"));
			return new ResponseEntity<demo.cosmos.core.policy.model.ModelAndView>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 
	 */
	@PostMapping(value = "/error", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add a error details", tags = "POST /error")
	@ApiResponses({ @ApiResponse(code = 201, message = "Successfully created error list") })
	public ResponseEntity<demo.cosmos.core.policy.model.ModelAndView> errorHtmlUsingPOST(
			@Valid @RequestBody String string, @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
			@ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
			@ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {
		LOG.info(env.getProperty("policy-service.log.message.key.9"));
		demo.cosmos.core.policy.model.ModelAndView data = policyService.errorHtmlUsingPOST(string,
				new ServiceContext(headers, pathParams, queryParams, string));
		LOG.info(env.getProperty("policy-service.log.message.key.7"));
		return new ResponseEntity<demo.cosmos.core.policy.model.ModelAndView>(data, HttpStatus.CREATED);
	}

	/**
	 * 
	 */
	@PutMapping(value = "/error", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update a error details", tags = "PUT /error")
	@ApiResponses({ @ApiResponse(code = 204, message = "Successfully updated error list"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<demo.cosmos.core.policy.model.ModelAndView> errorHtmlUsingPUT(
			@Valid @RequestBody String string, @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
			@ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
			@ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {
		LOG.info(env.getProperty("policy-service.log.message.key.10"));
		demo.cosmos.core.policy.model.ModelAndView updated = policyService.errorHtmlUsingPUT(string,
				new ServiceContext(headers, pathParams, queryParams, string));
		if (updated != null) {
			LOG.info(env.getProperty("policy-service.log.message.key.11"));
			return new ResponseEntity<demo.cosmos.core.policy.model.ModelAndView>(updated, HttpStatus.OK);
		} else {
			LOG.info(env.getProperty("policy-service.log.message.key.12"));
			return new ResponseEntity<demo.cosmos.core.policy.model.ModelAndView>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 
	 */
	@DeleteMapping("/error")
	@ApiOperation(value = "Delete a error details", tags = "DELETE /error")
	@ApiResponses({ @ApiResponse(code = 204, message = "Successfully deleted error list"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<Integer> errorHtmlUsingDELETE(@ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
			@ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
			@ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {
		LOG.info(env.getProperty("policy-service.log.message.key.13"));
		int deleted = policyService.errorHtmlUsingDELETE(new ServiceContext(headers, pathParams, queryParams));
		if (deleted > 0) {
			LOG.info(env.getProperty("policy-service.log.message.key.14"));
			return new ResponseEntity<Integer>(deleted, HttpStatus.NO_CONTENT);
		} else {
			LOG.info(env.getProperty("policy-service.log.message.key.15"));
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getwrapper")
	public ResponseEntity<PolicyCreationRequestWrapper> getWrapper(){
		PolicyCreationRequestWrapper wrapper=new PolicyCreationRequestWrapper();
		wrapper.setPolicyDetails(new CreateProposal());
		wrapper.getPolicyDetails().addBeneficiaryListItem(new ProposalBeneficiaryInfo());
		wrapper.getPolicyDetails().addQuestionListItem(new ProposalQuestionInfo());
		wrapper.getPolicyDetails().setCommunicationDetails(new ProposalCommunicationDetails());
		wrapper.getPolicyDetails().setPolicyDetails(new PolicyDetails());
		return new ResponseEntity<PolicyCreationRequestWrapper>(wrapper,HttpStatus.OK);
	}
}