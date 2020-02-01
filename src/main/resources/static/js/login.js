let password = '', username = '', usernameValidation, passwordValidation;

function usernameVF(newVal) {
  this.usernameValidation = Test(newVal);
}

function passwordVF(newVal) {
  this.passwordValidation = Test(newVal);
}

function Test(input) {
  // noinspection JSConstructorReturnsPrimitive
  return (/^[A-Za-z0-9]{1,15}$/.test(input)) ? "√" : "×请输入1-15位数字或字母";
}

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