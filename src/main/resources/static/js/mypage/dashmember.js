window.addEventListener("load", function(){
	let myHashBtn = document.querySelector(".my-hash-btn");
	let hashBtn = document.querySelector(".hash-btn");
	let myHash = document.querySelector(".my-hash");
	let hash = document.querySelector(".hash")

	let selected;
		
	myHashBtn.addEventListener("click", function(){

		hash.classList.remove("d-none");
		myHash.classList.add("d-none");
	})
	
	hashBtn.addEventListener("click", function(){

		hash.classList.add("d-none");
		myHash.classList.remove("d-none");
	})
	
	hash.addEventListener("click", function(e){
		if(!e.target.classList.contains("hash-edit-list")){
			return;
		}
			
		e.target.classList.toggle("selected");
	})
	
	hashBtn.addEventListener("click", function(){
		let url = 'http://localhost:8080/mypage/dashboard/update'
		fetch(url, {
			method: "POST",
			body: JSON.stringify({
				hashId: selected,
			})
		})
		.then(response=>{
			console.log("post 완료")
		})
	})
})