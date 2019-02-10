
package demo.cosmos.core.policy.api.test;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.cognizant.cosmos.core.utils.execution.ServiceContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.cosmos.core.policy.api.controller.PolicyServiceController;
import demo.cosmos.core.policy.model.ModelAndView;
import demo.cosmos.core.policy.model.PlansResource;
import demo.cosmos.core.policy.model.PolicyCreationRequestWrapper;
import demo.cosmos.core.policy.model.PolicyDetails;
import demo.cosmos.core.policy.model.ProductResource;
import demo.cosmos.core.policy.model.ProposalCommunicationDetails;
import demo.cosmos.core.policy.model.QuestionResource;
import demo.cosmos.core.policy.service.PolicyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(PolicyServiceController.class)
@PropertySource("classpath:log.messages")
public class PolicyServiceControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private PolicyService policyService;
	private ObjectMapper mapper = new ObjectMapper();
	private final static List DEFAULT_LINKS = null;
	private final static String DEFAULT_SHORTPRODUCTNAME = "DEFAULT_SHORTPRODUCTNAME";
	private final static Integer DEFAULT_RISKSTARTDATERANGE = 301;
	private final static Boolean DEFAULT_BACKDATEDINCEPTION = true;
	private final static Integer DEFAULT_BACKDATEDINCEPTIONRANGE = 301;
	private final static Integer DEFAULT_PRODUCTID = 301;
	private final static String DEFAULT_PRODUCTNAME = "DEFAULT_PRODUCTNAME";
	private final static Integer DEFAULT_LOBID = 301;
	private final static Date DEFAULT_STARTDATE = null;
	private final static Date DEFAULT_ENDDATE = null;
	private final static Date DEFAULT_EFFECTIVEDATE = null;
	private final static List DEFAULT_PLANDETAILS = null;
	private final static List DEFAULT_SUMINSUREDINLAKHS = null;
	private final static Integer DEFAULT_PLANID = 301;
	private final static String DEFAULT_POLICYTYPE = "DEFAULT_POLICYTYPE";
	private final static Integer DEFAULT_QUESTIONID = 301;
	private final static String DEFAULT_QUESTION = "DEFAULT_QUESTION";
	private final static demo.cosmos.core.policy.model.CreateProposal DEFAULT_POLICYDETAILS = null;
	private final static String DEFAULT_SUMINSURED = "DEFAULT_SUMINSURED";
	private final static PolicyDetails DEFAULT_POLICYDETAILS_1 = null;
	private final static Integer DEFAULT_AFFINITYID = 301;
	private final static Integer DEFAULT_CUSTOMERID = 301;
	private final static String DEFAULT_EMPLOYEECODE = "DEFAULT_EMPLOYEECODE";
	private final static String DEFAULT_GSTNO = "DEFAULT_GSTNO";
	private final static String DEFAULT_PAYMENTOPTION = "DEFAULT_PAYMENTOPTION";
	private final static Integer DEFAULT_POLICYID = 301;
	private final static String DEFAULT_POLICYTERM = "DEFAULT_POLICYTERM";
	private final static List DEFAULT_QUESTIONLIST = null;
	private final static List DEFAULT_BENEFICIARYLIST = null;
	private final static ProposalCommunicationDetails DEFAULT_COMMUNICATIONDETAILS = null;
	private final static Integer DEFAULT_POLICYSTATUSID = 301;
	private final static Timestamp DEFAULT_POLICYSTARTDATE = null;
	private final static String DEFAULT_MASTERPOLICYNO = "DEFAULT_MASTERPOLICYNO";
	private final static Timestamp DEFAULT_POLICYENDDATE = null;
	private final static Integer DEFAULT_BRANCHID = 301;
	private final static Boolean DEFAULT_REFERENCE = true;
	private final static Object DEFAULT_MODEL = null;
	//private final static demo.cosmos.core.policy.model.ModelAndView$StatusEnum DEFAULT_STATUS = null;
	private final static Boolean DEFAULT_EMPTY = true;
	private final static Map DEFAULT_MODELMAP = null;
	private final static demo.cosmos.core.policy.model.View DEFAULT_VIEW = null;
	private final static String DEFAULT_VIEWNAME = "DEFAULT_VIEWNAME";
	private final static Boolean UPDATED_REFERENCE = false;
	private final static Object UPDATED_MODEL = null;
	//private final static demo.cosmos.core.policy.model.ModelAndView$StatusEnum UPDATED_STATUS = null;
	private final static Boolean UPDATED_EMPTY = false;
	private final static Map UPDATED_MODELMAP = null;
	private final static demo.cosmos.core.policy.model.View UPDATED_VIEW = null;
	private final static String UPDATED_VIEWNAME = "UPDATED_VIEWNAME";
	private final static java.lang.Integer DEFAULT_DELETE_RETURN = 1;

	private ProductResource defaultProductResource() {
		ProductResource productResource = new ProductResource();
		productResource.setLinks(DEFAULT_LINKS);
		productResource.setShortProductname(DEFAULT_SHORTPRODUCTNAME);
		productResource.setRiskstartdaterange(DEFAULT_RISKSTARTDATERANGE);
		productResource.setBackdatedinception(DEFAULT_BACKDATEDINCEPTION);
		productResource.setBackdatedinceptionrange(DEFAULT_BACKDATEDINCEPTIONRANGE);
		productResource.setProductid(DEFAULT_PRODUCTID);
		productResource.setProductname(DEFAULT_PRODUCTNAME);
		productResource.setLobid(DEFAULT_LOBID);
		productResource.setStartdate(DEFAULT_STARTDATE);
		productResource.setEnddate(DEFAULT_ENDDATE);
		productResource.setEffectivedate(DEFAULT_EFFECTIVEDATE);
		return productResource;
	}

	@Test
	public void testGetProductsUsingGET() throws Exception {
		Mockito.when(policyService.getProductsUsingGET(Mockito.any(String.class), Mockito.any(ServiceContext.class)))
				.thenReturn(defaultProductResource());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/policy/products/123").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
				.andDo(MockMvcResultHandlers.print());
	}

	private PlansResource defaultPlansResource() {
		PlansResource plansResource = new PlansResource();
		plansResource.setLinks(DEFAULT_LINKS);
		plansResource.setPlanDetails(DEFAULT_PLANDETAILS);
		plansResource.setSumInsuredinLakhs(DEFAULT_SUMINSUREDINLAKHS);
		plansResource.setPlanid(DEFAULT_PLANID);
		plansResource.setPolicytype(DEFAULT_POLICYTYPE);
		plansResource.setProductid(DEFAULT_PRODUCTID);
		return plansResource;
	}

	@Test
	public void testGetPlansUsingGET() throws Exception {
		Mockito.when(policyService.getPlansUsingGET(Mockito.any(ServiceContext.class)))
				.thenReturn(Arrays.asList(defaultPlansResource()));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/policy/products/123/plans").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
				.andDo(MockMvcResultHandlers.print());
	}

	private QuestionResource defaultQuestionResource() {
		QuestionResource questionResource = new QuestionResource();
		questionResource.setLinks(DEFAULT_LINKS);
		questionResource.setQuestionid(DEFAULT_QUESTIONID);
		questionResource.setQuestion(DEFAULT_QUESTION);
		questionResource.setProductid(DEFAULT_PRODUCTID);
		return questionResource;
	}

	@Test
	public void testGetQuestionsUsingGET() throws Exception {
		Mockito.when(policyService.getQuestionsUsingGET(Mockito.any(ServiceContext.class)))
				.thenReturn(Arrays.asList(defaultQuestionResource()));
		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/policy/products/123/questions").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
				.andDo(MockMvcResultHandlers.print());
	}

	private PolicyCreationRequestWrapper defaultPolicyCreationRequestWrapper() {
		PolicyCreationRequestWrapper policyCreationRequestWrapper = new PolicyCreationRequestWrapper();
		policyCreationRequestWrapper.setPolicyDetails(DEFAULT_POLICYDETAILS);
		return policyCreationRequestWrapper;
	}

	private demo.cosmos.core.policy.model.CreateProposal defaultCreateProposal() {
		demo.cosmos.core.policy.model.CreateProposal createProposal = new demo.cosmos.core.policy.model.CreateProposal();
		createProposal.setLinks(DEFAULT_LINKS);
		createProposal.setSumInsured(DEFAULT_SUMINSURED);
		createProposal.setPolicyDetails(DEFAULT_POLICYDETAILS_1);
		createProposal.setAffinityId(DEFAULT_AFFINITYID);
		createProposal.setCustomerId(DEFAULT_CUSTOMERID);
		createProposal.setEmployeeCode(DEFAULT_EMPLOYEECODE);
		createProposal.setGstNo(DEFAULT_GSTNO);
		createProposal.setPaymentOption(DEFAULT_PAYMENTOPTION);
		createProposal.setPolicyId(DEFAULT_POLICYID);
		createProposal.setPolicyTerm(DEFAULT_POLICYTERM);
		createProposal.setProductId(DEFAULT_PRODUCTID);
		createProposal.setQuestionList(DEFAULT_QUESTIONLIST);
		createProposal.setBeneficiaryList(DEFAULT_BENEFICIARYLIST);
		createProposal.setCommunicationDetails(DEFAULT_COMMUNICATIONDETAILS);
		createProposal.setPolicyStatusId(DEFAULT_POLICYSTATUSID);
		createProposal.setPolicyStartDate(DEFAULT_POLICYSTARTDATE);
		createProposal.setMasterpolicyno(DEFAULT_MASTERPOLICYNO);
		createProposal.setPlanId(DEFAULT_PLANID);
		createProposal.setPolicyEndDate(DEFAULT_POLICYENDDATE);
		createProposal.setBranchId(DEFAULT_BRANCHID);
		return createProposal;
	}

	@Test
	public void testSaveQuoteUsingPOST() throws Exception {
		Mockito.when(policyService.saveQuoteUsingPOST(Mockito.any(PolicyCreationRequestWrapper.class),
				Mockito.any(ServiceContext.class))).thenReturn(defaultCreateProposal());
		java.lang.String requestBody = mapper.writeValueAsString(defaultPolicyCreationRequestWrapper());
		mockMvc.perform(MockMvcRequestBuilders.post("/api/policy/quote").content(requestBody)
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()))
				.andDo(MockMvcResultHandlers.print());
	}

	private ModelAndView defaultModelAndView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setReference(DEFAULT_REFERENCE);
		modelAndView.setModel(DEFAULT_MODEL);
	//	modelAndView.setStatus(DEFAULT_STATUS);
		modelAndView.setEmpty(DEFAULT_EMPTY);
		modelAndView.setModelMap(DEFAULT_MODELMAP);
		modelAndView.setView(DEFAULT_VIEW);
		modelAndView.setViewName(DEFAULT_VIEWNAME);
		return modelAndView;
	}

	@Test
	public void testErrorHtmlUsingGET() throws Exception {
		Mockito.when(policyService.errorHtmlUsingGET(Mockito.any(ServiceContext.class)))
				.thenReturn(defaultModelAndView());
		mockMvc.perform(MockMvcRequestBuilders.get("/error").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
				.andDo(MockMvcResultHandlers.print());
	}

	private java.lang.String defaultString() {
		java.lang.String string = new java.lang.String();
		return string;
	}

	@Test
	public void testErrorHtmlUsingPOST() throws Exception {
		Mockito.when(policyService.errorHtmlUsingPOST(Mockito.any(java.lang.String.class),
				Mockito.any(ServiceContext.class))).thenReturn(defaultModelAndView());
		java.lang.String requestBody = mapper.writeValueAsString(defaultString());
		mockMvc.perform(MockMvcRequestBuilders.post("/error").content(requestBody).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()))
				.andDo(MockMvcResultHandlers.print());
	}

	private ModelAndView updatedModelAndView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setReference(UPDATED_REFERENCE);
		modelAndView.setModel(UPDATED_MODEL);
	//	modelAndView.setStatus(UPDATED_STATUS);
		modelAndView.setEmpty(UPDATED_EMPTY);
		modelAndView.setModelMap(UPDATED_MODELMAP);
		modelAndView.setView(UPDATED_VIEW);
		modelAndView.setViewName(UPDATED_VIEWNAME);
		return modelAndView;
	}

	private java.lang.String updatedString() {
		java.lang.String string = new java.lang.String();
		return string;
	}

	@Test
	public void testErrorHtmlUsingPUT() throws Exception {
		Mockito.when(
				policyService.errorHtmlUsingPUT(Mockito.any(java.lang.String.class), Mockito.any(ServiceContext.class)))
				.thenReturn(updatedModelAndView());
		java.lang.String requestBody = mapper.writeValueAsString(updatedString());
		mockMvc.perform(MockMvcRequestBuilders.put("/error").content(requestBody).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testErrorHtmlUsingDELETE() throws Exception {
		Mockito.when(policyService.errorHtmlUsingDELETE(Mockito.any(ServiceContext.class)))
				.thenReturn(DEFAULT_DELETE_RETURN);
		mockMvc.perform(MockMvcRequestBuilders.delete("/error").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.NO_CONTENT.value()))
				.andDo(MockMvcResultHandlers.print());
	}

}
