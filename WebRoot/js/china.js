window.onload = function() {
	var provinceEle = document.getElementById("province");

	var httpRequest = new XMLHttpRequest();
	httpRequest.open("GET", "servlet/ProvinceServlet", true);
	httpRequest.send(null);
	httpRequest.onreadystatechange = function() {
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
			var provinces = httpRequest.responseText;
			var arr = provinces.split(",");
			for (var i = 0; i < arr.length; i++) {
				var optionEle = document.createElement("option");
				optionEle.value = arr[i];
				var textNode = document.createTextNode(arr[i]);
				optionEle.appendChild(textNode);
				provinceEle.appendChild(optionEle);
			}
		}
	}
}

function provinceChanged() {
	var provinceEle=document.getElementById("province");
	var cityEle = document.getElementById("city");
	var districtEle=document.getElementById("district");
	//选择提示信息选项时return
	if(provinceEle.value=="0"){
		return;
	}
	//更改隐藏域province的value
	changeText("province");
	
	var httpRequest = new XMLHttpRequest();
	httpRequest.open("POST", "servlet/CityServlet", true);
	httpRequest.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded;charset=utf-8");
	httpRequest.send("provinceName=" + provinceEle.value);
	httpRequest.onreadystatechange = function() {
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
			// 移除除了第一个option元素之外的所有子元素
			var cityOptionList = cityEle.getElementsByTagName("option");
			while (cityOptionList.length > 1) {
				cityEle.removeChild(cityOptionList[1]);
			}
			var districtOptionList = districtEle
					.getElementsByTagName("option");
			while (districtOptionList.length > 1) {
				districtEle.removeChild(districtOptionList[1]);
			}

			var cities = httpRequest.responseText;
			var arr = cities.split(",");
			for (var i = 0; i < arr.length; i++) {
				var optionEle = document.createElement("option");
				optionEle.value = arr[i];
				var textNode = document.createTextNode(arr[i]);
				optionEle.appendChild(textNode);
				cityEle.appendChild(optionEle);
			}
		}
	}
}


function cityChanged() {
	var cityEle = document.getElementById("city");
	var districtEle = document.getElementById("district");
	//选择提示信息选项时return
	if(cityEle.value=="0"){
		return false;
	}
	//更改隐藏域city的value
	changeText("city");
	var httpRequest = new XMLHttpRequest();
	httpRequest.open("POST", "servlet/DistrictServlet", true);
	httpRequest.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded;charset=utf-8");
	httpRequest.send("cityName=" + cityEle.value);
	httpRequest.onreadystatechange = function() {
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
			// 移除除了请选择之外的所有子元素
			var districtOptionList = districtEle
					.getElementsByTagName("option");
			while (districtOptionList.length > 1) {
				districtEle.removeChild(districtOptionList[1]);
			}
			var districts = httpRequest.responseText;
			var arr = districts.split(",");
			for (var i = 0; i < arr.length; i++) {
				var optionEle = document.createElement("option");
				optionEle.value = arr[i];
				var textNode = document.createTextNode(arr[i]);
				optionEle.appendChild(textNode);
				districtEle.appendChild(optionEle);
			}
		}
	}
}

function changeText(name){
	document.getElementsByName(name)[0].value=document.getElementById(name).value;
	
	
}