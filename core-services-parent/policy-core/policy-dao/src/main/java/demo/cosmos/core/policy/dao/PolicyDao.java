
package demo.cosmos.core.policy.dao;

import java.util.List;
import java.util.Map;

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

public interface PolicyDao {


    Product getProductsUsingGET(String productID, Map<String, ?> headers);

    List<Planbreakup> getPlansUsingGET(Map<String, ?> headers);

    List<ProductquestionChoice> getQuestionsUsingGET(Map<String, ?> headers);

    Policydetails saveQuoteUsingPOST(Policydetails policydetails, Map<String, ?> headers);
    
    Policydetails savePolicydetails(Policydetails policydetails);
    
    void saveNominee(Nominee nominee);
    
    Relationship getRelationshipByRelationid(Integer id);
    
    void saveBeneficiaryInfo(BeneficiaryInfo beneficiaryInfo);
    
    Customers getCustomersById(Integer id);
    
    void saveCustomers(Customers customers);
    
    void saveCustomeraddress(Customeraddress customeraddress);
    
    List<Productquestions> getProductQuestions();
        
    Productquestions getProductQuestionsById(Integer id);
    
    void saveProductanswers(Productanswers answers);
    
    Policystatus getPolicystatusByPolicystatusId(Integer id);
    
    Product getProductById(Integer id);
    
    Policydetails getPolicydetailsByPolicyid(Integer policyid);

}
