package org.cb.practice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(name="TestMartCatalog",portName="TestMartCatalogPort",serviceName="TestMartCatalogService", targetNamespace="http://www.testmart.com")
@SOAPBinding(style=Style.DOCUMENT)
public class ShopInfo {
	
	@WebMethod(action="fetch-categories", operationName="fetchCategories")
	@WebResult(partName="lookupOutput")
	public String getShopInfo(@WebParam(partName="lookupInput") String property) throws InvalidInputException {
		
		String response = null;		 
		
		if("shopname".equals(property)) {
			response = "Testmart";
		}
		else if("since".equals(property)) {
			response = "since 1991";
		}
		else {
			throw new InvalidInputException(response, property+" is invalid input");
		}
				
		return response;
	}

}