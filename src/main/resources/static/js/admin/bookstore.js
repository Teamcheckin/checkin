//팝업주소, 팝업창 이름, 팝업창 설정

window.addEventListener("load", function(){
	
	let card = document.querySelector(".card");
	let popupBtn = document.querySelector(".popup-btn");
	let popup = document.querySelector(".popup");
	let btnList = document.querySelector(".btn-list");
	let assignBtn = document.querySelector(".assign-btn");
	
	
	card.addEventListener("click", (e) =>{
		e.preventDefault();
		
		if(!e.target.classList.contains("popup-btn"))
			return;
			
		popup.classList.remove("d-none");
			
	})

	let input = document.querySelectorAll("input[type=hidden]");
	let bookstoreId = input[0]
	let MemberId = input[1]
	assignBtn.addEventListener("click",(e) =>{
		
		
		
	})


		
})
	
	
