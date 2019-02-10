
package demo.cosmos.core.policy.service.mapper;

import com.cognizant.cosmos.core.utils.mapper.BaseMapper;
import demo.cosmos.core.policy.dao.entity.Policydetails;
import demo.cosmos.core.policy.model.PolicyCreationRequestWrapper;
import org.springframework.stereotype.Component;

@Component
public class PolicyCreationRequestWrapperToPolicydetailsMapper
    extends BaseMapper<PolicyCreationRequestWrapper, Policydetails>
{


}
