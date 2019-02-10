
package demo.cosmos.core.policy.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.cognizant.cosmos.core.utils.execution.ServiceContext;
import demo.cosmos.core.policy.dao.PolicyDao;
import demo.cosmos.core.policy.dao.entity.BeneficiaryInfo;
import demo.cosmos.core.policy.dao.entity.BeneficiaryInfoId;
import demo.cosmos.core.policy.dao.entity.Customeraddress;
import demo.cosmos.core.policy.dao.entity.Customers;
import demo.cosmos.core.policy.dao.entity.Nominee;
import demo.cosmos.core.policy.dao.entity.Planbreakup;
import demo.cosmos.core.policy.dao.entity.Policydetails;
import demo.cosmos.core.policy.dao.entity.Policystatus;
import demo.cosmos.core.policy.dao.entity.Product;
import demo.cosmos.core.policy.dao.entity.Productanswers;
import demo.cosmos.core.policy.dao.entity.ProductanswersId;
import demo.cosmos.core.policy.dao.entity.ProductquestionChoice;
import demo.cosmos.core.policy.dao.entity.Productquestions;
import demo.cosmos.core.policy.dao.repository.BeneficiaryInfoRepository;
import demo.cosmos.core.policy.model.CreateProposal;
import demo.cosmos.core.policy.model.ModelAndView;
import demo.cosmos.core.policy.model.PlanDetails;
import demo.cosmos.core.policy.model.PlanSumInsuredDetails;
import demo.cosmos.core.policy.model.PlansResource;
import demo.cosmos.core.policy.model.PolicyCreationRequestWrapper;
import demo.cosmos.core.policy.model.PolicyDetails;
import demo.cosmos.core.policy.model.ProductResource;
import demo.cosmos.core.policy.model.ProposalBeneficiaryInfo;
import demo.cosmos.core.policy.model.ProposalCommunicationDetails;
import demo.cosmos.core.policy.model.ProposalQuestionInfo;
import demo.cosmos.core.policy.model.QuestionResource;
import demo.cosmos.core.policy.service.PolicyService;
import demo.cosmos.core.policy.service.mapper.CreateProposalToPolicydetailsMapper;
import demo.cosmos.core.policy.service.mapper.ModelAndViewToStringMapper;
import demo.cosmos.core.policy.service.mapper.PlansResourceToPlanbreakupMapper;
import demo.cosmos.core.policy.service.mapper.PolicyCreationRequestWrapperToPolicydetailsMapper;
import demo.cosmos.core.policy.service.mapper.ProductResourceToProductMapper;
import demo.cosmos.core.policy.service.mapper.QuestionResourceToProductquestionChoiceMapper;
import demo.cosmos.core.policy.service.mapper.StringToStringMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("policyService")
public class PolicyServiceImpl
    implements PolicyService
{

    @Autowired
    private PolicyDao policyDao;
    @Autowired
    private ProductResourceToProductMapper productResourceToProductMapper;
    @Autowired
    private PlansResourceToPlanbreakupMapper plansResourceToPlanbreakupMapper;
    @Autowired
    private QuestionResourceToProductquestionChoiceMapper questionResourceToProductquestionChoiceMapper;
    @Autowired
    private PolicyCreationRequestWrapperToPolicydetailsMapper policyCreationRequestWrapperToPolicydetailsMapper;
    @Autowired
    private CreateProposalToPolicydetailsMapper createProposalToPolicydetailsMapper;
    @Autowired
    private ModelAndViewToStringMapper modelAndViewToStringMapper;
    @Autowired
    private StringToStringMapper stringToStringMapper;


    @Override
    public ProductResource getProductsUsingGET(String productID, ServiceContext context) {
        return productResourceToProductMapper.convertToResource(policyDao.getProductsUsingGET(productID, context.getQueryParams()));
    }

    @Override
    public List<PlansResource> getPlansUsingGET(ServiceContext context) {
        List<PlansResource> plansResourceList = new ArrayList<PlansResource>();
        for (Planbreakup _planbreakup: policyDao.getPlansUsingGET(context.getQueryParams())) {
            //plansResourceList.add(plansResourceToPlanbreakupMapper.convertToResource(_planbreakup));
        	PlansResource plansResource=new PlansResource();
        	plansResource.setLinks(null);
        	ArrayList<PlanDetails> planDetailsList=new ArrayList<>();
        	PlanDetails planDetails= new PlanDetails();
        	planDetails.setAgeRange(_planbreakup.getAgerange().getAgerangeid());
        	planDetails.setGrosspremium(new BigDecimal(_planbreakup.getId().getGp()));
        	planDetails.setPremium(new BigDecimal(_planbreakup.getId().getPremium()));
        	planDetails.setSumInsured((int)_planbreakup.getId().getSi());
        	planDetailsList.add(planDetails);
        	plansResource.setPlanDetails(planDetailsList);
        	plansResource.setPlanid(_planbreakup.getId().getPlanid());
        	plansResource.setPolicytype(_planbreakup.getPlantype().getPolicytype());
        	plansResource.setProductid(_planbreakup.getPlantype().getProduct().getProductid());
        	plansResource.setSumInsuredinLakhs(new ArrayList<PlanSumInsuredDetails>());
        	PlanSumInsuredDetails planSumInsuredDetails = new PlanSumInsuredDetails();
        	planSumInsuredDetails.setSumInsured((int)_planbreakup.getId().getSi());
        	plansResource.getSumInsuredinLakhs().add(planSumInsuredDetails);
        	plansResourceList.add(plansResource);
        }
        return plansResourceList;
    }

    @Override
    public List<QuestionResource> getQuestionsUsingGET(ServiceContext context) {
        List<QuestionResource> questionResourceList = new ArrayList<QuestionResource>();
        for (ProductquestionChoice _productquestionChoice: policyDao.getQuestionsUsingGET(context.getQueryParams())) {
            //questionResourceList.add(questionResourceToProductquestionChoiceMapper.convertToResource(_productquestionChoice));
        	QuestionResource questionResource=new QuestionResource();
        	questionResource.setLinks(null);
        	questionResource.setProductid(_productquestionChoice.getProductquestions().getProduct().getProductid());
        	questionResource.setQuestion(_productquestionChoice.getProductquestions().getQuestion());
        	questionResource.setQuestionid(_productquestionChoice.getProductquestions().getQuestionid());
        	questionResourceList.add(questionResource);
        }
        return questionResourceList;
    }

    @Override
    public CreateProposal saveQuoteUsingPOST(PolicyCreationRequestWrapper policyCreationRequestWrapper, ServiceContext context) {
        
    	CreateProposal createProposal=policyCreationRequestWrapper.getPolicyDetails();
    	PolicyDetails policyDetails=createProposal.getPolicyDetails();
    	
    	Policydetails policydetails=new Policydetails();
    	policydetails.setAffinityid(policyDetails.getAffinityid());
    	policydetails.setBranchId(policyDetails.getBranchId());
    	policydetails.setCovernoteno(policyDetails.getCovernoteno());
    	policydetails.setEmployeecode(policyDetails.getEmployeecode());
    	policydetails.setLastUpdatedBy(policyDetails.getLastUpdatedBy());
    	policydetails.setLastUpdatedDate(policyDetails.getLastUpdatedDate());
    	policydetails.setMasterpolicyno(policyDetails.getMasterpolicyno());
    	policydetails.setPlanId(policyDetails.getPlanId());
    	policydetails.setPolicyEndDate(policyDetails.getPolicyEndDate());
    	policydetails.setPolicyid(policyDetails.getPolicyId());
    	policydetails.setPolicyStartDate(policyDetails.getPolicyStartDate());
    	policydetails.setPolicyterm(policyDetails.getPolicyterm());
    	policydetails.setPolicystatus(policyDao.getPolicystatusByPolicystatusId(1));
    	policydetails.setProduct(policyDao.getProductById(createProposal.getProductId()));
    	policydetails.setCertificateno(null);
    	policydetails=policyDao.savePolicydetails(policydetails);
    	
    	
    	
    	Set<BeneficiaryInfo> beneficiaryInfoSet=new HashSet<>(0);
    	List<ProposalBeneficiaryInfo> pBIList=createProposal.getBeneficiaryList();
    	Iterator<ProposalBeneficiaryInfo> pBILItr=pBIList.iterator();
    	while(pBILItr.hasNext()) {
    		ProposalBeneficiaryInfo temp=pBILItr.next();
    		BeneficiaryInfo beneficiaryInfo=new BeneficiaryInfo();
    		beneficiaryInfo.setPolicydetails(policydetails);
    		BeneficiaryInfoId bIId=new BeneficiaryInfoId();
    		bIId.setDob(temp.getDob());
    		bIId.setGender(temp.getGender());
    		bIId.setName(temp.getName());
    		bIId.setNomineename(temp.getNomineeName());
    		bIId.setNomineeType(temp.getNomineeType());
    		bIId.setPolicyid(policyDetails.getPolicyId());
    		bIId.setRelationNominee(temp.getNomineeRelation());
    		bIId.setRelationProposer(temp.getProposerRelation());
    		beneficiaryInfo.setId(bIId);
    		
    		Nominee nominee=new Nominee();
    		nominee.setBeneficiaryInfos(null);
    		nominee.setType(String.valueOf(temp.getNomineeType()));
    		policyDao.saveNominee(nominee);
    		beneficiaryInfo.setNominee(nominee);
    		
    		beneficiaryInfo.setRelationshipByRelationNominee(policyDao.getRelationshipByRelationid(temp.getNomineeRelation()));
    		beneficiaryInfo.setRelationshipByRelationProposer(policyDao.getRelationshipByRelationid(temp.getProposerRelation()));
    		policyDao.saveBeneficiaryInfo(beneficiaryInfo);
    		beneficiaryInfoSet.add(beneficiaryInfo);
    	}
    	
    	policydetails.setBeneficiaryInfos(beneficiaryInfoSet);
    	Customers customers=policyDao.getCustomersById(createProposal.getCustomerId());
    	policydetails.setCustomers(customers);
    	
    	Customeraddress customeradderss = new Customeraddress();
    	ProposalCommunicationDetails cDetails=createProposal.getCommunicationDetails();
    	customeradderss.setAddress1(cDetails.getAddress1());
    	customeradderss.setAddress2(cDetails.getAddress2());
    	customeradderss.setAddress3(cDetails.getAddress3());
    	customeradderss.setCity(cDetails.getCity());
    	customeradderss.setCustomers(customers);
    	customeradderss.setDistrict(cDetails.getDistrict());
    	customeradderss.setEmailId(cDetails.getEmailId());
    	customeradderss.setMobile(cDetails.getMobile());
    	customeradderss.setPincode(cDetails.getPincode());
    	customeradderss.setPolicyid(policydetails.getPolicyid());
    	customeradderss.setState(cDetails.getState());
    	policyDao.saveCustomeraddress(customeradderss);
    	
    	
    	List<ProposalQuestionInfo> pQIList=createProposal.getQuestionList();
    	Iterator<ProposalQuestionInfo> pQIItr=pQIList.iterator();
    	Set<Productanswers> pansSet=new HashSet<>();
    	while(pQIItr.hasNext()){
    		ProposalQuestionInfo pques=pQIItr.next();
    		Productanswers productanswers=new Productanswers();
        	ProductanswersId pAId=new ProductanswersId();
        	pAId.setAns(pques.isQuestionAns());
        	pAId.setPolicyid(policydetails.getPolicyid());
        	pAId.setQuestionid(pques.getQuestionId());
        	productanswers.setId(pAId);
        	productanswers.setPolicydetails(policydetails);
        	productanswers.setProductquestions(policyDao.getProductQuestionsById(pques.getQuestionId()));
        	pansSet.add(productanswers);
        	policyDao.saveProductanswers(productanswers);
    	}
    	policydetails.setProductanswerses(pansSet);
    	policydetails.setLastUpdatedDate(policyDetails.getLastUpdatedDate());
    	
    	return createProposalToPolicydetailsMapper.convertToResource(policyDao.savePolicydetails(policydetails));
    	//return createProposalToPolicydetailsMapper.convertToResource(policyDao.saveQuoteUsingPOST(policyCreationRequestWrapperToPolicydetailsMapper.convertToEntity(policyCreationRequestWrapper), context.getQueryParams()));
    }

    @Override
    public ModelAndView errorHtmlUsingGET(ServiceContext context) {
    	//TODO : your code goes here
        return null;
    }

    @Override
    public ModelAndView errorHtmlUsingPOST(String string, ServiceContext context) {
    	//TODO : your code goes here
        return null;
    }

    @Override
    public ModelAndView errorHtmlUsingPUT(String string, ServiceContext context) {
    	//TODO : your code goes here
        return null;
    }

    @Override
    public int errorHtmlUsingDELETE(ServiceContext context) {
    	//TODO : your code goes here
        return 1;
    }
    

}
