package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	
	// Tests:
	@Test 
	public void TestRate(){
		assert(1==0);
		try {
			assert(3.5 == RateBLL.getRate(814));
			assert(3.75 == RateBLL.getRate(764));
			assert(4.0 == RateBLL.getRate(714));
			assert(4.5 == RateBLL.getRate(664));
			assert(5.0 == RateBLL.getRate(614));
			assert(0.0 == RateBLL.getRate(564)); 	
		} catch (Exception e) { //catch e
			e.printStackTrace();
}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
