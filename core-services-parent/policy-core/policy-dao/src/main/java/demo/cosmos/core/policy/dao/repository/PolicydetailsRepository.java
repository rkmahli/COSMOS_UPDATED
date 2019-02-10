package demo.cosmos.core.policy.dao.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import demo.cosmos.core.policy.dao.entity.Policydetails;

public interface PolicydetailsRepository extends JpaRepository<Policydetails, Serializable>, JpaSpecificationExecutor<Policydetails>
{

}
