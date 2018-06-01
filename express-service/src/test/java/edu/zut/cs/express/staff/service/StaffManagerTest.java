package edu.zut.cs.express.staff.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.express.base.service.GenericManagerTestCase;
import edu.zut.cs.express.staff.domain.Staff;
import edu.zut.cs.express.staff.service.StaffManager;

public class StaffManagerTest extends GenericManagerTestCase<Long, Staff, StaffManager> {

	StaffManager staffManager;

	@Autowired
	public void setStudentManager(StaffManager staffManager) {
		this.staffManager = staffManager;
		this.manager = this.staffManager;
	}

	public StaffManagerTest() {
		super(Staff.class);
	}

	@Before
	public void setUp() throws Exception {
		Staff staff = new Staff();
		staff.setIDnum("4");
		staff.setName("张三");
		staff.setAge(21);
		staff.setSex("male");
		this.entity = this.manager.save(staff);
	}

	@Test
	public void testFindByName() {
		List<Staff> result = this.staffManager.findByName("张");
		/*assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals("张三", result.get(0).getName());*/
		//assertEquals(1, result.size());
		//assertEquals("薛二伟", result.get(0).getName());
		System.out.println(result.toString());
	}

	@Test
	public void testFindByIDnum() {
		String postcode = this.entity.getIDnum();
		List<Staff> result = this.staffManager.findByIDnum("idnum");
		//System.out.println(result.toString());
		//assertEquals(idnum, result.get(0).getIDnum());
		/*assertEquals(postcode, result.get(0).getIDnum());*/

	}

}