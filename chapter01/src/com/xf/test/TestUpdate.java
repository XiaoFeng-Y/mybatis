package com.xf.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xf.pojo.Student;

public class TestUpdate {
	
	public static void main(String[] args) {
		//读取配置文件
		String resorce = "mybatis-config.xml";
		try {
			InputStream in = Resources.getResourceAsStream(resorce);
			//创建 SQLSessionFactory 对象
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
			//创建 SqlSession 对象
			SqlSession sqlSession = factory.openSession(); 
			Student student = new Student();
			student.setSid(8);
			student.setSname("LiFang");
			student.setCourse("C++");
			//调用 SqlSession 对象的 update()方法执行更新 
			int result = sqlSession.update("student.updateStudent", student); 
			if(result > 0) {
				System.out.println("成功更新"+result+"条数据"); 
			}else {
				System.out.println("更新操作失败"); 
			}
			//提交事务 
			sqlSession.commit(); 
			//关闭 SqlSession 
			sqlSession.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
