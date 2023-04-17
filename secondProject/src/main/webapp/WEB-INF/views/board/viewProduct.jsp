<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%
   request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="product" value="${productMap.product }" />
<c:set var="imageFileList" value="${productMap.imageFileList }" />
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.carousel-item > img{
    width: 450px;
    height: 450px;
    object-fit: contain;
}

td>input[type="text"]{
	width: 1050px;
	border: none;
	height: 40px;
	margin-left: 20px;
}
td>a{
	color:gray;
}

</style>
<script>
	function fn_needLogin(){
		alert("로그인이 필요합니다.");
		location.href='${contextPath }/member/loginForm.do';
	}

</script>
<link rel="stylesheet" href="${contextPath }/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath }/resources/css/board/viewProduct_style.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="ProductContent">
		<!-- <div class="ProductTop"> -->
		<div class="ProductImage">
			<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true" style="max-height: 450px; width: 450px;">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="/image/${product.regNum }/${product.pr_img1}" class="d-block w-100" alt="...">
						</div>
						<c:if test="${product.pr_img2 != null}">
						<div class="carousel-item">
							<img src="/image/${product.regNum }/${product.pr_img2}" class="d-block w-100" alt="...">
						</div>
						</c:if>
						<c:if test="${product.pr_img3 != null}">
						<div class="carousel-item">
							<img src="/image/${product.regNum }/${product.pr_img3}" class="d-block w-100" alt="...">
						</div>
						</c:if>
						<c:if test="${product.pr_sold == 1 }">
							<div class="onSellDisplay" style="color: #FFCD4A;">거래 중</div>
						</c:if>
						<c:if test="${product.pr_sold == 2 }">
							<div class="onSellDisplay" style="color: #f34a5a;">거래 완료</div>
						</c:if>
						<c:if test="${product.pr_sold == 3 }">
							<div class="onSellDisplay" style="color: black;">거래 불가능</div>
						</c:if>
					</div>
					<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="visually-hidden">Next</span>
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
					</button>
				</div>
		</div>
		<div class="ProductSummary">
			<div class="ProductTitle">
				${product.pr_title}
			</div>
			<div class="ProductPrice">
				${product.pr_price }원
			</div>
			<div class="ProductInfo">
				<div class="ProductSellerId">
					<div class="ProductSellerId_1">
						판매자
					</div>
					<div class="ProductSellerId_2">
						${product.seller_id }
					</div>		
				</div>
				<div class="ProductCondition">
					<div class="ProductCondition_1">
						상품 상태
					</div>
					<div class="ProductCondition_2">
							<c:if test="${product.pr_condition =='1' }">하</c:if>
							<c:if test="${product.pr_condition =='2' }">중</c:if>
							<c:if test="${product.pr_condition =='3' }">상</c:if>
					</div>		
				</div>
				<div class="ProductRegDate">
					<div class="ProductRegDate_1">
						등록일
					</div>
					<div class="ProductCondition_2">
						${product.regDate }
					</div>	
				</div>
				<div class="ProductSold">
					<div class="ProductSold_1">
						판매상태
					</div>
					<div class="ProductSold_2">
						<c:if test="${product.pr_sold =='0' }">거래 가능</c:if>
						<c:if test="${product.pr_sold =='1' }">거래 중</c:if>
						<c:if test="${product.pr_sold =='2' }">거래 완료</c:if>
						<c:if test="${product.pr_sold =='3' }">거래 불가능</c:if>
				</div>		
				</div>
			</div>
			<c:choose>
				<c:when test="${isLogOn == true && member != null }">
					<c:if test="${member.user_id != product.seller_id }">
						<div class="buttons">
 							<div class="chatLink" onclick="location.href='${contextPath }/chat/chatForm.do?buyer_id=${member.user_id}&&seller_id=${product.seller_id}&&regNum=${product.regNum}&&pr_title=${product.pr_title}&&pr_sold=${product.pr_sold}&&pr_price=${product.pr_price}&&pr_img1=${product.pr_img1}';">
								메세지 보내기
							</div>
						<%-- 	<a class="btn btn-primary" href="${contextPath }/chat/chatForm.do?buyer_id=${member.user_id}&&seller_id=${product.seller_id}
				&&regNum=${product.regNum}&&pr_title=${product.pr_title}&&pr_sold=${product.pr_sold}&&pr_price=${product.pr_price}
				&&pr_img1=${product.pr_img1}">메세지 보내기</a> --%>
							
						</div>
					</c:if>
				</c:when>
				<c:otherwise>
					<div class="buttons">
						<div class="chatLink" onclick="fn_needLogin();">메세지 보내기</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="ProductBottom">
			${product.pr_content }
		</div>
		<c:choose>
			<c:when test="${isLogOn == true && member.user_id==product.seller_id }">
				<div class="logonActiveButtons">
					<span>
						<input type="button" class="modButton" name="modArticle" value="수정하기" onclick="location.href='${contextPath }/modify/modPro.do?regNum=${product.regNum}';">
					</span>
					<!--  <span>
						<input type="button" name="removeArticle" value="삭제하기">
					</span>-->
				</div>
			</c:when> 
			<c:otherwise>
				<div></div>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="commentContent"><!-- 댓글 part(지저분함) -->
		<div class="commentViewer">
			<c:choose>
				<c:when test="${isLogOn == true }"><!-- 로그인 시 댓글보임 -->
					<c:choose>
						<c:when test="${member.user_id==product.seller_id }"><!-- 판매자한테 댓글 모두 보임 -->
							<form name="comment" method="post" action="${contextPath }/product/SellerWriteComment.do?regNum=${product.regNum}" enctype="multipart/form-data">
								<table align="center" width="1150px;">
									<c:forEach var="sellerCommentsView0" items="${sellerCommentsView0 }"><!-- 판매자에게는 ForEach문 기준으로 10개(10명분,0~9) 반복됨, 데이터 없으면 보이지 않음-->
								  	 	<tr>
											<td align="left"  >
												<!-- 댓글 작성자 구분용 -->
												<c:choose>
													<c:when test="${sellerCommentsView0.comment_writer=='buyer' }"><span class="comBuyer_id">${sellerCommentsView0.buyer_id}</span></c:when>
													<c:when test="${sellerCommentsView0.comment_writer=='seller' }"><span class="comSeller_id">${sellerCommentsView0.seller_id} 판매자</span></c:when>
												</c:choose>
												<span class="commentDate">${sellerCommentsView0.regDate }</span>
											</td>
											<td align="right"><!-- 삭제 버튼 -->
												<c:choose>
													<c:when test="${sellerCommentsView0.comment_writer=='seller' }">
														<a href="${contextPath }/product/deleteComment.do?regNum=${product.regNum}&commentNo=${sellerCommentsView0.commentNo }">삭제</a>
													</c:when>
												</c:choose>
											</td>
										</tr>
										<tr>
											<td align="left" colspan="2"><!-- 댓글 내용 -->
												<span class="comment_content">${sellerCommentsView0.comment_content }</span>
											</td>
										</tr>
									</c:forEach>
									<!-- 댓글입력창 -->
									<c:choose>
										<c:when test="${not empty sellerCommentsView0 and (product.pr_sold==0 or product.pr_sold==1)}">
											<tr>
												<td width="1050px;">
													<input type="text" name="comment_content0" placeholder="댓글을 입력하세요">
												</td>
												<td width="80px;">
													<input type="submit" value="댓글 작성" class="commentSubmit">
												</td>
											</tr>
										</c:when>
									</c:choose>
									<c:forEach var="sellerCommentsView1" items="${sellerCommentsView1 }">
								  		<tr>
											<td align="left"  >
												<c:choose>
													<c:when test="${sellerCommentsView1.comment_writer=='buyer' }"><span class="comBuyer_id">${sellerCommentsView1.buyer_id}</span></c:when>
													<c:when test="${sellerCommentsView1.comment_writer=='seller' }"><span class="comSeller_id">${sellerCommentsView1.seller_id} 판매자</span></c:when>
										 		</c:choose>
										 		<span class="commentDate">${sellerCommentsView1.regDate }</span>
										 	</td>
											<td align="right">
												<c:choose>
													<c:when test="${sellerCommentsView1.comment_writer=='seller' }">
														<a href="${contextPath }/product/deleteComment.do?regNum=${product.regNum}&commentNo=${sellerCommentsView1.commentNo }">삭제</a>
													</c:when>
												</c:choose>
											</td>
										</tr>
										<tr>
											<td align="left" colspan="2">
												<span class="comment_content">${sellerCommentsView1.comment_content }</span>
											</td>
										</tr>
									</c:forEach>
									<c:choose>
										<c:when test="${not empty sellerCommentsView1 and (product.pr_sold==0 or product.pr_sold==1)}">
											<tr>
												<td width="1050px;">
													<input type="text" name="comment_content1" placeholder="댓글을 입력하세요">
												</td>
												<td width="80px;">
													<input type="submit" value="댓글 작성" class="commentSubmit">
												</td>
											</tr>
										</c:when>
									</c:choose>
									<c:forEach var="sellerCommentsView2" items="${sellerCommentsView2 }">
								  		<tr>
											<td align="left"  >
												<c:choose>
													<c:when test="${sellerCommentsView2.comment_writer=='buyer' }"><span class="comBuyer_id">${sellerCommentsView2.buyer_id}</span></c:when>
													<c:when test="${sellerCommentsView2.comment_writer=='seller' }"><span class="comSeller_id">${sellerCommentsView2.seller_id} 판매자</span></c:when>
												</c:choose>
												<span class="commentDate">${sellerCommentsView2.regDate }</span>
											</td>
											<td align="right">
												<c:choose>
													<c:when test="${sellerCommentsView2.comment_writer=='seller' }">
														<a href="${contextPath }/product/deleteComment.do?regNum=${product.regNum}&commentNo=${sellerCommentsView2.commentNo }">삭제</a>
													</c:when>
												</c:choose>
											</td>
										</tr>
										<tr>
											<td align="left" colspan="2">
												<span class="comment_content">${sellerCommentsView2.comment_content }</span>
											</td>
										</tr>
									</c:forEach>
									<c:choose>
										<c:when test="${not empty sellerCommentsView2 and (product.pr_sold==0 or product.pr_sold==1)}">
											<tr>
												<td width="1050px;">
													<input type="text" name="comment_content2" placeholder="댓글을 입력하세요">
												</td>
												<td width="80px;">
													<input type="submit" value="댓글 작성" class="commentSubmit">
												</td>
											</tr>
										</c:when>
									</c:choose>
									<c:forEach var="sellerCommentsView3" items="${sellerCommentsView3 }">
								  		<tr>
											<td align="left"  >
												<c:choose>
													<c:when test="${sellerCommentsView3.comment_writer=='buyer' }"><span class="comBuyer_id">${sellerCommentsView3.buyer_id}</span></c:when>
													<c:when test="${sellerCommentsView3.comment_writer=='seller' }"><span class="comSeller_id">${sellerCommentsView3.seller_id} 판매자</span></c:when>
										 		</c:choose>
										 		<span class="commentDate">${sellerCommentsView3.regDate }</span>
										 	</td>
											<td align="right">
												<c:choose>
													<c:when test="${sellerCommentsView3.comment_writer=='seller' }">
														<a href="${contextPath }/product/deleteComment.do?regNum=${product.regNum}&commentNo=${sellerCommentsView3.commentNo }">삭제</a>
													</c:when>
												</c:choose>
											</td>
										</tr>
										<tr>
											<td align="left" colspan="2">
												<span class="comment_content">${sellerCommentsView3.comment_content }</span>
											</td>
										</tr>
									</c:forEach>
									<c:choose>
										<c:when test="${not empty sellerCommentsView3 and (product.pr_sold==0 or product.pr_sold==1)}">
											<tr>
												<td width="1050px;">
													<input type="text" name="comment_content3" placeholder="댓글을 입력하세요">
												</td>
												<td width="80px;">
													<input type="submit" value="댓글 작성" class="commentSubmit">
												</td>
											</tr>
										</c:when>
									</c:choose>
									<c:forEach var="sellerCommentsView4" items="${sellerCommentsView4 }">
								  		<tr>
											<td align="left"  >
												<c:choose>
													<c:when test="${sellerCommentsView4.comment_writer=='buyer' }"><span class="comBuyer_id">${sellerCommentsView4.buyer_id}</span></c:when>
													<c:when test="${sellerCommentsView4.comment_writer=='seller' }"><span class="comSeller_id">${sellerCommentsView4.seller_id} 판매자</span></c:when>
										 		</c:choose>
										 		<span class="commentDate">${sellerCommentsView4.regDate}</span>
										 	</td>
											<td align="right">
												<c:choose>
													<c:when test="${sellerCommentsView4.comment_writer=='seller' }">
														<a href="${contextPath }/product/deleteComment.do?regNum=${product.regNum}&commentNo=${sellerCommentsView4.commentNo }">삭제</a>
													</c:when>
												</c:choose>
											</td>
										</tr>
										<tr>
											<td align="left" colspan="2">
												<span class="comment_content">${sellerCommentsView4.comment_content }</span>
											</td>
										</tr>
									</c:forEach>
									<c:choose>
										<c:when test="${not empty sellerCommentsView4 and (product.pr_sold==0 or product.pr_sold==1) }">
											<tr>
												<td width="1050px;">
													<input type="text" name="comment_content4" placeholder="댓글을 입력하세요">
												</td>
												<td width="80px;">
													<input type="submit" value="댓글 작성" class="commentSubmit">
												</td>
											</tr>
										</c:when>
									</c:choose>
									<c:forEach var="sellerCommentsView5" items="${sellerCommentsView5 }">
								  		<tr>
											<td align="left"  >
												<c:choose>
													<c:when test="${sellerCommentsView5.comment_writer=='buyer' }"><span class="comBuyer_id">${sellerCommentsView5.buyer_id}</span></c:when>
													<c:when test="${sellerCommentsView5.comment_writer=='seller' }"><span class="comSeller_id">${sellerCommentsView5.seller_id} 판매자</span></c:when>
										 		</c:choose>
										 		<span class="commentDate">${sellerCommentsView5.regDate }</span>
										 	</td>
											<td align="right">
												<c:choose>
													<c:when test="${sellerCommentsView5.comment_writer=='seller' }">
														<a href="${contextPath }/product/deleteComment.do?regNum=${product.regNum}&commentNo=${sellerCommentsView5.commentNo }">삭제</a>
													</c:when>
												</c:choose>
											</td>
										</tr>
										<tr>
											<td align="left" colspan="2">
												<span class="comment_content">${sellerCommentsView5.comment_content }</span>
											</td>
										</tr>
									</c:forEach>
									<c:choose>
										<c:when test="${not empty sellerCommentsView5 and (product.pr_sold==0 or product.pr_sold==1)}">
											<tr>
												<td width="1050px;">
													<input type="text" name="comment_content5" placeholder="댓글을 입력하세요">
												</td>
												<td width="80px;">
													<input type="submit" value="댓글 작성" class="commentSubmit">
												</td>
											</tr>
										</c:when>
									</c:choose>
									<c:forEach var="sellerCommentsView6" items="${sellerCommentsView6 }">
								  		<tr>
											<td align="left"  >
												<c:choose>
													<c:when test="${sellerCommentsView6.comment_writer=='buyer' }"><span class="comBuyer_id">${sellerCommentsView6.buyer_id}</span></c:when>
													<c:when test="${sellerCommentsView6.comment_writer=='seller' }"><span class="comSeller_id">${sellerCommentsView6.seller_id} 판매자</span></c:when>
										 		</c:choose>
										 		<span class="commentDate">${sellerCommentsView6.regDate }</span>
										 	</td>
											<td align="right">
												<c:choose>
													<c:when test="${sellerCommentsView6.comment_writer=='seller' }">
														<a href="${contextPath }/product/deleteComment.do?regNum=${product.regNum}&commentNo=${sellerCommentsView6.commentNo }">삭제</a>
													</c:when>
												</c:choose>
											</td>
										</tr>
										<tr>
											<td align="left" colspan="2">
												<span class="comment_content">${sellerCommentsView6.comment_content }</span>
											</td>
										</tr>
									</c:forEach>
									<c:choose>
										<c:when test="${not empty sellerCommentsView6 and (product.pr_sold==0 or product.pr_sold==1)}">
											<tr>
												<td width="1050px;">
													<input type="text" name="comment_content6" placeholder="댓글을 입력하세요">
												</td>
												<td width="80px;">
													<input type="submit" value="댓글 작성" class="commentSubmit">
												</td>
											</tr>
										</c:when>
									</c:choose>
									<c:forEach var="sellerCommentsView7" items="${sellerCommentsView7 }">
								  		<tr>
											<td align="left"  >
												<c:choose>
													<c:when test="${sellerCommentsView7.comment_writer=='buyer' }"><span class="comBuyer_id">${sellerCommentsView7.buyer_id}</span></c:when>
													<c:when test="${sellerCommentsView7.comment_writer=='seller' }"><span class="comSeller_id">${sellerCommentsView7.seller_id} 판매자</span></c:when>
										 		</c:choose>
										 		<span class="commentDate">${sellerCommentsView7.regDate }</span>
										 	</td>
											<td align="right">
												<c:choose>
													<c:when test="${sellerCommentsView7.comment_writer=='seller' }">
														<a href="${contextPath }/product/deleteComment.do?regNum=${product.regNum}&commentNo=${sellerCommentsView7.commentNo }">삭제</a>
													</c:when>
												</c:choose>
											</td>
										</tr>
										<tr>
											<td align="left" colspan="2">
												<span class="comment_content">${sellerCommentsView7.comment_content }</span>
											</td>
										</tr>
									</c:forEach>
									<c:choose>
										<c:when test="${not empty sellerCommentsView7 and (product.pr_sold==0 or product.pr_sold==1)}">
											<tr>
												<td width="1050px;">
													<input type="text" name="comment_content7" placeholder="댓글을 입력하세요">
												</td>
												<td width="80px;">
													<input type="submit" value="댓글 작성" class="commentSubmit">
												</td>
											</tr>
										</c:when>
									</c:choose>
									<c:forEach var="sellerCommentsView8" items="${sellerCommentsView8 }">
								  		<tr>
											<td align="left"  >
												<c:choose>
													<c:when test="${sellerCommentsView8.comment_writer=='buyer' }"><span class="comBuyer_id">${sellerCommentsView8.buyer_id}</span></c:when>
													<c:when test="${sellerCommentsView8.comment_writer=='seller' }"><span class="comSeller_id">${sellerCommentsView8.seller_id} 판매자</span></c:when>
										 		</c:choose>
										 		<span class="commentDate">${sellerCommentsView8.regDate }</span>
										 	</td>
											<td align="right">
												<c:choose>
													<c:when test="${sellerCommentsView8.comment_writer=='seller' }">
														<a href="${contextPath }/product/deleteComment.do?regNum=${product.regNum}&commentNo=${sellerCommentsView8.commentNo }">삭제</a>
													</c:when>
												</c:choose>
											</td>
										</tr>
										<tr>
											<td align="left" colspan="2">
												<span class="comment_content">${sellerCommentsView8.comment_content }</span>
											</td>
										</tr>
									</c:forEach>
									<c:choose>
										<c:when test="${not empty sellerCommentsView8 and (product.pr_sold==0 or product.pr_sold==1)}">
											<tr>
												<td width="1050px;">
													<input type="text" name="comment_content8" placeholder="댓글을 입력하세요">
												</td>
												<td width="80px;">
													<input type="submit" value="댓글 작성" class="commentSubmit">
												</td>
											</tr>
										</c:when>
									</c:choose>
									<c:forEach var="sellerCommentsView9" items="${sellerCommentsView9 }">
								  		<tr>
											<td align="left"  >
												<c:choose>
													<c:when test="${sellerCommentsView9.comment_writer=='buyer' }"><span class="comBuyer_id">${sellerCommentsView9.buyer_id}</span></c:when>
													<c:when test="${sellerCommentsView9.comment_writer=='seller' }"><span class="comSeller_id">${sellerCommentsView9.seller_id} 판매자</span></c:when>
										 		</c:choose>
										 		<span class="commentDate">${sellerCommentsView9.regDate }</span>
										 	</td>
											<td align="right">
												<c:choose>
													<c:when test="${sellerCommentsView9.comment_writer=='seller' }">
														<a href="${contextPath }/product/deleteComment.do?regNum=${product.regNum}&commentNo=${sellerCommentsView9.commentNo }">삭제</a>
													</c:when>
												</c:choose>
											</td>
										</tr>
										<tr>
											<td align="left" colspan="2">
												<span class="comment_content">${sellerCommentsView9.comment_content }</span>
											</td>
										</tr>
									</c:forEach>
									<c:choose>
										<c:when test="${not empty sellerCommentsView9 and (product.pr_sold==0 or product.pr_sold==1)}">
											<tr>
												<td>
													<input type="text" name="comment_content9" placeholder="댓글을 입력하세요">
												</td>
												<td width="80px;">
													<input type="submit" value="댓글 작성" class="commentSubmit">
												</td>
											</tr>
										</c:when>
									</c:choose>
								</table>
							</form>
						</c:when>
						<c:otherwise><!-- 판매자가 아닐 시 -->
							<form name="comment" method="post" action="${contextPath }/product/buyerWriteComment.do?regNum=${product.regNum}" enctype="multipart/form-data">
								<table align="center" width="1150px;">
									<c:forEach var="buyerComments" items="${buyerComments }"><!-- 구매자용 출력 창/form태그 사용, when태그 사용으로 인해 판매자용과 미묘하게 다른 형태를 취하고 있음 -->
										<tr>
											<td align="left" >
												<!-- 댓글 작성자 표시용 -->
												<c:choose>
													<c:when test="${buyerComments.comment_writer=='buyer' }"><span class="comBuyer_id">${buyerComments.buyer_id}</span></c:when>
													<c:when test="${buyerComments.comment_writer=='seller' }"><span class="comSeller_id">${buyerComments.seller_id} 판매자</span></c:when>
										 		</c:choose> 
										 		<span class="commentDate">${buyerComments.regDate }</span>
										 	</td>
											<td align="right"><!-- 삭제 버튼 -->
												<c:choose>
													<c:when test="${buyerComments.comment_writer=='buyer' }">
														<a href="${contextPath }/product/deleteComment.do?regNum=${product.regNum}&commentNo=${buyerComments.commentNo }">삭제</a>
													</c:when>
												</c:choose>
											</td>
										</tr>
										<tr><!-- 댓글 내용 -->
											<td align="left" colspan="2"><span class="comment_content">${buyerComments.comment_content }</span></td>
										</tr>
									</c:forEach>
									<!-- 댓글 입력 창, 댓글 내용이 보이는가에 대해 상관없이 구매자에게는 무조건 출력되어야 함 -->
									<c:choose>
										<c:when test="${isLogOn == true and member.user_id!=product.seller_id and (product.pr_sold==0 or product.pr_sold==1)}">
											<tr>
												<td width="1050px;">
													<input type="text" name="comment_content10" placeholder="댓글을 입력하세요">
												</td>
												<td width="80px;">
													<input type="submit" value="댓글 작성" class="commentSubmit">
												</td>
											</tr>
										</c:when>
									</c:choose>
								</table>
							</form>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>		
		</div>
	</div>
	<div class="articleCtrl">	
		<c:if test="${pageName != null }">
			<!-- 마이페이지에서 내상품 상세보기에서 다시 내상품 리스트로 돌아가려면 받아올 값이 없으므로 
				<a class="clas1" href="${contextPath }/product/viewProduct.do?regNum=${myList.regNum}&pageName=mypage">
			       pageName을 mypage로 입력해서 쿼리값을 받아옴
			 -->
			<c:if test='${pageName == "mypage" }'>
				<div class="toList" onclick="location.href='${contextPath }/mypage/myArticles.do';">목록으로</div>
			</c:if>
			<!-- 카데고리 상세페이지는 pageName 값을 category_name은 db값으로 받아오니까이렇게 둘 수 있음 -->
			<c:if test='${pageName != "mypage" }'>
				<div class="toList" onclick="location.href='${contextPath }/viewList.do?category_name=${pageName}';">목록으로</div>
			</c:if>
		</c:if>
			<c:if test="${pageName == null }">
				<div class="toList" onclick="location.href='${contextPath }/main.do';">목록으로</div>
			</c:if>
	</div> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>