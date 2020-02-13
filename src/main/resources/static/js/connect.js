function login() {
  axios.get("/public/login", {params: {username: this.username, password: this.password,}}).then(res => {
    if (res.data === true) {
      alert('登陆成功!');
      window.location.replace('/index.html');
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

function getPage(url) {
  self = this;
  axios.get(url).then(res => {
    this.list.data = res.data.content;
    this.page.totalPage = res.data.totalPages;
    this.page.totalRow = res.data.totalElements;
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

function getData(url) {
  self = this;
  axios.get(url).then((res => {
    this.selectForm = res.data;
  }));
}

function Submit(url) {
  axios.get(url).then(res => {
    if (res.data === true) {
      alert('操作成功');
    } else if(res.data===false) {
      alert('操作失败');
    }else {
      alert(res.data)
    }
    window.location.replace('./index.html');
  });
}