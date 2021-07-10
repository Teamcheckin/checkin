window.addEventListener("load", function(){
	let myHashBtn = document.querySelector(".my-hash-btn");
	let hashBtn = document.querySelector(".hash-btn");
	let myHash = document.querySelector(".my-hash");
	let hash = document.querySelector(".hash");
	const selected = new Set();
	
		
	myHashBtn.addEventListener("click", function(){
		hash.classList.remove("d-none");
		myHash.classList.add("d-none");
		
			
		let selectedId = document.querySelectorAll(".selected");
		for(let j = 0; j < selectedId.length; j++){
			let selectedValue = selectedId[j].nextElementSibling.value;
			selected.add(selectedValue);
		}
	})
	
	hashBtn.addEventListener("click", function(){
		hash.classList.add("d-none");
		myHash.classList.remove("d-none");
		console.log(selected);
		let selectArray = Array.from(selected);
		console.log(selectArray);
		fetch('/api/hashUpdate', {
			method: "POST",
			headers: {
			     'Content-Type': 'application/json'
		    },
			body: JSON.parse({selectArray})
		})
		.then(res => res.text())
		.then(text => {
			console.log(text);
		})
	})
	
	hash.addEventListener("click", (e)=>{
		if(!e.target.classList.contains("hash-edit-list")){
			return;
		}
		
		let hashId = e.target.nextElementSibling.value;
		console.log(hashId);
		if(!e.target.classList.contains("selected")){
			e.target.classList.add("selected");
			selected.add(hashId);
		} else {
			e.target.classList.remove("selected");
			for(let i of selected) {
			  if(i === hashId)  {
			    selected.delete(hashId);
			  }
			}
		}
	})
	
})