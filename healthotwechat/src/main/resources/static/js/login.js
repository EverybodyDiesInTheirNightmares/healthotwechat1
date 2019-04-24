$("#load").click(function (){
    $.ajax({
            type: "POST",
            dataType: "json",
            url: "/user/login",
            data:{
                "email":$("body > div.banner-bottom > div > div > div > form > div.left_form > div:nth-child(1) > span:nth-child(2) > input")[0].value,
                "password":$("body > div.banner-bottom > div > div > div > form > div.left_form > div:nth-child(2) > span:nth-child(2) > input")[0].value,
            },
            success : function(result){
                if(result.code == 666){
                    var redirectUrl = result.url;
                    window.location.href = "http://148.70.117.49:8080/"+redirectUrl;
                    alert("登陆成功");
                }else{
                    var redirectUrl = result.url;
                    var message = result.message;
                    alert(message);
                    window.location.href = "http://148.70.117.49:8080/"+redirectUrl;
                }
            },
            error : function(result){
                alert(result.toString());
            },
        }
    )
    return false;
})