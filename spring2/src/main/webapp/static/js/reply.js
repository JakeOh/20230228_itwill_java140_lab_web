/**
 * reply.js
 * 댓글 등록, 목록 검색, 수정, 삭제
 * /post/detail.jsp에 포함.
 */

document.addEventListener('DOMContentLoaded', () => {
    // 부트스트랩 Collapse 객체를 생성 - 초기 상태는 화면에서 안보이는 상태
    const bsCollapse = new bootstrap.Collapse('div#replyToggleDiv', {toggle: false});
    
    // 댓글 등록/목록 보이기/숨기기 토글 버튼에 이벤트 리스너를 등록
    const btnToggleReply = document.querySelector('button#btnToggleReply');
    btnToggleReply.addEventListener('click', () => {
        bsCollapse.toggle();
        const toggle = btnToggleReply.getAttribute('data-toggle');
        if (toggle === 'toggle-off') {
            btnToggleReply.innerHTML = '숨기기';
            btnToggleReply.setAttribute('data-toggle', 'toggle-on');
        } else {
            btnToggleReply.innerHTML = '보이기';
            btnToggleReply.setAttribute('data-toggle', 'toggle-off');
        }
    });
    
    const btnAddReply = document.querySelector('button#btnAddReply');
    const createReply = (e) => {
        const postId = document.querySelector('input#id').value;
        const replyText = document.querySelector('textarea#replyText').value;
        const writer = document.querySelector('input#writer').value;
        
        if (replyText === '') {
            alert('댓글 내용을 입력하세요.');
            return;
        }
        
        const data = { postId, replyText, writer, };
        
        axios.post('/spring2/api/reply', data) // POST 방식의 Ajax 요청 보냄.
            .then((response) => {
                alert(response.data);
                
                // 댓글 입력 창의 내용을 지움.
                document.querySelector('textarea#replyText').innerHTML = '';
                
                // TODO: 댓글 목록을 새로 고침.
                
            }) // 성공 응답이 왔을 때 실행할 콜백 함수 등록
            .catch((error) => {
                console.log(error);
            }); // 에러 응답이 왔을 때 실행할 콜백 함수 등록
    };
    btnAddReply.addEventListener('click', createReply);
    
});
