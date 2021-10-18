package com.reapal.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jackcooper
 */

@Transactional
@Entity
@Data
@TableName(value =  "db_config")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Proxy(lazy = false) // 不使用懒加载
public class DbConfig implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;

	/** 数据库 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String dbName;
	private String url="";
	private String driver="";	//com.mysql.jdbc.Driver
	private String username="";
	private String password="";
	private String schema;
	private String catalog;
	private String dbType;


}

