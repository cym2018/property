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

//table1
const selectForm = {
  "name": "",
  "buildingNumber": "",
  "unitNumber": "",
  "roomNumber": "",
  "area": "",
  "depositToCost": "",
  "paidForTime": "",
  "wechatPay": "",
  "moneyPay": "",
  "unionPay": "",
  "refundName": "",
  "refundAccount": "",
  "refundNumber": "",
  "breaks": "",
  "paidAt51": "",
  "depsit": "",
  "garbageRate": "",
  "waterRate": "",
  "col": "",
  "note": "",
};


// admin
let title = '', info = {
  id: '',
  username: '',
  password: '',
};


// 通用
let id;
// 实体对象
const userInfo = {
  "id": '',
  "name": '',
  "buildingNumber": '',
  "unitNumber": '',
  "roomNumber": '',
  "paidForTime": '',
  "area": '',
  "textNote1": '',
  "textNote2": '',
  "numberNote1": '',
  "numberNote2": '',
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
const recodeInfo = {
  "id": 0,
  "title": '',
  "date": '',
  "paidWay": '',
  "amount": '',
  "note": '',
};
// 数据表
const list = {"data": []};
// 分页
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
  for (let i in selectForm) {
    ret = ret + '&' + i + '=' + (eval("object." + i) === null ? '' : eval("object." + i));
  }
  return ret;
}