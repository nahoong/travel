package kdata.project.dto;

import java.io.Serializable;

//ProductDTO
public class ProductDTO implements Serializable{

   /**
    * 
    */
   private static final long serialVersionUID = 1840764657179553745L;
/**
    * 
    */

   private String prod_num;
   private String prod_name;
   private String prod_class;
   private int prod_price;
   private String prod_place;
   private String cus_id;
   private String filename;
   public String getFilename() {
   return filename;
}
public void setFilename(String filename) {
   this.filename = filename;
}

   
   public String getProd_name() {
      return prod_name;
   }
   public void setProd_name(String prod_name) {
      this.prod_name = prod_name;
   }
   
   
   public String getProd_num() {
      return prod_num;
   }
   public void setProd_num(String prod_num) {
      this.prod_num = prod_num;
   }
   public String getProd_class() {
      return prod_class;
   }
   public void setProd_class(String prod_class) {
      this.prod_class = prod_class;
   }
 
   public int getProd_price() {
      return prod_price;
   }
   public void setProd_price(int prod_price) {
      this.prod_price = prod_price;
   }
   public String getProd_place() {
      return prod_place;
   }
   public void setProd_place(String prod_place) {
      this.prod_place = prod_place;
   }
   public String getCus_id() {
      return cus_id;
   }
   public void setCus_id(String cus_id) {
      this.cus_id = cus_id;
   }
   
   public ProductDTO() {
      super();
   }
   
   
   
   
   
public ProductDTO(String prod_name, int prod_price, String prod_place, String cus_id, String filename) {
   super();
   this.prod_name = prod_name;
   this.prod_price = prod_price;
   this.prod_place = prod_place;
   this.cus_id = cus_id;
   this.filename = filename;
}

public ProductDTO(String prod_name, int prod_price, String prod_place, String cus_id, String filename, String prod_class) {
	   super();
	   this.prod_name = prod_name;
	   this.prod_price = prod_price;
	   this.prod_place = prod_place;
	   this.cus_id = cus_id;
	   this.filename = filename;
	   this.prod_class = prod_class;
	}

public ProductDTO(String prod_name, int prod_price, String prod_place, String cus_id, String filename, String prod_class, String prod_num) {
	   super();
	   this.prod_name = prod_name;
	   this.prod_price = prod_price;
	   this.prod_place = prod_place;
	   this.cus_id = cus_id;
	   this.filename = filename;
	   this.prod_class = prod_class;
	   this.prod_num = prod_num;
	}

@Override
public String toString() {
   return "ProductDTO [prod_num=" + prod_num + ", prod_name=" + prod_name + ", prod_class=" + prod_class
         + ", prod_price=" + prod_price + ", prod_place=" + prod_place + ", cus_id=" + cus_id + ", filename="
         + filename + "]";
}



   
   
   

   
   
   
   

     
   
   
}