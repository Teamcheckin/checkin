window.addEventListener("load", function() {
	
	let reviewContainer = document.querySelector(".review-container");
	let like = document.querySelector(".like");
	
	let request = new XMLHttpRequest();
			request.onload = function(e) {
			};
			request.open("GET", "/review/list", true);
			request.send("");
	
	reviewContainer.onclick = function(e) {
		/*let reviewId = e.target.previousElementSibling.value;*/
		
		
		if(!e.target.classList.contains("like"))
			return;
			
			let like = e.target;
			console.log("click");
		if(!like.classList.contains("likeAdded")) {
			let formData = new FormData(like.parentElement);
						console.log(like.parentElement);

						console.log("form 받아옴");

			
			let request = new XMLHttpRequest();
			request.onload = function(e) {
				like.src="/images/thumb-up.png";
				like.classList.add("likeAdded");
			};
			request.open("POST", "/review/like", true);
			request.send(formData);
		} else {
			let formData = new FormData(like.parentElement);
			
			let request = new XMLHttpRequest();
			request.onload = function(e) {
				like.src="/images/like.png";
								
				like.classList.remove("likeAdded");
			};
			request.open("POST", "/review/like/del", true);
			request.send(formData);
		}	
		
	}
	
});