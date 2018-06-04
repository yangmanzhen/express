Ext.Loader.setConfig({
	enabled : true
});
Ext.application({
	name : 'pay',
	appFolder : server_context + '/resources/js/Pay/app',
	controllers : [ 'PayController' ],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'payGrid'
			} ]
		});
	}
});
