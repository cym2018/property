'use strict';
// login
let password = '', username = '', usernameValidation, passwordValidation, message = '';

function usernameVF(newVal) {
  this.usernameValidation = StringTest(newVal);
}

function passwordVF(newVal) {
  this.passwordValidation = StringTest(newVal);
}

function StringTest(input) {
  // noinspection JSConstructorReturnsPrimitive
  return (/^[A-Za-z0-9]{1,15}$/.test(input)) ? "√" : "×请输入1-15位数字或字母";
}

// 通用
const statistics = {};
let id;
const list = {"data": []};
const page = {
  "_currPage": 0,
  "_showPage": 1,
  "totalPage": 0,
  "totalRow": 0,
  "pageSize": 30,
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
const table1SelectForm = {
  "name": '', "buildingNumber": "", "unitNumber": "", "roomNumber": "", "area": "", "depositToCost": "",
  "paidForTime": "", "wechatPay": "", "moneyPay": "", "unionPay": "", "refundName": "", "refundAccount": "",
  "refundNumber": "", "breaks": "", "paidAt51": "", "depsit": "", "garbageRate": "", "waterRate": "",
  "col": "", "note": "",
};

const table1Titles = ['姓名', '楼号', '单元', '房号', '面积', '交费至', '减免金额', '5月1日交费', '押金', '押金抵费',
  '微信支付', '现金支付', '银联支付', '退款金额', '备注1', '备注2', '操作'];

// table2
const table2Titles = ['姓名', '楼号', '单元号', '房间号', '面积', '交费至', '退款日期', '退款姓名', '退款金额', '退款状态',
  '垃圾清运费', '物业费1', '物业费2', '交费方式2', '物业费3', '交费方式3', '数字备注', '文字备注', '操作'];
const table2SelectForm = {
  "id": '', "name": '', "buildingNumber": '', "unitNumber": '', "roomNumber": '', "area": '', "refundDate": '',
  "refundName": '', "refundNumber": '', "depositState": '', "garbage": '', "property1": '', "paidForTime": '',
  "property2": '', "property3": '', "paidBy2": '', "paidBy3": '', "numberNote": '', "textNote": '',
};

// admin
let title = '', info = {id: '', username: '', password: '',};


// 通用

// 实体对象
const userInfo = {
  "id": '', "name": '', "buildingNumber": '', "unitNumber": '', "roomNumber": '', "paidForTime": '', "area": '',
  "textNote1": '', "textNote2": '', "numberNote1": '', "numberNote2": '',
  clear() {
    this.buildingNumber = '';
    this.unitNumber = '';
    this.roomNumber = '';
  },
};
const timeScope = {
  "startDate": '', "endDate": '',
  clear() {
    this.startDate = '';
    this.endDate = '';
  }
};
const recodeInfo = {"id": 0, "title": '', "date": '', "paidWay": '', "amount": '', "note": '',};


// 函数

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
    ret = ret + '&' + i + '=' + ((eval("object." + i) === null || eval("object." + i) === undefined) ? '' : eval("object." + i));
  }
  return ret;
}