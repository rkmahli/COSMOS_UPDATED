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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Productquestions generated by hbm2java
 */
@Entity
@Table(name="productquestions"
    ,catalog="test"
)
public class Productquestions  implements java.io.Serializable {


     private Integer questionid;
     private Product product;
     private String question;
     private String choices;
     private Set<Productanswers> productanswerses = new HashSet<Productanswers>(0);
     private Set<ProductquestionChoice> productquestionChoices = new HashSet<ProductquestionChoice>(0);

    public Productquestions() {
    }

    public Productquestions(Product product, String question, String choices, Set<Productanswers> productanswerses, Set<ProductquestionChoice> productquestionChoices) {
       this.product = product;
       this.question = question;
       this.choices = choices;
       this.productanswerses = productanswerses;
       this.productquestionChoices = productquestionChoices;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Questionid", unique=true, nullable=false)
    public Integer getQuestionid() {
        return this.questionid;
    }
    
    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Productid")
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

    
    @Column(name="Question", length=300)
    public String getQuestion() {
        return this.question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }

    
    @Column(name="choices", length=30)
    public String getChoices() {
        return this.choices;
    }
    
    public void setChoices(String choices) {
        this.choices = choices;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="productquestions")
    public Set<Productanswers> getProductanswerses() {
        return this.productanswerses;
    }
    
    public void setProductanswerses(Set<Productanswers> productanswerses) {
        this.productanswerses = productanswerses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="productquestions")
    public Set<ProductquestionChoice> getProductquestionChoices() {
        return this.productquestionChoices;
    }
    
    public void setProductquestionChoices(Set<ProductquestionChoice> productquestionChoices) {
        this.productquestionChoices = productquestionChoices;
    }




}

