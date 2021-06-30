
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


window.addEventListener("load", function(){
	
	let addBtn = document.querySelector("")
	
	
	
>>>>>>> branch 'main' of https://github.com/Teamcheckin/checkin.git
})