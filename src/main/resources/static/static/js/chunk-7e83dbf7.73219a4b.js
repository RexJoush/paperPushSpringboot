(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7e83dbf7"],{"886f":function(t,e,a){"use strict";a("baac")},ac67:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[t._v("进展情况")]),a("el-button",{staticStyle:{float:"right"},attrs:{type:"warning"},on:{click:function(e){t.dialogDeadlineVisible=!0,t.updateDate=t.deadlineDate}}},[t._v("修改截止日期")]),a("el-button",{staticStyle:{float:"right","margin-right":"10px"},attrs:{type:"primary"},on:{click:function(e){t.dialogTargetVisible=!0,t.updateDate=t.deadlineDate}}},[t._v("修改目标字数")])],1),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:6,offset:4}},[a("div",[a("el-statistic",{attrs:{value:t.moreThanLastTime,title:t.title}},[a("template",{slot:"prefix"},[a("i",{staticClass:"el-icon-s-flag",staticStyle:{color:"red"}})]),a("template",{slot:"formatter"},[t._v(" "+t._s(t.moreThanLastTime.toFixed(0))+" 字 ")])],2)],1)]),a("el-col",{attrs:{span:6}},[a("div",[a("el-statistic",{attrs:{value:t.deadline,format:"HH 小时 mm 分钟 ss 秒","time-indices":""}},[a("template",{slot:"title"},[t._v(" 论文上交 Deadline "),a("span",{staticStyle:{color:"orangered"}},[t._v(t._s(t.deadlineDate))])]),a("template",{slot:"prefix"},[a("i",{staticClass:"el-icon-alarm-clock",staticStyle:{color:"red"}})])],2)],1)])],1),a("el-divider",{attrs:{"content-position":"left"}},[t._v("百分比")]),a("el-row",[a("el-col",{attrs:{span:13}},[a("div",[a("el-progress",{attrs:{"text-inside":!0,color:"#3E6D9C","stroke-width":26,"text-color":"#FD841F",percentage:t.percentage}})],1)]),a("el-col",{attrs:{span:3}},[a("el-statistic",{staticStyle:{color:"#FD841F"}},[a("template",{slot:"title"},[t._v(" "+t._s(t.now)+" / "+t._s(t.target)+" ")])],2)],1)],1)],1),a("el-row",[a("el-col",{attrs:{span:24}},[a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[t._v("我的论文进展")])]),a("div",{ref:"chart",staticStyle:{height:"500px",width:"100%"}})])],1)],1),a("el-dialog",{attrs:{title:"修改截至日期",visible:t.dialogDeadlineVisible,width:"30%"},on:{"update:visible":function(e){t.dialogDeadlineVisible=e}}},[a("el-form",[a("el-form-item",{attrs:{label:"截至日期"}},[a("el-date-picker",{attrs:{format:"yyyy-MM-dd","value-format":"yyyy-MM-dd",type:"date",placeholder:"选择日期"},model:{value:t.updateDate,callback:function(e){t.updateDate=e},expression:"updateDate"}})],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogDeadlineVisible=!1}}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:t.submitUpdateDeadline}},[t._v("确 定")])],1)],1),a("el-dialog",{attrs:{title:"修改目标字数",visible:t.dialogTargetVisible,width:"30%"},on:{"update:visible":function(e){t.dialogTargetVisible=e}}},[a("el-form",[a("el-form-item",{attrs:{label:"目标字数"}},[a("el-input",{attrs:{type:"number","suffix-icon":"el-icon-circle-plus"},model:{value:t.target,callback:function(e){t.target=e},expression:"target"}})],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogTargetVisible=!1}}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:t.submitUpdateTarget}},[t._v("确 定")])],1)],1)],1)},s=[],l=a("b775"),r=a("99b1");function o(){return Object(l["a"])({url:r["a"]+"/statistics/initMyGraph",method:"get"})}function n(t){return Object(l["a"])({url:r["a"]+"/statistics/updateDeadline",method:"get",params:{deadline:t}})}function d(t){return Object(l["a"])({url:r["a"]+"/statistics/updateTarget",method:"get",params:{target:t}})}var c={data:function(){return{like:!0,percentage:0,title:"相比于上次多写了",moreThanLastTime:0,deadline:"",deadlineDate:"",updateDate:"",now:0,target:0,dialogDeadlineVisible:!1,dialogTargetVisible:!1}},mounted:function(){this.init()},methods:{submitUpdateDeadline:function(){var t=this;n(this.updateDate).then((function(e){2e4===e.code?(t.$message.success(e.message),t.init()):t.$message.error(e.message),t.dialogDeadlineVisible=!1,t.mounted()}))},submitUpdateTarget:function(){var t=this;d(this.target).then((function(e){2e4===e.code?(t.$message.success(e.message),t.init()):t.$message.error(e.message),t.dialogTargetVisible=!1,t.mounted()}))},init:function(){var t=this;o().then((function(e){console.log(e);var a=0;e.data.series.length<1?t.moreThanLastTime=0:e.data.series.length<2?(t.moreThanLastTime=e.data.series[0],a=e.data.series.at(-1)):(t.moreThanLastTime=e.data.series.at(-1)-e.data.series.at(-2),a=e.data.series.at(-1)),t.now=a,t.percentage=a/e.data.target*100,t.target=e.data.target,t.deadlineDate=e.data.deadline,t.deadline=new Date(e.data.deadline).getTime();var i=t.$refs.chart;if(i){var s=t.$echarts.init(i),l={tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},grid:{left:"3%",right:"4%",bottom:"3%",containLabel:!0},xAxis:[{type:"category",data:e.data.xAxis,axisTick:{alignWithLabel:!0}}],yAxis:[{type:"value"}],series:[{name:"字数",type:"bar",barWidth:"60%",data:e.data.series}]};s.setOption(l,null,{renderer:"svg"})}}))}}},u=c,g=(a("886f"),a("2877")),p=Object(g["a"])(u,i,s,!1,null,"1c06e748",null);e["default"]=p.exports},baac:function(t,e,a){}}]);