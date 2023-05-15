/**
 * post-modify.js
 * /post/modify.jsp에서 사용됨.
 */

document.addEventListener('DOMContentLoaded', function () {
    // form 요소를 찾음.
    const form = document.querySelector('#postModifyForm');
    
    // input#id 요소를 찾음.
    const inputId = document.querySelector('input#id');
    
    // input#title 요소를 찾음.
    const inputTitle = document.querySelector('input#title');
    
    // textarea#content 요소를 찾음.
    const textareaContent = document.querySelector('textarea#content');
    
    // 수정완료/삭제 버튼을 찾음.
    const btnUpdate = document.querySelector('button#btnUpdate');
    const btnDelete = document.querySelector('button#btnDelete');
    
    // 삭제 버튼에 클릭 이벤트 리스너(핸들러)를 등록.
    btnDelete.addEventListener('click', (e) => {
        e.preventDefault();
        //-> form 안에 있는 버튼 또는 input[type=submit]의 기본 (클릭) 동작은
        // 폼의 내용을 서버로 제출(서버로 요청을 보냄). 
        // 버튼의 기본 동작이 기능하지 않도록 함.
        
        const id = inputId.value;
        const result = confirm(`NO. ${id} 정말 삭제할까요?`);
        // 확인 -> true, 취소 -> false 리턴.
        console.log(`삭제 확인 결과 = ${result}`); // 브라우저 개발자 도구 콘솔 창 로그.
        
        // 사용자가 confirm 창에서 '확인'을 클릭했을 때
        if (result) {
            form.action = 'delete'; // 폼 제출(요청) 주소
            form.method = 'post'; // 요청 방식
            form.submit(); // 폼 제출(요청 보내기)
        }
    });
    
    btnUpdate.addEventListener('click', (e) => {
        e.preventDefault(); // 기본 동작인 폼 제출 기능을 막음.
        
        const id = inputId.value; // 포스트 번호
        const title = inputTitle.value; // 포스트 제목
        const content = textareaContent.value; // 포스트 내용
        
        if (title === '' || content === '') {
            // 제목 또는 내용이 비어 있으면
            alert('제목과 내용은 반드시 입력해야 합니다.');
            return; // 함수 종료
        }
        
        const result = confirm(`NO.${id} 포스트를 업데이트할까요?`);
        if (result) {
            form.action = 'update'; // 업데이트 요청 주소
            form.method = 'post'; // 요청 방식
            form.submit(); // 폼 제출(요청 보내기)
        }
    });
    
});
