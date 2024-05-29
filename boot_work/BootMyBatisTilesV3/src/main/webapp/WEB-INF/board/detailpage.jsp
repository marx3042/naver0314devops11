<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
   <style>
       body *{
           font-family: 'Jua';
       }
       
       td.buttons button{
        	width: 80px;
       }
       
       pre.adata{
       	margin-left: 10px;
       	color: gray;
       }
       
       span.aday{
       	 margin-left: 100px;
       	 color: gray;
       	 font-size: 0.9em;
       }
   </style>
   <script type="text/javascript">
   $(function(){
	   //처음 로딩시 댓글 목록 출력
	   answer_list();
	  
	   //댓글 추가 버튼
	  $("#btnansweradd").click(function(){
		  let num=${dto.num};
		  let content=$("#acontent").val();
		  if(content==''){
			  alert("댓글을 입력후 등록해주세요");
			  return;
		  }
		  
		  $.ajax({
			  type:'post',
			  dataType:'text',
			  url:"./ainsert",
			  data:{"num":num,"content":content},
			  success:function(){
				  //댓글 목록 다시 출력
				  answer_list();
				  //초기화
				  $("#acontent").val("");
			  }
		  });
	  });
	   
	   //댓글 삭제 이벤트
	   $(document).on("click",".adel",function(){
		  let aidx=$(this).attr("aidx");
		  let a=confirm("해당 댓글을 삭제할까요?");
		  if(a){
			  $.ajax({
				  type:"get",
				  dataType:"text",
				  data:{"aidx":aidx},
				  url:"./adelete",
				  success:function(){
					  //댓글 삭제후 목록 다시 출력
					  answer_list();
				  }
			  })
		  }
	   });
   });
   
   function answer_list(){
	   let num=${dto.num};
	   //로그인중인지 로그인중일경우 로그인 아이디 얻기
	   let loginok='${sessionScope.loginok}';
	   let loginid='${sessionScope.loginid}';
	   console.log(loginok+","+loginid);
	   
	   $.ajax({
		   type:"get",
		   dataType:"json",
		   data:{"num":num},
		   url:"./alist",
		   success:function(data){
			   //댓글 갯수 출력
			   $(".answercount").text(data.length);
			   //목록 출력
			   let s="";
			   $.each(data,function(idx,ele){
				  s+=					  
					  `
					  \${ele.writer}(\${ele.myid})
					  <span class="aday">\${ele.writeday}</span>
					  `;
					//로그인중이면서 댓글 아이디와 로그인 아이디가 같을경우 삭제 아이콘 추가
				   if(loginok=='yes' && loginid==ele.myid){
					   s+=
						   `
						   <i class="bi bi-trash adel" aidx="\${ele.aidx}"
						   style="cursor:pointer;"></i>
						   `
				   }	  
					  
				   s+=`
					  <br>
					  <pre class="adata">\${ele.content}</pre>
					  <br>
					  `; 
			   });
			   $(".answerlist").html(s);
		   }
	   })
   }
   </script>
</head>
<body>
<table class="table" style="width: 500px;">
	<tr>
		<td>
			<h2><b>${dto.subject}</b></h2>
			<!-- 프로필 사진 -->
			<img src="../save/${profile_photo}"
			  onerror="this.src='../image/noimage2.png'"
			  style="width: 45px;height: 45px;margin-right:5px;"
			  class="rounded-circle" align="left">
			  <b>${dto.writer}</b><br>
			  <span style="color: gray;font-size: 13px;">
			  	<fmt:formatDate value="${dto.writeday}"
			  	pattern="yyyy.MM.dd HH:mm"/>
			  	 &nbsp; &nbsp;
			  	 조회 &nbsp;${dto.readcount}
			  </span>
			  <span style="float: right;color: gray;">
			  	<i class="bi bi-chat-dots"></i>
			  	&nbsp;
			  	댓글 <span class="answercount">0</span>
			  </span>
		</td>
	</tr>
	<tr>
		<td>
			<c:if test="${dto.uploadphoto!='no'}">
				<img src="../save/${dto.uploadphoto}"
				onerror="this.src='../image/noimage2.png'"
				style="max-width: 300px;">
				<br><br>
			</c:if>
			<pre style="font-size: 17px;">${dto.content}</pre>
		</td>
	</tr>
	<tr>
		<td>
			 <!-- 댓글 출력할 영역 -->
			 <div class="answerlist"></div>
		</td>
	</tr>
	<c:if test="${sessionScope.loginok!=null}">
		<tr>
			<td>			   
				<b>댓글</b><br>
				<textarea style="width: 80%;height: 60px;" id="acontent"></textarea>
				<button type="button" class="btn btn-outline-success"
				style="height: 65px;position: relative;top:-25px;"
				id="btnansweradd">등록</button>
			</td>
		</tr>
	</c:if>
	<tr>
		<td class="buttons">
		    <!-- 새글 -->
			<button type="button" class="btn btn-sm btn-outline-success"
			onclick="location.href='./form'">
			<i class="bi bi-pencil-fill"></i>
			글쓰기</button>
			
			<!-- 답글 -->
			<button type="button" class="btn btn-sm btn-outline-secondary"
			onclick="location.href='./form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">			
			답글</button>
			
			<!-- 수정,삭제는 로그인중이며 자기가 쓴글에만 나타나게 하기 -->
			<c:if 
			test="${sessionScope.loginok!=null and sessionScope.loginid==dto.myid}">
				<button type="button" class="btn btn-sm btn-outline-secondary"
					onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">			
					수정</button>
					
				<button type="button" class="btn btn-sm btn-outline-secondary"
					onclick="del()">			
					삭제</button>
			</c:if>
			
			<button type="button" class="btn btn-sm btn-outline-secondary"
					onclick="location.href='./list?currentPage=${currentPage}'">			
					목록</button>
		</td>
	</tr>
</table>
<script>
	function del()
	{
		let num=${dto.num};
		let currentPage=${currentPage};
		
		let a=confirm("정말 삭제하시겠습니까?");
		if(a){
			location.href="./delete?num="+num+"&currentPage="+currentPage;
		}
	}
</script>
</body>
</html>