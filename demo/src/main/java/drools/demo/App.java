package drools.demo;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import drools.demo.model.Product;

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
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	Product product = new Product();
        	product.setType("silver");

			FactHandle fact1;
        	       	
        	fact1 = kSession.insert(product);
        	kSession.fireAllRules();
        	
        	System.out.println("The discount for the jewellery product "+product.getType()+" is "+product.getDiscount());
        }catch(Exception t){
        	t.printStackTrace();
        }
    }
}
