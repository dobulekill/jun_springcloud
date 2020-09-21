$(document).ready(function() {
    // Generate a simple captcha
    function randomNumber(min, max) {
        return Math.floor(Math.random() * (max - min + 1) + min);
    };
    $('#captchaOperation').html([randomNumber(1, 20), '+', randomNumber(1, 30), '='].join(' '));
    
    
    
    //Regular expression based validators
    $('#step1').bootstrapValidator({
        message: '此值无效！',
        fields: {

            email: {
                validators: {
                    notEmpty: {
                        message: 'Email地址是必须的，不能为空'
                    },
                    emailAddress: {
                        message: '您输入的Email地址无效！'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'confirmPassword',
                        message: '您输入的密码和确认是不一致'
                    }
                }
            },
            confirmPassword: {
                validators: {
                    notEmpty: {
                        message: '确认密码是必需的，不能是空的'
                    },
                    identical: {
                        field: 'password',
                        message: '您输入的密码和确认是不一致'
                    }
                }
            }
        }
    });
    
    
});