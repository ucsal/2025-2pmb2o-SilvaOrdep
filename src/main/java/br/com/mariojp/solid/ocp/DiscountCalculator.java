package br.com.mariojp.solid.ocp;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {
	private final Map<CustomerType, DiscountPolicy> policyMap;
	
	public DiscountCalculator(Map<CustomerType, DiscountPolicy> policyMap) {
		this.policyMap = policyMap;
	}
	
	public DiscountCalculator() {
		policyMap = new HashMap<>();
		// tendo em vista que o usuário não forneceu um map com as políticas, um map padrão seria:
		policyMap.put(CustomerType.REGULAR, new RegularPolicy());
		policyMap.put(CustomerType.PREMIUM, new PremiumPolicy());
		policyMap.put(CustomerType.PARTNER, new PartnerPolicy());
	}
	
    public double apply(double amount, CustomerType type){
        return policyMap.get(type) != null ? policyMap.get(type).apply(amount) : amount;
    }

}
