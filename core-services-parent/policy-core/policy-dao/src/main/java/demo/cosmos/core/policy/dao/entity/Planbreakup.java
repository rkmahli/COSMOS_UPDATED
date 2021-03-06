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
 * Planbreakup generated by hbm2java
 */
@Entity
@Table(name="planbreakup"
    ,catalog="test"
)
public class Planbreakup  implements java.io.Serializable {


     private PlanbreakupId id;
     private Agerange agerange;
     private Plantype plantype;

    public Planbreakup() {
    }

    public Planbreakup(PlanbreakupId id, Agerange agerange, Plantype plantype) {
       this.id = id;
       this.agerange = agerange;
       this.plantype = plantype;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="planid", column=@Column(name="Planid", nullable=false) ), 
        @AttributeOverride(name="si", column=@Column(name="SI", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="agerange", column=@Column(name="Agerange", nullable=false) ), 
        @AttributeOverride(name="premium", column=@Column(name="Premium", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="cgst", column=@Column(name="CGST", precision=10, scale=0) ), 
        @AttributeOverride(name="sgst", column=@Column(name="SGST", precision=10, scale=0) ), 
        @AttributeOverride(name="igst", column=@Column(name="IGST", precision=10, scale=0) ), 
        @AttributeOverride(name="gp", column=@Column(name="GP", nullable=false, precision=10, scale=0) ) } )
    public PlanbreakupId getId() {
        return this.id;
    }
    
    public void setId(PlanbreakupId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Agerange", nullable=false, insertable=false, updatable=false)
    public Agerange getAgerange() {
        return this.agerange;
    }
    
    public void setAgerange(Agerange agerange) {
        this.agerange = agerange;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Planid", nullable=false, insertable=false, updatable=false)
    public Plantype getPlantype() {
        return this.plantype;
    }
    
    public void setPlantype(Plantype plantype) {
        this.plantype = plantype;
    }




}


