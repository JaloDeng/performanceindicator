webpackJsonp([3],{NHnr:function(e,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=s("7+uW"),n={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var r=s("VU/8")({name:"App"},n,!1,function(e){s("qf9G")},null,null).exports,o=s("/ocq");a.default.use(o.a);var u=new o.a({mode:"history",routes:[{path:"/home",name:"Home",component:function(){return s.e(0).then(s.bind(null,"lO7g"))}},{path:"/",name:"integral",component:function(){return s.e(1).then(s.bind(null,"0XdB"))}}]}),p=s("zL8q"),c=s.n(p),d=(s("tvR6"),s("mtWM")),i=s.n(d),l="";l="https://test.jalo.net.cn",i.a.defaults.timeout=1e4,i.a.interceptors.request.use(function(e){return e},function(){p.Message.error({message:"请求超时!"})}),i.a.interceptors.response.use(function(e){return e.status&&200===e.status&&(e.data&&e.data.success&&e.data.message?p.Message.success({message:e.data.message}):e.data&&!e.data.success&&e.data.message&&p.Message.error({message:e.data.message})),e},function(e){504===e.response.status?p.Message.error({message:"服务器异常"}):404===e.response.status?p.Message.error({message:"请求不存在"}):403===e.response.status?p.Message.error({message:"权限不足,请联系管理员!"}):p.Message.error({message:"未知错误!"})});a.default.config.productionTip=!1,a.default.use(c.a),a.default.prototype.getRequest=function(e,t){return i()({method:"get",params:t,url:""+l+e})},a.default.prototype.postRequest=function(e,t){return i()({method:"post",url:""+l+e,data:t,headers:{"Content-Type":"application/json;charset=UTF-8"}})},a.default.prototype.deleteRequest=function(e){return i()({method:"delete",url:""+l+e})},a.default.prototype.putRequest=function(e,t){return i()({method:"put",url:""+l+e,data:t,headers:{"Content-Type":"application/json;charset=UTF-8"}})},new a.default({el:"#app",router:u,components:{App:r},template:"<App/>"})},qf9G:function(e,t){},tvR6:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.abe9ebf09c569c167679.js.map