package com.beeva.drools.model.demodrools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
        	KieServices ks = KieServices.Factory.get();
        	KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rule");
        	
        	Product product = new Product();
        	product.setType("diamond");
        	
        	FactHandle fact1;
        	
        	fact1 = kSession.insert(product);
        	kSession.fireAllRules();
        	
        	System.out.println("The discount for the jewellery product "+product.getType()+" is "+product.getDiscount());
        }catch(Exception t){
        	t.printStackTrace();
        }
    }
}
