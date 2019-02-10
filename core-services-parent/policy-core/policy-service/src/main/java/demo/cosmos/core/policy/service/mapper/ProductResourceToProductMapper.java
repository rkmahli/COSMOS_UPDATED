
package demo.cosmos.core.policy.service.mapper;

import com.cognizant.cosmos.core.utils.mapper.BaseMapper;
import demo.cosmos.core.policy.dao.entity.Product;
import demo.cosmos.core.policy.model.ProductResource;
import org.springframework.stereotype.Component;

@Component
public class ProductResourceToProductMapper
    extends BaseMapper<ProductResource, Product>
{


}
