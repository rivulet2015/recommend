package com.alfago.weixin.persistence.mongo.repository;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alfago.weixin.common.domain.Recommendation;
import com.alfago.weixin.persistence.mongo.repository.RecommendationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class RecommendationRepositoryTest {

	@SuppressWarnings("restriction")
	@Resource(name="recommendationRepository")
	private RecommendationRepository recommendationRepository;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

/*	@Test
	public void testInsertS() {
		Recommendation r = new Recommendation();
		r.setCreatedTime(new Date());
		r.setContent("abcd");
		r.setId("123467");
		recommendationRepository.save(r);
	}*/

	@Test
	public void testSave() {

		Recommendation r = new Recommendation();
		r.setContent("aeeeeeeeeeeeeeeeeeeeeeeeeee");
		recommendationRepository.findByContentAndUpdate("aeeeeeeeeeeeeeeeeeeeeeeeeee", "adawedawedwaedwe");
	}
	
	@Test
	public void testFindOne() {
/*		Recommendation r = new Recommendation();
		r.setContent("aeeeeeeeeeeeeeeeeeeeeeeeeee");
		Recommendation a = recommendationRepository.findOneByContent("aeeeeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println("****************"+a.getId()+"***************");*/
	}
	
	@Test
	public void testFindAll() {
/*		List<Recommendation> result = recommendationRepository.findAllByContent("aeeeeeeeeeeeeeeeeeeeeeeeeee");
		for(int i = 0; i< result.size();i++){
			System.out.println("****************"+result.get(i).getId()+"***************");
		}*/
		
	}
	

	
	@Test
	public void testCount() {
		
	//	System.out.println("&&&&&&&&&&&&&&&&&&"+recommendationRepository.count()+"&&&&&&&&&&&&&&");
	}

}
