/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author huu-thanhduong
 */
@Entity
@Table(name = "comment")
@Data
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComment;
    private String content;
    @Column(name = "createDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User idUser;
    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name = "idPost")
    private Post idPost;
}
