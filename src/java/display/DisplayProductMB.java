/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import dao.ListDao;
import entity.Product;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author User
 */
@ManagedBean
@RequestScoped
public class DisplayProductMB {

    Product product = new Product();
    private Product selectedProduct;
    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getAllProduct() {
        List<Product> plist = new ListDao().allProductList();
        return plist;
    }


//    public String catNavigate() {
//        getAllProductByCatName();
//        String ret = "/category/"+param+"/?faces-redirect=true";
//        System.out.println("ret======"+ ret);
//        return "catdetails";
//    }

    public List<Product> getAllProductByCatName() {
        System.out.println(param + "----------------------------------");
        //String idParm = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("param").toString();
        // System.out.println(idParm);
        List<Product> plist = new ListDao().allProductListbyCatName(param);
        return plist;
    }
}
