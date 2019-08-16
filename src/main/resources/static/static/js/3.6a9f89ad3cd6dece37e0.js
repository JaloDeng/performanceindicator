webpackJsonp([3],{"5+9p":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l={data:function(){return{employeeOptions:[]}},methods:{changeIntegralOption:function(e){for(var t=0;t<this.integrals.length;t++){var a=this.integrals[t];if(a.id===e){this.employeeIntegral.integralValue=a.value;break}}},colseForm:function(){this.$emit("colseForm")},getEmployeeOptions:function(){var e=this;this.getRequest("/employee").then(function(t){if(t.data&&t.data.data)for(var a=t.data.data,l=0;l<a.length;l++){var n=a[l];e.employeeOptions.push({label:n.name,value:n.id})}})},save:function(e){var t=this;this.putRequest("/employee/integral",this.employeeIntegral).then(function(e){t.colseForm()})}},mounted:function(){this.getEmployeeOptions()},props:{dialogTitle:String,dialogVisible:Boolean,employeeIntegral:Object,integrals:Array,integralOptions:Array}},n={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{title:e.dialogTitle,"close-on-click-modal":!1,visible:e.dialogVisible,"before-close":e.colseForm,width:"50%",center:""},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-form",{ref:"saveForm",attrs:{model:e.employeeIntegral}},[a("el-row",{attrs:{type:"flex"}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"参与者","label-width":"120px"}},[a("el-select",{attrs:{size:"mini"},model:{value:e.employeeIntegral.employeeId,callback:function(t){e.$set(e.employeeIntegral,"employeeId",t)},expression:"employeeIntegral.employeeId"}},e._l(e.employeeOptions,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex"}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"项目","label-width":"120px"}},[a("el-select",{attrs:{size:"mini"},on:{change:e.changeIntegralOption},model:{value:e.employeeIntegral.integralId,callback:function(t){e.$set(e.employeeIntegral,"integralId",t)},expression:"employeeIntegral.integralId"}},e._l(e.integralOptions,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex"}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"积分","label-width":"120px"}},[a("el-input",{staticStyle:{width:"200px"},attrs:{type:"number",size:"mini",readonly:!0},model:{value:e.employeeIntegral.integralValue,callback:function(t){e.$set(e.employeeIntegral,"integralValue",t)},expression:"employeeIntegral.integralValue"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex"}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"时间","label-width":"120px"}},[a("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"datetime",size:"mini","value-format":"yyyy-MM-dd HH:mm:ss"},model:{value:e.employeeIntegral.integralTime,callback:function(t){e.$set(e.employeeIntegral,"integralTime",t)},expression:"employeeIntegral.integralTime"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex"}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"备注","label-width":"120px"}},[a("el-input",{attrs:{type:"textarea",rows:"5",size:"mini",placeholder:"请输入备注"},model:{value:e.employeeIntegral.remark,callback:function(t){e.$set(e.employeeIntegral,"remark",t)},expression:"employeeIntegral.remark"}})],1)],1)],1)],1),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.save("saveForm")}}},[e._v("保存")]),e._v(" "),a("el-button",{attrs:{size:"mini"},on:{click:e.colseForm}},[e._v("取消")])],1)],1)},staticRenderFns:[]};var i=a("VU/8")(l,n,!1,function(e){a("hhj/")},null,null).exports,r=a("mtWM"),o=a.n(r),s={components:{employeeIntegralForm:i},data:function(){return{employeeStatusOptions:[{label:"全部",value:""}],dialogTitle:"",dialogVisible:!1,employeeIntegral:{id:"",employeeId:"",integralId:"",integralTime:"",integralValue:"",remark:"",createUser:"",createTime:"",updateUser:"",updateTime:"",name:"",label:""},employees:[],employeeIntegrals:[],employeeOptions:[],integrals:[],integralOptions:[],integralTime:[],searchParams:{employeeIds:[],employeeStatus:"",integralIds:[],integralEndTime:"",integralStartTime:"",orderBy:"",pageNum:1,pageSize:20},sizes:[20,50,100],tableLoading:!1,total:1}},methods:{changeEmployeeStatusOption:function(){this.employeeOptions=[],this.getEmployeeOptions(),this.load()},colseForm:function(){this.dialogVisible=!1,this.emptyData(),this.load()},currentChange:function(e){this.searchParams.pageNum=e,this.load()},del:function(e){var t=this;this.$confirm("此操作将永久删除["+e.name+" : "+e.label+" : "+e.integralTime+"]，是否继续？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.deleteRequest("/employee/integral/"+e.id).then(function(e){e&&200===e.status&&e.data.success&&t.load()})}).catch(function(){})},emptyData:function(){this.employeeIntegral={id:"",employeeId:"",integralId:"",integralTime:"",integralValue:"",remark:"",createUser:"",createTime:"",updateUser:"",updateTime:"",name:"",label:""}},exportExcel:function(){o.a.post("/employee/integral/export/excel",this.searchParams,{responseType:"blob"}).then(function(e){var t=new Blob([e.data],{type:"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"}),a=document.createElement("downloadExcel");a.href=window.URL.createObjectURL(t),a.download="pi.xlsx",a.click(),window.URL.revokeObjectURL(a.href)})},getEmployeeOptions:function(){var e=this;this.getRequest("/employee",{status:e.searchParams.employeeStatus}).then(function(t){if(t.data&&t.data.data){e.employees=t.data.data;for(var a=0;a<e.employees.length;a++){var l=e.employees[a];e.employeeOptions.push({label:l.name,value:l.id})}}})},getEmployeeStatusOptions:function(){var e=this;this.getRequest("/enum/active").then(function(t){t.data&&t.data.data&&(e.employeeStatusOptions=e.employeeStatusOptions.concat(t.data.data))})},getIntegralOptions:function(){var e=this;this.getRequest("/integral").then(function(t){if(t.data&&t.data.data){e.integrals=t.data.data;for(var a=0;a<e.integrals.length;a++){var l=e.integrals[a];e.integralOptions.push({label:l.label,value:l.id})}}})},integralSearchTimeChange:function(){var e=this.integralTime;e&&e.length>0?(this.searchParams.integralStartTime=e[0],this.searchParams.integralEndTime=e[1]):(this.searchParams.integralStartTime="",this.searchParams.integralEndTime=""),this.load()},load:function(){var e=this,t=this;this.tableLoading=!0,this.postRequest("/employee/integral",t.searchParams).then(function(a){e.tableLoading=!1,t.total=a.data.total,t.employeeIntegrals=a.data.data})},search:function(){this.searchParams.pageNum=1,this.load()},sizeChange:function(e){this.searchParams.pageSize=e,this.load()},showAddView:function(){this.dialogTitle="添加",this.dialogVisible=!0},showEditView:function(e){var t=this;this.tableLoading=!0,this.getRequest("/employee/integral/"+e.id).then(function(e){t.employeeIntegral=e.data.data}),t.tableLoading=!1,t.dialogTitle="编辑",t.dialogVisible=!0},tableSortChange:function(e){"descending"===e.order?this.searchParams.orderBy=e.prop+" DESC":this.searchParams.orderBy=e.prop+" ASC",this.load()}},mounted:function(){this.getEmployeeOptions(),this.getEmployeeStatusOptions(),this.getIntegralOptions()}},c={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-container",[a("el-main",{staticStyle:{padding:"0px"}},[[e._v("\n        参与者状态：\n        "),a("el-select",{staticStyle:{width:"100px"},attrs:{size:"mini"},on:{change:e.changeEmployeeStatusOption},model:{value:e.searchParams.employeeStatus,callback:function(t){e.$set(e.searchParams,"employeeStatus",t)},expression:"searchParams.employeeStatus"}},e._l(e.employeeStatusOptions,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1),e._v("\n        参与者：\n        "),a("el-select",{attrs:{multiple:"","collapse-tags":"",size:"mini"},on:{change:e.search},model:{value:e.searchParams.employeeIds,callback:function(t){e.$set(e.searchParams,"employeeIds",t)},expression:"searchParams.employeeIds"}},e._l(e.employeeOptions,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1),e._v("\n        项目：\n        "),a("el-select",{attrs:{multiple:"","collapse-tags":"",size:"mini"},on:{change:e.search},model:{value:e.searchParams.integralIds,callback:function(t){e.$set(e.searchParams,"integralIds",t)},expression:"searchParams.integralIds"}},e._l(e.integralOptions,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1),e._v("\n        获取时间：\n        "),a("el-date-picker",{staticStyle:{width:"320px"},attrs:{type:"datetimerange","range-separator":"-",format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",size:"mini","start-placeholder":e.searchParams.integralStartTime,"end-placeholder":e.searchParams.integralEndTime},on:{change:e.integralSearchTimeChange},model:{value:e.integralTime,callback:function(t){e.integralTime=t},expression:"integralTime"}}),e._v(" "),a("el-button",{attrs:{type:"primary",size:"mini",icon:"el-icon-search"},on:{click:e.search}},[e._v("搜索")]),e._v(" "),a("el-button",{attrs:{type:"warning",size:"mini",icon:"el-icon-download"},on:{click:e.exportExcel}},[e._v("导出")]),e._v(" "),a("el-button",{attrs:{type:"success",size:"mini",icon:"el-icon-plus"},on:{click:function(t){return e.showAddView()}}},[e._v("添加")])],e._v(" "),a("br",{staticStyle:{"line-height":"40px"}}),e._v(" "),[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],attrs:{data:e.employeeIntegrals,size:"mini",border:"","default-sort":{prop:"integralTime",order:"descending"},height:"600"},on:{"sort-change":e.tableSortChange}},[a("el-table-column",{attrs:{align:"center",width:"50",label:"序号",type:"index"}}),e._v(" "),a("el-table-column",{attrs:{align:"center",width:"200px",prop:"integralTime",label:"获取时间",sortable:"custom"}}),e._v(" "),a("el-table-column",{attrs:{align:"center",width:"200px",prop:"name",label:"姓名",sortable:"custom"}}),e._v(" "),a("el-table-column",{attrs:{align:"center",width:"200px",prop:"label",label:"项目",sortable:"custom"}}),e._v(" "),a("el-table-column",{attrs:{align:"center",width:"200px",prop:"integralValue",label:"积分",sortable:"custom"}}),e._v(" "),a("el-table-column",{attrs:{align:"center",width:"800px",prop:"remark",label:"备注"}}),e._v(" "),a("el-table-column",{attrs:{align:"center",width:"200",label:"操作",fixed:"right"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(a){return e.showEditView(t.row)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(a){return e.del(t.row)}}},[e._v("删除")])]}}])})],1),e._v(" "),a("br"),e._v(" "),a("div",{staticStyle:{"justify-content":"space-between"}},[a("el-pagination",{staticStyle:{"text-align":"center"},attrs:{background:"","page-sizes":e.sizes,"page-size":e.searchParams.pageSize,"current-page":e.searchParams.pageNum,layout:"sizes, prev, pager, next, jumper, ->, total",total:e.total},on:{"size-change":e.sizeChange,"current-change":e.currentChange}})],1)]],2)],1),e._v(" "),a("employeeIntegralForm",{attrs:{dialogTitle:e.dialogTitle,dialogVisible:e.dialogVisible,employeeIntegral:e.employeeIntegral,integralOptions:e.integralOptions,integrals:e.integrals},on:{colseForm:e.colseForm}})],1)},staticRenderFns:[]};var m=a("VU/8")(s,c,!1,function(e){a("RVb/")},null,null);t.default=m.exports},"RVb/":function(e,t){},"hhj/":function(e,t){}});
//# sourceMappingURL=3.6a9f89ad3cd6dece37e0.js.map