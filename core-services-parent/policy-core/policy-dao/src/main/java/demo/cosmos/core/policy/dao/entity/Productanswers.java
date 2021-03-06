package demo.cosmos.core.policy.dao.entity;
// Generated Nov 14, 2018 7:02:50 PM by Hibernate Tools 5.2.10.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Productanswers generated by hbm2java
 */
@Entity
@Table(name="productanswers"
    ,catalog="test"
)
public class Productanswers  implements java.io.Serializable {


     private ProductanswersId id;
     private Policydetails policydetails;
     private Productquestions productquestions;

    public Productanswers() {
    }

	
    public Productanswers(ProductanswersId id) {
        this.id = id;
    }
    public Productanswers(ProductanswersId id, Policydetails policydetails, Productquestions productquestions) {
       this.id = id;
       this.policydetails = policydetails;
       this.productquestions = productquestions;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="policyid", column=@Column(name="Policyid") ), 
        @AttributeOverride(name="questionid", column=@Column(name="Questionid") ), 
        @AttributeOverride(name="ans", column=@Column(name="Ans") ) } )
    public ProductanswersId getId() {
        return this.id;
    }
    
    public void setId(ProductanswersId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Policyid", insertable=false, updatable=false)
    public Policydetails getPolicydetails() {
        return this.policydetails;
    }
    
    public void setPolicydetails(Policydetails policydetails) {
        this.policydetails = policydetails;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Questionid", insertable=false, updatable=false)
    public Productquestions getProductquestions() {
        return this.productquestions;
    }
    
    public void setProductquestions(Productquestions productquestions) {
        this.productquestions = productquestions;
    }




}


