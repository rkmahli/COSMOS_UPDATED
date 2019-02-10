
package demo.cosmos.core.policy.service;

import java.util.List;
import com.cognizant.cosmos.core.utils.execution.ServiceContext;

import demo.cosmos.core.policy.dao.entity.Product;
import demo.cosmos.core.policy.model.CreateProposal;
import demo.cosmos.core.policy.model.ModelAndView;
import demo.cosmos.core.policy.model.PlansResource;
import demo.cosmos.core.policy.model.PolicyCreationRequestWrapper;
import demo.cosmos.core.policy.model.ProductResource;
import demo.cosmos.core.policy.model.QuestionResource;

public interface PolicyService {


    ProductResource getProductsUsingGET(String productID, ServiceContext context);

    List<PlansResource> getPlansUsingGET(ServiceContext context);

    List<QuestionResource> getQuestionsUsingGET(ServiceContext context);

    CreateProposal saveQuoteUsingPOST(PolicyCreationRequestWrapper policyCreationRequestWrapper, ServiceContext context);

    ModelAndView errorHtmlUsingGET(ServiceContext context);

    ModelAndView errorHtmlUsingPOST(String string, ServiceContext context);

    ModelAndView errorHtmlUsingPUT(String string, ServiceContext context);

    int errorHtmlUsingDELETE(ServiceContext context);
    

}
