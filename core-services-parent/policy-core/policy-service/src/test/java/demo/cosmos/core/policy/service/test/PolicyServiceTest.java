
package demo.cosmos.core.policy.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.cosmos.core.utils.execution.ServiceContext;

import demo.cosmos.core.policy.dao.PolicyDao;
import demo.cosmos.core.policy.dao.entity.Agerange;
import demo.cosmos.core.policy.dao.entity.Choices;
import demo.cosmos.core.policy.dao.entity.Customers;
import demo.cosmos.core.policy.dao.entity.Planbreakup;
import demo.cosmos.core.policy.dao.entity.PlanbreakupId;
import demo.cosmos.core.policy.dao.entity.Plantype;
import demo.cosmos.core.policy.dao.entity.Policydetails;
import demo.cosmos.core.policy.dao.entity.Policystatus;
import demo.cosmos.core.policy.dao.entity.ProductquestionChoice;
import demo.cosmos.core.policy.dao.entity.ProductquestionChoiceId;
import demo.cosmos.core.policy.dao.entity.Productquestions;
import demo.cosmos.core.policy.model.CreateProposal;
import demo.cosmos.core.policy.model.PolicyCreationRequestWrapper;
import demo.cosmos.core.policy.service.PolicyService;
import demo.cosmos.core.policy.service.test.config.TestConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class PolicyServiceTest {

    @MockBean
    private PolicyDao policyDao;
    @Autowired
    private PolicyService policyService;
    private final static Set DEFAULT_POLICYDETAILSES = null;
    private final static String DEFAULT_SHORTPRODUCTNAME = "DEFAULT_SHORTPRODUCTNAME";
    private final static Date DEFAULT_LASTUPDATEDDATE = null;
    private final static Integer DEFAULT_RISKSTARTDATERANGE = 301;
    private final static Boolean DEFAULT_BACKDATEDINCEPTION = true;
    private final static Integer DEFAULT_BACKDATEDINCEPTIONRANGE = 301;
    private final static String DEFAULT_POLICYNUMBERINGFORMAT = "DEFAULT_POLICYNUMBERINGFORMAT";
    private final static Set DEFAULT_PRODUCTQUESTIONSES = null;
    private final static Integer DEFAULT_PRODUCTID = 301;
    private final static String DEFAULT_PRODUCTNAME = "DEFAULT_PRODUCTNAME";
    private final static Integer DEFAULT_LOBID = 301;
    private final static Date DEFAULT_STARTDATE = null;
    private final static Date DEFAULT_ENDDATE = null;
    private final static Date DEFAULT_EFFECTIVEDATE = null;
    private final static Set DEFAULT_PLANTYPES = null;
    private String id = "id";
    private final static PlanbreakupId DEFAULT_ID = null;
    private final static Agerange DEFAULT_AGERANGE = null;
    private final static Plantype DEFAULT_PLANTYPE = null;
    private final static ProductquestionChoiceId DEFAULT_ID_1 = null;
    private final static Choices DEFAULT_CHOICES = null;
    private final static Productquestions DEFAULT_PRODUCTQUESTIONS = null;
    private final static CreateProposal DEFAULT_POLICYDETAILS = null;
    private final static demo.cosmos.core.policy.dao.entity.Product DEFAULT_PRODUCT = null;
    private final static Set DEFAULT_BENEFICIARYINFOS = null;
    private final static Date DEFAULT_POLICYSTARTDATE = null;
    private final static Integer DEFAULT_MASTERPOLICYNO = 301;
    private final static Set DEFAULT_PRODUCTANSWERSES = null;
    private final static Integer DEFAULT_POLICYID = 301;
    private final static Customers DEFAULT_CUSTOMERS = null;
    private final static Policystatus DEFAULT_POLICYSTATUS = null;
    private final static int DEFAULT_PLANID = 301;
    private final static Date DEFAULT_POLICYENDDATE = null;
    private final static int DEFAULT_AFFINITYID = 301;
    private final static int DEFAULT_BRANCHID = 301;
    private final static String DEFAULT_CERTIFICATENO = "DEFAULT_CERTIFICATENO";
    private final static int DEFAULT_LASTUPDATEDBY = 301;
    private final static String DEFAULT_EMPLOYEECODE = "DEFAULT_EMPLOYEECODE";
    private final static int DEFAULT_POLICYTERM = 301;
    private final static Integer DEFAULT_COVERNOTENO = 301;

    @Test
    public void testGetProductsUsingGET() {
	ServiceContext context = new ServiceContext();
	demo.cosmos.core.policy.dao.entity.Product product = defaultProduct();
	Mockito.when(policyDao.getProductsUsingGET(Mockito.eq(id), Mockito.anyMapOf(String.class, Object.class))).thenReturn(product);
	Assert.assertNotNull(policyService.getProductsUsingGET(id, context));
    }

    private demo.cosmos.core.policy.dao.entity.Product defaultProduct() {
	demo.cosmos.core.policy.dao.entity.Product product = new demo.cosmos.core.policy.dao.entity.Product();
	product.setPolicydetailses(DEFAULT_POLICYDETAILSES);
	product.setShortProductname(DEFAULT_SHORTPRODUCTNAME);
	product.setLastupdateddate(DEFAULT_LASTUPDATEDDATE);
	product.setRiskstartdaterange(DEFAULT_RISKSTARTDATERANGE);
	product.setBackdatedinception(DEFAULT_BACKDATEDINCEPTION);
	product.setBackdatedinceptionrange(DEFAULT_BACKDATEDINCEPTIONRANGE);
	product.setPolicynumberingformat(DEFAULT_POLICYNUMBERINGFORMAT);
	product.setProductquestionses(DEFAULT_PRODUCTQUESTIONSES);
	product.setProductid(DEFAULT_PRODUCTID);
	product.setProductname(DEFAULT_PRODUCTNAME);
	product.setLobid(DEFAULT_LOBID);
	product.setStartdate(DEFAULT_STARTDATE);
	product.setEnddate(DEFAULT_ENDDATE);
	product.setEffectivedate(DEFAULT_EFFECTIVEDATE);
	product.setPlantypes(DEFAULT_PLANTYPES);
	return product;
    }

    @Test
    public void testGetPlansUsingGET() {
	List<Planbreakup> result = new ArrayList<Planbreakup>();
	result.add(defaultPlanbreakup());
	Mockito.when(policyDao.getPlansUsingGET(Mockito.anyMapOf(String.class, Object.class))).thenReturn(result);
	ServiceContext context = new ServiceContext();
	Assert.assertEquals(result.size(), policyService.getPlansUsingGET(context).size());
    }

    private Planbreakup defaultPlanbreakup() {
	Planbreakup planbreakup = new Planbreakup();
	planbreakup.setId(DEFAULT_ID);
	planbreakup.setAgerange(DEFAULT_AGERANGE);
	planbreakup.setPlantype(DEFAULT_PLANTYPE);
	return planbreakup;
    }

    @Test
    public void testGetQuestionsUsingGET() {
	List<ProductquestionChoice> result = new ArrayList<ProductquestionChoice>();
	result.add(defaultProductquestionChoice());
	Mockito.when(policyDao.getQuestionsUsingGET(Mockito.anyMapOf(String.class, Object.class))).thenReturn(result);
	ServiceContext context = new ServiceContext();
	Assert.assertEquals(result.size(), policyService.getQuestionsUsingGET(context).size());
    }

    private ProductquestionChoice defaultProductquestionChoice() {
	ProductquestionChoice productquestionChoice = new ProductquestionChoice();
	productquestionChoice.setId(DEFAULT_ID_1);
	productquestionChoice.setChoices(DEFAULT_CHOICES);
	productquestionChoice.setProductquestions(DEFAULT_PRODUCTQUESTIONS);
	return productquestionChoice;
    }

    @Test
    public void testSaveQuoteUsingPOST() {
	PolicyCreationRequestWrapper policyCreationRequestWrapper = defaultPolicyCreationRequestWrapper();
	ServiceContext context = new ServiceContext();
	Policydetails defaultPolicydetails = defaultPolicydetails();
	Mockito.doReturn(defaultPolicydetails).when(policyDao).saveQuoteUsingPOST(Mockito.any(Policydetails.class),
		Mockito.anyMapOf(String.class, Object.class));
	Assert.assertNotNull(policyService.saveQuoteUsingPOST(policyCreationRequestWrapper, context));
    }

    private PolicyCreationRequestWrapper defaultPolicyCreationRequestWrapper() {
	PolicyCreationRequestWrapper policyCreationRequestWrapper = new PolicyCreationRequestWrapper();
	policyCreationRequestWrapper.setPolicyDetails(DEFAULT_POLICYDETAILS);
	return policyCreationRequestWrapper;
    }

    private Policydetails defaultPolicydetails() {
	Policydetails policydetails = new Policydetails();
	policydetails.setProduct(DEFAULT_PRODUCT);
	policydetails.setBeneficiaryInfos(DEFAULT_BENEFICIARYINFOS);
	policydetails.setPolicyStartDate(DEFAULT_POLICYSTARTDATE);
	policydetails.setLastUpdatedDate(DEFAULT_LASTUPDATEDDATE);
	policydetails.setMasterpolicyno(DEFAULT_MASTERPOLICYNO);
	policydetails.setProductanswerses(DEFAULT_PRODUCTANSWERSES);
	policydetails.setPolicyid(DEFAULT_POLICYID);
	policydetails.setCustomers(DEFAULT_CUSTOMERS);
	policydetails.setPolicystatus(DEFAULT_POLICYSTATUS);
	policydetails.setPlanId(DEFAULT_PLANID);
	policydetails.setPolicyEndDate(DEFAULT_POLICYENDDATE);
	policydetails.setAffinityid(DEFAULT_AFFINITYID);
	policydetails.setBranchId(DEFAULT_BRANCHID);
	policydetails.setCertificateno(DEFAULT_CERTIFICATENO);
	policydetails.setLastUpdatedBy(DEFAULT_LASTUPDATEDBY);
	policydetails.setEmployeecode(DEFAULT_EMPLOYEECODE);
	policydetails.setPolicyterm(DEFAULT_POLICYTERM);
	policydetails.setCovernoteno(DEFAULT_COVERNOTENO);
	return policydetails;
    }

    @Test
    public void testErrorHtmlUsingGET() {
	// TODO: your code goes here...
	Assert.assertTrue(true);
    }

    @Test
    public void testErrorHtmlUsingPOST() {
	// TODO: your code goes here...
	Assert.assertTrue(true);
    }

    @Test
    public void testErrorHtmlUsingPUT() {
	// TODO: your code goes here...
	Assert.assertTrue(true);
    }

    @Test
    public void testErrorHtmlUsingDELETE() {
	// TODO: your code goes here...
	Assert.assertTrue(true);
    }

}
