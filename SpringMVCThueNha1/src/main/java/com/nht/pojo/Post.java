/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nitro 5
 */
@Entity
@Table(name = "post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findByIdPost", query = "SELECT p FROM Post p WHERE p.idPost = :idPost"),
    @NamedQuery(name = "Post.findByTitlePost", query = "SELECT p FROM Post p WHERE p.titlePost = :titlePost"),
    @NamedQuery(name = "Post.findByAddressPost", query = "SELECT p FROM Post p WHERE p.addressPost = :addressPost"),
    @NamedQuery(name = "Post.findByImgPost", query = "SELECT p FROM Post p WHERE p.imgPost = :imgPost"),
    @NamedQuery(name = "Post.findByStatus", query = "SELECT p FROM Post p WHERE p.status = :status"),
    @NamedQuery(name = "Post.findByLikePost", query = "SELECT p FROM Post p WHERE p.likePost = :likePost"),
    @NamedQuery(name = "Post.findBySoluongNguoi", query = "SELECT p FROM Post p WHERE p.soluongNguoi = :soluongNguoi"),
    @NamedQuery(name = "Post.findByGiaTien", query = "SELECT p FROM Post p WHERE p.giaTien = :giaTien")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPost")
    private Integer idPost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titlePost")
    private String titlePost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "addressPost")
    private String addressPost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "imgPost")
    private String imgPost;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "likePost")
    private int likePost;
    @Column(name = "soluongNguoi")
    private Integer soluongNguoi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "giaTien")
    private double giaTien;
//    @JsonIgnore
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idUser;
    @Transient
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    public Post() {
    }

    public Post(Integer idPost) {
        this.idPost = idPost;
    }

    public Post(Integer idPost, String titlePost, String addressPost, String imgPost, int status, int likePost, double giaTien) {
        this.idPost = idPost;
        this.titlePost = titlePost;
        this.addressPost = addressPost;
        this.imgPost = imgPost;
        this.status = status;
        this.likePost = likePost;
        this.giaTien = giaTien;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public String getTitlePost() {
        return titlePost;
    }

    public void setTitlePost(String titlePost) {
        this.titlePost = titlePost;
    }

    public String getAddressPost() {
        return addressPost;
    }

    public void setAddressPost(String addressPost) {
        this.addressPost = addressPost;
    }

    public String getImgPost() {
        return imgPost;
    }

    public void setImgPost(String imgPost) {
        this.imgPost = imgPost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLikePost() {
        return likePost;
    }

    public void setLikePost(int likePost) {
        this.likePost = likePost;
    }

    public Integer getSoluongNguoi() {
        return soluongNguoi;
    }

    public void setSoluongNguoi(Integer soluongNguoi) {
        this.soluongNguoi = soluongNguoi;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPost != null ? idPost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.idPost == null && other.idPost != null) || (this.idPost != null && !this.idPost.equals(other.idPost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nht.pojo.Post[ idPost=" + idPost + " ]";
    }
    
}
