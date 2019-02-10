package demo.cosmos.core.policy.dao.entity;
// Generated Nov 14, 2018 7:02:50 PM by Hibernate Tools 5.2.10.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProductquestionChoiceId generated by hbm2java
 */
@Embeddable
public class ProductquestionChoiceId  implements java.io.Serializable {


     private Integer questionid;
     private Integer choiceid;

    public ProductquestionChoiceId() {
    }

    public ProductquestionChoiceId(Integer questionid, Integer choiceid) {
       this.questionid = questionid;
       this.choiceid = choiceid;
    }
   


    @Column(name="Questionid")
    public Integer getQuestionid() {
        return this.questionid;
    }
    
    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }


    @Column(name="Choiceid")
    public Integer getChoiceid() {
        return this.choiceid;
    }
    
    public void setChoiceid(Integer choiceid) {
        this.choiceid = choiceid;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProductquestionChoiceId) ) return false;
		 ProductquestionChoiceId castOther = ( ProductquestionChoiceId ) other; 
         
		 return ( (this.getQuestionid()==castOther.getQuestionid()) || ( this.getQuestionid()!=null && castOther.getQuestionid()!=null && this.getQuestionid().equals(castOther.getQuestionid()) ) )
 && ( (this.getChoiceid()==castOther.getChoiceid()) || ( this.getChoiceid()!=null && castOther.getChoiceid()!=null && this.getChoiceid().equals(castOther.getChoiceid()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getQuestionid() == null ? 0 : this.getQuestionid().hashCode() );
         result = 37 * result + ( getChoiceid() == null ? 0 : this.getChoiceid().hashCode() );
         return result;
   }   


}


