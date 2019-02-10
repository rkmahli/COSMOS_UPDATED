package demo.cosmos.core.policy.dao.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import demo.cosmos.core.policy.dao.entity.Policystatus;

public interface PolicystatusRepository extends JpaRepository<Policystatus, Serializable>, JpaSpecificationExecutor<Policystatus>
{

}
