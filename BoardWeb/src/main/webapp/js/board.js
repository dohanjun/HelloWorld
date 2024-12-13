console.log('Starhhhhhhht');

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
			let html = `<li data-rno="${reply.replyNo}">
										<span class="col-sm-2">${reply.replyNo}</span>
										<span class="col-sm-5">${reply.reply}</span>
										<span class="col-sm-2">${reply.replyer}</span>
										<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
									</li>`;
						let target = document.querySelector('div.reply ul.list');
						target.insertAdjacentHTML('afterbegin', html);
						document.querySelector('#reply').value = '';
		}else{
			alert("등록실패")
		}
	})
	.catch(err => console.log(err));
})



//댓글목록을 가져와서 li영역에 데이터를 만들어 주는게 목적
fetch('replyList.do?bno=' + bno)
	.then(result => result.json())
	.then(result => {
		console.log(result);
		for (let reply of result){
			let html = `<li data-rno="${reply.replyNo}">
							<span class="col-sm-2">${reply.replyNo}</span>
							<span class="col-sm-5">${reply.reply}</span>
							<span class="col-sm-2">${reply.replyer}</span>
							<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
						</li>`;
			let target = document.querySelector('div.reply ul.list');
			target.insertAdjacentHTML('afterbegin', html);
		}
	})
	.catch(err => console.log(err));