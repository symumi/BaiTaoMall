$()
			.ready(
					function() {
						// 在键盘按下并释放及提交后验证提交表单
						$("#receiveForm")
								.validate(
										{
											rules : {
												receiver : {
													required : true,
													minlength : 2,
													maxlength : 20,
												},
												phone : {
													required : true,
													digits : true,
													minlength : 11,
													maxlength : 11
												},
												detail : {
													required : true,
													minlength : 4,
												},
											},
											messages : {
												receiver : {
													required : "送给谁呢?",
													minlength : $.validator
															.format("最少要输入 {0} 个字符"),
													maxlength : $.validator
															.format("最多可以输入 {0} 个字符(一个中文字算2个字符)")
												},
												phone : {
													required : "联系谁呢?",
													digits : "混入了奇怪的东西",
													length : $.validator
															.format("你电话不是11位么"),
													minlength : $.validator
															.format("你电话不是11位么"),
													maxlength : $.validator
															.format("你电话不是11位么")
												},
												detail : {
													required : "地方好大找不到哦",
													minlength : $.validator
															.format("再详细些吧"),
												}
											}
										});
					});