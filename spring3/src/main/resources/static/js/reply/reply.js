/**
 * 댓글 영역 보이기/숨기기 토글
 * 댓글 검색, 등록, 수정, 삭제
 */
document.addEventListener('DOMContentLoaded', () => {
    // 로그인한 사용자 이름 -> 댓글 등록, 수정, 삭제할 때 사용하기 위해서.
    const authName = document.querySelector('div#authName').innerText;
    
    // 부트스트랩 Collapse 객체를 생성. 초기 상태는 화면에 보이지 않는 상태.
    const bsCollapse = new bootstrap.Collapse('div#replyToggleDiv', {toggle: false});
    
    // 토글 버튼을 찾고, 이벤트 리스너를 등록.
    const btnToggleReply = document.querySelector('#btnToggleReply');
    btnToggleReply.addEventListener('click', (e) => {
        bsCollapse.toggle();
        // console.log(e.target.innerText);
        if (e.target.innerText === '보이기') {
            e.target.innerText = '숨기기';
            
            // 댓글 목록 불러오기:
            getRepliesWithPostId();
        } else {
            e.target.innerText = '보이기';
        }
    });
    
    // 댓글 삭제 버튼들의 클릭을 처리하는 이벤트 리스너 콜백:
    const deleteReply = (e) => {
        // console.log(e.target);
        
        const result = confirm('정말 삭제할까요?');
        if (!result) {
            return;
        }
        
        // 삭제할 댓글 아이디
        const id = e.target.getAttribute('data-id');
        
        // Ajax DELETE 방식 요청 주소
        const reqUrl = `/api/reply/${id}`;
        
        axios
            .delete(reqUrl) // Ajax DELETE 요청을 보냄
            .then((response) => {
                console.log(response);
                
                // 댓글 목록 새로 고침
                getRepliesWithPostId();
                
            }) // 성공 응답일 때 실행할 콜백 등록
            .catch((error) => console.log(error)); // 실패 응답일 때 실행할 콜백 등록
        
    };
    
    // 댓글 업데이트 버튼들의 클릭을 처리하는 이벤트 리스너 콜백:
    const updateReply = (e) => {
        //console.log(e.target);
        const replyId = e.target.getAttribute('data-id'); // 수정할 댓글 아이디
        
        const textAreaId = `textarea#replyText_${replyId}`; // 댓글 입력 textarea 아이디
        //console.log(document.querySelector(textAreaId));
        
        // 수정할 댓글 내용
        const replyText = document.querySelector(textAreaId).value;
        if (replyText === '') { // 댓글 내용이 비어있으면
            alert('수정할 댓글 내용을 입력하세요.');
            return;
        }
        
        const reqUrl = `/api/reply/${replyId}`; // 요청 주소
        const data = { replyText }; // {replyText: replyText}, 요청 데이터(수정할 댓글 내용)
        axios
            .put(reqUrl, data) // PUT 방식의 Ajax 요청을 보냄.
            .then((response) => {
                console.log(response);
                getRepliesWithPostId(); // 댓글 목록 새로고침.
            }) // 성공 응답일 때 동작할 콜백을 등록.
            .catch((error) => console.log(error)); // 에러 응답일 때 동작할 콜백을 등록.
        
    };
    
    const makeReplyElements = (data) => {
        // 댓글 개수를 배열(data)의 원소 개수로 업데이트.
        document.querySelector('span#replyCount').innerText = data.length;
        
        // 댓글 목록을 삽입할 div 요소를 찾음.
        const replies = document.querySelector('div#replies');
        
        // div 안에 작성된 기존 내용은 삭제.
        replies.innerHTML = '';
        
        // div 안에 삽입할 HTML 코드 초기화.
        let htmlStr = '';
        for (let reply of data) {
            htmlStr += `
            <div class="card my-2">
                <div>
                    <span class="d-none">${reply.id}</span>
                    <span class="fw-bold">${reply.writer}</span>
                </div>
           `;
            
            // 로그인한 사용자와 댓글 작성자가 같을 때만 삭제, 수정 버튼을 보여줌.
            if (authName === reply.writer) {
                htmlStr += `
                <textarea id="replyText_${reply.id}">${reply.replyText}</textarea>
                <div>
                    <button class="btnDelete btn btn-outline-danger" data-id="${reply.id}">삭제</button>
                    <button class="btnModify btn btn-outline-primary" data-id="${reply.id}">수정</button>
                </div>
                `;
            } else {
                htmlStr += `
                <textarea id="replyText_${reply.id}" readonly>${reply.replyText}</textarea>
                `;
            }
            
            htmlStr += '</div>';

        }
        
        // 작성된 HTML 문자열을 div 요소의 innerHTML로 설정.
        replies.innerHTML = htmlStr;
        
        // 모든 댓글 삭제 버튼들에게 이벤트 리스너를 등록.
        const btnDeletes = document.querySelectorAll('button.btnDelete');
        for (let btn of btnDeletes) {
            btn.addEventListener('click', deleteReply);
        }
        
        // 모든 댓글 수정 버튼들에게 이벤트 리스너를 등록.
        const btnModifies = document.querySelectorAll('button.btnModify');
        for (let btn of btnModifies) {
            btn.addEventListener('click', updateReply);
        }
        
    };
    
    // 포스트 번호에 달려 있는 댓글 목록을 (Ajax 요청으로) 가져오는 함수:
    const getRepliesWithPostId = async () => {
        const postId = document.querySelector('input#id').value; // 포스트 아이디(번호)
        const reqUrl = `/api/reply/all/${postId}`; // Ajax 요청 주소
        
        // Ajax 요청을 보내고 응답을 기다림.
        try {
            const response = await axios.get(reqUrl);
            //console.log(response);
            makeReplyElements(response.data);
            
        } catch (error) {
            console.log(error);
        }
    };
    
    // 댓글 등록 버튼을 찾고, 이벤트 리스너 등록.
    const btnReplyCreate = document.querySelector('button#btnReplyCreate');
    btnReplyCreate.addEventListener('click', () => {
        // 포스트 아이디 찾음.
        const postId = document.querySelector('input#id').value;
        // 댓글 내용 찾음.
        const replyText = document.querySelector('textarea#replyText').value;
        // 댓글 작성자는 로그인한 사용자 아이디로 설정.
        const writer = authName;
        
        // 댓글 내용이 비어 있으면 경고창을 보여주고 종료.
        if (replyText === '') {
            alert('댓글 내용을 입력하세요.');
            return;
        }
        
        // Ajax 요청에서 보낼 데이터.
        const data = {postId, replyText, writer};
        // Ajax 요청을 보낼 URL.
        const reqUrl = '/api/reply';
        
        axios
            .post(reqUrl, data) // Ajax POST 방식 요청을 보냄.
            .then((response) => {
                console.log(response);
                
                // 댓글 목록 새로고침
                getRepliesWithPostId();
                // 댓글 입력한 내용을 지움.
                document.querySelector('textarea#replyText').value = '';
                
            }) // 성공 응답(response)일 때 실행할 콜백 등록.
            .catch((error) => console.log(error)); // 실패(error)일 때 실행할 콜백 등록. 
        
    });
    
});
