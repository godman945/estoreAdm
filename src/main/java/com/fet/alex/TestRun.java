package com.fet.alex;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;

import com.fet.db.oracle.service.coMaster.IAdmRoleService;
import com.fet.pojo.AdmRole;
import com.fet.spring.init.SpringbootWebApplication;

@Component
public class TestRun {

	@Autowired
	private IAdmRoleService admRoleService;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	  
	private void process() throws Exception{
		System.out.println("AAAAAAA");
		
		System.out.println(admRoleService);
		
		
		AdmRole a = new AdmRole();
		
		
//		a.setId("3");
//		a.setRoleId("ROLE_A03");
//		a.setRoleName("業務用5");
//		a.setColumn3(new Date());
//		a.setUpdateDate(new Date());
//		admRoleService.saveOrUpdate(a);
		
		
		
//		System.out.println(entityManager == null);
//		
//		System.out.println(entityManager.createNativeQuery("select * from adm_role").getResultList().size());
//		
//		System.out.println(entityManager.find(AdmRole.class, "1").getRoleName());
//		
		
//		System.out.println(admRoleService.loadAll().size());
//		
//		
//		System.out.println(admRoleService.findOne("1"));
//		System.out.println(admRoleService.findOne("1").getRoleName());
//		
		
		
//		System.out.println(admRoleService.findOne("1"));
		
		
//		System.out.println(admRoleService.getClass());
		
//		System.out.println(baseService == null);
	}
	
	public static void main(String[] args) {
		try {
			ApplicationContext ctx = new SpringApplicationBuilder(SpringbootWebApplication.class).web(WebApplicationType.NONE).run(args);
			TestRun testRun = ctx.getBean(TestRun.class);
			testRun.process();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
