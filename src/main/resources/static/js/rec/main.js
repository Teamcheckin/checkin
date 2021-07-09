/**
 * li도 div감싸면 안됨
 *span -> 모양 css에서 블럭타입
 *ul li> div , onClick
 */
 
 
 window.addEventListener("load", function() {

	let subBtn = document.querySelector(".subBtn");
	let recContent = document.querySelector("#recContent")
	
	subBtn.onclick = function(e) {
		e.preventDefault();
		recContent.classList.add("d-none");
		
		let q = document.querySelector("input[name='q']").value;
		let fSelect = document.querySelector("select[name='f']");
		let f = fSelect.options[fSelect.selectedIndex].value;

		console.log(q)
		console.log(f)

		let url = 'http://localhost:8080/api/rec/result/' + f + "/" + encodeURIComponent(q);

		console.log(url)
		
		
		function showResult() {
			const response = fetch(url);
			console.log(url)
			return response
				.then(res =>
					res.json())
				.then(bookstore => {
					let store = bookstore.list;
					return store;
				})
		}

		(async () => {
			try {
				let store = await showResult();

				for (let i = 0; i < store.length; i++) {
					let content = `<section id="bookstore">
					        <div>
					            <div>
					                <img src="/images/bs.jpg">
					            </div>
					            <div class="bsInfo">
					                <span>${store[i].name}</span>
					                <span>#해시태그</span>
					                <span>${store[i].address}</span>
					            </div>
					        </div>
					    </section>`

					let d1 = document.getElementById('search');
					d1.insertAdjacentHTML('afterend', content);

				}

			} catch (error) {
				console.log(error);
			}


		})();



	}
})
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
window.addEventListener("load", function(){ //책방 선택시 디테일 페이지로 이동
		let divs = document.querySelectorAll('.bookstore');
		
		for(const div of divs){
			div.onclick = function(e){
				e.preventDefault();
				
				if(!e.currentTarget.classList.contains("bookstore")){
					return;
				}
				console.log(e.currentTarget);
				
				let bsName = e.currentTarget.querySelector("span").innerText;
				console.log(bsName);
				
				/*let link = `서점디테일페이지?id=${id}`;
				location.href = link;*/
				
			}
			
		}
		
	
});
 
 
/* 
window.addEventListener("load", function(){
		let siled = document.querySelector('.slides');
		let slides = document.querySelectorAll('.sildes li');
		let currentIdx = 0;
		let slideCount = slide.length;
		let preBtn = document.querySelector('.prev');
		let nextBtn = document.querySelector('.next');
		let recTitles = document.querySelectorAll('.recTitle');
		
		let recTitle1 = recTitles[0];
		let recTitle2 = recTitles[1];
		let recTitle3 = recTitles[2];
	
	
	
});
 */
 
 
 window.addEventListener("load", function(){
	
		let section = document.querySelector("form");
		let selectBox = section.querySelector("select[name='h']");
		let inputBox = section.querySelector("input[name='q']");
		let fieldBox = section.querySelector("select[name='f']");
	
	
		
	
		selectBox.onclick = function(e){
			e.preventDefault();
			console.log("ok");
		
			let selectValue = e.target.value; //선택한 옵션값의 value값
			console.log(selectValue);
	
			let selectText = selectBox.querySelector(`option[value='${selectValue}']`).innerText;
			//value값으로 옵션의 innerText 찾기
			console.log(selectText);
			 
			inputBox.setAttribute('value', selectText); //검색창 value에 옵션 text 넣기
			
		}
	
})

