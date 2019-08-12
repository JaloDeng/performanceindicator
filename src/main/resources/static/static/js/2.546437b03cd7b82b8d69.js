webpackJsonp([2],{iLNH:function(e,t){},jK6X:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var i={data:function(){return{}},methods:{colseForm:function(){this.$emit("colseForm")},save:function(e){var t=this;this.putRequest("/integral",this.integral).then(function(e){t.colseForm()})}},props:{dialogTitle:String,dialogVisible:Boolean,integral:Object}},l={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{title:e.dialogTitle,"close-on-click-modal":!1,visible:e.dialogVisible,"before-close":e.colseForm,width:"50%",center:""},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-form",{ref:"saveForm",attrs:{model:e.integral}},[a("el-row",{attrs:{type:"flex"}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"项目","label-width":"120px"}},[a("el-input",{attrs:{size:"mini",placeholder:"请输入项目"},model:{value:e.integral.label,callback:function(t){e.$set(e.integral,"label",t)},expression:"integral.label"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex"}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"积分","label-width":"120px"}},[a("el-input",{attrs:{type:"number",size:"mini",placeholder:"请输入积分"},model:{value:e.integral.value,callback:function(t){e.$set(e.integral,"value",t)},expression:"integral.value"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex"}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"备注","label-width":"120px"}},[a("el-input",{attrs:{type:"textarea",rows:"5",size:"mini",placeholder:"请输入备注"},model:{value:e.integral.remark,callback:function(t){e.$set(e.integral,"remark",t)},expression:"integral.remark"}})],1)],1)],1)],1),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.save("saveForm")}}},[e._v("保存")]),e._v(" "),a("el-button",{attrs:{size:"mini"},on:{click:e.colseForm}},[e._v("取消")])],1)],1)},staticRenderFns:[]};var n={components:{integralForm:a("VU/8")(i,l,!1,function(e){a("iLNH")},null,null).exports},data:function(){return{dialogTitle:"",dialogVisible:!1,integral:{id:"",label:"",value:"",remark:""},integrals:[],searchParams:{label:"",orderBy:"",pageNum:1,pageSize:20,value:""},sizes:[20,50,100],tableLoading:!1,total:1}},methods:{colseForm:function(){this.dialogVisible=!1,this.emptyData(),this.load()},currentChange:function(e){this.searchParams.pageNum=e,this.load()},del:function(e){var t=this;this.$confirm("此操作将永久删除["+e.label+"]，是否继续？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.deleteRequest("/integral/"+e.id).then(function(e){e&&200===e.status&&e.data.success&&t.load()})}).catch(function(){})},emptyData:function(){this.integral={id:"",label:"",value:"",remark:""}},load:function(){var e=this;this.getRequest("/integral",e.searchParams).then(function(t){e.tableLoading=!1,e.total=t.data.total,e.integrals=t.data.data})},search:function(){this.searchParams.pageNum=1,this.load()},sizeChange:function(e){this.searchParams.pageSize=e,this.load()},showAddView:function(){this.dialogTitle="添加",this.dialogVisible=!0},showEditView:function(e){var t=this;this.tableLoading=!0,this.getRequest("/integral/"+e.id).then(function(e){t.integral=e.data.data}),this.tableLoading=!1,this.dialogTitle="编辑",this.dialogVisible=!0},tableSortChange:function(e){"descending"===e.order?this.searchParams.orderBy=e.prop+" DESC":this.searchParams.orderBy=e.prop+" ASC",this.load()}},mounted:function(){this.load()}},r={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-container",[a("h2",[e._v("项目积分表")]),e._v(" "),a("el-header",[a("div",[e._v("\n        项目："),a("el-input",{staticStyle:{width:"200px"},attrs:{clearable:"",size:"mini"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.search(t)}},model:{value:e.searchParams.label,callback:function(t){e.$set(e.searchParams,"label",t)},expression:"searchParams.label"}}),e._v(" "),a("el-button",{attrs:{type:"primary",size:"mini",icon:"el-icon-search"},on:{click:e.search}},[e._v("搜索")]),e._v(" "),a("el-button",{attrs:{type:"success",size:"mini",icon:"el-icon-plus"},on:{click:function(t){return e.showAddView()}}},[e._v("添加")])],1)]),e._v(" "),a("el-main",[a("div",[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],attrs:{data:e.integrals,size:"mini",border:"","default-sort":{prop:"value",order:"descending"},height:"600"},on:{"sort-change":e.tableSortChange}},[a("el-table-column",{attrs:{align:"center",width:"50",label:"序号",type:"index"}}),e._v(" "),a("el-table-column",{attrs:{align:"center",width:"500px",prop:"label",label:"项目",sortable:"custom"}}),e._v(" "),a("el-table-column",{attrs:{align:"center",width:"200px",prop:"value",label:"积分",sortable:"custom"}}),e._v(" "),a("el-table-column",{attrs:{align:"center",width:"1000px",prop:"remark",label:"备注"}}),e._v(" "),a("el-table-column",{attrs:{align:"center",width:"200",label:"操作",fixed:"right"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(a){return e.showEditView(t.row)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(a){return e.del(t.row)}}},[e._v("删除")])]}}])})],1),e._v(" "),a("br"),e._v(" "),a("div",{staticStyle:{"justify-content":"space-between"}},[a("el-pagination",{staticStyle:{"text-align":"center"},attrs:{background:"","page-sizes":e.sizes,"page-size":e.searchParams.pageSize,"current-page":e.searchParams.pageNum,layout:"sizes, prev, pager, next, jumper, ->, total",total:e.total},on:{"size-change":e.sizeChange,"current-change":e.currentChange}})],1)],1)])],1),e._v(" "),a("integralForm",{attrs:{dialogTitle:e.dialogTitle,dialogVisible:e.dialogVisible,integral:e.integral},on:{colseForm:e.colseForm}})],1)},staticRenderFns:[]};var s=a("VU/8")(n,r,!1,function(e){a("lVaH")},null,null);t.default=s.exports},lVaH:function(e,t){}});
//# sourceMappingURL=2.546437b03cd7b82b8d69.js.map