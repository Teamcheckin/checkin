
window.addEventListener("load", function() {
	
	let subBtn = document.querySelector("input[value='등록']")
	
	
	/*subBtn.onclick = function(e){
		e.preventDefault();
		console.log("subbtn");
		
	}*/
	
	fetch('/api/hash/error')
	.then(response=>response.text())
	.then(text=>{
				console.log(text);
				
			});
			
	
});


window.addEventListener("load", function() {
	let addBtn = document.querySelector(".addBtn");
	let delBtn = document.querySelector(".delBtn");

	let selected = null;
	
	addBtn.onclick = function(e) {
		e.preventDefault();

		if (selected != e.target && selected != null) {
			selected.classList.remove("selected");
		}

		selected = e.target;
		console.log(selected)
		selected.classList.toggle("selected");

		let sibling = e.target.nextElementSibling.nextElementSibling;
		sibling.classList.toggle("d-none");

	}


	delBtn.onclick = function(e) {
		e.preventDefault();

		if (selected != e.target && selected != null) {
			selected.classList.remove("selected");
		}

		selected = e.target;
		console.log(selected)
		selected.classList.toggle("selected");

	}
	
	
	
	
	
})











