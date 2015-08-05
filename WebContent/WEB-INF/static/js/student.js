//映射关系
var Student = Ext.data.Record.create([{
 name : 'id',mapping : 'id',type : 'string'},
 {name : 'name',mapping : 'name',type : 'string'},
 {name : 'age',mapping : 'age',type : 'string'}]);
var cm_Student = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
 header : '学生',
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
//3 添加窗体：含有两个输入框，和监听事件（当点击提交时候，数据转到后台处理）
var window_add_Student = new Ext.Window({
 title : '添加班级',
 width : 350,
 height : 440,
 resizable : false,
 autoHeight : true,
 modal : true,
 bodyStyle:'padding-right:20px',
 closeAction : 'hide',
 listeners : {
  'hide' : function() {
   this.setTitle('添加班级');
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
   msgTarget : 'side' // 验证信息显示右边
  },
  defaultType : 'textfield',
  items : [{
   fieldLabel : '年级',
   id : 'Student.grade',
   name : 'Student.grade',
   allowBlank : false,
   maxLength : 20
  }, {
   fieldLabel : '班级',
   id : 'Student.className',
   name : 'Student.className',
   allowBlank : false,
   maxLength : 20
  }],
  buttonAlign : 'right',
  minButtonWidth : 60,
  buttons : [{
   text : '添加',
   handler : function(btn) {
    var frm = this.ownerCt.ownerCt.form;
    if (frm.isValid()) {
     btn.disable();
     var gradeField = frm.findField('Student.grade'); // 获得年级名称输入框
     var classField = frm.findField('Student.className');// 获得班级名称输入框
     frm.submit({
      waitTitle : '请稍候',
      waitMsg : '正在提交表单数据,请稍候...',
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
       window_add_Student.setTitle('[ ' + gradeField.getValue()+'-'+classField.getValue()+ ' ]   添加成功!!');
      }else{//add
        window_add_Student.setTitle('添加未成功，请检查是否输入重复值!');
      }
       frm.reset();
       btn.enable();
      },
      failure : function(form, action) {
       Ext.Msg.show({
        title : '错误提示',
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
   text : '重置',
   handler : function() {
    this.ownerCt.ownerCt.form.reset();
   }
  }, {
   text : '取消',
   handler : function() {
    this.ownerCt.ownerCt.ownerCt.hide();
   }
  }]
 })]
});
//2.1 添加按钮
var btn_add_Student = new Ext.Button({
 text : '添加班级',
 iconCls : 'icon-add',
 handler : function() {
     window_add_Student.show();
 }
});
var btn_del_Student = new Ext.Button({
 text : '删除班级',
 iconCls : 'icon-del',
 handler : function() {
  var record = grid_Student.getSelectionModel().getSelected();
  if (record) {
   Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
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
        Ext.Msg.show({title : '错误提示',msg : message,buttons : Ext.Msg.OK,icon : Ext.Msg.ERROR});
        return;
       }else{
        grid_Student.getStore().remove(record);
       }       
      },
      failure : function() {
       Ext.Msg.show({
        title : '错误提示',
        msg : '无法删除,该班级存在业务数据!',
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
 emptyText: '输入年级',
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
 emptyText: '输入班级',
 listeners : {
  'specialkey' : function(field, e) {
   if (e.getKey() == Ext.EventObject.ENTER) {
    searchStudent();
   }
  }
 }
});
// grid的查找方法
var searchStudent = function() {
 // 传参数一定要用这种方式,否则翻页的时候不会根据这些参数查询
 ds_Student.baseParams.grade = text_search_Grade.getValue();
 ds_Student.baseParams.className = text_search_Class.getValue(); 
 ds_Student.load();
}
var btn_search_Student = new Ext.Button({
 text : '查询',
 iconCls : 'icon-search',
 handler : searchStudent
});
//2 可编辑的面板：包含添加按钮，删除按钮，查询按钮，两个文本域；含有编辑的监听事件（当编辑后通过AJAX修改数据）
var grid_Student = new Ext.grid.EditorGridPanel({
 title : '',
 iconCls : 'icon-grid',
 loadMask : {msg : '数据加载中...'},
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
  'afteredit' : function(e) {//编辑后，利用AJAX执行updateStudent.action操作。成功或失败时，给出提示。
   Ext.Ajax.request({
    url : 'updateStudent.action',
    params : {
     fieldName : e.field,
     fieldValue : e.value,
     id : e.record.data.id
    },
    success : function(form, action) {//add form, action
     // alert("数据修改成功！");
     var respText = Ext.util.JSON.decode(form.responseText);
     var success=respText.success;  
     if(!success){
     Ext.Msg.show({
      title : '错误提示',
      msg : '年级、班级信息不能重复,操作将被回滚!',
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
      title : '错误提示',
      msg : '修改数据发生错误,操作将被回滚!',
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
//1页面载入时
Ext.onReady(function() {
 var p_Student = new Ext.Viewport({
  id : 'Student-panel',
  border : false,
  layout : 'border',
  items : [grid_Student]
 });
});