<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:import url="/WEB-INF/view/include/top.jsp" />
<section>
<br>
<div align="center">
<h1>캠핑장목록</h1>
</div>
<br>
<div align="center">
<table border="1" id="table1">
	<tr>
		<td colspan="4" align="center">
		<div style="border: solid black 2px; width:50%;height:500px;" id="map" ></div>
		</td>
	</tr>
	<tr>
	<td colspan="2">시설명</td>
	<td colspan="2">${m.facility}</td>
	</tr>
	<tr>
	<td colspan="2">주소</td>
	<td colspan="2">${m.roadAddress}</td>
	</tr>
	<tr>
	<td colspan="2">전화번호</td>
	<td colspan="2">${m.telephone}</td>
	</tr>
	<tr>
	<td colspan="2">시설소개</td>
	<td colspan="2">${m.facilityInfo}</td>
	</tr>
	<tr>
	<td colspan="2">시설특징</td>
	<td colspan="2">${m.facilityFeature}</td>
	</tr>
	<tr>
	<td>위도</td><td>${m.latitude}</td>
	<td>경도</td><td>${m.longitude}</td>
	</tr>
</table>
<br>
</div>
</section>
<c:import url="/WEB-INF/view/include/bottom.jsp" />

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=524a2522168af43f6aa3f54379d9762f"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(${m.latitude}, ${m.longitude}), // 지도의 중심좌표
        level: 9 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(${m.latitude}, ${m.longitude}); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

var iwContent = '<div style="padding:5px;"> ${m.facility} <br><a href="https://map.kakao.com/link/map/${m.facility} ,${m.latitude}, ${m.longitude}" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/${m.facility},${m.latitude}, ${m.longitude}" style="color:blue" target="_blank">길찾기</a></div>', 
    iwPosition = new kakao.maps.LatLng(${m.latitude}, ${m.longitude}); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    position : iwPosition, 
    content : iwContent 
});
  
// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker); 
</script>