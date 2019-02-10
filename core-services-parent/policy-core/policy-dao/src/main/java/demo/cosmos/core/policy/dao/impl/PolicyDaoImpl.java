
package demo.cosmos.core.policy.dao.impl;

import java.util.List;
import java.util.Map;
import demo.cosmos.core.policy.dao.PolicyDao;
import demo.cosmos.core.policy.dao.entity.BeneficiaryInfo;
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
import demo.cosmos.core.policy.dao.entity.Relationship;
import demo.cosmos.core.policy.dao.repository.BeneficiaryInfoRepository;
import demo.cosmos.core.policy.dao.repository.CustomeraddressRepository;
import demo.cosmos.core.policy.dao.repository.CustomersRepository;
import demo.cosmos.core.policy.dao.repository.NomineeRepository;
import demo.cosmos.core.policy.dao.repository.PlanbreakupRepository;
import demo.cosmos.core.policy.dao.repository.PolicydetailsRepository;
import demo.cosmos.core.policy.dao.repository.PolicystatusRepository;
import demo.cosmos.core.policy.dao.repository.ProductRepository;
import demo.cosmos.core.policy.dao.repository.ProductanswersRepository;
import demo.cosmos.core.policy.dao.repository.ProductquestionChoiceRepository;
import demo.cosmos.core.policy.dao.repository.ProductquestionsRepository;
import demo.cosmos.core.policy.dao.repository.RelationshipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PolicyDaoImpl implements PolicyDao {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private PlanbreakupRepository planbreakupRepository;
	@Autowired
	private ProductquestionChoiceRepository productquestionChoiceRepository;
	@Autowired
	private PolicydetailsRepository policydetailsRepository;
	@Autowired
	private NomineeRepository nomineeRepository;
	@Autowired
	private RelationshipRepository relationshipRepository;
	@Autowired
	private BeneficiaryInfoRepository beneficiaryInfoRepository;
	@Autowired
	private CustomersRepository customersRepository;
	@Autowired
	private CustomeraddressRepository customeraddressRepository;
	@Autowired
	private ProductquestionsRepository productquestionsRepository;
	@Autowired
	private ProductanswersRepository productanswersRepository;
	@Autowired
	private PolicystatusRepository policystatusRepository;

	public Product getProductsUsingGET(String productID, Map<String, ?> headers) {
		return productRepository.findOne(Integer.parseInt(productID));
	}

	public List<Planbreakup> getPlansUsingGET(Map<String, ?> headers) {
		return planbreakupRepository.findAll();
	}

	public List<ProductquestionChoice> getQuestionsUsingGET(Map<String, ?> headers) {
		return productquestionChoiceRepository.findAll();
	}

	public Policydetails saveQuoteUsingPOST(Policydetails policydetails, Map<String, ?> headers) {
		policydetails = policydetailsRepository.save(policydetails);
		// TODO: your code goes here..
		return policydetails;
	}

	public Policydetails savePolicydetails(Policydetails policydetails) {
		return policydetailsRepository.save(policydetails);
	}

	public void saveNominee(Nominee nominee) {
		nomineeRepository.save(nominee);
	}

	public Relationship getRelationshipByRelationid(Integer id) {
		return relationshipRepository.findOne(id);
	}

	public void saveBeneficiaryInfo(BeneficiaryInfo beneficiaryInfo) {
		beneficiaryInfoRepository.save(beneficiaryInfo);
	}

	public Customers getCustomersById(Integer id) {
		return customersRepository.findOne(id);
	}

	public void saveCustomers(Customers customers) {
		customersRepository.save(customers);
	}

	public void saveCustomeraddress(Customeraddress customeraddress) {
		customeraddressRepository.save(customeraddress);
	}
	
	public List<Productquestions> getProductQuestions(){
		return productquestionsRepository.findAll();
	}
	
	public Productquestions getProductQuestionsById(Integer id){
		return productquestionsRepository.findOne(id);
	}
	
	public void saveProductanswers(Productanswers answers){
		productanswersRepository.save(answers);
	}
	
	public Policystatus getPolicystatusByPolicystatusId(Integer id){
		return policystatusRepository.findOne(id);
	}
	
	public Product getProductById(Integer id){
		return productRepository.findOne(id);
	}
	
	public Policydetails getPolicydetailsByPolicyid(Integer policyid){
		return policydetailsRepository.findOne(policyid);
	}
}