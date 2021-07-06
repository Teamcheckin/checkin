//팝업주소, 팝업창 이름, 팝업창 설정

window.addEventListener("load", function(){
	console.log("text");
	let card = document.querySelector(".card");
	let popupBtn = document.querySelector(".popup-btn");
	let popup = document.querySelector(".popup");
	let btnList = document.querySelector(".btn-list");
	
	
	card.addEventListener("click", function(e){
		e.preventDefault();
		
		console.log("11");
		if(!e.target.classList.contains("popup-btn"))
			return;
			
		popup.classList.remove("d-none");
		
		// 클로즈 버튼 클릭하면 d-none 추가하기
		

				
			})
	})
	
	
