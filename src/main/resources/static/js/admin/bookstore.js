//팝업주소, 팝업창 이름, 팝업창 설정
window.addEventListner("load", function(){
	let card = document.querySelector(".card");
	let popupBtn = document.querySelector(".popup-btn");
	let popup = document.querySelector(".popup");
	let btnList = document.querySelector(".btn-list");
	
	card.addEventListner("click", function(e){
		if(!e.target.classList.contains("popup-btn"))
			return;
			//popupBtn.onclick
			popupBtn.addEventListener("click", function(e){
				e.preventDefault();
				popup.classList.remove("d-none");
			})
	})
	
	
})