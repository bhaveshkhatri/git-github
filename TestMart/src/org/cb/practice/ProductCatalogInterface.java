package org.cb.practice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace="http://www.bookcatalog.com")
public interface ProductCatalogInterface {

	@WebMethod(action="fetch-categories", operationName="fetchcategories")
	public abstract List<String> getProductCategories();

	@WebMethod
	public abstract List<String> getProducts(String category);

	@WebMethod
	public abstract boolean addProduct(String category, String product);

	@WebMethod
	@WebResult(name="Product")
	public abstract List<Product> getProductV2(String category);

}