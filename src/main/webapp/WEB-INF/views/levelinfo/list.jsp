
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<script>
var AjaxUtil = function(conf){
	var xhr = new XMLHttpRequest();
	var url = conf.url;
	var method = conf.method?conf.method:'GET';
	var param = conf.param?conf.param:'{}';
	
	var success = conf.success?conf.success:function(res){
		alert(res);
	}
	var error = conf.error?conf.error:function(res){
		alert(res);
	}
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status=="200"){
				success(xhr.responseText);
			}else{
				error(xhr.responseText);
			}
		}
	}
	xhr.open(method,url);
	if(method!='GET'){
		xhr.setRequestHeader('Content-type','application/json;charset=utf-8');
	}
	this.send = function(){
		xhr.send();
	}
};


/* window.addEventListner('load',function(){
	var liBody = document.querySelector('#liBody');
	alert(liBody);
	alert("나 서버 갔다 오는 작업을 해야해");
});
window.addEventListner('load',function(){
	alert("난 새로 정의한 온로드야");
}); */

window.addEventListener('load',function(){
	var conf= {
			url : '/levelinfo',
			success : function(res){
				res=JSON.parse(res);
				var html='';
				for(var li of res){
					 html +='<tr id="lv' + li.liNum +'">';
					 html +='<td>' + li.liNum + '</td>';
					 html +='<td><input type="text" id="liLevel' + li.liNum+'" value="' + li.liLevel + '"></td>';
					 html +='<td><input type="text" id="liName' + li.liNum+'" value="' + li.liName + '"></td>';
					 html +='<td><input type="text" id="liDesc' + li.liNum+'" value="' + li.liDesc + '"></td>';
					 html += '<td><button onclick="updateLevelInfo(' + li.liNum +')">수정</button></td>';
					 html += '<td><button onclick="deleteLevelInfo(' + li.liNum +')">삭제</button></td>';
					 html +='</tr>' 
				}
				document.querySelector('#liBody').insertAdjacentHTML('beforeend',html);
			
			}
	}
		var au = new AjaxUtil(conf);
		au.send();
});

</script>
<body>
	liName :
	<input type="text" name="liName">
	<button>검색</button>


	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>레벨</th>
				<th>이름</th>
				<th>설명</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody id="liBody">

			<%-- <c:if test="${empty liList}">
				<tr>
					<td colspan="4">레벨목록이 없습니다</td>
				</tr>
			</c:if>
			<c:forEach items="${liList}" var="li">
				<tr>
					<td> ${li.liNum}</td>
					<td> ${li.liLevel}</td>
					<td> ${li.liName}</td>
					<td> ${li.liDesc}</td>
				</tr>
			</c:forEach> --%>
		</tbody>
	</table>
	<button onclick="addLevelInfo()">레벨추가</button>
	<script>
	
	function addLevelInfo(){
		var html ='<tr>';
			html +='<td>$nbsp;</td>';
			html +='<td><input type="text" id="liLevel" value=""></td>';
			html +='<td><input type="text" id="liName" value=""></td>';
			html +='<td><input type="text" id="liDesc" value=""></td>';
			html += '<td><button onclick="saveLevelInfo()">저장</button></td>';
			html +='</tr>'
				 document.querySelector("#liBody").insertAdjacentHTML('beforeend',html);
		}
	function saveLevelInfo(){
		var liLevel = document.querySelector("#liLevel").value;
		var liName = document.querySelector("#liName").value;
		var liDesc = document.querySelector("#liDesc").value;
		var params = {liLevel:liLevel,liName:liName,liDesc:liDesc};
		params = JSON.stringify(params);
		
		var conf= {
				url : '/levelinfo',
				method : 'POST',
				param : params,
				success : function(res){
					if(res==1){
						alert("저장완료");
						initList();
					}
				}
						
		}
		var au = new AjaxUtil(conf);
		au.send();
	 
		}
	
	

		function updateLevelInfo(liNum){
		var liLevel = document.querySelector("#liLevel" + liNum).value;
		var liName = document.querySelector("#liName" + liNum).value;
		var liDesc = document.querySelector("#liDesc" + liNum).value;
		var params = {liLevel:liLevel,liName:liName,liDesc:liDesc,liNum:liNum};
		params = JSON.stringify(params);
		
		var conf= {
				url : '/levelinfo' + liNum,
				method : 'PUT',
				param : params,
				success : function(res){
					alert(res);
				}
						
		}
		var au = new AjaxUtil(conf);
		au.send();
	 
		};
		
		function deleteLevelInfo(liNum) {
			
			var conf = {
					url : '/levelinfo/' + liNum,
					method : 'DELETE',
					success : function(res){
						if(res==1){
							alert("삭제 성공");
							location.href="/url/levelinfo:list";
						
						}
						
					}
			}
			var au = new AjaxUtil(conf);
			au.send();
		}; 
	</script>
</body>
</html>