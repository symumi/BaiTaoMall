$(function() {
	var state = false;
	$('#txtEmail').focus(function() {
		if (state == false) {
			$(this).val('');
		}
	})
	$('#txtEmail').blur(
			function() {
				if ($(this).val() == '') {
					$('#spinfo').text('邮箱不能为空');
				} else {
					if (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test($(
							this).val()) == false) {
						$('#spinfo').text('邮箱格式不正确，请重新输入');
					} else {
						$('#spinfo').text('');
						state = true;
					}
				}
			})

});
$(".tip").hide();
function checkpas1() {// 当第一个密码框失去焦点时，触发checkpas1事件
	var pas1 = document.getElementById("spassword").value;
	var pas2 = document.getElementById("repeatpassword").value;// 获取两个密码框的值
	if (pas1 != pas2 && pas2 != "")// 此事件当两个密码不相等且第二个密码是空的时候会显示错误信息
		$(".tip").show();
	else
		$(".tip").hide();// 若两次输入的密码相等且都不为空时，不显示错误信息。
}
function checkpas() {// 当第一个密码框失去焦点时，触发checkpas2件
	var pas1 = document.getElementById("spassword").value;
	var pas2 = document.getElementById("repeatpassword").value;// 获取两个密码框的值
	if (pas1 != pas2) {
		$(".tip").show();// 当两个密码不相等时则显示错误信息
	} else {
		$(".tip").hide();
	}
}
function checkpas2() {// 点击提交按钮时，触发checkpas2事件，会进行弹框提醒以防无视错误信息提交
	var pas3 = document.getElementById("spassword").value;
	var pas4 = document.getElementById("repeatpassword").value;
	if (pas3 != pas4) {
		alert("两次输入的密码不一致！");
		return false;
	}
}

$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	$("#signupForm").validate({
		rules : {
			username : {
				required : true,
				minlength : 6,
				maxlength : 50,
				remote : {//ajax
					type : "post",// 数据发送方式
					url : "UserFindByName", // 后台处理程序
					data : { // 要传递的数据
						usernameid : function() {
							return $("#username").val();
						}
					},
					dataFilter : function(data, type) { // 返回结果
						if (data == "true")
							return true;
						else {
							return false;
						}
					}
				}
			},
			password : {
				required : true,
				minlength : 6,
				maxlength : 20
			},
			email : {
				required : true,
			}
		},
		messages : {
			username : {
				required : "请输入用户名",
				remote : "用户名已存在",
				minlength : $.validator.format("最少要输入 {0} 个字符"),
				maxlength : $.validator.format("最多可以输入 {0} 个字符(一个中文字算2个字符)")
			},
			password : {
				required : "请输入密码",
				minlength : $.validator.format("最少要输入 {0} 个字符"),
				maxlength : $.validator.format("最多可以输入 {0} 个字符")
			},
			email : {
				required : "请输入邮箱"
			}
		}
	});
});
