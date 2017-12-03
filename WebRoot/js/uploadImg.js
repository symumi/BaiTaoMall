/**
 * 
 */
$(document).ready(function () {  
    $("#imgs").fileinput({
        language: 'zh', //设置语言
        uploadUrl: 'servlet/UploadImg',  
        mainClass: "input-group-lg",
        allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
        showUpload: true, //是否显示上传按钮
        showCaption: true, //是否显示标题
        maxFileCount: 1,/*允许最大上传数，可以多个，当前设置单个*/
        enctype: 'multipart/form-data', //设置上传属性
        maxFileSize : 10000,    
    }) ;
});