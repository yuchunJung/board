function login() {
    if($('#userId').val().trim().length<3) {
        alert('아이디 확인')
        $('#userId').val('');
        $('#userId').focus();
        return;
    }

    const param = {
        userId : $('#userId').val(),
        userPwd : $('#userPwd').val()
    }

    $.ajax({
        url : '/login-pro',
        type : 'POST',
        contentType : "application/json; charset=utf-8",
        data : JSON.stringify(param),
        dataType : "json",
        success : function(data) {
        console.log(data);
            if(data == 1){
                alert("로그인이 성공하였습니다.");
                location.href='/main'
            } else {
                alert ("아이디와 비밀번호가 맞지 않습니다.")
            }
        },
        error : function(error) {
            console.log(error)
            alert("로그인 처리 중 에러가 발생하였습니다.")
        }
    })
}