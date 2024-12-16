console.log('Starhhhhhhht');





// 댓글정보 -> row 생성.

function makeRow(reply = {}){
	let html = `<li data-rno="${reply.replyNo}">
						<span class="col-sm-2">${reply.replyNo}</span>
						<span class="col-sm-5">${reply.reply}</span>
						<span class="col-sm-2">${reply.replyer}</span>
						<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
				</li>`;
	let target = document.querySelector('div.reply ul.list');
	target.insertAdjacentHTML('beforeend', html); // target 태그의 끝나는 부분 앞에 붙음
}





// 댓글 =>삭제 =>retCode(OK.Fail)
function deleteReply(rno =1){
	fetch('removeReply.do?rno=' + rno)
	.then(result => result.json())
	.then(result => {
		
	if(result.retCode == 'OK'){
		alert("삭제됨")
	document.querySelector('li[data-rno="' + rno + '"]').remove();
	}else{
		alert("삭제안됨")
	}
	})
	.catch(err => console.log(err))

}

// 댓글목록 5건씩 출력.
function showReplyList(){

		fetch('replyList.do?bno=' + bno + '&page=' + page)
			.then(result => result.json())
			.then(result => {
				document.querySelector('ul.list').innerHTML = '';
				for (let reply of result){
					makeRow(reply); // 댓글정보 -> <li> 태그 생성
				}
				// 페이징 생성
				createPageList();
			})
			.catch(err => console.log(err));
}
// 페이지 정보 지정.
let page = 1;
// 글번호 -> 전체 건수를 활용해서 페이지 갯수 계산하는 함수.

function createPageList(){
	fetch('getCount.do?bno=' + bno)
	.then(result => result.json())
	.then(result => {
		let totalCnt = result.replyCount;
		// 이전, 이후 페이지 여부 , 첫번째 ~ 마지막페이지
		let prev, next;
		let startPage, endPage, realEnd;
		endPage = Math.ceil(page / 10) * 10; // 현재페이지 기준으로 마지막페이지 계산
		startPage = endPage  - 9; // 마지막페이지 - 9 => 첫째페이지.
		
		if(startPage > 1) {
			prev = true;
		}
		realEnd = Math.ceil(totalCnt / 5);
		if(endPage > realEnd) { // 현재 13페이지
			endPage = realEnd;
		}
		if(endPage < realEnd){ // 이후 목록이 존재하는지 확인
			next = true;
		}
		let pagination = document.querySelector('ul.pagination')
		pagination.innerHTML = '';
		if (prev){
			let html = `<li class="page-item"data-page="${startPage-1}">
			    			<a class="page-link" href="#" aria-label="Previous">
			      				<span aria-hidden="true">&laquo;</span>
			    			</a>
			  			</li>`
						
				pagination.insertAdjacentHTML('beforeend', html)
		}
		
		
		for(let p = startPage; p <= endPage; p++){
			console.log(page);
			if(page == p){
			let html = `<li class="page-item" data=page="${p}">
						<a class="page-link active" href="#">${p}</a></li>`
				pagination.insertAdjacentHTML('beforeend', html);				
			}else{
				let html = `<li class="page-item" data=page="${p}">
										<a class="page-link" href="#">${p}</a></li>`
								pagination.insertAdjacentHTML('beforeend', html);	
			}
			
		}
		if(next){
			let html = 	`<li class="page-item"data-page="${endPage+1}">
			      			<a class="page-link" href="#" aria-label="Next">
			        			<span aria-hidden="true">&raquo;</span>
			      			</a>
			    		 </li>`
				pagination.insertAdjacentHTML('beforeend', html);
			
		}
	//active" aria-current="page"
		// 페이징 a 태그의 클릭.
		document.querySelectorAll('ul.pagination a').forEach(item =>{
			item.addEventListener('click', function(e){ 
				e.preventDefault(); // 기본기능 차단
				//목록 출현
				page = item.parentElement.getAttribute('data-page');
				
				showReplyList()
			})
			
		})

		
	})
	.catch(err => console.log(err));
}// end of createOageList()





//댓글등록 이벤트
document.querySelector('#addBtn').addEventListener('click', function(e){
	// 로그인 정보, 원본글 정보, 댓글내용.
	let reply = document.querySelector('#reply').value;
	
	if(!logId || !reply){
		alert("필수값입력")
		return;
	}
	fetch('addReply.do?bno='+bno+'&replyer='+reply+'&reply='+logId)
	.then(result => result.json())
	.then(result => {
		console.log(result);
		let reply = result.retVal;
		if(result.retCode == 'OK'){
			alert("등록성공")
			makeRow(reply);
						document.querySelector('#reply').value = '';
		}else{
			alert("등록실패")
		}
	})
	.catch(err => console.log(err));
})

// 페이징 A태그의 출력



//댓글목록을 가져와서 li영역에 데이터를 만들어 주는게 목적
showReplyList();