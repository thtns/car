(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-fd355806"],{"46b9":function(e,t,a){"use strict";a("f871")},"8ea3":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"member-list"},[a("div",{staticClass:"search-container"},[a("el-form",{ref:"form",attrs:{inline:!0,model:e.form,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"会员姓名",prop:"name"}},[a("el-input",{attrs:{placeholder:"请输入会员姓名"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),a("el-form-item",{attrs:{label:"会员手机号",prop:"phone"}},[a("el-input",{attrs:{placeholder:"请输入会员手机号"},model:{value:e.form.phone,callback:function(t){e.$set(e.form,"phone",t)},expression:"form.phone"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.onSearch}},[e._v("查询")]),a("el-button",{on:{click:e.onReset}},[e._v("重置筛选条件")])],1)],1)],1),a("el-button",{staticClass:"add-btn",attrs:{type:"primary",plain:""},on:{click:e.handleAddMember}},[e._v("添加")]),a("div",{staticClass:"table-container"},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.pageData,border:""}},[a("el-table-column",{attrs:{prop:"createTime",label:"创建日期"}}),a("el-table-column",{attrs:{prop:"name",label:"姓名"}}),a("el-table-column",{attrs:{prop:"balance",label:"余额"}}),a("el-table-column",{attrs:{prop:"phone",label:"手机号"}}),a("el-table-column",{attrs:{prop:"numberPlate",label:"车牌号"}}),a("el-table-column",{attrs:{label:"会员"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(" "+e._s(1===t.row.type?"散客":"会员")+" ")]}}])}),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"150"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",size:"medium"},on:{click:function(a){return e.handleRecharge(t.row)}}},[e._v("充值")]),a("el-button",{staticStyle:{color:"#f56c6c"},attrs:{type:"text",size:"medium"},on:{click:function(a){return e.handleReset(t.row)}}},[e._v("重置")])]}}])})],1),a("div",{staticClass:"paging"},[a("pagination",{attrs:{total:e.total,small:!0,layout:"total, prev, pager, next",page:e.form.pageNo,limit:e.form.pageSize},on:{"update:page":function(t){return e.$set(e.form,"pageNo",t)},"update:limit":function(t){return e.$set(e.form,"pageSize",t)},pagination:e.getPageData}})],1)],1),a("el-dialog",{attrs:{title:e.isAdd?"新增会员":"会员充值",visible:e.DialogVisible,width:"30%",center:""},on:{"update:visible":function(t){e.DialogVisible=t}}},[a("el-form",{ref:"chargeForm",attrs:{model:e.chargeForm,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"会员姓名"}},[a("el-input",{attrs:{disabled:!e.isAdd,placeholder:"请输入会员姓名"},model:{value:e.chargeForm.name,callback:function(t){e.$set(e.chargeForm,"name",t)},expression:"chargeForm.name"}})],1),a("el-form-item",{attrs:{label:"会员手机号"}},[a("el-input",{attrs:{disabled:!e.isAdd,placeholder:"请输入会员手机号"},model:{value:e.chargeForm.phone,callback:function(t){e.$set(e.chargeForm,"phone",t)},expression:"chargeForm.phone"}})],1),a("el-form-item",{attrs:{label:"会员车牌号"}},[a("el-input",{attrs:{disabled:!e.isAdd,placeholder:"请输入会员车牌号"},model:{value:e.chargeForm.numberPlate,callback:function(t){e.$set(e.chargeForm,"numberPlate",t)},expression:"chargeForm.numberPlate"}})],1),e.isAdd?e._e():a("el-form-item",{attrs:{label:"会员余额"}},[a("el-input",{attrs:{disabled:"",placeholder:""},model:{value:e.chargeForm.balance,callback:function(t){e.$set(e.chargeForm,"balance",t)},expression:"chargeForm.balance"}})],1),a("el-form-item",{attrs:{label:"用户类型"}},[a("el-radio-group",{attrs:{disabled:!e.isAdd},model:{value:e.chargeForm.type,callback:function(t){e.$set(e.chargeForm,"type",t)},expression:"chargeForm.type"}},[a("el-radio",{attrs:{label:0}},[e._v("会员")]),a("el-radio",{attrs:{label:1}},[e._v("散客")])],1)],1),a("el-form-item",{attrs:{label:"充值金额",prop:"name"}},[a("el-input",{attrs:{placeholder:"请输入充值金额"},model:{value:e.chargeForm.price,callback:function(t){e.$set(e.chargeForm,"price",e._n(t))},expression:"chargeForm.price"}})],1),e.isAdd?e._e():a("el-form-item",{attrs:{label:"备注",prop:"phone"}},[a("el-input",{attrs:{type:"textarea",rows:2,placeholder:"请输入备注信息"},model:{value:e.chargeForm.remark,callback:function(t){e.$set(e.chargeForm,"remark",t)},expression:"chargeForm.remark"}})],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.handleCancelCharge}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.handleConfirmCharge}},[e._v("确 定")])],1)],1)],1)},l=[],o=(a("b0c0"),a("b775"));function n(e){return Object(o["a"])({url:"/biz-member/list",method:"get",params:e})}function i(e){return Object(o["a"])({url:"/biz-member/add",method:"post",data:e})}function s(e){return Object(o["a"])({url:"/biz-member/recharge",method:"put",data:e})}function c(e){return Object(o["a"])({url:"/biz-member/reset/".concat(e),method:"put"})}var m={data:function(){return{form:{name:"",phone:"",pageNo:1,pageSize:10},total:0,pageData:[],DialogVisible:!1,chargeForm:{name:"",phone:"",balance:0,price:"",remark:"",numberPlate:"",type:0},currentChargeItem:{},isAdd:!0}},created:function(){this.getPageData()},methods:{handleAddMember:function(){this.isAdd=!0,Object.assign(this.chargeForm,{name:"",phone:"",balance:0,price:"",remark:"",numberPlate:"",type:0}),this.DialogVisible=!0},handleCancelCharge:function(){this.DialogVisible=!1},handleConfirmCharge:function(){var e=this;if(this.isAdd){var t={name:this.chargeForm.name,phone:this.chargeForm.phone,balance:this.chargeForm.price,numberPlate:this.chargeForm.numberPlate,type:this.chargeForm.type};i(t).then((function(t){e.$message({type:"success",message:"添加成功！"}),e.DialogVisible=!1,e.form.pageNo=1,e.getPageData()}))}else{var a={memberId:this.currentChargeItem.id,price:this.chargeForm.price,remark:this.chargeForm.remark};s(a).then((function(t){e.$message({type:"success",message:"充值成功！"}),e.DialogVisible=!1,e.getPageData()}))}},handleRecharge:function(e){this.isAdd=!1,this.currentChargeItem=e,Object.assign(this.chargeForm,e),this.DialogVisible=!0},handleReset:function(e){var t=this;this.$confirm("此操作将重置该用户, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){c(e.id).then((function(e){t.$message({type:"success",message:"重置成功!"}),t.getPageData()}))})).catch((function(){t.$message({type:"info",message:"已取消"})}))},onSearch:function(){this.form.pageNo=1,this.getPageData()},onReset:function(){Object.assign(this.form,{name:"",phone:"",pageNo:1,pageSize:10}),this.getPageData()},getPageData:function(){var e=this;n(this.form).then((function(t){e.total=1*t.data.total,e.pageData=t.data.records}))}}},p=m,h=(a("46b9"),a("2877")),u=Object(h["a"])(p,r,l,!1,null,"9271cc56",null);t["default"]=u.exports},f871:function(e,t,a){}}]);