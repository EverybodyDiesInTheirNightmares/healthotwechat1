$(document).ready(function () {
    $.ajax({
        type:"GET",
        dataType:"json",
        url:"/user/isLogin",
        success:function (result) {
            if(result.code == 666){
                $("#home > div.top_menu_w3layouts > div > div.header_right > ul > li > a")[0].text = "注销你的账户";
            }
        },
        error:function () {
            alert("服务器出错，请稍后再试");
        }
    });
});

$("#login").click(function () {
    if($("#login").text() == "登陆你的账户"){
        window.location.href = "login.html";
    }else{
        $.ajax({
            type:"GET",
            dataType:"json",
            url:"user/logout",
            success:function (result) {
                if(result.code == 666){
                    $("#home > div.top_menu_w3layouts > div > div.header_right > ul > li > a")[0].text = "登陆你的账户";
                    alert(result.message);
                }else{
                    alert(result.message);
                }
            },
            error : function () {
                alert("服务器出错，请稍后再试");
            }
        });
    }
})