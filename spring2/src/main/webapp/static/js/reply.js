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
        // axios 라이브러리를 사용해서 Ajax 요청을 보냄.
    };
    btnAddReply.addEventListener('click', createReply);
    
});
