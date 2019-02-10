package demo.cosmos.core.policy.dao.entity;
// Generated Nov 14, 2018 7:02:50 PM by Hibernate Tools 5.2.10.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Nominee generated by hbm2java
 */
@Entity
@Table(name="nominee"
    ,catalog="test"
)
public class Nominee  implements java.io.Serializable {


     private Integer nomineeid;
     private String type;
     private Set<BeneficiaryInfo> beneficiaryInfos = new HashSet<BeneficiaryInfo>(0);

    public Nominee() {
    }

    public Nominee(String type, Set<BeneficiaryInfo> beneficiaryInfos) {
       this.type = type;
       this.beneficiaryInfos = beneficiaryInfos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="nomineeid", unique=true, nullable=false)
    public Integer getNomineeid() {
        return this.nomineeid;
    }
    
    public void setNomineeid(Integer nomineeid) {
        this.nomineeid = nomineeid;
    }

    
    @Column(name="type", length=20)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="nominee")
    public Set<BeneficiaryInfo> getBeneficiaryInfos() {
        return this.beneficiaryInfos;
    }
    
    public void setBeneficiaryInfos(Set<BeneficiaryInfo> beneficiaryInfos) {
        this.beneficiaryInfos = beneficiaryInfos;
    }




}


