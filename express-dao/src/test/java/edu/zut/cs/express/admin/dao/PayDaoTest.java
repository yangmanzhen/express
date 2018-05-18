package edu.zut.cs.express.admin.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.express.admin.domain.Group;
import edu.zut.cs.express.base.dao.GenericTreeDaoTestCase;

public class PayDaoTest extends GenericTreeDaoTestCase<Long, Group, GroupDao> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PayDaoTest.class);

	GroupDao groupDao;

	@Autowired
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
		this.dao = this.groupDao;
	}

	@Test
	public void testGetRoot(){
		int root_size = 10;
		for (int i = 0; i < root_size; i++) {
			Group group = new Group();
			group.setName("group_" + i);
			for (int j = 0; j < 10; j++) {
				Group g = new Group();
				g.setName("group_" + i + "_" + j);
				g.setParent(group);
			}
			this.groupDao.save(group);
		}

		List<Group> roots = this.groupDao.getRoot();
		//assertEquals(root_size, roots.size());

		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<Group> roots=" + roots); //$NON-NLS-1$
		}
	}

}