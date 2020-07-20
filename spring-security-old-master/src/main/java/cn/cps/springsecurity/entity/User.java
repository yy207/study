package cn.cps.springsecurity.entity;

import lombok.Data;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sun.security.util.Password;

import java.io.Serializable;

/**
 * 用户实体类
 */
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private String password;

	private String nickName;

	private String salt;

	private String token;

	public User(){
	}

	public User(Integer id,String username,String password){
		this.id = id;
		this.username = username;
		this.password = password;
	}
}



