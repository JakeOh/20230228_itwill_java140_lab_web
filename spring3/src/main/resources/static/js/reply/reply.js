/**
 * 댓글 영역 보이기/숨기기 토글
 * 댓글 검색, 등록, 수정, 삭제
 */
document.addEventListener('DOMContentLoaded', () => {
    // 부트스트랩 Collapse 객체를 생성. 초기 상태는 화면에 보이지 않는 상태.
    const bsCollapse = new bootstrap.Collapse('div#replyToggleDiv', {toggle: false});
    
    // 토글 버튼을 찾고, 이벤트 리스너를 등록.
    const btnToggleReply = document.querySelector('#btnToggleReply');
    btnToggleReply.addEventListener('click', (e) => {
        bsCollapse.toggle();
        // console.log(e.target.innerText);
        if (e.target.innerText === '보이기') {
            e.target.innerText = '숨기기';
        } else {
            e.target.innerText = '보이기';
        }
    });
    
});
