package com.nit.enums;

public enum STATE {
	
   ACTIVE("Active"),NOTACTIVE("Not Active"),UPCOMING("Upcoming"),FINISHED("Finished");
   String value;
   STATE(String value)
   { 
	   this.value=value;
   }
    
  public String getValue()
   {
	  return value; 
   }
   
}
