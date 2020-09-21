$(document).ready(function() {
    // Generate a simple captcha
    function randomNumber(min, max) {
        return Math.floor(Math.random() * (max - min + 1) + min);
    };
    $('#captchaOperation').html([randomNumber(1, 20), '+', randomNumber(1, 30), '='].join(' '));
	
	
	//EXAMPLE REGISTER FORM
    $('#registerForm').bootstrapValidator({
        message: '此值无效',
        fields: {
            username: {
                message: '这个用户名无效',
                validators: {
                    notEmpty: {
                        message: '用户名是必须的，不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '用户名为6-20个字母或数字'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '用户名只能包含字母，数字和下划线，点'
                    },
                    different: {
                        field: 'password',
                        message: '用户名和密码不能相同'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Email地址是必须的，不能为空'
                    },
                    emailAddress: {
                        message: '您输入的Email地址无效'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空！'
                    },
                    identical: {
                        field: 'confirmPassword',
                        message: '对不起,您输入的密码和确认密码不一致'
                    },
                    different: {
                        field: 'username',
                        message: '密码不能和用户名相同'
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
                        message: '对不起,您输入的密码和确认密码不一致'
                    },
                    different: {
                        field: 'username',
                        message: '密码不能和用户名相同'
                    }
                }
            },
            phoneNumber: {
                validators: {
                    digits: {
                        message: '请输入手机号码'
                    }
                }
            },
            acceptTerms: {
                validators: {
                    notEmpty: {
                        message: '你不得不接受的条款和政策'
                    }
                }
            },
            captcha: {
                validators: {
                    callback: {
                        message: '回答错误',
                        callback: function(value, validator) {
                            var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
                            return value == sum;
                        }
                    }
                }
            }
        }
    });
	
	
	//EXAMPLE CONTACT FORM
    $('#contactForm').bootstrapValidator({
        message: 'This value is not valid',
        fields: {
            name: {
                message: '姓名是无效的',
                validators: {
                    notEmpty: {
                        message: '名字是必须的，不能为空'
                    },
                    regexp: {
//                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '名称只能包含字母，数字和下划线，点'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: '电子邮件地址是必需的，不能是空的'
                    },
                    emailAddress: {
                        message: '您输入的Email地址是无效的'
                    }
                }
            },
            website: {
                validators: {
                    uri: {
                        message: '您输入的是无效的URL'
                    }
                }
            },
            Contactmessage: {
                validators: {
                    notEmpty: {
                        message: '信息是必需的，不能是空的'
                    },
                    stringLength: {
                        min: 6,
                        message: '消息必须超过6个字符长'
                    }
                }
            },
            captcha: {
                validators: {
                    callback: {
                        message: '回答错误！',
                        callback: function(value, validator) {
                            var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
                            return value == sum;
                        }
                    }
                }
            }
        }
    });
	
	
	//Regular expression based validators
    $('#ExpressionValidator').bootstrapValidator({
        message: '这个值无效',
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
            website: {
                validators: {
                    uri: {
                        message: '您输入的是无效的URL'
                    }
                }
            },
            phoneNumber: {
                validators: {
                    digits: {
                        message: '您的输入只能包含数字'
                    }
                }
            },
            color: {
                validators: {
                    hexColor: {
                        message: '输入是一个无效的十六进制颜色'
                    }
                }
            },
            zipCode: {
                validators: {
                    usZipCode: {
                        message: '输入的是不是一个有效的邮政编码'
                    }
                }
            }
        }
    });
	
	
	//Regular expression based validators
    $('#NotEmptyValidator').bootstrapValidator({
        message: 'This value is not valid',
        fields: {
            username: {
                message: '用户名无效',
                validators: {
                    notEmpty: {
                        message: '用户名是必须的，不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '用户名必须大于6且小于20个字符长'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '用户名只能包含字母，数字和下划线，点'
                    }
                }
            },
            country: {
                validators: {
                    notEmpty: {
                        message: '国家必须填写，不能为空'
                    }
                }
            }
        }
    });
	
	
	//Regular expression based validators
    $('#IdenticalValidator').bootstrapValidator({
        message: '此值无效！',
        fields: {
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
	
	//Regular expression based validators
    $('#OtherValidator').bootstrapValidator({
        message: '此值无效',
        fields: {
            ages: {
                validators: {
                    lessThan: {
                        value: 100,
                        inclusive: true,
                        message: '您输入的年龄必须小于100'
                    },
                    greaterThan: {
                        value: 10,
                        inclusive: false,
                        message: '您输入的年龄必须大于10'
                    }
                }
            }
        }
    });
	
});