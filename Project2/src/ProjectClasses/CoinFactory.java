package ProjectClasses;

public class CoinFactory {
	public Coin getCoin(String coinType) {
		if(coinType == null){
	         return null;
	    }		
	    if(coinType.equalsIgnoreCase("NICKEL")){
	         return new Nickel();
	         
	    } else if(coinType.equalsIgnoreCase("DIME")){
	         return new Dime();
	         
	    } else if(coinType.equalsIgnoreCase("QUARTER")){
	         return new Quarter();
	         
	    } else if(coinType.equalsIgnoreCase("Dollar")){
		     return new Dollar();
		     
	    }
		      
	      
	      return null;
	}
}
