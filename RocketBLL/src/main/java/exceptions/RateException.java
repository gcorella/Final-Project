package exceptions;
import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
	
	
	private RateDomainModel rdm;
	public RateException(RateDomainModel rdm){
		rdm = this.rdm;
	}
	public RateDomainModel getRdm() {
		return rdm;
	}
	// Un-needed********************************
	// public void setRdm(RateDomainModel rdm) {
	//	this.rdm = rdm;}

}
