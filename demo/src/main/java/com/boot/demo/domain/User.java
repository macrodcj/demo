package com.boot.demo.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @Entity会被spring扫描并加载，
 * @Id注解在主键上
 * @Column name="call_phone" 指该字段对应的数据库的字段名，如果相同就不需要定义。数据库下划线间隔和代码中的驼峰法视为相同，
 *         如数据库字段create_time等价于Java类中的createTime，因此不需要用@Column注解。复制代码
 * 
 * */
@SuppressWarnings("serial")
@TableName("user")
public class User extends Model<User> implements Serializable{

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;

	private String name;

	private String text;
	
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	protected Serializable pkVal() {
		 return this.id;
	}

}
