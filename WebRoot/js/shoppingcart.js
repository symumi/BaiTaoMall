/**
 * 
 */
window.onload=function(){
	var trLength=document.getElementsByTagName("tr").length;
	for(var i=0;i<trLength-2;i++){
		getSum(i);
		var num=document.getElementById("num"+i).value;
		var max=document.getElementById("max"+i).value;
		changeDisabled(i,num,max);
	}
	getTotal(0);
}

function deleteGoods(button,gid){
	var httpRequest=new XMLHttpRequest();
	httpRequest.open("POST", "servlet/PushGoodsServlet",true);
	httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
	httpRequest.send("gid="+gid);
	httpRequest.onreadystatechange=function(){
		if (httpRequest.readyState==4 && httpRequest.status==200){
			alert("删除成功");
			//移除当前行
			deleteRow(button);
		}
	}
}

function changeNum(op,index,max){
	var newnum;
	var gid=document.getElementById("gid"+index).value;
	var numEle=document.getElementById("num"+index);
	if(op=='+'){
		newnum=Number(numEle.value)+1;
	}
	if(op=='-'){
		newnum=Number(numEle.value)-1;
	}
	changeDisabled(index,newnum,max);
	update(gid,newnum,numEle,index);
}

//对数据库进行修改
function update(gid,newnum,numEle,index){
	var httpRequest=new XMLHttpRequest();
	httpRequest.open("POST", "servlet/ChangeNumberServlet",true);
	httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
	httpRequest.send("gid="+gid+"&newnum="+newnum);
	httpRequest.onreadystatechange=function(){
		if (httpRequest.readyState==4 && httpRequest.status==200){
			if(httpRequest.responseText=="error")
				deleteRow(document.getElementById(index));
			else{
				numEle.value=newnum;
				getSum(index);
			}
			//计算总价
			getTotal();
		}
	}
	
}

//改变按钮disabled状态
function changeDisabled(index,newnum,max){
	//递减按钮
	var decreaseEle=document.getElementById("decrease"+index);
	//递增按钮
	var increaseEle=document.getElementById("increase"+index);
	
	decreaseEle.disabled=false;
	increaseEle.disabled=false;
	
	if(newnum<=1){
		newnum=1;
		decreaseEle.disabled=true;
	}
	if(newnum>=max){
		newnum=max;
		increaseEle.disabled=true;
	}
}

//移除当前行
function deleteRow(button) {
	button.parentElement.parentElement.parentElement.removeChild(button.parentElement.parentElement);
}


//删除已选的所有商品
function deleteSelectedGoods(){
	var checkboxes=document.getElementsByName("selectedGoodsId");
	
	//迭代删除已勾选的商品
	for(var i=0;i<checkboxes.length;i++){
		var checkbox=checkboxes[i];
		if(checkbox.checked){
			deleteGoods(checkbox,checkbox.value);
		}
	}
	
}

//全选
function selectAll(checked){
	var checked=document.getElementById('all').checked;
	var checkboxes=document.getElementsByName("gid");
	for(var i=0;i<checkboxes.length;i++){
		checkboxes[i].checked=checked;
		if(checked){
			checkboxes[i].parentElement.parentElement.className="selected";
		}else{
			checkboxes[i].parentElement.parentElement.className="row"
		}
	}
	getTotal();
	checkSubmit(checkboxes);
}
function checkboxChanged(checkbox){
	//检查是否全选中
	var checked=checkbox.checked;
	var checkboxes=document.getElementsByName("gid");
	if(checkbox.checked){
		//选中状态
		checkbox.parentElement.parentElement.className="selected";
		var flag=true;
		for(var i=0;i<checkboxes.length;i++){
			console.log(i+"="+checkboxes[i].checked)
			if(checkboxes[i].checked!=checkbox.checked){
				flag=false;
				break;
			}
		}
		document.getElementById("all").checked=flag;
	}else{
		//取消选中
		checkbox.parentElement.parentElement.className="row";
		document.getElementById("all").checked=false;
	}
	
	//改变结算按钮链接
	checkSubmit(checkboxes);
	
	//计算总价
	getTotal();
}

//有选中的checkbox则使结算按钮有效
function checkSubmit(checkboxes){
	document.getElementById("submit-btn").disabled=true;
	for(var i=0;i<checkboxes.length;i++){
		if(checkboxes[i].checked){
			document.getElementById("submit-btn").disabled="";
			break;
		}
	}
}

function getSum(index){
	var sumEle=document.getElementById("sum"+index);
	var numEle=document.getElementById("num"+index);
	var priceEle=document.getElementById("price"+index);
	var sum=Number(priceEle.innerHTML)*Number(numEle.value);
	sumEle.innerHTML="￥"+sum.toFixed(2);
}

function validate(numEle,index,max){
	var gid=document.getElementById("gid"+index).value;
	numEle.value=numEle.value.replace(/\D/g,'');
	if(numEle.value==''||numEle.value<='0'){
		numEle.value='1';
	}
	if(numEle.value>=max){
		numEle.value=max;
	}
	update(gid,numEle.value,numEle,index)
}

function getTotal(){
	var indexes=new Array();
	var checkboxes=document.getElementsByName("gid");
	
	for(var i=0,j=0;i<checkboxes.length;i++){
		var checkbox=checkboxes[i];
		if(checkbox.checked){
			indexes[j++]=checkbox.parentElement.parentElement.id;
		}
	}
	var total=0;
	for(var i=0;i<indexes.length;i++)
		total+=Number((document.getElementById("sum"+indexes[i])).innerHTML.substr(1));
	document.getElementById("total").innerHTML="￥"+total.toFixed(2);
}
