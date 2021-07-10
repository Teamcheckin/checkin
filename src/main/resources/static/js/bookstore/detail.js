window.addEventListener("load", function() {
	var title = document.querySelector(".name").innerHTML;
	var latitude = document.querySelectorAll(".info>input")[0].value;
	var longitude = document.querySelectorAll(".info>input")[1].value;
	var information = document.querySelectorAll(".tap-menu>span")[0];
	var review = document.querySelectorAll(".tap-menu>span")[1];
	
	console.log(latitude);
	console.log(longitude);
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(latitude, longitude), // 지도의 중심좌표
	        level: 5 // 지도의 확대 레벨 
	    }; 

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 마커가 표시될 위치입니다 
	var markerPosition  = new kakao.maps.LatLng(latitude, longitude); 
	
	// 마커 이미지의 이미지 주소입니다
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
	
	 // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    markerImage
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: markerPosition, // 마커를 표시할 위치
        image : markerImage, // 마커 이미지 
        clickable: true
    });
    
   	var url = "https://map.kakao.com/link/map/" + title + ',' + latitude + ',' + longitude; 
    
    // 마커에 클릭이벤트를 등록합니다
	kakao.maps.event.addListener(marker, 'click', function() {
	      // 마커 위에 인포윈도우를 표시합니다
	      window.open(`${url}`);
	});

	// 마커 위에 커스텀오버레이를 표시합니다
	// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
	var overlay = new kakao.maps.CustomOverlay({
	    content: content,
	    map: map,
	    position: marker.getPosition()       
	});
	
	
	
});