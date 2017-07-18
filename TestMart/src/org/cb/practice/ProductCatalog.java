package org.cb.practice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.cb.practice.bussiness.ProductServiceImpl;

@WebService(name="BookCatalog", endpointInterface="org.cb.practice.ProductCatalogInterface", portName="BookCatalogPort", serviceName="BookCatalogService")
public class ProductCatalog implements ProductCatalogInterface {
	
	ProductServiceImpl pimpl = new ProductServiceImpl();
	
	/* (non-Javadoc)
	 * @see org.cb.practice.ProductCatalogInterface#getProductCategories()
	 */
	@Override
	public List<String> getProductCategories() {
		
		return pimpl.getProductCategories();
	}
	
	/* (non-Javadoc)
	 * @see org.cb.practice.ProductCatalogInterface#getProducts(java.lang.String)
	 */
	@Override
	public List<String> getProducts(String category) {
		
		return pimpl.getProducts(category);
	}
	
	/* (non-Javadoc)
	 * @see org.cb.practice.ProductCatalogInterface#addProduct(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addProduct(String category, String product) {
		
		return pimpl.addProduct(category, product);
	}
	
	/* (non-Javadoc)
	 * @see org.cb.practice.ProductCatalogInterface#getProductV2(java.lang.String)
	 */
	@Override
	public List<Product> getProductV2(String category) {
		
		return pimpl.getProductV2(category);
	}
	
}