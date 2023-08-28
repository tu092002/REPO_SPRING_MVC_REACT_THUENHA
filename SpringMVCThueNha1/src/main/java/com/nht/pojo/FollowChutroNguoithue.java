/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.pojo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nitro 5
 */
@Entity
@Table(name = "follow_chutro_nguoithue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FollowChutroNguoithue.findAll", query = "SELECT f FROM FollowChutroNguoithue f"),
    @NamedQuery(name = "FollowChutroNguoithue.findByIdfollow", query = "SELECT f FROM FollowChutroNguoithue f WHERE f.idfollow = :idfollow")})
public class FollowChutroNguoithue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfollow")
    private Integer idfollow;
    @JoinColumn(name = "idChuTro", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idChuTro;
    @JoinColumn(name = "idNguoiThue", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idNguoiThue;

    public FollowChutroNguoithue() {
    }

    public FollowChutroNguoithue(Integer idfollow) {
        this.idfollow = idfollow;
    }

    public Integer getIdfollow() {
        return idfollow;
    }

    public void setIdfollow(Integer idfollow) {
        this.idfollow = idfollow;
    }

    public User getIdChuTro() {
        return idChuTro;
    }

    public void setIdChuTro(User idChuTro) {
        this.idChuTro = idChuTro;
    }

    public User getIdNguoiThue() {
        return idNguoiThue;
    }

    public void setIdNguoiThue(User idNguoiThue) {
        this.idNguoiThue = idNguoiThue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfollow != null ? idfollow.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowChutroNguoithue)) {
            return false;
        }
        FollowChutroNguoithue other = (FollowChutroNguoithue) object;
        if ((this.idfollow == null && other.idfollow != null) || (this.idfollow != null && !this.idfollow.equals(other.idfollow))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nht.pojo.FollowChutroNguoithue[ idfollow=" + idfollow + " ]";
    }
    
}
