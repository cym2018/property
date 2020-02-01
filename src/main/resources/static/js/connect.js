// login
function loginF() {
  axios.get("/public/login", {params: {username: this.username, password: this.password,}}).then(res => {
    if (res.data === true) {
      alert('登陆成功!');
      window.location.replace('/');
    } else {
      alert('登陆失败:用户名或密码不正确!');
    }
  });
}

// index
function logout() {
  axios.get('/public/logout').then(res => {
    if (res.data === true) {
      alert('退出成功!');
      window.location.replace('/');
    } else {
      alert('操作失败!');
    }
  });
}

// table1
function getTable1Page() {
  getPage('/visit/table1/query',
      {
        pageSize: page.pageSize,
        pageNumber: page.currPage,
        name: selectForm.name,
        buildingNumber: selectForm.buildingNumber,
        unitNumber: selectForm.unitNumber,
        roomNumber: selectForm.roomNumber,
        area: selectForm.area,
        depositToCost: selectForm.depositToCost,
        paidForTime: selectForm.paidForTime,
        wechatPay: selectForm.wechatPay,
        moneyPay: selectForm.moneyPay,
        unionPay: selectForm.unionPay,
        refundName: selectForm.refundName,
        refundAccount: selectForm.refundAccount,
        refundNumber: selectForm.refundNumber,
        breaks: selectForm.breaks,
        paidAt51: selectForm.paidAt51,
        depsit: selectForm.depsit,
        garbageRate: selectForm.garbageRate,
        waterRate: selectForm.waterRate,
        col: selectForm.col,
        note: selectForm.note,
      },
      {list, page,}
  );
}

function getTable1Data(id) {
  self = this;
  axios.get('/visit/table1/query', {params: {id: id}}).then((res => {
    this.selectForm = res.data;
  }));
}

function table1Submit() {
  self = this;
  axios.get('/admin/table1/save?id=' + this.id + urlEncoding(this.selectForm)).then(res => {
    alert(res.data);
    window.location.replace("./index.html");
  });
}

// admin
function getAdminData(info) {
  self = this;
  axios.get('/admin/query?id=' + info.id).then(res => {
    info.username = res.data.username;
    info.password = res.data.password;
  });
}

function adminSubmit() {
  self = this;
  axios.get('/admin/save', {
    params: {
      id: this.info.id,
      username: this.info.username,
      password: this.info.password
    }
  }).then(res => {
    if (res.data === true) {
      alert(this.title + '成功');
    } else {
      alert(this.title + '失败');
    }
  });
}
function getList(url, params, ret) {
  axios.get(url, {params: params}).then(res => {
    console.log(res);
    // if(ret.data==='')
    ret.data = res.data;
  });
}

// 公共
function getPage(url, params, ret) {
  axios.get(url, {params: params,}).then(res => {
    ret.list.data = res.data.content;
    ret.page.totalPage = res.data.totalPages;
    ret.page.totalRow = res.data.totalElements;
  });
}



