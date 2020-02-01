'use strict';
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
  "totalPage": 0,
  "totalRow": 0,
  "pageSize": 30,
  set currPage(val) {
    if (val >= 0 && val < this.totalPage)
      this._currPage = val;
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

// 获取url中的参数
function getVariable(key) {
  let vars = window.location.search.substring(1).split("&"); //获取参数
  for (let i = 0; i < vars.length; i++) {
    let pair = vars[i].split("=");
    if (pair[0] === key) {
      return pair[1];
    }
  }
  return false;
}

function getPage(url, params, ret) {
  axios.get(url, {params: params,}).then(res => {
    ret.list.data = res.data.content;
    ret.page.totalPage = res.data.totalPages;
    ret.page.totalRow = res.data.totalElements;
  });
}

function getList(url, params, ret) {
  axios.get(url, {params: params}).then(res => {
    ret.data = res.data;
  });
}
