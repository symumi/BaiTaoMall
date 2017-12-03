$()
			.ready(
					function() {
						// 在键盘按下并释放及提交后验证提交表单
						$("#LoginForm")
								.validate(
										{
											rules : {
												username : {
													required : true,
													minlength : 6,
													maxlength : 50
												},
												password : "required",
											},
											messages : {
												username : {
													required : "请输入用户名",
													minlength : $.validator
															.format("最少要输入 {0} 个字符"),
													maxlength : $.validator
															.format("最多可以输入 {0} 个字符(一个中文字算2个字符)")
												},
												password : "请输入密码"
											}
										});
					});