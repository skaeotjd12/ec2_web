package com.nice.shop.model;


import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int replyId; 
	
	@Column(nullable = false, length = 200)
	private String replyText;
	
	//보드와의 연관관계
	@ManyToOne(fetch = FetchType.LAZY)    //여러개의 답변은 하나의 게시글에 존재할 수있다 
	@JoinColumn(name="prdNum")
	private Product product;
	
    @ManyToOne(fetch = FetchType.LAZY)   //여러개의 답변을 하나의 유저가 쓸 수 있다.	
	@JoinColumn(name="userId") 
	private User user; //답변을 누가 적었는짖 알기 위해
    
    
    @CreationTimestamp
    private Timestamp createDate;
}
