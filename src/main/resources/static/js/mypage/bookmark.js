window.addEventListener("load", ()=>{
	
	let bookstore = document.querySelector(".bookstore-card")
	let id = document.querySelector("input[type=hidden]").value;
	
	bookstore.addEventListener("click", ()=>{
		location.href=`/bookstore/detail/${id}`;
	})
})