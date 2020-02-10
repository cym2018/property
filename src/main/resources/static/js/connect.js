// public
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
function getTablePage(tableName) {
  self = this;
  axios.get('/visit/table' + tableName + '/query?pageSize=' + this.page.pageSize + '&pageNumber=' + this.page.currPage + urlEncoding(this.selectForm)).then(res => {
    this.list.data = res.data.content;
    this.page.totalPage = res.data.totalPages;
    this.page.totalRow = res.data.totalElements;
  });
}

function getTableData(tableName) {
  self = this;
  axios.get('/visit/table' + tableName + '/query?id=' + this.id).then((res => {
    this.selectForm = res.data;
  }));
}

function tableSubmit(tableName) {
  self = this;
  axios.get('/admin/table' + tableName + '/save?id=' + this.id + urlEncoding(this.selectForm)).then(res => {
    alert(res.data);
    window.location.replace("./index.html");
  });
}

function getTableStatistics(tableName) {
  self = this;
  axios.get('/visit/table' + tableName + '/statistics?info=' + urlEncoding(this.selectForm)).then(res => {
    this.statistics = res.data;
    this.statistics.name = '合计';
  })
}

function getTableCounts(tableName) {
  self = this;
  axios.get('/visit/table' + tableName + '/counts?info=' + urlEncoding(this.selectForm)).then(res => {
    this.counts = res.data;
    this.counts.name = '非空行数';
  })
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


// 公共
function getList(url, params, ret) {
  axios.get(url, {params: params}).then(res => {
    ret.data = res.data;
  });
}

function getPage(url, params, ret) {
  axios.get(url, {params: params,}).then(res => {
    ret.list.data = res.data.content;
    ret.page.totalPage = res.data.totalPages;
    ret.page.totalRow = res.data.totalElements;
  });
}



