//팝업주소, 팝업창 이름, 팝업창 설정

window.addEventListener("load", function(){
	
	let card = document.querySelector(".card");
	let popupBtn = document.querySelector(".popup-btn");
	let popup = document.querySelector(".popup");
	let btnList = document.querySelector(".btn-list");
	let assignBtn = document.querySelector(".assign-btn");
	let form = document.querySelectorAll("form")[1];
	

	
	
	form.addEventListener("click", (e) =>{
		e.preventDefault();
		
		if(!e.target.classList.contains("popup-btn"))
			return;
			
			console.log(e.target.parentElement.previousElementSibling);
		e.target.parentElement.previousElementSibling.classList.remove("d-none");
			
	})

	form.addEventListener("click",(e) =>{
		
		if(!e.target.classList.contains("assign-btn"))
		return;
		
		let input= e.target.parentElement.querySelectorAll("input[type=hidden]")
		console.log(input);
		let memberId = input[0].value
		let bookstoreId = input[1].value		
		console.log(memberId, bookstoreId)
				
			let url = `/api/assign/${memberId}/${bookstoreId}`
			console.log(url)
			fetch(url)
	        .then(response=>{
	            return response.text(); // false or true
	        })
	        .then(result=>{
				console.log(result)})

		
		
		
	})


		
})
	
	
