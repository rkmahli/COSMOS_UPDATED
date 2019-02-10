
package demo.cosmos.core.policy.service.mapper;

import com.cognizant.cosmos.core.utils.mapper.BaseMapper;
import demo.cosmos.core.policy.dao.entity.ProductquestionChoice;
import demo.cosmos.core.policy.model.QuestionResource;
import org.springframework.stereotype.Component;

@Component
public class QuestionResourceToProductquestionChoiceMapper
    extends BaseMapper<QuestionResource, ProductquestionChoice>
{


}
