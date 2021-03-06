var pageSize = 20;

var registerStore = Ext.create('register.store.RegisterStore');

Ext.define('register.view.RegisterGrid', {
	extend : 'Ext.grid.GridPanel',
	alias : 'widget.registerGrid',
	title : 'Express - 人员信息表',
	store : registerStore,
	columns : [ {
		text : 'ID',
		width : 50,
		sortable : true,
		dataIndex : 'ID'
	}, {
		text : "username",
		width : 80,
		sortable : true,
		dataIndex : 'username'
	},{
		text : "idnum",
		width : 80,
		sortable : true,
		dataIndex : 'idnum'
	}, {
		text : "email",
		width : 120,
		sortable : true,
		dataIndex : 'email'
	}, {
		text : "sex",
		width : 80,
		sortable : true,
		dataIndex : 'sex'
	}, {
		text : "phone",
		width : 120,
		sortable : true,
		dataIndex : 'phone'
	}, {
		text : "DATECREATED",
		width : 150,
		dataIndex : 'dateCreated',
		renderer : Ext.util.Format.dateRenderer('Y/m/d H:i:s'),
		sortable : true
	}, {
		text : "DATEMODIFIED",
		width : 150,
		dataIndex : 'dateModified',
		renderer : Ext.util.Format.dateRenderer('Y/m/d H:i:s'),
		sortable : true
	} ],
	viewConfig : {
		columnsText : '列',
		sortAscText : '升序',
		sortDescText : '降序'
	},

	bbar : new Ext.PagingToolbar({
		pageSize : pageSize,// 每页显示的记录值
		store : registerStore,
		displayInfo : true,
		firstTest : '首页',
		lastText : '尾页',
		nextText : '下页',
		prevText : '前页',
		beforePageText : '第',
		afterPageText : '页，共{0}页',
		displayMsg : '记录数：第{0}条 - 第{1}条，共 {2}条',
		emptyMsg : "没有记录"
	})
});