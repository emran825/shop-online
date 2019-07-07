/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.DelivaryCost;
import entity.Product;
import entity.SubCategory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author User
 */
public class ListDao {

    public List catList() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Category> cList=session.createQuery("SELECT al.catName FROM Category al").list();
        cList.toString();
        session.close();
        return cList;
    }
    public List subcatList(String name) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<SubCategory> cList=session.createQuery("SELECT al.subCatName FROM SubCategory al where al.category.catId IN (SELECT a.catId FROM Category a where lower(a.catName)='"+name.toLowerCase()+"')").list();
        cList.toString();
        session.close();
        return cList;
    }
    public List<Category> catListByName(String name) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Category> cList=session.createQuery("SELECT al FROM Category al where lower(catName)='"+name.toLowerCase()+"'").list();
        cList.toString();
        session.close();
        return cList;
    }
    public List<Category> catListAll() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Category> cList=session.createQuery("SELECT al FROM Category al").list();
        cList.toString();
        session.close();
        return cList;
    }
    public List<SubCategory> subcatListByName(String name) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<SubCategory> cList=session.createQuery("SELECT al FROM SubCategory al where lower(subCatName)='"+name.toLowerCase()+"'").list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public List allProductList() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Product> cList=session.createQuery("SELECT al FROM Product al").list();
        cList.toString();
        session.close();
        return cList;
    }
    public List allProductListbyCatName(String catname) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Product> cList=session.createQuery("SELECT product FROM SubCategory sub_category, Category category, Product product WHERE sub_category.category.catId = category.catId AND product.subCategory.subCatId = sub_category.subCatId AND (category.catName = '"+catname+"')").list();
        cList.toString();
        session.close();
        return cList;
    }
    public List zoneList() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<DelivaryCost> cList=session.createQuery("SELECT al.zoneName FROM DelivaryCost al").list();
        cList.toString();
        session.close();
        return cList;
    }
}
