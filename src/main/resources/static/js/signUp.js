function signUp() {
        if ($('#userId').val().trim().length<3) {
            alert('아이디는 3글자 이상이어야 합니다')
           $('#userId').val('');
           $('#userId').focus();
           return;
        }

        if ($('#userPwd').val() !== $('#userPwd2').val()) {
            alert('비밀번호가 일치하지 않습니다')
            $('#password2').focus();
            return;
        }

        const param = {
            userId : $('#userId').val(),
            userPwd : $('#userPwd').val(),
            userName : $('#userName').val(),
            userEmail : $('#userEmail').val()
        }

        $.ajax({
            url : '/join-pro',
            type : 'POST',
            accept : "application/json",
            contentType : "application/json; charset=utf-8",
            data : JSON.stringify(param),
            dataType : "json",
            async : false,
            success : function(data) {
            if (data === 1) {
                 alert('회원가입이 완료되었습니다.');
                 location.href = '/login'
             } else {
                alert("회원 가입 중 에러가 발생하였습니다.")
             }

            },
            error : function(error) {
                console.log(error);
            }
        })
    }