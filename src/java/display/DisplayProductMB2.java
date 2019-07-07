/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import dao.ListDao;
import entity.Product;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class DisplayProductMB2 {
    Product product = new Product();
    private String param;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
    public List<Product> getAllProductByCatName() {
        System.out.println(param + "----------------------------------");
        //String idParm = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("param").toString();
        // System.out.println(idParm);
        List<Product> plist = new ListDao().allProductListbyCatName(param);
        return plist;
    }
}
