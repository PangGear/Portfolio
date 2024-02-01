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

<div id="map" style="width:95%;height:600px; border-top:2px solid blue; border-bottom:2px solid red; border-left:2px solid chartreuse; border-right:2px solid yellow; padding:10px;"></div>

<table border="1">
<tr align="center">
<td>번호</td>
<td>시설명</td>
<td>주소</td>
<td>위도</td>
<td>경도</td>
<td>전화번호</td>
<td>시설소개</td>
<td>시설특징</td>
</tr>
<c:forEach items="${li}" var="m" varStatus="status">
<tr>
	<td>${status.count}</td>
	<td>${m.facility}</td>
	<td>${m.roadAddress}</td>
	<td>${m.latitude}</td>
	<td>${m.longitude}</td>
	<td>${m.telephone}</td>
	<td>${m.facilityInfo}</td>
	<td>${m.facilityFeature}</td>
</tr>
</c:forEach>
</table>
<br>
</div>
</section>
<c:import url="/WEB-INF/view/include/bottom.jsp" />

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=524a2522168af43f6aa3f54379d9762f"></script>
<script>
    var mapContainer = document.getElementById('map'); // 지도를 표시할 div  
    var mapOption = { 
        center: new kakao.maps.LatLng(37.8853984, 127.7297758), // 지도의 중심좌표
        level: 10 // 지도의 확대 레벨
    };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
    
    var positions = [];
    <c:forEach var="m" items="${li}">  		
        var position = {
            content: ' <div style="padding:5px;"> ' +
                     '<a href="/getJson.do?idx=${m.idx}" style="color:blue" >${m.facility}</a></div>',                   
            latlng: new kakao.maps.LatLng(${m.latitude}, ${m.longitude})  
        };	
        positions.push(position);
    </c:forEach>
    
    var infowindows = [];
    var markers = [];
    var timeoutId;

    for (var i = 0; i < positions.length; i++) {
        var marker = new kakao.maps.Marker({
            map: map,
            position: positions[i].latlng
        });
        
        var infowindow = new kakao.maps.InfoWindow({
            content: positions[i].content
        });
        
        infowindows.push(infowindow);
        markers.push(marker);

        kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(map, infowindow));
    }

    function makeOverListener(map, marker, infowindow) {
        return function() {
            closeAllInfowindows();
            infowindow.open(map, marker);
            clearTimeout(timeoutId);
        };
    }

    function makeOutListener(map, infowindow) {
        return function() {
            timeoutId = setTimeout(function() {
                infowindow.close();
            }, 10000); // 10초 후에 인포윈도우를 닫음
        };
    }

    function closeAllInfowindows() {
        for (var i = 0; i < infowindows.length; i++) {
            infowindows[i].close();
        }
    }
</script>