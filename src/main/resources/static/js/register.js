var f = true;
function trip(obj, trip) {
    if (trip === "OK!!") {
        document.getElementById(obj).innerHTML = "<b class ='trip_ok'>" + trip + "</b>";
    } else {
        document.getElementById(obj).innerHTML = "<b class ='trip_error'>" + trip + "</b>";
    }

}
let nametype = true;
function checkName() {

    //获取用户名输入项
    var userNname = document.getElementById("userNname");
    var uName = userNname.value;
    if (uName.length < 4 || uName.length > 10) {
        trip("name_trip", "长度为4-10位");
        nametype = false;
        return;
    } else {
        nametype = true;
        trip("name_trip", "OK!!");
    }
}
let passwordtype = true;
function checkPassword() {
    //密码长度大于6 和确认必须一致 
    var password = document.getElementById("password");
    var userPass = password.value;
    //获取确认密码框的值 var
    var surePassword = document.getElementById("surePassword");
    var surePass = surePassword.value;

    if (userPass.length < 6) {
        trip("password_trip", "密码要>=6位!!");
        passwordtype = false;
        return;
    } else {
        passwordtype = true;
        trip("password_trip", "OK!!");
    }
    if (userPass != surePass) {
        trip("surePassword_trip", "密码不一致!!");
        passwordtype = false;
        return;
    } else {
        passwordtype = true;
        trip("surePassword_trip", "OK!!");
    }
}
let sex_type = true
function checkSex() {
    var sexNum = document.getElementsByName("gender");
    var sex = "";
    for (let i = 0; i < sexNum.length; ++i) {
        if (sexNum[i].checked) {
            sex = sexNum[i];
        }
    }
    if (sex == "") {
        sex_type = false;
        trip("sex_trip", "不能为空!!");
        return;
    } else {
        sex_type = true
        trip("sex_trip", "OK!!");
    }
}
let date_type = true
function checkDate() {
    var birthday = document.getElementById("birthday").value;
    if (birthday == "") {
        date_type = false;
        trip("birthday_trip", "不能为空!!");
        return;
    } else {
        date_type = true
        trip("birthday_trip", "OK!!");
    }
}
let hobby_type = true
function checkHobby() {
    var hobbyNum = document.getElementsByName("hobby");
    var hobby = "";
    for (let i = 0; i < hobbyNum.length; ++i) {
        if (hobbyNum[i].checked) {
            hobby = hobbyNum[i];
        }
    }
    if (hobby == "") {
        hobby_type = false;
        trip("hobby_trip", "不能为空!!");
        return;
    } else {
        hobby_type = true
        trip("hobby_trip", "OK!!");

    }
}
let email_type = true
function checkEmail() {
    //校验邮箱:/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/
    var inputEmail = document.getElementById("email");
    var uEmail = inputEmail.value;
    if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/.test(uEmail)) {
        email_type = false;
        trip("emil_trip", "邮箱不合法!!");
        return;
    } else {
        email_type = true
        trip("emil_trip", "OK!!");
    }
}
let select_type = true
function checkSelect() {
    var myselect = document.getElementById("userType");
    var index = myselect.selectedIndex;
    var checkValue = myselect.options[index].value;
    if (checkValue == 0) {
        select_type = false;
        trip("type_trip", "请选择!!");
        return;
    } else {
        select_type = true
        trip("type_trip", "OK!!");
    }
}
let text_type = true
function checkText() {
    // 校验自我介绍
    var introduceText = document.getElementById("introduceText");
    var introduce = introduceText.value;
    if (introduce.length < 3 || introduce.length > 50) {
        text_type = false;
        trip("introduce_trip", "长度为3-50字!!");
        return;
    } else {
        text_type = true
        trip("introduce_trip", "OK!!");
    }
}

