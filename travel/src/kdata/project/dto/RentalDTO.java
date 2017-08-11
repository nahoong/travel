package kdata.project.dto;

import java.io.Serializable;

public class RentalDTO implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = -5474759773345838102L;
   
   private int rent_num;
   private String cus_id;
   private String rent_context;
   private String rent_startday;
   private String rent_endday;
   
   public int getRent_num() {
      return rent_num;
   }
   public void setRent_num(int rent_num) {
      this.rent_num = rent_num;
   }
   public String getCus_id() {
      return cus_id;
   }
   public void setCus_id(String cus_id) {
      this.cus_id = cus_id;
   }
   public String getRent_context() {
      return rent_context;
   }
   public void setRent_context(String rent_context) {
      this.rent_context = rent_context;
   }
   public String getRent_startday() {
      return rent_startday;
   }
   public void setRent_startday(String rent_startday) {
      this.rent_startday = rent_startday;
   }
   public String getRent_endday() {
      return rent_endday;
   }
   public void setRent_endday(String rent_endday) {
      this.rent_endday = rent_endday;
   }
   public RentalDTO(int rent_num,  String cus_id,String rent_startday, String rent_endday, String rent_context) {
      super();
      this.rent_num = rent_num;
      this.cus_id = cus_id;
      this.rent_context = rent_context;
      this.rent_startday = rent_startday;
      this.rent_endday = rent_endday;
   }
   public RentalDTO() {
      super();
   }
   
   public RentalDTO(String cus_id, String rent_context, String rent_startday, String rent_endday) {
   super();
   this.cus_id = cus_id;
   this.rent_context = rent_context;
   this.rent_startday = rent_startday;
   this.rent_endday = rent_endday;
}
@Override
   public String toString() {
      return "RentalDTO [rent_startday=" + rent_startday + ", rent_endday=" + rent_endday + ", rent_context="
            + rent_context + ", cus_id=" + cus_id + ", rent_num=" + rent_num + "]";
   }


   
   

}