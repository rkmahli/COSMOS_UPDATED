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
 * BeneficiaryInfo generated by hbm2java
 */
@Entity
@Table(name="beneficiary_info"
    ,catalog="test"
)
public class BeneficiaryInfo  implements java.io.Serializable {


     private BeneficiaryInfoId id;
     private Nominee nominee;
     private Policydetails policydetails;
     private Relationship relationshipByRelationNominee;
     private Relationship relationshipByRelationProposer;

    public BeneficiaryInfo() {
    }

	
    public BeneficiaryInfo(BeneficiaryInfoId id) {
        this.id = id;
    }
    public BeneficiaryInfo(BeneficiaryInfoId id, Nominee nominee, Policydetails policydetails, Relationship relationshipByRelationNominee, Relationship relationshipByRelationProposer) {
       this.id = id;
       this.nominee = nominee;
       this.policydetails = policydetails;
       this.relationshipByRelationNominee = relationshipByRelationNominee;
       this.relationshipByRelationProposer = relationshipByRelationProposer;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="policyid", column=@Column(name="Policyid") ), 
        @AttributeOverride(name="name", column=@Column(name="Name", length=100) ), 
        @AttributeOverride(name="dob", column=@Column(name="Dob", length=10) ), 
        @AttributeOverride(name="gender", column=@Column(name="Gender", length=2) ), 
        @AttributeOverride(name="relationProposer", column=@Column(name="Relation_proposer") ), 
        @AttributeOverride(name="nomineename", column=@Column(name="nomineename", length=100) ), 
        @AttributeOverride(name="relationNominee", column=@Column(name="Relation_nominee") ), 
        @AttributeOverride(name="nomineeType", column=@Column(name="Nominee_type") ) } )
    public BeneficiaryInfoId getId() {
        return this.id;
    }
    
    public void setId(BeneficiaryInfoId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Nominee_type", insertable=false, updatable=false)
    public Nominee getNominee() {
        return this.nominee;
    }
    
    public void setNominee(Nominee nominee) {
        this.nominee = nominee;
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
    @JoinColumn(name="Relation_nominee", insertable=false, updatable=false)
    public Relationship getRelationshipByRelationNominee() {
        return this.relationshipByRelationNominee;
    }
    
    public void setRelationshipByRelationNominee(Relationship relationshipByRelationNominee) {
        this.relationshipByRelationNominee = relationshipByRelationNominee;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Relation_proposer", insertable=false, updatable=false)
    public Relationship getRelationshipByRelationProposer() {
        return this.relationshipByRelationProposer;
    }
    
    public void setRelationshipByRelationProposer(Relationship relationshipByRelationProposer) {
        this.relationshipByRelationProposer = relationshipByRelationProposer;
    }




}


