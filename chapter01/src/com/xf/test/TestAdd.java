package com.xf.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xf.pojo.Student;

public class TestAdd {
	
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
			student.setSname("XiaoFeng");
			student.setAge("20");
			student.setCourse("TypeScript");
			//调用 SqlSession 对象的 insert()方法执行插入 
			int result = sqlSession.insert("student.addStudent", student); 
			if(result > 0) {
				System.out.println("成功插入"+result+"条数据"); 
			}else {
				System.out.println("插入操作失败"); 
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
