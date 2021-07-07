
function showResult(){
	
	fetch('/api/hash/list')
			.then(response=>response.json())
			.then(json=>{
				console.log(json);
	});
	
	
	
	
	let response = await fetch(url);
	
	if (response.ok) { // HTTP 상태 코드가 200~299일 경우
  	// 응답 몬문을 받습니다(관련 메서드는 아래에서 설명).
  		let json = await response.json();
	} else {
  		alert("HTTP-Error: " + response.status);
	}	
	
	
	
	
	
	
	
	
	
	
}

