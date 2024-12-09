package kr.co.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import chapter12.StudentMapper;
import chapter12.StudentVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = chapter12.MvcConfig.class)
@WebAppConfiguration
public class StudentMapperTest {
	@Autowired
	private StudentMapper mapper;
	
	@Test
	public void count() {
		int count = mapper.count(new StudentVO());
		System.out.println(count);
	}
	@Test
	public void list() {
		StudentVO vo = new StudentVO();
		vo.setSearchGrade(1);
		List<StudentVO> list = mapper.list(vo);
		list.stream().forEach(o->System.out.println(o));
	}
}
