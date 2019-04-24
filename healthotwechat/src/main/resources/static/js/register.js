$("#sent").click(function(){

    $.ajax({
        type:"GET",
        url:"/user/generateValidateCode",
        dataType:"json",
        data:{
            "email" : $("#iEmail").val()
        },
        success:function(data){
            if(data.code==0){
                alert(data.message);
            }
            else{
                alert(data.message);
            }
        },
        error : function (XMLHttpRequest) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);

        }
    });
})

$("#sbt").click(function(){
    $.ajax({
        type:"POST",
        url:"/user/register",
        dataType:"json",
        data:$("#register").serialize(),
        success:function(result){
            if (result.code == 666) {

                var redirectUrl = result.url;
                window.location.href=  "http://148.70.117.49:8080/"+redirectUrl;

            }else {
                var redirectUrl = result.url;
                var message = result.message;
                alert(message);
                window.location.href=  "http://148.70.117.49:8080/"+redirectUrl;
            }
        },
        error:function(){
            alert("服务器出错！");
        },
    })
    return false;
})