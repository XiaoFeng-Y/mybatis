package com.xf.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestDelete {
	
	public static void main(String[] args) {
		//读取配置文件
		String resorce = "mybatis-config.xml";
		try {
			InputStream in = Resources.getResourceAsStream(resorce);
			//创建 SQLSessionFactory 对象
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
			//创建 SqlSession 对象
			SqlSession sqlSession = factory.openSession(); 
			//调用 SqlSession 对象的 delete()方法执行删除
			int result = sqlSession.delete("student.deleteStudent", 8); 
			if(result > 0) {
				System.out.println("成功删除"+result+"条数据"); 
			}else {
				System.out.println("删除操作失败"); 
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
