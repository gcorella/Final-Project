package rocketBase;

import java.util.ArrayList;
import org.apache.poi.ss.formula.functions.*;
import org.hibernate.HibernateException;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static ArrayList<RateDomainModel> Rates = null;
	public static int MinimumCreditScore;
	public static final double LoanIncome = 0.25;
	public static final double LoanExpenses = 0.36;

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		if (Rates == null) {
			try {
				Rates = RateDAL.getAllRates();
				MinimumCreditScore = 900;
				for (int i = 0; i < Rates.size(); i++) {
					int cr = Rates.get(i).getiMinCreditScore();
					if (cr < MinimumCreditScore) {
						MinimumCreditScore = cr;
					}
				}
			} catch (HibernateException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			}
		}
		// The logic below relies on Rates being sorted by decreasing credit score
		RateDomainModel rdm = null;
		double rate = -1.0;
		for (int i = 0; i < Rates.size(); i++) {
			rdm = Rates.get(i);
			if (rdm.getiMinCreditScore() <= GivenCreditScore) {
				rate = rdm.getdInterestRate();
				break;
			}
		}
		if (rate < 0.0) {
			throw new RateException(rdm);
		} else {
			return rate / 100.0;
		}
	}
		
	public static double maximumPayment(double income, double expenses) {
		if (expenses >= income * LoanExpenses) {
			return 0.0;
		} else {
			return Math.min(income * LoanIncome, income * LoanExpenses - expenses);
		}
	}

		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		
		
		//TODO - RocketBLL RateBLL.getRate
		//			obviously this should be changed to return the determined rate


		//TODO: Filter the ArrayList...  look for the correct rate for the given credit score.
		//	Easiest way is to apply a filter using a Lambda function.
		//
		//	Example... how to use Lambda functions:
		//			https://github.com/CISC181/Lambda

		//TODO - RocketBLL RateBLL.getPayment 
		//		how to use:
		//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	
	public static double getPayment(double r, double n, double p, double f, boolean t) {		
		return Math.abs(FinanceLib.pmt(r, n, p, f, t));
		}
	}
