/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.repository.impl;

import com.nht.pojo.Post;
import com.nht.pojo.User;
import com.nht.repository.PostRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.ReportAsSingleViolation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nitro 5
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")

public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Post> getPostsAllList() {

        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Post");
        return q.getResultList();

    }

    @Override
    public List<Post> getPosts(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Post> q = b.createQuery(Post.class);
        Root root = q.from(Post.class);
        q.select(root);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("titlePost"), String.format("%%%s%%", kw)));
            }

            String idUser = params.get("idUser");
            if (idUser != null && !idUser.isEmpty()) {
                predicates.add(b.equal(root.get("idUser"), idUser));
            }
            q.where(predicates.toArray(Predicate[]::new));

        }

        q.orderBy(b.desc(root.get("idPost")));
        Query query = s.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
            if (page != null && !page.isEmpty()) {
                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
                query.setMaxResults(pageSize);
            }
        }
        return query.getResultList();
    }

//    @Override
//    public List<Post> getPostById(int idPost) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("FROM Post p "
//                + "WHERE p.idPost = :idPost");
//        q.setParameter("idPost", idPost);
//        return q.getResultList();
//    }
    @Override
    public Post getPostById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Post.class, id);
    }

    @Override
    public List<Post> getPostByAddress(String Address) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Post p "
                + "WHERE p.addressPost LIKE :Address");
        q.setParameter("Address", "%Address%");

        return q.getResultList();

    }

    @Override
    public List<Post> getPostByGiaTien(double minPrice, double maxPrice) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Post p "
                + "WHERE  p.giaTien BETWEEN :minPrice AND :maxPrice");
        q.setParameter("minPrice", minPrice);
        q.setParameter("maxPrice", maxPrice);
        return q.getResultList();

    }

    @Override
    public int countPosts() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM Post");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public Post addPost(Post u) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(u);

        return u;
    }

    @Override
    public boolean deletePost(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Post u = this.getPostById(id);
            s.delete(u);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStatusPost(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        // Định dạng câu truy vấn HQL UPDATE
    
            String hqlUpdate = "UPDATE Post SET status = :newValue WHERE conditionField = :condition";
            Query q = s.createQuery(hqlUpdate);
            q.setParameter("newValue", 1);
            q.setParameter("condition", id);
                return true;
      

    }

}
