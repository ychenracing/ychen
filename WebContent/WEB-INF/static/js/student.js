//ӳ���ϵ
var Student = Ext.data.Record.create([{
 name : 'id',mapping : 'id',type : 'string'},
 {name : 'name',mapping : 'name',type : 'string'},
 {name : 'age',mapping : 'age',type : 'string'}]);
var cm_Student = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
 header : 'ѧ��',
 width : 200,
 dataIndex : 'name',
 editor : new Ext.form.TextField({
  allowBlank : false,
  maxLength : 20
 })
}, {
 header : 'ID',
 id : 'id',
 dataIndex : 'id',
 editor : new Ext.form.TextField({
  allowBlank : false,
  maxLength : 20
 })
}]);
var ds_Student = new Ext.data.Store({
 proxy : new Ext.data.HttpProxy({
  url : 'findAllStudent.action'
 }),
 reader : new Ext.data.JsonReader({
  totalProperty : 'totalProperty',
  root : 'root'
 }, Student)
});
cm_Student.defaultSortable = false;
//3 ��Ӵ��壺������������򣬺ͼ����¼���������ύʱ������ת����̨����
var window_add_Student = new Ext.Window({
 title : '��Ӱ༶',
 width : 350,
 height : 440,
 resizable : false,
 autoHeight : true,
 modal : true,
 bodyStyle:'padding-right:20px',
 closeAction : 'hide',
 listeners : {
  'hide' : function() {
   this.setTitle('��Ӱ༶');
   Ext.getCmp('addStudentForm').form.reset();
  }
 },
 items : [new Ext.FormPanel({
  labelWidth : 70,
  id: 'addStudentForm',
  labelAlign : 'right',
  url : 'saveStudent.action',
  border : false,
  baseCls : 'x-plain',
  bodyStyle : 'padding:5px 5px 0',
  anchor : '100%',
  defaults : {
   width : 233,
   msgTarget : 'side' // ��֤��Ϣ��ʾ�ұ�
  },
  defaultType : 'textfield',
  items : [{
   fieldLabel : '�꼶',
   id : 'Student.grade',
   name : 'Student.grade',
   allowBlank : false,
   maxLength : 20
  }, {
   fieldLabel : '�༶',
   id : 'Student.className',
   name : 'Student.className',
   allowBlank : false,
   maxLength : 20
  }],
  buttonAlign : 'right',
  minButtonWidth : 60,
  buttons : [{
   text : '���',
   handler : function(btn) {
    var frm = this.ownerCt.ownerCt.form;
    if (frm.isValid()) {
     btn.disable();
     var gradeField = frm.findField('Student.grade'); // ����꼶���������
     var classField = frm.findField('Student.className');// ��ð༶���������
     frm.submit({
      waitTitle : '���Ժ�',
      waitMsg : '�����ύ������,���Ժ�...',
      success : function(form, action) {
      if(action.result.success==true){
       var store = grid_Student.getStore();
       if (store.data.length <= 20) {
        var Student = new Student({
         id : action.result.message,
         grade : gradeField.getValue(),
         className : classField.getValue()
        });
          store.insert(0, [Student]);
         if (store.data.length > 20) {
         store.remove(store.getAt(store.data.length - 1));
         }
       }
       window_add_Student.setTitle('[ ' + gradeField.getValue()+'-'+classField.getValue()+ ' ]   ��ӳɹ�!!');
      }else{//add
        window_add_Student.setTitle('���δ�ɹ��������Ƿ������ظ�ֵ!');
      }
       frm.reset();
       btn.enable();
      },
      failure : function(form, action) {
       Ext.Msg.show({
        title : '������ʾ',
        msg :action.result.message,
        buttons : Ext.Msg.OK,
        fn : function() {
         btn.enable();
        },
        icon : Ext.Msg.ERROR
       });
      }
     });
    }
   }
  }, {
   text : '����',
   handler : function() {
    this.ownerCt.ownerCt.form.reset();
   }
  }, {
   text : 'ȡ��',
   handler : function() {
    this.ownerCt.ownerCt.ownerCt.hide();
   }
  }]
 })]
});
//2.1 ��Ӱ�ť
var btn_add_Student = new Ext.Button({
 text : '��Ӱ༶',
 iconCls : 'icon-add',
 handler : function() {
     window_add_Student.show();
 }
});
var btn_del_Student = new Ext.Button({
 text : 'ɾ���༶',
 iconCls : 'icon-del',
 handler : function() {
  var record = grid_Student.getSelectionModel().getSelected();
  if (record) {
   Ext.Msg.confirm('ȷ��ɾ��', '��ȷ��ɾ��������¼?', function(btn) {
    if (btn == 'yes') {
     Ext.Ajax.request({
      url : 'deleteStudent.action',
      params : {
       id : record.data.id
      },
      success : function(form, action) {
       var respText = Ext.util.JSON.decode(form.responseText);
       var message=respText.message;
       var success=respText.success;       
       if(success==false){
        Ext.Msg.show({title : '������ʾ',msg : message,buttons : Ext.Msg.OK,icon : Ext.Msg.ERROR});
        return;
       }else{
        grid_Student.getStore().remove(record);
       }       
      },
      failure : function() {
       Ext.Msg.show({
        title : '������ʾ',
        msg : '�޷�ɾ��,�ð༶����ҵ������!',
        buttons : Ext.Msg.OK,
        icon : Ext.Msg.ERROR
       });
      }
     });
    }
   });
  }
 }
});
var text_search_Grade = new Ext.form.TextField({
 width : 100,
 emptyText: '�����꼶',
 listeners : {
  'specialkey' : function(field, e) {
   if (e.getKey() == Ext.EventObject.ENTER) {
    searchStudent();
   }
  }
 }
});
var text_search_Class = new Ext.form.TextField({
 width : 100,
 emptyText: '����༶',
 listeners : {
  'specialkey' : function(field, e) {
   if (e.getKey() == Ext.EventObject.ENTER) {
    searchStudent();
   }
  }
 }
});
// grid�Ĳ��ҷ���
var searchStudent = function() {
 // ������һ��Ҫ�����ַ�ʽ,����ҳ��ʱ�򲻻������Щ������ѯ
 ds_Student.baseParams.grade = text_search_Grade.getValue();
 ds_Student.baseParams.className = text_search_Class.getValue(); 
 ds_Student.load();
}
var btn_search_Student = new Ext.Button({
 text : '��ѯ',
 iconCls : 'icon-search',
 handler : searchStudent
});
//2 �ɱ༭����壺������Ӱ�ť��ɾ����ť����ѯ��ť�������ı��򣻺��б༭�ļ����¼������༭��ͨ��AJAX�޸����ݣ�
var grid_Student = new Ext.grid.EditorGridPanel({
 title : '',
 iconCls : 'icon-grid',
 loadMask : {msg : '���ݼ�����...'},
 region : 'center',
 cm : cm_Student,
 ds : ds_Student,
 sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
 enableColumnMove : false,
 trackMouseOver : false,
 frame : false,
 autoExpandColumn : 'className',
 clicksToEdit : 1,
 tbar : [btn_add_Student, btn_del_Student, text_search_Grade, text_search_Class, btn_search_Student],
 listeners : {
  'afteredit' : function(e) {//�༭������AJAXִ��updateStudent.action�������ɹ���ʧ��ʱ��������ʾ��
   Ext.Ajax.request({
    url : 'updateStudent.action',
    params : {
     fieldName : e.field,
     fieldValue : e.value,
     id : e.record.data.id
    },
    success : function(form, action) {//add form, action
     // alert("�����޸ĳɹ���");
     var respText = Ext.util.JSON.decode(form.responseText);
     var success=respText.success;  
     if(!success){
     Ext.Msg.show({
      title : '������ʾ',
      msg : '�꼶���༶��Ϣ�����ظ�,���������ع�!',
      fn : function() {
       e.record.set(e.field, e.originalValue);
      },
      buttons : Ext.Msg.OK,
      icon : Ext.Msg.ERROR
     });
     }
    },
    failure : function() {
     Ext.Msg.show({
      title : '������ʾ',
      msg : '�޸����ݷ�������,���������ع�!',
      fn : function() {
       e.record.set(e.field, e.originalValue);
      },
      buttons : Ext.Msg.OK,
      icon : Ext.Msg.ERROR
     });
    }
   });
  }
 }
});
//1ҳ������ʱ
Ext.onReady(function() {
 var p_Student = new Ext.Viewport({
  id : 'Student-panel',
  border : false,
  layout : 'border',
  items : [grid_Student]
 });
});