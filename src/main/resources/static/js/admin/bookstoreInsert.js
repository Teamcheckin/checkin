window.addEventListener("load", function(){
	
	let fileBtn = document.querySelectorAll(".fake-btn");
    let realBtn = document.querySelectorAll(".real-btn");
    let logoImg = document.querySelector(".logo-img");
    let bgImg = document.querySelector(".bg-img");
	let profileSection = document.querySelector(".profile-section");
	let addressBtn = document.querySelector(".address-btn");
	
	let submitBtn = document.querySelector(".submit-btn");
	
	realBtn[0].oninput = function(e) { // 파일 등록버튼 선택
		let bgFile = realBtn[0].files[0];
		if(bgFile.type.indexOf("image/") < 0)
			alert("이미지 형식만 사용할 수 있습니다");
	
		// 선택된 파일을 메모리에 올릴 수 있음, 로컬에 파일 로드 가능
		// 웹(원격)이라는 브라우저는 로컬의 문서에 접근하지 못함
		var reader = new FileReader(); // 파일 읽어오기 가능, Reader 하나당 파일 하나 읽기 가능
		reader.onload = function(evt) { // 아직 원격에 올라간 거 아닌데도 웹에서 이미지 보기 가능
			bgImg.src = evt.target.result; 
		}
	
		reader.readAsDataURL(bgFile); // 비동기로 읽어옴, 위 코드가 바로 진행되지 않게 onload 이벤트에 넣어주기	
	}
	
	realBtn[1].oninput = function(e) { // 파일 등록버튼 선택
		let logoFile = realBtn[1].files[0]; // 파일에 대한 정보만 가져온 상태
		if(logoFile.type.indexOf("image/") < 0)
			alert("이미지 형식만 사용할 수 있습니다");
		
	
		// 선택된 파일을 메모리에 올릴 수 있음, 로컬에 파일 로드 가능
		// 웹(원격)이라는 브라우저는 로컬의 문서에 접근하지 못함
		var reader = new FileReader(); // 파일 읽어오기 가능, Reader 하나당 파일 하나 읽기 가능
		reader.onload = function(evt) { // 아직 원격에 올라간 거 아닌데도 웹에서 이미지 보기 가능
			logoImg.src = evt.target.result;
		}
		
		reader.readAsDataURL(logoFile); // 비동기로 읽어옴, 위 코드가 바로 진행되지 않게 onload 이벤트에 넣어주기	
	}

	// 버튼 클릭해서 업로드
	fileBtn[0].onclick = function() {
        var event = new MouseEvent("click", {
            'view': window,
            'bubbles': true, // 이벤트 버블링: true
            'cancelable': true
        });
    	realBtn[0].dispatchEvent(event);     
    }
    
	fileBtn[1].onclick = function() {
        var event = new MouseEvent("click", {
            'view': window,
            'bubbles': true, // 이벤트 버블링: true
            'cancelable': true
	    });
        realBtn[1].dispatchEvent(event);   
	}


	addressBtn.addEventListener("click", ()=>{
		
	})
	
	let errorMessage = document.querySelectorAll(".error-message");
	let input = document.querySelectorAll(".input");
	
	let nameCheck = false; let guCheck = false; let timeCheck = false; let instaCheck = false; let hashCheck = false;
	

		let nameError = errorMessage[0];
		let nameInput = input[0];

		nameInput.addEventListener("change", ()=>{
			if(nameInput.value == ''){
				nameCheck = false;
				nameError.classList.add("animation");
				nameInput.focus(); // 화면커서이동
				nameInput.style.border = "2px solid red";
			} else {
				nameCheck = true;
				nameError.classList.remove("animation");
				nameInput.style.border = "1px solid black";
			}
		})
		
		let guError = errorMessage[2];
		let selectOption = document.querySelector("select[name=guName]");
		let option = selectOption.options[selectOption.selectedIndex].text;
		selectOption.addEventListener("change", ()=>{

				console.log(option);
			if(option == '선택'){
				guCheck = false;
				guError.classList.add("animation");
				selectOption.style.border = "2px solid red";
			} else {
				guCheck = true;
				guError.classList.remove("ß");
				selectOption.style.border = "1px solid black";
			}
		})
		
		let timeError = errorMessage[3];
		let timeInput = input[2];
		let timePattern = '';
		timeInput.addEventListener("change", ()=>{
			if(timeInput.value.match(timePattern) == null){
				timeCheck = false;
				timeError.classList.add("animation");
				timeInput.style.border = "2px solid red";
			} else {
				timeCheck = true;
				timeError.classList.remove("animation");
				timeInput.style.border = "1px solid black";
			}
		})
		
		let instaError = errorMessage[4];
		let instaInput = input[3];
		let instaPattern = '/(http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/';

		instaInput.addEventListener("change", ()=>{
			console.log(nameCheck, guCheck, timeCheck, instaCheck, hashCheck);
			if(instaInput.value.match(instaPattern) == null){
				instaCheck = false;
				instaError.classList.add("animation");
				instaInput.style.border = "2px solid red";
			} else {
				instaCheck = true;
				instaError.classList.remove("animation");
				instaInput.style.border = "1px solid black";
			}
		})
		
		let rerror = document.querySelector(".rerror-message");
		submitBtn.addEventListener("click", (e)=>{
			if(nameCheck && guCheck && timeCheck && instaCheck && hashCheck){
				return true;	
			} else{
				e.preventDefault();
				rerror.classList.remove("d-none");
				
				window.scrollTo({
					top: 80, 
					behavior:'smooth'
				});
			}
		})
	})