Ext.define('MyApp.view.MyViewport', {
    extend: 'Ext.container.Viewport',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'gridpanel',
                    height: 327,
                    id: 'mygrid',
                    title: 'My Grid Panel',
                    store: 
'persionStore'
, 
                    columns: [
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'id',
                            text: 'ID'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'name',
                            text: 'MyColumn1'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'coursename',
                            text: 'MyColumn2'
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'pagingtoolbar',
                            dock: 'bottom',
                            width: 360,
                            displayInfo: true,
                            store: 
'persionStore'

                        }
                    ]
                },
                {
                    xtype: 'textareafield',
                    height: 33,
                    fieldLabel: '�ؼ���',
                    labelWidth: 60
                },
                {
                    xtype: 'button',
                    id: 'btnfind',
                    text: '����'
                },
                {
                    xtype: 'button',
                    id: 'btndelete',
                    text: 'ɾ��'
                },
                {
                    xtype: 'button',
                    id: 'btnadd',
                    text: '���'
                }
            ]
        });

        me.callParent(arguments);
    }

});