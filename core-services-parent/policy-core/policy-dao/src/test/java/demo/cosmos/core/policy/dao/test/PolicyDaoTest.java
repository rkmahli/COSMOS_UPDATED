
package demo.cosmos.core.policy.dao.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

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
import demo.cosmos.core.policy.dao.repository.PlanbreakupRepository;
import demo.cosmos.core.policy.dao.repository.PolicydetailsRepository;
import demo.cosmos.core.policy.dao.repository.ProductRepository;
import demo.cosmos.core.policy.dao.repository.ProductquestionChoiceRepository;
import demo.cosmos.core.policy.dao.test.config.TestConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class PolicyDaoTest {

    @Autowired
    private PolicyDao policyDao;
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
    @MockBean
    private ProductRepository productRepository;
    private final static PlanbreakupId DEFAULT_ID = null;
    private final static Agerange DEFAULT_AGERANGE = null;
    private final static Plantype DEFAULT_PLANTYPE = null;
    @MockBean
    private PlanbreakupRepository planbreakupRepository;
    private final static ProductquestionChoiceId DEFAULT_ID_1 = null;
    private final static Choices DEFAULT_CHOICES = null;
    private final static Productquestions DEFAULT_PRODUCTQUESTIONS = null;
    @MockBean
    private ProductquestionChoiceRepository productquestionChoiceRepository;
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
    @MockBean
    private PolicydetailsRepository policydetailsRepository;

    @Test
    public void testGetProductsUsingGET() {
	demo.cosmos.core.policy.dao.entity.Product result = defaultProduct();
	Mockito.doReturn(result).when(productRepository).findOne(Mockito.eq(id));
	Map<String, Object> headers = new HashMap<String, Object>();
	Assert.assertEquals(result, policyDao.getProductsUsingGET(id, headers));
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
	Map<String, Object> headers = new HashMap<String, Object>();
	Mockito.doReturn(result).when(planbreakupRepository).findAll();
	Assert.assertEquals(result.size(), policyDao.getPlansUsingGET(headers).size());
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
	Map<String, Object> headers = new HashMap<String, Object>();
	Mockito.doReturn(result).when(productquestionChoiceRepository).findAll();
	Assert.assertEquals(result.size(), policyDao.getQuestionsUsingGET(headers).size());
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
	Policydetails policydetails = defaultPolicydetails();
	Map<String, Object> headers = new HashMap<String, Object>();
	Mockito.doReturn(policydetails).when(policydetailsRepository).save(Mockito.any(Policydetails.class));
	Assert.assertNotNull(policyDao.saveQuoteUsingPOST(policydetails, headers));
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

}
