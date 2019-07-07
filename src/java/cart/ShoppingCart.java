package cart;

import entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

@ManagedBean
@SessionScoped
public class ShoppingCart {

    private List<Item> cart = new ArrayList<>();
    private double total;
    int cartsize;
    String item = "item";

    public String getItem() {
        if (cartsize > 1) {
            item = "items";
        }
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCartsize() {
        cartsize = cart.size();
        return cartsize;
    }

    public void setCartsize(int cartsize) {
        this.cartsize = cartsize;
    }

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public double getTotal() {
        total = 0.0;
        for (Item item : cart) {
            total = total + (item.getQuantity() * item.getP().getProPrice());
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String addtoCart(Product p) {
//        FacesContext context = FacesContext.getCurrentInstance();
//        ServletContext servletcontext = (ServletContext) context.getExternalContext().getContext();
//        String dbpath = servletcontext.getRealPath("/");
//        String webcut = dbpath.substring(0, dbpath.lastIndexOf("\\"));
//        String buildcut = webcut.substring(0, webcut.lastIndexOf("\\"));
//        System.out.println(buildcut + "------------");
        if (cart.size() > 0) {
            for (Item item : cart) {
                if (item.getP().getProId().equals(p.getProId())) {
                    item.setQuantity(item.getQuantity() + 1);
                    return "shopcart?faces-redirect=true";
                }
            }
        }
        Item i = new Item();
        i.setQuantity(1);
        i.setP(p);
        cart.add(i);
        System.out.println("i am here..............");
        return "shopcart?faces-redirect=true";
    }
    public String addtoCart2() {
        
        System.out.println("i am here....in crt2..........");
        return "";
    }

    public void updateCart() {

    }

    public void removeCart(Item i) {
        for (Item item : cart) {
            if (item.equals(i)) {
                cart.remove(i);
                break;
            }
        }

    }
    public String removeCartAll() {
        cart.removeAll(cart);
        return "all?faces-redirect=true";
    }

    public String payment() {

        return "payment";
    }
}
