'use strict';
// login
let password = '', username = '', message = '', id = '';

// 通用
const statistics = {}, counts = {};
const selectForm = {};
const list = {"data": []};
const page = {
  "_currPage": 0,
  "_showPage": 1,
  "totalPage": 0,
  "totalRow": 0,
  "pageSize": 20,
  set currPage(val) {
    if (val >= 0 && val < this.totalPage) {
      this._currPage = val;
      this._showPage = val + 1;
    }
  },
  set showPage(val) {
    this._showPage = val;
    this._currPage = val - 1;
  },
  get showPage() {
    return this._showPage;
  },
  get currPage() {
    return this._currPage;
  },
  get firstRow() {
    return this.pageSize * this._currPage + 1;
  },
  get lastRow() {
    if (this.pageSize * (this._currPage + 1) > this.totalRow)
      return this.totalRow;
    return this.pageSize * (this._currPage + 1);
  },
};
//table1


const table1Titles = ['姓名', '楼号', '单元', '房号', '面积', '交费至', '减免金额', '5月1日交费', '押金', '押金抵费',
  '退款金额', '物业费1', '物业费2', '物业费3', '数值备注', '文字备注', '操作'];

// table2
const table2Titles = ['姓名', '楼号', '单元号', '房间号', '面积', '交费至', '退款日期', '退款姓名', '退款金额', '退款状态',
  '垃圾清运费', '物业费1', '物业费2', '物业费3', '数字备注', '文字备注', '操作'];
const table3Titles = ['姓名', '楼号', '单元号', '房间号', '面积', '交费至', '退款日期', '退款姓名', '退款金额', '退款状态',
  '物业费1', '物业费2', '物业费3', '数字备注', '文字备注', '操作'];
// admin
let title = '', info = {id: '', username: '', password: '',};

// 获取url中的值
function getUrl(key) {
  let vars = window.location.search.substring(1).split('&');
  return getVariable(vars, key);
}

// 获取cookie中的值
function getCookie(key) {
  let vars = document.cookie.split('; ');
  return getVariable(vars, key);
}

// 获取字符串中的参数
function getVariable(vars, key) {
  for (let i = 0; i < vars.length; i++) {
    let pair = vars[i].split("=");
    if (pair[0] === key) {
      return pair[1];
    }
  }
  return false;
}

// object转url字符串
function urlEncoding(object) {
  let ret = '';
  for (let i in object) {
    if (eval('object.' + i) !== null && eval('object.' + i) !== undefined && eval('object.' + i) !== '') {
      ret = ret + '&' + i + '=' + eval("object." + i);
    }
  }
  return ret;
}

function urlEncoding2(object) {
  let ret = '';
  for (let i in object) {
    if (eval('object.' + i) !== null && eval('object.' + i) !== undefined && eval('object.' + i) !== '') {
      ret = ret + '&' + i + '=' + eval("object." + i);
    }
  }
  ret = ret.replace('&', '?');
  return ret;
}