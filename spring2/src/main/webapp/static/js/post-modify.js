/**
 * post-modify.js
 * /post/modify.jsp 에서 사용.
 */

document.addEventListener('DOMContentLoaded', () => {
    
    const modifyForm = document.querySelector('#modifyForm');
    
    // 삭제 버튼을 찾아서 이벤트 리스너를 등록.
    const btnDelete = document.querySelector('#btnDelete');
    btnDelete.addEventListener('click', () => {
        const check = confirm('정말 삭제할까요?');
        if (check) {
            modifyForm.action = './delete'; // 'delete' // 폼 요청 주소
            modifyForm.method = 'post'; // 폼 요청 방식
            modifyForm.submit(); // 폼 제출 -> 요청을 서버로 보냄.
        }
    });
    
    // 업데이트 버튼을 찾아서 이벤트 리스너를 등록.
    const btnUpdate = document.querySelector('#btnUpdate');
    btnUpdate.addEventListener('click', () => {
        // 제목과 내용이 입력되어 있는 지 체크.
        const title = document.querySelector('input#title').value; // input에 입력된 값.
        const content = document.querySelector('textarea#content').value; // textarea에 입력된 값.
        if (title === '' || content === '') {
            alert('제목과 내용은 반드시 입력하세요.');
            return; // 함수 종료
        }
        
        const check = confirm('변경 내용을 저장할까요?');
        if (check) {
            modifyForm.action = './update'; // 폼 요청 주소
            modifyForm.method = 'post'; // 폼 요청 방식
            modifyForm.submit();
        }
        
    });
    
});
