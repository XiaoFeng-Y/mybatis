package com.xf.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xf.pojo.Student;

public class TestFindBySname {
	public static void main(String[] args) {
		//读取配置文件
		String resorce = "mybatis-config.xml";
		try {
			InputStream in = Resources.getResourceAsStream(resorce);
			//创建 SQLSessionFactory 对象
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
			//创建 SqlSession 对象
			SqlSession sqlSession = factory.openSession(); 
			//调用 SqlSession 对象的 selectOne()方法执行查询 
			List<Student> selectList = sqlSession.selectList("student.findStudentByName","ZhangSan");
			for (Student student : selectList) {
				System.out.println(student.toString());
			}
			//关闭 SqlSession 
			sqlSession.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
